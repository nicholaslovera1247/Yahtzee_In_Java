/*
Nicholas Lovera
CS2100A
Class Sixes - Sixes is a category, creates a category of Sixes
*/
public class Sixes extends Category
{
   /*
      Method evaluate for Sixes adds all the Sixes
      found in Dice d together and returns the sum
      @param Dice d, the array of die
      @return int sum, the sum of all Sixes added together
   */
   @Override
   public int evaluate(Dice d)
   {
      int sum = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         if (d.getDie(i).getValue() == 6)
         {
            sum += 6;
         }
      }
      return sum;
   }
}