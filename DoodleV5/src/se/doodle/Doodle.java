package se.doodle;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import se.doodle.controller.listener.UnDoListener;
import se.doodle.controller.listener.canvasMouseListener;
import se.doodle.model.Doodler;
import se.doodle.view.About;
import se.doodle.view.DoodleViewCanvas;
import se.doodle.view.Menu;
import se.doodle.view.NewCanvas;
import se.doodle.view.NewShape;
import se.doodle.view.SelectedShape;


public class Doodle {

	public static void main(String args[]) throws CloneNotSupportedException {		
		//creating the game
		
		
		Doodler model = new Doodler();

		DoodleViewCanvas canvas = new DoodleViewCanvas(model);		
		JFrame frame = new JFrame("Doodler");
		frame.setSize(1280, 960);
		
		
		frame.addKeyListener(new UnDoListener(model));
		NewCanvas newCanvasDialog = new NewCanvas(frame);
		
		
		NewShape newShapeDialog = new NewShape(frame);
		
		
		SelectedShape SelectedShapeDialog = new SelectedShape(frame,model);
		
		About aboutDialog = new About(frame);
		Menu panel = new Menu(canvas,newCanvasDialog,newShapeDialog, aboutDialog);

		//Setting The MenuBar
		JMenuBar menuBar = panel.createMenuBar();
		frame.setJMenuBar(menuBar);
		frame.add(panel);
		frame.getContentPane().add(canvas);
		
		model.addObserver(panel);
		
		
		canvas.addMouseListener(new canvasMouseListener(canvas, model, SelectedShapeDialog));
		//Setting options for the frame
		//frame.pack();
		
		model.addObserver(canvas);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setMinimumSize(new Dimension(1100,800));

	}
	
	
}
