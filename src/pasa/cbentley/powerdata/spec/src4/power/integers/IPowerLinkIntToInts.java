package pasa.cbentley.powerdata.spec.src4.power.integers;

import pasa.cbentley.powerdata.spec.src4.power.IPowerDataTypes;
import pasa.cbentley.powerdata.spec.src4.power.IPowerEnum;
import pasa.cbentley.powerdata.spec.src4.power.itech.ITechIntToInts;
import pasa.cbentley.powerdata.spec.src4.power.itech.ITechPointerStruct;

public interface IPowerLinkIntToInts extends IPowerLinkIntToInt, ITechIntToInts {

   public static final int INT_ID = IPowerDataTypes.INT_29_LINK_INT_TO_INTS;

   /**
    * Add data to value's array
    * Add value for pointer, creating empty pointer recipients between last used pointer
    * and given pointer
    * i.e you can add 1000,value to an empty double array. it will created 999 pointers
    * <br>
    * 
    * Depending on {@link ITechIntToInts#ITIS_FLAG_2_DUPLICATES}
    * 
    *  data is or it not added
    * 
    * Create entry if unknown key
    * 
    * @param value 0 <= pointer
    * @param value an integer
    */
   public void addValueToKey(int value, int key);

   /**
    * Enumerates over non null arrays for instance.
    * <li> Iterates over array of length Param
    * <li> Iterates over arrays
    * @param type
    * @param param
    * @return
    */
   public IPowerEnum getEnu(int type, Object param);

   /**
    * Removes old values
    * @param values
    * @param key
    */
   public void setValuesForKey(int[] values, int key);

   /**
    * 
    * @param value
    * @param key
    * @return -1 if key does not have that value
    */
   public int getIndexOfValueFromKey(int value, int key);

   public boolean isValueBelongToKey(int value, int key);

   /**
    * 
    * @param values
    * @param key
    */
   public void addValuesToKey(int[] values, int key);

   /**
    * Return the array linked to pointer.
    * Some implementations might return an inner reference, not a copy.
    * <br>
    * In Those case, the flag {@link ITechPointerStruct#PS_FLAG_6_REFERENCE}
    * <br>
    * Returns null or an empty array depending on tech
    * @param key
    * @return
    */
   public int[] getKeyValues(int key);

   /**
    * 
    * @param keys
    * @return
    */
   public int[] getKeysValues(int[] keys);

   /**
    * Returns the value at index. 0 being the first
    * <br>
    * 
    * @param pointer
    * @param index
    * @return
    * @throws ArrayIndexOutOfBoundsException
    */
   public int getKeyValue(int pointer, int index);

   /**
    * Remove the linked array to pointer. but does not remove the pointer itself.
    * <br>
    * Calling get on the key will return null.
    * @param key
    * @return number of elements removed
    */
   public int removeKeyValues(int key);

   /**
    * The number of datas at pointer
    * @param key
    * @return
    */
   public int getNumValuesFromKey(int key);

   /**
    * if data exists, remove all data instances in the data array
    * @param data
    */
   public void removeValueFromKey(int value, int key);
}
