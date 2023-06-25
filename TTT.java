import java.util.Scanner;
public class TTT {
    private String[][] box = {{"1", "2", "3"}, {"4", "5", "6"}, {"7","8","9"}};
    private static String[] store = new String[6];

    public void accept1(String c, int p) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (box[i][j].equals(c) && p == 1) {
                    box[i][j] = "X";
                } else if (box[i][j].equals(c) && p == 2) {
                    box[i][j] = "O";
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|\t" + box[i][j] + "\t|");
            }
            System.out.println();
        }
    }

    public boolean legal(String c) {
      if (c.equals("1") || c.equals("2") || c.equals("3") || c.equals("4") || c.equals("5") || c.equals("6") || c.equals("7") || c.equals("8") || c.equals("9")) {
        for (int j = 0; j < 6; j++) {
            if (c.equals(store[j])) {
                System.out.println("Illegal number, Re-enter");
                return false;
            }
        }
        return true;
      }
      System.out.println("Illegal number, Re-enter");
      return false;
    }

    public void store(String c) {
        for (int j = 0; j < 6; j++) {
            if (store[j] == null) {
                store[j] = c;
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TTT obj = new TTT();
        obj.display();
        
        for (int i = 0; i < 3; i++) {
            for (int p = 1; p < 3; p++) {
                System.out.print("Enter the number chosen by player " + p + ": ");
                String c = in.nextLine();
                if (!obj.legal(c)) {
                    p--;
                    continue;
                }
                
                obj.store(c);
                obj.accept1(c, p);
                obj.display();
            }
        }
    }
}

