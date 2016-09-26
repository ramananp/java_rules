package databaseObjects;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.jpmchase.aata.services.exception.framework.AATABaseBusinessException;
import com.jpmchase.aata.services.exception.framework.AATABaseDatabaseException;

public class DelTktSQ {
	
	public void deleteTicket(String accountNo, String initiatorID)throws AATABaseBusinessException, AATABaseDatabaseException {
		
		Connection con = null;
		CallableStatement callableStatement = null;
		String sql = "{call sp_at_del}";
		
		try {
			con = ConnectionManager.getConnection();			//Establish connection
			callableStatement = con.prepareCall(sql);
			
			callableStatement.setString(1, accountNo);
			callableStatement.setString(2, initiatorID);
			callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);

			callableStatement.executeUpdate();					//Execute Proc Query
			
		    Integer errorCode = callableStatement.getInt(3);
			String errorMessage = callableStatement.getString(4);
			
			System.out.println("ErrorCode : " + errorCode);
			System.out.println("ErrorMessage : " + errorMessage);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}