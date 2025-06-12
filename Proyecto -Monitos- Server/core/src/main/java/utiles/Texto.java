package utiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Texto {
	BitmapFont fuente;
	private float x = 0, y = 0;
	private String texto = "";
	GlyphLayout glyphLayout;
	
	public Texto(String rutaFuente, int dimension, Color color, boolean sombra) {
		generarTexto(rutaFuente, dimension, color, sombra);
	}
	
	public void generarTexto(String rutaFuente, int dimension, Color color, boolean sombra) {
		FreeTypeFontGenerator generadores = new FreeTypeFontGenerator(Gdx.files.internal(rutaFuente));
		FreeTypeFontParameter parametros = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parametros.size = dimension;
		parametros.color = color;
		if (sombra) {
			parametros.shadowColor = Color.BLACK;
			parametros.shadowOffsetX = 1;
			parametros.shadowOffsetY = 1;	
		}
        fuente = generadores.generateFont(parametros);
        glyphLayout = new GlyphLayout();
	}
	
	public void setColor(Color color) {
		fuente.setColor(color);
	}
	
	public void dibujar() {
		fuente.draw(Render.sb, texto, x, y);
	}
	
	public void setPosicion (float x, float y) {	
		this.x=x;
		this.y=y;
	}
	
	public void getPosicion (float x, float y) {	
		this.x=x;
		this.y=y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		glyphLayout.setText(fuente, texto);
	}
	
	public float getAncho() {
		return glyphLayout.width;
	}
	
	public float getAlto() {
		return glyphLayout.height;
	}
}