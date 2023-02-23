public class MethodFour implements MethodsClass{
    protected static int oCount = 0;

    protected int nCount = 0;
    public MethodFour(){}

    @Override
    public boolean Method(String input) {

        String reversedStr = reverse(input);
        return input.equals(reversedStr);
    }
    public static String reverse(String input){
        // base case
        // if input length is 1, then return the string
        // if input is empty return the string
        if (input.isEmpty() || input.length() == 1) {
            return input;
        }

        String reversedSubstring = reverse(input.substring(1));
        oCount ++;
        return reversedSubstring + input.charAt(0);
    }

    @Override
    public int get_oCount() {
        return this.oCount;
    }

    @Override
    public int getNCount() {
        return nCount;
    }
}
