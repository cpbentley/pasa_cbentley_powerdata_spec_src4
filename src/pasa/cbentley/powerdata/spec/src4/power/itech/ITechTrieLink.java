package pasa.cbentley.powerdata.spec.src4.power.itech;

public interface ITechTrieLink extends ITechMorph {

   public static final int TRIEDATA_BASIC_SIZE            = MORPH_BASIC_SIZE + 7;

   public static final int TRIEDATA_OFFSET_01_FLAG        = MORPH_BASIC_SIZE;

   /**
    * Number of types
    */
   public static final int TRIEDATA_OFFSET_02_NUMTYPES2   = MORPH_BASIC_SIZE + 1;

   public static final int TRIEDATA_OFFSET_03_REF_TRIE2   = MORPH_BASIC_SIZE + 3;

   /**
    * Base ID for our linkers.
    */
   public static final int TRIEDATA_OFFSET_04_REF_LINKER2 = MORPH_BASIC_SIZE + 5;

}
