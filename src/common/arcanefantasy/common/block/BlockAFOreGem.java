/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.block;

import arcanefantasy.common.core.managers.ItemManager;
import arcanefantasy.common.item.ItemAFGem;
import arcanefantasy.common.lib.Reference;

import net.minecraft.src.BlockOre;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;

import java.util.List;
import java.util.Random;


/**
 * Generic Block for all mod gem ores.
 *
 * @author  HMPerson1
 */
public class BlockAFOreGem extends BlockOre {

    /**
     * Total number of gems. (Here for convenience should we add more)
     */
    public static final int GEM_TYPES = ItemAFGem.GEM_TYPES;

    /**
     * Found through reflection by {@link ItemDamageValuedBlock}.
     */
    public static final String[] DAMAGED_NAMES = ItemAFGem.GEM_NAMES;

    /**
     * Creates a new BlockAFOreGem object.
     *
     * @param  id   this block's id
     * @param  tex  the index at which this block's texture(s) are located
     */
    public BlockAFOreGem(final int id, final int tex) {
        super(id, tex);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION +
                           Reference.BLOCK_SPRITE_SHEET);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(final int side, final int meta) {
        return blockIndexInTexture + meta;
    }

    @Override
    public int idDropped(final int par1, final Random par2Random, final int par3) {

        // don't drop the block, drop the gem
        return ItemManager.gem.shiftedIndex;
    }

    @Override
    protected int damageDropped(final int damage) {
        return damage;
    }

    /**
     * {@inheritDoc}
     *
     * @param  id {@inheritDoc}
     * @param  par2CreativeTabs {@inheritDoc}
     * @param  list {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked" /* NOI18N */)
    // FORGE!!!! Y U FORGET ABOUT GENERICS?!?!
    public void getSubBlocks(final int id, final CreativeTabs par2CreativeTabs, final List list) {

        for (int i = 0; i < GEM_TYPES; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
