package pasa.cbentley.powerdata.spec.src4.power.string;

import pasa.cbentley.core.src4.structs.IntToStrings;
import pasa.cbentley.powerdata.spec.src4.power.IDataMorphable;
import pasa.cbentley.powerdata.spec.src4.power.IPowerCharCollector;
import pasa.cbentley.powerdata.spec.src4.power.IPowerDataTypes;
import pasa.cbentley.powerdata.spec.src4.power.IPowerEnum;
import pasa.cbentley.powerdata.spec.src4.power.itech.ITechStringLinker;

/**
 * Maps a String to an integer which both can be retrieved with a pointer. It is basically the interface of {@link IntToStrings}
 * <br>
 * But the goal is to apply it to a Trie implementation with pointer stability.
 * <br>
 * Optionally the String can be retrieved using a pointer.
 * Some {@link IPowerLinkStringToInt} may not accept the null value as well as the "" string value.
 * <br>
 * <br>
 * How do you enumerate the Strings?
 * <li> You morph it to an {@link IntToStrings}
 * <li> 
 * <br>
 * <br>
 * Can morph into a char collector?
 * @author Charles Bentley
 *
 */
public interface IPowerLinkStringToInt extends IDataMorphable, ITechStringLinker {
   public static final int INT_ID                 = IPowerDataTypes.CLASS_TYPE_91_STRING_TO_INT;

   public static final int ENUM_TYPE_0_STRINGS    = IPowerCharCollector.ENUM_TYPE_0_STRING;

   public static final int ENUM_TYPE_1_POINTER    = IPowerCharCollector.ENUM_TYPE_1_POINTER;

   /**
    * 
    */
   public static final int ENUM_TYPE_2_CHARS      = IPowerCharCollector.ENUM_TYPE_2_CHARS;

   /**
    * Same as {@link IPowerCharCollector#ENUM_TYPE_3_INTSTRINGS}
    * <br>
    * Integers are pointers
    */
   public static final int ENUM_TYPE_3_INTSTRINGS = IPowerCharCollector.ENUM_TYPE_3_INTSTRINGS;

   /**
    * Enumeration on the data
    */
   public static final int ENUM_TYPE_6_INT_DATE   = 6;


   /**
    * Enumeration on the Strings
    * <li> when param is null Enumeration on the pointers
    * <li> Integer.class then Enumeration on Integer
    * <li> String.class Enumeration on Strings
    * @param type TODO
    * @return
    */
   public IPowerEnum getEnumOnLinkStringToInt(int type, Object param);

   /**
    * Returns the value store at the pointer
    * @param pointer
    * @return int value
    * @throws IllegalArgumentException
    */
   public int getIntFromPointer(int pointer);

   /**
    * The number of links.
    * <br>
    * <br>
    * 
    * @return
    */
   public int getSize();

   /**
    * Returns the Key internally used to link 
    * @param pointer valid pointer from {@link IPowerLinkStringToInt#getPointerFromKeyString(String)}
    * @return
    */
   public String getKeyStringFromPointer(int pointer);

   /**
    * 
    * @param c
    * @param offset
    * @param len
    * @return
    */
   public int getIntFromKeyString(char[] c, int offset, int len);

   /**
    * 
    * @param s
    * @return 
    * @throws IllegalArgumentException if String not there
    */
   public int getIntFromKeyString(String s);

   /**
    * Returns the internal unique ID of the String inside the structure.
    * <br>
    * @param str
    * @return {@link IPowerCharCollector#CHARS_NOT_FOUND}
    */
   public int getPointerFromKeyString(String str);

   /**
    * Returns the reference to the structure that contains the Strings.
    * <br>
    * @return
    */
   public Object getStringStructure();

   /**
    * True if string is inside {@link IPowerLinkStringToInt} as a key
    * @param str
    * @return
    */
   public boolean hasKeyString(String str);

   /**
    * Does nothing if String is not in the structure.
    * Returns the pointer
    * @param incr
    * @param c
    * @param offset
    * @param len
    * @return
    * @throws IllegalArgumentException if String not there
    */
   public int incrementIntFromKeyString(int incr, char[] c, int offset, int len);

   /**
    * Increment the value stored at String.
    * <br>
    * <br>
    * @param incr
    * @param s
    * 
    * @return value incremented
    * @throws IllegalArgumentException if String not there
    */
   public int incrementIntFromKeyString(int incr, String s);

   /**
    * Stores the value at the string of characters.
    * Replaces the old value.
    * <br>
    * If String is not there, creates a new entry for it.
    * <br>
    * <br>
    * 
    * @param data
    * @param c
    * @param offset
    * @param len
    * @return
    */
   public int linkIntToKeyString(int data, char[] c, int offset, int len);

   /**
    * Stores the value at String.
    * @param data
    * @param s
    * @return a valid pointer
    */
   public int linkIntToKeyString(int data, String s);

   /**
    * Remove the link
    * @param str
    */
   public void removeKeyString(String str);
}
