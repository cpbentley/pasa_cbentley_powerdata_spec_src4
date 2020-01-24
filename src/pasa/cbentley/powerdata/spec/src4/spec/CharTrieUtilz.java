package pasa.cbentley.powerdata.spec.src4.spec;

import pasa.cbentley.powerdata.spec.src4.power.trie.IPowerCharTrie;


public class CharTrieUtilz {

   public static IPowerCharTrie[] increaseCapacity(IPowerCharTrie[] ar, int addition) {
      IPowerCharTrie[] oldData = ar;
      ar = new IPowerCharTrie[oldData.length + addition];
      System.arraycopy(oldData, 0, ar, 0, oldData.length);
      return ar;
   }
}
