package farmacia.repository;

import farmacia.model.Produto;

public interface ProdutoRepository {

	// Métodos do CRUD (Create, Read, Update e Delete)
	public void criarProduto(Produto produto);
    public void listarTodos();
    public void consultarPorId(int id);
    public void atualizarProduto(int id);
    public void deletarProduto(int id);

}
