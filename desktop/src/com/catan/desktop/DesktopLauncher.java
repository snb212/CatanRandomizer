package com.catan.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.catan.CatanRandomizer;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
//		config.height = 400;
//		config.width = 200;
		
		new LwjglApplication(new CatanRandomizer(), config);
	}
}
