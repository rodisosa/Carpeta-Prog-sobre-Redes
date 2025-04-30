import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Avanzado_4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error = false;
		String exp="", num="";
		int posicion=0, men=0, res=0, cont=0, raiz=0;
		double resultado = 0;
		
		
		do {
			
			System.out.println("");
			System.out.println("1- Suma");
			System.out.println("2- Resta");
			System.out.println("3- Multiplicación");
			System.out.println("4- Divición");
			System.out.println("5- Potenciación");
			System.out.println("6- Radiación");
			System.out.println("7- Salir");
			System.out.println("");
			
			do {
				error=false;
				System.out.println("Ingrese un número:");
				try {
					men = s.nextInt();
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
			
			s.nextLine();
			System.out.println("----------------------------------");
			System.out.println("");
			
			switch(men) {
				case 1: 
					
					do {
						error=false;
						System.out.println("Ingrese una suma:");
						try {
							exp = s.nextLine();
						}catch (StringIndexOutOfBoundsException e) {
						error=true;
						System.out.println("|ERROR|");
						s.nextLine();	
						}
						
						for(int i=0; i<exp.length();i++) {
							if(exp.charAt(i) == '+') {                                    
								cont++;
							}
						}
						res=0;
						if(!error) {
							
							for(int i=0; i<cont; i++) {
								
								posicion=exp.indexOf("+");
								num=exp.substring(0,posicion);
								try {
									res += Integer.parseInt(num);
								}catch(InputMismatchException e) {
									error = true;
									System.out.println("|Error|, no ingresó un número entero");
									s.nextLine();
								}catch(Exception e) {
									error = true;
									System.out.println("|Error|, no ingresó un número entero");
									s.nextLine();
								}
								exp=exp.substring(posicion+1);	
								
							}
								
							try {
								res += Integer.parseInt(exp);
							}catch(InputMismatchException e) {
								error = true;
								System.out.println("|Error|, no ingresó un número entero");
								s.nextLine();
							}catch(Exception e) {
								error = true;
								System.out.println("|Error|, no ingresó un número entero");
								s.nextLine();
							}
						}
					}while(error);
					System.out.println("La suma da: "+res);	
					cont=0;
					break;
					
				case 2: 
					
					do {
						error=false;
						System.out.println("Ingrese una resta:");
						try {
							exp = s.nextLine();
						}catch (StringIndexOutOfBoundsException e) {
						error=true;
						System.out.println("|ERROR|");
						s.nextLine();	
						}
						
						for(int i=0; i<exp.length();i++) {
							if(exp.charAt(i) == '-' && i==0) {                                    
								cont=0;
							}else if (exp.charAt(i) == '-' && i>0){
								cont++;
							}
						}
						
						if(!error) {
							
							for(int i=0; i<cont; i++) {
								
								
								
								if(i==0 && exp.charAt(i) == '-') {
									
									
									exp=exp.substring(0+1);
									posicion=exp.indexOf("-");
									num=exp.substring(0,posicion);
									
									
									try {
										res = -(Integer.parseInt(num));
									}catch(InputMismatchException e) {
										error = true;
										System.out.println("|Error|, no ingresó un número entero");
										s.nextLine();
									}catch(Exception e) {
										error = true;
										System.out.println("|Error|, no ingresó un número entero");
										s.nextLine();
									}
									exp=exp.substring(posicion+1);
								
								} else {
									
									posicion=exp.indexOf("-");
									num=exp.substring(0,posicion);
									if(i==0) {
										
										try {
											res = Integer.parseInt(num);
										}catch(InputMismatchException e) {
											error = true;
											System.out.println("|Error|, no ingresó un número entero");
											s.nextLine();
										}catch(Exception e) {
											error = true;
											System.out.println("|Error|, no ingresó un número entero");
											s.nextLine();
										}
									} else {
										try {
											res -= Integer.parseInt(num);
										}catch(InputMismatchException e) {
											error = true;
											System.out.println("|Error|, no ingresó un número negativo");
											s.nextLine();
										}catch(Exception e) {
											error = true;
											System.out.println("|Error|, no ingresó un número negativo");
											s.nextLine();
										}
									}
									exp=exp.substring(posicion+1);
								}
							}
								
							try {
								res -= Integer.parseInt(exp);
							}catch(InputMismatchException e) {
								error = true;
								System.out.println("|Error|, no ingresó un número negativo");
								s.nextLine();
							}catch(Exception e) {
								error = true;
								System.out.println("|Error|, no ingresó un número negativo");
								s.nextLine();
							}
						}
					}while(error);
					System.out.println("La resta da: "+res);
					cont=0;
					break;
					
				case 3: 
					
					do {
						error=false;
						System.out.println("Ingrese una multiplicación:");
						try {
							exp = s.nextLine();
						}catch (StringIndexOutOfBoundsException e) {
						error=true;
						System.out.println("|ERROR|");
						s.nextLine();	
						}
						
						for(int i=0; i<exp.length();i++) {
							if(exp.charAt(i) == '*') {                                    
								cont++;
							}
						}
						
						if(!error) {
							
							for(int i=0; i<cont; i++) {
								
								posicion=exp.indexOf("*");
								num=exp.substring(0,posicion);
								try {
									if(i==0) {
										res = Integer.parseInt(num);
									} else {
										res *= Integer.parseInt(num);
									}
								}catch(InputMismatchException e) {
									error = true;
									System.out.println("|Error|, no ingresó un número entero");
									s.nextLine();
								}catch(Exception e) {
									error = true;
									System.out.println("|Error|, no ingresó un número entero");
									s.nextLine();
								}
								exp=exp.substring(posicion+1);									
							}
								
							try {
								res *= Integer.parseInt(exp);
							}catch(InputMismatchException e) {
								error = true;
								System.out.println("|Error|, no ingresó un número entero");
								s.nextLine();
							}catch(Exception e) {
								error = true;
								System.out.println("|Error|, no ingresó un número entero");
								s.nextLine();
							}
						}
					}while(error);
					System.out.println("La multiplicación da: "+res);	
					cont=0;
					
					break;
					
				case 4: 
					
					do {
						error=false;
						System.out.println("Ingrese una división:");
						try {
							exp = s.nextLine();
						}catch (StringIndexOutOfBoundsException e) {
						error=true;
						System.out.println("|ERROR|");
						s.nextLine();	
						}

						for(int i=0; i<exp.length();i++) {
							if(exp.charAt(i) == '/') {                                    
								cont++;
							}
						}
						
						if(exp.charAt(0) == '0') {
							error=true;
							System.out.println("|ERROR|, no se puede dividir por cero");
							s.nextLine();
						}
						
						if(!error) {
							
							for(int i=0; i<cont; i++) {
								
								posicion=exp.indexOf("/");
								num=exp.substring(0,posicion);
								try {
									if(i==0) {
										res = Integer.parseInt(num);
									} else {
										res /= Integer.parseInt(num);
									}
								}catch(InputMismatchException e) {
									error = true;
									System.out.println("|Error|, no ingresó un número entero");
									s.nextLine();
								}catch(Exception e) {
									error = true;
									System.out.println("|Error|, no ingresó un número entero");
									s.nextLine();
								}
								exp=exp.substring(posicion+1);									
							}
								
							try {
								res /= Integer.parseInt(exp);
							}catch(InputMismatchException e) {
								error = true;
								System.out.println("|Error|, no ingresó un número entero");
								s.nextLine();
							}catch(Exception e) {
								error = true;
								System.out.println("|Error|, no ingresó un número entero");
								s.nextLine();
							}
						}
					}while(error);
					System.out.println("La división da: "+res);	
					cont=0;
					
					break;
					
					
				case 5:
					
					do {
						error=false;
						System.out.println("Ingrese una potenciación ^ :");
						try {
							exp = s.nextLine();
						}catch (StringIndexOutOfBoundsException e) {
						error=true;
						System.out.println("|ERROR|");
						s.nextLine();	
						}

						for(int i=0; i<exp.length();i++) {
							if(exp.charAt(i) == '^') {                                    
								cont++;
							}
						}
						
						if(!error) {
							
							for(int i=0; i<cont; i++) {
								
								posicion=exp.indexOf("^");
								num=exp.substring(0,posicion);
								try {
									if(i==0) {
										res = Integer.parseInt(num);
									} else {
										res = (int) Math.pow( res,Integer.parseInt(num));
									}
								}catch(InputMismatchException e) {
									error = true;
									System.out.println("|Error|, no ingresó un número entero");
									s.nextLine();
								}catch(Exception e) {
									error = true;
									System.out.println("|Error|, no ingresó un número entero");
									s.nextLine();
								}
								exp=exp.substring(posicion+1);									
							}
								
							try {
								res = (int) Math.pow( res,Integer.parseInt(exp));
							}catch(InputMismatchException e) {
								error = true;
								System.out.println("|Error|, no ingresó un número entero");
								s.nextLine();
							}catch(Exception e) {
								error = true;
								System.out.println("|Error|, no ingresó un número entero");
								s.nextLine();
							}
						}
					}while(error);
					System.out.println("La potenciación da: "+res);	
					cont=0;
					break;
					
				case 6:
					
					do {
						error=false;
						System.out.println("Ingrese una raiz 2√ o 3√:");
						try {
							exp = s.nextLine();
						}catch (StringIndexOutOfBoundsException e) {
						error=true;
						System.out.println("|ERROR|");
						s.nextLine();	
						}
						
						if(exp.charAt(0) == '2' || exp.charAt(0) == '3') {
							error=false;
						} else {
							error=true;
							System.out.println("|ERROR|, no ingresó una raiz 2√ o 3√");
							s.nextLine();
						}
						
						if(!error) {
							
							posicion=exp.indexOf("√");
							
							
							try {
								if(exp.charAt(0) == '2') {
										
									raiz = 2;
									
								} else  if (exp.charAt(0) == '3'){	
									
									raiz = 3;
								} 
								
							}catch(InputMismatchException e) {
								error = true;
								System.out.println("|Error|, no ingresó un número entero");
								s.nextLine();
							}catch(Exception e) {
								error = true;
								System.out.println("|Error|, no ingresó un número entero");
								s.nextLine();
							}
							
							exp=exp.substring(posicion+1);
							
							
							
							if(exp.charAt(0) == '-') {
								error=true;
								System.out.println("|ERROR|, no se puede hacer la raíz de un número negativo");
								s.nextLine();
							}
							
							if(!error) {
								try {
										res = Integer.parseInt(exp);	
									
								}catch(InputMismatchException e) {
									error = true;
									System.out.println("|Error|, no ingresó un número entero");
									s.nextLine();
								}catch(Exception e) {
									error = true;
									System.out.println("|Error|, no ingresó un número entero");
									s.nextLine();
								}
							}
							resultado = (raiz==2) ? Math.sqrt(res) : Math.cbrt(res);
						}
					}while(error);
					System.out.println("La raiz da: "+ resultado);	
					cont=0;
					break;
					
				case 7:	
					error=true;
					System.out.println("Saliendo...");
					break;
					
				default:
					System.out.println("Ingrese un número entre los disponibles");
					break;
				}
			
		}while(!error);
		
		s.close();
	}

}
