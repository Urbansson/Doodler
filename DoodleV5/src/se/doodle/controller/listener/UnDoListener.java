package se.doodle.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import se.doodle.model.Doodler;


public class UnDoListener implements ActionListener, KeyListener{

	private Doodler model;
	
	private int Sample = 0;
	
	public UnDoListener(Doodler model){
		this.model = model;

	};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.undo();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if(e.getKeyCode() == 157){
			Sample = 157;
		}else{
			if(Sample == 157 && e.getKeyCode() == 90){
				model.undo();
				Sample = 0;
			}
			
			if(Sample == 157 && e.getKeyCode() == 89){
				model.redo();
				Sample = 0;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}