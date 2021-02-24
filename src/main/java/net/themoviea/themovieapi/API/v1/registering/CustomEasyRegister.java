package net.themoviea.themovieapi.API.v1.registering;

import net.minecraft.util.registry.Registry;

public interface CustomEasyRegister {
	boolean createCustomRegisterList(Object... a);
	
	void registerCustom(String modid, Registry<?> registry);
}
