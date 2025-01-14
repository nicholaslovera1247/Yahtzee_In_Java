/*
Nicholas Lovera
CS2100A
Class FullHouse - FullHouse is a category, creates a category of FullHouse
*/
public class FullHouse extends Category
{
   /*
      Method evaluate for FullHouse checks
      Dice d for a Full House (Two of the same value die and 
      three of the same value die in the same roll(array))
      @param Dice d, the array of die
      @return int 25 or 0, returns 25 if there is a Full
      House, 0 if not.
   */
   @Override
   public int evaluate(Dice d)
   {
      boolean sameTwo = false;
      boolean sameThree = false;
      
      for (int i = 1; i <= 6; i++)
      {
         int count = d.count(i);
         if (count == 2)
         {
            sameTwo = true;
         }
         
         else if (count == 3)
         {
            sameThree = true;
         }
      }
      
      if (sameTwo && sameThree)
      {
         return 25;
      }
      
      return 0;
   }
}
