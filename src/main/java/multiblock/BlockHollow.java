package multiblock;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockHollow extends BlockMultiBlock {
    public BlockHollow() {
        super(Material.rock);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileHollowMultiBlock();
    }


}
