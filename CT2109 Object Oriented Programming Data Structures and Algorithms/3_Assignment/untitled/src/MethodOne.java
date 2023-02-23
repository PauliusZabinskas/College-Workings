public class MethodOne implements MethodsClass {

    protected int oCount = 0;
    protected int nCount = 0;
    public MethodOne() {

    }
    @Override
    public boolean Method(String input){
        String reverseString = "";
        oCount += 1;
        for(int i = input.length()-1; i > -1; i--){
            reverseString += input.charAt(i);
            oCount+=4;
            nCount ++;
        }
        oCount++;
        return reverseString.equals(input);
    }
    public int get_oCount(){
        return this.oCount;
    }
    public int getNCount(){
        return nCount;
    }
}
