package pasa.cbentley.powerdata.spec.src4.power.integers;

import pasa.cbentley.powerdata.spec.src4.power.IPowerDataTypes;

/**
 * 
 * @author Charles Bentley
 *
 */
public interface IPowerIntArrayOrdered extends IPowerIntArray {

   
   public static final int INT_ID = IPowerDataTypes.INT_27_LINK_ORDEREDINT_TO_INT;

   /**
    * Return the value located a the given count position.
    * <br>
    * <br>
    * 
    * @param count
    * @return Integer.MAX_VALUE when not found
    */
   public int getValueFromPosition(int count);

   /**
    * Return the value's position in the (ordered) sequence
    * <br>
    * <br>
    * @param value
    * @return between 1 and max. 0 if value not in the sequence.
    */
   public int getValueOrderCount(int value);
   
}
