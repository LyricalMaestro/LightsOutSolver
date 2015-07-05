package com.lyricaloriginal.lightsoutsolver;

import java.util.Set;

import com.lyricaloriginal.f2matrixanalyzer.Analyzer;
import com.lyricaloriginal.f2matrixanalyzer.Report;

/**
 * nxn(2<=n)のライツアウトのソルバーです。<BR>
 * ライブラリ「F2MatrixAnalyzer.jar」を使用しています。
 * 
 * @author LyricalMaestro
 * 
 */
public class SizeNRightsoutSolver extends RightsOutSolver{
	
	private final int[] _p;
	private final boolean _needMinimumTapPattern;
	private final int[][] _lightsOutMatrix;
	private final int[][] _generalizedMatrix;
	private final int[][] _kernelVectors;
	private final int _kernelDim;
	
	/**
	 * コンストラクタ
	 * 
	 * @param n
	 * 			問題のサイズ
	 * @param lights
	 *            ライトの初期状態を示す配列
	 * @param needMinimumTapPattern
	 *            最小タップ数でクリアできるような回答を求めるか。
	 */
	SizeNRightsoutSolver(int n, int[] lights, boolean needMinimumTapPattern) {
		_lightsOutMatrix = makeLightsOutMatrix(n);
		_p = lights;
		_needMinimumTapPattern = needMinimumTapPattern;

		Analyzer analyzer = new Analyzer(makeLightsOutMatrix(n));
		Report report = analyzer.analyze();
		_generalizedMatrix = report.getGeneralizedInverse();
		_kernelVectors = report.getKernelVectors();
		_kernelDim = report.getKernelDim();
	}

	@Override
	protected boolean solvable() {
		int n = _generalizedMatrix.length;
		for(int i = n - _kernelDim; i < n; i++){
			for(int j = 0; j < n; j++){
				int v = _generalizedMatrix[i][j] * _p[j];
				if(v % 2 != 0){
					return false;
				}
			}
		}
		return true;
	}

	@Override
	protected int[] solve() {
		int n = _generalizedMatrix.length;
		int[] answer = new int[n];
		for(int i = 0; i < n - _kernelDim; i++){
			for(int j = 0; j < n; j++){
				answer[i] += _generalizedMatrix[i][j] * _p[j];
			}
			answer[i] %= 2;
		}
		for(int i = n - _kernelDim; i < n; i++){
			answer[i] = 0;
		}
		
		//	念のため計算チェック
		check(answer);
		if (_needMinimumTapPattern) {
			answer = searchMinimumTapPattern(answer);
		}
		return answer;
	}
	
	private void check(int[] answer) {
		int n = _lightsOutMatrix.length;
		for(int i = 0; i < n; i++){
			int val = 0;
			for(int j = 0; j < n ; j++){
				val += _lightsOutMatrix[i][j] * answer[j];
			}
			val %= 2;
			if(val != _p[i]){
				throw new RuntimeException("計算があっていません！ i = " + i);
			}
		}
	}

	private int[][] makeLightsOutMatrix(int n){
		int[][] matrix = new int[n * n][];
		for(int i = 0; i < n * n; i++){
			matrix[i] = new int[n * n];
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i * n + j][i * n + j] = 1;
				if(0 < j){
					matrix[i * n + j][i * n + j - 1] = 1;
				}
				if(j < n - 1){
					matrix[i * n + j][i * n + j + 1] = 1;
				}
				if(0 < i){
					matrix[i * n + j][(i - 1) * n + j] = 1;
				}
				if(i < n - 1){
					matrix[i * n + j][(i + 1) * n + j] = 1;
				}
			}
		}
		return matrix;
	}
	
	private int[] searchMinimumTapPattern(int[] orgPattern) {
		if(_kernelDim == 0){
			return orgPattern;
		}
		
		Set<int[]> kernelVectors = VectorSetGenerator
				.spanFromBaseVectorSpace(_kernelVectors);
		
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
