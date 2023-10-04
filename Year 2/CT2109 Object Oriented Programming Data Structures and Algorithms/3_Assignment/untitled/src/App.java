import java.util.Scanner;

public class App {

    static int defaultIterations;
    public App(){

    }

    public void build(){
        MethodsClass methodOne = new MethodOne();
        MethodsClass methodTwo = new MethodTwo();
        MethodsClass methodThree = new MethodThree();
        MethodsClass methodFour = new MethodFour();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Number Of Iterations For Test Or Enter 0 For Default Setting");

        while (!sc.hasNextInt()){
            System.out.println("is not int");
            sc = new Scanner(System.in);
        }
        int testTimes = sc.nextInt();


        System.out.println("\nMethod One: ");test(methodOne, testTimes);
        System.out.println("\nMethod Two: ");test(methodTwo, testTimes);
        System.out.println("\nMethod Three: ");test(methodThree, testTimes);
        System.out.println("\nMethod Four: ");test(methodFour, testTimes);
    }


    public static void main(String[] args) {
        App app = new App();
        app.build();

    }

    public static String utility(String input){
        int decimal = Integer.parseInt(input);
        StringBuilder binary = new StringBuilder();

        // Handle the case of 0 separately
        if (decimal == 0) {
            return "0";
        }

        // Convert the decimal number to binary using repeated division by 2
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder); // insert the remainder at the beginning of the StringBuilder
            decimal /= 2;
        }

        return binary.toString();
    }

    public static void test(MethodsClass method, int testTimes){
        defaultIterations = 1000000;
        if(testTimes == 0){
            testTimes = defaultIterations;
        }

        int count = 0;
        long start = System.currentTimeMillis();
        for(int i = 0; i< testTimes; i++){

            String j = Integer.toString(i);

            if (method.Method(j)){
                count++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Decimal Numbers:");
        System.out.println("\tPalindrome Count: "+ count);
        System.out.println("\tTime in milliseconds Count: "+ (end-start)+" ms");
        System.out.println("\tOperation Count: "+ method.get_oCount() );
        System.out.println("\tO(n)): "+ method.getNCount() );
        count = 0;

        start = System.currentTimeMillis();
        for(int i = 0; i<= testTimes; i++ ){

            String j = Integer.toString(i);

            if (method.Method(utility(j))){
                count++;
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Binary Numbers:");
        System.out.println("\tPalindrome Count: "+ count);
        System.out.println("\tTime in milliseconds Count: "+ (end-start)+" ms");
        System.out.println("\tOperation Count: "+ method.get_oCount());
        System.out.println("\tO(n) Count: "+ method.getNCount() );
    }
}

