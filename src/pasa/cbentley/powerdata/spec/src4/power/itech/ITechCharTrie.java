package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.byteobjects.src4.core.ByteController;
import pasa.cbentley.byteobjects.src4.tech.ITechObjectManaged;
import pasa.cbentley.powerdata.spec.src4.power.IPowerCharCollector;
import pasa.cbentley.powerdata.spec.src4.power.trie.IPowerCharTrie;

/**
 * <b>What?</b><br>
 * Describes parameters of an {@link IPowerCharTrie} that extends {@link IPowerCharCollector}.
 * <br>
 * <br>
 * 
 * <b>When?</b><br>
 * Just before since it is needed in the constructor.
 * <br>
 * <br>
 * 
 * <b>Who creates this byte template?</b> <br>
 * The creator of an implementation of an {@link IPowerCharTrie}
 * <br>
 * <br>
 * @author Charles Bentley
 *
 */
public interface ITechCharTrie extends ITechCharCol {

   public static final int CTRIE_BASIC_SIZE                      = CHARCOL_BASIC_SIZE + 15;

   public static final int CTRIE_NODE_DATA_0_PACKFAST            = 0;

   /**
    * Set this flag to reuse char in the char collector
    * slows the build process
    */
   public static final int CTRIE_FLAG_1_REUSE_CHARS              = 1;

   /**
    * Set internally when Trie provides word to id services.
    * <br>
    * <br>
    * Set by default.
    */
   public static final int CTRIE_FLAG_11_CHILD_REF               = 1 << 10;

   /**
    * Will trie to use a CharTrie to compress the CharCollectorRun
    */
   public static final int CTRIE_FLAG_2_RECURSIVE_CHARTRIE       = 1 << 1;

   public static final int CTRIE_FLAG_3_PERSO_USES               = 1 << 2;

   /**
    * Set this flag to change all capital letters from input words. 
    * <br>
    * Depending on {@link TrieSearchSession},
    * <br>
    * FranCe is equal to France and to france.
    * <br>
    * <br>
    * 
    */
   public static final int CTRIE_FLAG_4_LOWERCASE_TRANSFORM  = 1 << 3;

   /**
    * Automatically chooses between Recursive CharTrie or CharCollector
    */
   public static final int CTRIE_FLAG_5_CHECK_RECURSIVE_CHARTRIE = 1 << 4;

   /**
    * in run char trie, the char compressor may not be changed
    * in which case the chartrie must split each letter as a separate node
    */
   public static final int CTRIE_FLAG_6_CHAR_COMPRESSOR_GOLEM    = 1 << 5;

   public static final int CTRIE_FLAG_7_USE_BINARY_SEARCH        = 1 << 6;

   /**
    * All characters are individually assigned a node. None are packed.
    * 
    */
   public static final int CTRIE_FLAG_8_CHAR_EQUAL_NODE          = 1 << 7;

   /**
    * 
    */
   public static final int CTRIE_FLAGX_1_RETURN_FIRST_CAP        = 1 << 0;

   public static final int CTRIE_OFFSET_01_FLAG                  = CHARCOL_BASIC_SIZE;

   /**
    * <li> {@link ITechCharTrie#CTRIE_FLAGX_1_RETURN_FIRST_CAP}
    */
   public static final int CTRIE_OFFSET_02_FLAX                  = CHARCOL_BASIC_SIZE + 1;

   /**
    * 0 means no limit.
    * <br>
    * <br>
    * 1 means 1 character per node maximum. i.e. all nodes only have 1 char stored by the mean of a char pointer.
    */
   public static final int CTRIE_OFFSET_03_MAX_CHARS_PER_NODE1   = CHARCOL_BASIC_SIZE + 2;

   public static final int CTRIE_OFFSET_04_BIGGEST_WORD_SIZE1    = CHARCOL_BASIC_SIZE + 3;

   /**
    * The maximum number of levels below root. (exclusive)
    * <br>
    * <br>
    * So value is 1 if only root has children. Starts at 0 when root is alone.
    */
   public static final int CTRIE_OFFSET_05_HEIGHT_TRIE2          = CHARCOL_BASIC_SIZE + 4;

   /**
    * We want to be able to reference a data structure that lives inside the {@link ByteController}
    * hierarchy. The {@link ITechObjectManaged#AGENT_OFFSET_08_REF_ID2}.
    * Those IDs are statically defined at the application level. They are valid in the current Module
    */
   public static final int CTRIE_OFFSET_06_REF_CHARCOL2          = CHARCOL_BASIC_SIZE + 6;

   public static final int CTRIE_OFFSET_07_REF_TRIEDATA2         = CHARCOL_BASIC_SIZE + 8;

   /**
    * Type of node data. spread or pack
    * <li> {@link ITechCharTrie#NODE_DATA_0_PACKFAST}
    */
   public static final int CTRIE_OFFSET_08_NODE_DATA_TYPE1       = CHARCOL_BASIC_SIZE + 10;

   /**
    * ID for {@link IPowerCharTrie#INT_ID}
    */
   public static final int CTRIE_OFFSET_09_INTID_TRIE2           = CHARCOL_BASIC_SIZE + 11;

   /**
    * ID for {@link IPowerCharCollector#INT_ID}
    */
   public static final int CTRIE_OFFSET_10_INTID_CHAR2           = CHARCOL_BASIC_SIZE + 13;

}
