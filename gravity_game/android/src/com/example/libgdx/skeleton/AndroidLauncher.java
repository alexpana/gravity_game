package com.example.libgdx.skeleton;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import org.vertexarmy.gravity.game.GravityGame;


public class AndroidLauncher extends AndroidApplication
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		cfg.useAccelerometer = false;
		cfg.useCompass = false;
		cfg.useWakelock = true;
		cfg.useGL20 = true;
		initialize(new GravityGame(), cfg);
	}
}
