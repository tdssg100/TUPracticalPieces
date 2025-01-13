package com.google.gwt.personal.tupracticalpieces.client.mobile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class MileageEditViewMobile_AdminMileageEditViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements com.google.gwt.personal.tupracticalpieces.client.mobile.MileageEditViewMobile_AdminMileageEditViewUiBinderImpl_GenBundle {
  private static MileageEditViewMobile_AdminMileageEditViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new MileageEditViewMobile_AdminMileageEditViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.google.gwt.personal.tupracticalpieces.client.mobile.MileageEditViewMobile_AdminMileageEditViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GP-OPMDHN{padding:" + ("4px"+ " " +"10px")  + ";font-size:" + ("14pt")  + ";font-weight:" + ("bold")  + ";color:" + ("#666")  + ";}.GP-OPMDAN{padding:" + ("10px")  + ";background:" + ("white")  + ";}.GP-OPMDCN{color:" + ("#333")  + ";font-size:" + ("10pt")  + ";padding-bottom:" + ("3px")  + ";}.GP-OPMDBN{width:" + ("300px")  + ";}.GP-OPMDGN{margin-left:") + (("10px")  + ";}.GP-OPMDDN{height:" + ("6em")  + ";}.GP-OPMDIN{color:" + ("red")  + ";}.GP-OPMDMM{padding-top:" + ("8px")  + ";padding-bottom:" + ("8px")  + ";color:" + ("#3f3f3f")  + ";}.GP-OPMDOM{text-align:" + ("center")  + ";}.GP-OPMDNM{padding:" + ("10px")  + ";margin-top:" + ("15px")  + ";}.GP-OPMDEN{width:" + ("130px")  + ";margin-left:" + ("5px") ) + (";}.GP-OPMDPM{width:" + ("130px")  + ";margin-right:" + ("5px")  + ";color:" + ("white")  + ";background:" + ("#940000")  + ";}.GP-OPMDFN{border-right:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";}")) : ((".GP-OPMDHN{padding:" + ("4px"+ " " +"10px")  + ";font-size:" + ("14pt")  + ";font-weight:" + ("bold")  + ";color:" + ("#666")  + ";}.GP-OPMDAN{padding:" + ("10px")  + ";background:" + ("white")  + ";}.GP-OPMDCN{color:" + ("#333")  + ";font-size:" + ("10pt")  + ";padding-bottom:" + ("3px")  + ";}.GP-OPMDBN{width:" + ("300px")  + ";}.GP-OPMDGN{margin-right:") + (("10px")  + ";}.GP-OPMDDN{height:" + ("6em")  + ";}.GP-OPMDIN{color:" + ("red")  + ";}.GP-OPMDMM{padding-top:" + ("8px")  + ";padding-bottom:" + ("8px")  + ";color:" + ("#3f3f3f")  + ";}.GP-OPMDOM{text-align:" + ("center")  + ";}.GP-OPMDNM{padding:" + ("10px")  + ";margin-top:" + ("15px")  + ";}.GP-OPMDEN{width:" + ("130px")  + ";margin-right:" + ("5px") ) + (";}.GP-OPMDPM{width:" + ("130px")  + ";margin-left:" + ("5px")  + ";color:" + ("white")  + ";background:" + ("#940000")  + ";}.GP-OPMDFN{border-left:" + ("1px"+ " " +"solid"+ " " +"#aaa")  + ";}"));
      }
      public java.lang.String button() {
        return "GP-OPMDMM";
      }
      public java.lang.String buttonPanel() {
        return "GP-OPMDNM";
      }
      public java.lang.String dateButton() {
        return "GP-OPMDOM";
      }
      public java.lang.String deleteButton() {
        return "GP-OPMDPM";
      }
      public java.lang.String editForm() {
        return "GP-OPMDAN";
      }
      public java.lang.String field() {
        return "GP-OPMDBN";
      }
      public java.lang.String label() {
        return "GP-OPMDCN";
      }
      public java.lang.String notesBox() {
        return "GP-OPMDDN";
      }
      public java.lang.String saveButton() {
        return "GP-OPMDEN";
      }
      public java.lang.String templateList() {
        return "GP-OPMDFN";
      }
      public java.lang.String textBoxWrapper() {
        return "GP-OPMDGN";
      }
      public java.lang.String title() {
        return "GP-OPMDHN";
      }
      public java.lang.String violation() {
        return "GP-OPMDIN";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.google.gwt.personal.tupracticalpieces.client.mobile.MileageEditViewMobile_AdminMileageEditViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.google.gwt.personal.tupracticalpieces.client.mobile.MileageEditViewMobile_AdminMileageEditViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.personal.tupracticalpieces.client.mobile.MileageEditViewMobile_AdminMileageEditViewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.google.gwt.personal.tupracticalpieces.client.mobile.MileageEditViewMobile_AdminMileageEditViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
