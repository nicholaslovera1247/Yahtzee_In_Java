/*
Nicholas Lovera
CS2100A
Class FiveOfAKind - FiveOfAKind is a category, creates a category of FiveOfAKind
*/
public class FiveOfAKind extends Category
{
   /*
      Method evaluate for FiveOfAKind checks for
      Five of a Kind(a Yahtzee) in Dice d
      @param Dice d, the array of die
      @return int score, returns the value of score
      score will equal 50 if there is Five of a Kind
      (Yahtzee), and equal 0 if not.
   */
   @Override
   public int evaluate(Dice d)
   {
      int score = 0;
      boolean found = false;
      
      for (int n = 1; n <= 6 && !found; n++)
      {
         if (d.count(n) == 5)
         {
            score += 50;
            found = true;
         }
      }
      return score;
   }
}
