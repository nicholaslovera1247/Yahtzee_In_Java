/*
Nicholas Lovera
CS2100A
DiceRoll Class - Is a Dice, creates a Dice and adds new Die to it, and has a method to toss said die
*/
public class DiceRoll extends Dice
{
   // Class Constant
   private static final int NUM_DIE = 5;
   
   /*
      Standard Constructor
      Uses our super constructor to make a new Dice with the range or NUM_DIE
      and then adds new Die to the die ArrayList made from the super constructor using
      our super addDie method
   */
   public DiceRoll()
   {
      super(NUM_DIE);
      for (int i = 0; i < NUM_DIE; i++)
      {
         super.addDie(new Die());
      }
   }
   
   /*
      Method toss takes no parameters and returns nothing,
      it just iterates through our die ArrayList and rolls each
      die.
   */
   public void toss()
   {
      int count = super.getNumDice();
      for (int i = 0; i < count; i++)
      {
         super.getDie(i).roll();
      }
   }
}