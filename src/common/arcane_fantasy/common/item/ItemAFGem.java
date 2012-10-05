/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcane_fantasy.common.item;

import arcane_fantasy.common.lib.Reference;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

import java.util.List;


/**
 * Generic Item for all mod gems.
 *
 * @author  HMPerson1
 */
public class ItemAFGem extends Item {

    /**
     * Total number of gems. (Here for convenience should we add more)
     */
    public static final int GEM_TYPES = 2;

    /**
     * Names of all the gems, indexed by damage value.
     */
    public static final String[] GEM_NAMES = {
        "crystal"  /* NOI18N */,
        "amethyst" /* NOI18N */
    };

    /**
     * Creates a new ItemAFGem object.
     *
     * @param  id  this item's id
     */
    public ItemAFGem(int id) {
        super(id);
        setHasSubtypes(true);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);
    }

    /**
     * {@inheritDoc}
     *
     * @param   par1 {@inheritDoc}
     *
     * @return  {@inheritDoc}
     */
    @Override
    public int getIconFromDamage(int par1) {
        return iconIndex + par1;
    }

    /**
     * {@inheritDoc}
     *
     * @param   is {@inheritDoc}
     *
     * @return  {@inheritDoc}
     */
    @Override
    public String getItemNameIS(ItemStack is) {
        return String.format("%s.%s" /* NOI18N */, getItemName(), GEM_NAMES[is.getItemDamage()]);
    }

    /**
     * {@inheritDoc}
     *
     * @param  id {@inheritDoc}
     * @param  ignored {@inheritDoc}
     * @param  list {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked" /* NOI18N */)
    // FORGE!!!! Y U FORGET ABOUT GENERICS?!?!
    public void getSubItems(int id, CreativeTabs ignored, List list) {

        for (int i = 0; i < GEM_TYPES; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
