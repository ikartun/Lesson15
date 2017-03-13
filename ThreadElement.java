package by.epam.tr.lesson15;

public class ThreadElement extends Thread {
	private int[][] firstMatrix, secondMatrix, resultMatrix;
	private int startRow, endRow;
	
	public ThreadElement(int[][] firstMatrix, int[][] secondMatrix, int[][] resultMatrix, int startRow, int endRow) {
		this.firstMatrix = firstMatrix;
		this.secondMatrix = secondMatrix;
		this.resultMatrix = resultMatrix;
		this.startRow = startRow;
		this.endRow = endRow;
	}

	@Override
	public void run() {		
		System.out.println("Thread " + getName() + " multiply rows from " + startRow + " to " + endRow);
		
		for (int i = startRow; i < endRow; i++) {
			for (int j = 0; j < firstMatrix.length; j++) {
				for (int k = 0; k < firstMatrix.length; k++) {
					resultMatrix[i][j] += firstMatrix[i][k]*secondMatrix[k][j];
				}				
			}
		}
	}	
}
