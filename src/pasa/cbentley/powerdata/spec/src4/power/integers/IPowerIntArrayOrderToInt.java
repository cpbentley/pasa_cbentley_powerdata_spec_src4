package pasa.cbentley.powerdata.spec.src4.power.integers;

import pasa.cbentley.core.src4.structs.IntToInts;
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
public interface IPowerIntArrayOrderToInt extends IPowerIntArrayOrdered {

   public static final int INT_ID = IPowerDataTypes.INT_27_LINK_ORDEREDINT_TO_INT;

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

   public void addValueShift(int value, int data);

   public void addValueShift(int value);

   /**
    * Returns an array with (value:data) pairs following each other.
    * <br>
    * <br>
    *  
    * @return
    */
   public int[] getValuesDatas();

   /**
    * Returns the data for this value
    * @param value
    * @return
    */
   public int getData(int value);

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
