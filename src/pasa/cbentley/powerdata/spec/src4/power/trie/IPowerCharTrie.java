package pasa.cbentley.powerdata.spec.src4.power.trie;

import pasa.cbentley.core.src4.structs.IntToStrings;
import pasa.cbentley.powerdata.spec.src4.guicontrols.IPrefixSearchSession;
import pasa.cbentley.powerdata.spec.src4.power.IPowerCharCollector;
import pasa.cbentley.powerdata.spec.src4.power.IPowerDataTypes;

/**
 * A Trie with both prefix and array table abilities. However the suffix only works with a word id
 * <br>
 * <br>
 * Services used by
 * <br>
 * <br>
 * A CharTrie is able to associate an integer value to each String.
 * <br>
 * When this feature is disabled, those methods return 0.
 * <br>
 * <br>
 * 
 * Tech is specified by 
 * @author Charles Bentley
 *
 */
public interface IPowerCharTrie extends IPowerCharCollector {
   public static final int INT_ID = IPowerDataTypes.INT_23_CHAR_TRIE;

   /**
    * Count the number of words prefixed by the string matching the wordid
    * <br>
    * <br>
    * @param wordid
    * @return
    */
   public int countWords(int wordid);

   /**
    * Count the words prefix by string
    * <br>
    * <br>
    * @param prefix
    * @return
    */
   public int countWords(String prefix);

   /**
    * Convenience method
    * @param prefix
    * @return
    */
   public IntToStrings getPrefixed(String prefix);

   public boolean isWord(int pointer);

   /**
    * The pointer of the first lemme matching the prefix.
    * <br>
    * With words alliance and all. 
    * <li> Prefix al returns the pointer for all.
    * <li> Prefix al returns the pointer for all.
    * With words alliance and all and altitude.
    * <li> Prefix al returns the pointer for al node.
    * <br>
    * The pointer doesn't point to a user word. but is a valid node.
    * <br>
    * @param prefix
    * @return
    */
   public int getPrefixPointer(String str, ICharComparator tss);

   public IPrefixSearchSession searchPrefix(int frameSize);

}
