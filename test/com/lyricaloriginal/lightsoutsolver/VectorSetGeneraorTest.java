package com.lyricaloriginal.lightsoutsolver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class VectorSetGeneraorTest {

	@Test
	public void spanFromBaseVectorSpaceTest1() {

		Set<int[]> actual = VectorSetGenerator.spanFromBaseVectorSpace(null);

		assertThat(actual, notNullValue());
		assertThat(actual.isEmpty(), is(true));
	}

	@Test
	public void spanFromBaseVectorSpaceTest2() {
		int[][] inputVectors = new int[0][];

		Set<int[]> actual = VectorSetGenerator
				.spanFromBaseVectorSpace(inputVectors);

		assertThat(actual, notNullValue());
		assertThat(actual.isEmpty(), is(true));
	}

	@Test(expected = IllegalArgumentException.class)
	public void spanFromBaseVectorSpaceTest3() {
		//@formatter:off
		int[][] inputVectors = new int[][]{
				{1, 0, 1, 0},
				{1, 0, 1}
			};
		//@formatter:on

		VectorSetGenerator.spanFromBaseVectorSpace(inputVectors);
	}

	@Test
	public void spanFromBaseVectorSpaceTest4() {
		//@formatter:off
		int[][] inputVectors = new int[][]{
				{0, 1, 0},
				{1, 0, 1}
			};
		//@formatter:on
		Set<int[]> expected = new HashSet<int[]>();
		expected.add(new int[]{0, 0, 0});
		expected.add(new int[]{0, 1, 0});
		expected.add(new int[]{1, 0, 1});
		expected.add(new int[]{1, 1, 1});

		Set<int[]> actual = VectorSetGenerator.spanFromBaseVectorSpace(inputVectors);
		assertThat(isMatch(actual, expected), is(true));
	}
	
	@Test
	public void spanFromBaseVectorSpaceTest5() {
		//@formatter:off
		int[][] inputVectors = new int[][]{
				{0, 1, 0, 0},
				{1, 0, 1, 0},
				{0, 1, 1, 1},
			};
		//@formatter:on
		Set<int[]> expected = new HashSet<int[]>();
		expected.add(new int[]{0, 0, 0, 0});
		expected.add(new int[]{0, 1, 0, 0});
		expected.add(new int[]{1, 0, 1, 0});
		expected.add(new int[]{1, 1, 1, 0});
		expected.add(new int[]{0, 1, 1, 1});
		expected.add(new int[]{0, 0, 1, 1});
		expected.add(new int[]{1, 1, 0, 1});
		expected.add(new int[]{1, 0, 0, 1});

		Set<int[]> actual = VectorSetGenerator.spanFromBaseVectorSpace(inputVectors);
		assertThat(isMatch(actual, expected), is(true));
	}

	private static boolean isMatch(Set<int[]> actual, Set<int[]> expected){
		if(actual == null && expected == null){
			return true;
		}else if(actual != null && expected == null){
			return false;
		}else if(actual == null && expected != null){
			return false;
		}
		
		if(actual.size() != expected.size()){
			return false;
		}
		
		for(int[] array : actual){
			if(!contains(expected, array)){
				return false;
			}
		}
		return true;
	}

	private static boolean contains(Set<int[]> set, int[] val) {
		for(int[] v : set){
			if(Arrays.equals(v, val)){
				return true;
			}
		}
		return false;
	}
}
