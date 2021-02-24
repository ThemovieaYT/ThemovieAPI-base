package net.themoviea.themovieapi_base.registering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.themoviea.themovieapi_base.exceptions.InputNotAnObjectException;

/**
 * Class for registering Minecraft objects,
 * but more simple than doing it the regular way.
 * @author Themoviea
 */
public class EasyRegister {
	private static ArrayList<Object> mcCustom = new ArrayList<>();
	private static ArrayList<Object> mcBlock = new ArrayList<>();
	private static ArrayList<Object> mcItem = new ArrayList<>();
	private static ArrayList<Object> mcEffect = new ArrayList<>();
	private static ArrayList<Object> mcStructurePiece = new ArrayList<>();

	public static boolean createCustomRegisterList(Object... a) {
		List<Object> list = Arrays.asList(a);
		return mcCustom.addAll(list);
	}
	/**
	 * Creates a block list provided by your inputs.
	 * @param a
	 * @return
	 */
	public static boolean createBlockList(Object... a) {
		List<Object> list = Arrays.asList(a);
		return mcBlock.addAll(list);
	}
	
	/**
	 * Creates a item list provided by your inputs.
	 * @param a
	 * @return
	 */
	public static boolean createItemList(Object... a) {
		List<Object> list = Arrays.asList(a);
		return mcItem.addAll(list);
	}
	
	/**
	 * Creates an effect list provided by your inputs.
	 * @param a
	 * @return
	 */
	public static boolean createEffectList(Object... a) {
		List<Object> list = Arrays.asList(a);
		return mcEffect.addAll(list);
	}
	
	/**
	 * Creates a structure piece list provided by your inputs.
	 * @param a
	 * @return
	 */
	public static boolean createStructurePieceList(Object... a) {
		List<Object> list = Arrays.asList(a);
		return mcStructurePiece.addAll(list);
	}
	
	/**
	 * Simple method for registering blocks.
	 * The way to use this is by simply creating a 
	 * {@code EasyRegister.createBlockList(list[] args here)};
	 * Reminder: the String should be the name of the block that is at the left side of it.
	 * and then do {@code EasyRegister.registerBlocks(modid)}.
	 * @param modid
	 * @throws InputNotAnObjectException
	 */
	public static void registerBlocks(String modid) throws InputNotAnObjectException {
		if(mcBlock.size() == 0) {
			System.out.println("No blocks has been registered, as of there is nothing to register.");
		} else {
			for(int x = 0; x < mcBlock.size(); x = x + 2) {
				if(mcBlock.get(x) instanceof Block) {
					if(mcBlock.get(x+1) instanceof String) {
						Registry.register(Registry.BLOCK, new Identifier(modid, (String)mcBlock.get(x+1)), (Block)mcBlock.get(x));
					} else
						throw new InputNotAnObjectException("The " + mcBlock.get(x+1) + "on index: " + x+1 + " is not a String!");
				} else
					throw new InputNotAnObjectException("The " + mcBlock.get(x) + " on index: " + x + " is not a Block!");
			}
		}
	}
	
	/**
	 * Simple method for registering items.
	 * The way to use this is by simply creating a
	 * {@code EasyRegister.createItemList(list[] args here);}
	 * and then do {@code EasyRegister.registerItems(modid)}.
	 * @param modid
	 * @throws InputNotAnObjectException
	 */
	public static void registerItems(String modid) throws InputNotAnObjectException {
		if(mcItem.size() == 0) {
			System.out.println("No items has been registered, as of there is nothing to register.");
		} else {
			for(int x = 0; x < mcItem.size(); x = x + 2) {
				if(mcItem.get(x) instanceof Item) {
					if(mcItem.get(x+1) instanceof String) {
						Registry.register(Registry.ITEM, new Identifier(modid, (String)mcItem.get(x+1)), (Item)mcItem.get(x));
					} else
						throw new InputNotAnObjectException("The " + mcItem.get(x+1) + "on index: " + x+1 + " is not a String!");
				} else
					throw new InputNotAnObjectException("The " + mcItem.get(x) + "on index: " + x + " is not a Item!");
			}
		}
	}
	
	/**
	 *  Simple method for registering effects.
	 * The way to use this is by simply creating a 
	 * {@code EasyRegister.createEffectList(list[] args here);}
	 * and then do {@code EasyRegister.registerEffects(modid)}.
	 * @param modid
	 * @throws InputNotAnObjectException
	 */
	public static void registerEffects(String modid) throws InputNotAnObjectException {
		if(mcEffect.size() == 0) {
			System.out.println("No effects has been registered, as of there is nothing to register.");
		} else {
			for(int x = 0; x < mcEffect.size(); x = x + 2) {
				if(mcEffect.get(x) instanceof StatusEffect) {
					if(mcEffect.get(x+1) instanceof String) {
						Registry.register(Registry.STATUS_EFFECT, new Identifier(modid, (String)mcEffect.get(x+1)), (StatusEffect)mcEffect.get(x));
					} else
						throw new InputNotAnObjectException("The " + mcEffect.get(x+1) + "on index: " + x+1 + " is not a String!");
				} else
					throw new InputNotAnObjectException("The " + mcEffect.get(x) + "on index: " + x + " is not a Status Effect!");
			}
		}
	}
	
	/**
	 * Simple method for registering structure pieces.
	 * The way to use this is by simply creating a 
	 * {@code EasyRegister.createStructurePieceList(list[] args here);}
	 * and then do {@code EasyRegister.registerStructurePieces(modid)}.
	 * @param modid
	 * @throws InputNotAnObjectException
	 */
	public static void registerStructurePieces(String modid) throws InputNotAnObjectException {
		if(mcStructurePiece.size() == 0) {
			System.out.println("No effects has been registered, as of there is nothing to register.");
		} else {
			for(int x = 0; x < mcStructurePiece.size(); x = x + 2) {
				if(mcStructurePiece.get(x) instanceof StatusEffect) {
					if(mcStructurePiece.get(x+1) instanceof String) {
						Registry.register(Registry.STRUCTURE_PIECE, new Identifier(modid, (String)mcStructurePiece.get(x+1)), (StructurePieceType)mcStructurePiece.get(x));
					} else
						throw new InputNotAnObjectException("The " + mcStructurePiece.get(x+1) + "on index: " + x+1 + " is not a String!");
				} else
					throw new InputNotAnObjectException("The " + mcStructurePiece.get(x) + "on index: " + x + " is not a Structure Piece Type!");
			}
		}
	}
}
