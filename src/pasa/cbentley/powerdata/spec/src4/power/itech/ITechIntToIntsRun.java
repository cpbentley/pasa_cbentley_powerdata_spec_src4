package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.byteobjects.src4.tech.ITechObjectManaged;
import pasa.cbentley.powerdata.spec.src4.power.IPowerDataTypes;

/**
 * For {@link IPowerDataTypes#CLASS_TYPE_31_INT_ARRAY_RUN}
 * <br>
 * {@link ITechMorph}
 * <br>
 * {@link ITechObjectManaged}
 * <br>
 *  * 
 * [ bitPointerSize 1 byte ]
 * [ bitIntSize 1 byte ]
 * [ numChunks 2 bytes]
 * [ tableoffset 4 bytes]
 * [ lastpointer bit used 4 bytes]
 * [ lastDataBit used 4 bytes]
 * [ negative flag 1 byte]
 * [ 0 pointer array ]
 * [ 1 pointer array ]
 * [ 2 pointer array ]
 * [ 3 pointer array ]
 * [ bitspointer for 0] the pointer are at the end to make the smaller and hopefully consume less bits
 * [ bitspointer for 1]
 * [ bitspointer for 2]
 * [ bitspointer for 3]
 * 
 * 
 * @author Charles Bentley
 *
 */
public interface ITechIntToIntsRun extends ITechIntToInts {

   public static final int ITIS_RUN_BASIC_SIZE                  = ITIS_BASIC_SIZE + 17;

   public static final int ITIS_RUN_FLAG_1_NEGATIVE             = 1;

   public static final int ITIS_RUN_OFFSET_01_FLAG1             = ITIS_BASIC_SIZE;

   public static final int ITIS_RUN_OFFSET_02_POINTER_BIT_SIZE1 = ITIS_BASIC_SIZE + 1;

   public static final int ITIS_RUN_OFFSET_03_INT_BIT_SIZE1     = ITIS_BASIC_SIZE + 2;

   public static final int ITIS_RUN_OFFSET_04_NUM_CHUNKS2       = ITIS_BASIC_SIZE + 3;

   public static final int ITIS_RUN_OFFSET_05_TABLE4            = ITIS_BASIC_SIZE + 5;

   public static final int ITIS_RUN_OFFSET_06_LAST_POINTER4     = ITIS_BASIC_SIZE + 9;

   public static final int ITIS_RUN_OFFSET_07_LAST_DATA_BIT4    = ITIS_BASIC_SIZE + 13;
}
