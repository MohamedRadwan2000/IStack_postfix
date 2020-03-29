package Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    //testStack
    @Test
    void test1(){
        Stack x=new  Stack();
        x.push(1);
        x.push(2);
        x.push(3);
        x.push(5);
        assertEquals(5,(int)x.peek());
        int size=x.size();
        Object[]Expected_values={5,3,2,1};
        Object[]actual_values=new Object[x.size()];
        actual_values=x.ToArray();
        assertArrayEquals(Expected_values,actual_values);
        assertEquals(4,size);
    }
    @Test
    void test2(){
        Stack x=new  Stack();
        x.push(1);
        x.push(2);
        x.push(3);
        x.push(5);
        x.push(8);
        assertEquals(8,(int)x.pop());
        assertEquals(5,(int)x.peek());
        int size=x.size();
        Object[]Expected_values={5,3,2,1};
        Object[]actual_values=new Object[x.size()];
        actual_values=x.ToArray();
        assertArrayEquals(Expected_values,actual_values);
        assertEquals(4,size);
    }
    @Test
    void test3(){
        //test_errors
        Stack x=new  Stack();
        x.push(1);
        x.push(2);
        x.push(3);
        x.push(5);
      x.pop();
      x.pop();
      x.pop();
      x.pop();
      //empty stack
      assertThrows(NullPointerException.class,()->{x.pop();});
      assertThrows(NullPointerException.class,()->{x.peek();});
    }



}