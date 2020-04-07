package pasa.cbentley.powerdata.spec.src4.engine;

import pasa.cbentley.byteobjects.src4.core.ByteObjectManaged;
import pasa.cbentley.byteobjects.src4.core.ByteObjectManagedFactory;
import pasa.cbentley.powerdata.spec.src4.ctx.PDCtxA;
import pasa.cbentley.powerdata.spec.src4.power.itech.ITechMorph;
import pasa.cbentley.powerdata.spec.src4.power.itech.ITechPointerStruct;

/**
 * 
 * @author Charles Bentley
 *
 */
public class MorphTech {

   private PDCtxA pdc;

   /**
    * 
    * @param pdc
    */
   public MorphTech(PDCtxA pdc) {
      this.pdc = pdc;
   }

   /**
    * Mode defaults to Build
    * <br>
    * <br>
    * Defines the Interface we want. The implementation is unknown.
    * <br>
    * @param mod
    * @param intID
    * @param modeFlags
    * @return
    */
   public ByteObjectManaged getMorph(int intID, int modeFlags) {
      int hSize = ITechMorph.MORPH_BASIC_SIZE;
      int classID = 0;
      ByteObjectManaged bom = getBomBase(intID, hSize, classID);
      bom.set1(ITechMorph.MORPH_OFFSET_02_MODE1, modeFlags);
      bom.setFlag(ITechMorph.MORPH_OFFSET_01_FLAG, ITechMorph.MORPH_FLAG_7_INTID_DEF, true);
      return bom;
   }

   private ByteObjectManaged getBomBase(int intID, int hSize, int classID) {
      ByteObjectManagedFactory factory = pdc.getBOC().getByteObjectManagedFactory();
      ByteObjectManaged bom = factory.getTechDefault(hSize, classID, intID);
      return bom;
   }

   public ByteObjectManaged getMorphTest(int intID) {
      int hSize = ITechMorph.MORPH_BASIC_SIZE;
      int classID = 0;
      ByteObjectManaged bom = getBomBase(intID, hSize, classID);
      bom.set1(ITechMorph.MORPH_OFFSET_02_MODE1, ITechMorph.MODE_1_BUILD);
      bom.setFlag(ITechMorph.MORPH_OFFSET_01_FLAG, ITechMorph.MORPH_FLAG_7_INTID_DEF, true);
      return bom;
   }

   public ByteObjectManaged getPointerTech(int intID, int modeFlags) {
      int hSize = ITechPointerStruct.PS_BASIC_SIZE;
      int classID = 0;
      ByteObjectManaged bom = getBomBase(intID, hSize, classID);
      bom.set1(ITechMorph.MORPH_OFFSET_02_MODE1, modeFlags);
      bom.setFlag(ITechMorph.MORPH_OFFSET_01_FLAG, ITechMorph.MORPH_FLAG_7_INTID_DEF, true);
      return bom;
   }

}
