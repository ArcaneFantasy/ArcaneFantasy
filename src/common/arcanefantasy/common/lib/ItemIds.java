/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.lib;

/**
 * Class that stores item IDs.
 *
 * @author  HMPerson1
 */
@SuppressWarnings("PublicField" /* NOI18N */)
public class ItemIds {

    public static int   ID_ITEM_GEM     = 5000;
    public static int   ID_ITEM_METAL   = 5001;
    public static int   ID_ITEM_SLATEF  = 5002;
    public static int   ID_ITEM_CHALK   = 5003;
    public static int   ID_ITEM_SALT    = 5004;
    public static int[] ID_ITEM_SWORD   = new int[16];
    public static int[] ID_ITEM_AXE     = new int[16];
    public static int[] ID_ITEM_HOE     = new int[16];
    public static int[] ID_ITEM_PICKAXE = new int[16];
    public static int[] ID_ITEM_SPADE   = new int[16];

    static {
        ID_ITEM_SWORD[0]   = 5021;
        ID_ITEM_AXE[0]     = 5037;
        ID_ITEM_HOE[0]     = 5053;
        ID_ITEM_PICKAXE[0] = 5069;
        ID_ITEM_SPADE[0]   = 5085;

        for (int i = 1; i < 16; i++) {
            ID_ITEM_AXE[i]     = ID_ITEM_AXE[i - 1] - 1;
            ID_ITEM_HOE[i]     = ID_ITEM_HOE[i - 1] - 1;
            ID_ITEM_PICKAXE[i] = ID_ITEM_PICKAXE[i - 1] - 1;
            ID_ITEM_SPADE[i]   = ID_ITEM_SPADE[i - 1] - 1;
            ID_ITEM_SWORD[i]   = ID_ITEM_SWORD[i - 1] - 1;
        }
    }

    private ItemIds() { }

}
