package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud_dao.ClientesDAO;
import model.Clientes;

@WebServlet(urlPatterns = { "/clientes", "/clientes-create", "/cadastroclientes-create", "/clientes-update", "/clientes-edit", "/clientes-delete" })
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientesDAO udao = new ClientesDAO();
	Clientes clientes = new Clientes();

	public ClienteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/clientes":
			getCliente(request, response);
			break;

		case "/clientes-create":
			save(request, response);
			response.sendRedirect("clientes");
			break;

		case "/cadastroclientes-create":
			edit(request, response);
			response.sendRedirect("cadastrosucesso.html");
			break;

		case "/clientes-edit":
			edit(request, response);
			break;

		case "/clientes-update":
			update(request, response);
			break;

		case "/clientes-delete":
			removeById(request, response);
			break;

		default:
			response.sendRedirect("cadastro.html");
			break;
		}

	}

	protected void getCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Clientes> lista = udao.getCliente();

		request.setAttribute("listaClientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listacliente.jsp");
		rd.forward(request, response);
	}

	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clientes.setNome(request.getParameter("nome"));
		clientes.setCpf(request.getParameter("cpf"));
		clientes.setData_nascimento(request.getParameter("data_nascimento"));
		clientes.setEmail(request.getParameter("email"));
		clientes.setTelefone(request.getParameter("telefone"));
		clientes.setEndereco(request.getParameter("endereco"));
		clientes.setSenha(request.getParameter("senha"));

		udao.save(clientes);

	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		
		clientes = udao.clientesById(id_cliente);
		
		request.setAttribute("clientes", clientes);
		
		RequestDispatcher rd = request.getRequestDispatcher("editarcliente.jsp");
		rd.forward(request, response);

	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		clientes.setNome(request.getParameter("nome"));
		clientes.setCpf(request.getParameter("cpf"));
		clientes.setData_nascimento(request.getParameter("data_nascimento"));
		clientes.setEmail(request.getParameter("email"));
		clientes.setTelefone(request.getParameter("telefone"));
		clientes.setEndereco(request.getParameter("endereco"));
		clientes.setSenha(request.getParameter("senha"));
		
		udao.update(clientes);
		
		response.sendRedirect("clientes");
	}

	protected void removeById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		udao.removeById(id);

		response.sendRedirect("clientes");

	}
}
