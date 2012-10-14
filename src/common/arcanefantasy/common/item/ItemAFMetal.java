/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.item;

import arcanefantasy.common.lib.Reference;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

import java.util.List;


/**
 * Generic Item for all mod metals.
 *
 * @author  HMPerson1
 */
public class ItemAFMetal extends Item {

    /**
     * Total number of metals. (Here for convenience should we add more)
     */
    public static final int METAL_TYPES = 11;

    /**
     * Names of all the metals, indexed by damage value.
     */
    public static final String[] METAL_NAMES = {
        "copper"     /* NOI18N */,
        "pyrite"     /* NOI18N */,
        "magneze"    /* NOI18N */,
        "silver"     /* NOI18N */,
        "magilith"   /* NOI18N */,
        "dragon"     /* NOI18N */,
        "platinum"   /* NOI18N */,
        "paladinium" /* NOI18N */,
        "firium"     /* NOI18N */,
        "glacium"    /* NOI18N */,
        "foudrium"   /* NOI18N */
    };

    /**
     * Creates a new ItemAFMetal object.
     *
     * @param  id  this item's id
     */
    public ItemAFMetal(int id) {
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
        return String.format("%s.%s" /* NOI18N */, getItemName(), METAL_NAMES[is.getItemDamage()]);
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

        for (int i = 0; i < METAL_TYPES; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
