package pasa.cbentley.powerdata.spec.src4.power.itech;

public interface ITechIntToBytesRun extends ITechIntToBytes {

   public static final int ITBR_BASIC_SIZE               = ITB_BASIC_SIZE + 2;

   public static final int ITBR_BLOCK_SIZE               = 3;

   public static final int ITBR_BLOCK_FLAG_1_NULL        = 1;

   public static final int ITBR_BLOCK_FLAG_2_DELETED     = 1 << 1;

   public static final int ITBR_FLAG_1_UNIQUE_SIZE       = 1;

   public static final int ITBR_OFFSET_01_FLAG1          = ITB_BASIC_SIZE;

   /**
    * Type of configuration
    * <li>a few big records
    * <li>many identical records
    */
   public static final int ITBR_OFFSET_03_TYPE1          = ITB_BASIC_SIZE + 1;

   /**
    * Number of
    */
   public static final int ITBR_OFFSET_04_NUM_BLOCK3     = ITB_BASIC_SIZE + 1;

   /**
    * Flags saying, how to read the block
    */
   public static final int ITBR_BLOCK_OFFSET_01_FLAG1    = ITB_BASIC_SIZE + 1;

   public static final int ITBR_BLOCK_OFFSET_02_NUMS3    = ITB_BASIC_SIZE + 1;

   public static final int ITBR_BLOCK_OFFSET_02_SIZE3    = ITB_BASIC_SIZE + 1;

}
