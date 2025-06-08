package elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import utiles.Recursos;



public class Sprites {
	
	static TextureAtlas atlas;
	public static Sprite  monoMarronEst, monoGrisEst, manzana, pera, banana;
	public static Animation<Sprite> monoMarronCamDer, monoMarronCamIzq, monoGrisCamDer, monoGrisCamIzq;
	
	
	
	public static void load() {
		atlas = new TextureAtlas(Gdx.files.internal(Recursos.ATLAS));
		monoGrisEst = atlas.createSprite("MonoGrisEst");
		monoGrisCamIzq = new Animation<Sprite>(Mono.DURACION_DE_FRAMES,
				atlas.createSprite("MonoGrisCamIzq1"),
				atlas.createSprite("MonoGrisCamIzq2"),
				atlas.createSprite("MonoGrisCamIzq3"),
				atlas.createSprite("MonoGrisCamIzq4"),
				atlas.createSprite("MonoGrisCamIzq5"));
		monoGrisCamDer = new Animation<Sprite>(Mono.DURACION_DE_FRAMES,
				atlas.createSprite("MonoGrisCamDer1"),
				atlas.createSprite("MonoGrisCamDer2"),
				atlas.createSprite("MonoGrisCamDer3"),
				atlas.createSprite("MonoGrisCamDer4"),
				atlas.createSprite("MonoGrisCamDer5"));
		
		monoMarronEst = atlas.createSprite("MonoMarronEst");
		monoMarronCamIzq = new Animation<Sprite>(Mono.DURACION_DE_FRAMES,
				atlas.createSprite("MonoMarronCamIzq1"),
				atlas.createSprite("MonoMarronCamIzq2"),
				atlas.createSprite("MonoMarronCamIzq3"),
				atlas.createSprite("MonoMarronCamIzq4"),
				atlas.createSprite("MonoMarronCamIzq5"));
		monoMarronCamDer = new Animation<Sprite>(Mono.DURACION_DE_FRAMES,		
				atlas.createSprite("MonoMarronCamDer1"),
				atlas.createSprite("MonoMarronCamDer2"),
				atlas.createSprite("MonoMarronCamDer3"),
				atlas.createSprite("MonoMarronCamDer4"),
				atlas.createSprite("MonoMarronCamDer5"));
		
		manzana = atlas.createSprite("manzana");
		pera = atlas.createSprite("pera");
		banana = atlas.createSprite("banana");
	}

	public void dispose() {
		atlas.dispose();
	}
}