package me.zenmor.dialogtweaks.platform.fabric;

//? fabric {

import me.zenmor.dialogtweaks.DialogTweaks;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		DialogTweaks.onInitializeClient();
	}

}
//?}
