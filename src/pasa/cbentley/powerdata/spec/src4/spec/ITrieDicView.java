package pasa.cbentley.powerdata.spec.src4.spec;

import pasa.cbentley.core.src4.structs.IntToStrings;

/**
 * An GUI class that want to search a Trie Dictionnary implements this interface.
 * <br>
 * <br>
 * It must be able to display {@link IntToStrings} built by the Trie Dictionnary search mechanism.
 * <br>
 * <br>
 * @author Charles Bentley
 *
 */
public interface ITrieDicView {

   /**
    * The timer
    * @return 0 if no wait time
    */
   //public int getWaitTime();

   /**
    * Strings for the last search
    * @param its 
    */
   public void setValues(IntToStrings its);

   public void setTransValues(IntToStrings trans);
}
