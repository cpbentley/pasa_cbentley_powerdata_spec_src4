package pasa.cbentley.powerdata.spec.src4.power.integers;

import pasa.cbentley.core.src4.structs.IntToInts;
import pasa.cbentley.powerdata.spec.src4.power.IDataMorphable;
import pasa.cbentley.powerdata.spec.src4.power.IPowerDataTypes;

/**
 * Interface to a structure int[][] where keys are ordered.
 * <br>
 * Datastructure that maps a int key to a data integer while ordering the keys.
 * <br>
 * <br>
 * Similar to {@link IntToInts}.
 * <br>
 * <br>
 * Think of an optimized Run/Build {@link IntToInts}.
 * <br>
 * <br>
 * Can be sorted on the key
 * <br>
 * <br>
 * A Value = Key, Data = Value
 * <br>
 * <br>
 * 1 data maximum.
 * <br>
 * <br>
 * For storing arrays of integers to a key, use.
 * <br>
 * <br>
 * <br>
 * 
 * Similar to {@link IntToInts}
 * <br>
 * @see IPowerLinkIntToInt
 * @author Charles Bentley
 *
 */
public interface IPowerLinkOrderedIntToInt extends IDataMorphable {

   public static final int INT_ID = IPowerDataTypes.INT_27_LINK_ORDEREDINT_TO_INT;

   /**
    * Add by shifting by one all values > value, along with their associated data
    * <br>
    * <br>
    * 
    * @param value
    * @param data
    */
   public void addValueShift(int value, int data);

   /**
    * Add by shifting by one all values > value, along with their associated data
    * @param value
    */
   public void addValueShift(int value);

   /**
    * Adds/Appends a value without a data.
    * <br>
    * <br>
    * @param value
    */
   public void addValue(int value);

   /**
    * Add Value and link data to the value
    * If single data.
    * <br>
    * <br>
    * If key is already, replace value or keep old one 
    * when multiple datas, adds the data, if data is sorted, sort it.
    * <br>
    * <br>
    * 
    * @param value Must be > 1
    * @param data
    */
   public void addValue(int value, int data);

   /**
    * Returns all Values in order
    * <br>
    * <br>
    * @return
    */
   public int[] getValues();

   /**
    * Returns an array with (value:data) pairs following each other.
    * <br>
    * <br>
    *  
    * @return
    */
   public int[] getValuesDatas();

   /**
    * Number of data-value pairs.
    * <br>
    * @return
    */
   public int getSize();

   /**
    * Return the key located a the given order position.
    * <br>
    * <br>
    * In a basic array, that would return itself.
    * <br>
    * <br>
    * When keys are not particularly ordered, returns what makes sense.
    * <br>
    * <br>
    * 
    * @param count
    * @return
    */
   public int getValueFromPosition(int count);

   /**
    * Return the key's position in the (ordered) sequence.
    * <br>
    * <br>
    * @param value
    * @return between 1 and max. 0 if value not in the sequence.
    */
   public int getValueOrderCount(int value);

   /**
    * Returns the data for this value
    * @param value
    * @return
    */
   public int getData(int value);

   /**
    * Is the value key available
    * @param value
    * @return
    */
   public boolean hasValue(int value);

   /**
    * Remove the value and its datas.
    * @param value
    * @return -1 if value not present or if data = 0 of course
    */
   public int remove(int value);

   /**
    * if only space for one data, the first value in the array is saved
    * <br>
    * <br>
    * If double array, all data are saved
    * @param value
    * @param datas
    */
   public void setValueDatas(int value, int[] datas);
}
