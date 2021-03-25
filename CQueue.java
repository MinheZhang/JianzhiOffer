class CQueue {

    private Stack<Integer> mainStack;
    private Stack<Integer> tempStack;

    public CQueue() {
        mainStack = new Stack<Integer>();
        tempStack = new Stack<Integer>();
    }
    
    public void appendTail(int value) {
        while (!mainStack.empty()) {
            tempStack.push(mainStack.pop());
        }
        tempStack.push(value);
        while (!tempStack.empty()) {
            mainStack.push(tempStack.pop());
        }
    }
    
    public int deleteHead() {
        if (mainStack.empty()) {
            return -1;
        }
        return mainStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */