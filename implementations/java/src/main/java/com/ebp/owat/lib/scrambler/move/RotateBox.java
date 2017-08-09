package com.ebp.owat.lib.scrambler.move;

import com.ebp.owat.lib.dataStructure.matrix.utils.coordinate.Coordinate;
import com.ebp.owat.lib.dataStructure.matrix.Matrix;

/**
 * Created by stewy on 4/4/17.
 */
public class RotateBox extends ScrambleMove {
	public enum RotateDir {
		CLOCKWISE,
		COUNTER
	}
	
	/**
	 * Constructor to set the matrix we are dealing with.
	 *
	 * @param matrixIn The matrix this move is dealing with.
	 */
	public RotateBox(Matrix matrixIn) {
		super(matrixIn);
	}
	
	/**
	 * Constructor to set the marix and the direction the move will take.
	 *
	 * @param matrixIn The matrix this move is dealing with.
	 * @param dirIn    The direction this move is to do.
	 */
	public RotateBox(Matrix matrixIn, Direction dirIn) {
		super(matrixIn, dirIn);
	}
	
	
	public void doMove(Coordinate nodeOne, Coordinate nodeTwo){
		//TODO:: swap the values
	}
}
