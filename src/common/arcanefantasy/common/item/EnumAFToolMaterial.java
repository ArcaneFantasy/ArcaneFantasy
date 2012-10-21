/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.item;

/**
 * DOCUMENT ME!
 *
 * @author  HMPeron1
 */
public enum EnumAFToolMaterial {

    // TODO: Change these defaults
    CRYSTAL   (3, 1561, 8.0F, 3, 10, false, 0),
    AMETHYST  (3, 1561, 8.0F, 3, 10, false, 1),
    COPPER    (2, 250, 6.0F, 2, 14, true, 0),
    PYRITE    (2, 250, 6.0F, 2, 14, true, 1),
    MAGNEZE   (2, 250, 6.0F, 2, 14, true, 2),
    SILVER    (2, 250, 6.0F, 2, 14, true, 3),
    MAGILITH  (2, 250, 6.0F, 2, 14, true, 4),
    DRAGON    (2, 250, 6.0F, 2, 14, true, 5),
    PLATINUM  (2, 250, 6.0F, 2, 14, true, 6),
    PALADINIUM(2, 250, 6.0F, 2, 14, true, 7),
    FIRIUM    (2, 250, 6.0F, 2, 14, true, 8),
    GLACIUM   (2, 250, 6.0F, 2, 14, true, 9),
    FOUDRIUM  (2, 250, 6.0F, 2, 14, true, 10);

    public final int     harvestLevel;
    public final int     maxUses;
    public final float   efficiencyOnProperMaterial;
    public final int     damageVsEntity;
    public final int     enchantability;
    public final boolean isIngot;
    public final int     materialMeta;

    private EnumAFToolMaterial(final int     harvestLevel,
                               final int     maxUses,
                               final float   efficiency,
                               final int     damage,
                               final int     enchantability,
                               final boolean isIngot,
                               final int     materialMeta) {
        this.harvestLevel               = harvestLevel;
        this.maxUses                    = maxUses;
        this.efficiencyOnProperMaterial = efficiency;
        this.damageVsEntity             = damage;
        this.enchantability             = enchantability;
        this.isIngot                      = isIngot;
        this.materialMeta               = materialMeta;
    }
}
