package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.byteobjects.src4.core.ByteController;
import pasa.cbentley.byteobjects.src4.interfaces.IJavaObjectFactory;
import pasa.cbentley.byteobjects.src4.tech.ITechObjectManaged;

/**
 * 
 * @author Charles-Philip
 *
 */
public interface ITechMorph extends ITechObjectManaged {

   public static final int MORPH_BASIC_SIZE              = AGENT_BASIC_SIZE + 4;

   public static final int MORPH_FLAG_1_RUN              = 2;

   /**
    * Genetic flag set by implementation when reads are constant.
    */
   public static final int MORPH_FLAG_2_FAST_READ        = 1 << 1;

   /**
    * Genetic flag set by implementation when writes are constant.
    */
   public static final int MORPH_FLAG_3_FAST_WRITE       = 1 << 2;

   /**
    * Genetic flag set by implementation when datastructure is using compressing techniques.
    */
   public static final int MORPH_FLAG_4_SMALL_FOOT_PRINT = 1 << 3;

   public static final int MORPH_FLAG_5                  = 1 << 4;

   public static final int MORPH_FLAG_6                  = 1 << 5;

   public static final int MORPH_FLAG_7_INTID_DEF        = 1 << 6;

   /**
    * Requires structures to set up a {@link ByteController} for managing interdependance
    */
   public static final int MORPH_FLAG_8_INTER_DEPENDANCE = 1 << 7;

   public static final int MORPH_OFFSET_01_FLAG          = AGENT_BASIC_SIZE;

   public static final int MODE_0_UNDEFINED              = 0;

   /**
    * The structure must optimized the structure.
    * {@link IJavaObjectFactory} will choose 
    */
   public static final int MODE_1_BUILD                  = 1;

   public static final int MODE_2_RUN                    = 2;

   /**
    * User decided mode.
    * <li> 0 UNDEFINED
    * <li> {@link ITechMorph#MODE_1_BUILD} 0 UNDEFINED
    * <li> 0 UNDEFINED
    * 
    */
   public static final int MORPH_OFFSET_02_MODE1         = AGENT_BASIC_SIZE + 1;

   /**
    * 2 bytes field to make references between structures.
    * 
    */
   public static final int MORPH_OFFSET_03_REF2          = AGENT_BASIC_SIZE + 2;

   public static final int MORPH_BASIC_SIZE_HEADER_1     = 2;

}
