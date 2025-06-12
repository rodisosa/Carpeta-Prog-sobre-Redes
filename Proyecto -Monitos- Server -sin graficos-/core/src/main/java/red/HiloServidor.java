package red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import pantalla.PantallaOnline;

public class HiloServidor extends Thread{
	private DatagramSocket conexion;
	private boolean fin = false;
	private DireccionRed[] clientes = new DireccionRed[2];
	private int cantClientes = 0; //--------------------------------------------------
	private int puerto = 8851;
	private boolean creado = false, err = false, aux = false;
	PantallaOnline app;
	
	public HiloServidor(PantallaOnline app){
		this.app = app;
		fin = false;
		creado = crearServer();   
    }

	public boolean crearServer() {
		try {
			conexion = new DatagramSocket(puerto);
			System.out.println("sv creado en el puerto: "+ puerto);
			return true;
		} catch (SocketException e) {
			System.out.println("No se pudo crear el sv en el puerto: "+puerto);
            e.printStackTrace();
            return false;
		}	
	}

	@Override
	public void run() {
		do {
			while (!creado) {//comprobar si el socket existe
				try {
					Thread.sleep(2000);
					puerto++;
					creado=crearServer();
				} catch (InterruptedException e) {}
			}
			do {
				if(conexion.isClosed()) err=true;
				else{
					byte[] data = new byte[1024];
					DatagramPacket dp = new DatagramPacket(data, data.length);
					try {  
						//System.out.println("esperando mensaje");
						conexion.receive(dp); 
					}catch(Exception e) {
						if (conexion.isClosed()) {
							System.out.println("el socket esta cerrado");
							err=true;
						}       
					}
					procesarMensaje(dp);
				}
			} while (!err);
		}while (fin);
    }

	public void enviarMensaje(String msg, InetAddress ip, int puerto) {
		System.out.println("Enviar mensaje: " + msg);
		byte[] data = msg.getBytes();
		DatagramPacket dp = new DatagramPacket(data, data.length, ip, puerto);
		try {
			conexion.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void enviarMensajeATodos(String msg) {
		for (int i=0; i<clientes.length; i++) {
			enviarMensaje(msg, clientes[i].getIp(), clientes[i].getPuerto());
		}
	}
	
	public void enviarMensajeCliente1(String msg) {
		for (int i=0; i<clientes.length; i++) {
			if (i==0) {
				enviarMensaje(msg, clientes[0].getIp(), clientes[0].getPuerto());
			}
		}
	}
	
	public void enviarMensajeCliente2(String msg) {
		for (int i=0; i<clientes.length; i++) {
			if (i==1) {
				enviarMensaje(msg, clientes[1].getIp(), clientes[1].getPuerto());
			}	
		}
	}
	
	public void procesarMensaje(DatagramPacket dp) {
		String msg = new String(dp.getData()).trim();
		int nroCliente = -1;
		System.out.println("Mensaje procesado: " + msg);
		if (cantClientes>1) {
			for (int i=0; i<clientes.length; i++) {
				if (dp.getPort()==clientes[i].getPuerto() && dp.getAddress().equals(clientes[i].getIp())) {
					nroCliente = i;
				}
			}
		}
		
		if (msg.equals("Desconexion")) {
			if (cantClientes==2) {enviarMensajeATodos("Desconexion");}
			cantClientes = 0;
			app.partidaTerminada = false;
			aux = true;
			System.out.println("Desconectar");
			cerrarHilo();
		}
		
		if (cantClientes<2) {	
			if(!aux) {
				if (msg.equals("Conexion")) {
					System.out.println("Recibió un jugador");
					if (cantClientes<2) {
						clientes[cantClientes] = new DireccionRed(dp.getAddress(), dp.getPort());
						enviarMensaje("OK", clientes[cantClientes].getIp(), clientes[cantClientes++].getPuerto());
						if (cantClientes==2) {
							for (int i=0; i<clientes.length; i++) {
								enviarMensaje("Empezar<" + i, clientes[i].getIp(), clientes[i].getPuerto());
								System.out.println("Enviar mensaje empezar a jugador nro: "+ i+1);
							}
						}
					}
				}
			}
			aux = false;
		} else {
			if (nroCliente!=-1) {
				if (msg.equals("Der")) {
					if (nroCliente==0) app.der1 = true;
					else app.der2 = true;
				} else if (msg.equals("Izq")) {
					if (nroCliente==0) app.izq1 = true;
					else app.izq2 = true;
				} else if (msg.equals("NoDer")) {
					if (nroCliente==0) app.der1 = false;
					else app.der2 = false;
				} else if (msg.equals("NoIzq")) {
					if (nroCliente==0) app.izq1 = false;
					else app.izq2 = false;
				}
				if (msg.equals("Volver<a<Jugar")) {
					if (nroCliente==0) app.volJugar1 = true;
					else app.volJugar2 = true;
					System.out.println("llego volver a jugar");
				}
			} 
		}
	}
	
	public void cerrarHilo() {
		fin=true;
	}
	
	public int getCantClientes() {
		return cantClientes;
	}
}