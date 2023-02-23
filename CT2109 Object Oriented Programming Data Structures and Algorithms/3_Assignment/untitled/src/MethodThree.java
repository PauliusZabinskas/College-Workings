public class MethodThree implements MethodsClass {
    protected int oCount = 0;
    protected int nCount = 0;
    public MethodThree() {
    }

    @Override
    public boolean Method(String input) {
        ArrayStack arrayStack = new ArrayStack();
        ArrayQueue arrayQueue = new ArrayQueue();
        oCount +=2;

        for(int i = 0; i < input.length(); i++){
            arrayStack.push(input.charAt(i));
            arrayQueue.enqueue(input.charAt(i));
            oCount += 4;
            nCount ++;
        }

        while(!arrayStack.isEmpty() && !arrayQueue.isEmpty()){
            if(arrayStack.pop() != arrayQueue.dequeue()){
                oCount++;
                return false;
            }
            nCount ++;
            oCount += 3;
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
