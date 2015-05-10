package com.lyricaloriginal.lightsoutsolver;

import java.util.Set;

/**
 * 4x4のライツアウトのソルバーです。
 * 
 * @author LyricalMaestro
 * 
 */
public class Size4RightsoutSolver extends RightsOutSolver {

	private static final int[][] BASE_KERNEL_VECTORS = new int[][] {
			{ 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0 },
			{ 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0 },
			{ 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0 },
			{ 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1 }, };

	private final int[] _p;
	private final boolean _needMinimumTapPattern;

	/**
	 * コンストラクタ
	 * 
	 * @param lights
	 *            ライトの初期状態を示す配列
	 * @param needMinimumTapPattern
	 *            最小タップ数でクリアできるような回答を求めるか。
	 */
	Size4RightsoutSolver(int[] lights, boolean needMinimumTapPattern) {
		_p = lights;
		_needMinimumTapPattern = needMinimumTapPattern;
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

		if (_needMinimumTapPattern) {
			answer = searchMinimumTapPattern(answer);
		}
		return answer;
	}

	private int[] searchMinimumTapPattern(int[] orgPattern) {
		Set<int[]> kernelVectors = VectorSetGenerator
				.spanFromBaseVectorSpace(BASE_KERNEL_VECTORS);
		
		int minTapNum = Integer.MAX_VALUE;
		int[] minTapPattern = null;
		for(int[] kernelVector: kernelVectors){
			int[] v = add(kernelVector, orgPattern);
			int n = calcTapNum(v);
			if(n < minTapNum){
				minTapNum = n;
				minTapPattern = v;
			}
		}
		return minTapPattern;
	}
	
	private int[] add(int[] v1, int[] v2){
		int[] v = new int[v1.length];
		for(int i = 0; i < v1.length ; i++){
			v[i] = (v1[i] + v2[i]) % 2;
		}
		return v;
	}
	
	private int calcTapNum(int[] v) {
		int num = 0;
		for(int i = 0; i < v.length ; i++){
			num += v[i];
		}
		return num;
	}
}
