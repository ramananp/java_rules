package databaseObjects;

import com.jpmchase.aata.services.exception.framework.AATABaseBusinessException;
import com.jpmchase.aata.services.exception.framework.AATABaseDatabaseException;

public class ExecuteProc {
	
	public static void main(String[] args) throws AATABaseBusinessException, AATABaseDatabaseException {
		// TODO Auto-generated method stub
		DelTktSQ delTktSQ = new DelTktSQ();
		delTktSQ.deleteTicket("A00028000", "U041098");
	}

}
