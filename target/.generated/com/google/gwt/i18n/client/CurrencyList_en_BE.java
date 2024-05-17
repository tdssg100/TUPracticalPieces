package com.google.gwt.i18n.client;

import com.google.gwt.i18n.client.impl.CurrencyDataImpl;
import com.google.gwt.core.client.JavaScriptObject;
import java.util.HashMap;

public class CurrencyList_en_BE extends com.google.gwt.i18n.client.CurrencyList_en_150 {
  
  @Override
  protected CurrencyData getDefaultJava() {
    return new CurrencyDataImpl("EUR", "€", 2, "€", "€");
  }
  
  @Override
  protected native CurrencyData getDefaultNative() /*-{
    return [ "EUR", "€", 2, "€", "€"];
  }-*/;
  
  @Override
  protected HashMap<String, CurrencyData> loadCurrencyMapJava() {
    HashMap<String, CurrencyData> result = super.loadCurrencyMapJava();
    // US Dollar
    result.put("USD", new CurrencyDataImpl("USD", "US$", 2, "US$", "$"));
    return result;
  }
  
  @Override
  protected JavaScriptObject loadCurrencyMapNative() {
    return overrideMap(super.loadCurrencyMapNative(), loadMyCurrencyMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyCurrencyMapOverridesNative() /*-{
    return {
      // US Dollar
      "USD": [ "USD", "US$", 2, "US$", "$"],
    };
  }-*/;
  
  @Override
  protected HashMap<String, String> loadNamesMapJava() {
    HashMap<String, String> result = super.loadNamesMapJava();
    result.put("USD", "US Dollar");
    return result;
  }
  
  @Override
  protected JavaScriptObject loadNamesMapNative() {
    return overrideMap(super.loadNamesMapNative(), loadMyNamesMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyNamesMapOverridesNative() /*-{
    return {
      "USD": "US Dollar",
    };
  }-*/;
}
