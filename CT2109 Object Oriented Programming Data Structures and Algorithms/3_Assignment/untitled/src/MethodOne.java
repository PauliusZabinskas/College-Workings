public class MethodOne implements MethodsClass {

    protected int oCount = 0;
    protected int nCount = 0;
    public MethodOne() {

    }
    @Override
    public boolean Method(String input){
        String reverseString = ""; // 1
        oCount += 1; // 1
        for(int i = input.length()-1; i > -1; i--){ // 3n - 1
            reverseString += input.charAt(i); // 1n
            oCount+=4; // 3n + 1n
            nCount ++; // O(n)
        }
        oCount++;
        return reverseString.equals(input);
        //
    }
    public int get_oCount(){
        return this.oCount;
    }
    public int getNCount(){
        return nCount;
    }
}
