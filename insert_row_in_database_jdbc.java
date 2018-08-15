/*
create a program to insert a row in database using jdbc
*/

public void insertRow(){
	
	try{
		//register the driver
		Driver driver = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		//OR can be done using following way
		//Class.forName("com.mysql.jdbc.Driver");
		
		//create connection
		String url="";
		String username="";
		String password="";
		
		Connection conn = DriverManager.getConnection(url,username,password);
		
		//create statement
		Statement stmt = conn.createStatement();
		String sql ="INSERT INTO table1(name, address) VALUES ('abcname','defaddress')";
		
		//execute statement
		stmt.executeUpdate(sql);
		
		//close connection, statement
	}
	catch(SQLException se){
	}
	catch(Exception e){		
	}
	finally{
		stmt.close();
		conn.close();
	}
}