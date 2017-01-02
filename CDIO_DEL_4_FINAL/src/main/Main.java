package main;

import javax.swing.SwingUtilities;

import controller.GameController;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new GameController());
	}

}