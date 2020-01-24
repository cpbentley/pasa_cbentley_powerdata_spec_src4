package pasa.cbentley.powerdata.spec.src4.power.string;

import pasa.cbentley.powerdata.spec.src4.power.IPowerDataTypes;
import pasa.cbentley.powerdata.spec.src4.power.trie.IPowerCharTrie;

/**
 * Links Data to String in a {@link IPowerCharTrie}.
 * <br>
 * Convenience class 
 * <br>
 * Data can be typed.
 * <br>
 * @author Charles Bentley
 *
 */
public interface IPowerLinkTrieData extends IPowerCharTrie, IPowerLinkStringToIntArray {

   public static final int INT_ID = IPowerDataTypes.INT_55_TRIE_DATA_TYPE;

   /**
    * 
    * @param str
    * @param data
    * @param type
    */
   public void addIntToKeyStringType(int data, String str, int type);

   public void addIntToKeyStringType(int data, char[] chars, int offset, int len, int type);

   /**
    * Default type is
    * @param str
    * @return
    */
   public int[] getIntsFromKeyStringTyped(String str, int type);

   public int[] getIntsFromPointerType(int pointer, int type);

   public boolean isIntLinkedToKeyStringTyped(int data, String str, int type);
}
