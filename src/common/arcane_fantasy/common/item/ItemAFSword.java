/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcane_fantasy.common.item;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemSword;
import net.minecraft.src.World;

import arcane_fantasy.common.lib.Reference;

/**
 *
 * @author HMPerson1
 */
public class ItemAFSword extends ItemSword {

    /**
     * The material this item is made of.
     */
    public final EnumAFToolMaterial toolMaterial;
    /**
     * How much damage this does to an entity.
     */
    private final int weaponDamage;

    /**
     *
     * @param id this item's id
     * @param material this sword's material
     */
    public ItemAFSword(int id, EnumAFToolMaterial material) {
        super(id, EnumToolMaterial.IRON); // MUST be called
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);

        // Overwrite what super() just did:
        setMaxDamage(material.maxUses);
        this.toolMaterial = material;
        weaponDamage = 4 + material.damageVsEntity;
    }

    @Override
    public boolean hitEntity(ItemStack is, EntityLiving target, EntityLiving player) {
        boolean ret = super.hitEntity(is, target, player);
        switch (toolMaterial) {
            case FIRIUM:
                // sets it on fire for 12 seconds; equivalent to fire aspect 3
                target.setFire(12);
                return true;
            case GLACIUM:
                // puts the entity in a 4x4 chunk of ice
                World world = target.worldObj;
                int tgtX = (int) Math.round(target.posX);
                int tgtY = (int) Math.round(target.posY);
                int tgtZ = (int) Math.round(target.posZ);
                for (int i = tgtX - 2; i < tgtX + 2; i++) {
                    for (int j = tgtY - 2; j < tgtY + 2; j++) {
                        for (int k = tgtZ - 2; k < tgtZ + 2; k++) {
                            int id = world.getBlockId(i, j, k);
                            if ((Block.blocksList[id] == null || Block.blocksList[id].isBlockReplaceable(world, i, j, k))
                                    // hard coded list of all the replacable blocks
                                    || id == Block.waterStill.blockID
                                    || id == Block.waterMoving.blockID
                                    || id == Block.snow.blockID
                                    || id == Block.vine.blockID
                                    || id == Block.tallGrass.blockID
                                    || id == Block.deadBush.blockID) {
                                world.setBlock(i, j, k, Block.ice.blockID);
                            }
                        }
                    }
                }
                return true;
            case FOUDRIUM:
                // strikes the entity with lightning
                target.worldObj.addWeatherEffect(new EntityLightningBolt(
                        target.worldObj, target.posX, target.posY, target.posZ));
                return true;
            default:
                return ret;
        }

    }

    @Override
    public int getDamageVsEntity(Entity par1Entity) {
        // override ItemSword
        return weaponDamage;
    }

    @Override
    public int getItemEnchantability() {
        // override ItemSword
        return toolMaterial.enchantability;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public String func_77825_f() {
        // used by furnaces to see if this is a wooden tool
        return toolMaterial.toString();
    }
}
