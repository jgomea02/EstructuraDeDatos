package unileon.es.proii;

/**
 * Implementa en Java la solución al problema de las n reinas dado en los apuntes de clase.
 */
import java.util.ArrayList;

public class NReinasEsquema {

/**
 * almacena el tamaño del tablero. Eso determina el número de reinas a colocar.
 */
	int tam;
	private boolean result;
 
 NReinasEsquema(int n){
     tam = n;
    }
 
 /**
  * Devuelve verdadero si y sólo si hay conflicto por columna o por diagonal entre la reina colocada en la 
  * fila k de tab con cualquier otra reina colocada en las filas 0 a k-1.
  * 
  * Precondición: No hay conflicto ni por columna ni por diagonal en las posiciones 0 a k-1 entre sí.
  * 
  * @param tab la posición de las reinas en columnas hasta la fila k
  * @param k fila de la reina a evaluar con las reinas anteriores
  * @return true hay conflicto entre el valor tab[k] y cualquier tab[i] con i < k por fila o por diagonal, 
  * false si no lo hay.
  */
 public boolean hayConflicto (int[] tab,int k){
        for (int i = 0; i < k ; i++){
            if (tab[i] == tab[k] || Math.abs(tab[i]-tab[k]) == k-i)
                return true;
        }
        return false;            
     }
 
 /**
  * Resuelve el problema de las n reinas con tam=n. Puede encontrar la primera solución llamando a reinasVueltaAtras() o todas
  * llamando a reinasVueltaAtras_TodasLasSoluciones()
  * 
  * @param soluciones Almacena las soluciones encontradas.
  */
 public void reinas (ArrayList<int[]> soluciones){
     int[] solucion = new int[tam];
     for (int i=0; i<tam;i++)
         solucion[i] = -1;
     
     reinasVueltaAtras(solucion,0,soluciones, result);
     }
 /**
  * Añade a sols todas las soluciones encontradas al problema de las n-reinas a partir de la solución parcial dada en sol hasta la 
  * posición fila-1. 
  * 
  * Precondición: !hayConflcito(sol,i) para 0 <= i < fila y sol not nulo  y 0 <= fila < sol.length
  * 
  * @param sol solución parcial construida hasta el momento. 
  * @param fila fila que toca poner una nueva reina. Precondición: 0 <= fila < tam 
  * @param sols
  */
 private void reinasVueltaAtras_TodasLasSoluciones(int[] sol, int fila, ArrayList<int[]> sols){
     for (int i=0; i<tam; i++){
         sol[fila] = i;
         if (!hayConflicto(sol,fila))
             if (fila==tam-1){
                 int[] nuevaSol = new int[tam];
                 for (int j=0; j<tam;j++)
                     nuevaSol[j] = sol[j];
                 sols.add(nuevaSol);
             } else {
            	 reinasVueltaAtras_TodasLasSoluciones(sol,fila+1,sols);
             }
     }
 }
 
 /**
  * Devuelve true si encuentra una solución al problema de las n-reinas a partir de la solución parcial dada en sol hasta la 
  * posición fila-1.  La solución la añade a sols.
  * 
  * La implementación se realiza usando el parámetro de retorno del método.
  * Ejercicios: programar este mismo caso usando una variable booleana que sea un atributo de la clase, o usando un parámetro (debe ser 
  * un vector booleano)
  * 
  * Precondición: !hayConflcito(sol,i) para 0 <= i < fila y sol not nulo  y 0 <= fila < sol.length
  * 
  * @param sol solución parcial construida hasta el momento. 
  * @param fila fila que toca poner una nueva reina. Precondición: 0 <= fila < tam 
  * @param sols
  */
	private void reinasVueltaAtras(int[] sol, int fila, ArrayList<int[]> sols, boolean result) {
		for (int i = 0; i < tam && !result; i++) {
			sol[fila] = i;
			if (!hayConflicto(sol, fila))
				if (fila == tam - 1) {
					int[] nuevaSol = new int[tam];
					for (int j = 0; j < tam; j++)
						nuevaSol[j] = sol[j];
					sols.add(nuevaSol);
					result = true;
				} else {
					reinasVueltaAtras(sol, fila + 1, sols, result);
				}
		}
	}
 
 public static void main (String[] args){
     int n=4; //Probamos con 4 por defecto
     if (args.length > 0)
         n = Integer.parseInt(args[0]);
     
     NReinasEsquema nr = new NReinasEsquema(n);
     ArrayList<int[]> soluciones = new ArrayList<int[]>();
     
     nr.reinas(soluciones);
     System.out.print(nr.toStringSoluciones(soluciones));
 }

    public String toStringSoluciones(ArrayList<int[]> arrayList) {
        StringBuffer sal = new StringBuffer();
        for (int[] sol:arrayList){
            sal.append("(");
            for (int i=0; i<tam-1; i++){
                sal.append(sol[i]);
                sal.append(",");
            }
            sal.append(sol[tam-1]);
            sal.append(")\n");
        }
        return sal.toString();
    }
}