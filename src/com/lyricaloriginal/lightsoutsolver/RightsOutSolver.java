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
	 * 
	 * @param size
	 *            ライツアウトのサイズ
	 * @param lights
	 *            ライトの初期状態を示す配列
	 * @param needMinimumTapPattern
	 *            最小タップ数でクリアできるような回答を求めるか。
	 * @return 捜査すべき場所と回数を示す配列
	 */
	public static int[] solve(int size, int[] lights,
			boolean needMinimumTapPattern) {
		if (size == 3) {
			Size3RightsoutSolver solver = new Size3RightsoutSolver(lights);
			return solver.solve();
		} else if (size == 4) {
			Size4RightsoutSolver solver = new Size4RightsoutSolver(lights,
					needMinimumTapPattern);
			if (solver.solvable()) {
				return solver.solve();
			} else {
				return null;
			}
		} else {
			throw new RuntimeException("Not Implemented for size = " + size);
		}
	}

	/**
	 * ライツアウトが解けるかどうか判定します。
	 * 
	 * @return true:解ける, false:解けない
	 */
	protected abstract boolean solvable();

	/**
	 * ライツアウトを解きます。
	 * 
	 * @return　捜査すべき場所と回数を示す配列
	 */
	protected abstract int[] solve();
}
