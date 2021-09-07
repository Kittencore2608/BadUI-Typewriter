package me.archdukeliamus.badui.typewriter;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public final class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(Main::initInSwingEDT);
	}
	
	public static void initInSwingEDT() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		JFrame frame = new JFrame("Untitled - Typewriter");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JMenuBar topMenu = new JMenuBar();
		topMenu.add(new JMenu("File"));
		topMenu.add(new JMenu("Edit"));
		topMenu.add(new JMenu("Format"));
		topMenu.add(new JMenu("View"));
		topMenu.add(new JMenu("Help"));
		frame.setJMenuBar(topMenu);
		
//		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(false);
		textArea.setFont(new Font(Font.MONOSPACED, 0, 12));
		frame.add(textArea);
		
		MovementListener listener = new MovementListener(frame, textArea);
		textArea.addCaretListener(listener);
		textArea.addKeyListener(listener);
		frame.addComponentListener(listener);
		
		frame.setVisible(true);
		frame.setSize(640, 480);
		frame.setLocationRelativeTo(null);
	}
}
