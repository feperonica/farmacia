package farmacia.controller;

import java.util.ArrayList;
import java.util.Scanner;

import farmacia.model.Produto;
import farmacia.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	// Criação da Collection ArrayList
	private ArrayList<Produto> listaProduto = new ArrayList<>();
	private Scanner leia = new Scanner(System.in);
	
	// Variavel para controlar o ID dos produtos
	int id = 0;

	@Override
	public void criarProduto(Produto produto) {
		listaProduto.add(produto);
		System.out.printf("\nProduto cadastrado com sucesso!");
	}

	@Override
	public void listarTodos() {
		for (Produto produto : listaProduto) {
			produto.visualizar();
		}
	}

	@Override
	public void consultarPorId(int id) {
		Produto produto = buscaNaCollection(id);

		if (produto != null)
			produto.visualizar();
		else
			System.out.printf("\nProduto com ID %d não foi encontrado.\n", id);
	}

	@Override
	public void atualizarProduto(int id) {
		Produto produto = buscaNaCollection(id);

		if (produto != null) {
			System.out.print("Novo nome: ");
			leia.nextLine(); // limpeza do buffer
			produto.setNome(leia.nextLine());

			System.out.print("Novo tipo (1 - Medicamento | 2 - Cosmético): ");
			produto.setTipo(leia.nextInt());

			System.out.print("Novo preço: ");
			produto.setPreco(leia.nextFloat());

			System.out.println("Produto atualizado com sucesso!");
		} else {
			System.out.println("Produto não encontrado.");
		}
	}

	@Override
	public void deletarProduto(int id) {
		Produto produto = buscaNaCollection(id);

		if (produto != null) {
			listaProduto.remove(produto);
			System.out.println("Produto removido com sucesso!");
		} else {
			System.out.println("Produto não encontrado.");
		}
	}
	
	public int gerarId() {
		return ++ id;
	}

	// Método auxiliar
	public Produto buscaNaCollection(int id) {
		for (Produto produto : listaProduto) {
			if (produto.getId() == id)
				return produto;
		}
		return null;
	}

}