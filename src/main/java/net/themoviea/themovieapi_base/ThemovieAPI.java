package net.themoviea.themovieapi_base;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.themoviea.themovieapi_base.exceptions.InputNotAnObjectException;
import net.themoviea.themovieapi_base.registering.EasyRegister;

public class ThemovieAPI implements ModInitializer
{
    public static final Block ENCHANTED_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN_TERRACOTTA).hardness(2.0f).resistance(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block DARK_STONE = new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.BLACK).hardness(3.5f).resistance(6.0f).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));

	@Override
	public void onInitialize() {
		EasyRegister.createBlockList(DARK_STONE, "dark_stone", ENCHANTED_PLANKS, "enchanted_planks");
		try {
			EasyRegister.registerBlocks("testmod");
		} catch (InputNotAnObjectException e) {
			e.printStackTrace();
			System.exit(1);
			System.out.println();
		}
	}
}
