package pasa.cbentley.powerdata.spec.src4.power;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.core.src4.helpers.StringBBuilder;
import pasa.cbentley.powerdata.spec.src4.guicontrols.IPrefixSearchSession;
import pasa.cbentley.powerdata.spec.src4.guicontrols.ISearchSession;
import pasa.cbentley.powerdata.spec.src4.power.itech.ITechCharCol;
import pasa.cbentley.powerdata.spec.src4.power.itech.ITechPointerStruct;

/**
 * Class that associates a char[] array to a integer pointer or handle. The pointer domain and topology is unknown a priori.
 * <br>
 * <br>
 * <li> {@link IPowerCharCollector#addChars(char[], int, int)} 
 * <li> {@link IPowerCharCollector#addChars(String)} 
 * <br>
 * Method return an integer handle.
 * <br>
 * <br>
 * This value allows for later retrieving 
 * <li> {@link IPowerCharCollector#getChars(int)} the characters
 * <li> {@link IPowerCharCollector#getChar(int)} first character
 * <li> {@link IPowerCharCollector#getLen(int)} the length of the string of characters.
 * <li> 
 * <br>
 * <br>
 * 
 * @see ITechCharCol
 * @see ITechPointerStruct
 * @author Charles Bentley
 *
 */
public interface IPowerCharCollector extends IDataMorphable {

   public static final int INT_ID                 = IPowerDataTypes.INT_22_CHAR_COLLECTOR;

   /**
    * Value returned when pointer is invalid or when a string cannot be found
    */
   public static final int CHARS_NOT_FOUND        = Integer.MAX_VALUE;

   public static final int ENUM_TYPE_0_STRING     = 0;

   public static final int ENUM_TYPE_1_POINTER    = 1;

   public static final int ENUM_TYPE_2_CHARS      = 2;

   /**
    * String and its pointer
    */
   public static final int ENUM_TYPE_3_INTSTRINGS = 3;

   /**
    * 
    */
   public static final int INVALID_POINTER        = -1;

   /**
    * Add the characters and return a pointer handle for later retrieving it
    * <br>
    * <br>
    * The char data is fully copied. The reference array is not used.
    * <br>
    * <br>
    * Returns the pointer at which the chars can be retrieved just after the call.
    * <br>
    * <br>
    * This value is valid in the future if structure has pointer stability.
    * <br>
    * <br>
    * If the characters are already in the structure? It depends on the implementation
    * checking for duplicates. A tech param is present when this option is possible.
    * <br>
    * <br>
    *   
    * @param c
    * @param offset
    * @param len
    * @return
    */
   public int addChars(char[] c, int offset, int len);

   /**
    * For all complicated searches.
    * <br>
    * <li> {@link IPowerCharCollector#find(char[], int, int)}
    * <li> {@link IPowerCharCollector#hasChars(char[], int, int)}
    * <br>
    * If implementation class does not support the type of search, response include flag saying so.
    * <br>
    * <br>
    * The method is used in order to keep the API simple. It makes future modifications to the search
    * mechanism much easier and does not break the code.
    * The implementation will do its best searching and will flag if some parameters were not used because
    * the implementation is not able to process it.
    * <br>
    * <br>
    * 
    * @param css
    */
   //public void search(CharSearchSession css);

   /**
    * 
    * Opens a Search of type {@link ITechCharCol#SEARCH_1_INDEXOF}
    * <br>
    * Convenience API method.
    * @param frame size of results per search. 0 for everything
    * @return
    */
   public ISearchSession searchIndexOf(int frame);

   /**
    * Opens a Search of type {@link ITechCharCol#SEARCH_0_PREFIX}
    * <br>
    * Convenience API method.
    * <br>
    * Some {@link IPowerCharCollector} will be optimized for fast prefix searches.
    * <br>
    * @param frame size of results per search. 0 for everything
    * @return
    */
   public IPrefixSearchSession searchPrefix(int frame);

   /**
    * Generic Open Search
    * @param param
    * @return
    */
   public ISearchSession search(ByteObject param);

   /**
    * Same as {@link IPowerCharCollector#addChars(char[], int, int)}
    * <br>
    * <br>
    * 
    * @param s
    * @return
    */
   public int addChars(String s);

   /**
    * Copies the characters found at pointer inside character array starting at offset
    * <br>
    * <br>
    * Return the number of characters copied, i.e. the length of the string at the given pointer.
    * <br>
    * <br>
    * @param pointer
    * @param c
    * @param offset position to start copy
    * @return
    * @throws ArrayIndexOutOfBoundsException when char[] is not big enough
    */
   public int copyChars(int pointer, char[] c, int offset);

   /**
    * Find pointer for the given characters. Equality check is done for each character value.
    * <br>
    * <br>
    * @param str
    * @param offset
    * @param len
    * @return the pointer or  {@link IPowerCharCollector#CHARS_NOT_FOUND}
    */
   public int find(char[] str, int offset, int len);

   /**
    * The first character stored at that pointer handle.
    * <br>
    * <br>
    * 
    * @param pointer
    * @return
    * @throws IllegalArgumentException when pointer is invalid
    */
   public char getChar(int pointer);

