package by.epam.tr.lesson15;

import java.util.ArrayList;
import java.util.List;

public class ThreadElementManipulator {
	private int countThreads;
	private int[][] firstMatrix, secondMatrix, resultMatrix;
	private int startRow, endRow;
	private List<ThreadElement> threadElements = new ArrayList<>();
	
	public ThreadElementManipulator(int countThreads, int[][] firstMatrix, int[][] secondMatrix) {
		if (countThreads <= 0 || firstMatrix.length != secondMatrix.length) {
			throw new IllegalArgumentException();
		}		
		this.countThreads = countThreads;
		this.firstMatrix = firstMatrix;
		this.secondMatrix = secondMatrix;
		resultMatrix = new int[firstMatrix.length][firstMatrix.length];
		endRow = resultMatrix.length/countThreads;
		
		if (endRow == 0 || countThreads == 1) {
			endRow = resultMatrix.length;
			this.countThreads = 1;
		}
	}
	
	public int[][] multiply() {
		int difference = endRow - startRow;
		
		if (resultMatrix.length%countThreads != 0) {
			endRow += resultMatrix.length%countThreads;
		}
		
		for (int i = 1; i <= countThreads; i++) {
			ThreadElement threadElement = new ThreadElement(firstMatrix, secondMatrix, resultMatrix, startRow, endRow);
			threadElements.add(threadElement);
			
			startRow = endRow;
			endRow += difference;
		}
		
		for (ThreadElement threadElement : threadElements) {
			threadElement.start();
		}
		
		for (ThreadElement threadElement : threadElements) {
			try {
				threadElement.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return resultMatrix;
	}
	
	public static void print(int[][] matrix) {		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
