/*
Nicholas Lovera
CS2100A
Class Ones - Is a category, creates a category of Ones
*/
public class Ones extends Category
{
   /*
      Method evaluate for Ones counts the amount
      of ones in Dice d and adds them together
      @param Dice d, the array of die
      @return int sum, the sum of all Ones added together
   */
   @Override
   public int evaluate(Dice d)
   {
      int sum = 0;
      for(int i = 0; i < d.getNumDice();i++)
      {
         if(d.getDie(i).getValue()==1)
         {
            sum += 1;
         }
      }
      return sum;
   }
}