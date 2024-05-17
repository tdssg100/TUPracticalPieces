package com.google.gwt.personal.tupracticalpieces.client.common;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ResultFetch_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native boolean getResult(com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch instance) /*-{
    return instance.@com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch::result;
  }-*/;
  
  private static native void setResult(com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch instance, boolean value) 
  /*-{
    instance.@com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch::result = value;
  }-*/;
  
  private static native java.lang.String getText(com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch instance) /*-{
    return instance.@com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch::text;
  }-*/;
  
  private static native void setText(com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch instance, java.lang.String value) 
  /*-{
    instance.@com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch::text = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch instance) throws SerializationException {
    setResult(instance, streamReader.readBoolean());
    setText(instance, streamReader.readString());
    
  }
  
  public static com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch instance) throws SerializationException {
    streamWriter.writeBoolean(getResult(instance));
    streamWriter.writeString(getText(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch_FieldSerializer.deserialize(reader, (com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch_FieldSerializer.serialize(writer, (com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch)object);
  }
  
}
