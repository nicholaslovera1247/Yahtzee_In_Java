/*
Nicholas Lovera
CS2100A
Class Twos - Twos is a category, creates a category for Twos
*/
public class Twos extends Category
{
   /*
      Method evaluate for Twos counts all the Twos in
      Dice d and returns the sum of all the Twos added
      together
      @param Dice d, the array of die
      @return int sum, the sum of all Twos added together
   */
   @Override
   public int evaluate(Dice d)
   {
      int sum = 0;
      for(int i = 0; i < d.getNumDice(); i++)
      {
         if(d.getDie(i).getValue() == 2)
         {
            sum += 2;
         }
      }
      return sum;
   }
}