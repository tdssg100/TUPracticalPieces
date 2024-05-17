package com.google.gwt.i18n.client.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import java.util.HashMap;

public class LocaleInfoImpl_shared extends com.google.gwt.i18n.client.impl.LocaleInfoImpl {
  private static native String getLocaleNativeDisplayName(
      JavaScriptObject nativeDisplayNamesNative,String localeName) /*-{
    return nativeDisplayNamesNative[localeName];
  }-*/;
  
  HashMap<String,String> nativeDisplayNamesJava;
  private JavaScriptObject nativeDisplayNamesNative;
  
  @Override
  public String[] getAvailableLocaleNames() {
    return new String[] {
      "default",
      "en",
      "en_AS",
      "en_AU",
      "en_BE",
      "en_BW",
      "en_BZ",
      "en_CA",
      "en_GB",
      "en_GU",
      "en_HK",
      "en_IE",
      "en_IN",
      "en_JM",
      "en_MH",
      "en_MP",
      "en_MT",
      "en_NA",
      "en_NZ",
      "en_PH",
      "en_PK",
      "en_SG",
      "en_TT",
      "en_UM",
      "en_US",
      "en_VI",
      "en_ZA",
      "en_ZW",
      "ja",
      "ja_JP",
    };
  }
  
  @Override
  public String getLocaleNativeDisplayName(String localeName) {
    if (GWT.isScript()) {
      if (nativeDisplayNamesNative == null) {
        nativeDisplayNamesNative = loadNativeDisplayNamesNative();
      }
      return getLocaleNativeDisplayName(nativeDisplayNamesNative, localeName);
    } else {
      if (nativeDisplayNamesJava == null) {
        nativeDisplayNamesJava = new HashMap<String, String>();
        nativeDisplayNamesJava.put("en", "English");
        nativeDisplayNamesJava.put("en_AS", "English - American Samoa");
        nativeDisplayNamesJava.put("en_AU", "Australian English");
        nativeDisplayNamesJava.put("en_BE", "English - Belgium");
        nativeDisplayNamesJava.put("en_BW", "English - Botswana");
        nativeDisplayNamesJava.put("en_BZ", "English - Belize");
        nativeDisplayNamesJava.put("en_CA", "Canadian English");
        nativeDisplayNamesJava.put("en_GB", "British English");
        nativeDisplayNamesJava.put("en_GU", "English - Guam");
        nativeDisplayNamesJava.put("en_HK", "English - Hong Kong SAR China");
        nativeDisplayNamesJava.put("en_IE", "English - Ireland");
        nativeDisplayNamesJava.put("en_IN", "English - India");
        nativeDisplayNamesJava.put("en_JM", "English - Jamaica");
        nativeDisplayNamesJava.put("en_MH", "English - Marshall Islands");
        nativeDisplayNamesJava.put("en_MP", "English - Northern Mariana Islands");
        nativeDisplayNamesJava.put("en_MT", "English - Malta");
        nativeDisplayNamesJava.put("en_NA", "English - Namibia");
        nativeDisplayNamesJava.put("en_NZ", "English - New Zealand");
        nativeDisplayNamesJava.put("en_PH", "English - Philippines");
        nativeDisplayNamesJava.put("en_PK", "English - Pakistan");
        nativeDisplayNamesJava.put("en_SG", "English - Singapore");
        nativeDisplayNamesJava.put("en_TT", "English - Trinidad and Tobago");
        nativeDisplayNamesJava.put("en_UM", "English - United States Minor Outlying Islands");
        nativeDisplayNamesJava.put("en_US", "U.S. English");
        nativeDisplayNamesJava.put("en_VI", "English - U.S. Virgin Islands");
        nativeDisplayNamesJava.put("en_ZA", "English - South Africa");
        nativeDisplayNamesJava.put("en_ZW", "English - Zimbabwe");
        nativeDisplayNamesJava.put("ja", "日本語");
        nativeDisplayNamesJava.put("ja_JP", "日本語 - 日本");
      }
      return nativeDisplayNamesJava.get(localeName);
    }
  }
  
  @Override
  public boolean hasAnyRTL() {
    return false;
  }
  
  private native JavaScriptObject loadNativeDisplayNamesNative() /*-{
    return {
      "en": "English",
      "en_AS": "English - American Samoa",
      "en_AU": "Australian English",
      "en_BE": "English - Belgium",
      "en_BW": "English - Botswana",
      "en_BZ": "English - Belize",
      "en_CA": "Canadian English",
      "en_GB": "British English",
      "en_GU": "English - Guam",
      "en_HK": "English - Hong Kong SAR China",
      "en_IE": "English - Ireland",
      "en_IN": "English - India",
      "en_JM": "English - Jamaica",
      "en_MH": "English - Marshall Islands",
      "en_MP": "English - Northern Mariana Islands",
      "en_MT": "English - Malta",
      "en_NA": "English - Namibia",
      "en_NZ": "English - New Zealand",
      "en_PH": "English - Philippines",
      "en_PK": "English - Pakistan",
      "en_SG": "English - Singapore",
      "en_TT": "English - Trinidad and Tobago",
      "en_UM": "English - United States Minor Outlying Islands",
      "en_US": "U.S. English",
      "en_VI": "English - U.S. Virgin Islands",
      "en_ZA": "English - South Africa",
      "en_ZW": "English - Zimbabwe",
      "ja": "日本語",
      "ja_JP": "日本語 - 日本"
    };
  }-*/;
}
