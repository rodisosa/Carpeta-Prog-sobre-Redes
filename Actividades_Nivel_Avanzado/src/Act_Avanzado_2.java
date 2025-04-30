import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Avanzado_2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int clara=0, luisa=0, maria=0, nelida=0;
		boolean error=false, florista=false, directora=false, disen=false, jardinera=false;
		
		do {
			System.out.println("");
			System.out.println("INGRESE UN NÚMERO PARA CADA EMPLEO:");
			System.out.println("1-Florista");
			System.out.println("2-Directora de Orquesta");
			System.out.println("3-Diseñadora de Moda");
			System.out.println("4-Jardinera");
			System.out.println("");
		
			do {
				error=false;
				System.out.println("Oficio de Clara:");
				try {
					clara = s.nextInt();
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
					if(clara<0 || clara > 4) {
						error = true;
						System.out.println("|Error|, ingrese un número de las opciones");
						s.nextLine();		
				}}}while(error);
		
			do {
				error=false;
				System.out.println("Oficio de Luisa:");
				try {
					luisa = s.nextInt();
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
					if(luisa<0 || luisa > 4) {
						error = true;
						System.out.println("|Error|, ingrese un número de las opciones");
						s.nextLine();
					}
					if(clara==luisa) {
						error = true;
						System.out.println("|Error|, ese oficio ya está escojido");
						s.nextLine();
				}}}while(error);
		
			do {
				error=false;
				System.out.println("Oficio de María:");
				try {
					maria = s.nextInt();
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
					if(maria<0 || maria > 4) {
						error = true;
						System.out.println("|Error|, ingrese un número de las opciones");
						s.nextLine();
					}
					if(clara==maria || luisa==maria) {
						error = true;
						System.out.println("|Error|, ese oficio ya está escojido");
						s.nextLine();
				}}}while(error);
		
			do {
				error=false;
				System.out.println("Oficio de Nélida:");
				try {
					nelida = s.nextInt();
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
					if(nelida<0 || nelida > 4) {
						error = true;
						System.out.println("|Error|, ingrese un número de las opciones");
						s.nextLine();
					}
					if(clara==nelida || luisa==nelida || maria==nelida) {
						error = true;
						System.out.println("|Error|, ese oficio ya está escojido");
						s.nextLine();
				}}}while(error);
		
			disen = (clara==3) ? true : false;
			jardinera = (luisa==4) ? true : false;
			directora = (nelida==2) ? true : false;
			florista = (maria==1) ? true : false;
		
			error = (disen & jardinera & directora & florista) ? error==false : error==true;
		
			if(!error) { 
				System.out.println("");
				System.out.println("Los oficios no son los correctos"); 
				}
			
		}while(!error);
		
		System.out.println("Felicidades los oficios son los correctos");
		s.close();
	}

}
