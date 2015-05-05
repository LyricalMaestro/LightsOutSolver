package com.lyricaloriginal.lightsoutsolver;

/**
 * 3x3のライツアウトのソルバーです。
 * 
 * @author LyricalMaestro
 *
 */
class Size3RightsoutSolver extends RightsOutSolver{

	private final int[] _p;
	
	/**
	 * コンストラクタ
	 * 
	 * @param panels
	 * 			ライトの初期状態を示す配列
	 */
	Size3RightsoutSolver(int[] panels) {
		_p = panels;
	}

	@Override
	protected int[] solve() {
		int[] answer = new int[9];
		answer[0] = (_p[0] +       + _p[2] +                 _p[5] + _p[6] + _p[7]        ) % 2;
		answer[1] = (                      +         _p[4] +         _p[6] + _p[7] + _p[8]) % 2;
		answer[2] = (_p[0] +       + _p[2] + _p[3] +                         _p[7] + _p[8]) % 2;
		answer[3] = (                _p[2] +         _p[4] + _p[5] +                 _p[8]) % 2;
		answer[4] = (        _p[1] +         _p[3] + _p[4] + _p[5] +         _p[7]        ) % 2;
		answer[5] = (_p[0] +                 _p[3] + _p[4] +       + _p[6]                ) % 2;
		answer[6] = (_p[0] + _p[1]         +                 _p[5] + _p[6]         + _p[8]) % 2;
		answer[7] = (_p[0] + _p[1] + _p[2] +         _p[4]                                ) % 2;
		answer[8] = (        _p[1] + _p[2] + _p[3]                 + _p[6]         + _p[8]) % 2;
		return answer;
	}

}
