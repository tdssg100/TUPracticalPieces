package com.google.gwt.personal.tupracticalpieces.client.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenBundle_ja_InlineClientBundleGenerator implements com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenBundle {
  private static AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenBundle_ja_InlineClientBundleGenerator _instance0 = new AdminMileageReadView_AdminMileageReadViewUiBinderImpl_GenBundle_ja_InlineClientBundleGenerator();
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GP-OPMDKM{padding:" + ("4px"+ " " +"10px")  + ";font-size:" + ("14pt")  + ";font-weight:" + ("bold")  + ";color:" + ("#666")  + ";}.GP-OPMDDM{padding:" + ("10px")  + ";background:" + ("white")  + ";}.GP-OPMDFM{color:" + ("#333")  + ";font-size:" + ("10pt")  + ";padding-bottom:" + ("3px")  + ";}.GP-OPMDEM{width:" + ("300px")  + ";}.GP-OPMDJM{margin-left:") + (("10px")  + ";}.GP-OPMDGM{height:" + ("6em")  + ";}.GP-OPMDLM{color:" + ("red")  + ";}.GP-OPMDAM{padding-top:" + ("8px")  + ";padding-bottom:" + ("8px")  + ";color:" + ("#3f3f3f")  + ";}.GP-OPMDCM{text-align:" + ("center")  + ";}.GP-OPMDBM{padding:" + ("10px")  + ";margin-top:" + ("15px")  + ";}.GP-OPMDHM{width:" + ("130px")  + ";margin-left:" + ("5px") ) + (";}.GP-OPMDIM{border-right:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";}")) : ((".GP-OPMDKM{padding:" + ("4px"+ " " +"10px")  + ";font-size:" + ("14pt")  + ";font-weight:" + ("bold")  + ";color:" + ("#666")  + ";}.GP-OPMDDM{padding:" + ("10px")  + ";background:" + ("white")  + ";}.GP-OPMDFM{color:" + ("#333")  + ";font-size:" + ("10pt")  + ";padding-bottom:" + ("3px")  + ";}.GP-OPMDEM{width:" + ("300px")  + ";}.GP-OPMDJM{margin-right:") + (("10px")  + ";}.GP-OPMDGM{height:" + ("6em")  + ";}.GP-OPMDLM{color:" + ("red")  + ";}.GP-OPMDAM{padding-top:" + ("8px")  + ";padding-bottom:" + ("8px")  + ";color:" + ("#3f3f3f")  + ";}.GP-OPMDCM{text-align:" + ("center")  + ";}.GP-OPMDBM{padding:" + ("10px")  + ";margin-top:" + ("15px")  + ";}.GP-OPMDHM{width:" + ("130px")  + ";margin-right:" + ("5px") ) + (";}.GP-OPMDIM{border-left:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";}"));
      }
      public java.lang.String button() {
        return "GP-OPMDAM";
      }
      public java.lang.String buttonPanel() {
        return "GP-OPMDBM";
      }
      public java.lang.String dateButton() {
        return "GP-OPMDCM";
      }
      public java.lang.String editForm() {
        return "GP-OPMDDM";
      }
      public java.lang.String field() {
        return "GP-OPMDEM";
      }
      public java.lang.String label() {
        return "GP-OPMDFM";
      }
      public java.lang.String notesBox() {
        return "GP-OPMDGM";
      }
      public java.lang.String saveButton() {
        return "GP-OPMDHM";
      }
      public java.lang.String templateList() {
        return "GP-OPMDIM";
      }
      public java.lang.String textBoxWrapper() {
        return "GP-OPMDJM";
      }
      public java.lang.String title() {
        return "GP-OPMDKM";
      }
      public java.lang.String violation() {
        return "GP-OPMDLM";
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
