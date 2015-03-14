package se.doodle.model.undoredo;

import java.util.Stack;

public class UndoRedoInvoker{

	Stack<UndoRedo> undoCommands;
	Stack<UndoRedo> redoCommands;

	public UndoRedoInvoker(){
		undoCommands = new Stack<>();
		redoCommands =  new Stack<>();
	}

	public void addUndoCommand(UndoRedo command){
		undoCommands.push(command);
	}

	private void addRedoCommands(UndoRedo command){
		redoCommands.push(command);
	}

	public void undo(){
		if(!undoCommands.isEmpty()){
			UndoRedo current = undoCommands.pop();
			current.undo();
			this.addRedoCommands(current);
		}
	}

	public void redo(){

		if(!redoCommands.isEmpty()){
			UndoRedo current = redoCommands.pop();
			current.redo();
			this.addUndoCommand(current);

		}
	}

	public void clearRedo(){

		redoCommands.clear();
	}

	public boolean redoAvailable(){
		return !redoCommands.isEmpty();
	}
	

	public boolean undoAvailable(){
		return !undoCommands.isEmpty();
	}
	

}
