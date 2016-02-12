package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class TelaProcessamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcessamento frame = new TelaProcessamento(textArea);
					frame.setVisible(true);
					frame.setTitle("Console");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaProcessamento(JTextArea textArea) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 11, 545, 351);
		contentPane.add(scrollPane);
		textArea.setBounds(10, 11, 545, 351);
		contentPane.add(textArea);

		scrollPane.setViewportView(textArea);
	}
}
