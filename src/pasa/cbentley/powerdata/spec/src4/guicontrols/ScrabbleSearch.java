package pasa.cbentley.powerdata.spec.src4.guicontrols;

import pasa.cbentley.byteobjects.src4.core.BOModuleAbstract;
import pasa.cbentley.core.src4.ctx.UCtx;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.core.src4.structs.IntToStrings;
import pasa.cbentley.core.src4.utils.StringUtils;
import pasa.cbentley.powerdata.spec.src4.ctx.PDCtxA;
import pasa.cbentley.powerdata.spec.src4.power.trie.IPowerCharTrie;

/**
 * Letter merge, filter some characters and replace them with its equivalance.
 * such as é is e, y is i.
 * <br>
 * <br>
 * @author Charles Bentley
 *
 */
public class ScrabbleSearch implements IStringable {

   private T9PrefixTrieSearch triesearch;

   public IntToStrings  results;

   public boolean       accentMerge        = false;

   //actively read by thread displaying progress bar
   public int           passiveProgress    = 0;

   //-1 means that maximum is unknown
   public int           passiveProgressMax = 0;

   private PDCtxA pdc;

   public ScrabbleSearch(PDCtxA pdc) {
      this.pdc = pdc;
      
   }
   /**
    * 
    * @param mod
    * @param source
    */
   public ScrabbleSearch(PDCtxA pdc, IPowerCharTrie source) {
      this.pdc = pdc;
      results = new IntToStrings(pdc.getUCtx(), 30);
      this.triesearch = new T9PrefixTrieSearch(pdc, source, 1);
   }

   /**
    * Search words composed of letters from chars of minimum size.
    * <br>
    * @param chars
    * @param minsize
    */
   public void search(char[] chars, int minsize) {
      triesearch.clear();
      results.nextempty = 0;
      int level = 1;
      //TODO char search equivalence � = e. y = i.
      if (accentMerge) {
         rec(chars, level, false, minsize, false, getAccentMergeOriginChars(chars));
      }
      rec(chars, level, false, minsize, false, chars);
   }

   public void search(char[] chars, int minsize, boolean onlyOriginalLetters) {
      triesearch.clear();
      results.nextempty = 0;
      int level = 1;
      if (accentMerge) {
         rec(chars, level, false, minsize, onlyOriginalLetters, getAccentMergeOriginChars(chars));
      }
      rec(chars, level, false, minsize, onlyOriginalLetters, chars);
   }

   private char[] getAccentMergeOriginChars(char[] chars) {
      char[] origin = new char[chars.length];
      int count = 0;
      for (int i = 0; i < chars.length; i++) {
         char[] m =  getStrU().getCharAccentMerge(chars[i]);
         if (m != null) {
            origin = pdc.getUCtx().getMem().increaseCapacity(origin, m.length - 1);
            for (int j = 0; j < m.length; j++) {
               origin[count] = m[j];
               count++;
            }
         } else {
            origin[count] = chars[i];
            count++;
         }
      }
      return origin;
   }
   
   public StringUtils getStrU() {
      return pdc.getUCtx().getStrU();
   }

   public IntToStrings getResults() {
      return results;
   }

   /**
    * search for words that anagrams chars
    * @param chars
    */
   public void searchAnagram(char[] chars) {
      triesearch.clear();
      results.nextempty = 0;
      rec(chars, 1, true, chars.length, false, null);
   }

   private boolean contains(char[] chars, int offset, int len, char c) {
      for (int i = offset; i < offset + len; i++) {
         if (chars[i] == c)
            return true;
      }
      return false;
   }

   /**
    * 
    * @param chars
    * @param level
    * @param anagram true if only anagrams are accepted. minsize is the exact size
    * @param minsize the minimum size of the words
    * @param onlyOriginalLetters words can only be composed of letters in origin
    * @param origin can be null if originalletters = false
    */
   private void rec(char[] chars, int level, boolean anagram, int minsize, boolean onlyOriginalLetters, char[] origin) {
      for (int i = 0; i < chars.length; i++) {
         //don't search in the same config with the same char again
         //add the char
         if (accentMerge) {
            char[] m = getStrU().getCharAccentMerge(chars[i]);
            if (m == null) {
               if (contains(chars, 0, i, chars[i]))
                  continue;
               triesearch.add(chars[i]);
            } else {
               if (contains(chars, 0, i, chars[i]))
                  continue;
               //accent merging only if main letter
               triesearch.add(m);
            }
         } else {
            //if character is
            if (contains(chars, 0, i, chars[i]))
               continue;
            triesearch.add(chars[i]);
         }
         //if adding the chars at this level produces some result
         if (triesearch.getResults().nextempty != 0) {
            //if we reached recording level starting
            if (level >= minsize) {
               for (int j = 0; j < triesearch.getResults().nextempty; j++) {
                  boolean accept = true;
                  if (anagram) {
                     if (triesearch.getResults().strings[j].length() != minsize)
                        accept = false;
                  } else if (onlyOriginalLetters) {
                     //in the prefixed mangez,onlyOriginal removes mangaillez
                     String s = triesearch.getResults().strings[j];
                     int len = s.length();
                     for (int cha = 0; cha < len; cha++) {
                        if (!contains(origin, 0, origin.length, s.charAt(cha))) {
                           accept = false;
                           break;
                        }
                     }
                  }
                  if (results.findInt(triesearch.getResults().ints[j]) != -1)
                     accept = false;
                  //
                  if (accept)
                     results.add(triesearch.getResults().ints[j], triesearch.getResults().strings[j]);
               }
            }
            char[] sub = getSubSet(chars, i);
            //continue to next level
            rec(sub, level + 1, anagram, minsize, onlyOriginalLetters, origin);
         }
         triesearch.stepBack();
         //next letter

      }
   }

   private char[] getSubSet(char[] chars, int removeindex) {
      char[] n = new char[chars.length - 1];
      int count = 0;
      for (int i = 0; i < removeindex; i++) {
         n[count] = chars[i];
         count++;
      }
      for (int i = removeindex + 1; i < chars.length; i++) {
         n[count] = chars[i];
         count++;
      }
      return n;
   }

   //#mdebug
   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, "ScrabbleSearch");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "ScrabbleSearch");
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return pdc.getUCtx();
   }

   //#enddebug
   

}