   /**
    * Get the chars for the given handle
    * <br>
    * <br>
    * Implementation may return its own reference. thus modifying may lead to corruption of the {@link IPowerCharCollector}.
    * <br>
    * <br>
    * If implementation, {@link ITechCharCol#CHARCOL_FLAG_6_SINGLE_PLANE}
    * @param pointer pointer >= 1
    * @return empty array
    */
   public char[] getChars(int pointer);

   /**
    * Same as {@link IPowerCharCollector#getChars(int)} but appends them.
    * <br>
    * <br>
    * 
    * @param pointer
    * @param sb
    */
   public void appendChars(int pointer, StringBBuilder sb);

   /**
    * Return an array of character filled with all the strings found at the given pointers.
    * <br>
    * <br>
    * 
    * @param pointers array of pointer/handles
    * @return array
    */
   public char[] getChars(int[] pointers);

   /**
    * Returns the length of the string located at the pointer handle.
    * <br>
    * <br>
    * @param pointer
    * @return
    */
   public int getLen(int pointer);

   /**
    * Returns the number of characters of the longest char array.
    * <br>
    * Provides a buffer max limit when creating a char array.
    * <br>
    * <br>
    * 
    * @return
    */
   public int getBiggestWordSize();

   /**
    * Looks for Chars in the collector and return the handle for it.
    * <br>
    * <br>
    * @param chars
    * @return {@link IPowerCharCollector#CHARS_NOT_FOUND} when input chars are not in the collector
    */
   public int getPointer(char[] chars);

   /**
    * 
    * @param str
    * @return {@link IPowerCharCollector#CHARS_NOT_FOUND}
    */
   public int getPointer(String str);

   /**
    * Returns the ID/Pointer within the {@link IPowerCharCollector} for given the word.
    * <br>
    * @param word
    * @param offset
    * @param len
    * @return {@link IPowerCharCollector#CHARS_NOT_FOUND} if not found
    */
   public int getPointer(char[] chars, int offset, int len);

   /**
    * Return the number of words;
    * @return
    */
   public int getSize();

   /**
    * Constraint on Pointer?
    * @param pointer
    * @return
    */
   public String getKeyStringFromPointer(int pointer);

   /**
    * Returns an {@link IPowerEnum}.
    * <br>
    * The {@link IPowerEnum} can be parametrized before the first call
    * <br>
    * <li> {@link IPowerCharCollector#ENUM_TYPE_0_STRING}
    * <li> {@link IPowerCharCollector#ENUM_TYPE_1_POINTER}
    * <li> {@link IPowerCharCollector#ENUM_TYPE_2_CHARS}
    * <li> {@link IPowerCharCollector#ENUM_TYPE_3_INTSTRINGS}
    * <br>
    * <br>
    * 
    * @param type {@link IPowerCharCollector#ENUM_TYPE_0_STRING}
    * @param Object
    * @return
    */
   public IPowerEnum getEnumOnCharCol(int type, Object param);

   /**
    * Is the string defined by the array stored in the {@link IPowerCharCollector}.
    * <br>
    * <br>
    * Syntactic sugar / Shortcut to {@link IPowerCharCollector#find(char[], int, int)}
    * <br>
    * <br>
    * 
    * @param c
    * @param offset
    * @param len
    * @return
    */
   public boolean hasChars(char[] c, int offset, int len);

   /**
    * 
    * @param str
    * @return
    */
   public boolean hasChars(String str);

   /**
    * An array describing the different sizes of strings in this {@link IPowerCharCollector}.
    * <br>
    * 
    * <li>int[1][0] gives you the number of 1 sized strings
    * <li>int[1][1...k1] contains an array with pointers to all 1 sized strings, except for the first value.
    * <li>...
    * <li>int[n][0] gives you the number of n sized strings
    * <li>int[n][1...kn] contains an array with pointers to all n sized strings, except for the first value.
   
    * @return
    */
   public int[][] getSizes();

   /**
    * Is the pointer pointing to some chars?
    * <br>
    * <br>
    * @param pointer
    * @return
    */
   public boolean isValid(int pointer);

   /**
    * Remove the chars pointed by pointer. if use force, defragment memory space used by chars.
    * <br>
    * <br>
    * @param pointer
    * @param useForce possibly be ignored.
    * @return
    */
   public int remove(int pointer, boolean useForce);

   /**
    * Sets a new char array.
    * <br>
    * This method will not work on unstable pointers char collectors where
    * <br>
    * The array in input is not used by the structure.
    * @param pointer
    * @param d
    * @param offset
    * @param len
    * @return -1 if the pointer could not be updated due to structural design
    */
   public int setChars(int pointer, char[] d, int offset, int len);

   /**
    * Adds the {@link IPointerUser} to the call back list. It will be called when pointers are changed.
    * <br>
    * <br>
    * When a change is made that modifies the pointer structure, the {@link IPowerCharCollector}
    * calls {@link IPointerUser#updatePointers(Object, Object)} where Object is a mapping between old and new pointer.
    * <br>
    * <br>
   
    * @param pointerUser
    */
   public void addPointerUser(IPointerUser pointerUser);

}
