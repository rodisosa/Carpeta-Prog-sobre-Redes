
public class Act_Arreglo_06 {

	public static void main(String[] args) {
		int array[] = new int [20];
		int arrayCopia[] = new int [array.length];
		int cont=0, a=1, res=0;
		
		for(int i = 1; i < (array.length*2);i++) {		
			if((i%2)==0) {
				array[a]=i;
				a++;
			}
		}
		for(int i = 0; i < array.length;i++) {
			arrayCopia[i]=array[i];
		}
		for(int i = 0; i < array.length;i++) {
			cont++;
			System.out.println("Índice "+cont+": "+array[i]);
			System.out.println();
			System.out.print(res+" + "+arrayCopia[i]+" = ");
			res+=arrayCopia[i];
			System.out.print(res);
			System.out.println("");
			System.out.println("");
		}

	}

}
