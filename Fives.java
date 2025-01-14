/*
Nicholas Lovera
CS2100A
Class Fives - Fives is a category, creates a category of Fives
*/
public class Fives extends Category
{
   /*
      Method evaluate for Fives adds all the Fives
      found in Dice d and returns their sum
      @param Dice d, the array of die
      @return int sum, the sum of all Fives added together
   */
   @Override
   public int evaluate(Dice d)
   {
      int sum = 0;
      for (int i = 0; i < d.getNumDice(); i++)
      {
         if (d.getDie(i).getValue() == 5)
         {
            sum += 5;
         }
      }
      return sum;
   }
}