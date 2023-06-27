import java.util.Scanner;
public class TTT {
    private String[][] box = {{"1", "2", "3"}, {"4", "5", "6"}, {"7","8","9"}};
    private static String[] store = new String[10];
    int fill=1;
    //Accept choice from the user
    public void accept1(String c, int p) 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if (box[i][j].equals(c) && p == 1) 
                {
                    box[i][j] = "X";
                } else if (box[i][j].equals(c) && p == 2) 
                {
                    box[i][j] = "O";
                }
            }
        }
    }
    
    //Display output after choosed choice
    public int display() 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                System.out.print("|\t" + box[i][j] + "\t|");
            }
            System.out.println();
        }
        return drawResult();
        
    }
    
    //Returns result if player 2 win 
    public int winResultp2() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (box[i][0].equals("O") && box[i][1].equals("O") && box[i][2].equals("O")) {
                return 1;
            }
        }
        
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (box[0][j].equals("O") && box[1][j].equals("O") && box[2][j].equals("O")) {
                return 1;
            }
        }
        
        // Check diagonals
        if (box[0][0].equals("O") && box[1][1].equals("O") && box[2][2].equals("O")) {
            return 1;
        }
        if (box[0][2].equals("O") && box[1][1].equals("O") && box[2][0].equals("O")) {
            return 1;
        }
        
        return 0;
    }
    
    //Returns result if player 1 wins
    public int winResultp1() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (box[i][0].equals("X") && box[i][1].equals("X") && box[i][2].equals("X")) {
                return 1;
            }
        }
        
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (box[0][j].equals("X") && box[1][j].equals("X") && box[2][j].equals("X")) {
                return 1;
            }
        }
        
        // Check diagonals
        if (box[0][0].equals("X") && box[1][1].equals("X") && box[2][2].equals("X")) {
            return 1;
        }
        if (box[0][2].equals("X") && box[1][1].equals("X") && box[2][0].equals("X")) {
            return 1;
        }
        
        return 0;
    }
    
    //Returns result if game is draw
    public int drawResult()
    {
      if(store[8]!=null)
      return 0;
      else
      return 1;
    }
    
    //Checks if entered choice is legal
    public boolean legal(String c) 
    {
      if (c.equals("1") || c.equals("2") || c.equals("3") || c.equals("4") || c.equals("5") || c.equals("6") || c.equals("7") || c.equals("8") || c.equals("9")) 
      {
        for (int j = 0; j < 9; j++) 
        {
            if (c.equals(store[j])) 
            {
                System.out.println("Illegal number, Re-enter");
                return false;
            }
        }
        return true;
      }
      System.out.println("Illegal number, Re-enter");
      return false;
    }

    //Stores previous choices of players to compare legal choices
    public void store(String c) 
    {
        for (int j = 0; j < 9; j++) 
        {
            if (store[j] == null) 
            {
                store[j] = c;
                break;
            }
        }
    }

    //Main Function 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TTT obj = new TTT();
        obj.display();
        
        for (int i = 0; i < 5; i++) {
            for (int p = 1; p < 3; p++) {
                System.out.print("Enter the number chosen by player " + p + ": ");
                String c = in.nextLine();
                if (!obj.legal(c)) {
                    p--;
                    continue;
                }
                obj.store(c);
                obj.accept1(c, p);
                if(obj.display()==0){
                  System.out.print("Its a DRAW!!!");
                  System.exit(0);
                }
                else if(obj.winResultp1()==1){
                  System.out.print("Player 1 WON!!!");
                  System.exit(0);
                }
                else if(obj.winResultp2()==1){
                  System.out.print("Player 2 WON!!!");
                  System.exit(0);
                }    
            }
        }
    }
}