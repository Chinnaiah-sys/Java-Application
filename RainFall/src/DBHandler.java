import java.sql.Connection;

public class DBHandler {


	public Connection establishConnection() {

		
		 Connection con=null;
		try {
 			FileInputStream file=new FileInputStream("db.properties");
 			Properties prop=new Properties();
 			prop.load(file);
 			String drive=(String)prop.get("db.classname");
			String url=(String)prop.get("db.url");
			String name=(String)prop.get("db.username");
			String pass=(String)prop.get("db.password");
			Class.forName(drive);
			con =DriverManager.getConnection(url,name,pass);
			System.out.println("Connection Established");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
 		}
 	return con;

	}
}
