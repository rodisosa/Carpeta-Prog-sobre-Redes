import java.util.Scanner;

public class Act_Sem_1_16 {

	public static void main(String[] args) {
		boolean error = false;
		Scanner s = new Scanner(System.in);
		String tiempo = null, hora, minuto, segundo;
		int posicion=0, numHora=0, numMin=0, numSeg=0;
		
		do {
			error = false;
			System.out.println("Ingrese un la hora en formato HH-MM-SS:");
			tiempo = s.nextLine();	
			if(tiempo.matches("[A-Za-z]*")) {
				error=true;
				System.out.println("|ERROR, Ingrese un número|");
			}
			
			if(!error) {
				posicion=tiempo.indexOf("-");
				hora=tiempo.substring(0,posicion);
				tiempo=tiempo.substring(posicion+1);
			
				posicion=tiempo.indexOf("-");
				minuto=tiempo.substring(0,posicion);
				tiempo=tiempo.substring(posicion+1);
			
				segundo=tiempo;
			
				numHora=Integer.parseInt(hora);
				numMin=Integer.parseInt(minuto);
				numSeg=Integer.parseInt(segundo);
			
				if(numHora>23 | numHora<0 | numMin>59 | numMin<0 | numSeg>59 | numSeg<0) {
					error=true;
					System.out.println("|ERROR, Hora incorrecta|");
				}
				
				numHora*=3600;
				numMin*=60;
				numSeg+=(numHora+numMin);
				System.out.println("El tiempo de "+hora+"-"+minuto+"-"+segundo+" serán: "+numSeg+" segundos");
			}
		}while(error);
		s.close();
		
	}

}
