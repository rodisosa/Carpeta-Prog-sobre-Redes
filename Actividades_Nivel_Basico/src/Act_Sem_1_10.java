import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_10 {

	public static void main(String[] args) {
		Scanner s = new Scanner( System.in );
		int prestamo = 0;
		int porcentaje = 0;
		int pago = 0;
		int cal=0, anos=0, total=0;
		boolean error = false;
		
		do {
			error=false;
			System.out.println("Ingrese el préstamo:");
			try {
				prestamo = s.nextInt();
			}catch(InputMismatchException e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}catch(Exception e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}
			if(!error) {
				if(prestamo<0) {
					error = true;
					System.out.println("|Error|, ingrese un número positivo");
					s.nextLine();
		}}}while(error);
		
		do {
			error=false;
			System.out.println("Ingrese el porcentaje de interés anual:");
			try {
				porcentaje = s.nextInt();
			}catch(InputMismatchException e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}catch(Exception e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}
			if(!error) {
				if(porcentaje<0) {
					error = true;
					System.out.println("|Error|, ingrese un número positivo");
					s.nextLine();
				}else if(porcentaje>100){
					error = true;
					System.out.println("|Error|, ingrese un número menor que 101");
					s.nextLine();
			}}}while(error);
		
		do {
			error=false;
			System.out.println("Ingrese la cantidad que quiere pagar por mes:");
			try {
				pago = s.nextInt();
			}catch(InputMismatchException e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}catch(Exception e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}
			if(!error) {
				if(pago<0) {
					error = true;
					System.out.println("|Error|, ingrese un número positivo");
					s.nextLine();
		}}}while(error);
		
		cal = prestamo * (porcentaje / 100);
		total= prestamo + cal;
		
		total/=pago;
		
		if(total>=12) {
			anos= total / 12;
			System.out.println("tardará "+anos+" años");
			total%=12;
		}
		if(total<12) {
			System.out.println("tardará "+total+" meses");
		}
		s.close();
	}

}
