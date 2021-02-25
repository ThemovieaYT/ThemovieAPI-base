package net.themoviea.themovieapi_base.registering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.themoviea.themovieapi_base.exceptions.InputNotAnObjectException;

/**
 * Mainly an interface used for other APIs
 * to support EasyRegister so users can easily
 * register their own custom registers.
 * @author Themoviea
 *
 * @param <ObjectClass>
 */
public interface CustomEasyRegister<ObjectClass> {
	
	/**
	 * Gets the object.
	 * @return ObjectClass
	 */
	ObjectClass getObject();
	
	/**
	 * Gets the ArrayList.
	 * @return ArrayList<Object>
	 */
	ArrayList<Object> getArrayList();
	
	default boolean createCustomRegisterList(Object... a) {
		List<Object> list = Arrays.asList(a);
		return getArrayList().addAll(list);
	}
	
	/**
	 * Simple method for registering custom entries.
	 * @param modid
	 * @param registry
	 */
	@SuppressWarnings("unchecked")
	default void registerCustom(String modid, Registry<ObjectClass> registry) throws InputNotAnObjectException {
		if(getArrayList().size() == 0) {
			System.out.println("(" + modid + ") No custom entries has been registered, as of there is nothing to register.");
		} else {
			for(int x = 0; x < getArrayList().size(); x = x + 2) {
				if(getArrayList().get(x).equals(getObject())) {
					if(getArrayList().get(x+1) instanceof String) {
						Registry.register(registry, new Identifier(modid, (String)getArrayList().get(x+1)), (ObjectClass)getArrayList().get(x));
					} else
						throw new InputNotAnObjectException("The " + getArrayList().get(x+1) + "on index: " + x+1 + " is not a String!");
				} else
					throw new InputNotAnObjectException("The " + getArrayList().get(x) + "on index: " + x + " is not a custom entry from " + modid + "!");
			}
		}
	}
}
