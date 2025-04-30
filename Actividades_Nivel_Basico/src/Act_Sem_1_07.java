import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_07 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error=false;
		int pesos=0;
		int cont=0;
		
		do {
			error=false;
			System.out.println("Ingrese la cantidad de pesos:");
			try {
				pesos = s.nextInt();
			}catch(InputMismatchException e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}catch(Exception e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}
		}while(error);
		
		
		if (pesos>=10000) {
			cont=pesos/10000;
			System.out.println("------------------------------");
			System.out.println(cont+" billetes de 10.000 pesos");
			pesos%=10000;
		}
		
		if(pesos>=2000){
			cont=pesos/2000;
			System.out.println("------------------------------");
			System.out.println(cont+" billetes de 2.000 pesos");
			pesos%=2000;
		}
		
		if(pesos>=1000){
			cont=pesos/1000;
			System.out.println("------------------------------");
			System.out.println(cont+" billetes de 1.000 pesos");
			pesos%=1000;
		}
		
		if(pesos>=500){
			cont=pesos/500;
			System.out.println("------------------------------");
			System.out.println(cont+" billetes de 500 pesos");
			pesos%=500;
		}
		
		if(pesos>=200){
			cont=pesos/200;
			System.out.println("------------------------------");
			System.out.println(cont+" billetes de 200 pesos");
			pesos%=200;
		}
		
		if(pesos>=100){
			cont=pesos/100;
			System.out.println("------------------------------");
			System.out.println(cont+" billetes de 100 pesos");
			pesos%=100;
		}
		
		if(pesos>=50){
			cont=pesos/50;
			System.out.println("------------------------------");
			System.out.println(cont+" billetes de 50 pesos");
			pesos%=50;
		}
		
		if(pesos>=20){
			cont=pesos/20;
			System.out.println("------------------------------");
			System.out.println(cont+" billetes de 20 pesos");
			pesos%=20;
		}
		
		if(pesos>=10){
			cont=pesos/10;
			System.out.println("------------------------------");
			System.out.println(cont+" monedas de 10 pesos");
			pesos%=10;
		}
		
		if(pesos>=5){
			cont=pesos/5;
			System.out.println("------------------------------");
			System.out.println(cont+" monedas de 5 pesos");
			pesos%=5;
		}
		
		if(pesos>=2){
			cont=pesos/2;
			System.out.println("------------------------------");
			System.out.println(cont+" monedas de 2 pesos");
			pesos%=2;
		}
		
		if(pesos>=1){
			System.out.println("------------------------------");
			System.out.println("1 moneda de 1 peso");
			pesos%=2;
		}
		s.close();
	}

}
