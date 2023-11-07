package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud_dao.PassagensDAO;
import model.Passagens;
import model.Clientes;
import model.Destinos;


@WebServlet(urlPatterns = {"/passagens", "/passagens-create", "/passagens-update", "/passagens-edit", "/passagens-delete"})
public class PassagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PassagensDAO udao = new PassagensDAO();
    Passagens passagens = new Passagens();
    Clientes clientes = new Clientes();
    Destinos destinos = new Destinos();
   
    public PassagemServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch (action) {
		case "/passagens":
			 getPassagem(request, response);
			break;
			
		case "/passagens-create":
			 save(request, response);
			break;
			
		case "/passagens-edit":
			edit(request, response);
			break;

		case "/passagens-update":
			update(request, response);
			break;
			
		case "/passagens-delete":
			removeById(request, response);
			break;
		default:
			response.sendRedirect("listapassagem.html");
			break;
		}
		
	}

	protected void getPassagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Passagens> lista = udao.getPassagem();
		
		request.setAttribute("listaPassagens", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listapassagem.jsp");
		rd.forward(request, response);
	}
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        clientes.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
        passagens.setFk_cliente_id_cliente(clientes);
        destinos.setId_destino(Integer.parseInt(request.getParameter("id_destino")));
        passagens.setFk_id_destino(destinos);
		passagens.setNum_voo(Integer.parseInt(request.getParameter("num_voo")));
		passagens.setAssento(request.getParameter("assento"));
		passagens.setData_hora(request.getParameter("data_hora"));
		passagens.setValor(Float.parseFloat(request.getParameter("valor")));
		
		
		udao.save(passagens);
		
		response.sendRedirect("passagens");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_passagem = Integer.parseInt(request.getParameter("id_passagem"));
		
		passagens = udao.passagensById(id_passagem);
		
		request.setAttribute("passagens", passagens);
		
		RequestDispatcher rd = request.getRequestDispatcher("editarpassagem.jsp");
		rd.forward(request, response);

	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		clientes.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
        passagens.setFk_cliente_id_cliente(clientes);
        destinos.setId_destino(Integer.parseInt(request.getParameter("id_destino")));
        passagens.setFk_id_destino(destinos);
		passagens.setNum_voo(Integer.parseInt(request.getParameter("num_voo")));
		passagens.setAssento(request.getParameter("assento"));
		passagens.setData_hora(request.getParameter("data_hora"));
		passagens.setValor(Float.parseFloat(request.getParameter("valor")));
		
		udao.update(passagens);
		
		response.sendRedirect("passagens");
	}
	
	protected void removeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_passagem = Integer.parseInt(request.getParameter("id_passagem"));
		udao.removeById(id_passagem);
		
		response.sendRedirect("passagens");
		
	}
}











