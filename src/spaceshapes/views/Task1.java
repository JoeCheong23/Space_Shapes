package spaceshapes.views;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import spaceshapes.CarrierShape;
import spaceshapes.Shape;
import spaceshapes.ShapeModel;

public class Task1 implements TreeModel{

	ShapeModel _shapeModel;
	
	public Task1(ShapeModel shapeModel) {
		_shapeModel = shapeModel;
	}

	@Override
	public Object getRoot() {
		return _shapeModel.root();
	}

	@Override
	public Object getChild(Object parent, int index) {
		if (parent instanceof CarrierShape) {
			try {
				return ((CarrierShape) parent).shapeAt(index);
			} catch (IndexOutOfBoundsException e) {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public int getChildCount(Object parent) {
		if (parent instanceof CarrierShape) {
			return ((CarrierShape)parent).shapeCount();
		} else {
			return 0;
		}
	}

	@Override
	public boolean isLeaf(Object node) {
		if (node instanceof CarrierShape) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// Blank method body, as allowed for Task1.
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if (parent instanceof CarrierShape && child instanceof Shape) {
			return ((CarrierShape)parent).indexOf((Shape)child);
		} else {
			return -1;
		}
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
	}
	
	
	
}
