package se.doodle.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.doodle.model.Doodler;


public class ReDoListener implements ActionListener{

	private Doodler model;
	
	public ReDoListener(Doodler model){
		this.model = model;

	};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.redo();
	}

	
}