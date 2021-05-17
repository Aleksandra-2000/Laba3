import java.util.HashMap;

public class AStarState
{
    private Map2D map;
    private HashMap<Location,Waypoint> opened_waypoints = new HashMap<Location,Waypoint>(); //создаем приватный обьект - хэш карту
    private HashMap<Location,Waypoint> closed_waypoints = new HashMap<Location,Waypoint>(); //

    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");
        this.map = map;
    }

    public Map2D getMap()
    {
        return map;
    }

    public Waypoint getMinOpenWaypoint()
    {
        float min = -1;
        Waypoint waypoint = null; //
        for (Waypoint w :opened_waypoints.values()) { //
            if( min > w.getTotalCost() || min == -1) { //
                min = w.getTotalCost(); //
                waypoint = w;
            }
        }
        return waypoint;
    }

    public boolean addOpenWaypoint(Waypoint newWP)
    {
        if(opened_waypoints.containsKey(newWP.loc)){ //
            if(opened_waypoints.get(newWP.loc).getPreviousCost() > newWP.getPreviousCost()){ //
                opened_waypoints.put(newWP.loc,newWP); //
                return true;
            }

        }
        else {
            opened_waypoints.put(newWP.loc,newWP);
            return true;
        }
        return false;
    }


    public int numOpenWaypoints()
    {
        return opened_waypoints.values().size();
    } //


    public void closeWaypoint(Location loc)
    {
        closed_waypoints.put(loc,opened_waypoints.get(loc)); //
        opened_waypoints.remove(loc); //
    }


    public boolean isLocationClosed(Location loc)
    {
        return closed_waypoints.containsKey(loc);
    } //
}
