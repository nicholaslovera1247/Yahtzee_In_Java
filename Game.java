/*
Nicholas Lovera
CS2100A
Class Game - Programs the game of Yahtzee
*/
import java.util.Scanner;
import java.util.InputMismatchException;
public class Game
{
   //instance variables
   private DiceRoll d;
   private DiceRoll d2;
   private Scorecard player1Score;
   private Scorecard player2Score;
   private int player1EndScore;
   private int player2EndScore;
   private Scanner input;
   //class constants
   private static final int AMOUNT_OF_ROLLS = 2;
   private static final int ROUNDS = 13;
   
   /*
      Standard Constructor
      Sets player1Score and player2Score to a
      new Scorecard
      Sets input to a new Scanner for user input
   */
   public Game()
   {
      player1Score = new Scorecard();
      player2Score = new Scorecard();
      input = new Scanner(System.in);
   }
   
   /*
      Method playGame plays the game of Yahtzee using
      ALL of the different objects (classes) that we made
      to make up the game
      no parameters
   */
   public void playGame()
   {
      System.out.println("*******************************************************");
      System.out.println("                   WELCOME TO YAHTZEE                  ");
      System.out.println("*******************************************************\n\n");
      for (int i = 0; i < ROUNDS; i++)
      {
         int player1Turn = 0;
         int player2Turn = 0;
         int player1Rolls = 0;
         int player2Rolls = 0;
         System.out.println("*** Player 1 ***");
         d = new DiceRoll();
         do{
            System.out.println(player1Score + "\n");
            System.out.println("******************************\n");
            System.out.println("Dice:\n" + d);
            System.out.print("Please select a die # to toggle it between save and unsave, \"roll\" or \"score\": \n");
            String userInput = input.next().toLowerCase();
            if (userInput.equals("roll"))
            {
               if (player1Rolls < AMOUNT_OF_ROLLS)
               {
                  for (int count = 0; count < d.getNumDice(); count++)
                  {
                     if (!d.getDie(count).getSavedDie())
                     {
                        d.getDie(count).roll();
                     }
                  }
                  player1Rolls++;
                  
                }
                
                else
                {
                  System.out.println("OUT OF ROLLS!");
                }
            }
            
            else if (userInput.equals("score"))
            {
               boolean scoreLoop = false;
               while (!scoreLoop)
               {
                  System.out.println("Select a category that you have not scored in yet:");
                  for (CategoryValue cv : CategoryValue.values())
                  {
                     if (!player1Score.checkScored(cv))
                     {
                        System.out.printf("%d: %s, %d points\n", cv.getValue() + 1, cv.toString(), player1Score.getEvaluation(cv,d));
                     }
                     else if (player1Score.getEvaluation(cv,d) == 50 
                         && player1Score.getCategoryScore(cv) > 0 && player1Score.getYahtzeeBonus() < 3)
                        {
                           System.out.println("12: YAHTZEE BONUS!!");
                        }
                  }

                  
                  try
                  {
                     int userInputScore = input.nextInt();
                     if (userInputScore < 1 || userInputScore > 13)
                     {
                        System.out.println("Please choose a valid category");
                     }
                     else
                     {
                        for (CategoryValue cv : CategoryValue.values())
                           if (userInputScore - 1 == cv.getValue() && player1Score.checkScored(cv))
                           {
                              if (cv.getValue() == 11 && player1Score.getCategoryScore(cv) > 0 
                                 && player1Score.getYahtzeeBonus() < 3 && player1Score.getEvaluation(cv,d) == 50)
                              {
                                 player1Score.choose(cv,d);
                                 System.out.println("YAHTZEE BONUS!");
                                 scoreLoop = true;
                                 player1Turn += 1;
                              }
                              else
                              {
                                 System.out.println("You already scored in that category");
                              }
                           }
                           
                           else if (userInputScore - 1 == cv.getValue())
                           {
                              player1Score.choose(cv,d);
                              System.out.printf("You scored %d points in %s\n", player1Score.getCategoryScore(cv), cv.toString());
                              scoreLoop = true;
                              player1Turn += 1;
                           }
                     }
                   }
                   catch (InputMismatchException ex)
                   {
                     System.out.println("That is not a valid category selection");
                     input.next();
                   }
               }
            }
            
            else if (userInput.equals("1"))
            {
               int dice1 = 0;
               if (!d.getDie(dice1).getSavedDie())
               {
                  d.getDie(dice1).saveDie();
               }
               else
               {
                  d.getDie(dice1).unsaveDie();
               }
            }
            
            else if (userInput.equals("2"))
            {
               int dice2 = 1;
               if (!d.getDie(dice2).getSavedDie())
               {
                  d.getDie(dice2).saveDie();
               }
               else
               {
                  d.getDie(dice2).unsaveDie();
               }
            }
            
            else if (userInput.equals("3"))
            {
               int dice3 = 2;
               if (!d.getDie(dice3).getSavedDie())
               {
                  d.getDie(dice3).saveDie();
               }
               else
               {
                  d.getDie(dice3).unsaveDie();
               }
            }
            
            else if (userInput.equals("4"))
            {
               int dice4 = 3;
               if (!d.getDie(dice4).getSavedDie())
               {
                  d.getDie(dice4).saveDie();
               }
               else
               {
                  d.getDie(dice4).unsaveDie();
               }
            }
            
            else if (userInput.equals("5"))
            {
               int dice5 = 4;
               if (!d.getDie(dice5).getSavedDie())
               {
                  d.getDie(dice5).saveDie();
               }
               else
               {
                  d.getDie(dice5).unsaveDie();
               }
            }
            
            else
            {
               System.out.printf("%s is not a valid dice value\n", userInput);
            }

         } while (player1Turn == 0);
         
         System.out.println("*** Player 2 ***");
         d2 = new DiceRoll();
         do{
            System.out.println(player2Score + "\n");
            System.out.println("******************************\n");
            System.out.println("Dice:\n" + d2);
            System.out.print("Please select a die # to toggle it between save and unsave, \"roll\" or \"score\": \n");
            String userInput = input.next().toLowerCase();
            if (userInput.equals("roll"))
            {
               if (player2Rolls < AMOUNT_OF_ROLLS)
               {
                  for (int count = 0; count < d2.getNumDice(); count++)
                  {
                     if (!d2.getDie(count).getSavedDie())
                     {
                        d2.getDie(count).roll();
                     }
                  }
                  player2Rolls++;
                }
                
                else
                {
                  System.out.println("OUT OF ROLLS!");
                }
            }
            
            else if (userInput.equals("score"))
            {
               boolean scoreLoop = false;
               while (!scoreLoop)
               {
                  System.out.println("Select a category that you have not scored in yet:");
                  for (CategoryValue cv : CategoryValue.values())
                  {
                     if (!player2Score.checkScored(cv))
                     {
                        System.out.printf("%d: %s, %d points\n", cv.getValue() + 1, cv.toString(), player2Score.getEvaluation(cv,d2));
                     }
                     else if (player2Score.getEvaluation(cv,d2) == 50 && 
                           player2Score.getCategoryScore(cv) > 0 && player2Score.getYahtzeeBonus() < 3)
                     {
                        System.out.println("12: YAHTZEE BONUS!!");
                     }

                   }
                  
                  try
                  {
                     int userInputScore = input.nextInt();
                     if (userInputScore < 1 || userInputScore > 13)
                     {
                        System.out.println("Please choose a valid category");
                     }
                     else
                     {
                        for (CategoryValue cv : CategoryValue.values())
                           if (userInputScore - 1 == cv.getValue() && player2Score.checkScored(cv))
                           {
                              if (cv.getValue() == 11 && player2Score.getCategoryScore(cv) > 0 
                                 && player2Score.getYahtzeeBonus() < 3 && player2Score.getEvaluation(cv,d2) == 50)
                              {
                                 player2Score.choose(cv,d2);
                                 System.out.println("YAHTZEE BONUS!");
                                 scoreLoop = true;
                                 player2Turn += 1;
                              }

                              else
                              {
                                 System.out.println("You already scored in that category");
                              }
                           }  
                           
                           else if (userInputScore - 1 == cv.getValue())
                           {
                              player2Score.choose(cv,d2);
                              System.out.printf("You scored %d points in %s\n", player2Score.getCategoryScore(cv), cv.toString());
                              scoreLoop = true;
                              player2Turn += 1;
                           }
                     }
                   }
                   catch (InputMismatchException ex)
                   {
                     System.out.println("That is not a valid category selection");
                     input.next();
                   }
               }
            }
            
            else if (userInput.equals("1"))
            {
               int dice1 = 0;
               if (!d2.getDie(dice1).getSavedDie())
               {
                  d2.getDie(dice1).saveDie();
               }
               else
               {
                  d2.getDie(dice1).unsaveDie();
               }
            }
            
            else if (userInput.equals("2"))
            {
               int dice2 = 1;
               if (!d2.getDie(dice2).getSavedDie())
               {
                  d2.getDie(dice2).saveDie();
               }
               else
               {
                  d2.getDie(dice2).unsaveDie();
               }
            }
            
            else if (userInput.equals("3"))
            {
               int dice3 = 2;
               if (!d2.getDie(dice3).getSavedDie())
               {
                  d2.getDie(dice3).saveDie();
               }
               else
               {
                  d2.getDie(dice3).unsaveDie();
               }
            }
            
            else if (userInput.equals("4"))
            {
               int dice4 = 3;
               if (!d2.getDie(dice4).getSavedDie())
               {
                  d2.getDie(dice4).saveDie();
               }
               else
               {
                  d2.getDie(dice4).unsaveDie();
               }
            }
            
            else if (userInput.equals("5"))
            {
               int dice5 = 4;
               if (!d2.getDie(dice5).getSavedDie())
               {
                  d2.getDie(dice5).saveDie();
               }
               else
               {
                  d2.getDie(dice5).unsaveDie();
               }
            }
            
            else
            {
               System.out.printf("%s is not a valid dice value\n", userInput);
            }

         } while (player2Turn == 0);
      }
      player1EndScore = player1Score.score(); // Variables that calculates the end score, made to add bonuses at end
      player2EndScore = player2Score.score();
      if (player1Score.scoreTop() >= 63)
      {
         System.out.println("Player 1 gets a 35 point bonus for scoring 63+ points in upper section!");
         player1EndScore += 35;
      }
      
      if (player2Score.scoreTop() >= 63)
      {
         System.out.println("Player 2 gets a 35 point bonus for scoring 63+ points in upper section!");
         player2EndScore += 35;
      }
      
      player1EndScore += (100 * player1Score.getYahtzeeBonus());
      player2EndScore += (100 * player1Score.getYahtzeeBonus());
      
      System.out.printf("Player 1 received %d points for %d Yahtzee Bonuses\n", (100 * player1Score.getYahtzeeBonus()), player1Score.getYahtzeeBonus());
      System.out.printf("Player 2 received %d points for %d Yahtzee Bonuses\n", (100 * player2Score.getYahtzeeBonus()), player2Score.getYahtzeeBonus());
      System.out.println("Player 1: " + player1EndScore);
      System.out.println("Player 2: " + player2EndScore);
      
      if (player1EndScore > player2EndScore)
      {
         System.out.println("Player 1 wins!");
      }
      
      else if (player1EndScore == player2EndScore)
      {
         System.out.println("Tie!");
      }
      
      else
      {
         System.out.println("Player 2 wins!");
      }
   }
}