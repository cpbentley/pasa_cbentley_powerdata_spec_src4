package pasa.cbentley.powerdata.spec.src4.power.trie;

public interface oldIPowerStringIntData {

   public void addWordData(String word, int data);

   /**
    * Adds a word to the {@link IPowerCharTrie} and store associate data in typed datastructure.
    * <br>
    * <br>
    * Data may be later retrieve with {@link IPowerCharTrie#getWordData(String, int)}
    * <br>
    * <br>
    * @param word
    * @param datatype
    * @param data
    */
   public void addWordData(String word, int datatype, int data);

   /**
    * 
    * @param word
    * @param datatype
    * @param datas
    */
   public void addWordData(String word, int datatype, int[] datas);

   public int getWordData(int wordid);

   public int getWordData(int wordid, int type);

   /**
    * Return the integer data for the default data type
    * @param str
    * @return WORD_NOT_FOUND ?  if str not in the Trie
    */
   public int getWordData(String word);

   /**
    * Gets the int data stored with {@link IPowerCharTrie#addWordData(String, int, int)} with the given type
    * <br>
    * <br>
    * @param word
    * @param datatype
    * @return
    */
   public int getWordData(String word, int datatype);

   /**
    * Get all datas stored with {@link IPowerCharTrie#addWordData(String, int, int)} with the given type
    * @param str
    * @param datatype
    * @return null if str not in the Trie
    */
   public int[] getWordDatas(String word, int datatype);
}
