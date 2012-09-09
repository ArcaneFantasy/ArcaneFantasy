/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.item;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

import java.util.*;

import arcaneFantasy.common.lib.Reference;

/**
 * Generic Item for all mod metals.
 *
 * @author HMPerson1
 */
public class ItemModMetal extends Item {

    /**
     * Total number of metals. (Here for convenience should we add more)
     */
    public static final int METAL_TYPES = 11;
    /**
     * Names of all the metals, indexed by damage value.
     */
    public static final String[] METAL_NAMES = {
        "copper", "pyrite", "magneze", "silver", "magilith", "dragon",
        "platinum", "paladinium", "firium", "glacium", "foudrium"};

    /**
     *
     * @param id this item's id
     */
    public ItemModMetal(int id) {
        super(id);
        setHasSubtypes(true);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);
    }

    /**
     * {@inheritDoc}
     *
     * @param par1 {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public int getIconFromDamage(int par1) {
        return iconIndex + par1;
    }

    /**
     * {@inheritDoc}
     *
     * @param is {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public String getItemNameIS(ItemStack is) {
        return String.format("%s.%s", getItemName(), METAL_NAMES[is.getItemDamage()]);
    }

    /**
     * {@inheritDoc}
     *
     * @param id {@inheritDoc}
     * @param ignored {@inheritDoc}
     * @param list {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked") // FORGE!!!! Y U FORGET ABOUT GENERICS?!?!
    public void getSubItems(int id, CreativeTabs ignored, List list) {
        for (int i = 0; i < METAL_TYPES; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
