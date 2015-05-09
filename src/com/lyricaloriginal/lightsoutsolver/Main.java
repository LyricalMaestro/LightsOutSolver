package com.lyricaloriginal.lightsoutsolver;

/**
 * このプログラムを動かすためのメインクラスです。<BR>
 * このプロジェクトをライブラリとして参照する場合には、このクラスを含める必要はありません。
 * 
 * @author LyricalMaestro
 * 
 */
public class Main {

	// ライツアウトのサイズ。
	private static final int SIZE = 3;
	// ライトのon/offの初期状態。
	private static final int[] LIGHTS = new int[] { 0, 1, 0, 0, 1, 0, 0, 1, 0 };

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("起動時引数を指定しなかったので、デフォルトの値を使用します。");
			solve(SIZE, LIGHTS);
		} else {
			int size = getSize(args);
			int[] lights = getLights(args, size);
			solve(size, lights);
		}
	}

	private static int getSize(String[] args) {
		int size = 0;
		String sizeStr = getValue(args, "-s");
		if (sizeStr.length() == 0) {
			System.out.println("オプション -s には2以上の自然数を指定してください。");
			System.exit(-1);
		}
		try {
			size = Integer.parseInt(sizeStr);
		} catch (NumberFormatException ex) {
			System.out.println("オプション -s には2以上の自然数を指定してください。");
			System.exit(-1);
		}
		if (size < 2) {
			System.out.println("オプション -s には2以上の自然数を指定してください。");
			System.exit(-1);
		}
		return size;
	}

	private static int[] getLights(String[] args, int size) {
		String matArray = getValue(args, "-l");
		if (matArray.length() == 0) {
			System.out.println("オプション -l にはライトの状態を示す値0, 1をカンマ区切りで指定してください。");
			System.exit(-1);
		}
		String[] vals = matArray.split(",");
		if (vals.length != size * size) {
			System.out.println("値は" + (size * size)+ "個指定してください。");
			System.exit(-1);
		}
		int[] lights = new int[size * size];
		for (int i = 0; i < size * size; i++) {
			int val = -1;
			try {
				val = Integer.parseInt(vals[i]);
			} catch (NumberFormatException ex) {
				System.out.println(String.format("第%d成分は整数ではありません。", i + 1));
				System.exit(-1);
			}
			lights[i] = val % 2;
			if (lights[i] < 0) {
				lights[i] += 2;
			}
		}
		return lights;
	}

	private static String getValue(String[] args, String optionKey) {
		for (int i = 0; i < args.length - 1; i++) {
			if (optionKey.equals(args[i])) {
				return args[i + 1];
			}
		}
		return "";
	}

	private static void solve(int size, int[] lights) {

		System.out.println("---  Input  ---");
		System.out.println("Size = " + size);
		System.out.println("ライトの初期状態 ");
		System.out.println("■ : ON,  □ : OFF ");
		System.out.println("    ");
		for (int i = 0; i < size; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < size; j++) {
				sb.append(lights[i * size + j] == 1 ? "■" : "□");
				sb.append(" ");
			}
			System.out.println(sb.toString());
		}
		System.out.println("");

		int[] answer = RightsOutSolver.solve(size, lights);

		System.out.println("---  Output  ---");
		if (answer == null) {
			System.out.println("このライツアウトは解くことができません。");
			return;
		}

		System.out.println("タップすべき場所と回数 ");
		System.out.println("    ");
		for (int i = 0; i < size; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < size; j++) {
				sb.append(answer[i * size + j] == 1 ? "1" : "0");
				sb.append(" ");
			}
			System.out.println(sb.toString());
		}
	}

}
