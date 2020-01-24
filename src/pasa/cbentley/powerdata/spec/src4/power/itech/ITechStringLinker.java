package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.powerdata.spec.src4.power.IPowerCharCollector;

/**
 * 
 * @author Charles Bentley
 *
 */
public interface ITechStringLinker extends ITechPointerStruct {
   public static final int LINKER_BASIC_SIZE          = PS_BASIC_SIZE + 7;

   /**
    * Flags tellig how to return the values
    */
   public static final int LINKER_OFFSET_01_FLAG          = PS_BASIC_SIZE;

   /**
    * Size of init buffer
    */
   public static final int LINKER_OFFSET_02_SIZE2         = PS_BASIC_SIZE + 1;

   /**
    * ref id to the {@link IPowerCharCollector}
    */
   public static final int LINKER_OFFSET_03_REF_CHARCO2   = PS_BASIC_SIZE + 3;

   /**
    * 
    */
   public static final int LINKER_OFFSET_04_REF_POINTERS2 = PS_BASIC_SIZE + 5;

}
