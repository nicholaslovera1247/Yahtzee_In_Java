/*
Nicholas Lovera
CS2100A
Class Die - Creates an indivdual Die
*/
import java.util.Random;
public class Die
{
   // Instance Variables
   private int value;
   private boolean save = false;
   // Class Constant
   private static final int SIDES = 6;
   // Class Variable
   private static final Random r = new Random();
   
   /*
      Standard Constructor
      Assigns a random value to a die from a range of 1 - 6
   */
   public Die()
   {
      value = r.nextInt(SIDES) + 1;
   }
   
   /*
      Method roll takes no parameters and returns nothing
      Just reassigns an die value to another random value
      from 1 - 6
      no parameters
   */
   public void roll()
   {
      value = r.nextInt(SIDES) + 1;
   }
   
   /*
      Method getValue takes no parameters and returns the
      value of the die
   */
   public int getValue()
   {
      return value;
   }
   
   /*
      Method saveDie is a setter method, when invoked
      it sets our instance variable save to true, which says the
      die is saved
      no parameters
   */
   public void saveDie()
   {
      save = true;
   }
   
   /*
      Method unsaveDie is a setter method, when invoked
      it sets our instance variable save to false, which says the
      die is now unsaved
      no parameters
   */
   public void unsaveDie()
   {
      save = false;
   }
   
   /*
      Method getSavedDie is a getter method that returns the
      boolean value of save, returns true if the die is saved, false
      if it is not saved
      no parameters
      @return boolean save, boolean value of our save instance
      variable
   */
   public boolean getSavedDie()
   {
      return save;
   }
   
   /*
      Method toString formats our die value into a readable string
      no parameters
      @return String String.format, readable value of our die
   */
   @Override
   public String toString()
   {
      return String.format("%d",value);
   }
   
}

