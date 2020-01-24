package pasa.cbentley.powerdata.spec.src4.guicontrols;

import pasa.cbentley.core.src4.structs.IntBuffer;
import pasa.cbentley.powerdata.spec.src4.power.trie.IPowerCharTrie;

/**
 * State control of the {@link ICharTrie} search.
 * <br>
 * <br>
 * Enables framed search.
 * <br>
 * <li>remembers the last visited node in a Trie
 * <li>define the maximum number of results
 * <br>
 * <br>
 * @author Charles Bentley
 *
 */
public class SearchSession {

   public int       customIndex;

   /**
    * When a search is looking into the base CharTrie and also in auxilliary tries?
    * How do you define that? That will depend on the CharTrie implementation.
    * <br>
    * <br>
    * Customs also allows to some word ids to be associated with a prefix, so this word is shown
    * first in the list.
    * 
    */
   public int[]     customs;

   
   /**
    * Tracks the last visited nodes. This can be seen as a row in all the Trie entries.
    * <br>
    * <br>
    * When looking for strings prefixed with ea
    * <li>eat
    * <li>eaten
    */
   public IntBuffer lastVisitedRow;

   private int      prefixLen;

   /**
    * the maximum number of words to be looked for during each {@link IPowerCharTrie#search(TrieSearchSession)} calls
    */
   public int       max = 0;

   /**
    * Temporary node value holder used by the CharTrie when searching down.
    * <br>
    * <br>
    * Once the {@link IPowerCharTrie#search(TrieSearchSession)} call returns, it holds the node of the last word.
    */
   public int       node;

   private int      prefixOffset;

   private char[]   prefix;

   /**
    * The Trie Nodes that represent the prefix.
    * <br>
    * <br>
    * Once built, the Trie search can re-use it.
    * <br>
    * <br>
    * {@link ICharTrie#getWord(int)}
    */
   public IntBuffer prefixNodes;

   /**
    * The node of the prefix or more
    * 
    * Prefix "prem" might be matched to node "premi" because i is internally merged to prem.
    */
   public int       searchRootNode;

   public SearchSession() {
   }

   public SearchSession(char[] prefix, int offset, int len, int max) {
      this.prefix = prefix;
      this.prefixOffset = offset;
      this.prefixLen = len;
      this.max = max;
   }

   public SearchSession(String prefix, int max) {
      this.prefix = prefix.toCharArray();
      this.max = max;
   }

   public String getPrefix() {
      return new String(prefix, prefixOffset, prefixLen);
   }

   private void reset() {
      node = 0;
      customIndex = 0;
      customs = null;
      prefixNodes = null;
      lastVisitedRow = null;
   }

   public void resetPrefix(char[] prefix, int offset, int len) {
      this.prefix = prefix;
      this.prefixOffset = offset;
      this.prefixLen = len;
      reset();
   }

   public void resetPrefix(String prefix) {
      resetPrefix(prefix, this.max);
   }

   public void resetPrefix(String prefix, int max) {
      this.prefix = prefix.toCharArray();
      this.prefixOffset = 0;
      this.prefixLen = prefix.length();
      this.max = max;
      reset();
   }

}