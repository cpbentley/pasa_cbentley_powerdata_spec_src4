package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.byteobjects.src4.core.ByteController;

public interface ITechUserTrie extends ITechCharCol {
   public static final int USERTRIE_BASIC_SIZE                   = CHARCOL_BASIC_SIZE + 10;

   public static final int USERTRIE_OFFSET_01_FLAG               = CHARCOL_BASIC_SIZE;

   /**
    * Tech position
    */
   public static final int USERTRIE_REF_1_DIC                    = 1;

   /**
    * 
    */
   public static final int USERTRIE_REF_2_FEEDBACK               = 2;

   public static final int USERTRIE_REF_TRIE_3_NEWWORDS          = 3;

   /**
    * But what happens if that CharCollector is shared externally?
    * Is that possible in this framework?
    * Load the Char Collector in a {@link ByteController}
    * The MemorySource
    */
   public static final int USERTRIE_REF_CHARCO_4_SHARED          = 4;

   public static final int USERTRIE_PARAMS_SIZE                  = 5;

   public static final int USERTRIE_OFFSET_02_REF_DIC_TRIE2      = CHARCOL_BASIC_SIZE + 1;

   public static final int USERTRIE_OFFSET_03_REF_FEEDBACK_TRIE3 = CHARCOL_BASIC_SIZE + 3;

   public static final int USERTRIE_OFFSET_04_REF_NEWWORDS_TRIE4 = CHARCOL_BASIC_SIZE + 5;

}
