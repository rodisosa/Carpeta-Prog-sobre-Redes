package entrada;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

import pantalla.PantallaLocal;
import pantalla.PantallaLocalFinal;
import pantalla.PantallaMenu;

public class Teclado implements InputProcessor{

	private boolean 
	arriba = false, 
	abajo = false, 
	izq = false, 
	der = false, 
	enter = false, 
			
	w = false, 
	a = false, 
	d = false, 
	x = false, 
	c = false;

protected boolean inputflag=true;


PantallaMenu app;
PantallaLocal app1;
PantallaLocalFinal app2;

	public Teclado (PantallaMenu app) {
		this.app = app;
	}

public Teclado (PantallaLocal app) {
this.app1 = app;
}

public Teclado (PantallaLocalFinal app) {
this.app2 = app;
}



//----------------------------------------------------

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

public boolean isW() {
return w;
}

public void setW(boolean w) {
this.w = w;
}

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

public boolean isX() {
return x;
}

public void setX(boolean x) {
this.x = x;
}

public boolean isC() {
return c;
}

public void setC(boolean c) {
this.c = c;
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

case Keys.W:
	w = true;
	break;

case Keys.A:
	a = true;
	break;

case Keys.D:
	d = true;
	break;
	
case Keys.X:
	x = true;
	break;

case Keys.C:
	c = true;
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

case Keys.W:
	w = false;
	break;

case Keys.A:
	a = false;
	break;

case Keys.D:
	d = false;
	break;
	
case Keys.X:
	x = false;
	break;
}

return false;
}

@Override
public boolean keyTyped(char character) {
// TODO Auto-generated method stub
return false;
}

@Override
public boolean touchDown(int screenX, int screenY, int pointer, int button) {
// TODO Auto-generated method stub
return false;
}

@Override
public boolean touchUp(int screenX, int screenY, int pointer, int button) {
// TODO Auto-generated method stub
return false;
}

@Override
public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
// TODO Auto-generated method stub
return false;
}

@Override
public boolean touchDragged(int screenX, int screenY, int pointer) {
// TODO Auto-generated method stub
return false;
}

@Override
public boolean mouseMoved(int screenX, int screenY) {
// TODO Auto-generated method stub
return false;
}

@Override
public boolean scrolled(float amountX, float amountY) {
// TODO Auto-generated method stub
return false;
}

public void stopInput(){
inputflag=false;
}

public void startInput(){
inputflag=true;
}
	
	
}
