package se.doodle.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.doodle.model.Doodler;
import se.doodle.view.NewCanvas;

public class newCanvasListener implements ActionListener{
	
	private NewCanvas newCanvasDialog;
	private Doodler model;
	
	public newCanvasListener(NewCanvas newCanvasDialog, Doodler model){
		this.newCanvasDialog = newCanvasDialog;
		this.model = model;
	}
	
	public void actionPerformed(ActionEvent ae) {
		newCanvasDialog.setVisible(true);
		
		model.newCanvas();
		
		
		//newCanvasDialog.getHeight();
		//newCanvasDialog.getWidth();

		

	}
}
	
	
