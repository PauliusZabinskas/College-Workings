public class Main {

    int operationCount = 0;

    public static void main(String[] args) {
        MethodsClass methodOne = new MethodOne();
        MethodsClass methodTwo = new MethodTwo();
        MethodsClass methodThree = new MethodThree();
        MethodsClass methodFour = new MethodFour();

        System.out.println("\nMethod One: ");test(methodOne);
        System.out.println("\nMethod Two: ");test(methodTwo);
        System.out.println("\nMethod Three: ");test(methodThree);
        System.out.println("\nMethod Four: ");test(methodFour);

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

    public static void test(MethodsClass method){
        int count= 0;
        long start = System.currentTimeMillis();
        for(int i =0; i< 1000000; i++){

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
        for(int i = 0; i<= 1000000; i++ ){

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

