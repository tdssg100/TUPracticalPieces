package com.google.gwt.i18n.client;

import com.google.gwt.i18n.client.impl.CurrencyDataImpl;
import com.google.gwt.core.client.JavaScriptObject;
import java.util.HashMap;

public class CurrencyList_en_AU extends com.google.gwt.i18n.client.CurrencyList_en_001 {
  
  @Override
  protected CurrencyData getDefaultJava() {
    return new CurrencyDataImpl("AUD", "$", 2, "AU$", "$");
  }
  
  @Override
  protected native CurrencyData getDefaultNative() /*-{
    return [ "AUD", "$", 2, "AU$", "$"];
  }-*/;
  
  @Override
  protected HashMap<String, CurrencyData> loadCurrencyMapJava() {
    HashMap<String, CurrencyData> result = super.loadCurrencyMapJava();
    // Australian Dollar
    result.put("AUD", new CurrencyDataImpl("AUD", "$", 2, "AU$", "$"));
    // Bosnia-Herzegovina Convertible Marka
    result.put("BAM", new CurrencyDataImpl("BAM", "BAM", 2, "BAM", "KM"));
    // Barbados Dollar
    result.put("BBD", new CurrencyDataImpl("BBD", "BBD", 2, "BBD", "$"));
    // Bermuda Dollar
    result.put("BMD", new CurrencyDataImpl("BMD", "BMD", 2, "BMD", "$"));
    // Boliviano
    result.put("BOB", new CurrencyDataImpl("BOB", "BOB", 2, "BOB", "Bs"));
    // Brazilian Real
    result.put("BRL", new CurrencyDataImpl("BRL", "R$", 2, "R$", "R$"));
    // Canadian Dollar
    result.put("CAD", new CurrencyDataImpl("CAD", "C$", 2, "C$", "$"));
    // CNH
    result.put("CNH", new CurrencyDataImpl("CNH", "CNH", 130, "CNH", "CNH"));
    // Chinese Yuan
    result.put("CNY", new CurrencyDataImpl("CNY", "RMB¥", 2, "RMB¥", "¥"));
    // Euro
    result.put("EUR", new CurrencyDataImpl("EUR", "€", 2, "€", "€"));
    // British Pound
    result.put("GBP", new CurrencyDataImpl("GBP", "GB£", 2, "GB£", "£"));
    // Hong Kong Dollar
    result.put("HKD", new CurrencyDataImpl("HKD", "HK$", 2, "HK$", "$"));
    // Israeli Shekel
    result.put("ILS", new CurrencyDataImpl("ILS", "IL₪", 2, "IL₪", "₪"));
    // Indian Rupee
    result.put("INR", new CurrencyDataImpl("INR", "Rs", 2, "Rs", "₹"));
    // Japanese Yen
    result.put("JPY", new CurrencyDataImpl("JPY", "JP¥", 0, "JP¥", "¥"));
    // South Korean Won
    result.put("KRW", new CurrencyDataImpl("KRW", "KR₩", 0, "KR₩", "₩"));
    // Mexican Peso
    result.put("MXN", new CurrencyDataImpl("MXN", "Mex$", 2, "Mex$", "$"));
    // New Zealand Dollar
    result.put("NZD", new CurrencyDataImpl("NZD", "NZD", 2, "NZD", "$"));
    // Qatari Riyal
    result.put("QAR", new CurrencyDataImpl("QAR", "QAR", 2, "QAR", "Rial"));
    // Seychellois Rupee
    result.put("SCR", new CurrencyDataImpl("SCR", "Rs", 2, "Rs", "SCR"));
    // Suriname Dollar
    result.put("SRD", new CurrencyDataImpl("SRD", "SRD", 2, "SRD", "$"));
    // New Taiwan Dollar
    result.put("TWD", new CurrencyDataImpl("TWD", "NT$", 2, "NT$", "NT$"));
    // US Dollar
    result.put("USD", new CurrencyDataImpl("USD", "US$", 2, "US$", "$"));
    // Peso Uruguayo
    result.put("UYU", new CurrencyDataImpl("UYU", "UY$", 2, "UY$", "$"));
    // VES
    result.put("VES", new CurrencyDataImpl("VES", "VES", 2, "VES", "VES"));
    // Vietnamese Dong
    result.put("VND", new CurrencyDataImpl("VND", "₫", 24, "₫", "₫"));
    // Central African CFA Franc
    result.put("XAF", new CurrencyDataImpl("XAF", "XAF", 0, "XAF", "FCFA"));
    // East Caribbean Dollar
    result.put("XCD", new CurrencyDataImpl("XCD", "XCD", 2, "XCD", "$"));
    // West African CFA Franc
    result.put("XOF", new CurrencyDataImpl("XOF", "XOF", 0, "XOF", "CFA"));
    // CFP Franc
    result.put("XPF", new CurrencyDataImpl("XPF", "CFP", 0, "CFP", "FCFP"));
    return result;
  }
  
