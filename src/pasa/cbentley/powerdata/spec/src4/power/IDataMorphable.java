package pasa.cbentley.powerdata.spec.src4.power;

import pasa.cbentley.byteobjects.src4.core.ByteController;
import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.core.ByteObjectManaged;
import pasa.cbentley.byteobjects.src4.tech.ITechByteObject;
import pasa.cbentley.byteobjects.src4.tech.ITechObjectManaged;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.powerdata.spec.src4.power.itech.ITechMorph;

/**
 * Implemented by any datastructure with
 * <li> {@link ByteController} framework
 * <li> that is a {@link ByteObjectManaged}.
 * <li> Run/Build genetic types.
 * <li> Has the datatype {@link ITechMorph}.
 * <br>
 * <br>
 * Thus the data structure is a {@link ByteObjectManaged} and has a byte header following the {@link ITechObjectManaged} specification.
 * <br>
 * <br>
 * The {@link IDataMorphable} framework allows code to manipulate datastructures at the logical level.
 * <br>
 * <br>
 
 * <br>
 * <br>
 * 
 * @author Charles Bentley
 *
 */
public interface IDataMorphable extends IStringable {

   /**
    * The {@link ByteObject} defining meta-data about the structure.
    * <br>
    * <br>
    * May it returns itself? as {@link ITechObjectManaged} + other extensions ? Yes.
    * <br>
    * But then you cannot move around genes as a unit. Yes you can, with {@link ITechObjectManaged} and no data, just the header.
    * <br>
    * <br>
    * When implementing morphing, we want to define gene units. The datastructure user will define a gene structure
    * that he wants and the morhping will take that as a work base.
    * <br>
    * <br>
    * The morphed structure will match as closely as possible the input genetics.
    * <br>
    * Have a flag set when payload is included in this {@link ITechObjectManaged} length header.
    * <br>
    * <br>
    * 
    * @return
    */
   public ByteObjectManaged getTech();

   /**
    * Frees up any resources and unregisters from all event channels.
    * 
    */
   public void closeAgent();

   public void saveAgent();

   /**
    * Creating a new instance by Morphing the {@link ByteObjectManaged} structure in the given tech parameters given in params[0].
    * <br>
    * <br>
    * Returns itself when structure cannot make sense of destination parameters.
    * <br>
    * <br>
    * 
    * Most of the time, a fast reads/writes and big memory footprint structure morphs into a fast read/slow writes and small memory footprint optimized.
    * <br>
    * <br>
    * <br>
    * <br>
    * How does a composite structure know what parameters to use for its sub {@link IDataMorphable}?
    * <br>
    * <br>
    * When Structure is matching {@link IDataMorphable#MORPH_FLAG_1_RUN} and Type, it checks {@link MemController} and attaches itself to it.
    * <br>
    * <br>
    * <br>
    * The spec of the morphing parameters is defined at the level of the datastructure type.
    * <br>
    * <br>
    * By convention, the first index is the {@link ByteObject} tech of the destination structure.
    * <br>
    * <br>
    * When the same genetics are provided, the datastructure is cloned.
    * <br>
    * <br>
    * The {@link ByteController} serves the purpose of centralizing the morphing of a composite element.
    * ...do we really need this?
    * <br>
    * <br>
    * @param p TODO
    * 
    * @return {@link IDataMorphable} of the same interface with a Run archetype optimized for small memory footprint.
    */
   public Object getMorph(MorphParams p);

   /**
    * Serialize out of context as if structure is alone in the world.
    * <br>
    * <br>
    * This method exist to hide the {@link ByteController} class. 
    * <br>
    * Normally, you create a {@link ByteController}, {@link IDataMorphable#serializeTo(ByteController)}.
    * <br>
    * Neverthless the byte[] array starts with the headers of a {@link ByteController}.
    * <br>
    * The {@link ITechObjectManaged#AGENT_OFFSET_16_LEN4} tells the length of the whole byte array.
    * <br>
    * <br>
    * While {@link ITechByteObject#A_OBJECT_OFFSET_3_LENGTH2} is 0xFFFF?
    * <br>
    * <br>
    *  and {@link ITechObjectManaged#AGENT_FLAG_CTRL_5_ROOT} is set by this method.
    * <br>
    * While the {@link ITechObjectManaged#AGENT_FLAG_CTRL_5_ROOT} is un-set by the caller depending on the context.
    * Not to forget that the 1st byte returned by the array is always the {@link ITechByteObject#MAGIC_BYTE_DEF}.
    * <br>
    * <br>
    * Thus if one wants to modifies ByteObject flags, a index must be offset by +1.
    * <br>
    * <br>
    * @return
    */
   public byte[] serializePack();

   /**
    * Serialize Data just at the level of the Class. Does not serialize composites.
    * <br>
    * Starts with the {@link ByteObjectManaged} header.
    * @return
    */
   //public byte[] serializeRaw();

   /**
    * Serialization in the context given by the {@link ByteController}.
    * <br>
    * <br>
    * 
    * When serializing composite {@link IDataMorphable}, create a {@link ByteController}. It will prevent
    * the duplicate serialization of a given {@link IDataMorphable} used by several structures.
    * <br>
    * Example: the same {@link IPowerCharCollector} used by several different Tries in TrieTable.
    * <br>
    * <br>
    * Provides smooth buffer operations as well.
    * <br>
    * <br>
    * Check if this instance is alreayd controlled by the {@link ByteController}.
    * <br>
    * <br>
    * Calling this method does not modify the state of the Object.
    * <br>
    * <br>
    * 
    * @param bc if null nothing happens.
    */
   public ByteObjectManaged serializeTo(ByteController bc);

   /**
    * Construct object from a source which was created with the {@link IDataMorphable#serializePack()} methods.
    * <br>
    * Why is this method in the API? Because it allows a datastructure reference to be mutable.
    * <br>
    * When {@link ByteController} is null, there is no context and all the data is provided by the wrapper of a byte[]. 
    * <br>
    * <br>
    * The method will look at params object. The order is set by the class. This order must be respected by
    * the caller. For instance, a shared object will be provided in that array.
    * <br>
    * <br>
    * When the {@link ByteController} is not null, and data is null, ask the {@link ByteController} to find
    * an area that match the current header of the object. That header provides the different ids for the {@link ByteController}
    * to identifies the right byte area for this {@link ByteObjectManaged}.
    * <br>
    * <br>
    * The {@link ByteController} will control the {@link ByteObjectManaged}.
    * @param bc  {@link ByteController} Maybe null
    */
   public void serializeReverse();

   /**
    * Debug method to be removed in production code.
    * <br>
    * <br>
    * 
    * @param nl
    * @return
    */
}
