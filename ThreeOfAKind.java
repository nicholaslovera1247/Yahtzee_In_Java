/*
Nicholas Lovera
CS2100A
Class ThreeOFAKind - ThreeOFAKind is a category, creates a category of ThreeOFAKind
*/
public class ThreeOfAKind extends Category
{
   /*
      Method evaluate for ThreeOfAKind checks
      Dice d for 3 of the same value die
      @param Dice d, the array of die
      @return int score, if there is 3 of a kind
      in the dice then it will return the sum of ALL
      the dice, if not it will return 0
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = 0;
      boolean found = false;
      for (int n = 1; n <= 6 && !found; n++)
      {
         if (d.count(n) >= 3)
         {
            score += d.sum();
            found = true;
         }
      }
      return score;
   }
}