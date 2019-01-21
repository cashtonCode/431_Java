/*
Program 1 (25 pts)

Write a Java program to get the average of a collection/assortment of numbers. The numbers can be input from the console or a file and the result output to the console or a file (Your choice). Provide sufficient console instructions to anyone running the program. If there are constraints that the user needs to be aware of, make sure to communicate these to the user.  The user should not be adversely constrained by number of elements or type of data (integer and decimal numbers should work). Be sure to handle and test invalid input.

Your program should use the following features, constructs:

a variable name
an aggregate data type such as an array (a string will not satisfy this requirement)
an expression and assignment statement
a statement-level control structure such as a loop
a subprogram
error handling
This project should run on the local Linux system.
Submit your code as instructed. Submit by email screen prints of your testing, and the associated input and output.

Due at class start time (by e-mail and printout); turn in a printout of your source code, screen prints of your testing (screen changed from black), and a printout of your input and the program output. Your printout should show that you sufficiently tested the program. E-mail a copy of your source code (as a separate file), screen prints of your testing, and your input and output. Font size should be 12 or larger.
*/
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

public class program1
{
  public static void main(String[] args) throws IOException
  {
    Scanner reader = new Scanner(System.in);
    double userInput = 0, userInputSum = 0;
    double[] userArray = new double[100000000];
    int userAmount = 0, inputChoice = 0;

    System.out.println("\n\nThank you for choosing to use this machine for your average needs. In just a moment I will take your numbers and calculate the average of them for you. While I am an incredible machine I have a programmed limit of 100,000,000 entries.\n\n\n\n");
    System.out.println("Before I begin I need to know how you want to give me the numbers.\nEnter 1 for input from a file\nEnter 2 for input from the console\nEnter anything else to end the program early");
    try{
      inputChoice = reader.nextInt();
    }catch(java.util.InputMismatchException e){
      System.exit(0);
    }

    switch(inputChoice)
    {
      case 1://file input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n\n\n\nYou have chosen to use a file as your input. In a moment I will ask you to enter the name of the file. Carefully enter the correct filename or this program will not find the intended file and terminate early.\n\nPlease enter the name of your file: ");

        String filename = br.readLine();
        Scanner scan;
        File file = new File(filename);

        try{
            scan = new Scanner(file);
            int arrayCounter = 0;
            while( (scan.hasNextDouble()) && (arrayCounter < 1000) )
            {
              userInput = scan.nextDouble();
              System.out.println(userInput);
              userArray[arrayCounter] = userInput;
              userAmount += 1;
              arrayCounter += 1;
            }
        } catch (java.io.FileNotFoundException e1) {e1.printStackTrace();}

        for(int i = 0; i < userAmount; i++)userInputSum += userArray[i];
        break;

      case 2://console input
        try{
          System.out.println("\n\n\n\nYou have chosen to use the console as your input. In a moment I will ask you to enter the amount of numbers you want to enter. Following that I will ask you to enter each number individually. Please use only numbers, any other character will terminate the program early.");
          System.out.println("\n\nHow many entries do you want?");
          userAmount = reader.nextInt();
          System.out.println("\n");
        }catch(java.util.InputMismatchException e1){
          System.out.println("\n\nPlease only enter numbers\n\n");
          System.exit(0);
        }

        int i;
        for(i = 0; i < userAmount; i++)
        {
          try{
            System.out.println("Enter a number");
            userInput = reader.nextDouble();
          }catch(java.util.InputMismatchException e2){
            System.out.println("\n\nPlease only enter numbers\n\n");
            System.exit(0);
          }
          userArray[i] = userInput;
        }
        for(i = 0; i < userAmount; i++)userInputSum += userArray[i];
        break;

      default://Any input that isn't (1 || 2)
        System.exit(0);
        break;
    }

    System.out.println("\n\nCurrent Total: ");
    System.out.println(userInputSum);
    double userInputAverage = CalcAverage(userInputSum,userAmount);
    System.out.println("\nAverage: ");
    System.out.println(userInputAverage);
    reader.close();
  }

  public static double CalcAverage(double amount, double divisor){return (amount / divisor);}
}
