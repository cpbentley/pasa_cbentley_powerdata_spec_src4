package pasa.cbentley.powerdata.spec.src4.guicontrols;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.core.src4.structs.IntToStrings;
import pasa.cbentley.powerdata.spec.src4.ctx.PDCtxA;
import pasa.cbentley.powerdata.spec.src4.power.trie.IPowerCharTrie;

/**
 * This kind of search does not use a fixed prefix.
 * <br>
 * Prefix is a multi plex of several characters.
 * <br>
 * Instead, several chars
 * Class managing the search for T9 input.
 * <br>
 * <br>
 * What this class does
 * A char[] array of possibilities.
 * <br>
 * <br>
 * 
 * @author Charles Bentley
 *
 */
public class T9PrefixTrieSearch implements IStringable {

   /**
    * max words returned per search
    */
   public static int            max           = 300;

   public static int            startSize     = 40;

   /**
    * tracks in print array memory
    */
   private int[]                addedAtLevel;

   /**
    * Counts the number of valid branches.
    * start at zero for the root
    */
   private int                  countBranches = 0;

   private int                  deepNessLevel;

   /**
    * 
    */
   private boolean[]            isChecked;

   /**
    * tracks the word length in print memory
    */
   private int[]                lengths;

   public int                   maxLevelSize  = 40;

   private int                  maxWordLength = 40;

   private PDCtxA               pdc;

   /**
    * 
    */
   private char[][]             print;

   private IntToStrings         results;

   private IPowerCharTrie       source;

   /**
    * The {@link TrieSearchSession} used to search a new combination of possibilities.
    * <br>
    */
   private IPrefixSearchSession ss;

   public T9PrefixTrieSearch(PDCtxA pdc, IPowerCharTrie source) {
      this(pdc, source, max);
   }

   /**
    * 
    * @param source
    * @param max stop searching once max number of strings have been found
    */
   public T9PrefixTrieSearch(PDCtxA pdc, IPowerCharTrie source, int max) {
      this.pdc = pdc;
      this.source = source;
      ss = source.searchPrefix(max);
      results = new IntToStrings(pdc.getUCtx(), 30);
      print = new char[startSize][maxLevelSize];
      isChecked = new boolean[startSize];
      lengths = new int[startSize];
      int lvl = source.getBiggestWordSize();
      if (lvl == -1)
         lvl = maxLevelSize;
      addedAtLevel = new int[lvl];

   }

   public void add(char c) {
      int branchCounter = 0;
      deepNessLevel++; //we go next level in deepness
      if (countBranches == 0) {
         isChecked[0] = true;
      }
      results.nextempty = 0;
      int end = countBranches;
      //for 
      for (int i = 0; i <= end; i++) {
         if (isChecked[i]) {
            int len = lengths[i];
            print[i][len] = c;
            if (source.hasChars(print[i], 0, len + 1)) {
               addBranch(print[i], 0, len + 1);
               branchCounter++; //counter for new branches
               //search words for the new prefix
               ss.reset(print[i], 0, len + 1);
               //finds are added to results
               ss.search();
               //copy the results
               results.add(ss.getResults());
            }
            isChecked[i] = false;
         }
      }
      addedAtLevel[deepNessLevel] = branchCounter;
   }

   /**
    * Reset the results and return a 
    * @param chars
    */
   public void add(char[] chars) {
      int branchCounter = 0;
      deepNessLevel++; //we go next level in deepness
      if (countBranches == 0) {
         isChecked[0] = true;
      }
      results.nextempty = 0;
      int end = countBranches;
      for (int i = 0; i <= end; i++) {
         if (isChecked[i]) {
            for (int j = 0; j < chars.length; j++) {
               int len = lengths[i];
               print[i][len] = chars[j];
               if (source.hasChars(print[i], 0, len + 1)) {
                  addBranch(print[i], 0, len + 1);
                  branchCounter++; //counter for new branches
                  //search words for the new prefix
                  ss.reset(print[i], 0, len + 1);
                  //finds are added to results
                  ss.search();
                  //copy the results
                  results.add(ss.getResults());
               }
            }
            isChecked[i] = false;
         }
      }
      addedAtLevel[deepNessLevel] = branchCounter;
   }

   /**
    * Add value
    * @param cs
    * @param offset
    * @param len
    */
   private void addBranch(char[] cs, int offset, int len) {
      countBranches++;
      isChecked[countBranches] = true;
      lengths[countBranches] = len;
      int c = 0;
      for (int i = offset; i < offset + len; i++) {
         print[countBranches][c] = cs[i];
         c++;
      }
   }

   public void clear() {
      countBranches = 0;
   }

   public IntToStrings getResults() {
      return results;
   }

   private int process(int i, char c, int branchCounter) {
      if (isChecked[i]) {
         int len = lengths[i];
         print[i][len] = c;
         if (source.hasChars(print[i], 0, len + 1)) {
            addBranch(print[i], 0, len + 1);
            branchCounter++; //counter for new branches
            //search words for the new prefix
            ss.reset(print[i], 0, len + 1);
            //finds are added to results
            ss.search();
            //copy the results
            results.add(ss.getResults());
         }
         isChecked[i] = false;
      }
      return branchCounter;
   }

   public void setCharTrie(IPowerCharTrie trie) {
      clear();
      results.nextempty = 0;
      source = trie;
   }

   /**
    * Take one step back.
    * remove the last added value
    */
   public void stepBack() {
      if (deepNessLevel == 0)
         return;
      //remove the last added
      countBranches = countBranches - addedAtLevel[deepNessLevel];
      deepNessLevel--;
      countBranches = countBranches - addedAtLevel[deepNessLevel];
      //bring back the true
      for (int i = countBranches + 1; i <= countBranches + addedAtLevel[deepNessLevel]; i++) {
         isChecked[i] = true;
      }
      results.nextempty = 0;
      //compute back the prefix
      for (int i = 0; i <= countBranches + addedAtLevel[deepNessLevel]; i++) {
         if (isChecked[i]) {
            ss.reset(print[i], 0, lengths[i]);
            ss.search();
            //copy the results
            results.add(ss.getResults());
         }
      }
      countBranches += addedAtLevel[deepNessLevel];
   }

   //#mdebug
   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, "T9PrefixTrieSearch");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "T9PrefixTrieSearch");
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return pdc.getUCtx();
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
