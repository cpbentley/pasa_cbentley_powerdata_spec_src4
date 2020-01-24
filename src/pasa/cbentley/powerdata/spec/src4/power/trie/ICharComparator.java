package pasa.cbentley.powerdata.spec.src4.power.trie;

public interface ICharComparator {

   /**
    * Is the method bijective?
    * <br>
    * <br>
    * We may want 'é' not be equal to e but 'e' to match 'é'
    * <br>
    * <br>
    * 
    * @param c1 prefix char
    * @param c2 node char
    * @return
    */
   public boolean isEqual(char c1, char c2);
}
