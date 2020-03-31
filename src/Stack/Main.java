package Stack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
        int choose;
        while (true) {
            while (true) {
                System.out.println("which UI do you want : press 1-Stack.   2-Expression Evaluator.");
                choose=read.nextInt();
                if (choose == 1 || choose == 2) {
                    break;
                }
            }
            if (choose == 1) {
                Stack s = new Stack();
                int Operation;
                while (true) {
                    System.out.println("Which Operation do you want to do on the stack");
                    System.out.println("1-push.");
                    System.out.println("2-Pop.");
                    System.out.println("3-Peek.");
                    System.out.println("4-Get Size.");
                    System.out.println("5-Check if empty.");
                    System.out.println("6-Back to main menu.");
                    Operation = read.nextInt();
                    if (Operation == 1) {
                        String value;
                        System.out.println("Enter the value you want to push into Stack:");
                        value = read.next();
                        s.push(value);
                    } else if (Operation == 2) {
                        if (!s.isEmpty()) {
                            System.out.println(s.pop());
                        } else {
                            System.out.println("Stack is Empty");
                        }
                    } else if (Operation == 3) {
                        if (!s.isEmpty()) {
                            System.out.println("peeked value is: "+s.peek());
                        } else {
                            System.out.println("Stack is Empty");
                        }}
                    else if (Operation==4){System.out.println("the Size of the Stack is:"+s.size());}
                    else if (Operation==5){
                        if(s.isEmpty()){System.out.println("Stack is Empty");}
                        else {System.out.println("Stack is not Empty");}
                    }
                    else if (Operation==6){
                        break;
                    }

                }
            } else if (choose == 2) {
                ExpressionEvaluator l = new ExpressionEvaluator();
                String x = new String();
                while (true) {
                    System.out.println("Do you want to : 1-Continue. 2-Back to main menu");
                    int des=read.nextInt();
                    if (des==1) {
                        try {
                            System.out.println("Enter the infix expression");
                            x = read.next();
                            String y = l.infixToPostfix(x);
                            System.out.println("the postfix expression is: " + y);
                            int m = l.evaluate(y);
                            System.out.println("the value of this expression:  " + m);
                        } catch (Exception e) {
                        }
                    }
                    else if (des==2){break;}
                    }
                }

            }
        }
    }



