package Darts;

import javax.swing.JTextField;

import net.bytebuddy.asm.Advice.This;

public class Field extends JTextField {
	private int number;
	private boolean is_guessed=false;

	public void set_number(int number) {
		this.number = number;
	}

	public int get_number() {
		return number;
	}
	
	public void set_is_guessed(boolean is_guessed) {
		this.is_guessed=is_guessed;
	}
	
	public boolean get_is_guessed() {
		return is_guessed;
	}
}
