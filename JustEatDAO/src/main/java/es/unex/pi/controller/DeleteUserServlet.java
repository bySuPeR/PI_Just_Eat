package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.User;

/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private long user = -1;
       
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
		request.setAttribute ("delete", 0);
		this.user= Long.parseLong(request.getParameter("id"));
		RequestDispatcher view = request.getRequestDispatcher ("WEB-INF/ConfirmDelete.jsp");
		view.forward (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*TODO Eliminar el usuario de la Base de Datos*/
		String option = request.getParameter("Option");
		if(option.equals("No")){
			response.sendRedirect(request.getContextPath() + "/UpdateUserServlet.do");
		}
		else {
			HttpSession sesion = request.getSession();
			User usuarioSesion = (User) sesion.getAttribute("user"); 
			UserDAO usuarioBD = new JDBCUserDAOImpl();
			Connection conn = (Connection)getServletContext().getAttribute("dbConn");
			usuarioBD.setConnection(conn); //debes hacer una conexion por cada DAO!
			usuarioBD.delete(usuarioSesion.getId());
			response.sendRedirect (request.getContextPath () + "/LoginServlet.do");
		}
		
	}
}

