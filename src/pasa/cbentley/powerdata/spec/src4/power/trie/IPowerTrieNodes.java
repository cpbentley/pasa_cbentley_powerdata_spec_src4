package pasa.cbentley.powerdata.spec.src4.power.trie;

import pasa.cbentley.core.src4.structs.IntBuffer;
import pasa.cbentley.powerdata.spec.src4.power.IDataMorphable;

/**
 * Describe a Tree node relation between nodes. A sub interface describes what kind of data is stored at each node.
 * <br>
 * <br>
 * The node values are not always patterned. Some implementation may pattern the user nodes, but the user should not assume.
 * 
 * Each node in the trie has fields to be saved. The format depends on the implementing class.
 * <br>
 * <br>
 * @author Charles Bentley
 */
public interface IPowerTrieNodes extends IDataMorphable {

   /**
    * All implementations must respect this constant
    */
   public static final int NOT_A_NODE              = 0;

   public static final int CHILD_NODE_NOT_FOUND    = -1;

   /**
    * Return true if the node makes sense to the end user (i.e. was inserted)
    * False if the node is internal and does not makes sense to the user of the class
    * <br>
    * <br>
    * Returns true if the user bit is not used.
    * <br>
    * <br>
    */
   public static final int NODE_FLAG_1_USER_NODE   = 1;

   /**
    * Flags the node as being grappe suffix start.
    */
   public static final int NODE_FLAG_2_SUFFIX_NODE = 2;

   /**
    * Create a new child and tries to add him in the given order in the family.
    * <br>
    * <br>
    * If there are not enough nodes for the given index value, node is appended last
    * in the family.
    * <br>
    * <br>
    * 
    * @param parentNode
    * @param familyIndex
    * @return
    */
   public int addChild(int parentNode, int familyIndex);

   /**
    * Returns the first child
    * <br>
    * <br>
    * 
    * @param node
    * @return
    */
   public int getNodeChildFirst(int node);

   /**
    *  list children in order of appearance.
    *  To be deleted.
    * @param node
    * @param dest
    * @param offset
    * @return the number of children written
    */
   public int getNodeChildren(int node, int[] dest, int offset);

   /**
    * list children in order of appearance.
    * <br>
    * <br>
    * When reverse is true, children are added in reverse order.
    * @param node
    * @param IntBuffer
    * @return the number of children written
    */
   public int getNodeChildren(int node, IntBuffer dest);

   /**
    * Adds the Children nodes of the <code>node</code> to the {@link IntBuffer} possibly in reverse order.
    * <br>
    * @param node the parent from which to collect children nodes.
    * @param dest The destination buffer
    * @param reverse
    * @return the number of children nodes added to the buffer
    */
   public int getNodeChildren(int node, IntBuffer dest, boolean reverse);

   /**
    * Returns the number of children for the node.
    * <br>
    * <br>
    * @param node
    * @return
    */
   public int getNodeFamilySize(int node);

   /**
    * 
    * @return
    */
   public int getFirstNode();

   /**
    * The upper numeric bounder on node pointers.
    * @return
    */
   public int getLastNode();

   /**
    * An int pointer/hash representation of the data stored at the node.
    * Might be 0 by default if no data and only flags are stored.
    * <br>
    * <br>
    * 
    * @param node
    * @return
    */
   public int getNodePayload(int node);

   /**
    * Creates a full node description in a {@link TrieNode} for the given node.
    * <br>
    * <br>
    * that desc mainly family size and child pointer
    * <br>
    * <br>
    * @return the class for all the trie node data
    */
   public TrieNode getNode(int node);

   /**
    * Return the parent node, if possible
    * <br>
    * <br>
    * @param node
    * @return
    */
   public int getNodeParent(int node);

   /**
    * 
    * @param node
    * @return
    */
   public int getNodeSisterLeft(int node);

   /**
    * 
    * @param node
    * @return
    */
   public int getNodeSisterRight(int node);

   /**
    * 
    * @return the number of nodes stored by the class
    */
   public int getNumberOfNodes();

   /**
    * A leaf does not have children
    * 
    * @param node
    * @return
    */
   public boolean isLeaf(int node);

   /**
    * Fills the toplogy for the node.
    * <br>
    * <br>
    * This is done to lighten the {@link IPowerTrieNodes} interface and avoid all those countValue/getToplogyValue
    * method spamming this interface. It will make the addition of topologies easier.
    * <br>
    * <br>
    * 
    * @param tnt topology requested
    * @return
    */
   public void getTopology(TrieNodeTopo tnt);

   /**
    * Returns the root node
    * <br>
    * <br>
    * 
    * @return
    */
   public int getRootNode();

   /**
    * 
    * <li> user node flag
    * <li> custom from subclass: example dictionnary word flag 
    * 
    * @param node
    * @param flag
    * @return
    */
   public boolean hasNodeFlag(int node, int flag);

   /**
    * Node values have the own topolgy. But usually starts at 0 or 1 and go up.
    * <br>
    * This method returns the next node value. This method is called when adding a singleton leaf under a parent node.
    * <br>
    * <br>
    * 
    * @return
    */
   public int nextNode();

   /**
    * Sets flags from the defined possibilities. Number of flags is defined at the constructor level.
    * <br>
    * <br>
    * Flag values are dynamically decided after the 2 base flag
    * <li> {@link IPowerTrieNodes#NODE_FLAG_1_USER_NODE}.
    * 
    * Check if this is a user node i
    * <br>
    * <br>
    * @param node
    * @param flag
    * @param v
    */
   public void setNodeFlag(int node, int flag, boolean v);

   /**
    * Split a node. so that both nod The new node is a child of node. Parentage is transfered to the new node.
    * <br>
    * <br>
    * The caller of this method must re-arrange other data to fit its needs. At this level we don't know about data.
    * <br>
    * <br>
    * Splitting a leaf is like add a new node with {@link IPowerTrieNodes#addChild(int, int)}
    * <br>
    * <br>
    * 
    * @param node
    * @return the first node, and the second now node.
    */
   public int splitNode(int node);

   /**
    * Adds a node so that firstPL is first, secondPL is second
    * <br>
    * <br>
    * Returns the node which has the secondPL and returns the children.
    * Get parent would returns the extended node. Parent of that one returns the
    * parent node of original node.
    * <br>
    * <br>
    * Depending on node configuration, the value node after the call is uncertain.
    * <br>
    * <br>
    * The end node keeps the flags.
    * <br>
    * <br>
    * 
    * @param node
    * @param firstPL
    * @param secondPL
    * @return
    */
   public int payLoadSplit(int node, int firstPL, int secondPL);

   //#debug
   public String toStringNode(int i);
}
