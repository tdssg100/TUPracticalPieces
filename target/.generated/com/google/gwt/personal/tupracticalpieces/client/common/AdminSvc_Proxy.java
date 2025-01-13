package com.google.gwt.personal.tupracticalpieces.client.common;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class AdminSvc_Proxy extends RemoteServiceProxy implements com.google.gwt.personal.tupracticalpieces.client.common.AdminSvcAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.google.gwt.personal.tupracticalpieces.client.common.AdminSvc";
  private static final String SERIALIZATION_POLICY ="2937272FBB208BAA6CB5F5AABA0C9E27";
  private static final com.google.gwt.personal.tupracticalpieces.client.common.AdminSvc_TypeSerializer SERIALIZER = new com.google.gwt.personal.tupracticalpieces.client.common.AdminSvc_TypeSerializer();
  
  public AdminSvc_Proxy() {
    super(GWT.getModuleBaseURL(),
      "adminsvc", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void dispatchMileageData(int startRow, int rowCount, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("AdminSvc_Proxy", "dispatchMileageData");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeInt(startRow);
      streamWriter.writeInt(rowCount);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
