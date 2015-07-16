package com.lyricaloriginal.lightsoutsolver;

class LightsOutMatrixGenerator {

	static int[][] generate(int size){
		if(size < 2){
			return null;
		}
		
		int[][] matrix = new int[size * size][];
		for(int i = 0; i < size* size; i++){
			matrix[i] = new int[size * size];
		}
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				matrix[i * size + j][i * size + j] = 1;
				if(0 < j){
					matrix[i * size + j][i * size + j - 1] = 1;
				}
				if(j < size - 1){
					matrix[i * size + j][i * size + j + 1] = 1;
				}
				if(0 < i){
					matrix[i * size + j][(i - 1) * size + j] = 1;
				}
				if(i < size - 1){
					matrix[i * size + j][(i + 1) * size + j] = 1;
				}
			}
		}
		return matrix;
	}
}
