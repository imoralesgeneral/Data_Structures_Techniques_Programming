package com.techniques.Backtracking;


import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class nQueens {

	int[] s;
	int n, k, indSol;

	public nQueens(int n) {
		this.n = n;
		indSol = 1;
		s = new int[n];
	}

	public String Queens(int j) {
		s[j] = 0;
		while (s[j] < n) {
			s[j] = s[j] + 1;
			if (Complet(s, j)) {
				if (j == n - 1) {
					 //System.out.println("--"+Arrays.toString(s));
					devSol(s);
				} else {
					Queens(j+1);
				}
			}
		}
		 //System.out.println("failed--"+Arrays.toString(s));
		return "FIN";
		// return Arrays.toString(s);
	}

	private boolean Complet(int[] s, int k) {
		for (int i = 0; i <= k - 1; i++) {
			if (s[i] == s[k] || (valAbs(s[i] - s[k]) == valAbs(i - k)))
				return false;
		}
		return true;
	}

	private void devSol(int[] s) {

		String sol = "";
		Set<String> lst;
		lst = new TreeSet<String>();
		for (int i = 0; i < s.length; i++) {
			String auxiliar = "";
			String caracter = ascii(s[i]);
			int numero = s.length - i;
			String num = Integer.toString(numero);
			auxiliar = caracter + num + " ";
			lst.add(auxiliar);
		}
		Iterator<String> itElements = lst.iterator(); // No se especifica tipo
														// de dato a recorrer
		while (itElements.hasNext()) { // Recorro cada elemento del ArrayList
										// con un iterador
			String a = itElements.next();
			sol = sol + a + " ";
		}
		if (sol.equals("")) {
			sol = "There is o sol";
		}
		System.out.println("Sol numb. " + indSol + ": ");
		System.out.println(sol);
		indSol++;
	}

	/**
	 * Este método devuelve el caracter ascii correspondiente.
	 * 
	 */
	private String ascii(int i) {
		int aux;
		int rest;
		int auxi;
		String dev = "";
		if (i < 27) {
			aux = i + 96;
			dev = "" + (char) aux;
		} else {
			rest = (i % 27) + 97;
			auxi = (i / 27) + 96;
			String aux1 = "" + (char) auxi;
			String aux2 = "" + (char) rest;
			String aux0 = "";
			for (int k = 0; k < auxi - 96; k++) {
				aux0 = aux0 + "" + (char) 127;
			}
			dev = aux0 + aux1 + aux2;
		}
		return dev;
	}

	/**
	 * Este método devuelve el valor absoluto.
	 * 
	 */
	private int valAbs(int n) {
		if (n < 0) {
			return n * -1;
		} else {
			return n;
		}
	}

}
