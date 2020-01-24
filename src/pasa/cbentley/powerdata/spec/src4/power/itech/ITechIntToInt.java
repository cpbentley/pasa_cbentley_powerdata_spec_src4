package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.powerdata.spec.src4.power.integers.IPowerLinkIntToInt;

public interface ITechIntToInt extends ITechPointerStruct {

   public static final int ITI_BASIC_SIZE           = PS_BASIC_SIZE + 5;

   /**
    * When set, {@link IPowerLinkIntToInt#getKeyData(int)} throws an
    * {@link IllegalArgumentException} when key data was never used
    */
   public static final int ITI_FLAG_1_EXCEPTION     = 1;

   public static final int ITI_OFFSET_01_FLAG       = PS_BASIC_SIZE;

   public static final int ITI_OFFSET_02_DEF_VALUE4 = PS_BASIC_SIZE + 1;

}
