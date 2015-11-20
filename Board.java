import java.util.Scanner;
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board
{
    // instance variables - replace the example below with your own
    private Space[][] sea;
    private boolean pass = false;
    private boolean game = false;
    private Ship carrier;
    private Ship battleship;
    private Ship destroyer;
    private Ship sub;
    private Ship patrol;
    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        sea = new Space[10][10];
        for(int i = 0; i <= 9; i++)
        {
            for(int j = 0; j <= 9; j++)
            {
                sea[i][j] = new Space("~", 0);
            }
        }
        carrier = new Ship(5, "C", "Carrier");
        battleship = new Ship(4, "B", "Battleship");
        destroyer = new Ship(3, "D", "Destroyer");
        sub = new Ship(3, "S", "Submarine");
        patrol = new Ship(2, "P", "Patrol Boat");
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void print()
    {
        System.out.println("   0   1   2   3   4   5   6   7   8   9  ");
        System.out.println(" -----------------------------------------");
        for(int i = 0; i <= 9; i++)
        {
            System.out.print(i);
            for(int j = 0; j <= 8; j++)
            {
                System.out.print("| " + sea[i][j].print() + " ");
            }
            System.out.println("| " + sea[i][9].print() + " |");
            System.out.println(" -----------------------------------------");
        }
    }

    public void reset()
    {
        for(int i = 0; i <= 9; i++)
        {
            for(int j = 0; j <= 9; j++)
            {
                sea[i][j] = new Space("~", 0);
            }
        }
    }

    public void move(int inChoice)
    {
        int choice = inChoice;
        Ship ship;
        switch(choice)
        {
            case 1:
                ship = carrier;
                break;
            case 2:
                ship = battleship;
                break;
            case 3:
                ship = destroyer;
                break;
            case 4:
                ship = sub;
                break;
            case 5:
                ship = patrol;
                break;
            default:
                ship = null;
        }
        int length = ship.getLength();
        String marker = ship.getMarker();
        String name = ship.getName();
        boolean validSelection = false;
        while(validSelection == false)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Ship selected: " + name);
            System.out.println("What is the Y-Coordinate? >");
            int x = in.nextInt();
            System.out.println("What is the X-Coordinate? >");
            int y = in.nextInt();
            System.out.println("What is the direction? (1. Up, 2. Down, 3. Left, 4. Right) >");
            int dir = in.nextInt();
            boolean check = check(x, y, dir, length);
            if(check == true)
            {
                placeShip(marker, dir, length, x, y);
                ship.place();
                validSelection = true;
            }
            if(check == false)
            {
                System.out.println();
                System.out.println("Out of bounds!");
                System.out.println();
            }
        }
    }

    public boolean check(int inX, int inY, int inDir, int inLength)
    {
        int x = inX;
        int y = inY;
        int dir = inDir;
        int length = inLength;
        switch(dir)
        {
            case 1:
            for(int i = 0; i <= length; i++)
            {
                if((x >= 0 && x <= 9) && (y >= 0 && y <= 9))
                {
                    if(sea[x][y].getSpace() == "~")
                    {
                        pass = true;
                    }
                    else
                    {
                        pass = false;
                    }
                }
                else
                {
                    pass = false;
                    break;
                }
                x--;
            }
            break;
            case 2:
            for(int i = 0; i <= length; i++)
            {
                if((x >= 0 && x <= 9) && (y >= 0 && y <= 9))
                {
                    if(sea[x][y].getSpace() == "~")
                    {
                        pass = true;
                    }
                    else
                    {
                        pass = false;
                    }
                }
                else
                {
                    pass = false;
                }
                x++;
            }
            break;
            case 3:
            for(int i = 0; i <= length; i++)
            {
                if((x >= 0 && x <= 9) && (y >= 0 && y <= 9))
                {
                    if(sea[x][y].getSpace() == "~")
                    {
                        pass = true;
                    }
                    else
                    {
                        pass = false;
                    }
                }
                else
                {
                    pass = false;
                }
                y--;
            }
            break;
            case 4:
            for(int i = 0; i <= length; i++)
            {
                if((x >= 0 && x <= 9) && (y >= 0 && y <= 9))
                {
                    if(sea[x][y].getSpace() == "~")
                    {
                        pass = true;
                    }
                    else
                    {
                        pass = false;
                    }
                }
                else
                {
                    pass = false;
                }
                y++;
            }
            break;
            default: 
            System.out.println("That's not an option.");
            pass = false;
        }
        return pass;
    }

    public void placeShip(String inMarker, int inDir, int inLength, int inX, int inY)
    {
        int x = inX;
        int y = inY;
        int length = inLength;
        String marker = inMarker;
        int dir = inDir;
        switch(dir)
        {
            case 1:
            if(pass == true)
            {
                x = inX;
                y = inY;
                for(int j = 0; j <= length-1; j++)
                {
                    sea[x][y].change(marker);
                    x--;
                }
            }
            break;
            case 2:
            if(pass == true)
            {
                x = inX;
                y = inY;
                for(int j = 0; j <= length-1; j++)
                {
                    sea[x][y].change(marker);
                    x++;
                }
            }
            break;
            case 3:
            if(pass == true)
            {
                x = inX;
                y = inY;                
                for(int j = 0; j <= length-1; j++)
                {
                    sea[x][y].change(marker);
                    y--;
                }
            }
            break;
            case 4:
            if(pass == true)
            {
                x = inX;
                y = inY;
                for(int j = 0; j <= length-1; j++)
                {
                    sea[x][y].change(marker);
                    y++;
                }
            }
            break;
        }
    }

    public String getType(int x, int y)
    {
        return sea[x][y].getSpace();
    }

    public void hit(String inType, int inX, int inY)
    {
        String type = inType;
        int x = inX;
        int y = inY;
        sea[x][y].killSpace();
        switch(type)
        {
            case "C":
            carrier.hurt();
            break;
            case "B":
            battleship.hurt();
            break;
            case "D":
            destroyer.hurt();
            break;
            case "S": 
            sub.hurt();
            break;
            case "P":
            patrol.hurt();
            break;
        }
    }
    
    public boolean placed(int inShip)
    {
        int ship = inShip;
        boolean placed = false;
        switch(ship)
        {
            case 1:
                placed = carrier.placed();
                break;
            case 2:
                placed = battleship.placed();
                break;
            case 3:
                placed = destroyer.placed();
                break;
            case 4:
                placed = sub.placed();
                break;
            case 5:
                placed = patrol.placed();
                break;
            default:
                placed = false;

        }
        return placed;
    }
    
    public void xPlode(int inX, int inY, String inMark)
    {
        int x = inX;
        int y = inY;
        String mark = inMark;
        sea[x][y].change(mark);
    }
    
    public boolean allSunk()
    {
        boolean allSunk = false;
        if((carrier.sunk()) && (battleship.sunk()) && (destroyer.sunk()) && (sub.sunk()) && (patrol.sunk()))
        {
            allSunk = true;
        }
        return allSunk;
    }
}