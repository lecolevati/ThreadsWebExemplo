package controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JTextArea;

import view.TelaProcessamento;
import controller.threads.ThreadProcessamento;

@WebServlet("/threads")
public class ServletThreads extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletThreads() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JTextArea textArea = new JTextArea();
		TelaProcessamento tela = new TelaProcessamento(textArea);
		tela.setVisible(true);
		tela.setAlwaysOnTop(true);
		textArea.setFocusable(true);
		int numThreads = 10;
		for (int i = 0 ; i < numThreads ; i++){
			Thread t = new ThreadProcessamento(i,textArea, tela, numThreads);
			t.start();
		}
		RequestDispatcher view = request.getRequestDispatcher("saida.jsp");
		view.forward(request, response);	
	}

}
