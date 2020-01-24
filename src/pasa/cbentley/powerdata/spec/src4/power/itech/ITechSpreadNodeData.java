package pasa.cbentley.powerdata.spec.src4.power.itech;


public interface ITechSpreadNodeData extends ITechNodeData {

   public static final int SPREAD_BASIC_SIZE                  = A_OBJECT_BASIC_SIZE + 3;

   public static final int SPREAD_TYPE                        = 0;

   public static final int SPREAD_OFFSET_01_FLAG              = A_OBJECT_BASIC_SIZE + 3;

   /**
    * The number of bits used to code for the childpointer
    */
   public static final int SPREAD_OFFSET_02_CHILDPOINTERBITS1 = A_OBJECT_BASIC_SIZE + 3;

}
