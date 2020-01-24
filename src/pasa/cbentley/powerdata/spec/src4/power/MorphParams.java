package pasa.cbentley.powerdata.spec.src4.power;

import pasa.cbentley.byteobjects.src4.core.ByteController;

/**
 * Describes the Morphing of {@link IDataMorphable} object into.
 * 
 * 
 * @author Charles Bentley
 *
 */
public class MorphParams {
   public ByteController bc;

   public Class          cl;

   /**
    * Truen when morph successfully done without changing reference
    */
   public boolean        insideSuccess;

   /**
    * Try to morph inside and returns this
    */
   public boolean        tryInside;

   public int            type;

   public MorphParams() {

   }

   public MorphParams(Class cl) {
      this.cl = cl;
   }

}
