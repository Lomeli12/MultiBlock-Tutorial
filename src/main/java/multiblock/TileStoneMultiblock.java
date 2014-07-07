package multiblock;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;

public class TileStoneMultiblock extends TileMultiBlock {
    @Override
    public void doMultiBlockStuff() {

    }

    @Override
    public boolean checkMultiBlockForm() {
        // Checks to see if surrounded by stone
        int i = 0;
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord -1; y < yCoord + 2; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    if (worldObj.getBlock(x, y, z) == Blocks.stone)
                        i++;
                }
        return i == 26;
    }

    @Override
    public void setupStructure() {
        // replaces stone with diamond blocks
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord -1; y < yCoord + 2; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    if (worldObj.getBlock(x, y, z) == Blocks.stone)
                        worldObj.setBlock(x, y, z, Blocks.diamond_block);
                }
    }

    @Override
    public void masterWriteToNBT(NBTTagCompound tag) {

    }

    @Override
    public void masterReadFromNBT(NBTTagCompound tag) {

    }
}
