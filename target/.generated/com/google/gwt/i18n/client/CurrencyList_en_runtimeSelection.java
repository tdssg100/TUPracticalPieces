package com.google.gwt.i18n.client;

import com.google.gwt.i18n.client.impl.CurrencyDataImpl;
import com.google.gwt.core.client.JavaScriptObject;
import java.util.HashMap;
import com.google.gwt.i18n.client.LocaleInfo;

public class CurrencyList_en_runtimeSelection extends com.google.gwt.i18n.client.CurrencyList {
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
    if ("en_ZW".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_001();
      return;
    }
    if ("en_AS".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_AS();
      return;
    }
    if ("en_AU".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_AU();
      return;
    }
    if ("en_BE".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_BE();
      return;
    }
    if ("en_BW".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_BW();
      return;
    }
    if ("en_BZ".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_BZ();
      return;
    }
    if ("en_CA".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_CA();
      return;
    }
    if ("en_GB".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_GB();
      return;
    }
    if ("en_GU".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_GU();
      return;
    }
    if ("en_HK".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_HK();
      return;
    }
    if ("en_IE".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_IE();
      return;
    }
    if ("en_IN".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_IN();
      return;
    }
    if ("en_JM".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_JM();
      return;
    }
    if ("en_MH".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_MH();
      return;
    }
    if ("en_MP".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_MP();
      return;
    }
    if ("en_MT".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_MT();
      return;
    }
    if ("en_NA".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_NA();
      return;
    }
    if ("en_NZ".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_NZ();
      return;
    }
    if ("en_PH".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_PH();
      return;
    }
    if ("en_PK".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_PK();
      return;
    }
    if ("en_SG".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_SG();
      return;
    }
    if ("en_TT".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_TT();
      return;
    }
    if ("en_UM".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_UM();
      return;
    }
    if ("en_US".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_US();
      return;
    }
    if ("en_VI".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_VI();
      return;
    }
    if ("en_ZA".equals(runtimeLocale)) {
      instance = new com.google.gwt.i18n.client.CurrencyList_en_ZA();
      return;
    }
    instance = new com.google.gwt.i18n.client.CurrencyList_en();
  }
}
