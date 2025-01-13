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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GP-OPMDOL{padding:" + ("4px"+ " " +"10px")  + ";font-size:" + ("14pt")  + ";font-weight:" + ("bold")  + ";color:" + ("#666")  + ";}.GP-OPMDHL{padding:" + ("10px")  + ";background:" + ("white")  + ";}.GP-OPMDJL{color:" + ("#333")  + ";font-size:" + ("10pt")  + ";padding-bottom:" + ("3px")  + ";}.GP-OPMDIL{width:" + ("300px")  + ";}.GP-OPMDNL{margin-left:") + (("10px")  + ";}.GP-OPMDKL{height:" + ("6em")  + ";}.GP-OPMDPL{color:" + ("red")  + ";}.GP-OPMDDL{padding-top:" + ("8px")  + ";padding-bottom:" + ("8px")  + ";color:" + ("#3f3f3f")  + ";}.GP-OPMDFL{text-align:" + ("center")  + ";}.GP-OPMDEL{padding:" + ("10px")  + ";margin-top:" + ("15px")  + ";}.GP-OPMDLL{width:" + ("130px")  + ";margin-left:" + ("5px") ) + (";}.GP-OPMDGL{width:" + ("130px")  + ";margin-right:" + ("5px")  + ";color:" + ("white")  + ";background:" + ("#940000")  + ";}.GP-OPMDML{border-right:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";}")) : ((".GP-OPMDOL{padding:" + ("4px"+ " " +"10px")  + ";font-size:" + ("14pt")  + ";font-weight:" + ("bold")  + ";color:" + ("#666")  + ";}.GP-OPMDHL{padding:" + ("10px")  + ";background:" + ("white")  + ";}.GP-OPMDJL{color:" + ("#333")  + ";font-size:" + ("10pt")  + ";padding-bottom:" + ("3px")  + ";}.GP-OPMDIL{width:" + ("300px")  + ";}.GP-OPMDNL{margin-right:") + (("10px")  + ";}.GP-OPMDKL{height:" + ("6em")  + ";}.GP-OPMDPL{color:" + ("red")  + ";}.GP-OPMDDL{padding-top:" + ("8px")  + ";padding-bottom:" + ("8px")  + ";color:" + ("#3f3f3f")  + ";}.GP-OPMDFL{text-align:" + ("center")  + ";}.GP-OPMDEL{padding:" + ("10px")  + ";margin-top:" + ("15px")  + ";}.GP-OPMDLL{width:" + ("130px")  + ";margin-right:" + ("5px") ) + (";}.GP-OPMDGL{width:" + ("130px")  + ";margin-left:" + ("5px")  + ";color:" + ("white")  + ";background:" + ("#940000")  + ";}.GP-OPMDML{border-left:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";}"));
      }
      public java.lang.String button() {
        return "GP-OPMDDL";
      }
      public java.lang.String buttonPanel() {
        return "GP-OPMDEL";
      }
      public java.lang.String dateButton() {
        return "GP-OPMDFL";
      }
      public java.lang.String deleteButton() {
        return "GP-OPMDGL";
      }
      public java.lang.String editForm() {
        return "GP-OPMDHL";
      }
      public java.lang.String field() {
        return "GP-OPMDIL";
      }
      public java.lang.String label() {
        return "GP-OPMDJL";
      }
      public java.lang.String notesBox() {
        return "GP-OPMDKL";
      }
      public java.lang.String saveButton() {
        return "GP-OPMDLL";
      }
      public java.lang.String templateList() {
        return "GP-OPMDML";
      }
      public java.lang.String textBoxWrapper() {
        return "GP-OPMDNL";
      }
      public java.lang.String title() {
        return "GP-OPMDOL";
      }
      public java.lang.String violation() {
        return "GP-OPMDPL";
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
