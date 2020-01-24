package pasa.cbentley.powerdata.spec.src4.power;

import java.util.NoSuchElementException;

public interface IPowerEnum {

   /**
    * 
    * @return
    * @throws NoSuchElementException if no element
    */
   public Object getNext();
   
   public boolean hasNext();
}
