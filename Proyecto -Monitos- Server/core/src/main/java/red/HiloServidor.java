package red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import pantalla.PantallaMenu;
import pantalla.PantallaOnline;

public class HiloServidor extends Thread{

	private DatagramSocket conexion;
	private boolean fin = false;
	private DireccionRed[] clientes = new DireccionRed[2];
	private int cantClientes = 0; //--------------------------------------------------
	private int puerto = 8851;
	private boolean creado = false, err = false;
	PantallaOnline app;
	
	public HiloServidor(PantallaOnline app){
		this.app = app;
		creado =crearServer();   
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
    }

	public void enviarMensaje(String msg, InetAddress ip, int puerto) {
		byte[] data = msg.getBytes();
		DatagramPacket dp = new DatagramPacket(data, data.length, ip, puerto);
		try {
			conexion.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void enviarMensajeATodos(String msg) {
		for (int i = 0; i < clientes.length; i++) {
			enviarMensaje(msg, clientes[i].getIp(), clientes[i].getPuerto());
		}
		
	}
	
	
	public void procesarMensaje(DatagramPacket dp) {
		String msg = new String(dp.getData()).trim();
		int nroCliente = -1;
		
		if(cantClientes>1) {
			for (int i=0; i < clientes.length; i++) {
				if(dp.getPort()==clientes[i].getPuerto() && dp.getAddress().equals(clientes[i].getIp())) {
					nroCliente=i;
				}
			}
		}
		
		if (cantClientes<2) {
			if(msg.equals("Conexion")) {
				
				System.out.println("Recibió un jugador");
				
				if(cantClientes < 2) {
					clientes[cantClientes] = new DireccionRed(dp.getAddress(), dp.getPort());
					enviarMensaje("OK", clientes[cantClientes].getIp(), clientes[cantClientes++].getPuerto());
					if(cantClientes == 2) {
						for(int i = 0; i < clientes.length; i++) {
							enviarMensaje("Empezar-" + i, clientes[i].getIp(), clientes[i].getPuerto());
							
							System.out.println("Enviar mensaje empezar a jugador nro: "+ i+1);
						}
					}
				}
			}
		} else {
			if(nroCliente != -1) {
				if (msg.equals("Der")) {
					if(nroCliente == 0) app.der1 = true;
					else app.der2 = true;
				} else if(msg.equals("Izq")) {
					if(nroCliente == 0) app.izq1 = true;
					else app.izq2 = true;
				} else if (msg.equals("NoDer")) {
					if(nroCliente == 0) app.der1 = false;
					else app.der2 = false;
				} else if(msg.equals("NoIzq")) {
					if(nroCliente == 0) app.izq1 = false;
					else app.izq2 = false;
				}
			} 
		}
	}
	
	
	
	public int getCantClientes() {
		return cantClientes;
	}




	
	
	
	
	
	
}
