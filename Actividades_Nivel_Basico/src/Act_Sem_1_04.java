
public class Act_Sem_1_04 {

	public static void main(String[] args) {
		int inicio=33;
		int limite=126;
		
		for(int z=0;z<7;z++) {
			
			System.out.println("");

			for(int j=0;j<15;j++) {
				
				char c = (char)inicio;
	            System.out.print(" "+c+" ");
	            inicio++;
	            if(inicio>limite) {
	            	break;	
	            }
			}
		}
	}

}
