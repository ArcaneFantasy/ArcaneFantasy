package arcaneFantasy;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraft.src.forge.*;

public class ItemMagicArmor extends ItemArmor implements ITextureProvider, IArmorTextureProvider
{

        public ItemMagicArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
        {
                super(i, enumarmormaterial, j, k);
        }
        
        public String getTextureFile()
        {
                return "/ArcaneFantasy/gui/items.png";
        }

  public String getArmorTextureFile(ItemStack itemstack)
{
    if(itemstack.itemID == mod_ArcaneFantasy.helmetMagic.shiftedIndex || itemstack.itemID == mod_ArcaneFantasy.plateMagic.shiftedIndex || itemstack.itemID == mod_ArcaneFantasy.bootsMagic.shiftedIndex)
    {
            return "/ArcaneFantasy/armor/MagicArmor_1.png";
    }
    if(itemstack.itemID == mod_ArcaneFantasy.legsMagic.shiftedIndex)
    {
            return "/ArcaneFantasy/armor/MagicArmor_2.png";
    }
    return "/ArcaneFantasy/MagicArmor_1.png";
}
}