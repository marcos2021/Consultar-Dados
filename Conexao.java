import java.sql.*;

public class Conexao {
	public static String status="";
	public static Connection cn = null;

	public static Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver" ;
		String ip = "192.241.230.235:3306";
		String usuario = "demolidor" ;
		String senha   = "pipoka" ;
		String banco   = "Consulta" ;
		
		try{
			Class.forName(driver).newInstance();
			String url="jdbc:mysql://"+ip+"/"+ banco+"?user="+usuario+"&password="+senha;

//			String url="jdbc:mysql://127.0.0.1/banco?user=root&password=";

			cn = DriverManager.getConnection(url);
			status = "Conexão Aberta";
		}catch(SQLException e){
			status =  e.getMessage();
		}catch(ClassNotFoundException e){
			status =  e.getMessage();
		}catch(Exception e){
			status =  e.getMessage();
		}
		return cn;
	}

	public static void fecharConexao(){
		try {
			cn.close();
		} catch (SQLException e) {
		}
	}
}