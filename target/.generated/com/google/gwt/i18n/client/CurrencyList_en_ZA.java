package com.google.gwt.i18n.client;

import com.google.gwt.i18n.client.impl.CurrencyDataImpl;
import com.google.gwt.core.client.JavaScriptObject;
import java.util.HashMap;

public class CurrencyList_en_ZA extends com.google.gwt.i18n.client.CurrencyList_en_001 {
  
  @Override
  protected CurrencyData getDefaultJava() {
    return new CurrencyDataImpl("ZAR", "R", 2, "ZAR", "R");
  }
  
  @Override
  protected native CurrencyData getDefaultNative() /*-{
    return [ "ZAR", "R", 2, "ZAR", "R"];
  }-*/;
  
  @Override
  protected HashMap<String, CurrencyData> loadCurrencyMapJava() {
    HashMap<String, CurrencyData> result = super.loadCurrencyMapJava();
    // South African Rand
    result.put("ZAR", new CurrencyDataImpl("ZAR", "R", 2, "ZAR", "R"));
    return result;
  }
  
  @Override
  protected JavaScriptObject loadCurrencyMapNative() {
    return overrideMap(super.loadCurrencyMapNative(), loadMyCurrencyMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyCurrencyMapOverridesNative() /*-{
    return {
      // South African Rand
      "ZAR": [ "ZAR", "R", 2, "ZAR", "R"],
    };
  }-*/;
  
  @Override
  protected HashMap<String, String> loadNamesMapJava() {
    HashMap<String, String> result = super.loadNamesMapJava();
    result.put("ZAR", "South African Rand");
    return result;
  }
  
  @Override
  protected JavaScriptObject loadNamesMapNative() {
    return overrideMap(super.loadNamesMapNative(), loadMyNamesMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyNamesMapOverridesNative() /*-{
    return {
      "ZAR": "South African Rand",
    };
  }-*/;
}
