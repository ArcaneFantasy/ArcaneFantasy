/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcane_fantasy.common.entity;

import arcane_fantasy.common.entity.mob.EntityRapace;
import arcane_fantasy.common.entity.mob.model.ModelRapace;
import arcane_fantasy.common.entity.renderers.RenderRapace;
import arcane_fantasy.common.lib.EntityIds;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EnumCreatureType;


/**
 * DOCUMENT ME!
 *
 * @author  HMPerson1
 */
public class EntityManager {

    /**
     * Initializes and registers all entities.
     */
    @SuppressWarnings("unchecked" /* NOI18N */)
    // FORGE!!!! Y U FORGET ABOUT GENERICS?!?!
    public static void init() {
        EntityRegistry.registerGlobalEntityID(EntityRapace.class, "Rapace" /* NOI18N */,
            EntityIds.ENTITY_RAPACE);
        EntityRegistry.addSpawn(EntityRapace.class, 1, 0, 256, EnumCreatureType.creature,
            BiomeGenBase.plains, BiomeGenBase.forest);
        RenderingRegistry.registerEntityRenderingHandler(EntityRapace.class,
            new RenderRapace(new ModelRapace(), 0.7f));
    }
}
