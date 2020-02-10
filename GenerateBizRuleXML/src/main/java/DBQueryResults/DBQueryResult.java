package DBQueryResults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQueryResult {

	
	public String HumanDBqueryResultProvisionFileName(String FileName)
	{  	  		
			String result="";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
		String TestconnString ="jdbc:oracle:thin:@(DESCRIPTION =    (ADDRESS = (PROTOCOL = TCP)(HOST = test-cp-cluster-scan.emea.eu.int)(PORT = 1570))    (CONNECT_DATA =      (SERVER = DEDICATED)      (SERVICE_NAME = PHV08_TEST.emea.eu.int)    )  )";
		Connection con=null;
		try {
			con = DriverManager.getConnection(TestconnString,"Phvreader", "AZiw9yXj");
		} catch (SQLException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
	

		Statement stmt=null;;
		try {
			stmt = con.createStatement();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		String Query=
				 " select a.error_message_comment from "+
                 " icsr.safety_report_message sfm "+
                 " LEFT OUTER JOIN ICSR.SAFETY_REPORT_ACK A on a.safety_report_message_id=sfm.safety_report_message_id "+
                 " where sfm.message_identifier='"+FileName+"'"+
				 " and sfm.SAFETY_REPORT_MESSAGE_ID =( select max(SAFETY_REPORT_MESSAGE_ID) from icsr.safety_report_message where message_identifier='"+FileName+"')"+
				 " and sfm.created_on >=  '06-FEB-20 14.00.19.556000000'";
				 		
		ResultSet rs=null;
		try {
			rs = stmt.executeQuery(Query);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}  
		try {
			while(rs.next())  
			result=rs.getString(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("=========================================================================================================");
		System.out.println(FileName);
		System.out.println(result);
		return result;
	}
	
}
 
