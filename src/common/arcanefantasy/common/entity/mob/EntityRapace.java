/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.entity.mob;

import arcanefantasy.common.lib.Reference;

import net.minecraft.src.EntityAnimal;
import net.minecraft.src.World;


/**
 * An {@code Entity} for our Rapace. Includes code from
 * {@link net.minecraft.src.EntityFlying} to make it fly.
 *
 * @author  HMPerson1
 */
public class EntityRapace extends EntityAnimal {

    /**
     * Health.
     */
    private static final int MAX_HEALTH = 10;

    public EntityRapace(final World world) {
        super(world);
        setSize(1.0F, 0.2F);
        texture = Reference.TEXTURE_LOCATION + Reference.RAPACE_TEXTURE;
    }

    @Override
    protected void fall(final float fallDistance) { }

    @Override
    public EntityAnimal spawnBabyAnimal(final EntityAnimal var1) {
        return new EntityRapace(worldObj);
    }

    @Override
    public int getMaxHealth() {
        return MAX_HEALTH;
    }

}
