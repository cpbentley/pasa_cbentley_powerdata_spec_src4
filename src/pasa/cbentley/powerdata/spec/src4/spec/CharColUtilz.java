package pasa.cbentley.powerdata.spec.src4.spec;

import pasa.cbentley.core.src4.helpers.StringBBuilder;
import pasa.cbentley.core.src4.io.FileReader;
import pasa.cbentley.core.src4.io.XString;
import pasa.cbentley.core.src4.logging.ITechLvl;
import pasa.cbentley.powerdata.spec.src4.ctx.PDCtxA;
import pasa.cbentley.powerdata.spec.src4.power.IPowerCharCollector;
import pasa.cbentley.powerdata.spec.src4.power.IPowerEnum;

public class CharColUtilz {

   protected final PDCtxA pdc;

   public CharColUtilz(PDCtxA pdc) {
      this.pdc = pdc;

   }

   /**
    * Get locks
    * @param cc
    * @param charp
    * @return
    */
   public static char[] get(IPowerCharCollector cc, int[] charp) {
      int size = 0;
      for (int i = 0; i < charp.length; i++) {
         size += cc.getLen(charp[i]);
      }
      char[] val = new char[size];
      int off = 0;
      for (int i = 0; i < charp.length; i++) {
         off += cc.copyChars(charp[i], val, off);
      }
      return val;
   }

   public void populate(IPowerCharCollector ct, String filename) {
      populate(ct, filename, "UTF-8");
   }

   /**
    * File with 1 word on each line.
    * 
    * Each word is {@link IPowerCharCollector#addChars(String)}.
    * 
    * @param ct
    * @param filename
    * @param encod
    */
   public void populate(IPowerCharCollector ct, String filename, String encod) {
      FileReader fr = new FileReader(pdc.getUCtx(), 300);
      fr.openFile(filename, encod);
      XString cp = null;
      int wordcount = 0;
      //problem with bom, there a lie with nothing
      fr.readCharLine();
      while ((cp = fr.readCharLine()) != null) {
         if (cp.getLen() == 0) {
            continue;
         }
         ct.addChars(cp.getChars(), cp.getOffset(), cp.getLen());
         wordcount++;

         if (wordcount % 5000 == 0) {
            //#debug
            pdc.toDLog().pTest("#words read=" + wordcount , fr, CharColUtilz.class, "populate", ITechLvl.LVL_05_FINE, true);
         }
      }
      fr.close();
   }

   public String toStringContent(IPowerCharCollector c) {
      return toStringContent(c, "\n\t", 10);
   }

   public String toStringContent(IPowerCharCollector c, String nl, int numRow) {
      StringBBuilder sb = new StringBBuilder(pdc.getUCtx());
      IPowerEnum e = c.getEnumOnCharCol(IPowerCharCollector.ENUM_TYPE_0_STRING, null);
      int count = 0;
      while (e.hasNext()) {
         String str = (String) e.getNext();
         sb.append(str);
         count++;
         if (count > numRow) {
            sb.append(nl);
            count = 0;
         } else {
            sb.append(" ");
         }
      }
      return sb.toString();
   }

}
