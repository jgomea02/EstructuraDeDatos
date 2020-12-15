package recursion;

import java.util.Scanner;

/* Resuelve un Sudoku dado por la entrada estándar en forma de matriz de 9x9 posiciones de 0 a 9.
 * El cero representa la posición vacía
 * 
 * Prec: El sudoku introducido es consistente y no está resuelto completamente.
 */
public class Sudoku {
	public static final int NFILAS = 3 ; //Tamaño bloque
	public static final int NCOLS = 3 ;
	public static final int TAMSUDOKU=NFILAS*NCOLS; 
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			int[][] sudoku = new int[TAMSUDOKU][TAMSUDOKU];
			
			// Inicializo el sudoku
			for (int i=0; i < TAMSUDOKU; i++)
				for (int j=0; j < TAMSUDOKU; j++)
					sudoku[i][j] = sc.nextInt();
				
			sc.close();
			
			boolean[] esFinal = { false };
			
			// validamos el sudoku antes de resolverlo porque ResuelveSudoku requiere
			// un sudoku consistente
			for (int i=0; i < TAMSUDOKU; i++)
				for (int j=0; j < TAMSUDOKU; j++)
					if (sudoku[i][j] != 0 && !spSudoku(i, j, sudoku)){
					    System.out.println("Sudoku sin solución.");
					    return;
					}
			
			if (ResuelveSudoku(0, 0, sudoku, esFinal)){
				System.out.println(toString(sudoku));
			} else
				System.out.println("Sudoku sin solución");
		
			sc.close();
	}

	/**
	 * Convierte un sudoku a una cadena, para darlo por la salida estándar.
	 * Sigue el convenio de denominar toString a este método (ver class Object)
	 * @param sudoku
	 * @return
	 */
	public static String toString(int[][] sudoku) {
		StringBuffer result = new StringBuffer((2*sudoku[0].length+1)*sudoku.length+1);
		for (int i=0; i<sudoku.length; i++){
			for (int j=0; j<sudoku[0].length; j++)
				result.append(""+sudoku[i][j]+" ");
		    result.append('\n');
		}
		return result.toString();
	}

/**
 * Resuelve un sudoku comenzando a rellenar en la casilla fila x col . Sigue un diseño por backtraking 
 * 
 * @param fila: la fila de la casilla que toca resolver. 0 <= fila < TAMSUDOKU 
 * @param col:  la columna  de la casilla que toca resolver.  0 <= col < TAMSUDOKU
 * @param sudoku: el sudoku a resolver. sudoku es consistente
 * @param esFinal: si ya he encontrado una solución a sudoku. esFinal[0] == esSolucionFinal(sudoku). Observar que
 * se requiere el array para poder cambiar el valor de la variable booleana.
 * @return  devuelve true si y sólo si se encuentra una solución para sudoku a partir de la posición (fila,col)
 */
	public static boolean ResuelveSudoku(int fila, int col, int[][] sudoku,
			boolean[] esFinal) { 
		int ncol=col; int nfila=fila;
		
		if (sudoku[fila][col] != 0){
				if (fila == TAMSUDOKU-1 && col == TAMSUDOKU-1){
					esFinal[0] = true;
					return true;
				} 
				if (col == TAMSUDOKU-1){
					ncol = 0;
					nfila = nfila+1;
				} else
					ncol=ncol+1;
				return ResuelveSudoku(nfila,ncol, sudoku,esFinal);
			} else {
				for (int i=1; i <= 9 && !esFinal[0]; i++){
					sudoku[fila][col] = i;
					if (spSudoku(fila, col, sudoku)) {
						if (fila == TAMSUDOKU-1 && col == TAMSUDOKU-1){
							esFinal[0] = true;
							return true;
						}
						if (col == TAMSUDOKU-1){
							ncol = 0;
							nfila=fila+1;
						} else
							ncol=col+1;
						if (ResuelveSudoku(nfila,ncol, sudoku,esFinal)){
							esFinal[0] = true;
							return true;
						}	
					}
				}
				sudoku[fila][col] = 0;
			}
		
		return false;
	}

	/** Método que indica si un sudoku es consistente (no tiene conflicto) en una casilla dada. El sudoku
	 * debe ser consistente en todas las casillas exceptuando la que queremos comprobar.
	 * 
	 * Precondición: sudoku consistente salvo quizá en sudoku[fila][col] y sudoku[fila][col] != 0
	 * 
	 * @param fila. fila de la casilla donde puede haber una inconsistencia. 0 <= fila < NFILAS*NCOLS 
	 * @param col. columna de la casilla donde puede haber una inconsistencia.  0 <= col < NFILAS*NCOLS
	 * @param sudoku. es consistente sin considerar la casilla (fila, col). sudoku[fila][col] != 0
	 * @return true si y sólo si sudoku es consistente
	 */
public static boolean spSudoku(int fila, int col, int[][] sudoku) {
	
	// Conflicto por fila o columna
	for (int i=0; i<TAMSUDOKU;i++){
		if(sudoku[fila][i] == sudoku[fila][col] && i != col )
			return false;
		if(sudoku[i][col] == sudoku[fila][col] && i != fila )
			return false;
	}

	// Conflicto por bloque
	int fb = fila / NFILAS;
	int cb = col / NCOLS;
	for (int i=0; i < NFILAS; i++)
		for (int j=0; j<NCOLS; j++){
			int f = NFILAS*fb + i;
			int c = NCOLS*cb + j;
			if(sudoku[f][c] == sudoku[fila][col] && f != fila && c != col )
				return false;
		}

	return true;
}
	


}
