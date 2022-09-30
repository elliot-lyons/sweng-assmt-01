import java.util.*;

public class Calculator
{

    public static Stack<Character> globalOps = new Stack<Character>();
    public static Stack<Integer> globalNos = new Stack<Integer>();

    public static void main(String[] args) 
    {
        boolean quit = false;
        boolean first = true;
        
        Scanner input = new Scanner(System.in);

        while (!quit)
        {
            System.out.println((first ? "Welcome to the simple calculator application. " : "") + "Please enter "
                + "in an expression to start or 'quit' to quit...");

            first = false;

                try
                {
                    String expression = input.next();

                    if (expression.equals("quit"))
                    {
                        quit = true;
                        System.out.println("Exiting application");
                    }

                    else
                    {
                        if (validate(expression))               // maybe return a list, making it easier for calculate 
                        {                                       // implementation? Certainly make it more efficient
                            int result = calculate(expression);
                            System.out.println("Result = " + result);

                            while (!globalOps.isEmpty())
                            {
                                System.out.println(globalOps.pop());
                            }

                            while (!globalNos.isEmpty())
                            {
                                System.out.println(globalNos.pop());
                            }
                        }

                        else
                        {
                            System.out.println("Invalid input... ");
                        }
                    }
                }

                catch (Exception e)
                {
                    e.printStackTrace();
                }
        }

        input.close();
    }

    public static boolean validate(String input)
    {
        if (input.equals(null))
        {
            return false;
        }

        char[] theChars = input.toCharArray();
        // boolean hasToBeNo = true;               // next char has to be number (i.e. at start of sum or after operation)

        Stack<Character> localOps = new Stack<Character>();
        Stack<String> localNos = new Stack<String>();
        int count = 1;

        for (int i = 0; i < theChars.length; i++)
        {
            switch (theChars[i])
            {
                case ('+'):
                case('*'):
                case('-'):
                case('/'):
                    	if (count == 1 || i == (theChars.length - 1))
                        {
                            return false;
                        }

                        localOps.push(theChars[i]);
                        String current = "";

                        while (count > 1)
                        {
                            current = localNos.pop() + current;
                            count--;
                        }

                        localNos.push(current);
                        break;

                case('0'):                  // might be a more efficient way of doing this with ASCII?
                case('1'):
                case('2'):
                case('3'):
                case('4'):
                case('5'):
                case('6'):
                case('7'):
                case('8'):
                case('9'):
                        count++;
                        localNos.push(Character.toString(theChars[i]));
                        break;

                default:
                        return false;        // input involves some character that's neither a number nor character
            }
        }
        String current = "";

        while (count > 1)
        {
            current = localNos.pop() + current;
            count--;
        }

        localNos.push(current);


        while (!localOps.isEmpty())
        {
            globalOps.push(localOps.pop());
        }

        while (!localNos.isEmpty())
        {
            globalNos.push(Integer.parseInt(localNos.pop()));
        }

        return true;
    }
    
    public static int add (int a, int b){
        return a + b;
    }

    public static int subtract (int a, int b){
        return a - b;
    }

    public static int multiply (int a, int b){
        return a * b;
    }

    public static int divide (int a, int b){
        if (b == 0)
        {
            return 0;
        }
        return a / b;
    }

    public static int calculate(String input)
    {
        return 0;
    }
}