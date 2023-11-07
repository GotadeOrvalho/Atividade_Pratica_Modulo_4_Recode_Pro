package console_main;

import java.util.Scanner;

import crud_dao.DestinosDAO;
import model.Destinos;

public  class DestinosMain {
	
	public static void Destinos(String[] args) {
		Scanner teclado = new Scanner(System.in);
		DestinosDAO destinosDAO = new DestinosDAO();
		
		Destinos destinos = new Destinos();
		
		int menu;
		
		System.out.println("========== Destinos ==========");
		System.out.println("1 - Cadastrar destino");
		System.out.println("2 - Remover destino");
		System.out.println("3 - Atualizar destino");
		System.out.println("4 - Mostrar destinos");
		System.out.println("5 - Buscar destino por Id");
		System.out.println("0 - Voltar");
		menu = teclado.nextInt();
		teclado.nextLine();
		switch (menu) {
		case 1:
			System.out.println("_____________________________");
			System.out.println("1 - Cadastrar destino");
			System.out.println(" ");

			System.out.println("Digite a cidade:");
			destinos.setCidade(teclado.nextLine());

			System.out.println("Digite o estado:");
			destinos.setEstado(teclado.nextLine());
			
			System.out.println("Digite o pais:");
			destinos.setPais(teclado.nextLine());
			
			System.out.println("Digite o aeroporto:");
			destinos.setAeroporto(teclado.nextLine());

			System.out.println("Digite a promoção em porcentagem %:");
			destinos.setPromocao(teclado.nextFloat());
			
			destinosDAO.save(destinos);

			DestinosMain.Destinos(args);
			break;
		case 2:
			System.out.println("_____________________________");
			System.out.println("2 - Remover destino");
			System.out.println(" ");

			System.out.println("Digite o Id do destino que sera deletado:");
			destinosDAO.removeById(teclado.nextInt());
			DestinosMain.Destinos(args);
			break;
		case 3:
			System.out.println("_____________________________");
			System.out.println("3 - Atualizar destino");
			System.out.println(" ");

			System.out.println("Digite o Id:");
			destinos.setId_destino(teclado.nextInt());
			
			teclado.nextLine();

			System.out.println("Digite a cidade:");
			destinos.setCidade(teclado.nextLine());

			System.out.println("Digite o estado:");
			destinos.setEstado(teclado.nextLine());
			
			System.out.println("Digite o pais:");
			destinos.setPais(teclado.nextLine());
			
			System.out.println("Digite o aeroporto:");
			destinos.setAeroporto(teclado.nextLine());
			
			System.out.println("Digite a promoção em porcentagem %:");
			destinos.setPromocao(teclado.nextFloat());

			destinosDAO.update(destinos);
			DestinosMain.Destinos(args);
			break;

		case 4:
			System.out.println("===============================");
			System.out.println("4 - Mostrar destinos");
			System.out.println(" ");

			for (Destinos c : destinosDAO.getDestino()) {
				System.out.println("Id: " + c.getId_destino());
				System.out.println("Cidade: " + c.getCidade());
				System.out.println("Estado: " + c.getEstado());
				System.out.println("País: " + c.getPais());
				System.out.println("Aeroporto: "+ c.getAeroporto());
				System.out.println("Promoção em porcentagem %: " + c.getPromocao());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			DestinosMain.Destinos(args);
			break;
		case 5:
			System.out.println("_____________________________");
			System.out.println("5 - Buscar destino por Id");
			System.out.println(" ");

			System.out.println("Digite o Id do destino:");
			int id_destino = teclado.nextInt();
			
			Destinos c = destinosDAO.destinosById(id_destino);
			System.out.println("===============================");
			System.out.println("Id: " + c.getId_destino());
			System.out.println("Cidade: " + c.getCidade());
			System.out.println("Estado: " + c.getEstado());
			System.out.println("País: " + c.getPais());
			System.out.println("Aeroporto: "+ c.getAeroporto());
			System.out.println("Promoção em porcentagem %: " + c.getPromocao());
			System.out.println("----------------------------------- ");
			
			DestinosMain.Destinos(args);
			break;
		case 0:
			System.out.println("_____________________________");
			System.out.println("Você escolheu voltar para o menu.");
			ConsoleMain.main(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			DestinosMain.Destinos(args);
			break;
		}
		teclado.close();
	}
}
