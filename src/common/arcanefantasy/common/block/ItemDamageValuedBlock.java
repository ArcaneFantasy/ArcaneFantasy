/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.block;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;


/**
 * An ItemBlock for our blocks that are separated by damage value. The default
 * ItemBlock acts as if they're all the same thing
 *
 * @author  HMPerson1
 */
public class ItemDamageValuedBlock extends ItemBlock {

    /**
     * Array damage-value-indexed strings.
     */
    private final String[] names;

    /**
     * Creates a new ItemDamageValuedBlock object.
     *
     * @param  id  this item's id
     */
    public ItemDamageValuedBlock(int id) {
        super(id);
        this.setHasSubtypes(true);

        // The item id is offset 256 from the block id
        names = getDamagedNames(id + 256);
    }

    @Override
    public int getMetadata(int metadata) {

        // the default impl just returns 0
        return metadata;
    }

    /**
     * {@inheritDoc}
     *
     * @param   is {@inheritDoc}
     *
     * @return  {@inheritDoc}
     */
    @Override
    public String getItemNameIS(ItemStack is) {
        return String.format("%s.%s", getItemName(), names[is.getItemDamage()]);
    }

    /**
     * Helper method for retrieving the field {@code DAMAGED_NAMES} from a
     * block.
     *
     * @param   id  the block's id
     *
     * @return  {@code DAMAGED_NAMES} field of the block
     *
     * @throws  RuntimeException  DOCUMENT ME!
     */
    private static String[] getDamagedNames(int id) {

        try {

            // reflexively find the field
            return (String[]) Block.blocksList[id].getClass().getField("DAMAGED_NAMES").get(null);
        } catch (NoSuchFieldException ex) {
            throw new RuntimeException(ex);
        } catch (SecurityException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
}
