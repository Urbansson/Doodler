package se.doodle.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import se.doodle.model.Doodler;


public class saveCanvasListener implements ActionListener{

    private JFileChooser chooser;
    private Doodler model;
    
	public saveCanvasListener(Doodler model){
		chooser = new JFileChooser();
		this.model = model;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		    chooser = new JFileChooser();
		    chooser.setCurrentDirectory(new File("/home/me/Desktop"));
		    int retrival = chooser.showSaveDialog(null);
		    if (retrival == JFileChooser.APPROVE_OPTION) {
		        try {
	        		ObjectOutputStream oos = null;

	        		try{
	        			FileOutputStream fop = new FileOutputStream(chooser.getSelectedFile()+".save");
	        			oos = new ObjectOutputStream(fop);
	        			oos.writeObject(model.saveCanvas());
	        		}
	        		finally {
	        			oos.close();
	        		}
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
	}
}
