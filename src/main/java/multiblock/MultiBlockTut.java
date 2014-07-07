package multiblock;

import net.minecraft.block.Block;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "LomeliMultiBlockTutorial", name = "Example MultiBlock Mod", version = "1.0")
public class MultiBlockTut {
    public static Block hollow, stoneMulti;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        hollow = new BlockHollow().setBlockName("hollowMultiBlock");
        stoneMulti = new BlockStone().setBlockName("stoneMultiBlock");

        GameRegistry.registerBlock(hollow, ItemSpecialBlock.class, "HollowMultiBlock");
        GameRegistry.registerBlock(stoneMulti, ItemSpecialBlock.class, "StoneMultiBlock");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // ALWAYS register your Tile Entities and give them unique names!
        GameRegistry.registerTileEntity(TileHollowMultiBlock.class, "tutorial.multiblock.hallow");
        GameRegistry.registerTileEntity(TileStoneMultiblock.class, "tutorial.multiblock.stone");
    }
}
