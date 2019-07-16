package fr.eni.tirage;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tirage
 */
@WebServlet("/Tirage")
public class Tirage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Tirage() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int serverNumber = 9;
		int userNumber;
		int max = 10;
		int min = 0;
		String resultat = " ";
		
		Random r = new Random();
		serverNumber = r.nextInt((max - min) + 1) + min;
		String serverNumberInString = String.valueOf(serverNumber);				
		
		
		String number = request.getParameter("nombre");
		response.getWriter().append("Nombre que vous avez choisi: ").append(number).append("\nLa bonne réponse était: ").append(serverNumberInString);
		

		userNumber = Integer.valueOf(number);
		if(userNumber == serverNumber) {
			response.sendRedirect("gagne.html");
		}
		else {
			response.sendRedirect("echec.html");
			
		}
		response.getWriter().append(resultat);

		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