  @Override
  protected JavaScriptObject loadCurrencyMapNative() {
    return overrideMap(super.loadCurrencyMapNative(), loadMyCurrencyMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyCurrencyMapOverridesNative() /*-{
    return {
      // Australian Dollar
      "AUD": [ "AUD", "$", 2, "AU$", "$"],
      // Bosnia-Herzegovina Convertible Marka
      "BAM": [ "BAM", "BAM", 2, "BAM", "KM"],
      // Barbados Dollar
      "BBD": [ "BBD", "BBD", 2, "BBD", "$"],
      // Bermuda Dollar
      "BMD": [ "BMD", "BMD", 2, "BMD", "$"],
      // Boliviano
      "BOB": [ "BOB", "BOB", 2, "BOB", "Bs"],
      // Brazilian Real
      "BRL": [ "BRL", "R$", 2, "R$", "R$"],
      // Canadian Dollar
      "CAD": [ "CAD", "C$", 2, "C$", "$"],
      // CNH
      "CNH": [ "CNH", "CNH", 130, "CNH", "CNH"],
      // Chinese Yuan
      "CNY": [ "CNY", "RMB¥", 2, "RMB¥", "¥"],
      // Euro
      "EUR": [ "EUR", "€", 2, "€", "€"],
      // British Pound
      "GBP": [ "GBP", "GB£", 2, "GB£", "£"],
      // Hong Kong Dollar
      "HKD": [ "HKD", "HK$", 2, "HK$", "$"],
      // Israeli Shekel
      "ILS": [ "ILS", "IL₪", 2, "IL₪", "₪"],
      // Indian Rupee
      "INR": [ "INR", "Rs", 2, "Rs", "₹"],
      // Japanese Yen
      "JPY": [ "JPY", "JP¥", 0, "JP¥", "¥"],
      // South Korean Won
      "KRW": [ "KRW", "KR₩", 0, "KR₩", "₩"],
      // Mexican Peso
      "MXN": [ "MXN", "Mex$", 2, "Mex$", "$"],
      // New Zealand Dollar
      "NZD": [ "NZD", "NZD", 2, "NZD", "$"],
      // Qatari Riyal
      "QAR": [ "QAR", "QAR", 2, "QAR", "Rial"],
      // Seychellois Rupee
      "SCR": [ "SCR", "Rs", 2, "Rs", "SCR"],
      // Suriname Dollar
      "SRD": [ "SRD", "SRD", 2, "SRD", "$"],
      // New Taiwan Dollar
      "TWD": [ "TWD", "NT$", 2, "NT$", "NT$"],
      // US Dollar
      "USD": [ "USD", "US$", 2, "US$", "$"],
      // Peso Uruguayo
      "UYU": [ "UYU", "UY$", 2, "UY$", "$"],
      // VES
      "VES": [ "VES", "VES", 2, "VES", "VES"],
      // Vietnamese Dong
      "VND": [ "VND", "₫", 24, "₫", "₫"],
      // Central African CFA Franc
      "XAF": [ "XAF", "XAF", 0, "XAF", "FCFA"],
      // East Caribbean Dollar
      "XCD": [ "XCD", "XCD", 2, "XCD", "$"],
      // West African CFA Franc
      "XOF": [ "XOF", "XOF", 0, "XOF", "CFA"],
      // CFP Franc
      "XPF": [ "XPF", "CFP", 0, "CFP", "FCFP"],
    };
  }-*/;
  
  @Override
  protected HashMap<String, String> loadNamesMapJava() {
    HashMap<String, String> result = super.loadNamesMapJava();
    result.put("AUD", "Australian Dollar");
    result.put("BAM", "Bosnia-Herzegovina Convertible Marka");
    result.put("BBD", "Barbados Dollar");
    result.put("BMD", "Bermuda Dollar");
    result.put("BOB", "Boliviano");
    result.put("BRL", "Brazilian Real");
    result.put("CAD", "Canadian Dollar");
    result.put("CNY", "Chinese Yuan");
    result.put("EUR", "Euro");
    result.put("GBP", "British Pound");
    result.put("HKD", "Hong Kong Dollar");
    result.put("ILS", "Israeli Shekel");
    result.put("INR", "Indian Rupee");
    result.put("JPY", "Japanese Yen");
    result.put("KRW", "South Korean Won");
    result.put("MXN", "Mexican Peso");
    result.put("NZD", "New Zealand Dollar");
    result.put("QAR", "Qatari Riyal");
    result.put("SCR", "Seychellois Rupee");
    result.put("SRD", "Suriname Dollar");
    result.put("TWD", "New Taiwan Dollar");
    result.put("USD", "US Dollar");
    result.put("UYU", "Peso Uruguayo");
    result.put("VND", "Vietnamese Dong");
    result.put("XAF", "Central African CFA Franc");
    result.put("XCD", "East Caribbean Dollar");
    result.put("XOF", "West African CFA Franc");
    result.put("XPF", "CFP Franc");
    return result;
  }
  
  @Override
  protected JavaScriptObject loadNamesMapNative() {
    return overrideMap(super.loadNamesMapNative(), loadMyNamesMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyNamesMapOverridesNative() /*-{
    return {
      "AUD": "Australian Dollar",
      "BAM": "Bosnia-Herzegovina Convertible Marka",
      "BBD": "Barbados Dollar",
      "BMD": "Bermuda Dollar",
      "BOB": "Boliviano",
      "BRL": "Brazilian Real",
      "CAD": "Canadian Dollar",
      "CNY": "Chinese Yuan",
      "EUR": "Euro",
      "GBP": "British Pound",
      "HKD": "Hong Kong Dollar",
      "ILS": "Israeli Shekel",
      "INR": "Indian Rupee",
      "JPY": "Japanese Yen",
      "KRW": "South Korean Won",
      "MXN": "Mexican Peso",
      "NZD": "New Zealand Dollar",
      "QAR": "Qatari Riyal",
      "SCR": "Seychellois Rupee",
      "SRD": "Suriname Dollar",
      "TWD": "New Taiwan Dollar",
      "USD": "US Dollar",
      "UYU": "Peso Uruguayo",
      "VND": "Vietnamese Dong",
      "XAF": "Central African CFA Franc",
      "XCD": "East Caribbean Dollar",
      "XOF": "West African CFA Franc",
      "XPF": "CFP Franc",
    };
  }-*/;
}
