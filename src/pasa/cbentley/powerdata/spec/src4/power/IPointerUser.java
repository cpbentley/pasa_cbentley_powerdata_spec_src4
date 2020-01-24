package pasa.cbentley.powerdata.spec.src4.power;

import pasa.cbentley.core.src4.structs.IntToInts;
import pasa.cbentley.powerdata.spec.src4.power.integers.IPowerLinkIntToInt;
import pasa.cbentley.powerdata.spec.src4.power.itech.ITechPointerStruct;

/**
 * Each time a {@link ITechPointerStruct} modifies its structure so that pointers are modified, a non null {@link IPointerUser}
 * is requested to change its pointers according to the mapping function.
 * <br>
 * <br>
 * Structures with stable pointers will not call the update call back.
 * <br>
 * <br>
 * 
 * @author Charles Bentley
 *
 */
public interface IPointerUser {

   /**
    *  Return the array containing the link between
    * a rearrangement of pointers for the old Collector when going from Run to Build
    * or Build to Run or after a change.
    * <br>
    * <br>
    * linking updates automatically for several changes in a row when this method is not called.
    * 
    * When a non stable CharTrie or {@link IPowerCharCollector} modifies its node arrangement, the function for updaing
    * <br>
    * TODO make it an interface function. Int To Int Mapper. 
    * {@link IPowerLinkIntToInt}
    * <br>
    * <br>
    * The mapping must be copied. The initial values will change once a new update is made.
    * <br>
    * <br>
    * 
    * @param struct
    * @param mapping the int[] array of {@link IntToInts} function for finding the pointer function.
    */
   public void updatePointers(Object struct, Object mapping);

   /**
    * 
    * @param struct
    * @param newPointer
    * @param oldPointer
    */
   public void pointerSwap(Object struct, int newPointer, int oldPointer);
}
