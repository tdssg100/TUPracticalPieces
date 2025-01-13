package com.google.gwt.personal.tupracticalpieces.client.common;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ResultSvc_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getNum(com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc instance) /*-{
    return instance.@com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc::num;
  }-*/;
  
  private static native void setNum(com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc instance, int value) 
  /*-{
    instance.@com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc::num = value;
  }-*/;
  
  private static native java.lang.String[] getRec(com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc instance) /*-{
    return instance.@com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc::rec;
  }-*/;
  
  private static native void setRec(com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc instance, java.lang.String[] value) 
  /*-{
    instance.@com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc::rec = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc instance) throws SerializationException {
    setNum(instance, streamReader.readInt());
    setRec(instance, (java.lang.String[]) streamReader.readObject());
    
  }
  
  public static com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc instance) throws SerializationException {
    streamWriter.writeInt(getNum(instance));
    streamWriter.writeObject(getRec(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc_FieldSerializer.deserialize(reader, (com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc_FieldSerializer.serialize(writer, (com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc)object);
  }
  
}
