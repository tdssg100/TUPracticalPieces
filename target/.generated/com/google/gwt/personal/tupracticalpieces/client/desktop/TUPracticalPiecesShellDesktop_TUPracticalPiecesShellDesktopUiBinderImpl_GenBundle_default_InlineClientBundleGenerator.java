package com.google.gwt.personal.tupracticalpieces.client.desktop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class TUPracticalPiecesShellDesktop_TUPracticalPiecesShellDesktopUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements com.google.gwt.personal.tupracticalpieces.client.desktop.TUPracticalPiecesShellDesktop_TUPracticalPiecesShellDesktopUiBinderImpl_GenBundle {
  private static TUPracticalPiecesShellDesktop_TUPracticalPiecesShellDesktopUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new TUPracticalPiecesShellDesktop_TUPracticalPiecesShellDesktopUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.google.gwt.personal.tupracticalpieces.client.desktop.TUPracticalPiecesShellDesktop_TUPracticalPiecesShellDesktopUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GP-OPMDM{background-color:" + ("#daa")  + ";}.GP-OPMDN{background-color:" + ("#ccf")  + ";}.GP-OPMDDB{padding:" + ("2px"+ " " +"0"+ " " +"2px"+ " " +"22px")  + ";background:" + ("white")  + ";text-align:" + ("left")  + ";}.GP-OPMDCB{font-size:" + ("8pt")  + ";line-height:" + ("10pt")  + ";}.GP-OPMDNB{padding:" + ("0"+ " " +"10px")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#c3c3c3")  + ";}.GP-OPMDMB{color:" + ("#7b8fae")  + ";font-size:") + (("20pt")  + ";font-weight:" + ("bold")  + ";text-shadow:" + ("#ddd"+ " " +"3px"+ " " +"3px"+ " " +"1px")  + ";margin:" + ("0")  + ";padding:" + ("0"+ " " +"4px"+ " " +"0"+ " " +"0")  + ";}.GP-OPMDLB{color:" + ("#888")  + ";font-size:" + ("16pt")  + ";margin:" + ("0")  + ";padding:" + ("0"+ " " +"6px"+ " " +"0"+ " " +"0")  + ";}.GP-OPMDGB{padding:" + ("6px"+ " " +"0"+ " " +"0"+ " " +"10px")  + ";}.GP-OPMDEB{color:" + ("blue") ) + (";font-size:" + ("8pt")  + ";margin-right:" + ("4px")  + ";}.GP-OPMDHB{width:" + ("36px")  + ";height:" + ("16px")  + ";margin:" + ("3px"+ " " +"10px"+ " " +"0"+ " " +"0")  + ";padding:" + ("0")  + ";}.GP-OPMDKB{background:" + ("#d0e4f6")  + ";}.GP-OPMDIB{background:" + ("#ccc")  + ";}.GP-OPMDJB{background:" + ("#3d3d3d")  + ";}.GP-OPMDFB{background-color:" + ("#d7dde8")  + ";border-left:") + (("1px"+ " " +"solid"+ " " +"#c3c3c3")  + ";}.GP-OPMDAB{background-color:" + ("#d7dde8")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#c3c3c3")  + ";padding:" + ("0"+ " " +"10px")  + ";}.GP-OPMDO{margin-left:" + ("20px")  + ";color:" + ("#888")  + ";font-weight:" + ("bold")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";line-height:" + ("20pt")  + ";vertical-align:" + ("middle") ) + (";}.GP-OPMDO:hover{color:" + ("#4b4a4a")  + ";text-decoration:" + ("underline")  + ";}.GP-OPMDP{margin-left:" + ("4px")  + ";}.GP-OPMDBB{font-size:" + ("8pt")  + ";color:" + ("#4b4a4a")  + ";direction:" + ("ltr")  + ";}")) : ((".GP-OPMDM{background-color:" + ("#daa")  + ";}.GP-OPMDN{background-color:" + ("#ccf")  + ";}.GP-OPMDDB{padding:" + ("2px"+ " " +"22px"+ " " +"2px"+ " " +"0")  + ";background:" + ("white")  + ";text-align:" + ("right")  + ";}.GP-OPMDCB{font-size:" + ("8pt")  + ";line-height:" + ("10pt")  + ";}.GP-OPMDNB{padding:" + ("0"+ " " +"10px")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#c3c3c3")  + ";}.GP-OPMDMB{color:" + ("#7b8fae")  + ";font-size:") + (("20pt")  + ";font-weight:" + ("bold")  + ";text-shadow:" + ("#ddd"+ " " +"3px"+ " " +"3px"+ " " +"1px")  + ";margin:" + ("0")  + ";padding:" + ("0"+ " " +"0"+ " " +"0"+ " " +"4px")  + ";}.GP-OPMDLB{color:" + ("#888")  + ";font-size:" + ("16pt")  + ";margin:" + ("0")  + ";padding:" + ("0"+ " " +"0"+ " " +"0"+ " " +"6px")  + ";}.GP-OPMDGB{padding:" + ("6px"+ " " +"10px"+ " " +"0"+ " " +"0")  + ";}.GP-OPMDEB{color:" + ("blue") ) + (";font-size:" + ("8pt")  + ";margin-left:" + ("4px")  + ";}.GP-OPMDHB{width:" + ("36px")  + ";height:" + ("16px")  + ";margin:" + ("3px"+ " " +"0"+ " " +"0"+ " " +"10px")  + ";padding:" + ("0")  + ";}.GP-OPMDKB{background:" + ("#d0e4f6")  + ";}.GP-OPMDIB{background:" + ("#ccc")  + ";}.GP-OPMDJB{background:" + ("#3d3d3d")  + ";}.GP-OPMDFB{background-color:" + ("#d7dde8")  + ";border-right:") + (("1px"+ " " +"solid"+ " " +"#c3c3c3")  + ";}.GP-OPMDAB{background-color:" + ("#d7dde8")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#c3c3c3")  + ";padding:" + ("0"+ " " +"10px")  + ";}.GP-OPMDO{margin-right:" + ("20px")  + ";color:" + ("#888")  + ";font-weight:" + ("bold")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";line-height:" + ("20pt")  + ";vertical-align:" + ("middle") ) + (";}.GP-OPMDO:hover{color:" + ("#4b4a4a")  + ";text-decoration:" + ("underline")  + ";}.GP-OPMDP{margin-right:" + ("4px")  + ";}.GP-OPMDBB{font-size:" + ("8pt")  + ";color:" + ("#4b4a4a")  + ";direction:" + ("ltr")  + ";}"));
      }
      public java.lang.String backgroundDocLayoutPanel() {
        return "GP-OPMDM";
      }
      public java.lang.String backgroundSimpleLayoutPanel() {
        return "GP-OPMDN";
      }
      public java.lang.String contentButton() {
        return "GP-OPMDO";
      }
      public java.lang.String contentButtonSource() {
        return "GP-OPMDP";
      }
      public java.lang.String contentButtons() {
        return "GP-OPMDAB";
      }
      public java.lang.String contentList() {
        return "GP-OPMDBB";
      }
      public java.lang.String link() {
        return "GP-OPMDCB";
      }
      public java.lang.String linkBar() {
        return "GP-OPMDDB";
      }
      public java.lang.String localeBox() {
        return "GP-OPMDEB";
      }
      public java.lang.String mainMenu() {
        return "GP-OPMDFB";
      }
      public java.lang.String options() {
        return "GP-OPMDGB";
      }
      public java.lang.String styleSelectionButton() {
        return "GP-OPMDHB";
      }
      public java.lang.String styleSelectionChrome() {
        return "GP-OPMDIB";
      }
      public java.lang.String styleSelectionDark() {
        return "GP-OPMDJB";
      }
      public java.lang.String styleSelectionStandard() {
        return "GP-OPMDKB";
      }
      public java.lang.String subtitle() {
        return "GP-OPMDLB";
      }
      public java.lang.String title() {
        return "GP-OPMDMB";
      }
      public java.lang.String titleBar() {
        return "GP-OPMDNB";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.google.gwt.personal.tupracticalpieces.client.desktop.TUPracticalPiecesShellDesktop_TUPracticalPiecesShellDesktopUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.google.gwt.personal.tupracticalpieces.client.desktop.TUPracticalPiecesShellDesktop_TUPracticalPiecesShellDesktopUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.personal.tupracticalpieces.client.desktop.TUPracticalPiecesShellDesktop_TUPracticalPiecesShellDesktopUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.google.gwt.personal.tupracticalpieces.client.desktop.TUPracticalPiecesShellDesktop_TUPracticalPiecesShellDesktopUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
