package questao1;

import java.sql.Connection;
import java.sql.SQLException;

import questao1.dao.ProdutoDAO;
import questao1.modelo.Produto;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		 
		
		ConnectionDB connectionDB = new ConnectionDB();
		Connection connection = connectionDB.recuperarConexao();
		
	
		Produto p1 = new Produto("Smartkkk", "Polenguinho", "01", "2021-10-17", "2021-12-24");
		
		ProdutoDAO produtoDAO = new ProdutoDAO(connection);
		
		@SuppressWarnings("unused")
		Menu menu = new Menu(produtoDAO);
			
		produtoDAO.salvarProduto(p1);
		
		p1.setId(30);
		produtoDAO.editarProduto(p1);
//		
		
//		produtoDAO.deletarProduto(30);
		
		produtoDAO.listarProdutos();
		
	}
	
	


}
