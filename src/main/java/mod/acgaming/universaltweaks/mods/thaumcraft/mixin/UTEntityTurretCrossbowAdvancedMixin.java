package mod.acgaming.universaltweaks.mods.thaumcraft.mixin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import thaumcraft.common.entities.construct.EntityTurretCrossbow;
import thaumcraft.common.entities.construct.EntityTurretCrossbowAdvanced;

// Courtesy of Focamacho
@Mixin(EntityTurretCrossbowAdvanced.class)
public class UTEntityTurretCrossbowAdvancedMixin extends EntityTurretCrossbow
{
    public UTEntityTurretCrossbowAdvancedMixin(World worldIn)
    {
        super(worldIn);
    }

    @Inject(method = "processInteract", at = @At("HEAD"), cancellable = true)
    private void processInteract(EntityPlayer player, EnumHand hand, CallbackInfoReturnable<Boolean> cir)
    {
        if (getHealth() <= 0.0F) cir.setReturnValue(false);
    }
}