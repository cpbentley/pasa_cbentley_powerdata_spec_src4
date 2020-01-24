package pasa.cbentley.powerdata.spec.src4.guicontrols;

import pasa.cbentley.powerdata.spec.src4.power.trie.IPowerCharTrie;

/**
 * {@link IPowerCharTrie} wants to do a search.
 * 
 * {@link IPowerCharTrie#openSearch()}
 * 
 * 
 * @author Charles Bentley
 *
 */
public interface ISearchCallBack {

   /**
    * 
    * @param typel
    * @param searchSession
    */
   public void searchResult(int type, ISearchSession searchSession);
}
