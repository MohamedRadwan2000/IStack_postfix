package Stack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     ExpressionEvaluator l=new ExpressionEvaluator();
     String x=new String();
     Scanner read=new Scanner(System.in);
     while (true){
         try {
             System.out.println("Enter the infix expression");
             x=read.next();
             String y=l.infixToPostfix(x);
             System.out.println("the postfix expression is: "+y);
             int m=l.evaluate(y);
             System.out.println("the value of this expression:  "+m);
         }
         catch (Exception e){
         }
     }

        }
    }

