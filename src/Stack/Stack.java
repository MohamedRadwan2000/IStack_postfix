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
    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        else {return false;}
    }
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
    public Object pop(){
        if(head==null){
            throw new NullPointerException("STACK IS EMPTY");
        }
        else {Object data=head.data;
        head=head.next;
        this.size--;
        return data;}
    }
    public Object peek(){
        if(head==null){
            throw new NullPointerException("STACK IS EMPTY");
        }
        else {Object data=head.data;
            return data;}
    }
    public int size(){return this.size;}

    public Object[]ToArray(){
        Object[]y=new Object[this.size()];
        for(int i=0;i<y.length;i++){
            y[i]=this.pop();
        }
        return y;
    }

}
