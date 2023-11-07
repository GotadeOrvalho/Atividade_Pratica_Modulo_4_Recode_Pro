package console_main;

import java.util.Scanner;

import crud_dao.ClientesDAO;
import crud_dao.PassagensDAO;
import crud_dao.DestinosDAO;
import model.Clientes;
import model.Destinos;
import model.Passagens;

public  class PassagensMain {
	
	public static void Passagens(String[] args) {
		Scanner teclado = new Scanner(System.in);
		PassagensDAO passagensDAO = new PassagensDAO();
		ClientesDAO clientesDAO = new ClientesDAO();
		DestinosDAO destinosDAO = new DestinosDAO();
		
		Passagens passagens = new Passagens();
		//Destinos destinos = new Destinos();
		
		
		int menu;
		
		System.out.println("========== PASSAGENS ==========");
		System.out.println("1 - Cadastrar passagem");
		System.out.println("2 - Remover passagem");
		System.out.println("3 - Atualizar passagem");
		System.out.println("4 - Mostrar passagens");
		System.out.println("5 - Buscar passagem por Id");
		System.out.println("0 - Voltar");
		menu = teclado.nextInt();
		teclado.nextLine();
		switch (menu) {
		case 1:
			System.out.println("________________________________");
			System.out.println("1 - Cadastrar passagem");
			System.out.println(" ");

			System.out.println("Digite o Id do cliente:");
			Clientes clientes = clientesDAO.clientesById(teclado.nextInt());
			passagens.setFk_cliente_id_cliente(clientes);

			System.out.println("Digite o Id do destino:");
			Destinos destinos1 = destinosDAO.destinosById(teclado.nextInt());
			passagens.setFk_id_destino(destinos1);

			System.out.println("Digite o número de vôo:");
			passagens.setNum_voo(teclado.nextInt());

			teclado.nextLine();
			
			System.out.println("Digite o assento:");
			passagens.setAssento(teclado.nextLine());

			System.out.println("Digite a data e a hora do vôo (XX/XX/XXXX - XX:XXh):");
			passagens.setData_hora(teclado.nextLine());
			
			System.out.println("Digite o valor:");
			passagens.setValor(teclado.nextFloat());	
			
			System.out.println("Cadastro realizado com sucesso!");

			passagensDAO.save(passagens);

			PassagensMain.Passagens(args);
			break;
		case 2:
			System.out.println("________________________________");
			System.out.println("2 - Remover passagem");
			System.out.println(" ");

			System.out.println("Digite o Id da passagem que sera deletado:");
			passagensDAO.removeById(teclado.nextInt());

			System.out.println("Passagem removida com sucesso!");
			PassagensMain.Passagens(args);
			break;
		case 3:
			System.out.println("________________________________");
			System.out.println("3 - Atualizar passagem");
			System.out.println(" ");

			System.out.println("Digite o Id da passagem:");
			passagens.setId_passagem(teclado.nextInt());

			teclado.nextLine();

		    System.out.println("Digite o Id do cliente:");
			Clientes clientes1 = clientesDAO.clientesById(teclado.nextInt());
			passagens.setFk_cliente_id_cliente(clientes1);

			System.out.println("Digite o Id do destino:");
			Destinos destinos2 = destinosDAO.destinosById(teclado.nextInt());
			passagens.setFk_id_destino(destinos2);

			System.out.println("Digite o número de vôo:");
			passagens.setNum_voo(teclado.nextInt());
			
			System.out.println("Digite o assento:");
			passagens.setAssento(teclado.nextLine());
			
			System.out.println("Digite a data e a hora do vôo (XX/XX/XXXX - XX:XXh):");
			passagens.setData_hora(teclado.nextLine());

			System.out.println("Digite o valor:");
			passagens.setValor(teclado.nextFloat());
			
			System.out.println("Passagem atualizada com sucesso!");

			passagensDAO.update(passagens);
			PassagensMain.Passagens(args);
			break;

		case 4:
			System.out.println("===============================");
			System.out.println("4 - Mostrar passagens");
			System.out.println(" ");

			for (Passagens c : passagensDAO.getPassagem()) {

				System.out.println("Id: " + c.getId_passagem());

				System.out.println("Id do cliente: " + c.getFk_cliente_id_cliente().getId_cliente());
				int idCliente = c.getFk_cliente_id_cliente().getId_cliente();
        		String nomeCliente = clientesDAO.getNomeClienteById(idCliente);
				System.out.println("Nome: " + nomeCliente);

				System.out.println("Id do destino: " + c.getFk_id_destino().getId_destino());
				int idDestino = c.getFk_id_destino().getId_destino();
        		String nomeDestino = destinosDAO.getDestinoNomeById(idDestino);
				System.out.println("Destino: " + nomeDestino);

				System.out.println("Número do vôo: " + c.getNum_voo());

				System.out.println("Assento: " + c.getAssento());

				System.out.println("Data e hora de embarque: "+ c.getData_hora());

				c.aplicarPromocao(destinosDAO.destinosById(idDestino));

				System.out.println("Valor: "+ c.getValor());

				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			PassagensMain.Passagens(args);
			break;
		case 5:
			System.out.println("________________________________");
			System.out.println("5 - Buscar passagem por Id");
			System.out.println(" ");

			System.out.println("Digite o Id da passagem:");
			int id_passagem = teclado.nextInt();
			
			Passagens c = passagensDAO.passagensById(id_passagem);
			System.out.println("Id: " + c.getId_passagem());

				System.out.println("Id do cliente: " + c.getFk_cliente_id_cliente().getId_cliente());
				int idCliente = c.getFk_cliente_id_cliente().getId_cliente();
        		String nomeCliente = clientesDAO.getNomeClienteById(idCliente);
				System.out.println("Nome: " + nomeCliente);

				System.out.println("Id do destino: " + c.getFk_id_destino().getId_destino());
				int idDestino = c.getFk_id_destino().getId_destino();
        		String nomeDestino = destinosDAO.getDestinoNomeById(idDestino);
				System.out.println("Destino: " + nomeDestino);

				System.out.println("Número do vôo: " + c.getNum_voo());

				System.out.println("Assento: " + c.getAssento());

				System.out.println("Data e hora de embarque: "+ c.getData_hora());

				System.out.println("Valor: "+ c.getValor());
			System.out.println("===============================");
			PassagensMain.Passagens(args);
			break;
		case 0:
			System.out.println("________________________________");
			System.out.println("0 - Voltar");
			System.out.println(" ");
			System.out.println("você escolheu voltar para o menu");
			ConsoleMain.main(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			PassagensMain.Passagens(args);
			break;
		}
		teclado.close();
	}
}
