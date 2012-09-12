/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.block;

import net.minecraft.src.BlockOre;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;

import java.util.*;

import arcaneFantasy.common.item.ItemAFMetal;
import static arcaneFantasy.common.item.ItemAFMetal.*;
import arcaneFantasy.common.lib.Reference;

/**
 * Generic Block for all mod metal ores.
 *
 * @author HMPerson1
 */
public class BlockAFOreMetal extends BlockOre {

    /**
     * Total number of metals. (Here for convenience should we add more)
     */
    public static final int METAL_TYPES = ItemAFMetal.METAL_TYPES;
    /**
     * Found through reflection by {@link ItemDamageValuedBlock}.
     */
    public static final String[] DAMAGED_NAMES = METAL_NAMES;

    /**
     *
     * @param id this block's id
     * @param tex the index at which this block's texture(s) are located
     */
    public BlockAFOreMetal(int id, int tex) {
        super(id, tex);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.BLOCK_SPRITE_SHEET);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int meta) {
        return blockIndexInTexture + meta;
    }

    @Override
    protected int damageDropped(int damage) {
        return damage;
    }
    // don't override idDropped, because we want to drop the ore block, not 
    // the ingot

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
        for (int i = 0; i < METAL_TYPES; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
