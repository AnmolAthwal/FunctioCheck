import java.util.Scanner;

class Main {

  public static Boolean checkCode(int number) {
    
    // Declares and initalizes all the variables
    boolean trigger =  true;
    int charLength = 0;
    int numCheck = number;
    boolean num = false;
    int sum = 0;

    // return if the value of the number is below 0, since that isn't possible in this case
    if (number < 0) {
      return num;
    }

    // This will figure out how many numbers the code has.
    while (trigger == true) {
      // Checks if the integer is 0
      if (numCheck < 1) {
        trigger = false;
        break;
      }
      // Will remove one number per run, until there are no numbers left.
      numCheck = numCheck / 10;
      charLength++;
    }

    // Creates the array to store the numbers in
    int[] indivNum = new int[charLength];

    // Will put each individual numbers inside an array.
    for (int i = 0; i < charLength; i++) {
      int lastNum = number % 10;
      indivNum[i] = lastNum;
      number = number / 10;
    }

    // Get the sum of the array
    for (int i = 0; i < charLength; i++) {
      sum = sum + indivNum[i];
    }

    // Checks wether the sum is divisible by 7
    if (sum%7 == 0) {
      num = true;
    }

    // This will end the code and bring the final value to the code that called this function.
    return num;
  }
  public static void main(String[] args) {
    // create a Scanner for user input
    Scanner input = new Scanner(System.in);

    // Ask the user for a number
    System.out.println("Enter a positive integer.");
    int num = input.nextInt();

    // Call for the checkCode function, and see if the number is valid
    if (!checkCode(num)) {
      // Not valid (boolean is false)
      System.out.println("false");
    } else {
      // valid (boolean is true)
      System.out.println("true");
    }
  }
}