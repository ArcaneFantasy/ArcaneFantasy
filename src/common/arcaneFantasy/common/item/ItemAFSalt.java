/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.item;

import net.minecraft.src.Item;

import arcaneFantasy.common.lib.Reference;

/**
 * Nothin' special here.
 *
 * @author HMPerson1
 */
public class ItemAFSalt extends Item {

    /**
     *
     * @param id this item's id
     */
    public ItemAFSalt(int id) {
        super(id);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);
    }
}
