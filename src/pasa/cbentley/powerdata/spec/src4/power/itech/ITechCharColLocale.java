package pasa.cbentley.powerdata.spec.src4.power.itech;

public interface ITechCharColLocale extends ITechCharCol {
   public static final int LOCALE_CC_BASIC_SIZE            = CHARCOL_BASIC_SIZE + 9;

   public static final int LOCALE_CC_OFFSET_01_FLAG        = CHARCOL_BASIC_SIZE;

   /**
    * Number of locales. When a local is added, this number is increased.
    * <br>
    * <br>
    * 
    */
   public static final int LOCALE_CC_OFFSET_02_NUM2        = CHARCOL_BASIC_SIZE + 1;

   public static final int LOCALE_CC_OFFSET_03_ROOT_REF2   = CHARCOL_BASIC_SIZE + 3;

   public static final int LOCALE_CC_OFFSET_04_CURRENT_ID2 = CHARCOL_BASIC_SIZE + 5;

   public static final int LOCALE_CC_OFFSET_05_DYNAMIC_ID2 = CHARCOL_BASIC_SIZE + 7;

}
