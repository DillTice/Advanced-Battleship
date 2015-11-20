import java.util.Scanner;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String name;
    private Board gameBoard;
    private Board enemyBoard;
    private Board guessBoard;
    private boolean dead;

    /**
     * Constructor for objects of class Player
     */
    public Player(String inName, Board inBoard, Board inBoard2, Board inGuessBoard)
    {
        // initialise instance variables
        name = inName;
        gameBoard = inBoard;
        enemyBoard = inBoard2;
        guessBoard = inGuessBoard;
        dead = false;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setup()
    {
        boolean setup = false;
        Scanner in = new Scanner(System.in);
        while(!setup)
        {
            gameBoard.reset();
            gameBoard.print();
            for(int i = 0; i <= 4; i++)
            {
                int choice = 0;
                System.out.println("Please select a ship to deploy:");
                if(!gameBoard.placed(1))
                {
                    System.out.println("1. Carrier");
                }
                if(!gameBoard.placed(2))
                {
                    System.out.println("2. Battleship");
                }
                if(!gameBoard.placed(3))
                {
                    System.out.println("3. Destroyer");
                }
                if(!gameBoard.placed(4))
                {
                    System.out.println("4. Submarine");
                }
                if(!gameBoard.placed(5))
                {
                    System.out.println("5. Patrol Boat");
                }

                choice = in.nextInt();

                switch(choice)
                {
                    case 1:
                    if(!gameBoard.placed(1))
                    {
                        gameBoard.move(1);
                        gameBoard.print();
                        break;
                    }
                    else
                    {
                        System.out.println("That ship has already been placed!");
                    }
                    case 2:
                    if(!gameBoard.placed(2))
                    {
                        gameBoard.move(2);
                        gameBoard.print();
                        break;
                    }
                    else
                    {
                        System.out.println("That ship has already been placed!");
                    }
                    case 3:
                    if(!gameBoard.placed(3))
                    {
                        gameBoard.move(3);
                        gameBoard.print();
                        break;
                    }
                    else
                    {
                        System.out.println("That ship has already been placed!");
                    }
                    case 4:
                    if(!gameBoard.placed(4))
                    {
                        gameBoard.move(4);
                        gameBoard.print();
                        break;
                    }
                    else
                    {
                        System.out.println("That ship has already been placed!");
                    }
                    case 5:
                    if(!gameBoard.placed(5))
                    {
                        gameBoard.move(5);
                        gameBoard.print();
                        break;
                    }
                    else
                    {
                        System.out.println("That ship has already been placed!");
                    }
                }            
            }
            System.out.println("Ready? ( 1. Yes || 2. No )>");
            int ready = in.nextInt();
            switch(ready)
            {
                case 1:
                setup = true;
                break;
                case 2:
                setup = false;
                default:
                System.out.println("That is not a valid selection!");
                break;
            }
        }
    }

    public void move()
    {
        boolean selection = false;
        Scanner in = new Scanner(System.in);
        System.out.println(name + "'s turn");
        System.out.println("##########################################");
        guessBoard.print();
        System.out.println("==========================================");
        gameBoard.print();
        boolean ready = false;
        while(!selection)
        {
            System.out.println("Please enter target coordinates:");
            System.out.println("Y: ");
            int x = in.nextInt();
            System.out.println("X: ");
            int y = in.nextInt();
            String type = enemyBoard.getType(x, y);
            if((x >= 0 && x <= 9) && (y >= 0 && y <= 9))
            {
                if(type != "~")
                {
                    System.out.println("Hit!");

                    switch(type)
                    {
                        case "C":
                        enemyBoard.hit(type, x, y);
                        break;
                        case "B":
                        enemyBoard.hit(type, x, y);
                        break;
                        case "D":
                        enemyBoard.hit(type, x, y);
                        break;
                        case "S": 
                        enemyBoard.hit(type, x, y);
                        break;
                        case "P":
                        enemyBoard.hit(type, x, y);
                        break;
                    }
                    guessBoard.xPlode(x, y, "X");
                    selection = true;
                    pressAnyKeyToContinue();
                }
                if(type == "~")
                {
                    System.out.println("Miss!");
                    guessBoard.xPlode(x, y, "O");
                    selection = true;
                    pressAnyKeyToContinue();
                }
            }
            }
        
            
        
    }
    
    public void hurtShip(Ship inShip)
    {
        Ship ship = inShip;
        ship.hurt();
    }
    
    public boolean dead()
    {
        dead = false;
        if(gameBoard.allSunk())
        {
            dead = true;
        }
        return dead;
    }
    
        private static void pressAnyKeyToContinue()
    { 
        System.out.println("Press any key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
    }
}
