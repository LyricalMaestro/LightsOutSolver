package com.lyricaloriginal.lightsoutsolver;

public abstract class RightsOutSolver {

	public static int[] solve(int size, int[] panels){
		if(size == 3){
			Size3RightsoutSolver solver = new Size3RightsoutSolver(panels);
			return solver.solve();
		}else{
			throw new RuntimeException("Not Implemented for size = " + size);
		}
	}
	
	protected abstract int[] solve();
}
