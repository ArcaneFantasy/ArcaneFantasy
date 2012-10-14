/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.entity.renderers;

import arcanefantasy.common.entity.mob.EntityRapace;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;


/**
 * DOCUMENT ME!
 *
 * @author  HMPerson1
 */
public class RenderRapace extends RenderLiving {

    /**
     * Creates a renderer for Rapaces.
     *
     * @param  model   model to render
     * @param  shadow  shadow size to render
     */
    public RenderRapace(ModelBase model, float shadow) {
        super(model, shadow);
    }

    /**
     * Returns the rotation of the wings for a given Rapace.
     *
     * @param   rapace        the Rapace
     * @param   partialTicks  partial ticks
     *
     * @return  wing rotation in radians
     */
    protected float getWingRotation(EntityRapace rapace, float partialTicks) {
        return (float) Math.sin((rapace.ticksExisted + partialTicks) / 4);
    }

    @Override
    protected float handleRotationFloat(EntityLiving entity, float partialTicks) {
        return getWingRotation((EntityRapace) entity, partialTicks);
    }
}
