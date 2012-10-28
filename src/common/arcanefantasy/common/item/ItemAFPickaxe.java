/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.item;

import net.minecraft.src.Block;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemPickaxe;

import arcanefantasy.common.lib.Reference;


/**
 * DOCUMENT ME!
 *
 * @author  HMPerson1
 */
public class ItemAFPickaxe extends ItemPickaxe implements IAFTool {
    protected final EnumAFToolMaterial toolMaterial;

    public ItemAFPickaxe(final int id, final EnumAFToolMaterial toolMaterial) {
        super(id, EnumToolMaterial.IRON);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);
        this.toolMaterial          = toolMaterial;
        efficiencyOnProperMaterial = toolMaterial.efficiencyOnProperMaterial;
    }

    @Override
    public boolean canHarvestBlock(final Block block) {

        switch (toolMaterial.harvestLevel) {

            case 0:
                return Item.pickaxeWood.canHarvestBlock(block);

            case 1:
                return Item.pickaxeStone.canHarvestBlock(block);

            case 2:
                return Item.pickaxeSteel.canHarvestBlock(block);

            case 3:
                return Item.pickaxeDiamond.canHarvestBlock(block);

            default:
                return false;
        }
    }

    @Override
    public EnumAFToolMaterial getMaterial() {
        return toolMaterial;
    }

}
