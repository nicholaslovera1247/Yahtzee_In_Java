/*
Nicholas Lovera
CS2100A
Class FourOfAKind - FourOfAKind is a category, creates a category of FourOfAKind
*/
public class FourOfAKind extends Category
{
   /*
      Method evaluate for FourOfAKind checks
      Dice d for four of the same value die
      @param Dice d, the array of die
      @return int score, if there is 4 of a kind
      in the array of dice then it will be the sum of ALL
      the dice together, if not it will be zero
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = 0;
      boolean found = false;
      for (int n = 1; n <= 6 && !found; n++)
      {
         if (d.count(n) >= 4)
         {
            score += d.sum();
            found = true;
         }
      }
      return score;
   }
}