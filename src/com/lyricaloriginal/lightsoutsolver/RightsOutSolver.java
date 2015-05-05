package com.lyricaloriginal.lightsoutsolver;

/**
 * ライツアウトのソルバーです。
 * 
 * @author LyricalMaestro
 *
 */
public abstract class RightsOutSolver {

	/**
	 * ライツアウトを解きます。
	 * @param size
	 * 			ライツアウトのサイズ
	 * @param panels
	 * 			ライトの初期状態を示す配列
	 * @return 捜査すべき場所と回数を示す配列
	 */
	public static int[] solve(int size, int[] panels){
		if(size == 3){
			Size3RightsoutSolver solver = new Size3RightsoutSolver(panels);
			return solver.solve();
		}else{
			throw new RuntimeException("Not Implemented for size = " + size);
		}
	}
	
	/**
	 * ライツアウトを解きます。
	 * 
	 * @return　捜査すべき場所と回数を示す配列
	 */
	protected abstract int[] solve();
}
