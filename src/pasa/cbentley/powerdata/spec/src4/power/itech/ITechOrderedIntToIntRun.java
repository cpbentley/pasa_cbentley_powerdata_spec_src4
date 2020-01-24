package pasa.cbentley.powerdata.spec.src4.power.itech;

public interface ITechOrderedIntToIntRun extends ITechOrderedIntToInt {

   /**
    * Size in bytes of chunk description data.
    * <br>
    * <li> 4 bytes of coordinate
    * <li> 
    * A Chunk is the set of i bits integers.
    * <li> 7bits
    * <li> 8bits
    * <li> 9bits
    */
   public static final int CHUNK_HEADER_BYTE_SIZE                 = 15;

   /**
    * number of bits used by default for the byte part of a chunk coordinate
    */
   public static final int DEFAULT_BYTE_POINTER_SIZE              = 28;

   /**
    * Position of our values
    */
   public static final int OFFSET_CHUNK_01_COORDINATE_4           = 0;

   /**
    * How many bits code the length of a frame for this chunk
    */
   public static final int OFFSET_CHUNK_02_LENGTH_BITSIZE_1       = 4;

   /**
    * offset relative to chunkoffset
    * <br>
    * 1=true if flag bit is currently used inside the chunk
    */
   public static final int OFFSET_CHUNK_03_FLAGBIT_1              = 5;

   /**
    * Number of loners
    */
   public static final int OFFSET_CHUNK_04_NUM_LONERS_3           = 6;

   /**
    * Number of big frames
    */
   public static final int OFFSET_CHUNK_05_NUM_FRAMES_3           = 9;

   /**
    * number of values below this chunk. this includes all the values from all the chunks
    * below.
    */
   public static final int OFFSET_CHUNK_06_NUM_BELOW_3            = 12;

   /**
    * 
    */
   public static final int OITI_RUN_BASIC_SIZE                      = OITI_BASIC_SIZE + 20;

   /**
    * 
    */
   public static final int OITI_RUN_OFFSET_00_HEADER_CHUNK_BASE1    = OITI_BASIC_SIZE + 0;

   /**
    * Order ASC or DESC. not impelemtend yet
    */
   public static final int OITI_RUN_OFFSET_01_HEADER_ORDER1         = OITI_BASIC_SIZE + 1;

   /**
    * The bit size to be used. Will change if 
    * {@link ITechOrderedIntToIntRun#OITI_RUN_OFFSET_03_DATABITSIZE_FLAG1} is set to 1.
    * <br>
    */
   public static final int OITI_RUN_OFFSET_02_DATA_BITSIZE1         = OITI_BASIC_SIZE + 2;

   /**
    * Bit size to be used in constructor
    * <li>0 means there is no data
    * <li>1 means datasize expands when needed and is stored in {@link ITechOrderedIntToIntRun#OITI_RUN_OFFSET_02_DATA_BITSIZE1}
    * <li>otherwise use the databist
    */
   public static final int OITI_RUN_OFFSET_03_DATABITSIZE_FLAG1     = OITI_BASIC_SIZE + 3;

   /**
    * Number of bits to code the length of a frame for all chunks.
    * <br>
    * Not used if length is chunk base.
    */
   public static final int OITI_RUN_OFFSET_04_CHUNK_L1              = OITI_BASIC_SIZE + 4;

   /**
    * true if flag bit can be used inside chunks.
    * <br>
    * The flag bit is 
    */
   public static final int OITI_RUN_OFFSET_05_HEADER_FLAG_BIT1      = OITI_BASIC_SIZE + 5;

   public static final int OITI_RUN_OFFSET_05_TOTAL_NUM_VALUES4     = OITI_BASIC_SIZE + 6;

   /**
    * Number of lone values
    */
   public static final int OITI_RUN_OFFSET_06_TOTAL_LONERS3         = OITI_BASIC_SIZE + 10;

   public static final int OITI_RUN_OFFSET_07_TOTAL_BIG_FRAMES3     = OITI_BASIC_SIZE + 13;

   /**
    * 
    */
   public static final int OITI_RUN_OFFSET_08_HEADER_LAST_USED_BIT4 = OITI_BASIC_SIZE + 16;

}
