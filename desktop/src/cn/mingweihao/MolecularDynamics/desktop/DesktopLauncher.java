package cn.mingweihao.MolecularDynamics.desktop;

import cn.mingweihao.MolecularDynamics.MolecularDynamics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import cn.mingweihao.MolecularDynamics.MolecularDynamics;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MolecularDynamics(), config);
	}
}
