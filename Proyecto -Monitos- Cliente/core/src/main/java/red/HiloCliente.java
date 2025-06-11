package red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import pantalla.PantallaOnline;
import utiles.Config;

public class HiloCliente extends Thread{
	private DatagramSocket conexion;
	private InetAddress ipServer;
	private int puerto = 8851;
	private boolean fin = false;
	private PantallaOnline app;
	
	public HiloCliente(PantallaOnline app) {
		this.app = app;
		try {
			ipServer = InetAddress.getByName("255.255.255.255");
			conexion = new DatagramSocket();
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}
		enviarMensaje("Conexion");
		
		System.out.println("Mensaje Enviado");
	}

	public void enviarMensaje(String msg) {
		byte[] data = msg.getBytes();
		DatagramPacket dp = new DatagramPacket(data, data.length, ipServer, puerto);
		try {
			conexion.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		do {
			byte[] data = new byte[1024];
			DatagramPacket dp = new DatagramPacket(data, data.length);
			try {
				conexion.receive(dp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			procesarMensaje(dp);
		}while(!fin);
		
		
		
	}

	public void procesarMensaje(DatagramPacket dp) {
		String msg = new String(dp.getData()).trim();
		
		String mensajeParametrizado[] = msg.split("-");
		
		//System.out.println(msg);
		
		if(mensajeParametrizado.length < 3) {
			if(msg.equals("OK")) {
				ipServer = dp.getAddress();
				Config.conectado = true;
			}
			
			if (mensajeParametrizado[0].equals("Empezar")) {
				enviarMensaje("OK");
				Config.online = true;
				System.out.println("Llegó el mensaje empezar");  //----------------------------------------
				int nroJ = Integer.parseInt(mensajeParametrizado[1]);
				if(nroJ == 0) app.jugador=true;
				else app.jugador=false;
			}
			
			if (mensajeParametrizado[0].equals("Tiempo")) {
				int tiempo = Integer.parseInt(mensajeParametrizado[1]);
				app.tem = tiempo;
			}
			
		} else {
			
			if(mensajeParametrizado[0].equals("Actualizar")) {
				if (mensajeParametrizado[1].equals("Mono1")) {
					float posX1 = Float.parseFloat(mensajeParametrizado[2]);
					if(mensajeParametrizado[3].equals("false")) app.mono1.camIzq=false;
					else if(mensajeParametrizado[3].equals("true")) app.mono1.camIzq=true;
					if(mensajeParametrizado[4].equals("false")) app.mono1.camDer=false;
					else if(mensajeParametrizado[4].equals("true")) app.mono1.camDer=true;
					app.mono1.setPosX(posX1);
				} else if(mensajeParametrizado[1].equals("Mono2")) {
					float posX1 = Float.parseFloat(mensajeParametrizado[2]);
					if(mensajeParametrizado[3].equals("false")) app.mono2.camIzq=false;
					else if(mensajeParametrizado[3].equals("true")) app.mono2.camIzq=true;
					if(mensajeParametrizado[4].equals("false")) app.mono2.camDer=false;
					else if(mensajeParametrizado[4].equals("true")) app.mono2.camDer=true;
					app.mono2.setPosX(posX1);
				} else if (mensajeParametrizado[1].equals("Puntos1")) {
					int puntos1 = Integer.parseInt(mensajeParametrizado[2]);
					app.mono1.puntos=puntos1;
				} else if (mensajeParametrizado[1].equals("Puntos2")) {
					int puntos2 = Integer.parseInt(mensajeParametrizado[2]);
					app.mono2.puntos=puntos2;
				}
			}
			
			if (mensajeParametrizado[0].equals("CrearFruta")) {
				int nroF = Integer.parseInt(mensajeParametrizado[1]);
				float posX = Float.parseFloat(mensajeParametrizado[2]);
				app.crearFruta(nroF, posX);
				
			}
			
			if (mensajeParametrizado[0].equals("Borrar")) {
				if(mensajeParametrizado[1].equals("Fruta")) {
					int posI = Integer.parseInt(mensajeParametrizado[2]);
					for(int i = app.arrayFrutas.size - 1; i >= 0; i--) {
						if(i == posI) {
							app.arrayFrutas.removeIndex(i);
						}
					}
				}
			}
			
		}
		
		
		
	}
	
	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}
	
	
}