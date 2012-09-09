/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.block;

import net.minecraft.src.BlockOre;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

import java.util.*;

import arcaneFantasy.common.item.ItemAFGem;
import arcaneFantasy.common.item.ItemManager;
import static arcaneFantasy.common.item.ItemAFGem.*;
import arcaneFantasy.common.lib.Reference;

/**
 * Generic Block for all mod gem ores.
 *
 * @author HMPerson1
 */
public class BlockAFOreGem extends BlockOre {

    /**
     * Total number of gems. (Here for convenience should we add more)
     */
    public static final int GEM_TYPES = ItemAFGem.GEM_TYPES;
    /**
     * Found through reflection by {@link ItemDamageValuedBlock}.
     */
    public static final String[] DAMAGED_NAMES = GEM_NAMES;

    /**
     *
     * @param id this block's id
     * @param tex the index at which this block's texture(s) are located
     */
    public BlockAFOreGem(int id, int tex) {
        super(id, tex);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.BLOCK_SPRITE_SHEET);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int meta) {
        return blockIndexInTexture + meta;
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return ItemManager.gem.shiftedIndex;
    }

    @Override
    protected int damageDropped(int damage) {
        return damage;
    }
//
//    @Override
//    // TODO: Remove this debugging code
//    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
//        System.out.println(String.format("Ore %s: %d, %d, %d", GEM_NAMES[par1World.getBlockMetadata(par2, par3, par4)], par2, par3, par4));
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
        for (int i = 0; i < GEM_TYPES; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
