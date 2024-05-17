package com.google.gwt.personal.tupracticalpieces.client.common;  
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
/**
 * The interface for the RPC server endpoint to get school calendar information.
 */
@RemoteServiceRelativePath("adminsvc")
public interface AdminSvc extends RemoteService {
	ResultSvc dispatchMileageData(int startRow, int rowCount);
}
