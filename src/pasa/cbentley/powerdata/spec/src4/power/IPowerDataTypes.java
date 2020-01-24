package pasa.cbentley.powerdata.spec.src4.power;

import pasa.cbentley.byteobjects.src4.ctx.IBOTypesBOC;
import pasa.cbentley.byteobjects.src4.tech.ITechByteObject;
import pasa.cbentley.byteobjects.src4.tech.ITechObjectManaged;
import pasa.cbentley.powerdata.spec.src4.power.itech.ITechCharColBuild;
import pasa.cbentley.powerdata.spec.src4.power.itech.ITechCharTrie;
import pasa.cbentley.powerdata.spec.src4.power.string.IPowerLinkStringToBytes;
import pasa.cbentley.powerdata.spec.src4.power.trie.IPowerCharTrie;
import pasa.cbentley.powerdata.spec.src4.power.trie.IPowerTrieNodesChar;

/**
 * 
 * Defines Class used in the {@link ITechObjectManaged#AGENT_OFFSET_05_CLASS_ID2} field.
 * <br>
 * All PowerDatas use the {@link ITechByteObject#A_OBJECT_OFFSET_1_TYPE1}
 * {@link IBOTypesBOC#TYPE_035_STRUCT}
 * <br>
 * 
 * range from 230 to 250
 * <br>
 * <br>
 * @author Charles Bentley
 *
 */
public interface IPowerDataTypes extends IBOTypesBOC {

   public static final int CLASS_TYPE_01_BYTEOBJECTMANAGE_PURE    = 1;

   /**
    * {@link PowerCharTrie} implementing template {@link ITechCharTrie}.
    */
   public static final int CLASS_TYPE_100_POWER_CHAR_TRIE         = 100;

   /**
    * {@link PowerCharTrieGrap}
    */
   public static final int CLASS_TYPE_101_POWER_CHAR_TRIE_GRAPPE  = 101;

   /**
    * {@link PowerCharTrieTable}
    */
   public static final int CLASS_TYPE_102_POWER_CHAR_TRIE_TABLE   = 102;

   public static final int CLASS_TYPE_103_POWER_TRIE_DATA         = 103;

   public static final int CLASS_TYPE_104_USER_TRIE               = 104;

   /**
    * int to int cable.. very fast reads
    */
   public static final int CLASS_TYPE_22_INT_TO_INT_CABLE_BUILD   = 22;

   public static final int CLASS_TYPE_23_ORDERED_INT_TO_INT_BUILD = 23;

   public static final int CLASS_TYPE_25_INT_TO_BYTES_RUN         = 25;

   public static final int CLASS_TYPE_26_INT_TO_BYTES_BUILD       = 26;

   /**
    * int[]
    */
   public static final int CLASS_TYPE_29_INT_TO_INTS_RUN          = 29;

   public static final int CLASS_TYPE_28_INT_TO_INTS_BYTESRUN     = 28;

   /**
    * int[]
    */
   public static final int CLASS_TYPE_30_INT_TO_INTS_BUILD        = 30;

   /**
    * int[]
    */
   public static final int CLASS_TYPE_31_INT_ARRAY_RUN            = 31;

   /**
    * int[]
    */
   public static final int CLASS_TYPE_32_INT_ARRAY_BUILD          = 32;

   /**
    * 
    */
   public static final int CLASS_TYPE_33_SEQUENCE_BUILD           = 33;

   public static final int CLASS_TYPE_34_ORDERED_INT_TO_INT_RUN   = 34;

   /**
    * int[] to integer
    */
   public static final int CLASS_TYPE_35_ORDERED_INT_TO_INT_BUF   = 35;

   public static final int CLASS_TYPE_43_CHAR_COL_RUN             = 43;

   /**
    * {@link CharPowerColBuild} implementing template {@link ITechCharColBuild}
    */
   public static final int CLASS_TYPE_44_CHAR_COL_BUILD           = 44;

   public static final int CLASS_TYPE_45_CHAR_COL_RUN_LIGHT       = 45;

   public static final int CLASS_TYPE_46_CHAR_COL_AGGREGATE       = 46;

   /**
    * {@link FastNodeData}
    */
   public static final int CLASS_TYPE_65_NODE_DATA_FAST           = 65;

   /**
    * {@link FastNodeDataChar}
    */
   public static final int CLASS_TYPE_66_NODE_DATA_FAST_CHAR      = 66;

   public static final int CLASS_TYPE_90_STRINGLINKER_HASHTABLE   = 90;

   /**
    * Used to associated data to string in a {@link IPowerCharCollector}
    */
   public static final int CLASS_TYPE_91_STRING_TO_INT            = 91;

   /**
    * 
    */
   public static final int CLASS_TYPE_92_STRING_TO_INTS           = 92;

   public static final int OBJECT_120_SEARCH_CHAR                 = 120;

   public static final int OBJECT_121_SEARCH_TRIE                 = 121;

   /**
    * ID for {@link IPowerCharCollector}
    */
   public static final int INT_22_CHAR_COLLECTOR                  = 22;

   /**
    * {@link IPowerCharTrie}
    */
   public static final int INT_23_CHAR_TRIE                       = 23;

   /**
    *  {@link IPowerLinkStringToBytes}
    */
   public static final int INT_24_LINK_STRING_TO_INT              = 24;

   public static final int INT_25_LINK_STRING                     = 25;

   public static final int INT_26_LINK_STRING_TO_INTARRAY         = 26;

   public static final int INT_27_LINK_ORDEREDINT_TO_INT          = 27;

   public static final int INT_28_LINK_INT_TO_INT                 = 28;

   /**
    * IPowerIntDoubleArray
    */
   public static final int INT_29_LINK_INT_TO_INTS                = 29;

   public static final int INT_35_LINK_INT_TO_BYTES               = 35;

   public static final int INT_44_TRIE_NODE_DATA                  = 44;

   /**
    * {@link IPowerTrieNodesChar}
    */
   public static final int INT_45_TRIE_NODE_DATA_CHAR             = 45;

   public static final int INT_55_TRIE_DATA_TYPE                  = 55;
}
