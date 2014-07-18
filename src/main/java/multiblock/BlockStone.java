package multiblock;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStone extends BlockMultiBlock {
    public BlockStone() {
        super(Material.rock);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileStoneMultiblock();
    }
}
