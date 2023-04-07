package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DeleteDishServlet
 */
public class DeleteDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDishServlet () {
        super ();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute ("delete", 2);
		RequestDispatcher view = request.getRequestDispatcher ("WEB-INF/ConfirmDelete.jsp");
		view.forward (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * TODO Eliminar el plato de la Base de Datos. Creo que habrá que coger el ID del plato en el doGet,
		 * indicarlo en un atributo privado de la clase y volver a cogerlo aquí para eliminarlo.
		 */
	}
}
