
public class Act_Sem_1_05 {

	public static void main(String[] args) {
		int numUno=1;
		int f=0;
		int numDos=0;
		
		for(int i=0;i<20;i++) {
			
			numDos=f;
			f+=numUno;
			numUno=numDos;
			System.out.print(" |"+numUno+"| ");
		}
	}

}
