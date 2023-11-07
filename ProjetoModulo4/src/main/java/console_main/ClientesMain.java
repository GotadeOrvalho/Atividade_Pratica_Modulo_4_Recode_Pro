package console_main;

import java.util.Scanner;

import crud_dao.ClientesDAO;
import model.Clientes;

public  class ClientesMain {
	
	public static void Clientes(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ClientesDAO clientesDAO = new ClientesDAO();
		
		Clientes clientes = new Clientes();
		
		int menu;
		
		System.out.println("========== CLIENTE ==========");
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Remover cliente");
		System.out.println("3 - Atualizar cliente");
		System.out.println("4 - Mostrar clientes");
		System.out.println("5 - Buscar cliente por Id");
		System.out.println("0 - Voltar");
		menu = teclado.nextInt();
		teclado.nextLine();
		switch (menu) {
		case 1:
			System.out.println("_________________________________");
			System.out.println("1 - Cadastrar cliente");
			System.out.println(" ");

			System.out.println("Digite o nome:");
			clientes.setNome(teclado.nextLine());

			System.out.println("Digite o CPF:(xxx.xxx.xxx-xx)");
			clientes.setCpf(teclado.nextLine());
			
			System.out.println("Digite a data de nascimento:(dd/mm/aaaa)");
			clientes.setData_nascimento(teclado.nextLine());
			
			System.out.println("Digite o telefone:((DDD) xxxxx-xxxx)");
			clientes.setTelefone(teclado.nextLine());
			
			System.out.println("Digite o endereço:");
			clientes.setEndereco(teclado.nextLine());
			
			System.out.println("Digite o email:");
			clientes.setEmail(teclado.nextLine());
			
			System.out.println("Digite a senha:");
			clientes.setSenha(teclado.nextLine());

			System.out.println("Cadastro concluído com sucesso!");
			
			clientesDAO.save(clientes);

			ClientesMain.Clientes(args);
			break;
		case 2:
			System.out.println("_________________________________");
			System.out.println("2 - Remover cliente");
			System.out.println(" ");

			System.out.println("Digite o Id do cliente que sera deletado:");
			clientesDAO.removeById(teclado.nextInt());

			System.out.println("Cliente removido com sucesso!");

			ClientesMain.Clientes(args);
			break;
		case 3:
			System.out.println("_________________________________");
			System.out.println("3 - Atualizar cliente");
			System.out.println(" ");

			System.out.println("Digite o Id:");
			clientes.setId_cliente(teclado.nextInt());
			
			System.out.println("Digite o nome:");
			teclado.nextLine();
			clientes.setNome(teclado.nextLine());

			System.out.println("Digite o CPF:(xxx.xxx.xxx-xx)");
			clientes.setCpf(teclado.nextLine());
			
			System.out.println("Digite a data de nascimento:(dd/mm/aaaa)");
			clientes.setData_nascimento(teclado.nextLine());
			
			System.out.println("Digite o telefone:((DDD) xxxxx-xxxx)");
			clientes.setTelefone(teclado.nextLine());
			
			System.out.println("Digite o endereço:");
			clientes.setEndereco(teclado.nextLine());
			
			System.out.println("Digite o email:");
			clientes.setEmail(teclado.nextLine());
			
			System.out.println("Digite a senha:");
			clientes.setSenha(teclado.nextLine());

			System.out.println("Cliente atualizado com sucesso com sucesso!");

			clientesDAO.update(clientes);
			ClientesMain.Clientes(args);
			break;

		case 4:
			System.out.println("===============================");
			System.out.println("4 - Mostrar clientes");
			System.out.println(" ");

			for (Clientes c : clientesDAO.getCliente()) {
				System.out.println("Id: " + c.getId_cliente());
				System.out.println("Nome: " + c.getNome());
				System.out.println("CPF: " + c.getCpf());
				System.out.println("Data de Nascimento: " + c.getData_nascimento());
				System.out.println("Telefone: "+ c.getTelefone());
				System.out.println("Endereço: "+ c.getEndereco());
				System.out.println("Email: " + c.getEmail());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			ClientesMain.Clientes(args);
			break;
		case 5:
			System.out.println("_________________________________");
			System.out.println("5 - Buscar cliente por Id");
			System.out.println(" ");

			System.out.println("Digite o Id do cliente:");
			int id_cliente = teclado.nextInt();
			
			Clientes c = clientesDAO.clientesById(id_cliente);
			System.out.println("===============================");
			System.out.println("Id: " + c.getId_cliente());
			System.out.println("Nome: " + c.getNome());
			System.out.println("CPF: " + c.getCpf());
			System.out.println("Data de Nascimento: " + c.getData_nascimento());
			System.out.println("Telefone: "+ c.getTelefone());
			System.out.println("Endereço: "+ c.getEndereco());
			System.out.println("Email: " + c.getEmail());
			System.out.println("===============================");
			ClientesMain.Clientes(args);
			break;
		case 0:
			System.out.println("Você escolheu voltar para o menu.");
			ConsoleMain.main(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			ClientesMain.Clientes(args);
			break;
		}
		teclado.close();
	}
}