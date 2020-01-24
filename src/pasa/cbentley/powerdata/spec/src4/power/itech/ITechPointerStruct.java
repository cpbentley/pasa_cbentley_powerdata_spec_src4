package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.powerdata.spec.src4.power.IPowerCharCollector;

/**
 * Datastructures that creates pointers returned to the user for later data retrieval will be of this type.
 * <br>
 * <br>
 * 
 * @author Charles Bentley
 *
 */
public interface ITechPointerStruct extends ITechMorph {

   public static final int PS_BASIC_SIZE               = MORPH_BASIC_SIZE + 15;

   /**
    * Genetic flag saying that the structure has stable pointers. i.e. write methods don't change
    * the previous pointers.
    * <br>
    * <br>
    * By default a structure is unstable.
    * <br>
    * <br>
    * This flag is set by the implementation.
    * <br>
    * <br>
    * How does the user request a morphing with stability?
    * <br>
    * <br>
    * Stability can always be created with a pointer mapping that listens to pointer changes
    * <br>
    */
   public static final int PS_FLAG_1_STABLE            = 1;

   /**
    * Set when bit size for reading the pointer may grow over time when new words
    * are added. When false (default), 
    */
   public static final int PS_FLAG_2_POINTER_GROWTH    = 2;

   /**
    * The pointer bit size fits into an int. Otherwise a {@link ByteObject} is used
    * to code the pointer.
    */
   public static final int PS_FLAG_3_POINTER_INT       = 4;

   public static final int PS_FLAG_4_GROWTH_BELOW      = 8;

   /**
    * Allows pointer to grow the value {@link ITechPointerStruct#}
    */
   public static final int PS_FLAG_5_GROWTH_TOP        = 1 << 4;

   /**
    * Set when the pointer returns data refences, not copies.
    * To force returning copies, set the flag {@link ITechPointerStruct#PS_FLAG_7_COPIES}
    */
   public static final int PS_FLAG_6_REFERENCE         = 1 << 5;

   /**
    * Force the data returned to be references
    */
   public static final int PS_FLAG_7_COPIES            = 1 << 6;

   public static final int PS_OFFSET_01_FLAG           = MORPH_BASIC_SIZE;

   public static final int PS_OFFSET_02_TYPE1          = MORPH_BASIC_SIZE + 1;

   /**
    * Bitsize for reading pointer
    */
   public static final int PS_OFFSET_03_BITSIZE1       = MORPH_BASIC_SIZE + 2;

   /**
    * Start Pointer. Value returned when the first call is made to {@link IPowerCharCollector#addChars(String)}
    */
   public static final int PS_OFFSET_04_START_POINTER4 = MORPH_BASIC_SIZE + 3;

   /**
    * next invalid pointer
    */
   public static final int PS_OFFSET_05_END_POINTER4   = MORPH_BASIC_SIZE + 7;

   public static final int PS_OFFSET_06_NUM_POINTER4   = MORPH_BASIC_SIZE + 11;

}
