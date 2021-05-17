import java.util.Objects;

public class Location
{

    public int xCoord;
    public int yCoord;
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    public Location()
    {
        this(0, 0);
    }
    public boolean equals(Object o){ //
        if(this == o) return true; //
        if(o == null) return false; //
        Location location = (Location) o; //
        return this.xCoord == location.xCoord && this.yCoord == location.yCoord;
    }
    public int hashCode(){
        return Objects.hash(xCoord, yCoord);
    }

}