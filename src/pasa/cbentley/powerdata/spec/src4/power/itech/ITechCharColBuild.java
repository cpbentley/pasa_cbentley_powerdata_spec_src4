package pasa.cbentley.powerdata.spec.src4.power.itech;

/**
 * Specification for the char collecting build.
 * <br>
 * <br>
 * 
 * @author Charles Bentley
 *
 */
public interface ITechCharColBuild extends ITechCharCol {

   /**
    * 
    */
   public static final int CHAR_BUILD_BASIC_SIZE               = CHARCOL_BASIC_SIZE + 1;

   /**
    * First accepted pointer.
    * <br>
    * <br>
    * Usually 0 or 1. Default is 0.
    */
   public static final int CHAR_BUILD_OFFSET_02_START_POINTER1 = CHARCOL_BASIC_SIZE;

}
