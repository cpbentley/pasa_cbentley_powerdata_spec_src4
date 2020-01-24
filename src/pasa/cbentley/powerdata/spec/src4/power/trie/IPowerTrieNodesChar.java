package pasa.cbentley.powerdata.spec.src4.power.trie;

import pasa.cbentley.core.src4.helpers.StringBBuilder;
import pasa.cbentley.powerdata.spec.src4.power.IPowerCharCollector;
import pasa.cbentley.powerdata.spec.src4.power.IPowerDataTypes;

/**
 * Trie Node data for a character Trie.
 * <br>
 * <br>
 * 
 * @author Charles Bentley
 *
 */
public interface IPowerTrieNodesChar extends IPowerTrieNodes {

   public static final int INT_ID = IPowerDataTypes.INT_45_TRIE_NODE_DATA_CHAR;

   public void setCharPointer(int node, int pointer);

   /**
    * Gets the Char Pointer to later retrieve the string stored at this node
    * <br>
    * <br>
    * @param node
    * @return
    */
   public int getNodeCharPointer(int node);

   public char getNodeChar(int node);

   /**
    * Return the store characters at that node
    * <br>
    * <br>
    * @param c
    * @return
    */
   public char[] getNodeChars(int node);

   /**
    * Look up the child node of node that starts with mychar using the given comparator.
    * <br>
    * <br>
    * If comparator is null, simply use raw equality.
    * <br>
    * <br>
    * 
    * When using suffix direct linking, it will returns -1.
    * <br>
    * The Trie implementation must detect suffix leaf and act accordingly.
    * <br>
    * <br>
    * @param mychar
    * @param node
    * @return IPowerTrieNodes.CHILD_NODE_NOT_FOUND
    */
   public int nodeFindCharChild(char mychar, int node, ICharComparator icc);

   /**
    * 
    * @param mychar
    * @param node
    * @return
    */
   public int nodeFindCharChild(char mychar, int node);

   /**
    * The position or would be position of mychar as the children of node.
    * <br>
    * <br>
    * 
    * @param mychar
    * @param node
    * @return
    */
   public int getFamilyPosition(char mychar, int node);

   public int nodeAddCharChild(int node, char c);

   /**
    * 
    * @param node
    * @param c
    * @param offset
    * @param len
    * @return
    */
   public int nodeAddCharChild(int node, char[] c, int offset, int len);

   public void setCharsAtNode(int node, char[] c, int offset, int len);

   /**
    * Returns the structure used to store char data.
    * <br>
    * <br>
    * Noramlly when morphing, things are done internally.
    * @return
    */
   public IPowerCharCollector getCharCo();

   public void appendNodeChars(int node, StringBBuilder sb);

   /**
    * Sets the structure to be used if one is used
    * @param cc
    */
   public void setCharCo(IPowerCharCollector cc);

}
