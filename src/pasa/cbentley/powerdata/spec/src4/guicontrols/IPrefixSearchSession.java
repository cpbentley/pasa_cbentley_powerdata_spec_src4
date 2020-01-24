package pasa.cbentley.powerdata.spec.src4.guicontrols;

import pasa.cbentley.core.src4.structs.IntToStrings;

public interface IPrefixSearchSession extends ISearchSession {

   /**
    * Add String c to current prefix. returns updated results
    * @param c
    * @return
    */
   public IntToStrings searchAdd(String c);

   /**
    * Removes v chars from current prefix. Updates the results.
    * @param v
    * @return
    */
   public IntToStrings searchRemove(int v);
   
   /**
    * The possible chars at this current position.
    * <br>
    * Used to display the current char on a virtual keyboard
    * @return
    */
   public char[] nextPossibleChars();

}
