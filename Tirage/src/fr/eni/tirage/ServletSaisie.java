package fr.eni.tirage;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Saisie
 */
@WebServlet("/Saisie")
public class ServletSaisie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int guess;

    /**
     * Default constructor. 
     */
    public ServletSaisie() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	guess = new Random().nextInt(11);
    	System.out.println(guess);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		guess = new Random().nextInt(11);
		response.sendRedirect("/Tirage/html/saisie.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		System.out.println(choice);
		int choiceInt = Integer.parseInt(choice);
		
		if(choiceInt == guess) response.sendRedirect("/Tirage/html/victoire.html");
		else response.sendRedirect("/Tirage/html/echec.html");
	}

}
