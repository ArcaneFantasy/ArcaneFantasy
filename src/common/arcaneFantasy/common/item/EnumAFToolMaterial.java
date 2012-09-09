/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.item;

/**
 *
 * @author HMPeron1
 */
public enum EnumAFToolMaterial {

    // TODO: Change these defaults
    COPPER(2, 250, 6.0F, 2, 14),
    PYRITE(2, 250, 6.0F, 2, 14),
    MAGNEZE(2, 250, 6.0F, 2, 14),
    SILVER(2, 250, 6.0F, 2, 14),
    MAGILITH(2, 250, 6.0F, 2, 14),
    DRAGON(2, 250, 6.0F, 2, 14),
    PLATINUM(2, 250, 6.0F, 2, 14),
    PALADINIUM(2, 250, 6.0F, 2, 14),
    FIRIUM(2, 250, 6.0F, 2, 14),
    GLACIUM(2, 250, 6.0F, 2, 14),
    FOUDRIUM(2, 250, 6.0F, 2, 14);
    public final int harvestLevel;
    public final int maxUses;
    public final float efficiencyOnProperMaterial;
    public final int damageVsEntity;
    public final int enchantability;

    private EnumAFToolMaterial(int harvestLevel, int maxUses, float efficiency, int damage, int enchantability) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiencyOnProperMaterial = efficiency;
        this.damageVsEntity = damage;
        this.enchantability = enchantability;
    }
}