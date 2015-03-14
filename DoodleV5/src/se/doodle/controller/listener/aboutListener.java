package se.doodle.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.doodle.view.About;


public class aboutListener implements ActionListener{
	
	private About aboutDialog;
	
	public aboutListener(About about){
		this.aboutDialog = about;
	}
	
	public void actionPerformed(ActionEvent ae) {		
		aboutDialog.setVisible(true);
	}
}
