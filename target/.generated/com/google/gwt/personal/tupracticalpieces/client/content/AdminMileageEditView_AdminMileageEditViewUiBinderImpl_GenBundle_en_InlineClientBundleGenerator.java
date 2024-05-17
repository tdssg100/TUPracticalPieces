package com.google.gwt.personal.tupracticalpieces.client.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenBundle_en_InlineClientBundleGenerator implements com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenBundle {
  private static AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenBundle_en_InlineClientBundleGenerator _instance0 = new AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenBundle_en_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GKLQPWSML{padding:" + ("4px"+ " " +"10px")  + ";font-size:" + ("14pt")  + ";font-weight:" + ("bold")  + ";color:" + ("#666")  + ";}.GKLQPWSFL{padding:" + ("10px")  + ";background:" + ("white")  + ";}.GKLQPWSHL{color:" + ("#333")  + ";font-size:" + ("10pt")  + ";padding-bottom:" + ("3px")  + ";}.GKLQPWSGL{width:" + ("300px")  + ";}.GKLQPWSLL{margin-left:") + (("10px")  + ";}.GKLQPWSIL{height:" + ("6em")  + ";}.GKLQPWSNL{color:" + ("red")  + ";}.GKLQPWSBL{padding-top:" + ("8px")  + ";padding-bottom:" + ("8px")  + ";color:" + ("#3f3f3f")  + ";}.GKLQPWSDL{text-align:" + ("center")  + ";}.GKLQPWSCL{padding:" + ("10px")  + ";margin-top:" + ("15px")  + ";}.GKLQPWSJL{width:" + ("130px")  + ";margin-left:" + ("5px") ) + (";}.GKLQPWSEL{width:" + ("130px")  + ";margin-right:" + ("5px")  + ";color:" + ("white")  + ";background:" + ("#940000")  + ";}.GKLQPWSKL{border-right:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";}")) : ((".GKLQPWSML{padding:" + ("4px"+ " " +"10px")  + ";font-size:" + ("14pt")  + ";font-weight:" + ("bold")  + ";color:" + ("#666")  + ";}.GKLQPWSFL{padding:" + ("10px")  + ";background:" + ("white")  + ";}.GKLQPWSHL{color:" + ("#333")  + ";font-size:" + ("10pt")  + ";padding-bottom:" + ("3px")  + ";}.GKLQPWSGL{width:" + ("300px")  + ";}.GKLQPWSLL{margin-right:") + (("10px")  + ";}.GKLQPWSIL{height:" + ("6em")  + ";}.GKLQPWSNL{color:" + ("red")  + ";}.GKLQPWSBL{padding-top:" + ("8px")  + ";padding-bottom:" + ("8px")  + ";color:" + ("#3f3f3f")  + ";}.GKLQPWSDL{text-align:" + ("center")  + ";}.GKLQPWSCL{padding:" + ("10px")  + ";margin-top:" + ("15px")  + ";}.GKLQPWSJL{width:" + ("130px")  + ";margin-right:" + ("5px") ) + (";}.GKLQPWSEL{width:" + ("130px")  + ";margin-left:" + ("5px")  + ";color:" + ("white")  + ";background:" + ("#940000")  + ";}.GKLQPWSKL{border-left:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";}"));
      }
      public java.lang.String button() {
        return "GKLQPWSBL";
      }
      public java.lang.String buttonPanel() {
        return "GKLQPWSCL";
      }
      public java.lang.String dateButton() {
        return "GKLQPWSDL";
      }
      public java.lang.String deleteButton() {
        return "GKLQPWSEL";
      }
      public java.lang.String editForm() {
        return "GKLQPWSFL";
      }
      public java.lang.String field() {
        return "GKLQPWSGL";
      }
      public java.lang.String label() {
        return "GKLQPWSHL";
      }
      public java.lang.String notesBox() {
        return "GKLQPWSIL";
      }
      public java.lang.String saveButton() {
        return "GKLQPWSJL";
      }
      public java.lang.String templateList() {
        return "GKLQPWSKL";
      }
      public java.lang.String textBoxWrapper() {
        return "GKLQPWSLL";
      }
      public java.lang.String title() {
        return "GKLQPWSML";
      }
      public java.lang.String violation() {
        return "GKLQPWSNL";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
