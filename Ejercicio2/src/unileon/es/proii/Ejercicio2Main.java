package unileon.es.proii;

/*import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> entrada = new ArrayList<String>();
		ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) { //hay que parar la ejecución con ctrl+d y se inserta la entrada en bloque!!!!
			String linea = sc.nextLine().trim();  
			entrada.add(linea);
		}
		sc.close();//termina de leer la entrada
		
		lista = dividir(lista, entrada);
		
		
		for(int i = 0; i < lista.size();i++){
			System.out.println("Problema nº " + (i+1));
			System.out.println();
			contar(lista.get(i));
			if(i < lista.size()-1) {
				System.out.println();
				System.out.println("******************************");
				System.out.println();
			}
		}
	}

	private static void contar(ArrayList<String> cuadrado) {
		// TODO Auto-generated method stub
		int dimensionCuadrado = Integer.parseInt(cuadrado.get(0));
		int soluciones[] = new int[dimensionCuadrado-1];
		
		for(int i = 0; i < soluciones.length; i++) {
			soluciones[i] = solucionar(cuadrado, (i+1), 1, 1, dimensionCuadrado);    
		}
		int solucionesEncontradas = 0;
		for(int i = 0; i < soluciones.length; i++) {
			if(soluciones[i] != 0) {
				System.out.println(soluciones[i]+ " cuadrado(s) de tamaño " + (i+1));
				solucionesEncontradas++;
			}
		}
		
		if(solucionesEncontradas == 0) {
			System.out.println("No se ha encontrado ningun cuadrado completo");
		}
		
	}

	private static int solucionar(ArrayList<String> cuadrado, int dimension, int fila, int col, int dimensionCuadrado) {
		// TODO Auto-generated method stub
		int contador = 0;
		while(fila <= dimensionCuadrado && col <= dimensionCuadrado) {
			//busco cuadrados segun la dimension
			
			if(comprueboFilaSuperior(cuadrado, fila, col, dimension)) {
				if(comprueboFilaInferior(cuadrado, fila + dimension, col, dimension)) {
					if(comprueboColIzq(cuadrado, fila, col, dimension)) {
						if(comprueboColDrch(cuadrado, fila, col + dimension, dimension)) {
							contador++;
						}
					}
				}
			}
			fila++;
			if(fila ==dimensionCuadrado) { //estoy en la utima fila
				fila = 1;
				col++;  
			}
		}
		return contador;
	}

	private static boolean comprueboColDrch(ArrayList<String> cuadrado, int fila, int col, int dimension) {
		// TODO Auto-generated method stub
		for(int i = 0; i < dimension; i++) {
			String creoPunto = "V " + (col) + " " + (fila + i);
			if(!cuadrado.contains(creoPunto)) {
			return false;
			}
		}
		return true;
	}

	private static boolean comprueboColIzq(ArrayList<String> cuadrado, int fila, int col, int dimension) {
		// TODO Auto-generated method stub
		for(int i = 0; i < dimension; i++) {
			String creoPunto = "V " + (col) + " " + (fila + i);  
			if(!cuadrado.contains(creoPunto)) {
			return false;
			}
		}
		return true;
	}

	private static boolean comprueboFilaInferior(ArrayList<String> cuadrado, int fila, int col, int dimension) {
		// TODO Auto-generated method stub
		for(int i = 0; i < dimension; i++) {
			String creoPunto = "H " + (fila) +" " + (col + i);
			if(!cuadrado.contains(creoPunto)) {      
			return false;
			}
		}
		return true;
	}

	private static boolean comprueboFilaSuperior(ArrayList<String> cuadrado, int fila, int col, int dimension) {
		// TODO Auto-generated method stub
		for(int i = 0; i < dimension; i++) {
			String creoPunto = "H " + (fila) +" " + (col + i);
			if(!cuadrado.contains(creoPunto)) {
			return false;
			}
		}
		return true;
	}

	private static ArrayList<ArrayList<String>> dividir(ArrayList<ArrayList<String>> lista,
			ArrayList<String> entrada) {
		// TODO Auto-generated method stub
		while(entrada.size() > 0) { //mientras tenga lineas
			ArrayList<String> cuadrado = new ArrayList<String>(); 
			
			cuadrado.add(entrada.get(0));
			entrada.remove(0);
			
			String aristas = entrada.get(0);
			cuadrado.add(aristas);
			entrada.remove(0);
			
			int numAristas = Integer.parseInt(aristas);
			for(int i = 0; i < numAristas; i++) {
				cuadrado.add(entrada.get(0));  
				entrada.remove(0);
			}
			lista.add(cuadrado);
		}
		return lista;
	}

}*/
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> entrada = new ArrayList<String>();
		ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) { //hay que parar la ejecucion con ctrl+d y se inserta la entrada en bloque!!!!
			String linea = sc.nextLine().trim();  
			entrada.add(linea);
		}
		sc.close();//termina de leer la entrada
		
		lista = dividir(lista, entrada);
		
		
		imprimirRdo(lista);
	}

	private static void imprimirRdo(ArrayList<ArrayList<String>> lista) {
		for(int i = 0; i < lista.size();i++){
			System.out.println("Problema nº " + (i+1)); 
			System.out.println();
			contar(lista.get(i));
			imprimoAsteriscos(lista, i);
		}
	}

	private static void imprimoAsteriscos(ArrayList<ArrayList<String>> lista, int i) {
		if(i < lista.size()-1) {
			System.out.println();
			System.out.println("******************************");
			System.out.println();
		}
	}

	private static void contar(ArrayList<String> cuadrado) {
		// TODO Auto-generated method stub
		int dimensionCuadrado = Integer.parseInt(cuadrado.get(0));
		int soluciones[] = new int[dimensionCuadrado-1];
		
		for(int i = 0; i < soluciones.length; i++) {
			soluciones[i] = solucionar(cuadrado, (i+1), 1, 1, dimensionCuadrado);    
		}
		int solucionesEncontradas = 0;
		for(int i = 0; i < soluciones.length; i++) {
			if(soluciones[i] != 0) {
				System.out.println(soluciones[i]+ " cuadrado(s) de tamaño " + (i+1));
				solucionesEncontradas++;
			}
		}
		
		noHayCuadrados(solucionesEncontradas);
		
	}

	private static void noHayCuadrados(int solucionesEncontradas) {
		if(solucionesEncontradas == 0) {
			System.out.println("No se ha encontrado ningun cuadrado completo");
		}
	}

	private static int solucionar(ArrayList<String> cuadrado, int dimension, int fila, int col, int dimensionCuadrado) {
		// TODO Auto-generated method stub
		int contador = 0;
		while(fila <= dimensionCuadrado && col <= dimensionCuadrado) {
			//busco cuadrados segun la dimension
			
			if(comprueboFilaSuperior(cuadrado, fila, col, dimension)) {
				if(comprueboFilaInferior(cuadrado, fila + dimension, col, dimension)) {
					if(comprueboColIzq(cuadrado, fila, col, dimension)) {
						if(comprueboColDrch(cuadrado, fila, col + dimension, dimension)) {
							contador++;
						}
					}
				}
			}
			fila++;
			if(fila ==dimensionCuadrado) { //estoy en la utima fila
				fila = 1;
				col++;  
			}
		}
		return contador;
	}

	private static boolean comprueboColDrch(ArrayList<String> cuadrado, int fila, int col, int dimension) {
		// TODO Auto-generated method stub
		int i=0;
		while(i<dimension) {
		//for(int i = 0; i < dimension; i++) {
			String creoPunto = "V " + (col) + " " + (fila + i);
			if(!cuadrado.contains(creoPunto)) {
				return false;
			}
			i++;
		}
		return true;
	}

	private static boolean comprueboColIzq(ArrayList<String> cuadrado, int fila, int col, int dimension) {
		// TODO Auto-generated method stub
		int i=0;
		//for(int i = 0; i < dimension; i++) {
		while(i<dimension) {
			String creoPunto = "V " + (col) + " " + (fila + i);  
			if(!cuadrado.contains(creoPunto)) { 
				return false;
			}
			i++; 
		}
		return true;
	}

	private static boolean comprueboFilaInferior(ArrayList<String> cuadrado, int fila, int col, int dimension) {
		// TODO Auto-generated method stub
		for(int i = 0; i < dimension; i++) {
			String creoPunto = "H " + (fila) +" " + (col + i);
			if(!cuadrado.contains(creoPunto)) {      
			return false;
			}
		}
		return true;
	}

	private static boolean comprueboFilaSuperior(ArrayList<String> cuadrado, int fila, int col, int dimension) {
		// TODO Auto-generated method stub
		for(int i = 0; i < dimension; i++) {
			String creoPunto = "H " + (fila) +" " + (col + i);
			if(!cuadrado.contains(creoPunto)) {
			return false;
			}
		}
		return true;
	}

	private static ArrayList<ArrayList<String>> dividir(ArrayList<ArrayList<String>> lista,
			ArrayList<String> entrada) {
		// TODO Auto-generated method stub
		while(entrada.size() > 0) { //mientras tenga lineas
			ArrayList<String> cuadrado = new ArrayList<String>(); 
			
			cuadrado.add(entrada.get(0));
			entrada.remove(0);
			
			String aristas = entrada.get(0);
			cuadrado.add(aristas);
			entrada.remove(0);
			
			int numAristas = Integer.parseInt(aristas);
			for(int i = 0; i < numAristas; i++) {
				cuadrado.add(entrada.get(0));  
				entrada.remove(0);
			}
			lista.add(cuadrado);
		}
		return lista;
	}

}    

/*
 4
16
H 1 1
H 1 3
H 2 1
H 2 2
H 2 3
H 3 2
H 4 2
H 4 3
V 1 1
V 2 1
V 2 2
V 2 3
V 3 2
V 4 1
V 4 2
V 4 3
2
3
H 1 1
H 2 1
V 2 1
 */


