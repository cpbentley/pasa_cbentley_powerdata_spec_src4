package pasa.cbentley.powerdata.spec.src4.power.itech;

/**
 * Defines the parameter options of a {@link TrieSearchSession}.
 * <br>
 * <br>
 * 
 * @author Charles Bentley
 *
 */
public interface ITechSearchTrie extends ITechSearchChar {

   /**
    * Only return words
    */
   public static final int SEARCTRIE_TYPE_0_WORDS       = 0;

   /**
    * 
    */
   public static final int SEARCTRIE_TYPE_1_LEAVES      = 1;

   public static final int SEARCH_TRIE_BASIC_SIZE       = SEARCH_CHAR_BASIC_SIZE + 7;

   /**
    * Use the accept to verify if a String is a valid search result
    */
   public static final int FLAG_SEARCH_TRIE_01_ACCEPTOR = 1;

   public static final int SEARCH_TRIE_OFFSET_01_FLAG   = SEARCH_CHAR_BASIC_SIZE;

   /**
    * 
    */
   public static final int SEARCH_TRIE_OFFSET_02_TYPE1  = SEARCH_CHAR_BASIC_SIZE + 1;

}
