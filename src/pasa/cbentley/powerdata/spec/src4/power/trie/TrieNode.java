package pasa.cbentley.powerdata.spec.src4.power.trie;

/**
 * Specifies the data fields of a single node.
 * <li>Size of Family
 * <li>Pointer to first child node
 * <li>Pointer to parent node (for suffix look up)
 * <br>
 * <br>
 * Common to all Trie APIs
 * <br>
 * <br>
 * 
 * @author Charles Bentley
 *
 */
public class TrieNode {
   /**
    * Parent Node.
    * <br>
    * <br>
    * This value is 0 when parentage is not computable.
    */
   public int parentPointer;

   /**
    * The number of children.
    * <br>
    * <br>
    * 0 when leaf.
    */
   public int familySize;

   /**
    * the first child node.
    * <br>
    * <br>
    * Other children are fetched using 
    * <li> sisterRight
    * <li> familySize
    * <br>
    * <br>
    * This depends on the trie node data structure.
    */
   public int childPointer;

   /**
    * Some trie data implementation compute this value.
    */
   public int sisterLeft;

   /**
    * 
    */
   public int sisterRight;

   /**
    * the node
    */
   public int node;
   
   /**
    * Set to true when childPointer points to a suffix trie node. For the {@link IPowerTrieNodes} instance this value is meaningless. 
    * Only the suffix trie can use it.
    * <br>
    * <br>
    * A suffix node still has data regarding the char pointer
    */
   public int isSuffix;

   public int data;

   public String toString() {
      return familySize + ":" + childPointer + ">" + parentPointer;
   }
}
