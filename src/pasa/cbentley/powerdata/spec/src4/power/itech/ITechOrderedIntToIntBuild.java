package pasa.cbentley.powerdata.spec.src4.power.itech;

public interface ITechOrderedIntToIntBuild extends ITechOrderedIntToInt {

   /**
    * Size in bytes of chunk description data
    */
   public static final int BUILD_CHUNK_HEADER_BYTE_SIZE             = 4;

   /**
    * 
    */
   public static final int BUILD_CHUNK_OFFSET_03_FRAMES3            = 0;

   /**
    * Loners in that bit chunk category
    */
   public static final int BUILD_CHUNK_OFFSET_01_X3                 = 1;

   /**
    * Frames in that bit chunk category
    */
   public static final int BUILD_CHUNK_OFFSET_02_Y3                 = 2;

   /**
    * Offset inside the Chunk Header to the number of values below this bit chunk
    */
   public static final int BUILD_CHUNK_OFFSET_04_NUM_BELOW3         = 3;

   /**
    * number of bits used by default for the byte part of a chunk coordinate
    */
   public static final int DEFAULT_BYTE_POINTER_SIZE                = 28;

   public static final int SEQ_BUILD_BASIC_SIZE                     = MORPH_BASIC_SIZE + 15;

   public static final int SEQ_BUILD_HEADER_SIZE                    = 15;

   public static final int SQ_BUILD_AgentID                         = 7779;

   /**
    * 
    */
   public static final int SQ_BUILD_BASIC_SIZE                      = 20;

   public static final int SQ_BUILD_OFFSET_01_HEADER_CHUNK_BASE2    = MORPH_BASIC_SIZE + 0;

   public static final int SQ_BUILD_OFFSET_02_HEADER_DATA_BIT_SIZE3 = MORPH_BASIC_SIZE + 2;

   /**
    * Total number of values
    */
   public static final int SQ_BUILD_OFFSET_03_HEADER_NUM4           = MORPH_BASIC_SIZE + 5;

   /**
    * Number of loners in the Build
    */
   public static final int SQ_BUILD_OFFSET_04_HEADER_NUM_X3         = MORPH_BASIC_SIZE + 9;

   /**
    * Number of frames in the Build
    */
   public static final int SQ_BUILD_OFFSET_05_HEADER_NUM_Y3         = MORPH_BASIC_SIZE + 12;
}
