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
 * Generic Item for all chalk colors.
 *
 * @author  HMPerson1
 */
public class ItemAFChalk extends Item {

    /**
     * Total number of chalk colors. (Here for convenience should we add more)
     */
    public static final int CHALK_TYPES = 16;

    /**
     * Names of all the chalk colors, indexed by damage value. These are the
     * same as dyes
     */
    public static final String[] CHALK_NAMES = {
        "black"     /* NOI18N */,
        "red"       /* NOI18N */,
        "green"     /* NOI18N */,
        "brown"     /* NOI18N */,
        "blue"      /* NOI18N */,
        "purple"    /* NOI18N */,
        "cyan"      /* NOI18N */,
        "silver"    /* NOI18N */,
        "gray"      /* NOI18N */,
        "pink"      /* NOI18N */,
        "lime"      /* NOI18N */,
        "yellow"    /* NOI18N */,
        "lightBlue" /* NOI18N */,
        "magenta"   /* NOI18N */,
        "orange"    /* NOI18N */,
        "white"     /* NOI18N */
    };

    /**
     * Creates a new ItemAFChalk object.
     *
     * @param  id  this item's id
     */
    public ItemAFChalk(int id) {
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
        return String.format("%s.%s" /* NOI18N */, getItemName(), CHALK_NAMES[is.getItemDamage()]);
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

        for (int i = 0; i < CHALK_TYPES; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
