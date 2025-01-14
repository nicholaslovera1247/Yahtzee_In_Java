/*
Nicholas Lovera
CS2100A
Class GameDriver - Uses our Game class to actually play the game of Yahtzee
*/
import java.util.Scanner;
public class GameDriver
{
   public static void main(String [] args)
   {
      boolean playingGame = true; // Variable to use for while loop
      Scanner input = new Scanner(System.in); // Scanner used to repeat game or not
      while (playingGame)
      {
         Game g = new Game();
         g.playGame();
         
         boolean validation = true; // Variable for validation
         while (validation)
         {
            System.out.println("Do you want to play again? y/n: ");
            String choice = input.next();
            if (choice.equals("y"))
            {
               playingGame = true;
               validation = false;
            }
            
            else if (choice.equals("n"))
            {
               playingGame = false;
               validation = false;
            }
            
            else
            {
               System.out.println("Please select y/n");
            }
          }
      }
      
      System.out.println("Thanks for playing!");
      System.exit(0);
    }
}