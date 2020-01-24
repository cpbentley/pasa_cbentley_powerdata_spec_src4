package pasa.cbentley.powerdata.spec.src4.power.integers;

import pasa.cbentley.powerdata.spec.src4.power.IDataMorphable;
import pasa.cbentley.powerdata.spec.src4.power.IPowerDataTypes;

/**
 * 
 * @author Charles Bentley
 *
 */
public interface IPowerLinkIntToBytes extends IDataMorphable {

   public static final int INT_ID = IPowerDataTypes.INT_35_LINK_INT_TO_BYTES;

   public byte[] getBytes(int rid);

   public void getBytes(int rid, byte[] b, int offset, int len);

   public int addBytes(byte[] b);

   public int addBytes(byte[] b, int offset, int len);

   public void setBytes(int id, byte[] b);

   public void setBytes(int id, byte[] b, int offset, int len);

   public void deleteBytes(int rid);

   public int getSize();
   
}
