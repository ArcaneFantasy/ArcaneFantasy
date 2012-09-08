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

import arcaneFantasy.common.item.ItemManager;
import static arcaneFantasy.common.item.ItemModGem.*;
import arcaneFantasy.common.lib.Reference;

/**
 * Generic Block for all mod gem ores.
 *
 * @author HMPerson1
 */
public class BlockModOreGem extends BlockOre {

    /**
     * Found through reflection by {@link ItemDamageValuedBlock}.
     */
    public static final String[] DAMAGED_NAMES = GEM_NAMES;

    /**
     *
     * @param id this block's id
     * @param tex the index at which this block's texture(s) are located
     */
    public BlockModOreGem(int id, int tex) {
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