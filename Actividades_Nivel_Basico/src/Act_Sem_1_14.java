import java.util.Scanner;

public class Act_Sem_1_14 {

	public static void main(String[] args) {
		boolean error = false;
		Scanner s = new Scanner(System.in);
		String fecha = null, dia, mes, ano;
		int posicion=0, numDia=0, numMes=0, numAno=0;
		
		do {
			error = false;
			System.out.println("Ingrese un la fecha en formato DD/MM/AAAA:");
			fecha = s.nextLine();	
			if(fecha.matches("[A-Za-z]*")) {
				error=true;
				System.out.println("|ERROR, Ingrese un número|");
			}
			
			if(!error) {
				posicion=fecha.indexOf("/");
				dia=fecha.substring(0,posicion);
				fecha=fecha.substring(posicion+1);
			
				posicion=fecha.indexOf("/");
				mes=fecha.substring(0,posicion);
				fecha=fecha.substring(posicion+1);
			
				ano=fecha;
			
				numDia=Integer.parseInt(dia);
				numMes=Integer.parseInt(mes);
				numAno=Integer.parseInt(ano);
			
				if(numDia>31 | numDia<1 | numMes>12 | numMes<1 | numAno<1) {
					error=true;
					System.out.println("|ERROR, Fecha incorrecta|");
				}
			}
			
		}while(error);
		if(numMes==1) {
			System.out.println(numDia+" de Enero del "+numAno);
		}
		if(numMes==2) {
			System.out.println(numDia+" de Febrero del "+numAno);
		}
		if(numMes==3) {
			System.out.println(numDia+" de Marzo del "+numAno);
		}
		if(numMes==4) {
			System.out.println(numDia+" de Abril del "+numAno);
		}
		if(numMes==5) {
			System.out.println(numDia+" de Mayo del "+numAno);
		}
		if(numMes==6) {
			System.out.println(numDia+" de Junio del "+numAno);
		}	
		if(numMes==7) {
			System.out.println(numDia+" de Julio del "+numAno);
		}
		if(numMes==8) {
			System.out.println(numDia+" de Agosto del "+numAno);
		}
		if(numMes==9) {
			System.out.println(numDia+" de Septiembre del "+numAno);
		}
		if(numMes==10) {
			System.out.println(numDia+" de Octubre del "+numAno);
		}
		if(numMes==11) {
			System.out.println(numDia+" de Noviembre del "+numAno);
		}
		if(numMes==12) {
			System.out.println(numDia+" de Diciembre del "+numAno);
		}	
		s.close();

	}

}
