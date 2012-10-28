/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.item;

import arcanefantasy.common.lib.Reference;

import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemAxe;


/**
 * DOCUMENT ME!
 *
 * @author  HMPerson1
 */
public class ItemAFAxe extends ItemAxe implements IAFTool {
    protected final EnumAFToolMaterial toolMaterial;

    public ItemAFAxe(final int id, final EnumAFToolMaterial toolMaterial) {
        super(id, EnumToolMaterial.IRON);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);
        this.toolMaterial          = toolMaterial;
        efficiencyOnProperMaterial = toolMaterial.efficiencyOnProperMaterial;
    }

    @Override
    public EnumAFToolMaterial getMaterial() {
        return toolMaterial;
    }

}
