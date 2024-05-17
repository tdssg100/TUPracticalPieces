package com.google.gwt.i18n.client;

import com.google.gwt.i18n.client.impl.CurrencyDataImpl;
import com.google.gwt.core.client.JavaScriptObject;
import java.util.HashMap;
import com.google.gwt.i18n.client.LocaleInfo;

public class CurrencyList_ja_runtimeSelection extends com.google.gwt.i18n.client.CurrencyList {
  private CurrencyList instance;
  
  @Override
  protected CurrencyData getDefaultJava() {
    ensureInstance();
    return instance.getDefaultJava();
  }
  
  @Override
  protected CurrencyData getDefaultNative() {
    ensureInstance();
    return instance.getDefaultNative();
  }
  
  @Override
  protected HashMap<String, CurrencyData> loadCurrencyMapJava() {
    ensureInstance();
    return instance.loadCurrencyMapJava();
  }
  
  @Override
  protected JavaScriptObject loadCurrencyMapNative() {
    ensureInstance();
    return instance.loadCurrencyMapNative();
  }
  
  @Override
  protected HashMap<String, String> loadNamesMapJava() {
    ensureInstance();
    return instance.loadNamesMapJava();
  }
  
  @Override
  protected JavaScriptObject loadNamesMapNative() {
    ensureInstance();
    return instance.loadNamesMapNative();
  }
  
  private void ensureInstance() {
    if (instance != null) {
      return;
    }
    String runtimeLocale = LocaleInfo.getCurrentLocale().getLocaleName();
    instance = new com.google.gwt.i18n.client.CurrencyList_ja();
  }
}
