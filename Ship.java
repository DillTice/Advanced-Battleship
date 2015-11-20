
/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship
{
    // instance variables - replace the example below with your own
    private boolean placed;
    private int length;
    private String marker;
    private String name;
    private int health;
    private boolean sunk;

    /**
     * Constructor for objects of class Ship
     */
    public Ship(int inLength, String inMarker, String inName)
    {
        // initialise instance variables
        length = inLength;
        name = inName;
        marker = inMarker;
        health = length;
        placed = false;
        sunk = false;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean placed()
    {
        // put your code here
        return placed;
    }

    public void place()
    {
        placed = true;
    }

    public int getLength()
    {
        return length;
    }

    public String getMarker()
    {
        return marker;
    }

    public String getName()
    {
        return name;
    }

    public void hurt()
    {
        health--;
        if(health == 0)
        {
            sunk = true;
            System.out.println("You sunk my " + name + "!");
            System.out.println();
            pressAnyKeyToContinue();
        }
    }
    
    private void pressAnyKeyToContinue()
    { 
        System.out.println("Press any key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
    }

    public boolean sunk()
    {
        return sunk;
    }
}
