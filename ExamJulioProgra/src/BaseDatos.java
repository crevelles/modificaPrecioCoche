import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatos {

	
	private String surl = "jdbc:oracle:thin:@localhost:1521:XE";
	public Connection conexion;

	public BaseDatos() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(surl, "integrador", "integrador");
			System.out.println(" -Conexión con ORACLE establecida -");

			//conexion.close();
		} catch (Exception e) {
			System.out.println(" –Error de Conexión con ORACLE -");
			e.printStackTrace();
		}
	}

	public void cerrarBaseDatos() {
		try {
			conexion.close();
			System.out.println("BBDD cerrada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cerrar BBDD");
			e.printStackTrace();
		}
	}
	
	
	public void cargarVehiculos(ArrayList<Coche> coches){
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM COCHESS";
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				Coche c = new Coche();
				c.setMarca(rset.getString("MARCA"));
				c.setMatricula(rset.getString("MATRICULA"));
				c.setModelo(rset.getString("MODELO"));
				c.setPrecio(rset.getInt("PRECIO"));
				coches.add(c);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean vehiculoEncntrado(String matricula){
		try {
			ArrayList<Coche> coches = new ArrayList<>();
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM COCHESS WHERE MATRICULA ='"+matricula+"'";
			System.out.println(select);
			ResultSet rset = stmt.executeQuery(select);
			Coche c = new Coche();
			while(rset.next()){
				c.setMatricula(rset.getString("MATRICULA"));
				c.setMarca(rset.getString("MARCA"));
				c.setModelo(rset.getString("MODELO"));
				c.setPrecio(rset.getInt("PRECIO"));
				coches.add(c);
			}
			rset.close();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}



	public boolean modificaPrecio(String matricula, int precio) {
		try {
			Statement stmt = conexion.createStatement();
			String update = "UPDATE COCHESS SET PRECIO = " + precio + " WHERE MATRICULA = '"+matricula+"'";
			System.out.println(update);
			ResultSet rset = stmt.executeQuery(update);
			rset.close();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
}
