package pasa.cbentley.powerdata.spec.src4.guicontrols;

import pasa.cbentley.core.src4.structs.IntToStrings;
import pasa.cbentley.powerdata.spec.src4.ctx.PDCtxA;
import pasa.cbentley.powerdata.spec.src4.power.string.IPowerLinkTrieData;
import pasa.cbentley.powerdata.spec.src4.power.trie.IPowerCharTrie;

public class TrieUtilz {

   private PDCtxA pdc;

   public TrieUtilz(PDCtxA pdc) {
      this.pdc = pdc;
   }

   public IntToStrings getAllStrings(IPowerCharTrie pc) {
      return pc.getPrefixed("");
   }

   /**
    * Populate at nextempty the integer-word structure where integer is the word id in the Trie.
    * <br>
    * <br>
    * The word id is valid until a structural change happens in the Trie
    * <br>
    * <br>
    * @param prefix
    * @param offset
    * @param len
    * @param ss the search parameters
    * @param results the container for the prefixed words. start populate at nextempty
    */
   public IntToStrings getPrefixedStrings(IPowerCharTrie pc, String word) {
      return pc.searchPrefix(0).searchWait(word);
   }

   public IntToStrings getPrefixedStrings(IPowerCharTrie pc, String word, int v) {
      return pc.searchPrefix(v).searchWait(word);
   }

   /**
    * Return the translations and their node id in the Trie.
    * <br>
    * 
    * @param foreign
    * @param wordTrie
    * @param word
    * @return
    */
   public IntToStrings getTranslationsTable(IPowerCharTrie foreign, IPowerLinkTrieData wordTrie, String word) {
      int[] edata = wordTrie.getIntsFromKeyString(word);
      IntToStrings ar = new IntToStrings(pdc.getUCtx(), edata.length);
      for (int i = 0; i < edata.length; i++) {
         ar.add(edata[i], foreign.getKeyStringFromPointer(edata[i]));
      }
      ar.sort(true);
      return ar;
   }

}
