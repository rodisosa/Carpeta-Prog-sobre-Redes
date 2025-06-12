package entrada;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

import pantalla.PantallaLocal;
import pantalla.PantallaLocalFinal;
import pantalla.PantallaMenu;
import pantalla.PantallaOnline;

public class Teclado implements InputProcessor{

	private boolean 
	arriba = false, 
	abajo = false, 
	izq = false, 
	der = false, 
	enter = false, 
	esc = false,
	a = false, 
	d = false; 

	protected boolean inputflag=true;

	PantallaMenu app;
	PantallaLocal app1;
	PantallaLocalFinal app2;
	PantallaOnline app3;

	public Teclado (PantallaMenu app) {
		this.app = app;
	}

	public Teclado (PantallaLocal app) {
		this.app1 = app;
	}

	public Teclado (PantallaLocalFinal app) {
		this.app2 = app;
	}

	public Teclado (PantallaOnline app) {
		this.app3 = app;
	}

//----------------------------------------------------
	public boolean isEsc() {
	return esc;
	}

	public void setEsc(boolean esc) {
		this.esc = esc;
	}

	public boolean isEnter() {
		return enter;
	}

	public void setEnter(boolean enter) {
		this.enter = enter;
	}

	public boolean isArriba() {
		return arriba;
	}

	public void setArriba(boolean arriba) {
		this.arriba = arriba;
	}

	public boolean isAbajo() {
		return abajo;
	}

	public void setAbajo(boolean abajo) {
		this.abajo = abajo;
	}

//----------------------------------------------------

	public boolean isIzq() {
		return izq;
	}

	public void setIzq(boolean izq) {
		this.izq = izq;
	}

	public boolean isDer() {
		return der;
	}

	public void setDer(boolean der) {
		this.der = der;
	}

//----------------------------------------------------

	public boolean isA() {
		return a;
	}

	public void setA(boolean a) {
		this.a = a;
	}

	public boolean isD() {
		return d;
	}

	public void setD(boolean d) {
		this.d = d;
	}

	@Override
	public boolean keyDown(int keycode) {

		switch(keycode) {

		case Keys.DOWN:
			abajo = true;
			break;

		case Keys.UP:
			arriba = true;
			break;
	
		case Keys.LEFT:
			izq = true;
			break;	
	
		case Keys.RIGHT:
			der = true;
			break;	
	
		case Keys.ENTER:
			enter = true;
			break;

		case Keys.A:
			a = true;
			break;

		case Keys.D:
			d = true;
			break;
	
		case Keys.ESCAPE:
			esc = true;
			break;
		}

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {

		switch(keycode) {

		case Keys.DOWN:
			abajo = false;
			break;

		case Keys.UP:
			arriba = false;
			break;
	
		case Keys.LEFT:
			izq = false;
			break;	
	
		case Keys.RIGHT:
			der = false;
			break;
	
		case Keys.ENTER:
			enter = false;
			break;

		case Keys.A:
			a = false;
			break;

		case Keys.D:
			d = false;
			break;
	
		case Keys.ESCAPE:
			esc = false;
			break;
		}

		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}

	public void stopInput(){
		inputflag=false;
	}

	public void startInput(){
		inputflag=true;
	}	
}
