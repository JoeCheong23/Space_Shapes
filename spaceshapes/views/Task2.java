package spaceshapes.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

import spaceshapes.ShapeModel;
import spaceshapes.ShapeModelEvent;
import spaceshapes.ShapeModelListener;

public class Task2 extends Task1 implements ShapeModelListener{
	
	List<TreeModelListener> _treeListenerList = new ArrayList<TreeModelListener>();
	
	public Task2(ShapeModel shapeModel) {
		super(shapeModel);
	}

	@Override
	public void update(ShapeModelEvent event) {
		
		ShapeModelEvent.EventType eventType = event.eventType();
			
		if (eventType == ShapeModelEvent.EventType.ShapeAdded) {
			Object[] pathArray = new Object[] {event.parent().parent(), event.parent()};
			TreePath treePath = new TreePath(pathArray);
			TreeModelEvent treeEvent = new TreeModelEvent(event.parent(), treePath, new int[]{0}, new Object[]{event.operand()});
			for (TreeModelListener listeners:_treeListenerList) {	
				listeners.treeNodesInserted(treeEvent);
			}
		} else if (eventType == ShapeModelEvent.EventType.ShapeRemoved) {
			Object[] pathArray = new Object[]{ event.parent()};
			TreePath treePath = new TreePath(pathArray);
			TreeModelEvent treeEvent = new TreeModelEvent(event.parent(), treePath, new int[]{1}, new Object[]{event.operand()});
			for (TreeModelListener listeners:_treeListenerList) {	
				listeners.treeNodesRemoved(treeEvent);
			}
		}
		
		}
	

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		_treeListenerList.add(l);
	}
 
	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		_treeListenerList.remove(l);
	}

	
	
	
	
}
