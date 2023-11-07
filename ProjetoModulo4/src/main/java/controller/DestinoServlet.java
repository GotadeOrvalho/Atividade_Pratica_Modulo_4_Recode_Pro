package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud_dao.DestinosDAO;
import model.Destinos;


@WebServlet(urlPatterns = {"/destinos", "/destinos-create", "/destinos-update", "/destinos-edit", "/destinos-delete"})
public class DestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DestinosDAO udao = new DestinosDAO();
    Destinos destinos = new Destinos();
   
    public DestinoServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch (action) {
		case "/destinos":
			 getDestino(request, response);
			break;
			
		case "/destinos-create":
			 save(request, response);
			break;
			
		case "/destinos-edit":
			edit(request, response);
			break;

		case "/destinos-update":
			update(request, response);
			break;
			
			
		case "/destinos-delete":
			removeById(request, response);
			break;
		default:
			response.sendRedirect("listadestino.html");
			break;
		}
		
	}

	protected void getDestino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Destinos> lista = udao.getDestino();
		
		request.setAttribute("listaDestinos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listadestino.jsp");
		rd.forward(request, response);
	}
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		destinos.setCidade(request.getParameter("cidade"));
		destinos.setEstado(request.getParameter("estado"));
		destinos.setPais(request.getParameter("pais"));
		destinos.setAeroporto(request.getParameter("aeroporto"));
		destinos.setPromocao(Float.parseFloat(request.getParameter("promocao")));
		
		
		udao.save(destinos);
		
		response.sendRedirect("destinos");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_destino = Integer.parseInt(request.getParameter("id_destino"));
		
		destinos = udao.destinosById(id_destino);
		
		request.setAttribute("destinos", destinos);
		
		RequestDispatcher rd = request.getRequestDispatcher("editardestino.jsp");
		rd.forward(request, response);

	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		destinos.setCidade(request.getParameter("cidade"));
		destinos.setEstado(request.getParameter("estado"));
		destinos.setPais(request.getParameter("pais"));
		destinos.setAeroporto(request.getParameter("aeroporto"));
		destinos.setPromocao(Float.parseFloat(request.getParameter("promocao")));
		
		udao.update(destinos);
		
		response.sendRedirect("destinos");
	}
	
	protected void removeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_destino = Integer.parseInt(request.getParameter("id_destino"));
		udao.removeById(id_destino);
		
		response.sendRedirect("destinos");
		
	}
}











