package multiblock;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileHollowMultiBlock extends TileMultiBlock {
    public TileHollowMultiBlock() {};

    @Override
    public void doMultiBlockStuff() {
        // Sets diamond block 6 blocks above the master
        if (worldObj.isAirBlock(xCoord, yCoord + 6, zCoord))
            worldObj.setBlock(xCoord, yCoord + 6, zCoord, Blocks.diamond_block);
    }

    @Override
    public void masterWriteToNBT(NBTTagCompound tag) {
    }

    @Override
    public void masterReadFromNBT(NBTTagCompound tag) {
    }

    @Override
    public boolean checkMultiBlockForm() {
        int i = 0;
        // Scan a 3x3x3 area, starting with the bottom left corner
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    // Make sure tile isn't null, is an instance of the same Tile, and isn't already a part of a multiblock (if ours is already part of one)
                    if (tile != null && (tile instanceof TileHollowMultiBlock)) {
                        if (this.isMaster()) {
                            if (((TileHollowMultiBlock)tile).hasMaster())
                                i++;
                        } else if (!((TileHollowMultiBlock)tile).hasMaster())
                            i++;
                    }
                }
        // check if there are 26 blocks present ((3*3*3) - 1) and check that center block is empty
        return i > 25 && worldObj.isAirBlock(xCoord, yCoord + 1, zCoord);
    }

    @Override
    public void setupStructure() {
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    // Check if block is bottom center block
                    boolean master = (x == xCoord && y == yCoord && z == zCoord);
                    if (tile != null && (tile instanceof TileHollowMultiBlock)) {
                        ((TileHollowMultiBlock) tile).setMasterCoords(xCoord, yCoord, zCoord);
                        ((TileHollowMultiBlock) tile).setHasMaster(true);
                        ((TileHollowMultiBlock) tile).setIsMaster(master);
                    }
                }
    }
}
