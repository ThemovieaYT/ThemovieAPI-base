package net.themoviea.themovieapi_base.registering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.util.registry.Registry;

public interface CustomEasyRegister<ObjectClass> {
	ArrayList<Object> getArrayList();
	
	default boolean createCustomRegisterList(Object... a) {
		List<Object> list = Arrays.asList(a);
		return getArrayList().addAll(list);
	}
	
	void registerCustom(String modid, Registry<?> registry);
}
