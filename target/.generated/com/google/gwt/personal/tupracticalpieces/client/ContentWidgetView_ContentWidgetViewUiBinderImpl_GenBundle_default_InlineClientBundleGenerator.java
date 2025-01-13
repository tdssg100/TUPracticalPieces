package com.google.gwt.personal.tupracticalpieces.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ContentWidgetView_ContentWidgetViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements com.google.gwt.personal.tupracticalpieces.client.ContentWidgetView_ContentWidgetViewUiBinderImpl_GenBundle {
  private static ContentWidgetView_ContentWidgetViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new ContentWidgetView_ContentWidgetViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.google.gwt.personal.tupracticalpieces.client.ContentWidgetView_ContentWidgetViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GP-OPMDCL{color:" + ("#4b4a4a")  + ";font-size:" + ("17pt")  + ";font-weight:" + ("bold")  + ";margin:" + ("10px"+ " " +"10px"+ " " +"0")  + ";}.GP-OPMDBL{color:" + ("#4b4a4a")  + ";padding:" + ("10px"+ " " +"0")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#6f7277")  + ";margin:" + ("0"+ " " +"10px"+ " " +"12px"+ " " +"10px")  + ";}#colContainer{width:" + ("100%")  + ";margin-right:" + ("auto")  + ";margin-left:") + (("auto")  + ";text-align:" + ("right")  + ";}#colWrapper{float:" + ("right")  + ";width:" + ("66%")  + ";}#colLeft{border:" + ("none"+ " " +"4em"+ " " +"#fff")  + ";float:" + ("right")  + ";width:" + ("50%")  + ";}#colCenter{border:" + ("none"+ " " +"4em"+ " " +"#fff")  + ";float:" + ("left")  + ";width:" + ("50%")  + ";}#colRight{border:" + ("none"+ " " +"4em"+ " " +"#fff") ) + (";float:" + ("left")  + ";width:" + ("33%")  + ";}")) : ((".GP-OPMDCL{color:" + ("#4b4a4a")  + ";font-size:" + ("17pt")  + ";font-weight:" + ("bold")  + ";margin:" + ("10px"+ " " +"10px"+ " " +"0")  + ";}.GP-OPMDBL{color:" + ("#4b4a4a")  + ";padding:" + ("10px"+ " " +"0")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#6f7277")  + ";margin:" + ("0"+ " " +"10px"+ " " +"12px"+ " " +"10px")  + ";}#colContainer{width:" + ("100%")  + ";margin-left:" + ("auto")  + ";margin-right:") + (("auto")  + ";text-align:" + ("left")  + ";}#colWrapper{float:" + ("left")  + ";width:" + ("66%")  + ";}#colLeft{border:" + ("none"+ " " +"4em"+ " " +"#fff")  + ";float:" + ("left")  + ";width:" + ("50%")  + ";}#colCenter{border:" + ("none"+ " " +"4em"+ " " +"#fff")  + ";float:" + ("right")  + ";width:" + ("50%")  + ";}#colRight{border:" + ("none"+ " " +"4em"+ " " +"#fff") ) + (";float:" + ("right")  + ";width:" + ("33%")  + ";}"));
      }
      public java.lang.String description() {
        return "GP-OPMDBL";
      }
      public java.lang.String name() {
        return "GP-OPMDCL";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.google.gwt.personal.tupracticalpieces.client.ContentWidgetView_ContentWidgetViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.google.gwt.personal.tupracticalpieces.client.ContentWidgetView_ContentWidgetViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.personal.tupracticalpieces.client.ContentWidgetView_ContentWidgetViewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.google.gwt.personal.tupracticalpieces.client.ContentWidgetView_ContentWidgetViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
