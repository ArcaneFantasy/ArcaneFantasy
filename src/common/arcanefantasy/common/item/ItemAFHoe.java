/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.item;

import arcanefantasy.common.lib.Reference;

import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemHoe;


/**
 * DOCUMENT ME!
 *
 * @author  HMPerson1
 */
public class ItemAFHoe extends ItemHoe implements IAFTool {
    protected final EnumAFToolMaterial toolMaterial;

    public ItemAFHoe(final int par1, final EnumAFToolMaterial toolMaterial) {
        super(par1, EnumToolMaterial.IRON);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);
        this.toolMaterial = toolMaterial;
    }

    @Override
    public String func_77842_f() {
        return toolMaterial.toString();
    }

    @Override
    public EnumAFToolMaterial getMaterial() {
        return toolMaterial;
    }

}
