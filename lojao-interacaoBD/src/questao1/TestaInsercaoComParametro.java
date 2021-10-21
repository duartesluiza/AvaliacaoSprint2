package questao1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
	
		ConnectionDB connectionDB = new ConnectionDB();
		try(Connection connection = connectionDB.recuperarConexao()){

		connection.setAutoCommit(false); // CONTROLA A MINHA TRANSACAO

		try (PreparedStatement stm = connection.prepareStatement(
				"INSERT INTO PRODUTO (nome, descricao, desconto, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);
				){
			// Quando executar o INSERT, quero que me retorne o ID gerado.

			adicionarVariavel("BAZINGS", "BazingS WPS", "01", "2021-12-10", "2021-12-23", stm);
			adicionarVariavel("TABLET", "TABLET Multilaser", "01", "2021-10-27", "2021-12-23", stm);
			adicionarVariavel("CADEIRA", "CADEIRA GAMER", "01", "2021-10-10", "2021-11-30", stm);

			connection.commit(); // quando tudo tiver "ok", entao pode seguir com a trasancao

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback(); // GARANTO QUE A TRANSACAO OU ADICIONA TODOO MUNDO OU NAO ADICIONA NINGUEM
		}
	}

	}

	private static void adicionarVariavel(String nome, String descricao, String desconto, String dataInicio,
			String dataFim, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.setString(3, desconto);
		stm.setString(4, dataInicio);
		stm.setString(5, dataFim);

		if (nome.equals("Play")) {

			throw new RuntimeException("Não foi possivel adicionar o produto");
		}

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
	}

}
