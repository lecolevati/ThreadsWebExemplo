package controller.threads;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ThreadProcessamento extends Thread {

	private int idThread;
	private JTextArea textArea;
	private JFrame frame;
	private static int contThread;
	private int numThreads;
	

	public ThreadProcessamento(int idThread, JTextArea textArea, JFrame frame,
			int numThreads) {
		this.idThread = idThread;
		this.textArea = textArea;
		this.frame = frame;
		this.numThreads = numThreads;
	}

	@Override
	public void run() {
		processamento();
	}

	private void processamento() {
		for (int i = 0; i <= 10; i++) {
			try {
				int tempo = (int) ((Math.random() * 2000) + 100);
				Thread.sleep(tempo);
				String msg = "Processamento #" + idThread + " rodando.";
				textArea.setText(textArea.getText() + "\n" + msg);
				textArea.setCaretPosition(textArea.getDocument().getLength());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		contThread++;
		if (contThread % numThreads == 0){
			frame.setVisible(false);
		}
	}

}
