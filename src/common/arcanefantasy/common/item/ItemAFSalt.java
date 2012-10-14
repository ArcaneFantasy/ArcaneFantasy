/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.item;

import arcanefantasy.common.lib.Reference;

import net.minecraft.src.Item;


/**
 * Nothin' special here.
 *
 * @author  HMPerson1
 */
public class ItemAFSalt extends Item {

    /**
     * Creates a new ItemAFSalt object.
     *
     * @param  id  this item's id
     */
    public ItemAFSalt(int id) {
        super(id);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);
    }
}
