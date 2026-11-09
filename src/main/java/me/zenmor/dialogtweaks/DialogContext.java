package me.zenmor.dialogtweaks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.dialog.DialogScreen;

public final class DialogContext {

	private DialogContext() {
	}

	public static boolean isDialogScreenOpen() {
		//? if >= 26.2 {
		return Minecraft.getInstance().gui.screen() instanceof DialogScreen<?>;
		//?} else {
		/*return Minecraft.getInstance().screen instanceof DialogScreen<?>;
		*///?}
	}
}
