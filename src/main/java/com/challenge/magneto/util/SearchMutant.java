package com.challenge.magneto.util;

// Java program to search
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchMutant {

	private static final Logger logger = LogManager.getLogger(SearchMutant.class);
	final String[] patterns = { "AAAA", "CCCC", "GGGG", "TTTT" };
	static HashMap<String, ArrayList<Integer>> hm;
	static char[][] sequenceAdn;

	/**
	 * Metodo para busqueda de mutantes con los patrones identificados
	 * 
	 * @param dna del humano a analizar
	 */
	public boolean isMutant(String[] dna) {
		logger.debug("check isMutant");
		int n = dna.length + 1; // NXN
		sequenceAdn = new char[n][n];
		// Creando estructura de ADN para procesar matriz char[][]
		int rows = -1;
		for (String record : dna) {
			sequenceAdn[rows = rows + 1] = record.toCharArray();
		}
		logger.debug("sequenceAdn" + sequenceAdn);
		// Recorrer estructura por cada una las secuencias a analizar
		int count = 0;
		for (String pattern : patterns) {
			hm = new HashMap<String, ArrayList<Integer>>();
			// Recorrido de estructura DNA
			for (int row = 0; row < dna.length; row++) {
				for (int col = 0; col < dna.length; col++) {
					// Analisis de patrones iniciando con cada caracter disponible
					if (analyzePattern(row, col, pattern, dna.length)) {
						if (count >= 1) {
							return true;
						}
						count = count + 1;
					}
				}
			}
		}
		return false;
	}

	public boolean analyzePattern(int row, int column, String pattern, int lenghtDna) {
		logger.debug("sequenceAdn" + sequenceAdn);
		logger.debug("analyzePattern" + pattern);
		// Solo busqueda si la letra inicia con la base nitrogenada
		if (sequenceAdn[row][column] != pattern.charAt(0))
			return false;
		int[] axisX = { -1, -1, -1, 0, 0, 1, 1, 1 }; // direcciones eje x
		int[] axisY = { -1, 0, 1, -1, 1, -1, 0, 1 }; // direcciones eje y
		int length = pattern.length();
		// busqueda por cada direccion (corresponde a busqueda eje x, eje y)
		for (int direction = 0; direction < 8; direction++) {
			// Validación para evitar busqueda de patrones encontrados
			if (hm.get(row + "," + column) == null
					|| (hm.get(row + "," + column) != null && !hm.get(row + "," + column).contains(direction))) {
				int matches, moveX = row + axisX[direction], moveY = column + axisY[direction];
				for (matches = 1; matches < length; matches++) {
					// Si esta fuera de rango
					if (moveX >= lenghtDna || moveX < 0 || moveY >= lenghtDna || moveY < 0)
						break;
					// Si no cohincide la siguiente letra
					if (sequenceAdn[moveX][moveY] != pattern.charAt(matches))
						break;
					moveX += axisX[direction];
					moveY += axisY[direction];
				}
				// Si todos los matches coinciden, validando con el tamaño de cada patron
				if (matches == length) {
					int finalPointX = moveX - axisX[direction];
					int finalPointY = moveX - axisY[direction];
					int vald = 7 - direction;
					// Estructura para almacenar los matches encontrados y evitar busquedas
					// innecesarias
					if (hm.get(finalPointX + "," + finalPointY) != null) {
						hm.get(finalPointX + "," + finalPointY).add(vald);
					} else {
						hm.put(finalPointX + "," + finalPointY, new ArrayList<Integer>());
						hm.get(finalPointX + "," + finalPointY).add(vald);
					}
					return true;
				}
			}
		}
		return false;
	}
}
