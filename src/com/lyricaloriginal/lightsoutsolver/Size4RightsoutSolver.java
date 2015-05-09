package com.lyricaloriginal.lightsoutsolver;

/**
 * 4x4のライツアウトのソルバーです。
 * 
 * @author LyricalMaestro
 * 
 */
public class Size4RightsoutSolver extends RightsOutSolver {

	private final int[] _p;

	/**
	 * コンストラクタ
	 * 
	 * @param lights
	 *            ライトの初期状態を示す配列
	 */
	Size4RightsoutSolver(int[] lights) {
		_p = lights;
	}

	@Override
	protected boolean solvable() {
		int val1 = _p[1] + _p[2] + _p[3] + _p[4] + _p[6] + _p[8] + _p[9]
				+ _p[12];
		val1 %= 2;
		int val2 = _p[0] + _p[1] + _p[3] + _p[7] + _p[8] + _p[9] + _p[10]
				+ _p[13];
		val2 %= 2;
		int val3 = _p[0] + _p[2] + _p[3] + _p[4] + _p[9] + _p[10] + _p[11]
				+ _p[14];
		val3 %= 2;
		int val4 = _p[0] + _p[1] + _p[2] + _p[5] + _p[7] + _p[10] + _p[11]
				+ _p[15];
		val4 %= 2;
		return val1 == 0 && val2 == 0 && val3 == 0 && val4 == 0;
	}

	@Override
	protected int[] solve() {
		int[] answer = new int[16];
		answer[0] = (_p[0] + _p[1] + _p[4] + _p[6] + _p[9] + _p[10] + _p[11]) % 2;
		answer[1] = (_p[0] + _p[1] + _p[2] + _p[7] + _p[8] + _p[9] + _p[11]) % 2;
		answer[2] = (_p[1] + _p[2] + _p[3] + _p[4] + _p[8] + _p[10] + _p[11]) % 2;
		answer[3] = (_p[2] + _p[3] + _p[5] + _p[7] + _p[8] + _p[9] + _p[10]) % 2;

		answer[4] = (_p[0] + _p[2] + _p[4] + _p[6] + _p[7] + _p[8] + _p[10]) % 2;
		answer[5] = (_p[3] + _p[6] + _p[7] + _p[11]) % 2;
		answer[6] = (_p[0] + _p[4] + _p[5] + _p[8]) % 2;
		answer[7] = (_p[1] + _p[3] + _p[4] + _p[5] + _p[7] + _p[9] + _p[11]) % 2;
		
		answer[8] = (_p[1] + _p[2] + _p[3] + _p[4] + _p[6] + _p[8] + _p[9]) % 2;
		answer[9] = (_p[0] + _p[1] + _p[3] + _p[7] + _p[8] + _p[9] + _p[10]) % 2;
		answer[10] = (_p[0] + _p[2] + _p[3] + _p[4] + _p[9] + _p[10] + _p[11]) % 2;
		answer[11] = (_p[0] + _p[1] + _p[2] + _p[5] + _p[7] + _p[10] + _p[11]) % 2;
		
		answer[12] = 0;
		answer[13] = 0;
		answer[14] = 0;
		answer[15] = 0;
		return answer;
	}

}
