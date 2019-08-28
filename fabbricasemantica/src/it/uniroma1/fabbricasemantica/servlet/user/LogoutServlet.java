package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet che permette di disautentificare un utente
 * Imposta l'attributo username nella sessione con null
 * @author Matteo
 *
 */
@WebServlet(name="LogoutServlet", urlPatterns="/logout.jsp")
public class LogoutServlet extends BaseServlet 
{
	private static final long serialVersionUID = 8484501789787L;

	/**
	 * Imposta su null l'attributo username della sessione e reindirizza al login
	 * @param request Dati ricevuti dal front-end
	 * @param response Dati da inviare al front-end
	 * @throws ServletException Sollevata da errori generici nell servlet
	 * @throws IOException Sollevata da errori generici di input/output
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		session.setAttribute("username", null);
		response.sendRedirect("login.html");
	}

}
