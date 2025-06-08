package utiles;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Config {

	public static final int ANCHO = 900;		// Ancho de la pantalla  
	public static final int ALTO = 500;		// Alto de la pantalla


	public static boolean online=true;
	public static boolean conectado=true;
	
	public static Camera camara;
	public static SpriteBatch b;
	private static Viewport v;
	
	private static int proporcion;
	
	public static  void iniciarCamara(){
		
			camara = new OrthographicCamera(ANCHO,ALTO);
	        camara.normalizeUp();
	        v = new FitViewport(ANCHO, ALTO, camara); 
	        v.update(ANCHO, ALTO,true);
	        Render.sb.setProjectionMatrix(camara.combined);
	}
	 
	
	
	public static void updateCamara(){
		camara.update();
	}
	
	public static float tamanioDeAlgo(int porc,float f){
	    proporcion = porc;
	   return (porc*f/100);
	}
	
	public static float centrado(float f){

	    return (f/2-(Config.tamanioDeAlgo(proporcion,f))/2);
	}
	
	public static float SacarPorcentaje(float nmb, int xyvalue){
        return (nmb*xyvalue/100);
    }
	
}
