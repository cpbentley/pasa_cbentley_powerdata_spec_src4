package pasa.cbentley.powerdata.spec.src4.power.itech;

/**
 * Map one integer to several integers.
 * <br>
 * Each array of integers follow an ordering defined by {@link ITechIntToInts#ITIS_OFFSET_02_ORDER_TYPE1}
 * <li> {@link ITechIntToInts#ITIS_ARRAY_ORDER_0_APPEND_SUFFIX}
 * <li> {@link ITechIntToInts#ITIS_ARRAY_ORDER_1_APPEND_PREFIX}
 * <li> {@link ITechIntToInts#ITIS_ARRAY_ORDER_2_ASC}
 * <li> {@link ITechIntToInts#ITIS_ARRAY_ORDER_3_DESC}
 * <br>
 * <br>
 * If flag {@link ITechIntToInts#ITIS_FLAG_2_DUPLICATES} each array may contain
 * several instance of the same integer value
 * @author Charles Bentley
 *
 */
public interface ITechIntToInts extends ITechIntToInt {

   /**
    * basic insert of values in front of array
    */
   public static final int ITIS_ARRAY_ORDER_0_APPEND_SUFFIX = 0;

   /**
    * No sorting. but integers are added on the top of the array
    */
   public static final int ITIS_ARRAY_ORDER_1_APPEND_PREFIX = 1;

   /**
    * Sort from small to tall.
    * <br>
    * <br>
    * The algo for sorting is decided by the implementation
    */
   public static final int ITIS_ARRAY_ORDER_2_ASC           = 2;

   /**
    * Sorted from tall to small
    */
   public static final int ITIS_ARRAY_ORDER_3_DESC          = 3;

   public static final int ITIS_BASIC_SIZE                  = ITI_BASIC_SIZE + 6;

   /**
    * When set, the structures stores arrays of integers instead of a single value.
    */
   public static final int ITIS_FLAG_1_ARRAYS               = 1 << 0;

   /**
    * When set, allows duplicates in array of integers
    */
   public static final int ITIS_FLAG_2_DUPLICATES           = 1 << 1;

   public static final int ITIS_OFFSET_01_FLAG              = ITI_BASIC_SIZE;

   /**
    * How do you sort integers values in the array
    * <li> {@link ITechIntPowerArray#ARRAY_ORDER_0_FRONT}
    * <li> {@link ITechIntPowerArray#ARRAY_ORDER_1_BACK}
    * <li> {@link ITechIntPowerArray#ARRAY_ORDER_2_ASC}
    * <li> {@link ITechIntPowerArray#ARRAY_ORDER_3_DESC}
    * 
    */
   public static final int ITIS_OFFSET_02_ORDER_TYPE1       = ITI_BASIC_SIZE + 1;

   /**
    * Buffer size of columns
    */
   public static final int ITIS_OFFSET_03_COL_INIT_SIZE2    = ITI_BASIC_SIZE + 2;

   /**
    * Buffer size. of rows
    */
   public static final int ITIS_OFFSET_04_ROW_INIT_SIZE2    = ITI_BASIC_SIZE + 4;

}
