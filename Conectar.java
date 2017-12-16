import java.sql.*;
public abstract class Conectar {
	public static String status="";
	
	public static Connection getConnection() {
		Connection cn = null;
		try{
			String banco   = "Consulta";
			String url     = "jdbc:mysql://192.241.230.235:3306/" + banco;
			String usuario = "demolidor";
			String senha   = "pipoka";
			
			Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
			cn = DriverManager.getConnection( url ,usuario , senha);
			
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

}