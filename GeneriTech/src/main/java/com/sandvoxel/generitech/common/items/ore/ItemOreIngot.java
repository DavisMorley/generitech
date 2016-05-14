package com.sandvoxel.generitech.common.items.ore;

import com.sandvoxel.generitech.GeneriTechTabs;
import com.sandvoxel.generitech.Reference;
import com.sandvoxel.generitech.common.enumtypes.EnumOreType;
import com.sandvoxel.generitech.common.enumtypes.EnumOres;
import com.sandvoxel.generitech.common.items.ItemBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;

import java.util.List;


public class ItemOreIngot extends ItemBase {

    public ItemOreIngot(){
        super("ore/ingot");
        this.setHasSubtypes(true);
        this.setCreativeTab(GeneriTechTabs.ORE);
        this.setInternalName("oreingot");
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (int i = 0; i < EnumOres.values().length; i++) {
            if (EnumOres.byID(i).isTypeSet(EnumOreType.INGOT)) {
                subItems.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String name = super.getUnlocalizedName();
        String oreName = EnumOres.byID(stack.getItemDamage()).getName();
        return name + "." + oreName;
    }

    @Override
    public void registerItemRenderer() {
        for (int i = 0; i < EnumOres.values().length; i++) {
            if (EnumOres.byID(i).isTypeSet(EnumOreType.INGOT)) {
                ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(Reference.MOD_ID + ":" + resourcePath + "/ingot-" + EnumOres.byID(i).getName(), "inventory"));
            }
        }
    }
}
