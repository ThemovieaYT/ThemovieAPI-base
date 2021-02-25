package net.themoviea.themovieapi_base.registering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.util.registry.Registry;
import net.themoviea.themovieapi_base.exceptions.InputNotAnObjectException;

/**
 * Mainly an interface used for other APIs
 * to support EasyRegister so users can easily
 * register their own custom registries.
 * @author 1
 *
 * @param <ObjectClass>
 */
public interface CustomEasyRegister<ObjectClass> {
	
	/**
	 * Gets the ArrayList from the class that implements this interface,
	 * so no need to write createCustomRegisterList multiple times because
	 * it is a default method.
	 * @return
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
	void registerCustom(String modid, Registry<?> registry) throws InputNotAnObjectException;
}
