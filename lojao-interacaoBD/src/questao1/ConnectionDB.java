package questao1;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionDB {

	public DataSource dataSource;
	
	public ConnectionDB() {
		//CP3OPO me dá esse poll de conexoes:
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/lojao?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("admin");
		
		// Vai carregar o POOL com 15 conexoes disponíveis:
		comboPooledDataSource.setMaxPoolSize(15);
		
		//"DataSource, expoe esse pool de conexpes pra minha aplicação
		this.dataSource = comboPooledDataSource;
	}
	//aqui, vai chegar uma requisicao de conexao, e essa conexao estará disponivel no POOL de CONEXOES!!
	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();
}
}
