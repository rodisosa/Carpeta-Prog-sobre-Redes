
public class Act_Avanzado_5 {

public static void main(String[] args) {
		
		
		
		/*
		  
		 2 << -2 =  -2147483648 
		  
		 Esto sucede por como funciona java, al tener un número negativo, transforma
		 temporalmente el atributo byte (8 bits) a int (32 bits), generando que cambie el resultado:
		 
		 2 en int es = 00100000.00000000.00000000.00000000
		 
		 Al desplazar los 2 bits lo que sucede es que 2 pasa a ser -2147483648:
		  
		 -2147483648 en int es = 10000000.00000000.0000000.00000000
		 
		 Algo similar pasa con (12 << -2=0), sucede porque 12 es llevado a int como el otro desplazamiento:
		 
		 12 en int es = 11000000.00000000.00000000.00000000
		 
		 Y cuando es desplazado sucede que los dos bits "borran" a los dos unos:
		 
		 0 en int es = 00000000.00000000.00000000.00000000
		  
		 */
		
	}

}
