/*
Nicholas Lovera
CS2100A
Class Chance - Chance is a category, creates a category of Chance
*/
public class Chance extends Category
{
   /*
      Method evaluate for Chance adds all of
      the die in Dice d and returns the sum
      @param Dice d, the array of dice
      @return int d.sum(), the sum of all of the
      die added together
   */
   @Override
   public int evaluate(Dice d)
   {
      return d.sum();
   }
}