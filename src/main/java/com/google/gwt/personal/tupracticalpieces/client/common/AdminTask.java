package com.google.gwt.personal.tupracticalpieces.client.common;
  
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
  
/**
 * The interface for the RPC server endpoint to get school calendar information.
 */
@RemoteServiceRelativePath("admintask")
public interface AdminTask extends RemoteService {
	ResultFetch fetchMileageData(String postParam);
	ResultFetch saveJobName(String postParam);
	ResultFetch getJobName(String postParam); //202406
}
