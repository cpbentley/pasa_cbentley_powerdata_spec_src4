package pasa.cbentley.powerdata.spec.src4.power.itech;

public interface ITechIntToBytes extends ITechMorph {

   public static final int ITB_BASIC_SIZE               = MORPH_BASIC_SIZE + 25;

   public static final int ITB_OFFSET_01_FLAG1          = MORPH_BASIC_SIZE;

   /**
    * 
    */
   public static final int ITB_OFFSET_02_BASE4          = MORPH_BASIC_SIZE + 1;

   public static final int ITB_OFFSET_03_NEXT4          = MORPH_BASIC_SIZE + 5;

   /**
    * Computes number of elements, substracting deletions.
    */
   public static final int ITB_OFFSET_04_NUM_ELEMENTS4  = MORPH_BASIC_SIZE + 9;

   public static final int ITB_OFFSET_05_VERSION4       = MORPH_BASIC_SIZE + 13;

   public static final int ITB_OFFSET_06_LAST_MODIFIED8 = MORPH_BASIC_SIZE + 17;

}
