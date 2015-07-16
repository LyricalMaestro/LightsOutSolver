package com.lyricaloriginal.lightsoutsolver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LightsOutMatrixGeneratorTest {

	@Test
	public void generatorTest1(){
		int[][] matrix = LightsOutMatrixGenerator.generate(1);
		assertThat(matrix, nullValue());
	}
	
	@Test
	public void generatorTest2(){
		//@formatter:off
		int[][] expected = new int[][]{
				{1, 1, 1, 0},
				{1, 1, 0, 1},
				{1, 0, 1, 1},
				{0, 1, 1, 1}
			};
		//@formatter:on
		
		int[][] actual = LightsOutMatrixGenerator.generate(2);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void generatorTest3(){
		//@formatter:off
		int[][] expected = new int[][]{
				{1, 1, 0, 1, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 1, 0, 0, 0, 0},
				{0, 1, 1, 0, 0, 1, 0, 0, 0},
				{1, 0, 0, 1, 1, 0, 1, 0, 0},
				{0, 1, 0, 1, 1, 1, 0, 1, 0},
				{0, 0, 1, 0, 1, 1, 0, 0, 1},
				{0, 0, 0, 1, 0, 0, 1, 1, 0},
				{0, 0, 0, 0, 1, 0, 1, 1, 1},
				{0, 0, 0, 0, 0, 1, 0, 1, 1}
			};
		//@formatter:on
		
		int[][] actual = LightsOutMatrixGenerator.generate(3);
		assertThat(actual, is(expected));
	}

	@Test
	public void generatorTest4(){
		//@formatter:off
		int[][] expected = new int[][]{
				{1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1},
			};
		//@formatter:on
		
		int[][] actual = LightsOutMatrixGenerator.generate(4);
		assertThat(actual, is(expected));
	}
}
