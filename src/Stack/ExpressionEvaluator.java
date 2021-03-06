package Stack;


import java.lang.invoke.WrongMethodTypeException;

public class ExpressionEvaluator implements IExpressionEvaluator {
    /***
     *this function identify the priority of the operation  ) ( > * / > + -
     * @param c the character which refer to the type of operation
     * @return the priority of the operation
     */
    public int piority(char c){
        if(c=='+'||c=='-'){return 1;}
        else if(c=='*'||c=='/'){return 2;}
        else if(c=='^'){return 3;}
        else {return 0;}
    }
    /***
     *this function removes the all spaces from the expression
     * @param expression the string expression which we will remove the spaces from it
     * @return string without spaces
     */
    private String remove_spaces(String expression){
        String NewExpression="";
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)!=' '){NewExpression+=expression.charAt(i);}
        }
        return NewExpression;
    }
    /***
     *this function test if this expression is true or false
     * @param expression the string expression which we will be tested
     * @return true if it is correct false if it is wrong
     */
    boolean text_exp(String expression){
        if(expression.charAt(0)=='*'||expression.charAt(0)=='/'){System.out.println("invalid infix expression");return false; }
        for(int i=0;i<expression.length();i++){
            if((i!=expression.length()-1)&&((expression.charAt(i)=='*')||(expression.charAt(i)=='/')||(expression.charAt(i)=='+')||(expression.charAt(i)=='-'))&&((expression.charAt(i+1)=='*')||(expression.charAt(i+1)=='/'))) {
              System.out.println("invalid infix expression");return false;}
            if(expression.charAt(i)=='@'||expression.charAt(i)=='!'||expression.charAt(i)=='%'||expression.charAt(i)=='_'||expression.charAt(i)=='='||expression.charAt(i)=='#'||expression.charAt(expression.length()-1)=='~'||expression.charAt(i)=='$'||expression.charAt(i)=='?'||expression.charAt(i)=='.'){
                System.out.println("invalid infix expression");return false;
            }
            }
        if(expression.charAt(expression.length()-1)=='*'||expression.charAt(expression.length()-1)=='-'||expression.charAt(expression.length()-1)=='/'||expression.charAt(expression.length()-1)=='+'||expression.charAt(expression.length()-1)=='@'||expression.charAt(expression.length()-1)=='!'||expression.charAt(expression.length()-1)=='%'||expression.charAt(expression.length()-1)=='_'||expression.charAt(expression.length()-1)=='='||expression.charAt(expression.length()-1)=='#'||expression.charAt(expression.length()-1)=='~'||expression.charAt(expression.length()-1)=='$'||expression.charAt(expression.length()-1)=='?'||expression.charAt(expression.length()-1)=='.'||expression.charAt(expression.length()-1)=='^'||expression.charAt(expression.length()-1)=='|'||expression.charAt(expression.length()-1)=='&'||expression.charAt(expression.length()-1)==','){
            System.out.println("invalid infix expression");
            return false;
        }
        return true;
        }
    /***
     *this function takes the infix expression and turn it into postfix expression
     * @param expression the infix expression which we will be turned into postfix
     * @return true if it is correct false if it is wrong
     */
    public String infixToPostfix(String expression){
        String output="";
        expression=remove_spaces(expression);
        boolean y=true;
        for(int i=0;i<expression.length();i++){
            if(!Character.isDigit(expression.charAt(i))){y=false;}
        }
        if(y==true){return expression;}
        if(!text_exp(expression)){throw new WrongMethodTypeException();};
        Stack stk=new Stack();
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)==' '){continue;}
            if(Character.isDigit(expression.charAt(i))||Character.isAlphabetic(expression.charAt(i))){
                output+=expression.charAt(i);
                while ((i!=expression.length()-1)&&Character.isDigit(expression.charAt(i+1))){
                output+=expression.charAt(i+1);
                i++;}
                output+=' ';
            }
            else if(expression.charAt(i)=='('){
                stk.push('(');
            }
            else if(expression.charAt(i)==')'){
                while((char)stk.peek()!='('){
                    output+=stk.pop();
                    output+=' ';
                }
                stk.pop();//to remove '('
            }
            else if(expression.charAt(i)=='-'){if(i!=0) {

                if (((expression.charAt(i) == '-') || (expression.charAt(i) == '+')) && ((expression.charAt(i - 1) == '*') || (expression.charAt(i - 1) == '/') || (expression.charAt(i - 1) == '-') || (expression.charAt(i - 1) == '+')||(expression.charAt(i - 1) == '('))) {
                    int counter = 0;
                    while ((!Character.isDigit(expression.charAt(i)))&&(!Character.isAlphabetic(expression.charAt(i)))) {
                        if ((expression.charAt(i) != '/') && (expression.charAt(i) != '*')) {
                            stk.push(expression.charAt(i));
                            counter++;
                            output += '0';
                            output += ' ';
                            i++;
                        } else {
                            throw new WrongMethodTypeException("Wrong Expression");
                        }
                    }
                    output += expression.charAt(i);
                }
                else { while((!stk.isEmpty())&&((piority(expression.charAt(i)))<=(piority((char)stk.peek())))){
                    output+=stk.pop();
                    output+=' ';
                }
                    stk.push(expression.charAt(i));}
                } else {
                    if (((expression.charAt(i) == '-') || (i == 0))) {
                        int counter = 0;
                        while ((!Character.isDigit(expression.charAt(i)))&&(!Character.isAlphabetic(expression.charAt(i)))) {
                            if ((expression.charAt(i) != '/') && (expression.charAt(i) != '*')) {
                                stk.push(expression.charAt(i));
                                counter++;
                                output += '0';
                                output += ' ';
                                i++;
                            } else {
                                throw new WrongMethodTypeException("Wrong Expression");
                            }
                        }
                        output += expression.charAt(i);
                    }
                }
            }
            else{
                while((!stk.isEmpty())&&((piority(expression.charAt(i)))<=(piority((char)stk.peek())))){
                    output+=stk.pop();
                    output+=' ';
                }
                stk.push(expression.charAt(i));
            }

        }
        while (!stk.isEmpty()){output+=stk.pop();
        output+=' ';}
        String output2="";
        for(int i=0;i<output.length()-1;i++){
            output2+=output.charAt(i);
        }
        return output2;
    }
    /***
     *this function takes the postfix expression and find its value
     * if its Alphabetical expression it will return '0' value
     * @param expression the postfix expression which we will be turned into postfix
     * @return true if it is correct false if it is wrong
     */
    public int evaluate(String expression){
        Stack stk=new Stack();
        for (int i=0;i<expression.length();i++){
            if(Character.isAlphabetic(expression.charAt(i))){return 0;}
        }
        boolean y=true;
        for(int i=0;i<expression.length();i++){
            if(!Character.isDigit(expression.charAt(i))){y=false;}
        }
        if(y==true){
            float f=0;
            int counter=10;
            for(int i=0;i<expression.length();i++){
                f=f*counter+Float.parseFloat(Character.toString(expression.charAt(i)));
            }return (int)f;}
        for(int i=0;i<expression.length();i++){
            if(Character.isDigit(expression.charAt(i))){
                float x=Float.parseFloat(Character.toString(expression.charAt(i)));
                int counter=10;
                while (Character.isDigit(expression.charAt(i+1))){
                    x=x*counter+Float.parseFloat(Character.toString(expression.charAt(i+1)));
                    i++;

                }
                stk.push(x);
            }
            else if(expression.charAt(i)==' '){continue;}
            else{
                float op2=(float)stk.pop();
                float op1=(float)stk.pop();
                float result=MathOperation(op1,op2,expression.charAt(i));
                stk.push(result);
            }
        }
        float m=(float)stk.peek();
        return (int)m;
    }
    /***
     *this function takes the first operator and second operator and the operation and perform the operation on them
     * @param op1 the first operator
     * @param op2 the first operator
     * @param operator the operation which will performed
     * @return true if it is correct false if it is wrong
     */
    float MathOperation(float op1,float op2,char operator){
        if(operator=='+'){return op1+op2;}
        if(operator=='-'){return op1-op2;}
        if(operator=='*'){return op1*op2;}
        if(operator=='/'){
            if(op2==0){throw new RuntimeException("unable to devide by Zero");}
            return op1/op2;}
        else {throw new WrongMethodTypeException();
        }
    }
}
