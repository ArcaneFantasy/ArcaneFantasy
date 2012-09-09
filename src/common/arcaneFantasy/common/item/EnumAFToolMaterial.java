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

    COPPER,
    PYRITE,
    MAGNEZE,
    SILVER,
    MAGILITH,
    DRAGON,
    PLATINUM,
    PALADINIUM,
    FIRIUM,
    GLACIUM,
    FOUDRIUM;
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