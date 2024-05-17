package com.google.gwt.i18n.client.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.i18n.client.constants.NumberConstants;
import com.google.gwt.i18n.client.constants.NumberConstantsImpl;
import com.google.gwt.i18n.client.DateTimeFormatInfo;
import com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl;

public class LocaleInfoImpl_en_runtimeSelection extends LocaleInfoImpl_shared {
  @Override
  public String getLocaleName() {
    String rtLocale = getRuntimeLocale();
    return rtLocale != null ? rtLocale : "en";
  }
  
  @Override
  public String getLocaleQueryParam() {
    return "locale";
  }
  
  @Override
  public String getLocaleCookieName() {
    return "TUPRACTICALPIECES_LOCALE";
  }
  
  @Override
  public DateTimeFormatInfo getDateTimeFormatInfo() {
    String runtimeLocale = getLocaleName();
    if ("en_IE".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_IE_runtimeSelection();
    }
    if ("en_MH".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_MH_runtimeSelection();
    }
    if ("en_SG".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_SG_runtimeSelection();
    }
    if ("en_NA".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_NA_runtimeSelection();
    }
    if ("en_AS".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_AS_runtimeSelection();
    }
    if ("en_PH".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_PH_runtimeSelection();
    }
    if ("en_JM".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_JM_runtimeSelection();
    }
    if ("en_UM".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_UM_runtimeSelection();
    }
    if ("en".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_runtimeSelection();
    }
    if ("en_BW".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_BW_runtimeSelection();
    }
    if ("en_HK".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_HK_runtimeSelection();
    }
    if ("en_US".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_US_runtimeSelection();
    }
    if ("en_VI".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_VI_runtimeSelection();
    }
    if ("en_IN".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_IN_runtimeSelection();
    }
    if ("en_GU".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_GU_runtimeSelection();
    }
    if ("en_CA".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_CA_runtimeSelection();
    }
    if ("en_TT".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_TT_runtimeSelection();
    }
    if ("en_BE".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_BE_runtimeSelection();
    }
    if ("en_AU".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_AU_runtimeSelection();
    }
    if ("en_MP".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_MP_runtimeSelection();
    }
    if ("en_MT".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_MT_runtimeSelection();
    }
    if ("en_ZW".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_ZW_runtimeSelection();
    }
    if ("en_PK".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_PK_runtimeSelection();
    }
    if ("en_BZ".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_BZ_runtimeSelection();
    }
    if ("en_GB".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_GB_runtimeSelection();
    }
    if ("en_NZ".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_NZ_runtimeSelection();
    }
    if ("en_ZA".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl_en_ZA_runtimeSelection();
    }
    return GWT.create(com.google.gwt.i18n.client.impl.cldr.DateTimeFormatInfoImpl.class);
  }
  
  @Override
  public NumberConstants getNumberConstants() {
    String runtimeLocale = getLocaleName();
    if ("en_NZ".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_NZ();
    }
    if ("en".equals(runtimeLocale)
        || "en_GU".equals(runtimeLocale)
        || "en_US".equals(runtimeLocale)
        || "en_MH".equals(runtimeLocale)
        || "en_ZW".equals(runtimeLocale)
        || "en_VI".equals(runtimeLocale)
        || "en_AS".equals(runtimeLocale)
        || "en_UM".equals(runtimeLocale)
        || "en_MP".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en();
    }
    if ("en_ZA".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_ZA();
    }
    if ("en_MT".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_MT();
    }
    if ("en_NA".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_NA();
    }
    if ("en_SG".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_SG();
    }
    if ("en_AU".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_AU();
    }
    if ("en_BW".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_BW();
    }
    if ("en_GB".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_GB();
    }
    if ("en_PK".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_PK();
    }
    if ("en_IE".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_IE();
    }
    if ("en_CA".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_CA();
    }
    if ("en_PH".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_PH();
    }
    if ("en_BZ".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_BZ();
    }
    if ("en_BE".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_BE();
    }
    if ("en_HK".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_HK();
    }
    if ("en_JM".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_JM();
    }
    if ("en_IN".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_IN();
    }
    if ("en_TT".equals(runtimeLocale)) {
      return new com.google.gwt.i18n.client.constants.NumberConstantsImpl_en_TT();
    }
    return GWT.create(com.google.gwt.i18n.client.constants.NumberConstantsImpl.class);
  }
}
