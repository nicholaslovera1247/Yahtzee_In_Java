/*
Nicholas Lovera
CS2100A
Dice Class - Creates an ArrayList of Die along with different methods to see
how many of a certian die are in the array, getters and setters, what certain die
the array has
*/
import java.util.ArrayList;
public class Dice
{
   // Instance variable
   private ArrayList<Die> die;
   // Class Variable
   private static final int DEF_CAP = 5;
   
   /*
      Standard Constructor
      Fills our array list with DEF_CAP amount of die
      no parameters
   */
   public Dice()
   {
      die = new ArrayList<Die>(DEF_CAP);
   }
   
   /*
      Alternate Constructor
      Fills our die array with int num amount of die
      @params int num, an integer
   */
   public Dice(int num)
   {
      die = new ArrayList<Die>(num);
   }
   
   /*
      Method addDie adds a Die d to our die array
      @params Die d, a Die value
   */
   public void addDie(Die d)
   {
      die.add(d);
   }
   
   /*
      Method getNumDice returns the size of our die array
      no parameters
      @return int die.size(), a number representing our array size
   */
   public int getNumDice()
   {
      return die.size();
   }
   
   /*
      method getDie takes an integer i and returns what Die is at index i
      @params int i, an integer
      @return Die die.get(i), the Die in our die array at index i
   */
   public Die getDie(int i)
   {
      return die.get(i);
   }
   
   /*
      Method removeDie takes an integer i and removes the Die at that index
      @params int i, an integer
      @return Die die.remove(i), the die removed at from our die array at index i
   */
   public Die removeDie(int i)
   {
      die.remove(i);
      return die.remove(i);
   }
   
   /*
      Method count takes an integer val, makes a new arrayList valDie, and adds
      every Die in our die array to valDie if it has the same value as int val. 
      After it has gone through the die array, it returns the size
      of our valDie arrayList, telling us how many die of that value are in the die arrayList
      @params int val, an integer
      @return int valDie.size(), the size of our valDie arrayList, showing
      how many die with the value of int val are in the die array
   */
   public int count(int val)
   {
      ArrayList<Die> valDie = new ArrayList<Die>();
      for (Die d : die)
      {
         if (d.getValue() == val)
         {
            valDie.add(d);
         }
      }
      return valDie.size();  
   }
   
   /*
      Method sum takes no parameters and returns the sum of all the die
      in our die arrayList
      no parameters
      @return int sum, the sum of all the die in our die arrayList
   */
   public int sum()
   {
      int sum = 0;
      for (Die d : die)
      {
         sum += d.getValue();
      }
      
      return sum;
   }
   
   /*
      Method contains takes an int, val, and reads through our die arrayList
      For each die that has the same value as int val, it adds 1 to an integer named count
      If count >= 1, then the method will return a boolean true that says that the die arrayList
      contains at least one of those die, if it is less then 1, then it returns boolean false
      flagging that the die arrayList does not contain at least one of those die
      @param int val, an integer
      @return boolean true if there are at least 1 die with the same value as int val
      false if there is not
   */
   public boolean contains(int val)
   {  
      int count = 0;
      for (Die d : die)
      {
         if (d.getValue() == val)
         {
            count += 1;
         }
      }
      
      if (count >= 1)
      {
         return true;
      }
      
      else
      {
         return false;
      }
   }
   
   /*
      Method toString returns a string of the value of each our die in the die ArrayList
      If the die is saved (determined by our getSavedDie() method in die) then the toString
      will print an additonal SAVE keyword at the end of the line indicating the die is saved, if not
      it will just print the place of the die in the array plus 1, and the value of the die
      No parameters
      @return String string, our die arrayList information in a string
   */
   @Override
   public String toString()
   {
      String string = "";
      for (Die d : die)
      {
         int numberDie = die.indexOf(d) + 1;
         if (d.getSavedDie())
         {
            string += String.format("%d: value %d     SAVE\n",numberDie, d.getValue());
         }
         else
         {
            string += String.format("%d: value %d\n", numberDie, d.getValue());
         }
      }
      return string;
      
   }
   
}
