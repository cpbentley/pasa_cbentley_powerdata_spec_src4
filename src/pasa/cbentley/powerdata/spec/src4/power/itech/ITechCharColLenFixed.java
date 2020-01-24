package pasa.cbentley.powerdata.spec.src4.power.itech;

public interface ITechCharColLenFixed extends ITechCharCol {

   public static final int BASIC_SIZE                    = A_OBJECT_BASIC_SIZE + 5;

   public static final int CCFIXED_OFFSET_01_FLAG        = A_OBJECT_BASIC_SIZE;

   /**
    * Number of bytes for a chunk.
    * <br>
    * <br>
    * Since compression is used 1 byte for header and size-1 number of characters.
    */
   public static final int CCFIXED_OFFSET_02_SIZE1       = A_OBJECT_BASIC_SIZE;

   public static final int CCFIXED_OFFSET_03_BASE_PLANE1 = A_OBJECT_BASIC_SIZE;

}
