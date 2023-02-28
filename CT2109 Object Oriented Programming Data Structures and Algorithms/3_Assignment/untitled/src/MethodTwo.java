public class MethodTwo implements MethodsClass {
    protected int oCount = 0;
    protected int nCount = 0;
    public MethodTwo(){}

    @Override
    public boolean Method(String input) {
        for (int i = 0; i < input.length() / 2; i++) { // 3 operations
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) { // 2 operations
                oCount ++;
                return false;

            }
            // 3n/2
            oCount += 5;
            nCount ++;
        }
        return true;
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
