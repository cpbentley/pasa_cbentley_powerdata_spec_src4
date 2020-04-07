package pasa.cbentley.powerdata.spec.src4.ctx;

import pasa.cbentley.byteobjects.src4.core.BOModuleAbstract;
import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.byteobjects.src4.interfaces.IJavaObjectFactory;
import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.powerdata.spec.src4.IFactoryIDStruct;
import pasa.cbentley.powerdata.spec.src4.engine.MorphTech;
import pasa.cbentley.powerdata.spec.src4.engine.TechFactory;
import pasa.cbentley.powerdata.spec.src4.guicontrols.TrieUtilz;
import pasa.cbentley.powerdata.spec.src4.spec.CharColUtilz;

/**
 * The implementation of this API will subclass this context class
 * @author Charles Bentley
 *
 */
public abstract class PDCtxA extends ACtx {

   private final BOCtx boc;

   private CharColUtilz CharColUtilz;

   private MorphTech   morphFactory;

   private TechFactory techFactory;

   private TrieUtilz   trieU;

   public PDCtxA(UCtx uc, BOCtx boc) {
      super(uc);
      this.boc = boc;
   }

   public BOCtx getBOC() {
      return boc;
   }

   public abstract BOModuleAbstract getBOModule();

   public CharColUtilz getCharColUtilz() {
      if (CharColUtilz == null) {
         CharColUtilz = new CharColUtilz(this);
      }
      return CharColUtilz;
   }

   public IJavaObjectFactory getFactory() {
      return getFactory(IFactoryIDStruct.ID);
   }

   /**
    * 
    * @param id
    * @return
    */
   public abstract IJavaObjectFactory getFactory(String id);

   public MorphTech getMorphTech() {
      if (morphFactory == null) {
         morphFactory = new MorphTech(this);
      }
      return morphFactory;
   }

   public TechFactory getTechFactory() {
      if (techFactory == null) {
         techFactory = new TechFactory(this);
      }
      return techFactory;
   }

   public TrieUtilz getTrieU() {
      if (trieU == null) {
         trieU = new TrieUtilz(this);
      }
      return trieU;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "PDCtxA");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "PDCtxA");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
