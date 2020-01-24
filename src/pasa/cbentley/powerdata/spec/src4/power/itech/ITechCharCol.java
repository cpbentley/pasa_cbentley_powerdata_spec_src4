package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.byteobjects.src4.tech.ITechObjectManaged;
import pasa.cbentley.powerdata.spec.src4.power.IDataMorphable;
import pasa.cbentley.powerdata.spec.src4.power.IPowerCharCollector;
import pasa.cbentley.powerdata.spec.src4.power.MorphParams;

/**
 * The genetics definition of a {@link IPowerCharCollector}.
 * <br>
 * <br>
 * 
 * Global properties
 * <br>
 * <br>
 * Provide the different options for a char collector mapper.
 * <br>
 * <br>
 * 
 * @author Charles Bentley
 *
 */
public interface ITechCharCol extends ITechPointerStruct {
   public static final int SEARCH_0_PREFIX                      = 0;

   public static final int SEARCH_1_INDEXOF                     = 1;

   /**
    * 
    */
   public static final int CHARCOL_BASIC_SIZE                   = PS_BASIC_SIZE + 7;

   /**
    * When set, an index is created to quickly search integer handle based on String data.
    * <br>
    * <br>
    * Some implementations (Tries) don't need an index and will ignore this flag.
    */
   public static final int CHARCOL_FLAG_2_FAST_STRING_INDEX     = 1 << 1;

   /**
    * By default, does not accept duplicates
    * When set, the char collector checks to prevent duplicates.
    */
   public static final int CHARCOL_FLAG_3_DUPLICATES            = 1 << 2;

   /**
    * When set, the index is serialized, else it is rebuilt each time the class is instantiated.
    */
   public static final int CHARCOL_FLAG_4_INDEX_SERIALIZED      = 1 << 3;

   /**
    * Property that pointers are contiguous. There are no holes, that is
    * pointers inside the interval which don't point to a String
    * Deletion whithout pointer rearrangement destroy this property.
    */
   public static final int CHARCOL_FLAG_5_CONTINUOUS_POINTERS   = 1 << 4;

   /**
    * What happens when a multiple plane morphs into single plane?
    * <br>
    * Plane data is lost and sets to default.
    */
   public static final int CHARCOL_FLAG_6_SINGLE_PLANE          = 1 << 5;

   /**
    * True when collector is able to store multiples 
    */
   public static final int CHARCOL_FLAG_7_GENE_DUPLICATE        = 1 << 6;

   /**
    * Get methods return raw references.
    */
   public static final int CHARCOL_FLAG_8_REFERENCE_GET         = 1 << 7;

   public static final int CHARCOL_OFFSET_01_FLAG1              = PS_BASIC_SIZE;

   /**
    * Genetic Flags set by the implementation
    */
   public static final int CHARCOL_OFFSET_02_GENESX2            = PS_BASIC_SIZE + 1;

   /**
    * The type of char collector. When 0, it is undefined and the {@link IDataMorphable#getMorph(MorphParams)}
    * process must choose which type to use base on available genes.
    * <br>
    * <br>
    * We already have specific class id defined in {@link ITechObjectManaged#AGENT_OFFSET_05_CLASS_ID2}.
    * <br>
    * <br>
    * However for the purpose of morphying we want to be able to specify a type here.
    */
   public static final int CHARCOL_OFFSET_03_TYPE1              = PS_BASIC_SIZE + 3;

   public static final int CHARCOL_OFFSET_04_BIGGEST_WORD_SIZE1 = PS_BASIC_SIZE + 4;

   /**
    * Reference ID of the Index.
    */
   public static final int CHARCOL_OFFSET_05_INDEX_REF2         = PS_BASIC_SIZE + 5;

}
