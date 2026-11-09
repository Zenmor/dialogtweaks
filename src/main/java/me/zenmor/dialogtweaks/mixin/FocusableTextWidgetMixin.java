package me.zenmor.dialogtweaks.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import me.zenmor.dialogtweaks.DialogContext;
import net.minecraft.client.gui.components.FocusableTextWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FocusableTextWidget.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public class FocusableTextWidgetMixin {

	@WrapOperation(
		method = {"renderWidget", "extractWidgetRenderState"},
		at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/FocusableTextWidget;isFocused()Z")
	)
	private boolean hide(FocusableTextWidget instance, Operation<Boolean> original) {
		return !DialogContext.isDialogScreenOpen() && original.call(instance);
	}
}
