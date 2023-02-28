public class MethodThree implements MethodsClass {
    protected int oCount = 0;
    protected int nCount = 0;
    public MethodThree() {
    }

    @Override
    public boolean Method(String input) {
        ArrayStack arrayStack = new ArrayStack(); // 1
        ArrayQueue arrayQueue = new ArrayQueue(); // 1
        oCount +=2;

        for(int i = 0; i < input.length(); i++){ // 3n
            arrayStack.push(input.charAt(i)); // n
            arrayQueue.enqueue(input.charAt(i)); // n
            oCount += 5;
            nCount ++;
        }

        while(!arrayStack.isEmpty() && !arrayQueue.isEmpty()){ // 2n
            if(arrayStack.pop() != arrayQueue.dequeue()){ // 1
                oCount++;
                return false;
            }
            nCount ++;
            oCount += 3;
        }
        // 7n + 3
        // O(n)
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
