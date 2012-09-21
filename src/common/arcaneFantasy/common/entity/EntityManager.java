/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.entity;

import net.minecraft.src.RenderLiving;

import arcaneFantasy.common.entity.mob.EntityRapace;
import arcaneFantasy.common.entity.mob.model.ModelRapace;
import arcaneFantasy.common.lib.EntityIds;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

/**
 *
 * @author HMPerson1
 */
public class EntityManager {

    /**
     * Initializes and registers all entities.
     */
    @SuppressWarnings("unchecked") // FORGE!!!! Y U FORGET ABOUT GENERICS?!?!
    public static void init() {
        EntityRegistry.registerGlobalEntityID(EntityRapace.class, "Rapace", EntityIds.ENTITY_RAPACE);
        RenderingRegistry.registerEntityRenderingHandler(EntityRapace.class, new RenderLiving(new ModelRapace(), 0.7f));
    }
}