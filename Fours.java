/*
Nicholas Lovera
CS2100A
Class Fours - Fours is a category, creates a category of Fours
*/
public class Fours extends Category
{
   /*
      Method evaluate for Fours adds all the
      Fours found in Dice d together and returns
      the sum
      @param Dice d, the array of die
      @return int sum, the sum of all Fours added together
   */
   @Override
   public int evaluate(Dice d)
   {
      int sum = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         if (d.getDie(i).getValue() == 4)
         {
            sum += 4;
         }
      }
      return sum;
   }
}