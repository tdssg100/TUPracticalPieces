package com.google.gwt.personal.tupracticalpieces.client.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenBundle {
  private static AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GKLQPWSIM{padding:" + ("4px"+ " " +"10px")  + ";font-size:" + ("14pt")  + ";font-weight:" + ("bold")  + ";color:" + ("#666")  + ";}.GKLQPWSBM{padding:" + ("10px")  + ";background:" + ("white")  + ";}.GKLQPWSDM{color:" + ("#333")  + ";font-size:" + ("10pt")  + ";padding-bottom:" + ("3px")  + ";}.GKLQPWSCM{width:" + ("300px")  + ";}.GKLQPWSHM{margin-left:") + (("10px")  + ";}.GKLQPWSEM{height:" + ("6em")  + ";}.GKLQPWSJM{color:" + ("red")  + ";}.GKLQPWSOL{padding-top:" + ("8px")  + ";padding-bottom:" + ("8px")  + ";color:" + ("#3f3f3f")  + ";}.GKLQPWSAM{text-align:" + ("center")  + ";}.GKLQPWSPL{padding:" + ("10px")  + ";margin-top:" + ("15px")  + ";}.GKLQPWSFM{width:" + ("130px")  + ";margin-left:" + ("5px") ) + (";}.GKLQPWSGM{border-right:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";}")) : ((".GKLQPWSIM{padding:" + ("4px"+ " " +"10px")  + ";font-size:" + ("14pt")  + ";font-weight:" + ("bold")  + ";color:" + ("#666")  + ";}.GKLQPWSBM{padding:" + ("10px")  + ";background:" + ("white")  + ";}.GKLQPWSDM{color:" + ("#333")  + ";font-size:" + ("10pt")  + ";padding-bottom:" + ("3px")  + ";}.GKLQPWSCM{width:" + ("300px")  + ";}.GKLQPWSHM{margin-right:") + (("10px")  + ";}.GKLQPWSEM{height:" + ("6em")  + ";}.GKLQPWSJM{color:" + ("red")  + ";}.GKLQPWSOL{padding-top:" + ("8px")  + ";padding-bottom:" + ("8px")  + ";color:" + ("#3f3f3f")  + ";}.GKLQPWSAM{text-align:" + ("center")  + ";}.GKLQPWSPL{padding:" + ("10px")  + ";margin-top:" + ("15px")  + ";}.GKLQPWSFM{width:" + ("130px")  + ";margin-right:" + ("5px") ) + (";}.GKLQPWSGM{border-left:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";}"));
      }
      public java.lang.String button() {
        return "GKLQPWSOL";
      }
      public java.lang.String buttonPanel() {
        return "GKLQPWSPL";
      }
      public java.lang.String dateButton() {
        return "GKLQPWSAM";
      }
      public java.lang.String editForm() {
        return "GKLQPWSBM";
      }
      public java.lang.String field() {
        return "GKLQPWSCM";
      }
      public java.lang.String label() {
        return "GKLQPWSDM";
      }
      public java.lang.String notesBox() {
        return "GKLQPWSEM";
      }
      public java.lang.String saveButton() {
        return "GKLQPWSFM";
      }
      public java.lang.String templateList() {
        return "GKLQPWSGM";
      }
      public java.lang.String textBoxWrapper() {
        return "GKLQPWSHM";
      }
      public java.lang.String title() {
        return "GKLQPWSIM";
      }
      public java.lang.String violation() {
        return "GKLQPWSJM";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
