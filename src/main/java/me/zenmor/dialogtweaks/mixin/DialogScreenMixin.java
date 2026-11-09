package me.zenmor.dialogtweaks.mixin;

import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.dialog.DialogScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DialogScreen.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public abstract class DialogScreenMixin extends Screen {

	@Shadow
	private Button warningButton;

	protected DialogScreenMixin(Component title) {
		super(title);
	}

	@Inject(method = "createTitleWithWarningButton", at = @At("HEAD"), cancellable = true)
	private void titleOnly(CallbackInfoReturnable<LayoutElement> cir) {
		cir.setReturnValue(new StringWidget(this.title, this.font));
	}

	@Inject(method = "init", at = @At("RETURN"))
	private void hideWarningButton(CallbackInfo ci) {
		this.removeWidget(this.warningButton);
	}
}
