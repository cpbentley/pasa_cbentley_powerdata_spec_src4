package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.byteobjects.src4.tech.ITechObjectManaged;

/**
 * Defines extra parameter for {@link ITechObjectManaged#AGENT_OFFSET_05_CLASS_ID2} ??
 * <br>
 * <br>
 * 
 * @author Charles Bentley
 *
 */
public interface ITechCharTrieTable extends ITechCharTrie {

   public static final int CTRIETABLE_BASIC_SIZE               = CTRIE_BASIC_SIZE + 7;

   public static final int CTRIETABLE_FLAG_1_SINGLE_CHAR_COL   = 1;

   /**
    * Keeps all the Tries loaded.
    */
   public static final int CTRIETABLE_FLAG_2_LOAD_ALL          = 1 << 2;

   public static final int CTRIETABLE_OFFSET_01_FLAG           = CTRIE_BASIC_SIZE;

   /**
    * The class id of the trie implementing the arrays. 
    */
   public static final int CTRIETABLE_OFFSET_02_TRIE_CLASS_ID2 = CTRIE_BASIC_SIZE + 1;

   public static final int CTRIETABLE_OFFSET_03_NUM_TRIES2     = CTRIE_BASIC_SIZE + 3;

   public static final int CTRIETABLE_OFFSET_04_NUM_BITS_CODE1 = CTRIE_BASIC_SIZE + 5;

}
