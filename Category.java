/*
Nicholas Lovera
CS2100A
Category Class - Category is an abstract category that uses an abstract method 
to evaluate each category in CategoryValue, add specific value to each category
and indicate if each category has been used or not
*/
abstract class Category
{
   // instance variables
   private int score;
   private boolean used = false;
   
   /*
      Abstract Method Evaluate is a method that takes an
      array of dice and evaulatues what the score would be
      in each category
      @param dice d, the array of dice
   */
   public abstract int evaluate(Dice d);
   
   /*
      Method addValue is a setter method that takes an array of
      dice and calls our abstract method Evaluate, and sets the category score
      to the value produced by evaluate(d) and sets the used boolean to true
      to indicate that the category has been used
      @param Dice d, the array of dice
   */
   public void addValue(Dice d)
   {
      score = evaluate(d);
      used = true;
   }
   
   /*
      Method getScore is a getter method that just
      returns the score of said category
      no parameters
      @return int score, the score of the category
   */
   public int getScore()
   {
      return score;
   }
   
   /*
      Method getUsed is a getter method that just
      returns the boolean of used, if the category is
      used, it returns true, if not, it returns false
      no parameters
      @return boolean used, if the category has been used or not
   */
   public boolean getUsed()
   {
      return used;
   }
}
