package com.lyricaloriginal.lightsoutsolver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ベクトル集合を生成するためのクラスです。
 * 
 * @author LyricalMaestro
 * 
 */
class VectorSetGenerator {

	/**
	 * 入力したベクトルたちで生成される(F2係数)ベクトル空間内の全ベクトルを取得します。
	 * 
	 * @param baseVectors
	 *            生成元ベクトル
	 * @return 対象ベクトルの集合
	 */
	static Set<int[]> spanFromBaseVectorSpace(int[][] baseVectors) {
		Set<int[]> sets = new HashSet<int[]>();

		// 入力ベクトルの入力チェック
		if (baseVectors == null || baseVectors.length == 0) {
			return sets;
		}

		int dim = baseVectors[0].length;
		// 各ベクトルの次元が一致するかチェック
		for (int[] vec : baseVectors) {
			if (vec.length != dim) {
				throw new IllegalArgumentException("入力したベクトルたちの次元がバラバラです。");
			}
		}

		sets.add(zeroVector(dim));
		for (int i = 0; i < baseVectors.length; i++) {
			int[] vec = baseVectors[i];
			List<int[]> generatedVecs = new ArrayList<int[]>();
			for (int[] base : sets) {
				int[] vec2 = add(base, vec);
				generatedVecs.add(vec2);
			}
			sets.addAll(generatedVecs);
		}
		return sets;
	}

	private static int[] zeroVector(int dim) {
		int[] zeroVec = new int[dim];
		for (int i = 0; i < dim; i++) {
			zeroVec[i] = 0;
		}
		return zeroVec;
	}

	private static int[] add(int[] base, int[] vec) {
		int dim = base.length;
		int[] newVec = new int[dim];
		for (int i = 0; i < dim; i++) {
			newVec[i] = (base[i] + vec[i]) % 2;
		}
		return newVec;
	}
}
