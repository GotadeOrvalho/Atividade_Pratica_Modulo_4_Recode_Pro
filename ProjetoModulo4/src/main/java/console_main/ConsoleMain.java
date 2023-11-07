package console_main;

import java.util.Scanner;

public class ConsoleMain{

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int menu;

		System.out.println("========== MENU ==========");
		System.out.println("1 - Clientes");
		System.out.println("2 - Destinos");
		System.out.println("3 - Passagem");
		System.out.println("0 - Sair");

		menu = teclado.nextInt();
		switch (menu) {
		case 1:
			ClientesMain.Clientes(args);
			break;
		case 2:
			DestinosMain.Destinos(args);
			break;
		case 3:
			PassagensMain.Passagens(args);
			break;
		case 0:
			System.out.println("Ate logo!");
			break;
		default:
			System.out.println("Opcao invalida!");
			ConsoleMain.main(args);
		}
		teclado.close();
	}
}