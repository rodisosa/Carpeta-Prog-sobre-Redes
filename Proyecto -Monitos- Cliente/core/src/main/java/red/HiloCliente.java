package red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import elementos.Fruta;
import pantalla.PantallaCargaOnline;
import utiles.Config;

public class HiloCliente extends Thread{
	private DatagramSocket conexion;
	private InetAddress ipServer;
	private int puerto = 8851;
	private boolean fin = false;
	private PantallaCargaOnline app;
	
	public HiloCliente(PantallaCargaOnline app) {
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
			} /*else if (msg.equals("Empezar")) {
				enviarMensaje("OK");
				Config.online = true;
				System.out.println("Llegó el mensaje empezar");
			}*/
			
			if (mensajeParametrizado[0].equals("Empezar")) {
				enviarMensaje("OK");
				Config.online = true;
				System.out.println("Llegó el mensaje empezar");  //----------------------------------------
				int nroJ = Integer.parseInt(mensajeParametrizado[1]);
				if(nroJ == 0) app.jugador=true;
				else app.jugador=false;
			}
			
		} else {
			if(mensajeParametrizado[0].equals("Actualizar")) {
				if (mensajeParametrizado[1].equals("Mono")) {
					float posX1 = Float.parseFloat(mensajeParametrizado[2]);
					float posX2 = Float.parseFloat(mensajeParametrizado[3]);
					app.mono1.setPosX(posX1);
					app.mono2.setPosX(posX2);
				}
			}
			
			if (mensajeParametrizado[0].equals("CrearFruta")) {
				int nroF = Integer.parseInt(mensajeParametrizado[1]);
				float posX = Float.parseFloat(mensajeParametrizado[2]);
				
				//app.fruta = new Fruta(nroF);
				app.crearFruta(nroF, posX);
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