package it.uniroma1.fabbricasemantica.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Implementa una servlet di Base
 * Una semplice classe java con un ciclo di vita ben definito
 * Unifica doGet e doPost in doSomething
 * @author Matteo
 *
 */
public abstract class BaseServlet extends HttpServlet 
{
	/**
	 * Versione
	 */
	private static final long serialVersionUID = 6784574842574L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doSomething(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doSomething(request, response);
	}

	/**
	 * Metodo che implementa la logica richiesta nelle specifiche del backend.
	 * @param request Dati che vengono dal front-end
	 * @param response Dati che vengono inviati al front-end
	 * @throws ServletException Sollevata da errori generici della servlet
	 * @throws IOException Sollevata da errori generici di input/output
	 * */
	protected abstract void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	
}
