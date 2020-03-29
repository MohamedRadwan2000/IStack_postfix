package Stack;

import org.junit.jupiter.api.Test;

import java.lang.invoke.WrongMethodTypeException;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {
    @Test
    void test_1(){
        ExpressionEvaluator l=new ExpressionEvaluator();
        String x="2 + 3 * 4";
        String y="2 3 4 * +";
        String n=l.infixToPostfix(x);
        assertTrue(y.equals(n));
        assertEquals(14,l.evaluate(n));
    }
    @Test
    void test_2(){
        ExpressionEvaluator l=new ExpressionEvaluator();
        String x="2 + 3 * -14";
        String y="2 3 0 14 - * +";
        String n=l.infixToPostfix(x);
        assertTrue(y.equals(n));
        assertEquals(-40,l.evaluate(n));
    }

    @Test
    void test_4(){
        ExpressionEvaluator l=new ExpressionEvaluator();
        String x="(a / (b - c + d)) * (e - a) * c ";
        String y="a b c - d + / e a - * c *";
        String n=l.infixToPostfix(x);
        assertTrue(y.equals(n));
        assertEquals(0,l.evaluate(n));
    }
    @Test
    void test_(){
        ExpressionEvaluator l=new ExpressionEvaluator();
        String x="a / b - c + d * e - a * c";
        String y="a b / c - d e * + a c * -";
        String n=l.infixToPostfix(x);
        assertTrue(y.equals(n));
        assertEquals(0,l.evaluate(n));
    }
    @Test
    void test_5(){
        ExpressionEvaluator l=new ExpressionEvaluator();
        String x="2 + 3 * *-14 ";
        assertThrows(WrongMethodTypeException.class,()->{l.infixToPostfix(x);});

    }
    @Test
    void test_6(){
        ExpressionEvaluator l=new ExpressionEvaluator();
        String x="2 + 3 * -14* ";
        assertThrows(WrongMethodTypeException.class,()->{l.infixToPostfix(x);});

    }



}