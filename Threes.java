/*
Nicholas Lovera
CS2100A
Class Threes - Threes is a category, creates a category of Threes
*/
public class Threes extends Category
{
   /*
      Method evaluate for Threes adds all the 
      Threes in Dice d and returns their sum
      @param Dice d, the array of die
      @return int sum, the sum of all Threes added together
   */
   @Override
   public int evaluate(Dice d)
   {
      int sum = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         if (d.getDie(i).getValue() == 3)
         {
            sum += 3;
         }
      }
      return sum;
   }
}