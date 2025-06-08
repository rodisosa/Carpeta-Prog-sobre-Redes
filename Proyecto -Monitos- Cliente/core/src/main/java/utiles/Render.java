package utiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dojan.monitos.Monitos;

public class Render {

	public static SpriteBatch sb;
	public static Sprite s;
	public static Monitos app;
	
	public static void LimpPant() {
		Gdx.gl.glClearColor (1,1,1,1);
		Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);

	}
	
	public static void begin() {
		sb.begin();
	}
	
	public static void end() {
		sb.end();
	}
	
	public static void dispose() {
		sb.dispose();
	}
}