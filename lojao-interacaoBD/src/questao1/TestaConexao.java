package questao1;
import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionDB connectionFactory = new ConnectionDB();
		Connection connection = connectionFactory.recuperarConexao();
		
		System.out.println("Conexão encerrada!");
		
		connection.close();
	}

}
