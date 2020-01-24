package pasa.cbentley.powerdata.spec.src4.guicontrols;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.core.src4.structs.IntToStrings;
import pasa.cbentley.powerdata.spec.src4.ctx.PDCtxA;
import pasa.cbentley.powerdata.spec.src4.power.string.IPowerLinkTrieData;
import pasa.cbentley.powerdata.spec.src4.power.trie.IPowerCharTrie;
import pasa.cbentley.powerdata.spec.src4.spec.ITrieDicView;

/**
 * 
 * @author Charles Bentley
 *
 */
public class TrieTranslationSearch implements IStringable {

   private IntToStrings         its;

   private int                  max = 10;

   private IPrefixSearchSession searchSession;

   private boolean              toggle;

   private IPowerCharTrie       trieSourceForeign;

   private IPowerCharTrie       trieSourceNative;

   private IPowerCharTrie       trieWorkForeign;

   private IPowerCharTrie       trieWorkNative;

   private IPowerLinkTrieData   native2Foreign;

   private IPowerLinkTrieData   foreign2Native;

   private ITrieDicView         view;

   private PDCtxA               pdc;

   public TrieTranslationSearch(PDCtxA pdc, ITrieDicView view) {
      this.pdc = pdc;
      this.view = view;
      setTrie();
   }

   public void initTries(IPowerLinkTrieData nativeTrie, IPowerLinkTrieData transla) {
      native2Foreign = nativeTrie;
      foreign2Native = transla;
      trieSourceNative = (IPowerCharTrie) nativeTrie.getStringStructure();
      trieSourceForeign = (IPowerCharTrie) transla.getStringStructure();
      setTrie();
   }

   private void setTrie() {
      if (toggle) {
         trieWorkForeign = trieSourceNative;
         trieWorkNative = trieSourceForeign;
      } else {
         trieWorkForeign = trieSourceForeign;
         trieWorkNative = trieSourceNative;
      }
   }

   /**
    * 
    * @param s
    */
   public void task1(final String s) {
      if (s.equals("")) {
         return;
      }
      pdc.getUCtx().getWorkerThread().addToQueue(new Runnable() {
         public void run() {
            try {
               searchSession.reset(s);
               // else we use the same.
               its = searchSession.searchWait();
               view.setValues(its);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * if conditions permit it, show the strings in Its
    */
   public void task2() {

   }

   /**
    * toggles the translation A-B to B-A
    */
   public void toggle() {
      toggle = !toggle;
      setTrie();
   }

   public void translate(final String s) {
      pdc.getUCtx().getWorkerThread().addToQueue(new Runnable() {
         public void run() {
            //#debug
            System.out.println("Translating " + s);
            IntToStrings trans = pdc.getTrieU().getTranslationsTable(trieWorkForeign, native2Foreign, s);
            view.setTransValues(trans);
         }
      });
   }

   //#mdebug
   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, "TrieTranslationSearch");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "TrieTranslationSearch");
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return pdc.getUCtx();
   }

   //#enddebug

}
