public class Driver
{
    public static void main (String[] args)
    {
        String p1 = "Dill";
        String p2 = "Erich";
        Board board = new Board();
        Board board2 = new Board();
        Board guessBoard1 = new Board();
        Board guessBoard2 = new Board();

        Player player1 = new Player(p1, board, board2, guessBoard1);
        Player player2 = new Player(p2, board2, board, guessBoard2);

        System.out.println("              __              ");
        System.out.println("             |  |___       ");
        System.out.println("            .--**|___>..--*/   ");
        System.out.println("        .__.|-***..... ' /    ");
        System.out.println("__~__~__/_______________/____");
        System.out.println();
        System.out.println("       |BATTLESHIP|");

        System.out.println("Welcome to Battleship, Cadets!");
        scroll();
        System.out.println(p1 + ", please encode your fleet's formation:");
        System.out.println();
        player1.setup();
        for(int i = 0; i <= 9; i++)
        {
            System.out.println();
        }
        System.out.println(p2 + ", please encode your fleet's formation:");
        System.out.println();
        player2.setup();
        System.out.println("TO BATTLESTATIONS!");
        scroll();

        while((!player1.dead()) && (!player2.dead()))
        {
            player1.move();
            noPeeking();
            player2.move();
            noPeeking();
        }
        endSequence(p1, p2, player1, player2);
    }

    public static void noPeeking()
    {
        for(int i = 0; i <= 50; i++)
        {
            System.out.println("==========================================");
        }
        System.out.println    ("==============No Peeking==================");
        for(int i = 0; i <= 50; i++)
        {
            System.out.println("==========================================");
        }
        pressAnyKeyToContinue();
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

    public static void endSequence(String inP1, String inP2, Player inPlayer1, Player inPlayer2)
    { 
        String p1 = inP1;
        String p2 = inP2;
        Player player1 = inPlayer1;
        Player player2 = inPlayer2;
        if((player1.dead()) || (player2.dead()))
        {
            if(player1.dead())
            {
                scroll();
                System.out.println("Congratulations, Cadet " + p2 + ".");
                scroll();
                System.out.println("You are being promoted to Commander " + p2 + " due to extraordinary heroism."); 
                scroll();
                System.out.println("The world needs more people like you, Commander.");
                scroll();
                System.out.println("YOU WIN!");
                scroll();
            }
            if(player2.dead())
            {
                System.out.println("Congratulations, Cadet " + p1 + ". You are being promoted to Commander " + p1 + " due to extraordinary heroism. The world needs more people like you, Commander.");
            }
        }
    }

    public static void scroll()
    {
        try 
        {
            Thread.sleep(2000);                 //2000 milliseconds is one second.
        } 
        catch(InterruptedException ex) 
        {    
            Thread.currentThread().interrupt();
        }
        for(int i = 0; i <= 20; i++)
        {
            System.out.println();
            try
            {
                Thread.sleep(50);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }

}