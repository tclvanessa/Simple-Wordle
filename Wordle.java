/**
 *
 * @author Student Name
 * @version 1.0
 * @since -DATE FINISHED-
 * Wordle.java
 *
 * This program allows a user to play Wordle with the computer.
 * --EXPLAIN THE RULES--
 * 
 */
import java.util.*;
import java.lang.*;

public class Wordle
{
   //This is an array of Strings
   static String wordList[] = {"cynic", "fried", "spend", "mourn", "crash", "toxic", "geese", "frown", "berry", "abhor", "taste", "speak", "juice", "water", "hoard"};
   // add more to this list by adding more String Literals separated by commas
   /**
    * Entry point of the program
    * @param args input arguments
    */
   public static void main(String[] args)
   {
      //Variables
      String userInput = "";
      boolean game = true;
      String playAgainAnswr = "";
      boolean wrong = true;
      Scanner scnr = new Scanner(System.in);
      Random rand = new Random();

      //Opening to the Wordle
      System.out.println("Welcome to ... ");
      System.out.println(" __      __                .___.__");
      System.out.println("/  \\    /  \\___________  __| _/|  |   ____  ");
      System.out.println("\\   \\/\\/   /  _ \\_  __ \\/ __ | |  | _/ __ \\ ");
      System.out.println(" \\        (  <_> )  | \\/ /_/ | |  |_\\  ___/ ");
      System.out.println("  \\__/\\  / \\____/|__|  \\____ | |____/\\___  >");
      System.out.println("       \\/                   \\/           \\/ ");
      System.out.println("\nInstructions on how to play!");
      System.out.println("\t1. You have to guess the Wordle in six tries or less.");
      System.out.println("\t2. Every word you enter must be a valid word that would be in the dictionary and must be a 5 letter word.");
      System.out.println("\t3. A correct letter becomes upper case.");
      System.out.println("\t4. A letter that is in the wrong place will be lower case.");
      System.out.println("\t5. A letter that is not in the word will be an underscore (_)");
      System.out.println("\t*Remember! Your guess cannot contain anything other than letters.");
      System.out.println("\nNow that you have read the instructions, let's play!!\n");

      //Start game loop
      while(game)
      {
         game = true;
         String secret = wordList[rand.nextInt(wordList.length)];  // picks random word from the secret list

         //Loop for user guesses
         int userTries = 0;
         while(userTries < 6)
         {
            StringBuilder currentResult = new StringBuilder("_____");
            System.out.println("Enter your 5-letter guess.");
            userInput = scnr.next();

            //User input loop
            wrong = true;
            while(wrong)
            {
               wrong = false;
               for(int i = 0; i < 5; i++)
               {
                  //Asks user again if user gives a character other than a letter.
                  if(userInput.charAt(i) < 'a' || userInput.charAt(i) > 'z')
                  {
                     wrong = true;
                     System.out.println("Invalid. Only use letters.");
                     userInput = scnr.next();
                  }
               }

               //The user wins the game
               if (secret.equalsIgnoreCase(userInput))
               {
                  System.out.println("    " + userInput.toUpperCase() + " >>> try #" + (userTries + 1));
                  System.out.println("\nCongrats! You solved the word in " + (userTries + 1) + " tries!");
                  System.out.println("Play again? (y/n)");
                  userTries = 5;
                  playAgainAnswr = scnr.next();

                  //User chooses to stop playing
                  if(playAgainAnswr.equals("n"))
                  {
                     System.out.println("\nGood game!");
                     game = false;
                  }
               } else //Wordle checking
               {
                  //Takes in a letter from user's input
                  for(int i = 0; i < 5; i++)
                  {
                     //Takes in a letter from the secret word
                     for(int j = 0; j < 5; j++)
                     {
                        //Checks if the letter of the user's input is in the word
                        if(userInput.charAt(i) == secret.charAt(j))
                        {
                           currentResult.setCharAt(i, userInput.charAt(i));
                           //Checks if the letter of the user's input is in the correct place
                           if(userInput.charAt(i) == secret.charAt(i))
                           {
                              currentResult.setCharAt(i, Character.toUpperCase(userInput.charAt(i)));
                           }
                        }
                     }
                  }
                  //User's guess
                  System.out.println("    " + currentResult + " >>> try #" + (userTries + 1));

                  //User lost the Wordle
                  if(userTries >= 5)
                  {
                     System.out.println("\nNo more tries left...");
                     System.out.println("The Wordle of the day was " + secret + "!");
                     System.out.println("\nPlay again? (y/n)");
                     playAgainAnswr = scnr.next();

                     //Game Over
                     if(playAgainAnswr.equalsIgnoreCase("n"))
                     {
                        System.out.println("\nGame Over.");
                        game = false;
                     }
                  }
               }
               //Try attempt counter
               userTries++;
            }
         }
      }
      System.out.println("Thanks for playing!");
   }
}