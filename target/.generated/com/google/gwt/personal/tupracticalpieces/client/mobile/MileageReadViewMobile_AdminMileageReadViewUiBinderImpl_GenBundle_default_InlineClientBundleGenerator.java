package com.google.gwt.personal.tupracticalpieces.client.mobile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class MileageReadViewMobile_AdminMileageReadViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements com.google.gwt.personal.tupracticalpieces.client.mobile.MileageReadViewMobile_AdminMileageReadViewUiBinderImpl_GenBundle {
  private static MileageReadViewMobile_AdminMileageReadViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new MileageReadViewMobile_AdminMileageReadViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.google.gwt.personal.tupracticalpieces.client.mobile.MileageReadViewMobile_AdminMileageReadViewUiBinderImpl_GenCss_style() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "style";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GP-OPMDDO{padding:" + ("4px"+ " " +"10px")  + ";font-size:" + ("14pt")  + ";font-weight:" + ("bold")  + ";color:" + ("#666")  + ";}.GP-OPMDMN{padding:" + ("10px")  + ";background:" + ("white")  + ";}.GP-OPMDON{color:" + ("#333")  + ";font-size:" + ("10pt")  + ";padding-bottom:" + ("3px")  + ";}.GP-OPMDNN{width:" + ("300px")  + ";}.GP-OPMDCO{margin-left:") + (("10px")  + ";}.GP-OPMDPN{height:" + ("6em")  + ";}.GP-OPMDEO{color:" + ("red")  + ";}.GP-OPMDJN{padding-top:" + ("8px")  + ";padding-bottom:" + ("8px")  + ";color:" + ("#3f3f3f")  + ";}.GP-OPMDLN{text-align:" + ("center")  + ";}.GP-OPMDKN{padding:" + ("10px")  + ";margin-top:" + ("15px")  + ";}.GP-OPMDAO{width:" + ("130px")  + ";margin-left:" + ("5px") ) + (";}.GP-OPMDBO{border-right:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";}")) : ((".GP-OPMDDO{padding:" + ("4px"+ " " +"10px")  + ";font-size:" + ("14pt")  + ";font-weight:" + ("bold")  + ";color:" + ("#666")  + ";}.GP-OPMDMN{padding:" + ("10px")  + ";background:" + ("white")  + ";}.GP-OPMDON{color:" + ("#333")  + ";font-size:" + ("10pt")  + ";padding-bottom:" + ("3px")  + ";}.GP-OPMDNN{width:" + ("300px")  + ";}.GP-OPMDCO{margin-right:") + (("10px")  + ";}.GP-OPMDPN{height:" + ("6em")  + ";}.GP-OPMDEO{color:" + ("red")  + ";}.GP-OPMDJN{padding-top:" + ("8px")  + ";padding-bottom:" + ("8px")  + ";color:" + ("#3f3f3f")  + ";}.GP-OPMDLN{text-align:" + ("center")  + ";}.GP-OPMDKN{padding:" + ("10px")  + ";margin-top:" + ("15px")  + ";}.GP-OPMDAO{width:" + ("130px")  + ";margin-right:" + ("5px") ) + (";}.GP-OPMDBO{border-left:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";}"));
      }
      public java.lang.String button() {
        return "GP-OPMDJN";
      }
      public java.lang.String buttonPanel() {
        return "GP-OPMDKN";
      }
      public java.lang.String dateButton() {
        return "GP-OPMDLN";
      }
      public java.lang.String editForm() {
        return "GP-OPMDMN";
      }
      public java.lang.String field() {
        return "GP-OPMDNN";
      }
      public java.lang.String label() {
        return "GP-OPMDON";
      }
      public java.lang.String notesBox() {
        return "GP-OPMDPN";
      }
      public java.lang.String saveButton() {
        return "GP-OPMDAO";
      }
      public java.lang.String templateList() {
        return "GP-OPMDBO";
      }
      public java.lang.String textBoxWrapper() {
        return "GP-OPMDCO";
      }
      public java.lang.String title() {
        return "GP-OPMDDO";
      }
      public java.lang.String violation() {
        return "GP-OPMDEO";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.google.gwt.personal.tupracticalpieces.client.mobile.MileageReadViewMobile_AdminMileageReadViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.google.gwt.personal.tupracticalpieces.client.mobile.MileageReadViewMobile_AdminMileageReadViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.personal.tupracticalpieces.client.mobile.MileageReadViewMobile_AdminMileageReadViewUiBinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'style': return this.@com.google.gwt.personal.tupracticalpieces.client.mobile.MileageReadViewMobile_AdminMileageReadViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
