/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.network;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet250CustomPayload;


/**
 * Handles the packets for this mod.
 *
 * @author  HMPerson1
 */
public class PacketHandler implements IPacketHandler {

    @Override
    public void onPacketData(NetworkManager manager, Packet250CustomPayload packet, Player player) {
        // TODO: Packet stuff...
    }
}
