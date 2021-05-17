import java.util.HashMap;
import java.util.HashSet;

public class AStarPathfinder
{

    public static final float COST_LIMIT = 1e6f;

    public static Waypoint computePath(Map2D map)
    {
        AStarState state = new AStarState(map);
        Location finishLoc = map.getFinish();

        Waypoint start = new Waypoint(map.getStart(), null);
        start.setCosts(0, estimateTravelCost(start.getLocation(), finishLoc));
        state.addOpenWaypoint(start);

        Waypoint finalWaypoint = null;
        boolean foundPath = false;
        
        while (!foundPath && state.numOpenWaypoints() > 0)
        {
            // Find the "best" (i.e. lowest-cost) waypoint so far.
            Waypoint best = state.getMinOpenWaypoint();
            
            // If the best location is the finish location then we're done!
            if (best.getLocation().equals(finishLoc))
            {
                finalWaypoint = best;
                foundPath = true;
            }
            
            // Add/update all neighbors of the current best location.  This is
            // equivalent to trying all "next steps" from this location.
            takeNextStep(best, state);
            
            // Finally, move this location from the "open" list to the "closed"
            // list.
            state.closeWaypoint(best.getLocation());
        }
        
        return finalWaypoint;
    }

    private static void takeNextStep(Waypoint currWP, AStarState state)
    {
        Location loc = currWP.getLocation();
        Map2D map = state.getMap();
        
        for (int y = loc.yCoord - 1; y <= loc.yCoord + 1; y++)
        {
            for (int x = loc.xCoord - 1; x <= loc.xCoord + 1; x++)
            {
                Location nextLoc = new Location(x, y);

                if (!map.contains(nextLoc))
                    continue;

                if (nextLoc == loc)
                    continue;

                if (state.isLocationClosed(nextLoc))
                    continue;

                
                Waypoint nextWP = new Waypoint(nextLoc, currWP);

                float prevCost = currWP.getPreviousCost() +
                    estimateTravelCost(currWP.getLocation(),
                                       nextWP.getLocation());

                prevCost += map.getCellValue(nextLoc);

                if (prevCost >= COST_LIMIT)
                    continue;
                
                nextWP.setCosts(prevCost,
                    estimateTravelCost(nextLoc, map.getFinish()));

                state.addOpenWaypoint(nextWP);
            }
        }
    }
    private static float estimateTravelCost(Location currLoc, Location destLoc)
    {
        int dx = destLoc.xCoord - currLoc.xCoord;
        int dy = destLoc.yCoord - currLoc.yCoord;
        
        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}