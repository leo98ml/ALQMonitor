package it.unical.dimes.tesi.gui.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class CommonsPopUp {
	public static JMenuItem credits(JFrame frame) {
		JMenuItem mntmNewMenuItem = new JMenuItem("?");
		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Made by Leonardo Marafioti mat. 192770");
			}
		});
		return mntmNewMenuItem;
	}

}
