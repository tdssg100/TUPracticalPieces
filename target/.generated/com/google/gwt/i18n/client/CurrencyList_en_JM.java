package com.google.gwt.i18n.client;

import com.google.gwt.i18n.client.impl.CurrencyDataImpl;
import com.google.gwt.core.client.JavaScriptObject;
import java.util.HashMap;

public class CurrencyList_en_JM extends com.google.gwt.i18n.client.CurrencyList_en_001 {
  
  @Override
  protected CurrencyData getDefaultJava() {
    return new CurrencyDataImpl("JMD", "$", 2, "JA$", "$");
  }
  
  @Override
  protected native CurrencyData getDefaultNative() /*-{
    return [ "JMD", "$", 2, "JA$", "$"];
  }-*/;
  
  @Override
  protected HashMap<String, CurrencyData> loadCurrencyMapJava() {
    HashMap<String, CurrencyData> result = super.loadCurrencyMapJava();
    // Jamaican Dollar
    result.put("JMD", new CurrencyDataImpl("JMD", "$", 2, "JA$", "$"));
    return result;
  }
  
  @Override
  protected JavaScriptObject loadCurrencyMapNative() {
    return overrideMap(super.loadCurrencyMapNative(), loadMyCurrencyMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyCurrencyMapOverridesNative() /*-{
    return {
      // Jamaican Dollar
      "JMD": [ "JMD", "$", 2, "JA$", "$"],
    };
  }-*/;
  
  @Override
  protected HashMap<String, String> loadNamesMapJava() {
    HashMap<String, String> result = super.loadNamesMapJava();
    result.put("JMD", "Jamaican Dollar");
    return result;
  }
  
  @Override
  protected JavaScriptObject loadNamesMapNative() {
    return overrideMap(super.loadNamesMapNative(), loadMyNamesMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyNamesMapOverridesNative() /*-{
    return {
      "JMD": "Jamaican Dollar",
    };
  }-*/;
}
