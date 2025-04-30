
public class Act_Arreglo_03 {

	public static void main(String[] args) {
		int array[] = new int [51];
		int cont=0;
		int a=1;
		
		for(int i = 1; i < (array.length*2);i++) {		
			if((i%2)==0) {
				array[a]=i;
				a++;
			}
		}
		
		for(int i = 0; i < array.length;i++) {
			cont++;
			System.out.println("Índice "+cont+": "+array[i]);
		}

	}

}
