package net.riser876.blockrestore;

import net.fabricmc.api.ModInitializer;
import net.riser876.blockrestore.config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import static net.riser876.blockrestore.config.ConfigManager.CONFIG;

public class BlockRestore implements ModInitializer {

    public static final String MOD_ID = "blockrestore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        try {
            ConfigManager.loadConfig();
            LOGGER.info("[BlockRestore] Configuration loaded.");
        } catch (Exception e) {
            LOGGER.error("[BlockRestore] Failed to load configuration.", e);
        }

        if (Objects.isNull(CONFIG)) {
            LOGGER.error("[BlockRestore] Configuration file is broken.");
            return;
        }

        if (!CONFIG.ENABLED) {
            LOGGER.info("[BlockRestore] Mod disabled via config.");
            return;
        }

        LOGGER.info("[BlockRestore] Mod initialized.");
    }
}
