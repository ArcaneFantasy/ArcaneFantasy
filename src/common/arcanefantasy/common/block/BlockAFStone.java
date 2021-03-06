/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.block;

import arcanefantasy.common.core.managers.ItemManager;
import arcanefantasy.common.lib.Reference;

import net.minecraft.src.BlockStone;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

import java.util.List;
import java.util.Random;


/**
 * Generic Block for all mod stone types.
 *
 * @author  HMPerson1
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
        "slate"                                                 /* NOI18N */,
        "salt"                                                  /* NOI18N */,
        "marble"                                                /* NOI18N */,
        "magnetite"                                             /* NOI18N */,
        "chalk"                                                 /* NOI18N */
    };

    /**
     * Creates a new BlockAFStone object.
     *
     * @param  id   this block's id
     * @param  tex  the index at which this block's texture(s) are located
     */
    public BlockAFStone(final int id, final int tex) {
        super(id, tex);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION +
                           Reference.BLOCK_SPRITE_SHEET);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(final int side, final int meta) {
        return blockIndexInTexture + meta;
    }

    @Override
    public int idDropped(final int meta, final Random random, final int par3) {

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
    public int damageDropped(final int damage) {

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
    public int quantityDropped(final int meta, final int fortune, final Random random) {
        final int quantityDropped = random.nextInt(5) + 11;

        // TODO: May need some tweaking...
        switch (meta) {

            case 0:
            case 1:
            case 4:

                // same method used by BlockOre
                return quantityDropped *
                        (MathHelper.clamp_int(random.nextInt(fortune + 2) - 1,
                                              0,
                                              Integer.MAX_VALUE) + 1);

            default:
                return 1;
        }
    }

    @Override
    public ItemStack getPickBlock(final MovingObjectPosition target,
                                  final World                world,
                                  final int                  x,
                                  final int                  y,
                                  final int                  z) {

        // Must be overridden, otherwise the damaged returned will be the damage
        // of the item dropped, not the damage of the block itself
        return new ItemStack(idPicked(world, x, y, z), 1,
                             world.getBlockMetadata(x, y, z));
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

        for (int i = 0; i < STONE_TYPES; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
