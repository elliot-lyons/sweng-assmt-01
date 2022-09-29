import java.util.*;;

public class Calculator
{
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
                    if (input.hasNext("quit"))
                    {
                        quit = true;
                    }

                    else
                    {
                        if (validate(input.toString()))
                        {
                            int result = calculate(input.toString());
                            System.out.println("Result = " + result);
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

    }

    public static boolean validate(String input)
    {
        return false;
    }

    public static int calculate(String input)
    {
        return 0;
    }
}