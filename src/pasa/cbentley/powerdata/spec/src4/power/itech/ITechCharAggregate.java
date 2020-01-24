package pasa.cbentley.powerdata.spec.src4.power.itech;

public interface ITechCharAggregate extends ITechCharCol {

   /**
    * 
    */
   public static final int CHAR_AGGRE_BASIC_SIZE          = CHARCOL_BASIC_SIZE + 1;

   public static final int CHAR_AGGRE_FLAG_1_DYNAMIC      = 1;

   public static final int CHAR_AGGRE_OFFSET_01_FLAG1     = CHARCOL_BASIC_SIZE;

   /**
    */
   public static final int CHAR_AGGRE_OFFSET_02_NUM_TYPES = CHARCOL_BASIC_SIZE + 1;

}
