import java.io.*;
import java.util.*;
/**
 * Clase Main para la solucion del proyecto 4
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 * 
 * Proyecto 4
 * Prof Lab: Juan Arocha 
 *
 */
public class Main {

	/**
	 * @param args Comandos de entrada
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
				Pila<Nodo> pila;

				archivoOut = new FileWriter(args[1]);
				pw = new PrintWriter(archivoOut);

				archivoIn = new File(args[0]);
				s = new Scanner(archivoIn);
				int numCasos = s.nextInt();
				i = 0;
				while (i != numCasos) {
					if (s.hasNextInt())
						Columnas = s.nextInt();
					if (s.hasNextInt())
						Filas = s.nextInt();
					if(!(1<=Filas && Filas<=99 && 1<=Columnas && Columnas<=18278)){
						System.out.println("El archivo no respeta el formato indicado");
						System.exit(1);
					}

					grafo = Llenar(s, Filas, Columnas);

					Topologico topo = new Topologico(grafo);

					pila = topo.TopoSort();

					int matriz[][] = matriz(grafo, pila, Filas, Columnas);

					for (int f = 0; f != matriz.length; f++) {

						for (int c = 0; c != matriz[f].length; c++) {
							pw.print(matriz[f][c]);
							pw.print(" ");
						}
						pw.println();
					}
					i++;
				}
				s.close();
				archivoOut.close();
				pw.close();
			} else {
				System.out.println("Error en la linea de argumentos");
				System.exit(0);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error el archivo no existe");
		} catch (IOException e) {
			System.out.print("El archivo no existe pero no puede ser creado");
			System.out.println(" o no puede ser abierto por cualquier razon.");
		}
	}

	// funcion que llena la matriz
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
				if (s.hasNext())
					Arg = s.next();
				ID = new String(Array);
				ID = ID + "" + (j + 1);

				Procesar(G, ID, Arg);
				// System.out.println(new String(ID + "\t" + Arg));
			}// fin de for de i

		}// fin de for de j
		return G;

	}

	/**
	 * Toma el string Cont y descifra si es un numero o una formula
	 * 
	 * */
	private static void Procesar(Graph G, String Nombre, String Cont) {

		Nodo Nuevo = null;
		String[] Formula = null;
		String Aux = null;
		Nodo nodo;

		if (Cont.length() == 0)
			return;

		if (Cont.contains("=")) {

			Aux = Cont.substring(1);

			Formula = Aux.split("\\+");

			Nuevo = new Nodo(Nombre);

			G.add(Nuevo);

			for (int i = 0; i != Formula.length; i++) {
				G.add(new Nodo(Formula[i]));
				G.add(new Arco(Nombre, Formula[i]));
			}
			return;

		}

		nodo = G.get(new Nodo(Nombre));

		if (nodo != null) {

			if (nodo.getPeso() == Integer.MAX_VALUE) {
				nodo.setPeso(Integer.parseInt(Cont));

			}
			return;

		}

		Nuevo = new Nodo(Nombre, Integer.parseInt(Cont));

		G.add(Nuevo);

	}

	/**
	 * 
	 * Funcion que dado el el id del nodo, retorna la posicion que le
	 * corresponde en la matriz
	 * 
	 * */

	// Pos[0] son las columnas Pos[1] son las filas
	private static int[] PosicionMatriz(String Arg) {
		int[] Pos = new int[2];
		Pos[0] = -1;
		Pos[1] = -1;
		final char Const = 'A';
		// final char Const1 = '0';
		int j = -1;
		String Letras = "";
		String Numeros = "";

		//se busca la posicion donde aparece un numero por primera vez
		for (int i = 0; i != Arg.length(); i++) {
			int Num = Arg.charAt(i);
			if (!(65 <= Num && Num <= 90)) {
				j = i;
				break;
			}
		}

		//copio el substring de las letras
		Letras = Arg.substring(0, j);
		//copio el substring de los numeros
		Numeros = Arg.substring(j, Arg.length());

		char[] Aux = null;

		//evaluo en que caso estoy
		switch (Letras.length()) {
		case 1:
			Aux = Letras.toCharArray();
			Pos[0] = Aux[0] - Const;
			break;

		case 2:
			Aux = Letras.toCharArray();
			Pos[0] = (Aux[0] - Const) * 26 + (Aux[1] - Const) + 26;
			break;

		case 3:
			Aux = Letras.toCharArray();
			Pos[0] = (Aux[0] - Const) * 676 + (Aux[1] - Const) * 26
					+ (Aux[2] - Const) + 702;
			break;
		default:
			break;
		}

		//se le resta uno para que cuadre en la matriz
		Pos[1] = Integer.parseInt(Numeros) - 1;

		return Pos;

	}

	private static int[][] matriz(Graph grafo, Pila<Nodo> pila, int filas,
			int columnas) {
		int matriz[][] = new int[filas][columnas];

		while (!pila.esVacia()) {
			Nodo n = pila.primero();
			pila.desempilar();

			if (n.getPeso() == Integer.MAX_VALUE) {

				MiLista<Nodo> ady = (MiLista<Nodo>) grafo.getSuc(n);
				ListIterator<Nodo> it = ady.iterator();

				int j = 0;
				int peso = 0;
				while (j != ady.getSize()) {
					Nodo a = it.next();
					a = grafo.get(a);
					peso = peso + a.getPeso();
					j++;
				}
				n.setPeso(peso);
			}

			int pos[] = PosicionMatriz(n.toString());

			matriz[pos[1]][pos[0]] = n.getPeso();
		}

		return matriz;
	}

}// fin de clase Main

