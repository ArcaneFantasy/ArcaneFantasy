/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.item;

import arcanefantasy.common.lib.Reference;

import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSpade;


/**
 * DOCUMENT ME!
 *
 * @author  HMPerson1
 */
public class ItemAFSpade extends ItemSpade implements IAFTool {
    protected final EnumAFToolMaterial toolMaterial;

    public ItemAFSpade(final int par1, final EnumAFToolMaterial toolMaterial) {
        super(par1, EnumToolMaterial.IRON);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);
        this.toolMaterial          = toolMaterial;
        efficiencyOnProperMaterial = toolMaterial.efficiencyOnProperMaterial;
    }

    @Override
    public EnumAFToolMaterial getMaterial() {
        return toolMaterial;
    }

}
