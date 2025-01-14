/*
Nicholas Lovera
CS2100A
Class LgStraight - LgStraight is a category, creates a category of LgStraight
*/
import java.util.ArrayList;
public class LgStraight extends Category
{
   /*
      Method evaluate for LgStraight checks
      Dice d for a Large Straight
      @param Dice d, the array of die
      @return int 40 or 0, 40 if there is a 
      Large Straight, 0 if not
   */
   @Override
   public int evaluate(Dice d)
   {
      ArrayList<Integer> order = new ArrayList<>();
      
      for (int i = 0; i < d.getNumDice(); i++)
      {
         int value = d.getDie(i).getValue();
         order.add(value);
      }
      
      boolean largeStraight =
         (order.contains(1) && order.contains(2) && order.contains(3) && order.contains(4) && order.contains(5)) ||
         (order.contains(2) && order.contains(3) && order.contains(4) && order.contains(5) && order.contains(6));
         
      if (largeStraight)
      {
         return 40;
      }
      
      else
      {
         return 0;
      }
   }
}