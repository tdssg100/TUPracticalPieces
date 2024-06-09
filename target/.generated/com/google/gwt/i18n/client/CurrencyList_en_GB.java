package com.google.gwt.i18n.client;

import com.google.gwt.i18n.client.impl.CurrencyDataImpl;
import com.google.gwt.core.client.JavaScriptObject;
import java.util.HashMap;

public class CurrencyList_en_GB extends com.google.gwt.i18n.client.CurrencyList_en_150 {
  
  @Override
  protected CurrencyData getDefaultJava() {
    return new CurrencyDataImpl("GBP", "£", 2, "GB£", "£");
  }
  
  @Override
  protected native CurrencyData getDefaultNative() /*-{
    return [ "GBP", "£", 2, "GB£", "£"];
  }-*/;
}
