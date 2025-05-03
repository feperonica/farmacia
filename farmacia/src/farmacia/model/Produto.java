package farmacia.model;

import java.text.NumberFormat;

public abstract class Produto {

	// Atributos da Classe
	private int id;
	private String nome;
	private int tipo;
	private float preco;

	// Método Construtor
	public Produto(int id, String nome, int tipo, float preco) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.tipo = tipo;
		this.preco = preco;
	}

	public Produto() {
	}

	// Métodos Get e Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	// Métodos para visualizar os produtos
	public void visualizar() {

		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

		String tipo = "";

		switch (this.tipo) {
		case 1 -> tipo = "Medicamento";
		case 2 -> tipo = "Cosmético";
		default -> tipo = "Invalido";

		}

		System.out.println("********************************");
		System.out.println("DADOS DO PRODUTO					");
		System.out.println("********************************");
		System.out.println("ID do produto: " + this.id);
		System.out.println("Nome do Produto: " + this.nome);
		System.out.println("Tipo: " + tipo);
		System.out.println("Preço: " + nfMoeda.format(this.preco));

	}
}