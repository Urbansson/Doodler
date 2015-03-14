package se.doodle.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import se.doodle.model.Doodler;
import se.doodle.model.canvas.DoodlerCanvas;


public class loadCanvasListener implements ActionListener{
	private Doodler model;
    private JFileChooser chooser;

	public loadCanvasListener(Doodler model){
		this.model = model;
		chooser = new JFileChooser();
	}
	
	public void actionPerformed(ActionEvent ae) {		
		//openFile()

	        int returnName = chooser.showOpenDialog(null);	 
	        if (returnName == JFileChooser.APPROVE_OPTION) {
	        	ObjectInputStream ois = null;
				try {
					FileInputStream fin = new FileInputStream(chooser.getSelectedFile().getPath());
					ois = new ObjectInputStream(fin);
					
					DoodlerCanvas newCanvas = (DoodlerCanvas) ois.readObject();
					model.loadCanvas(newCanvas);
					
				} catch (IOException ie) {
					JOptionPane.showMessageDialog(chooser,
						    "Could not open File",
						    "Load Error",
						    JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(chooser,
						    "Could not open File",
						    "Load Error",
						    JOptionPane.ERROR_MESSAGE);
				} finally {
					try {
						if(ois != null) ois.close();
					} catch (IOException e) {}
				}
	        }

	}
}
