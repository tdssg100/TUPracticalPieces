package com.google.gwt.personal.tupracticalpieces.client.common;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The interface for the RPC server endpoint to get school calendar information.
 */
public interface AdminTaskAsync {
	void fetchMileageData(String postParam, AsyncCallback<ResultFetch> callback);
	void saveJobName(String postParam, AsyncCallback<ResultFetch> callback);
}
