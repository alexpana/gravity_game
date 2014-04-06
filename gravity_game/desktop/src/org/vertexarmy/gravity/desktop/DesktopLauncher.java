package org.vertexarmy.gravity.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.vertexarmy.gravity.game.GravityGame;

public class DesktopLauncher {

    private static LwjglApplicationConfiguration configuration;

    public static void main(String[] args) {
        initConfiguration();
		new LwjglApplication(new GravityGame(), configuration);
	}

    private static void initConfiguration() {
        configuration = new LwjglApplicationConfiguration();
        configuration.useGL20 = true;
        configuration.resizable = false;
        configuration.vSyncEnabled = true;
        configuration.fullscreen = false;
        setResolution(Resolution.GALAXY_S3);
    }

    private static void setResolution(Resolution resolution) {
        configuration.width = resolution.width;
        configuration.height =  resolution.height;
    }
}