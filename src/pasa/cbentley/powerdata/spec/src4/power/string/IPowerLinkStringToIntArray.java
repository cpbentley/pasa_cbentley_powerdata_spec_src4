package pasa.cbentley.powerdata.spec.src4.power.string;

import pasa.cbentley.powerdata.spec.src4.power.IPowerDataTypes;

public interface IPowerLinkStringToIntArray extends IPowerLinkStringToInt {

   public static final int INT_ID = IPowerDataTypes.INT_26_LINK_STRING_TO_INTARRAY;

   /**
    * Creates an entry for str if not there.
    * @param data
    * @param str
    */
   public void addIntToKeyString(int data, String str);

   /**
    * Creates an entry for chars if not there.
    * @param data
    * @param chars
    * @param offset
    * @param len
    */
   public void addIntToKeyString(int data, char[] chars, int offset, int len);

   /**
    * Default type is
    * <br>
    * When String is set
    * @param str
    * @return
    */
   public int[] getIntsFromKeyString(String str);

   /**
    * 
    * @param pointer
    * @return
    * @throws IllegalArgumentException if pointer  is not valid
    */
   public int[] getIntsFromPointer(int pointer);

   /**
    * True when data is linked to key String.
    * 
    * @param data
    * @param str
    * @return
    * @throws IllegalArgumentException if String 
    */
   public boolean isIntLinkedToKeyString(int data, String str);
}
