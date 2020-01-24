package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.byteobjects.src4.tech.ITechByteObject;

/**
 * Defines the parameter options of a {@link TrieSearchSession}.
 * <br>
 * <br>
 * 
 * @author Charles Bentley
 *
 */
public interface ITechSearchChar extends ITechByteObject {

   public static final int SEARCH_CHAR_BASIC_SIZE              = A_OBJECT_BASIC_SIZE + 4;

   /**
    * Results have the first letter in capital letter
    */
   public static final int SEARCH_CHAR_FLAG_1_RETURN_FIRST_CAP = 1 << 0;

   /**
    * Creates a new thread to search
    */
   public static final int SEARCH_CHAR_FLAG_2_IS_THREADED      = 1 << 1;

   /**
    * Creates a new thread to search
    */
   public static final int SEARCH_CHAR_FLAG_3_IS_APPEND        = 1 << 2;

   public static final int SEARCH_CHAR_FLAG_5_REVERSE_ORDER    = 1 << 4;

   /**
    * When soft, e = é.
    * <br>
    * 
    */
   public static final int SEARCH_CHAR_FLAGZ_1_SOFT_ACCENT     = 1 << 3;

   /**
    * H and h are equivalent
    */
   public static final int SEARCH_CHAR_FLAGZ_2_SOFT_CAP        = 1 << 5;

   public static final int SEARCH_CHAR_OFFSET_01_FLAG1         = A_OBJECT_BASIC_SIZE;

   /**
    * Max Frame size.
    * Size of 0 mean infinite. All results are returned at once.
    * <br>
    * 
    */
   public static final int SEARCH_CHAR_OFFSET_02_FRAME_SIZE2   = A_OBJECT_BASIC_SIZE + 1;

   /**
    * <li>{@link ITechCharCol#SEARCH_0_PREFIX}
    * <li>{@link ITechCharCol#SEARCH_1_INDEXOF}
    */
   public static final int SEARCH_CHAR_OFFSET_03_SEARCH_TYPE1  = A_OBJECT_BASIC_SIZE + 3;

   /**
    * The String transform to apply to each results.
    * <br>
    * <li> 0 None
    * <li> 1 First Cap
    * <li> 2 All Caps
    * <li> 3 All mins
    * 
    */
   public static final int SEARCH_CHAR_OFFSET_04_TRANSFORM1    = A_OBJECT_BASIC_SIZE + 4;

   /**
    * Comparator flags
    */
   public static final int SEARCH_CHAR_OFFSET_05_FLAGZ1        = A_OBJECT_BASIC_SIZE + 5;

}
