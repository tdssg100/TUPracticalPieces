package com.google.gwt.i18n.client;

import com.google.gwt.i18n.client.impl.CurrencyDataImpl;
import com.google.gwt.core.client.JavaScriptObject;
import java.util.HashMap;

public class CurrencyList_en_IN extends com.google.gwt.i18n.client.CurrencyList_en_001 {
  
  @Override
  protected CurrencyData getDefaultJava() {
    return new CurrencyDataImpl("INR", "₹", 2, "Rs", "₹");
  }
  
  @Override
  protected native CurrencyData getDefaultNative() /*-{
    return [ "INR", "₹", 2, "Rs", "₹"];
  }-*/;
  
  @Override
  protected HashMap<String, CurrencyData> loadCurrencyMapJava() {
    HashMap<String, CurrencyData> result = super.loadCurrencyMapJava();
    // Venezuelan Bolívar
    result.put("VEF", new CurrencyDataImpl("VEF", "VEF", 130, "VEF", "Bs"));
    // VES
    result.put("VES", new CurrencyDataImpl("VES", "VES", 2, "VES", "VES"));
    return result;
  }
  
  @Override
  protected JavaScriptObject loadCurrencyMapNative() {
    return overrideMap(super.loadCurrencyMapNative(), loadMyCurrencyMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyCurrencyMapOverridesNative() /*-{
    return {
      // Venezuelan Bolívar
      "VEF": [ "VEF", "VEF", 130, "VEF", "Bs"],
      // VES
      "VES": [ "VES", "VES", 2, "VES", "VES"],
    };
  }-*/;
  
  @Override
  protected HashMap<String, String> loadNamesMapJava() {
    HashMap<String, String> result = super.loadNamesMapJava();
    result.put("VEF", "Venezuelan Bolívar");
    return result;
  }
  
  @Override
  protected JavaScriptObject loadNamesMapNative() {
    return overrideMap(super.loadNamesMapNative(), loadMyNamesMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyNamesMapOverridesNative() /*-{
    return {
      "VEF": "Venezuelan Bolívar",
    };
  }-*/;
}
