package pasa.cbentley.powerdata.spec.src4.power.trie;

import pasa.cbentley.core.src4.structs.IntBuffer;
import pasa.cbentley.core.src4.structs.IntToStrings;

/**
 * Value holder for topology analysis of Trie.
 * <br>
 * <br>
 * Express the set up parameters and the return values.
 * @author Charles Bentley
 *
 */
public class TrieNodeTopo {

   /**
    * Iterate over nodes and inspect each node.
    * <br>
    * <br>
    * 
    * Counts the number of nodes below a given node, inclusive of said node.
    * <br>
    * <br>
    * There might be a filter such as family size of 0 (leaves), with flag set X.
    * Those parameters are expressed in this class.
    */
   public static final int TOPO_TYPE_01_NUM_NODES       = 0;

   /**
    * Iterate over nodes and count the families
    */
   public static final int TOPO_TYPE_02_FAMILIES        = 2;

   /**
    * A full analysis of the patterns.
    * <li>number of nodes
    * <li>number of leaves
    * <li>List of patterns sorted by occurences
    */
   public static final int TOPO_TYPE_03_PATTERN         = 3;

   /**
    * Analysis of the grappes concerning bits flags and pay load.
    */
   public static final int TOPO_TYPE_04_GRAPPES         = 4;

   /**
    * Inverse of depth. Biggest distance to a leaf.
    * <li>Leaf = 0;
    * 
    */
   public static final int TOPO_TYPE_05_HEIGHTS         = 5;

   /**
    * Compute for each node, its depth i.e. the distance from the root.
    * Root is 0. First children of root is 1.
    */
   public static final int TOPO_TYPE_06_DEPTH           = 6;

   /**
    * Compute the maximum family size of nodes below the parameter node.
    */
   public static final int TOPO_TYPE_07_MAX_FAMILY_SIZE = 7;

   /**
    * 
    */
   public static final int TOPO_TYPE_08_NUM_NODES_BELOW = 8;

   public static final int TOPO_SUB_TYPE_01_NUM_LEAVES  = 1;
   public static final int TOPO_SUB_TYPE_02_NUM_FLAGS  = 2;

   public int              paramNode;

   /**
    * Used to express a percentage or threshold
    */
   public double           parameterDouble;

   /**
    * 
    */
   public int              paramNum;

   public int              parameterFamily              = -1;

   public int              parameterFamilyInclude;

   /**
    * 
    */
   public int              parameterFlag                = -1;

   public int              paramType;

   public int              numNodes;

   /**
    * Tracks the number of families. Number of Leaves is at index 0
    */
   public int[]            results;

   public int              resultCount;

   /**
    * The patterns with enough leaves to match the threshold
    */
   public IntToStrings     resultStrings;

   public IntBuffer        resultBuffer;

   public boolean          all;

   public boolean          parameterFlagBool;

   public int             paramTypeSub;

   public TrieNodeTopo() {

   }

   /**
    * 
    * @param type
    * @param node the root node from which to build the topology
    * @param all
    */
   public TrieNodeTopo(int type, int node, boolean all) {
      this.paramType = type;
      this.paramNode = node;
      this.all = all;
   }

   /**
    * Condition for a node to be accepted in the count
    */
   public void addFlagCondition(int flag, boolean v) {
      parameterFlag = flag;
      parameterFlagBool = v;
      paramTypeSub = TOPO_SUB_TYPE_02_NUM_FLAGS;
   }

   public void resetToCountLeaves(int node, boolean all) {
      this.paramType = TOPO_TYPE_01_NUM_NODES;
      this.paramNode = node;
      this.all = all;
      paramTypeSub = TOPO_SUB_TYPE_01_NUM_LEAVES;
   }

   /**
    * When counting nodes with {@link TrieNodeTopo#TOPO_TYPE_01_NUM_NODES} and the all setting,
    * 
    * @param familySize
    * @param included
    */
   public void addFamilyCondition(int familySize, boolean included) {
      parameterFamily = familySize;
      parameterFlagBool = included;
   }

   public void reset(int node, int type, boolean v) {
      this.paramNode = node;
      this.paramType = type;
      all = v;
      paramTypeSub = 0;
   }

   /**
    * Some {@link IPowerTrieNodes} can store topology values once computed or even compute them.
    * <br>
    * <br>
    * It is thus easier to get them.
    * The {@link IPowerTrieNodes} stores an array of {@link TrieNodeTopo}.
    * @return
    */
   public int getTopology(int node) {
      return results[node];
   }

   /**
    * Copies over the result
    * @param tnt
    */
   public void setTo(TrieNodeTopo tnt) {
      tnt.resultCount = resultCount;
      tnt.results = results;
      tnt.resultStrings = resultStrings;

   }
}
