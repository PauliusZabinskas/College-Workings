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
        if (input.isEmpty() || input.length() == 1) {
            return input;
        }

        StringBuilder reversedSubstring = new StringBuilder(reverse(input.substring(1)));
        reversedSubstring.append(input.charAt(0));
        return reversedSubstring.toString();
        // O(n)
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
