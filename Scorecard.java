/*
Nicholas Lovera
CS2100A Final Project
Scorecard Class: Creates a scorecard that keeps ahold of category scores and Yahtzee Bonuses of a user.
*/
import java.util.ArrayList;
public class Scorecard
{
   // instance variables
   private ArrayList<Category> scorecard;
   private int yahtzeeBonus = 0;
   // class constant
   private static final int NUM_CATS = 13;
   
   /*
      Constuctor that creates an array of our score categories
      no parameters
   */
   public Scorecard()
   {
      Ones o = new Ones();
      Twos t = new Twos();
      Threes tt = new Threes();
      Fours f = new Fours();
      Fives ff = new Fives();
      Sixes s = new Sixes();
      ThreeOfAKind toak = new ThreeOfAKind();
      FourOfAKind foak = new FourOfAKind();
      SmStraight ss = new SmStraight();
      LgStraight ls = new LgStraight();
      FullHouse fh = new FullHouse();
      FiveOfAKind ffoak = new FiveOfAKind();
      Chance c = new Chance();
      scorecard = new ArrayList<Category>(NUM_CATS);
      scorecard.add(o);
      scorecard.add(t);
      scorecard.add(tt);
      scorecard.add(f);
      scorecard.add(ff);
      scorecard.add(s);
      scorecard.add(toak);
      scorecard.add(foak);
      scorecard.add(fh);
      scorecard.add(ss);
      scorecard.add(ls);
      scorecard.add(ffoak);
      scorecard.add(c);
   }
   
   /*
      Method choose is a void method that takes a category value and dice
      and scores that category if the dice have the correct properties
      to that value. Along with adding to yahtzeeBonus if the dice properties
      equal a yahtzee, the yahtzee category has already scored in and the bonus total is less
      than 3
      @param cv the CategoryValue
      @param d the dice
   */
   public void choose(CategoryValue cv, Dice d)
   {
     { 
         if (cv.getValue() == 11 && scorecard.get(cv.getValue()).getUsed())
            {
               if (yahtzeeBonus < 3)
               {
                  yahtzeeBonus++;
               }
             }
             
          else
          {
            scorecard.get(cv.getValue()).addValue(d);
          }
      }
   }
   
   /*
      Method getEvalutation takes a CategoryValue and a Dice
      and returns the score in the category, but does not score
      in it. Used to see potential score before user scores
      @param cv the CategoryValue
      @param d the Dice
      @return The score resulting from evaluating the dice values in each
      category
   */
   public int getEvaluation(CategoryValue cv, Dice d)
   {
      return scorecard.get(cv.getValue()).evaluate(d);
   }
   
   /*
      Method checkScored returns a boolean that
      tells us if the user has scored in that
      category already
      @param cv the CategoryValue
      @return boolean indicating if the category has been
      scored in or not
   */
   public boolean checkScored(CategoryValue cv)
   {
      return scorecard.get(cv.getValue()).getUsed();
   }
   
   /*
      Method getCategoryScore takes a CategoryValue
      and returns the current score in that specific
      category
      @param cv the CategoryValue
      @return int, the score of said category
   */
   public int getCategoryScore(CategoryValue cv)
   {
      return scorecard.get(cv.getValue()).getScore();
   }
   
   /*
      Method getYahtzeeBonus is a added getter method
      different from the UML, it simply just returns
      the value of the yahtzeeBonus instance variable
      to make retrieving in other classes/main easier
      no parameters
      @return int, the value of yahtzeeBonus
   */
   public int getYahtzeeBonus()
   {
      return yahtzeeBonus;
   }
   
   /*
      Method scoreTop is a method that adds
      up all category scores for the top section
      of the scorecard and returns their sum
      no parameters
      @return int, the sum of all categories in top section
      of scorecard
   */
   public int scoreTop()
   {
      int topScore = 0;
      for (int i = 0; i < 6; i++)
      {
         topScore += scorecard.get(i).getScore();
      }
      return topScore;
   }
   
   /*
      Method scoreBottom is a method that adds up all
      the categories in the bottom section of the scorecard
      and returns their sum
      no parameters
      @return int, sum of of all categories in the bottom
      section of scorecard
   */
   public int scoreBottom()
   {
      int bottomScore = 0;
      for (int i = 6; i < scorecard.size(); i++)
      {
         bottomScore += scorecard.get(i).getScore();
      }
      return bottomScore;
   }
   
   /*
      Method score addes up the score from all the 
      categories in the scorecard and returns its sum.
      IT DOES NOT INCLUDE YAHTZEE BONUS OR UPPER SECTION
      BONUS
      no parameters
      @return int, the sum of all scores of the categories in scorecard
   */
   public int score()
   {
      int score = 0;
      for (Category c : scorecard)
      {
         score += c.getScore();
      }
      return score;
   }
   
   /*
      Method toString turns our scorecard class into a readable
      string to use for retrieving information
      no parameters
      @return String, String format
   */
   @Override
   public String toString()
   {
      String emptySpace = " ";
      String spacing = "Current Scoreca";
      String string = "";
      string += "Current Scorecard:\n";
      for (CategoryValue cv : CategoryValue.values())
      {
         int d = spacing.length() - cv.toString().length();
         string += String.format("%s%s: %d\n",(emptySpace.repeat(d)),cv.toString(),getCategoryScore(cv));
      }
      
      string += String.format("%15s: %d\n","Yahtzee Bonus",yahtzeeBonus);
      string += String.format("%15s: %d\n","Upper Total", scoreTop());
      string += String.format("%15s: %d\n","Lower Total",scoreBottom());
      string += String.format("%15s: %d","Total",score());
      return string;
   }
}