package Darts;

import javax.swing.JTextField;

import net.bytebuddy.asm.Advice.This;

public class Field extends JTextField {
	private int number;

	public void set_number(int number) {
		this.number = number;
	}

	public int get_number() {
		return number;
	}
}
