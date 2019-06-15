import java.sql.*;

public class DB_Connect {
	private static Connection dbTest;
	
	DB_Connect(){
		connectDB();
	}
	private void connectDB(){
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			dbTest = DriverManager.getConnection("jdbc:oracle:thin:"+"@localhost:1521:XE","database","database");
			System.out.println("데이터 베이스에 연결 되었습니다.");
			
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("데이터 베이스에 연결에 실패하였습니다.");
			System.out.println("SQLException:"+e);
		} catch (Exception e){
			System.out.println("Exception:"+e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DB_Connect();
		Test1 t1 = new Test1();
		try{
			dbTest.close();
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQLException:"+ e);
		}
		

	}

}
