package com.lyricaloriginal.lightsoutsolver;

public class Main {

	//	ライツアウトのサイズ。
	private static final int SIZE = 3;
	//	ライトのon/offの初期状態。
	private static final int[] PANELS = new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0};
	
	public static void main(String[] args) {
		solve(SIZE, PANELS);
	}
	
	private static void solve(int size, int[] panels){
		
		System.out.println("---  Input  ---");
		System.out.println("Size = " + size);
		System.out.println("ライトの初期状態 ");
		System.out.println("    ");
		for(int i = 0; i < size; i++){
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < size; j++){
				sb.append(panels[i * size + j] == 1 ? "■" : "□");
				sb.append(" ");
			}
			System.out.println(sb.toString());
		}
		System.out.println("");
		
		int[] answer = RightsOutSolver.solve(size, panels);
		
		System.out.println("---  Output  ---");
		System.out.println("タップすべき場所と回数 ");
		System.out.println("    ");
		for(int i = 0; i < size; i++){
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < size; j++){
				sb.append(answer[i * size + j] == 1 ? "1" : "0");
				sb.append(" ");
			}
			System.out.println(sb.toString());
		}
	}

}
