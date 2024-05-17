package com.google.gwt.personal.tupracticalpieces.client.mobile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class TUPracticalPiecesResourcesMobile_default_InlineClientBundleGenerator implements com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile {
  private static TUPracticalPiecesResourcesMobile_default_InlineClientBundleGenerator _instance0 = new TUPracticalPiecesResourcesMobile_default_InlineClientBundleGenerator();
  private void catI18NInitializer() {
    catI18N = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "catI18N",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 10, 10, false, false
    );
  }
  private static class catI18NInitializer {
    static {
      _instance0.catI18NInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return catI18N;
    }
  }
  public com.google.gwt.resources.client.ImageResource catI18N() {
    return catI18NInitializer.get();
  }
  private void catWidgetsInitializer() {
    catWidgets = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "catWidgets",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage0),
      0, 0, 10, 10, false, false
    );
  }
  private static class catWidgetsInitializer {
    static {
      _instance0.catWidgetsInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return catWidgets;
    }
  }
  public com.google.gwt.resources.client.ImageResource catWidgets() {
    return catWidgetsInitializer.get();
  }
  private void gwtLogoInitializer() {
    gwtLogo = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "gwtLogo",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage1),
      0, 0, 110, 55, false, false
    );
  }
  private static class gwtLogoInitializer {
    static {
      _instance0.gwtLogoInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return gwtLogo;
    }
  }
  public com.google.gwt.resources.client.ImageResource gwtLogo() {
    return gwtLogoInitializer.get();
  }
  private void gwtLogoThumbInitializer() {
    gwtLogoThumb = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "gwtLogoThumb",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage2),
      0, 0, 14, 13, false, false
    );
  }
  private static class gwtLogoThumbInitializer {
    static {
      _instance0.gwtLogoThumbInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return gwtLogoThumb;
    }
  }
  public com.google.gwt.resources.client.ImageResource gwtLogoThumb() {
    return gwtLogoThumbInitializer.get();
  }
  private void loadingInitializer() {
    loading = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "loading",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage3),
      0, 0, 16, 16, true, false
    );
  }
  private static class loadingInitializer {
    static {
      _instance0.loadingInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return loading;
    }
  }
  public com.google.gwt.resources.client.ImageResource loading() {
    return loadingInitializer.get();
  }
  private void localeInitializer() {
    locale = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "locale",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage4),
      0, 0, 16, 16, false, false
    );
  }
  private static class localeInitializer {
    static {
      _instance0.localeInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return locale;
    }
  }
  public com.google.gwt.resources.client.ImageResource locale() {
    return localeInitializer.get();
  }
  private void cssInitializer() {
    css = new com.google.gwt.resources.client.CssResource() {
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
        return "css";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".sc-FixedWidthButton{width:" + ("8em")  + ";}.cw-BasicPopup-thumb{cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";}.cw-DictionaryExample-header{color:" + ("#7aa5d6")  + ";text-decoration:" + ("underline")  + ";font-weight:" + ("bold")  + ";padding-left:" + ("20px")  + ";}.cw-DictionaryExample-data{padding-left:" + ("20px")  + ";}.cw-DockPanel td,.cw-FlexTable td{border:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + ";padding:" + ("3px")  + ";}.cw-FlexTable-buttonPanel td{border:") + (("0")  + ";}.cw-FlowPanel-checkBox{margin-left:" + ("20px")  + ";}.cw-RedText{color:" + ("red")  + ";}.cw-RichText{border:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + ";border-spacing:" + ("0")  + ";}.cw-StackPanelHeader{padding-right:" + ("7px")  + ";font-weight:" + ("bold")  + ";font-size:" + ("1.4em")  + ";}.mileageWedgetHeader{font-size:" + ("8pt")  + ";font-weight:" + ("bold")  + ";line-height:" + ("10pt") ) + (";}.mileageWedgetDate{font-size:" + ("8pt")  + ";text-align:" + ("right")  + ";}.mileageWedgetFloat,.mileageWedgetInt{font-size:" + ("8pt")  + ";text-align:" + ("left")  + ";}.NewsCountMap{height:" + ("100%")  + ";}input[type=\"range\"]:before{content:" + ("attr(min)")  + ";padding-left:" + ("5px")  + ";}input[type=\"range\"]:after{content:" + ("attr(max)")  + ";padding-right:" + ("5px")  + ";}.sliderValue{font-size:" + ("1.5em")  + ";font-weight:") + (("bold")  + ";color:" + ("#777")  + ";margin:" + ("40px"+ " " +"0"+ " " +"70px")  + ";text-align:" + ("center")  + ";}.gra2DListBoxLeft{background-color:" + ("#fcc")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#311")  + ";color:" + ("#855")  + ";}.graphColorFirst{background-color:" + ("#faa")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#311")  + ";color:" + ("#f00")  + ";}.graphColorSecond{background-color:" + ("#afa") ) + (";border:" + ("2px"+ " " +"solid"+ " " +"#311")  + ";color:" + ("#0f0")  + ";}.graphColorThird{background-color:" + ("#aaf")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#311")  + ";color:" + ("#00f")  + ";}.gra2DListBoxRight{background-color:" + ("#cfc")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#131")  + ";color:" + ("#585")  + ";}.gra2DListBoxBottom{background-color:" + ("#ccf")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#113")  + ";color:") + (("#558")  + ";}")) : ((".sc-FixedWidthButton{width:" + ("8em")  + ";}.cw-BasicPopup-thumb{cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";}.cw-DictionaryExample-header{color:" + ("#7aa5d6")  + ";text-decoration:" + ("underline")  + ";font-weight:" + ("bold")  + ";padding-right:" + ("20px")  + ";}.cw-DictionaryExample-data{padding-right:" + ("20px")  + ";}.cw-DockPanel td,.cw-FlexTable td{border:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + ";padding:" + ("3px")  + ";}.cw-FlexTable-buttonPanel td{border:") + (("0")  + ";}.cw-FlowPanel-checkBox{margin-right:" + ("20px")  + ";}.cw-RedText{color:" + ("red")  + ";}.cw-RichText{border:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + ";border-spacing:" + ("0")  + ";}.cw-StackPanelHeader{padding-left:" + ("7px")  + ";font-weight:" + ("bold")  + ";font-size:" + ("1.4em")  + ";}.mileageWedgetHeader{font-size:" + ("8pt")  + ";font-weight:" + ("bold")  + ";line-height:" + ("10pt") ) + (";}.mileageWedgetDate{font-size:" + ("8pt")  + ";text-align:" + ("left")  + ";}.mileageWedgetFloat,.mileageWedgetInt{font-size:" + ("8pt")  + ";text-align:" + ("right")  + ";}.NewsCountMap{height:" + ("100%")  + ";}input[type=\"range\"]:before{content:" + ("attr(min)")  + ";padding-right:" + ("5px")  + ";}input[type=\"range\"]:after{content:" + ("attr(max)")  + ";padding-left:" + ("5px")  + ";}.sliderValue{font-size:" + ("1.5em")  + ";font-weight:") + (("bold")  + ";color:" + ("#777")  + ";margin:" + ("40px"+ " " +"0"+ " " +"70px")  + ";text-align:" + ("center")  + ";}.gra2DListBoxLeft{background-color:" + ("#fcc")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#311")  + ";color:" + ("#855")  + ";}.graphColorFirst{background-color:" + ("#faa")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#311")  + ";color:" + ("#f00")  + ";}.graphColorSecond{background-color:" + ("#afa") ) + (";border:" + ("2px"+ " " +"solid"+ " " +"#311")  + ";color:" + ("#0f0")  + ";}.graphColorThird{background-color:" + ("#aaf")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#311")  + ";color:" + ("#00f")  + ";}.gra2DListBoxRight{background-color:" + ("#cfc")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#131")  + ";color:" + ("#585")  + ";}.gra2DListBoxBottom{background-color:" + ("#ccf")  + ";border:" + ("2px"+ " " +"solid"+ " " +"#113")  + ";color:") + (("#558")  + ";}"));
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.google.gwt.resources.client.CssResource get() {
      return css;
    }
  }
  public com.google.gwt.resources.client.CssResource css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAABVElEQVR4XmNgYPjPqBVaz1a/5FBI97oz//deewnEL/53rzv1v2v18ZRJ207w1dfXMzFYhvZxZves+++X2/G/Z9m+/1ef//g/Zdul/wv23fovZxvzv2fT5f8OCfM5GOoW740ECai5pv7P617yf8r2K//7Np7775LcBFYIwpVz9sQz+BdNOgriKDkm/NfxzvxfMnnD/2nbL6MorF108D8DjCNvF/tfwT7+v7JTIliRlmcGHIP4YIUgRSAFINosvAQsYRRYCKar5+4GmnjoP0Ny+7L/SkBFIA3m4eX/LaMq4CY2Ltjzv2/T+f9LT73+z1C7aE+Ed27Pf0OgCa5prWAFFkANIMWtq07+b1937n/LiiMWDHqx3dzdGy7898ru/h9cMgWsKLtn9f+21Sf/1y058r9qybH/oLBmABPAAO1af0a5Z9OF/1Uzt4Fx26rjQHwiBKqIAQCRStvzYSb5igAAAABJRU5ErkJggg==";
  private static final java.lang.String externalImage0 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAiUlEQVR4XmNgQAOxxV3/sWF0dWCFq/dfRcFwhbM2nvg/a8OJ/10Ld4AFcSqcueH4/ztv/y/bc+HJPrwKZ6w7Cla4+/zj/TgVmgdm/0fG6J6AewYkOXnJVjBumrIcrHj/mZv/jl578a955gaEb5EVgjCIf+/tn38gPGXVQfwKQQpgGEUhOoZLIgEA1/zTmwOxCnEAAAAASUVORK5CYII=";
  private static final java.lang.String externalImage1 = "data:image/png;base64,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";
  private static final java.lang.String externalImage2 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAANCAYAAACZ3F9/AAACoklEQVR4Xm2Sa0hTcRjG/+VlTrezs3M85+y45SW8bFMnbV5WUt4FL5Cz+rCMggIpogsplBSJZKKhEN0skZRQu2lCRuqGlJqKiRcQk0wjCi1Q0CIMRPd0sgKJXng/vA+/9wYPIRsiIyNDlrbHbk+z2UviEzPrLFE7xvThsRMHAyIOl1Ja6ykfXpCwTRt7yAkSLMvzD4s3xyVP2nXGkQs6/XiDLnzqmr/pW9WWyLVOjXG20S/saQUdeHp9QBEbqL8SYLhRrwkdatOFfyrRx6289DOtfOQiMa+OWM8PggnTbAh6KRF3WeF7sVo8QGqTUwsnr1a5Fm2HsORnwYIQhVnOiBlBj7dxyRiLT8JQQgr6TBY4PRRoVdC4zAhPSM2uxOq59sdYqqvBMB+EflrECyWLV8YojNr2oScoFAMWKwZitqNDrkIbx6GcEbtJRaD2ztTxXHxtqcWgJRoON2843H0wXVYOJ82hw0uJdhWDDsYXTmlbq5JGmVpsIvk80/LGKmKpqgAjOVl47kOjg2YxU30Lnb48OiWwJyAYgzuT0EVxeCTVlxhNJclRq1pHzbxr2R6Nif3ZcEhTO+VKvK+swnD2bjg9FegNNmDq3Hl0+wejkWJQyohnSJJC0dS3TVj9kaLFu9RoCVSun9uzNQxzDY0Yzd2L/rh49KWmo5kXXddZ4XOxWpNJ9DKv2/cM4sJigohpqwFOGfX7Tym7wyLQnZ6OB0ajq5Lmv5xVcfdPynlbPlGriDshBeneyuauGN3ypDkIDm8az+QUHtLM2k2On7+o4l4f8WGL0jxU0bFEyUpe2fzXNGZPQvKO8r7O1siQ1TpOs1LBCuOFFFef60nbQolcKzES8o/V/oiCQeaddYzVVOcrfQuyPajYcEIxku5G/tPwK34Cn7EVIT5aVUAAAAAASUVORK5CYII=";
  private static final java.lang.String externalImage3 = "data:image/gif;base64,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";
  private static final java.lang.String externalImage4 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAADbklEQVR4XnWSW0yTZxjHv9vtYuF62ZUhYXGSLGDUMedwg5FB5SB8LcxSSu2K1YFtmdBPjk4OLaWHFWjr9/VAC5SWU2spKgcZoC0Vi6AzDhHUuYHbyJLFy23430cvyEayf/LcvHl+v+d5k4cg9qS8TvcRPTThco3demEP3n5tHJjYVtmGn8qaOplD6YUH9/bvJjVXFufwTXvCK5uYWXsO38MQHNFRdIQHoZ3xon0igG+c/u0MYRX9dvKJN/8DC2UNcZ7xyOKt1S3cWH0Jy51h6G/bYQxZoZ6lUTthgjxghHRQi6+YbiTnlU+/8wH5xq6AGZka8C5E4FpchWP5RzTcdOLCtVYor7dCMdaC5rkg1OE1KIJRlDqnwbnYi4Q0UVcMVup7UtuDXlQHGFz+bh2qyBacj/6A7JoJX3gU4PVXwrS0gcvh33Au+AykPYoPmzqQdKru733HyERCYbC5Jb0tKHI5cebqOqjZX9B25wXy+yhkdksh9puhi/6Oi+x7WeApChxLOKzqwrsyPhI+E31LkI1NL48bzuJzix+lQ6uQT/6MUv8IjjNl4Ho00Cxs4VLoV8inNiD2rbGC+0jTziCeykF8Pu8BkVJRiYRGEqnGPvD7H+HM6DMIfFNIMUsg9PtjkxUsLA0+h8C7gjzrPXzaPo33avg4wC17RRwQSxFfl4eDmpaYvWTgMSSBdWQ5LTjp7oV07ElMurMdz/U9skx3kaGZwYn6QRwpqn5FJAoqNvfXlOBY2xA45rvgOh+wm/zAAo+R3T2AdMaEYs9KDM6hF5FpnEdu+02crHPj4+KaZeL9AmVPqtwBjnoSWcYwcukoSMcyClmgqOdhDMyzRZBi0CGrcx7pOgcKNddRQFlBUswksZ9TcfRQqcrLbR0FzzgL0hwBj4mi0H6PrSVwLD4kacTsF8U4qqtgBXKUtA6DVOgXPxFSsp1TiEvMLtfnVFtx2jAOkXkOQnoeAmYBxWyRlgAyOihwzZ0oMNdC0KGFpMm5mSmiJln2rd1rTM5XzImaeyHp6oP4Sj9EdD/KmBs4bwuh0h5ClW0WX9MjqDJ4N/Ol9Uu74L+TlC2x8dTUa8EVJUoYCmJ7Iy443Ki3jqOBHoXS4N7OLJbtTP7/pJ06/2UaXzbOr23ekGhVf501tP157lLXTw100Futd6v39v8Dt/sucm1YCboAAAAASUVORK5CYII=";
  private static com.google.gwt.resources.client.ImageResource catI18N;
  private static com.google.gwt.resources.client.ImageResource catWidgets;
  private static com.google.gwt.resources.client.ImageResource gwtLogo;
  private static com.google.gwt.resources.client.ImageResource gwtLogoThumb;
  private static com.google.gwt.resources.client.ImageResource loading;
  private static com.google.gwt.resources.client.ImageResource locale;
  private static com.google.gwt.resources.client.CssResource css;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      catI18N(), 
      catWidgets(), 
      gwtLogo(), 
      gwtLogoThumb(), 
      loading(), 
      locale(), 
      css(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("catI18N", catI18N());
        resourceMap.put("catWidgets", catWidgets());
        resourceMap.put("gwtLogo", gwtLogo());
        resourceMap.put("gwtLogoThumb", gwtLogoThumb());
        resourceMap.put("loading", loading());
        resourceMap.put("locale", locale());
        resourceMap.put("css", css());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'catI18N': return this.@com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile::catI18N()();
      case 'catWidgets': return this.@com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile::catWidgets()();
      case 'gwtLogo': return this.@com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile::gwtLogo()();
      case 'gwtLogoThumb': return this.@com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile::gwtLogoThumb()();
      case 'loading': return this.@com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile::loading()();
      case 'locale': return this.@com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile::locale()();
      case 'css': return this.@com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile::css()();
    }
    return null;
  }-*/;
}
