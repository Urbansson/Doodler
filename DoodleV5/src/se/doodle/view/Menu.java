package se.doodle.view;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import se.doodle.controller.listener.ReDoListener;
import se.doodle.controller.listener.UnDoListener;
import se.doodle.controller.listener.aboutListener;
import se.doodle.controller.listener.loadCanvasListener;
import se.doodle.controller.listener.newCanvasListener;
import se.doodle.controller.listener.newShapeListener;
import se.doodle.controller.listener.quitListener;
import se.doodle.controller.listener.saveCanvasListener;
import se.doodle.model.Doodler;
import se.doodle.model.canvas.shapes.AvailableShapes;

public class Menu extends JPanel implements Observer{
		
	private Doodler model;
	private NewCanvas newCanvasDialog;
	private About aboutDialog;
	private NewShape newShapeDialog;
	private DoodleViewCanvas canvas;
	
	private JMenuItem undo;
	private JMenuItem redo;

	public Menu(DoodleViewCanvas canvas, NewCanvas newCanvasDialog,NewShape newShapeDialog,About aboutDialog){
		
		this.setBackground(Color.GREEN);
		this.model = canvas.getModel();
		this.newCanvasDialog = newCanvasDialog;
		this.aboutDialog = aboutDialog;
		this.newShapeDialog = newShapeDialog;
		this.canvas = canvas;
	}
	
	public JMenuBar createMenuBar() { 
		
		JMenuBar menuBar = new JMenuBar();
	
		JMenu mainMenu = new JMenu("Doodle");
		menuBar.add(mainMenu);
		
		JMenuItem aboutItem = new JMenuItem("About");
		mainMenu.add(aboutItem);
		
		mainMenu.addSeparator();

		JMenuItem newGameItem = new JMenuItem("New Canvas");
		mainMenu.add(newGameItem);
		
		JMenuItem LoadGameItem = new JMenuItem("Load Canvas");
		mainMenu.add(LoadGameItem);
		
		JMenuItem SaveGameItem = new JMenuItem("Save Canvas");
		mainMenu.add(SaveGameItem);
		
		mainMenu.addSeparator();

		JMenuItem quitItem = new JMenuItem("Quit");
		mainMenu.add(quitItem);
		
		// a listener for the about Item
		aboutListener aboutListener = new aboutListener(aboutDialog);
		aboutItem.addActionListener(aboutListener);
		
		// a listener for the New Game Item
		newCanvasListener newCanvasListener = new newCanvasListener(newCanvasDialog,this.model);
		newGameItem.addActionListener(newCanvasListener);

		// a listener for the Load Game Item
		loadCanvasListener loadCanvasListener = new loadCanvasListener(this.model);
		LoadGameItem.addActionListener(loadCanvasListener);
		
		saveCanvasListener saveCanvasListener = new saveCanvasListener(this.model);
		SaveGameItem.addActionListener(saveCanvasListener);
				
		// a listener for the Quit item
		quitListener quitListener = new quitListener();
		quitItem.addActionListener(quitListener);
		
		// 2: the Options menu
		JMenu optionsMenu = new JMenu("Options");
		menuBar.add(optionsMenu);
		
		
		undo = new JMenuItem("Undo");
		undo.addActionListener(new UnDoListener(model));
		undo.setEnabled(false);
		optionsMenu.add(undo);
		
		
		redo = new JMenuItem("Redo");
		redo.addActionListener(new ReDoListener(model));
		redo.setEnabled(false);
		optionsMenu.add(redo);
		
		
		// 3: the Modes menu
		JMenu modesMenu = new JMenu("Modes");
		menuBar.add(modesMenu);

		// a sub menu
		JMenu colorMenu = new JMenu("Shapes");

		//colorListener colorListener = new colorListener(this);

		// create menu items and add listener
		for (AvailableShapes shape: AvailableShapes.values()) {
			JMenuItem item = new JMenuItem(shape.toString());
			item.addActionListener(new newShapeListener(newShapeDialog, canvas,shape));
			colorMenu.add(item);
		}
		
		modesMenu.add(colorMenu);
		
		return menuBar;
	}
	
	

	private static final long serialVersionUID = 1L;

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
			undo.setEnabled(model.undoAvailable());
			redo.setEnabled(model.redoAvailable());
	}


}

