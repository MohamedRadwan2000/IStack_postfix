package Stack;

public class Stack implements IStack{
    static class StackNode{
       Object data;
        StackNode next;
        StackNode(Object  data){
            this.data=data;
        }
    }
      private StackNode head;
      private int size=0;
    /***
     * this function tests if this stack if empty or not
     * @return true if the stack is empty and false if its not empty
     */
    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        else {return false;}
    }
    /***
     * this function push the value you want to push into the stack
     */
    public void push(Object data){
        if(this.head==null){
            StackNode n=new StackNode(data);
            this.head=n;
            this.size++;
        }
        else {
            StackNode n=new StackNode(data);
            StackNode temp=head;
            head=n;
            n.next=temp;
            this.size++;}
    }
    /***
     * this function pop from the stack
     * it throws exception if the stack is already empty
     * @return the poped value
     */
    public Object pop(){
        if(head==null){
            throw new NullPointerException("STACK IS EMPTY");
        }
        else {Object data=head.data;
        head=head.next;
        this.size--;
        return data;}
    }
    /***
     * this function peek from the stack
     * it throws exception if the stack is already empty
     * @return the peeked value
     */
    public Object peek(){
        if(head==null){
            throw new NullPointerException("STACK IS EMPTY");
        }
        else {Object data=head.data;
            return data;}
    }
    /***
     * this function return the size of the stack
     * @return the size of the stack
     */
    public int size(){return this.size;}
    /***
     * this function turn the stack into array to make performing tests on it more easier
     * @return array with the values on the stack
     */
    public Object[]ToArray(){
        Object[]y=new Object[this.size()];
        for(int i=0;i<y.length;i++){
            y[i]=this.pop();
        }
        return y;
    }

}
