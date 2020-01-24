package pasa.cbentley.powerdata.spec.src4.power.itech;

public interface ITechSpreadNodeDataChar extends ITechSpreadNodeData {

   public static final int SPREAD_CHAR_BASIC_SIZE                      = A_OBJECT_BASIC_SIZE + 3;


   /**
    * When looking for a family.
    * <br>
    * <br>
    * Only usefull when lots of families with many many children.
    * <br>
    * <br>
    * Otherwise linear search works just fine in practice.
    */
   public static final int SPREAD_CHAR_FLAG_1_USE_BINARY_SEARCH        = 1;

   public static final int SPREAD_CHAR_OFFSET_01_FLAG                  = A_OBJECT_BASIC_SIZE + 3;

   public static final int SPREAD_CHAR_OFFSET_02_CHARPOINTER_BIT_SIZE1 = A_OBJECT_BASIC_SIZE + 3;

}
