package com.hollingsworth.arsnouveau.common.armor;

import com.hollingsworth.arsnouveau.api.mana.IManaEquipment;
import com.hollingsworth.arsnouveau.api.util.ManaUtil;
import com.hollingsworth.arsnouveau.common.capability.ManaCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public abstract class MagicArmor extends ArmorItem implements IManaEquipment {

    public MagicArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(world.isRemote() || world.getGameTime() % 20 !=  0)
            return;

        if(stack.getDamage() == 0)
            return;

        ManaCapability.getMana(player).ifPresent(mana -> {
            if(mana.getCurrentMana() > 2){
                mana.removeMana(2);
                stack.setDamage(stack.getDamage() - 1);
            }
        });
    }
}