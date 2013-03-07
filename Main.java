import java.io.*;
import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String args[]) {

		File archivoIn;
		FileWriter archivoOut;
		Graph grafo;
		Scanner s;
		PrintWriter pw;
		int i = 0;
		int Filas = -1;
		int Columnas = -1;

		try {
			if (args.length == 2) {
				archivoIn = new File(args[0]);
				s = new Scanner(archivoIn);
				int numCasos = s.nextInt();
				System.out.println(numCasos);
				i = 0;
				while (i != numCasos) {
					if (s.hasNextInt())
						Columnas = s.nextInt();
					if (s.hasNextInt())
						Filas = s.nextInt();

					System.out.println(Filas);
					System.out.println(Columnas);

					grafo = Llenar(s, Filas, Columnas);
					System.out.println(grafo.toString());
					System.out.println("\n\n\n\n");
					i++;
				}

			} else {
				System.out.println("Error en la linea de argumentos");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error el archivo no existe");
		} catch (IOException e) {
			System.out.print("El archivo no existe pero no puede ser creado");
			System.out.println(" o no puede ser abierto por cualquier razon.");
		}
	}

	private static Graph Llenar(Scanner s, int Fila, int Columna) {

		Graph G = null;
		
		G = new DiGraphHash();
		int N1 = 0;
		int N2 = 0;
		int N3 = 0;
		int N4 = 0;
		int N5 = 0;

		final String Tipo1 = "A";
		final String Tipo2 = "AA";
		final String Tipo3 = "AAA";

		String ID = "";
		String Arg = "";
		char[] Array;

		for (int j = 0; j >= 0 & j != Fila & Fila >= 0; j++) {

			for (int i = 0; i >= 0 & i != Columna & Columna >= 0; i++) {

				if (0 <= i && i < 26) {
					Array = Tipo1.toCharArray();
					Array[0] += i;

				} else if (26 <= i && i < 702) {

					if (N2 == 26) {
						N1++;
						N2 = 0;
					}
					Array = Tipo2.toCharArray();
					Array[0] += N1;
					Array[1] += N2;
					N2++;

				} else {

					if (N5 == 26) {
						N4++;
						N5 = 0;
						// Se pregunta si N2 Es igual a Z
						if (N4 == 26) {
							N3++;
							N4 = 0;
						}
					}
					Array = Tipo3.toCharArray();
					Array[0] += N3;
					Array[1] += N4;
					Array[2] += N5;
					N5++;
				}
				Arg = s.next();
				ID = new String(Array);
				ID = ID+""+(j+1);
				
				Procesar(G, ID, Arg);
				//System.out.println(new String(ID + "\t" + Arg));
			}// fin de for de i

		}// fin de for de j

		System.out.println();
		return G;

	}
	
	
	private static void Procesar(Graph G, String Nombre, String Cont){
		
		Nodo Nuevo=null;
		String[] Formula=null;
		String Aux=null;
		Nodo nodo;
		
		if(Cont.contains("=")){
			
			Aux = Cont.substring(1);
			
			Formula = Aux.split("\\+");
			
			G.add(new Nodo(Nombre));
			
			for(int i=0;i!=Formula.length;i++){
				G.add(new Nodo(Formula[i]));
				G.add(new Arco(Nombre,Formula[i]));
			}
			return;
			
		}
		
		nodo = G.get(new Nodo(Nombre));
		
		if (nodo!=null){
			
			if (nodo.getPeso()==Integer.MAX_VALUE){
				nodo.setPeso(Integer.parseInt(Cont));
			}
			return;
			
		}
		
		
		Nuevo = new Nodo(Nombre,Integer.parseInt(Cont));
		
		G.add(Nuevo);
		
		
		
	} 

}// fin de clase Main

