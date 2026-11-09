package me.zenmor.dialogtweaks.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import me.zenmor.dialogtweaks.DialogContext;
import net.minecraft.client.gui.components.AbstractButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractButton.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public class AbstractButtonMixin {

	@WrapOperation(
		method = {"renderDefaultSprite", "extractDefaultSprite"},
		at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/AbstractButton;isHoveredOrFocused()Z")
	)
	private boolean hide(AbstractButton instance, Operation<Boolean> original) {
		return DialogContext.isDialogScreenOpen() ? instance.isHovered() : original.call(instance);
	}
}
