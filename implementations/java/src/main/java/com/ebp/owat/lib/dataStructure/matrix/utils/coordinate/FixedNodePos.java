package com.ebp.owat.lib.dataStructure.matrix.utils.coordinate;

import com.ebp.owat.lib.dataStructure.matrix.Matrix;
import com.ebp.owat.lib.dataStructure.matrix.utils.NodeDir;

public class FixedNodePos<T> extends NodePos<T>{
	/** The fixed position this node is. */
	public final NodePos.FixedNodePos pos;
	
	/**
	 * Most basic constructor for a NodePos.
	 *
	 * @param matrix The matrix this potision is a part of.
	 */
	public FixedNodePos(Matrix<T> matrix, NodePos.FixedNodePos posIn) {
		super(matrix);
		this.pos = posIn;
		this.determinePos();
	}
	
	/**
	 * Method used by the position to recalculate and update the appropriate position of this node.
	 * <p>
	 * Sets the x&y coordinates
	 */
	@Override
	protected void determinePos() {
		if(this.node == null){
			if(this.matrix.isEmpty()){
				throw new IllegalStateException("Cannot setup fixed node position in empty matrix.");
			}
			this.matrix.get(0L, 0L);
		}
		//go to the border node this position is supposed to go to
		for(NodeDir curDirToGo : this.pos.getBorderDirs()){
			while(!this.node.isBorder(curDirToGo)){
				this.node = this.node.getNeighbor(curDirToGo);
				this.setX(
						curDirToGo.incDec(NodeDir.Plane.X, this.getX())
				);
				this.setY(
						curDirToGo.incDec(NodeDir.Plane.Y, this.getY())
				);
			}
		}
	}
}
