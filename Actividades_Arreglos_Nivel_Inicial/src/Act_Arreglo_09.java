
public class Act_Arreglo_09 {

	public static void main(String[] args) {
		int array[] = new int [26];
		int b=1, a=0, cont=0;
		
		for(int i = 1; i < 100;i++) {		
			
			a=1; 
			cont=0;
			while(a <= i) {
					
				if((i%a)==0) {		
					cont++;		
				}
				a++;
			}
			if(cont==2) {
				
				if(i>0) {
					array[b]=i;
					b++;
				}	
			}		
		}	
		cont=0;
			
		for(int i = 0; i < array.length;i++) {	
			if(i>0) {
				cont++;
				System.out.println("Índice "+cont+": "+array[i]);
			}		
		}

	}

}
