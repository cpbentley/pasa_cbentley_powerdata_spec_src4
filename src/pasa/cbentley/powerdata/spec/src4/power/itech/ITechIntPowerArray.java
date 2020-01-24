package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.powerdata.spec.src4.power.integers.IPowerLinkIntToInts;

/**
 * Tech definition for {@link IPowerLinkIntToInts}.
 * <br>
 * An array of int[]
 * <br>
 * 
 * @author Charles-Philip
 *
 */
public interface ITechIntPowerArray extends ITechMorph {

   public static final int ARRAY_HEADER_SIZE_2            = MORPH_BASIC_SIZE_HEADER_1 + 10;

   /**
    * Well treat the arrays as queues 
    * operations are peek,pop and push. accept a maximum
    * deletion at the front. addition at the rear
    */
   //public static final int   FLAG_USE_QUEUE = 64;

   public static final int ARRAY_INT_BASIC_SIZE           = MORPH_BASIC_SIZE + 10;

   public static final int ARRAY_FLAG_1_DUPLICATES        = 1;

   /**
    * Flags tellig how to return the values
    */
   public static final int ARRAY_OFFSET_01_FLAG           = MORPH_BASIC_SIZE;

   /**
    * NOT used
    */
   public static final int ARRAY_OFFSET_02_TYPE1          = MORPH_BASIC_SIZE + 1;

   public static final int ARRAY_OFFSET_03_COL_INIT_SIZE2 = MORPH_BASIC_SIZE + 2;

   public static final int ARRAY_OFFSET_04_ROW_INIT_SIZE2 = MORPH_BASIC_SIZE + 4;

   /**
    * Number of elements
    */
   public static final int ARRAY_OFFSET_05_SIZE4          = MORPH_BASIC_SIZE + 6;

   /**
    * Maximum number of values.
    * <br>
    * <br>
    * When 0, no maximum
    */
   public static final int ARRAY_OFFSET_06_MAX2           = MORPH_BASIC_SIZE + 6;

   /**
    * Reject values with bigger bit sizes.
    */
   public static final int ARRAY_OFFSET_07_BITSIZE1       = MORPH_BASIC_SIZE + 6;

   /**
    * <li> {@link ITechIntPowerArray#ARRAY_ORDER_0_FRONT}
    * <li> {@link ITechIntPowerArray#ARRAY_ORDER_1_BACK}
    * <li> {@link ITechIntPowerArray#ARRAY_ORDER_2_ASC}
    * <li> {@link ITechIntPowerArray#ARRAY_ORDER_3_DESC}
    * 
    */
   public static final int ARRAY_OFFSET_08_ORDER_TYPE1    = MORPH_BASIC_SIZE + 6;

   /**
    * 
    */
   public static final int ARRAY_OFFSET_09_MAX_TYPE1      = MORPH_BASIC_SIZE + 6;

   /**
    * basic insert of values in front of array. 
    */
   public static final int ARRAY_ORDER_0_FRONT            = 0;

   /**
    * No sorting. but integers are added on the top of the array
    */
   public static final int ARRAY_ORDER_1_BACK             = 1;

   /**
    * Sort from small to tall
    */
   public static final int ARRAY_ORDER_2_ASC              = 2;

   /**
    * Sorted from tall to small
    */
   public static final int ARRAY_ORDER_3_DESC             = 3;

   /**
    * if true, the data size is fixed and set externally
    */
   public static final int FLAG_FIXED_ARRAY_DATA_SIZE     = 64;

   public static final int ARRAY_MAX_0_BLOCK              = 0;

   public static final int ARRAY_MAX_1_LIFO               = 1;

   public static final int ARRAY_MAX_2_FIFO               = 2;

   /**
    * Will treat the array as a queue when Maximum is reached.
    * LIFO 
    * FIFO
    * DEFAULT = LIFO
    * If ordered
    * if true LIFO (last int first out)
    * if false FIFO (first in first out) 
    * If ordered, 
    * LIFO biggest is removed
    * FIFO smallest is removed
    * [5 7 11] LIFO becomes [5 7 ...]
    * [5 7 11] LIFO becomes [5 7 ...]
    * 
    */
   public static final int FLAG_TRUE_STACK_FALSE_QUEUE    = 32;

   /**
    * only different values in one array
    */
   public static final int ARRAY_4_FLAG_UNIQUE_VALUES     = 4;

   /**
    * if true, once the maximum is reached
    * new values are not more added to the array
    * an explicit remove will be needed
    */
   public static final int FLAG_USE_MAX_BLOCKED           = 16;

   /**
    * once maximum is reached, new values replaces another value
    * in ordered arrays, no replace is done.
    * in non ordered array: stack behaviour or queue
    */
   public static final int FLAG_USE_MAXIMUM               = 8;

}
