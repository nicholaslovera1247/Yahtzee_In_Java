/*
Nicholas Lovera
CS2100A
Class SmStraight - SmStraight is a category, creates a category of SmStraight
*/
import java.util.ArrayList;
public class SmStraight extends Category
{
   /*
      Method evaluate for SmStraight checks
      if there is a Small Straight in Dice d
      @param Dice d, the array of die
      @return int 30 or 0, if there is a Small Straight
      evaluate returns 30, if not, it returns 0
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
      
      boolean smallStraight = 
      (order.contains(1) && order.contains(2) && order.contains(3) && order.contains(4)) ||
      (order.contains(2) && order.contains(3) && order.contains(4) && order.contains(5)) ||
      (order.contains(3) && order.contains(4) && order.contains(5) && order.contains(6));
      
      if (smallStraight)
      {
         return 30;
      }
      
      else
      {
         return 0;
      }
      
   }
}
