package practica1_JoseManuelGomez;

import java.util.Scanner;

/**
 * @author jose
 *
 */

public class FuncionC {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(System.in);
		int n = sc1.nextInt();
		
		if(n >= 0) {
			System.out.println(recursivaDirect(n));
		}
		
		//if(n >= 0) {
		//	System.out.println(CnCRD(n));
		//}
		
	}
	/**
	 * implementacion recursividad directa 
	 * @param n >= 0
	 * @return 	el calculo de la funcion c definida previamente
	 */
	
	public static double recursivaDirect(int n) {
		if(n==0) {
			return 1;
		}
		
		double sum = 0;
		for(int i = 0; i<n; i++) {
			sum += recursivaDirect(i);
		}
		return (2.0/n)*sum + n;
		}
	
	public static double CnCRD(int n) {
		if(n== 0) {
			return 1;
		}
		double sum = CnCRD_Aux(n-1, 1);
		
		return (2.0/n)*sum + n;
	}
	
	public static double CnCRD_Aux(int n, double ss) {
		if(n == 0) {
			return ss;
		}
		return CnCRD_Aux(n-1,ss +recursivaDirect(n));
		}

}

	

	