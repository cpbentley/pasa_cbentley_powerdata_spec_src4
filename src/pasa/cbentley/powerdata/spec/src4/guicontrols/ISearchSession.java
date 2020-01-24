package pasa.cbentley.powerdata.spec.src4.guicontrols;

import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.core.src4.structs.IntToStrings;
import pasa.cbentley.powerdata.spec.src4.power.IPowerCharCollector;

/**
 * <li>Prefix searchs?
 * <li>Suffixes searches
 * <li>Contains substring
 * <li>
 * When the class is not optimized, it does an enumeration
 * and check the condition on every Strings inside.
 * <br>
 * @author Charles Bentley
 *
 */
public interface ISearchSession extends IStringable {

   /**
    * Notify action type
    * Word was selected. Word is demoted. Word is promoted.
    * <br>
    * Depends on user action.
    * <br>
    * @param wordid
    * @param notifyType
    */
   public void notifyAction(int wordid, String word, int actionType);

   /**
    * The results contains the current frame.
    * <br>
    * Object will not be reused by the SearchSession.
    * @return
    */
   public IntToStrings getResults();

   /**
    * 
    * @param ss
    */
   public void subordinateTo(ISearchSession parent);

   /**
    * 
    * @param str
    * @return {@link IntToStrings}. each word with its node ID
    */
   public IntToStrings searchWait(String str);

   /**
   * Notified when a search is done in a thread
   * @param cb
   */
   public void addCallBack(ISearchCallBack cb);

   /**
    * When true, the results are appened in the {@link IntToStrings}.
    * <br>
    * When False, the results are cleared everytime {@link ISearchSession#search()}
    * is called.
    * <br>
    * When in a thread, a call to search while search is aready working will do nothing
    * @param b
    */
   public void setAppend(boolean b);

   /**
    * Change the current tech parameter
    * ITechSearch
    * @param b
    */
   public void setThreaded(boolean b);

   /**
    * Has the search session looked over every stone available.
    * <br>
    * When false, we know 
    */
   public boolean isFinished();

   /**
    * Starts or Continue searching.
    * <br>
    * When in a thread, a call to search while search is aready working will do nothing
    */
   public void search();

   /**
    * Thread blocks until results are available.
    * @return
    */
   public IntToStrings searchWait();

   /**
    * Resets the search with a new prefix.
    * <br>
    * Old results are cleared.
    * <br>
    * 
    * @param str
    */
   public void reset(String str);

   /**
    * The root {@link IPowerCharCollector} for this {@link ISearchSession}.
    * <br>
    * <br>
    * 
    * Also aggregates of sessions to poll if an object is being searched
    * @param o
    * @return
    */
   public IPowerCharCollector getSearched();

   /**
    * True when Object is searched by this {@link ISearchSession} or the sessions being controlled by this session.
    * <br>
    * @param o
    * @return
    */
   public boolean isSearched(Object o);

   /**
    * 
    * @param c
    * @param offset
    * @param len
    */
   public void reset(char[] c, int offset, int len);

   /**
    * Search prefix and return results.
    * @param c
    * @param offset
    * @param len
    * @return
    */
   public IntToStrings searchWait(char[] c, int offset, int len);

   /**
    * Sets the number of words to be found before a result is ready to be returned.
    * <br>
    * In a threaded mode, the SearchSession may continue its work until another frame is ready.
    * <br>
    * 
    * @param frameSize a frame of 0 or less means infinite frame (until no more results)
    * 
    * <br>
    * The frame size may change dynamically.
    */
   public void setFrameSize(int frameSize);

   public int getFrameSize();

   /**
    * Dynamic won't change the tech settings. It will be used only for the next search.
    * After which, the frame size goes back to tech frame size;
    * @param frameSize
    */
   public void setFrameSizeDyn(int frameSize);

   public int getID();

   public void setID(int id);

   /**
    * 
    * @return
    */
   public int getFrameSizeDyn();

   public void setSoftAccent(boolean b);

   public void setSoftCap(boolean b);

   public void setReverseOrder(boolean b);

}
