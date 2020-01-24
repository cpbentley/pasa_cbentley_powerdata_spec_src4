package pasa.cbentley.powerdata.spec.src4.power.integers;

import pasa.cbentley.powerdata.spec.src4.power.IDataMorphable;
import pasa.cbentley.powerdata.spec.src4.power.IPowerDataTypes;
import pasa.cbentley.powerdata.spec.src4.power.itech.ITechPointerStruct;

/**
 * Simple interface for storing a single integer to another single integer.
 * <br>
 * <br>
 * Nothing else.
 * <br>
 * <br>
 * The Rolls Royce is the {@link IPowerLinkOrderedIntToInt}.
 * 
 * @author Charles Bentley
 *
 */
public interface IPowerLinkIntToInt extends IDataMorphable {

   public static final int INT_ID = IPowerDataTypes.INT_28_LINK_INT_TO_INT;

   /**
    * Returns an invalid value.
    * <br>
    * When a key was never used to set data with
    * {@link IPowerLinkIntToInt#setKeyData(int, int)}
    * 
    * returns a default value.
    * <br>
    * @param key
    * @return
    * @throws IllegalArgumentException when key is outside the range defined by
    * {@link ITechPointerStruct#PS_OFFSET_04_START_POINTER4}
    * {@link ITechPointerStruct#PS_OFFSET_05_END_POINTER4}
    * 
    */
   public int getKeyData(int key);

   /**
    * Sets the data for the integer key
    * Never fires an exception
    * @param key
    * @param data
    */
   public void setKeyData(int key, int data);

   /**
    * True when key is currently in use.
    * @param key
    * @return
    */
   public boolean isValidKey(int key);

   /**
    * Size of the current valid interval
    * @return
    */
   public int getSize();
}
