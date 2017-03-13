package by.epam.tr.lesson15;

public class Executor {

	public static void main(String[] args) {
		int[][] firstMatrix = null;
		int[][] secondMatrix = null;
		
		firstMatrix = Util.fill(firstMatrix, 3);
		secondMatrix = Util.fill(secondMatrix, 3);
		
		ThreadElementManipulator threadElementManipulator = new ThreadElementManipulator(2, firstMatrix, secondMatrix);
		int[][] resultMatrix = threadElementManipulator.multiply();
		
		Util.print(firstMatrix);
		Util.print(secondMatrix);
		Util.print(resultMatrix);
	}
}
