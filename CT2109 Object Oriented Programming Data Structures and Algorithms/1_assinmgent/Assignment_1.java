import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Assignment_1 {

    List<String> arrayList = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));

    protected static Scanner sc = new Scanner(System.in);

    public Assignment_1() {

    }

    public static void main(String[] args) {

        Assignment_1 g = new Assignment_1();
        g.game();
    }

    public void game() {
        System.out.println("\n\n\t===== Type alphabet in order. (Game)======");
        System.out.println("\tTime will start when u choose game direction");
        System.out.println("\tChoose to play the game forwards or backwards (f/b)");
        boolean forwards = (f_or_b()); // return boolean
        final long startTime = System.currentTimeMillis();
        testGame(forwards);
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " ms");
        System.out.println("Total execution time: " + (endTime - startTime) / 1000 + " seconds");

    }

    public boolean f_or_b() {
        String letter = "";
        while (!letter.equals("f") || !letter.equals("b")) {

            letter = sc.nextLine().toLowerCase();
            if (letter.equals("f")) {
                System.out.println("\t You have chosen to play the game forwards");
                break;
            }
            if (letter.equals("b")) {
                System.out.println("\t You have chosen to play the game backwards");
                break;
            } else {
                System.out.println("Not valid input. Choose 'f' or 'b' to start.");
            }
        }
        return letter.equals("f") ? true : false;
    }

    public void testGame(boolean direction) {

        System.out.println("\t");
        if (direction) {
            System.out.println("To start type 'a'");
            int i = 0;
            while (arrayList.size() - 1 >= i) {
                String l = sc.nextLine().toLowerCase();
                if (l.equals(arrayList.get(i))) {
                    try {
                        System.out.println(l + ": Correct! Now type " + arrayList.get(i + 1));
                        i++;
                    } catch (Exception e) {
                        if (l.equals("z")) {
                            System.out.println("Done");
                            break;
                        } else {
                            ;
                        }
                    }
                } else {
                    ;
                }
            }
        } else {
            System.out.println("To start type 'z'");
            int i = arrayList.size() - 1;
            while (0 <= i) {

                String l = sc.nextLine().toLowerCase();
                if (l.equals(arrayList.get(i))) {
                    try {
                        System.out.println(l + ": Correct! Now type " + arrayList.get(i - 1));
                        if (i > 0) {
                            i--;
                        }
                    } catch (Exception e) {
                        if (l.equals("a")) {
                            System.out.println("Done");
                            break;
                        } else {
                            ;
                        }

                    }

                } else {
                    ;
                }

            }
        }

    }

}
