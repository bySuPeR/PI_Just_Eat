package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet () {
        super ();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute ("isUser", true);
		RequestDispatcher view = request.getRequestDispatcher ("WEB-INF/ConfirmDelete.jsp");
		view.forward (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*TODO Eliminar el usuario de la Base de Datos*/
		
		//Por ahora, solo se cierra sesión y manda a la página de inicio de sesión.
		HttpSession session = request.getSession ();
		if (session != null) {
			session.invalidate ();
		}
		response.sendRedirect (request.getContextPath () + "/LoginServlet.do");
	}
}
