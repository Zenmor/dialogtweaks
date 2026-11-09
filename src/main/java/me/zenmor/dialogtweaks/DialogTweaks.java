package me.zenmor.dialogtweaks;

import me.zenmor.dialogtweaks.platform.Platform;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.zenmor.dialogtweaks.platform.fabric.FabricPlatform;

@SuppressWarnings("LoggingSimilarMessage")
public class DialogTweaks {

	public static final String MOD_ID = /*$ mod_id*/"dialogtweaks";
	public static final String MOD_VERSION = /*$ mod_version*/"0.1.0";
	public static final String MOD_FRIENDLY_NAME = /*$ mod_name*/"DialogTweaks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		LOGGER.info("Initializing {} on {}", MOD_ID, DialogTweaks.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}

	public static void onInitializeClient() {
		LOGGER.info("Initializing {} Client on {}", MOD_ID, DialogTweaks.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}

	public static Platform xplat() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		return new FabricPlatform();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	public static Identifier id(String namespace, String path) {
		return Identifier.fromNamespaceAndPath(namespace, path);
	}
}
