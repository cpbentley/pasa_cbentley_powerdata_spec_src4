package pasa.cbentley.powerdata.spec.src4.power.string;

import pasa.cbentley.powerdata.spec.src4.power.IDataMorphable;
import pasa.cbentley.powerdata.spec.src4.power.IPowerDataTypes;

/**
 * Associate byte data to a String (key). Fast searches on key String to find associated value.
 * <br>
 * <br>
 * old IStringIndex (that was a poor choice of words!)
 * <br>
 * <br>
 * It may link in such a way that it behaves like an index.
 * <br>
 * 
 * 
 * @author Charles Bentley
 *
 */
public interface IPowerLinkStringToBytes extends IDataMorphable {

   public static final int INT_ID = IPowerDataTypes.INT_25_LINK_STRING;

   /**
    * Look for String s in the Index and return the associated int value
    * <br>
    * <br>
    * @param s
    * @return`-1 if not found
    */
   public int findAsInt(String s);

   /**
    * Link a word to an integer data.
    * <br>
    * Data format?
    * <br>
    * <br>
    * 
    * @param word
    * @param rid
    */
   public void insertWord(char[] word, int rid);

   public void insertWord(char[] word, int offset, int len, int rid);

   public void insertWord(char[] word, int offset, int len, byte[] data, int numbits);

   /**
    * Tag the word from the structure as removed. could be added again
    */
   public void removeWord(String s);

   public void removeWord(char[] word, int offset, int len);

   public void removeWord(char[] word);

   /**
    * 
    * @param c
    * @param offset
    * @param len
    * @return
    */
   public byte[] find(char[] c, int offset, int len);
}
