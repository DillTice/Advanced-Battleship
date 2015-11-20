
/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space
{
    // instance variables - replace the example below with your own
    private String marker;
    private int team;

    /**
     * Constructor for objects of class Space
     */
    public Space(String inMarker, int inTeam)
    {
        // initialise instance variables
        marker = inMarker;
        team = inTeam;
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void killSpace()
    {
        // put your code here
        marker = "X";
        
    }
    
    public String getSpace()
    {
        return marker;
    }
    
    public String print()
    {
        return marker;
    }
    
    public void change(String inMarker)
    {
        marker = inMarker;
    }
}
