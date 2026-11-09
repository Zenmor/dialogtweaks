package me.zenmor.dialogtweaks.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import me.zenmor.dialogtweaks.DialogContext;
import net.minecraft.client.gui.components.AbstractSliderButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractSliderButton.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public class AbstractSliderButtonMixin {

	@WrapOperation(
		method = "getSprite",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/AbstractSliderButton;isFocused()Z")
	)
	private boolean hide(AbstractSliderButton instance, Operation<Boolean> original) {
		return !DialogContext.isDialogScreenOpen() && original.call(instance);
	}
}
