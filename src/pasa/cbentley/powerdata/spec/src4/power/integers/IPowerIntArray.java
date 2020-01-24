package pasa.cbentley.powerdata.spec.src4.power.integers;

import pasa.cbentley.powerdata.spec.src4.power.IDataMorphable;

/**
 * Interface to an int[] array.
 * 
 * <li> {@link IntBuffer}
 * <br>
 * <br>
 * No assumption is made relative to data.
 * <br>
 * <br>
 * Key is the index.
 * <br>
 * <br>
 * 
 * @author Charles Bentley
 *
 */
public interface IPowerIntArray extends IDataMorphable {

   public void addValue(int value);

   public boolean hasValue(int value);

   public int remove(int value);

   public int getSize();

   /**
    * Values
    * @return
    */
   public int[] getValues();
}
