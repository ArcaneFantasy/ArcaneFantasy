/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.block;

import arcanefantasy.common.item.ItemAFMetal;
import arcanefantasy.common.lib.Reference;

import net.minecraft.src.BlockOre;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;

import java.util.List;


/**
 * Generic Block for all mod metal ores.
 *
 * @author  HMPerson1
 */
public class BlockAFOreMetal extends BlockOre {

    /**
     * Total number of metals. (Here for convenience should we add more)
     */
    public static final int METAL_TYPES = ItemAFMetal.METAL_TYPES;

    /**
     * Found through reflection by {@link ItemDamageValuedBlock}.
     */
    public static final String[] DAMAGED_NAMES = ItemAFMetal.METAL_NAMES;

    /**
     * Creates a new BlockAFOreMetal object.
     *
     * @param  id   this block's id
     * @param  tex  the index at which this block's texture(s) are located
     */
    public BlockAFOreMetal(int id, int tex) {
        super(id, tex);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION +
                Reference.BLOCK_SPRITE_SHEET);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int meta) {
        return blockIndexInTexture + meta;
    }

    @Override
    public int damageDropped(int damage) {
        return damage;
    }
    // don't override idDropped, because we want to drop the ore block, not
    // the ingot

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
    public void getSubBlocks(int id, CreativeTabs par2CreativeTabs, List list) {

        for (int i = 0; i < METAL_TYPES; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
