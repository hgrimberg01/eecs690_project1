package edu.ku.eecs.agiledev.core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import org.jdesktop.swingx.JXFrame;
import java.awt.BorderLayout;
import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.MultiSplitLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class BaseWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseWindow window = new BaseWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BaseWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
		
		JXMultiSplitPane multiSplitPane = new JXMultiSplitPane();
		frame.getContentPane().add(multiSplitPane);
	}
}
