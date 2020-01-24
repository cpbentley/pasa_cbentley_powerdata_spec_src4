package pasa.cbentley.powerdata.spec.src4.power.itech;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.tech.ITechObjectManaged;

/**
 * Mother tech definition of node data structures.
 * <br>
 * <br>
 * 2 families of implementation
 * <li> family based where all sister nodes are consecutive but does not provide pointer stability on writes
 * <li> chained based node data where all nodes have a left and right pointer to sisters. provides stability with extra memory foot print.
 * <br>
 * <br>
 * @author Charles Bentley
 *
 */
public interface ITechNodeData extends ITechPointerStruct {

   public static final int NODEDATA_BASIC_SIZE                  = PS_BASIC_SIZE + 10;

   /**
    * Set when Structure of nodes codes for parent nodes.
    */
   public static final int NODEDATA_FLAG_1_PARENT               = 1;

   /**
    * Each node has a payload which may be and integer or an Object (good to use a {@link ByteObject}
    */
   public static final int NODEDATA_FLAG_2_HAS_PAY_LOAD         = 2;

   public static final int NODEDATA_OFFSET_01_FLAG              = PS_BASIC_SIZE;

   /**
    * No consecutive
    */
   public static final int NODEDATA_TYPE_0_CHAIN                = 0;

   public static final int NODEDATA_TYPE_1_FAMILY               = 1;

   /**
    * We already have specific class id defined in {@link ITechObjectManaged#AGENT_OFFSET_05_CLASS_ID2}.
    * <br>
    * <br>
    * However for the purpose of morphying we want to be able to specify a type here.
    */
   public static final int NODEDATA_OFFSET_02_TYPE1             = PS_BASIC_SIZE + 1;

   /**
    * Number of bit flags attached to every node.
    */
   public static final int NODEDATA_OFFSET_03_NUM_FLAGS1        = PS_BASIC_SIZE + 2;

   /**
    * Number of bits 
    */
   public static final int NODEDATA_OFFSET_04_PAYLOAD_BITSIZE1  = PS_BASIC_SIZE + 2;

   public static final int NODEDATA_OFFSET_05_TOPLOGY_FLAGS1    = PS_BASIC_SIZE + 3;

   public static final int NODEDATA_OFFSET_06_MAX_FAMILYSIZE2   = PS_BASIC_SIZE + 4;

   /**
    * the starting size of the buffer for holding nodes
    */
   public static final int NODEDATA_OFFSET_07_INIT_BUFFER_LOAD4 = PS_BASIC_SIZE + 6;


   public static final int NODEDATA_TOPOLOGY_1_DEPTH            = 1;

   public static final int NODEDATA_TOPOLOGY_2_HEIGHT           = 1 << 1;

   public static final int NODEDATA_TOPOLOGY_3_NODE_COUNT       = 1 << 2;

   public static final int NODEDATA_TOPOLOGY_4_LEAVES_COUNT     = 1 << 3;

   public static final int NODEDATA_TOPOLOGY_5_MAX_FAMILY_SIZE  = 1 << 4;

   public static final int NODEDATA_TOPOLOGY_6_LEAVES_COUNT     = 1 << 5;

}
