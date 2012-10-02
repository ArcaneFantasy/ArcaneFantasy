/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcane_fantasy.common.block;

import net.minecraft.src.BlockStone;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

import java.util.*;

import arcane_fantasy.common.item.ItemManager;
import arcane_fantasy.common.lib.Reference;

/**
 * Generic Block for all mod stone types.
 *
 * @author HMPerson1
 */
public class BlockAFStone extends BlockStone {

    /**
     * Total number of stone types. (Here for convenience should we add more)
     */
    public static final int STONE_TYPES = 5;
    /**
     * Found through reflection by {@link ItemDamageValuedBlock}.
     */
    public static final String[] DAMAGED_NAMES = {
        "slate", "salt", "marble", "magnetite", "chalk"};

    /**
     *
     * @param id this block's id
     * @param tex the index at which this block's texture(s) are located
     */
    public BlockAFStone(int id, int tex) {
        super(id, tex);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.BLOCK_SPRITE_SHEET);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int meta) {
        return blockIndexInTexture + meta;
    }

    @Override
    public int idDropped(int meta, Random random, int par3) {
        switch (meta) {
            case 0:
                // slate drops slate flakes
                return ItemManager.slateFlake.shiftedIndex;
            case 1:
                // salt drops salt grains
                return ItemManager.salt.shiftedIndex;
            case 4:
                // chalk drops chalk pieces
                return ItemManager.chalk.shiftedIndex;
            default:
                // everything else drops the block
                return blockID;
        }
    }

    @Override
    protected int damageDropped(int damage) {
        switch (damage) {
            case 0:
            case 1:
                // slate & salt drop items with individual ids 
                return 0;
            case 4:
                // white chalk has damage value of 15
                return 15;
            default:
                // otherwise, return the damage value of the block
                // becuase the block is what will be dropped 
                return damage;
        }
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        int quantityDropped = random.nextInt(5) + 11;
        // TODO: May need some tweaking...
        switch (meta) {
            case 0:
            case 1:
            case 4:
                // same method used by BlockOre
                return quantityDropped * (MathHelper.clamp_int(random.nextInt(fortune + 2) - 1, 0, Integer.MAX_VALUE) + 1);
            default:
                return 1;
        }
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
        // Must be overridden, otherwise the damaged returned will be the damage
        // of the item dropped, not the damage of the block itself
        return new ItemStack(idPicked(world, x, y, z), 1, world.getBlockMetadata(x, y, z));
    }
    
//
//    @Override
//    // TODO: Remove this debugging code
//    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
//        System.out.println(String.format("Ore %s: %d, %d, %d", METAL_NAMES[par1World.getBlockMetadata(par2, par3, par4)], par2, par3, par4));
//        super.onBlockAdded(par1World, par2, par3, par4);
//    }
    /**
     * {@inheritDoc}
     *
     * @param id {@inheritDoc}
     * @param par2CreativeTabs {@inheritDoc}
     * @param list {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked") // FORGE!!!! Y U FORGET ABOUT GENERICS?!?!
    public void getSubBlocks(int id, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 0; i < STONE_TYPES; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
