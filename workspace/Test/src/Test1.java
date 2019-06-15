import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test1 {
	private String username="database";
	private String password="database";
	private static Connection dbTest;
	
	Test1(){
		connectDB();	
	}
	private void connectDB(){
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			dbTest=DriverManager.getConnection("jdbc:oracle:thin:"+"@localhost:1521:XE",username,password);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQLException:"+e);
		}catch(Exception e){
			System.out.println("Exception:"+e);
			
		}
	}
	private void execute_query()throws SQLException{
		String sqlStr = "SELECT avg(speed) FROM PC";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr); 
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			System.out.println("avg(speed): "+rs.getString("avg(speed)"));
		} 
		rs.close();
		stmt.close();
	}
	private void execute_query2()throws SQLException{
		String sqlStr = "UPDATE PC set price = price -100 where price >=2000";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr); 
		String sqlStr2 = "SELECT price FROM PC where price>2000";
		PreparedStatement stmt2 = dbTest.prepareStatement(sqlStr2); 
		ResultSet rs = stmt2.executeQuery();
		while(rs.next()){
			System.out.println("price : "+rs.getString("price"));
		} 
		rs.close();
		stmt.close();
	}
	private void execute_query3()throws SQLException{
		String sqlStr = "SELECT model,speed,hd FROM PC WHERE price<1600";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr); 
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
	         System.out.println("model: "+rs.getString("model")+"speed: "+rs.getString("speed")+
	               "hd: "+rs.getString("hd"));}

		rs.close();
		stmt.close();
	}
	private void execute_query4()throws SQLException{
		String sqlStr = "SELECT model,speed,hd FROM pc WHERE (cd='8x' or cd='6x') and price<2000";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr); 
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
	         System.out.println("model: "+rs.getString("model")+"speed: "+rs.getString("speed")+
	               "hd: "+rs.getString("hd"));}

		rs.close();
		stmt.close();
	}private void execute_query5()throws SQLException{
		String sqlStr = "SELECT maker,speed FROM Laptop natural join Product WHERE hd>=1";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr); 
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
	         System.out.println("maker: "+rs.getString("maker")+"speed: "+rs.getString("speed"));}

		rs.close();
		stmt.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 t1 = new Test1();
		try{
			System.out.println("巩力1");
			t1.execute_query();
			System.out.println("巩力2");
			t1.execute_query2();

			System.out.println("巩力3");
			t1.execute_query3();
			System.out.println("巩力4");
			t1.execute_query4();
			System.out.println("巩力5");
			t1.execute_query5();
			
			dbTest.close();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQLException:"+e);
		}

	}

}