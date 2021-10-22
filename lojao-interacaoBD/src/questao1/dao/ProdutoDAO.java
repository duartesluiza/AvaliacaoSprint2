package questao1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import questao1.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvarProduto(Produto produto) throws SQLException {

		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, DESCONTO, DATA_INICIO, DATA_FIM) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setString(3, produto.getDesconto());
			pstm.setString(4, produto.getDataInicio());
			pstm.setString(5, produto.getDataFim());

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));

				}
			}
		}

	}

	public void editarProduto(Produto produto) throws SQLException {


		String sql = "UPDATE PRODUTO SET NOME = ?, DESCRICAO = ?, DESCONTO = ?, DATA_INICIO = ?, DATA_FIM = ? WHERE PRODUTO.ID = ?";
		
		
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setString(3, produto.getDesconto());
			pstm.setString(4, produto.getDataInicio());
			pstm.setString(5, produto.getDataFim());
			pstm.setInt(6, produto.getId());

			pstm.execute();

	
		}

	}
	
	public void deletarProduto(Integer produtoId) throws SQLException {
		// "didinha = pelido para chamar a tabela
		String sql = "DELETE FROM PRODUTO as didinha WHERE didinha.ID = "+produtoId;
		
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			pstm.execute();
			
		}
		
	}

	public List<Produto> listarProdutos() throws SQLException {

		String sql = "SELECT * FROM PRODUTO";

		List<Produto> produtos = new ArrayList<>();

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.execute();
			ResultSet rst = pstm.getResultSet();

			while (rst.next()) {
				
				Produto p = new Produto();
				
				
				p.setId(Integer.valueOf(rst.getString(1)));
				p.setNome(rst.getString(2));
				p.setDescricao(rst.getString(3));
				p.setDesconto(rst.getString(4));
				p.setDataInicio(rst.getString(5));
				p.setDataFim(rst.getString(6));
				
				
				produtos.add(p);
				

				
			}
		}

		return produtos;

	}

}

