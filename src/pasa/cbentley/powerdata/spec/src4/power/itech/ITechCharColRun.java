package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.core.ByteObjectManaged;

/**
 * Specifies the {@link ByteObjectManaged} collecting char for {@link CharCollectorRunLight}.
 * <br>
 * <br>
 * integer -> string linking
 * <br>
 * <br>
 * 
 * Accept only characters from a single plane (0 latin, 1 greek, 4 ciryllic)
 * <br>
 * <br>
 * 
 * DATA IMPLEMENTATION
 * <br>
 * 
 * These two integer sequences (the first/all letters)  are located by the. Outside of our byte array
 * <br>
 * <br>
 * [start letters IntOSequenceTable] : Tracks the first letters : 
 * <br>
 * [all letters IntOSequenceTable] : bag of all letters used
 * <br>
 * <br>
 * [index offset] [seq offset]
 * <br>
 * <br>
 * 
 * (header) <br>
 * <li>[plane 1 byte] (only one plane accepted per instance)
 * <li>[LengthBits 1 byte] (the # of bits to code the big_index values
 * <li>[numLetterbits 1 byte] (the # of bits to code the small_index values
 * <li>[max length 2 bytes] (the maximum word length currently coded in the table
 * <li>[numWords 3 bytes] (total number of words
 * <li>[dataoffset 2 bytes] (relative pointer to packed data below. pre compute the length of the table.)
 * <br>
 * <br>
 * 
 * (big_index = the # of words of that given length)
 * <br>
 * (small_index = # of words of that length startig with the nth letter)<br>
 * [length=1 char big_index] [ (1st letter small_index) (2nd letter small_index) (3rd...) ... ]<br>
 * [length=2 char big_index] [ (1st letter small_index) (2nd letter small_index) ... ]<br>
 * <br>
 * <br>
 * @author Charles Bentley
 *
 */
public interface ITechCharColRun extends ITechCharCol {
   public static final int DEFAULT_BIG_INDEX_BITSIZE             = 16;

   /**
    * byte length of basic header. use it as offset to the Table
    */
   public static final int CHAR_RUN_BASIC_SIZE                   = CHARCOL_BASIC_SIZE + 20;

   public static final int CHAR_RUN_OFFSET_00_PLANE1             = CHARCOL_BASIC_SIZE;

   /**
    * Number of bits used to code the Length entry in the LenAZNumTable
    * <br>
    * When 0, use {@link ITechCharColRun#DEFAULT_BIG_INDEX_BITSIZE}
    * 
    * getting the # of bits to code the LENGTH bit fields
    * it is by default 16 bits.
    * <br>
    * <br>
    * Every Length chunk will start with the number of words in that length category
    */
   public static final int CHAR_RUN_OFFSET_01_LENGTH_BIT1        = CHARCOL_BASIC_SIZE + 1;

   /**
    * getting the # of bits to code the LENGTH bit fields.
    * <br>
    * <br>
    * The small index codes the number of words starting with letter in the length category
    */
   public static final int CHAR_RUN_OFFSET_02_LETTER_BIT1        = CHARCOL_BASIC_SIZE + 2;

   /**
    * 
    */
   public static final int CHAR_RUN_OFFSET_03_MAX_LENGTH2        = CHARCOL_BASIC_SIZE + 3;

   /**
    * Number of words stored.
    * <br>
    * <br>
    * Pointer first?
    */
   public static final int CHAR_RUN_OFFSET_04_NUM_WORD3          = CHARCOL_BASIC_SIZE + 5;

   /**
    * Reads the offset for the {@link PowerOrderedIntToIntRun} start of {@link ByteObject}.
    */
   public static final int CHAR_RUN_OFFSET_05_LETTER_FIRST2      = CHARCOL_BASIC_SIZE + 8;

   /**
    */
   public static final int CHAR_RUN_OFFSET_06_LETTER_ALL2        = CHARCOL_BASIC_SIZE + 10;

   public static final int CHAR_RUN_OFFSET_07_LENAZTABLE2        = CHARCOL_BASIC_SIZE + 12;

   /**
    * reads the offset for reading char data after the header data
    */
   public static final int CHAR_RUN_OFFSET_08_DATA_OFFSET2       = CHARCOL_BASIC_SIZE + 14;

   public static final int CHAR_RUN_OFFSET_09_REFID_FIRSTLETTER2 = CHARCOL_BASIC_SIZE + 16;

   public static final int CHAR_RUN_OFFSET_10_REFID_ALLLETTER2   = CHARCOL_BASIC_SIZE + 18;

}
