package pasa.cbentley.powerdata.spec.src4.ctx;

import pasa.cbentley.byteobjects.src4.core.BOModuleAbstract;
import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.byteobjects.src4.interfaces.IJavaObjectFactory;
import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.powerdata.spec.src4.guicontrols.TrieUtilz;
import pasa.cbentley.powerdata.spec.src4.power.itech.MorphTech;

/**
 * The implementation of this API will subclass this context class
 * @author Charles Bentley
 *
 */
public abstract class PDCtxA extends ACtx {

   private final BOCtx boc;

   private TrieUtilz   trieU;

   private MorphTech   morphFactory;

   public MorphTech getMorphTech() {
      if (morphFactory == null) {
         morphFactory = new MorphTech(this);
      }
      return morphFactory;
   }

   public PDCtxA(UCtx uc, BOCtx boc) {
      super(uc);
      this.boc = boc;
   }

   public abstract BOModuleAbstract getBOModule();

   public BOCtx getBoc() {
      return boc;
   }

   public TrieUtilz getTrieU() {
      if (trieU == null) {
         trieU = new TrieUtilz(this);
      }
      return trieU;
   }

   /**
    * 
    * @param id
    * @return
    */
   public abstract IJavaObjectFactory getFactory(String id);
}
