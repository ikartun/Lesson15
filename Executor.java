package by.epam.tr.lesson15;

public class Executor {

	public static void main(String[] args) {
		int[][] firstMatrix = null;
		int[][] secondMatrix = null;
		
		firstMatrix = Util.fill(firstMatrix, 100);
		secondMatrix = Util.fill(secondMatrix, 100);
		
		ThreadElementManipulator threadElementManipulator = new ThreadElementManipulator(11, firstMatrix, secondMatrix);
		int[][] resultMatrix = threadElementManipulator.multiply();
		
		Util.print(firstMatrix);
		Util.print(secondMatrix);
		Util.print(resultMatrix);
	}
}
