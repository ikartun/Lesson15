package by.epam.tr.lesson15;

import java.util.Random;

public class Util {
	public static void print(int[][] matrix) {		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int[][] fill(int[][] matrix, int size) {
		Random random = new Random();
		matrix = new int[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = random.nextInt(10);
			}
		}
		return matrix;
	}
}
