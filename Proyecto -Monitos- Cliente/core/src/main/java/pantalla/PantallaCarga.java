package pantalla;

import com.badlogic.gdx.Screen;

import utiles.Config;
import utiles.Imagen;
import utiles.Recursos;
import utiles.Render;

public class PantallaCarga implements Screen{

	Imagen fondo;
	boolean fadeInTerminado = false, termina = false;
	float aux = 0;
	float tiempo = 0, tiempoEsp = 5;
	float contTiempoFinal = 0, tiempoFinal = 5;
	
	@Override
	public void show() {
		fondo = new Imagen (Recursos.FONDO_CARGA);
		fondo.setSize(Config.ANCHO, Config.ALTO);
		fondo.setTransparencia(1f);
	}

	@Override
	public void render(float delta) {
		Render.LimpPant();
		procesarFade();
		Render.begin();
			fondo.dibujar();
		Render.end();
	}
	
	private void procesarFade() {
		fondo.setTransparencia(aux);
		if (!fadeInTerminado) {
			aux += 0.01f;
			if (aux>1) {
				aux = 1;
				fadeInTerminado = true;
			}
		} else {
			tiempo+=0.1f;
			if (tiempo>tiempoEsp) {
				aux -= 0.01f;
				if (aux<0) {
					aux = 0;
					termina = true;
				}
			}
		}
		fondo.setTransparencia(aux);
		if (termina){
			contTiempoFinal+=0.1f;
			if (contTiempoFinal>tiempoFinal){
				Render.app.setScreen((Screen) new PantallaMenu());
			}
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
		dispose();
		Render.dispose();
	}
}
