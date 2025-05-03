package farmacia;

import java.io.IOException;
import java.util.Scanner;

import farmacia.controller.ProdutoController;
import farmacia.model.Cosmetico;
import farmacia.model.Medicamento;
import farmacia.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		ProdutoController produtos = new ProdutoController();

		int opcao, id, tipo;
		String nome, generico, fragancia;
		float preco;

		Medicamento m1 = new Medicamento(123, "Dipirona", 1, 120.00f, "Não");
		produtos.criarProduto(m1);
		Cosmetico c1 = new Cosmetico(2, "Sabonete", 2, 15.00f, "Lavanda");
		produtos.criarProduto(c1);

		while (true) {

			System.out.println(Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_RED_BOLD
					+ "\n█ﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩـ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨٨ـﮩ█");
			System.out.println("█                                                   █");
			System.out.println("█                 PHARMACIA COM PH                  █");
			System.out.println("█                                                   █");
			System.out.println("█ﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩـ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨٨ـﮩ█");
			System.out.println("█                                                   █");
			System.out.println("█           1 - Cadastrar Produto                   █");
			System.out.println("█           2 - Listar Todos os Produtos            █");
			System.out.println("█           3 - Consultar Produto por ID            █");
			System.out.println("█           4 - Atualizar Produto                   █");
			System.out.println("█           5 - Deletar Produto        	            █");
			System.out.println("█           6 - Sair                                █");
			System.out.println("█                                                   █");
			System.out.println("█ﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩـ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨ـﮩﮩ٨ـﮩ٨٨ـﮩ█");
			System.out.println("█Entre com a opção desejada:                        █");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 6) {
				System.out.println("\nPHARMARCIA COM PH - Agredece pela sua colaboração");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");

				System.out.println("Digite o nome do Produto:");
				leia.skip("\\R");
				nome = leia.nextLine();
				System.out.println("Digite tipo do produto (1 - Medicamento | 2 - Cosmetico:");
				tipo = leia.nextInt();

				System.out.println("Digite o Preço do Produto:");
				preco = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Medicamento Generico?");
					generico = leia.next();
					produtos.criarProduto(new Medicamento(produtos.gerarId(), nome, tipo, preco, generico));
				}
				case 2 -> {
					System.out.println("Qual é a Fragancia");
					fragancia = leia.next();
					produtos.criarProduto(new Cosmetico(produtos.gerarId(), nome, tipo, preco, fragancia));
				}

				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os produtos \n");
				produtos.listarTodos();
				
				keyPress();
				break;
			case 3:
				System.out.println("Produto por ID\n\n");
				System.out.println("Digite o numero do ID: ");
				id = leia.nextInt();
				
				produtos.consultarPorId(id);

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar Produto\n");

				keyPress();
				break;
			case 5:
				System.out.println("Apagar Produto\n");

				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n***********************************************************");
		System.out.println("Projeto Desenvolvido por:Felipe da Silva Peronica Ferreira   ");
		System.out.println("Felipe Peronica - felipeperonica@gmail.com                   ");
		System.out.println("https://github.com/feperonica/                               ");
		System.out.println("***********************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.err.println("Ocorreu um erro ao tentar ler o teclado");

		}
	}

}
