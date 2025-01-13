package com.google.gwt.user.cellview.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class CellTree_Resources_en_InlineClientBundleGenerator implements com.google.gwt.user.cellview.client.CellTree.Resources {
  private static CellTree_Resources_en_InlineClientBundleGenerator _instance0 = new CellTree_Resources_en_InlineClientBundleGenerator();
  private void cellTreeClosedItemInitializer() {
    cellTreeClosedItem = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTreeClosedItem",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?externalImage_rtl : externalImage),
      0, 0, 15, 15, false, false
    );
  }
  private static class cellTreeClosedItemInitializer {
    static {
      _instance0.cellTreeClosedItemInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTreeClosedItem;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTreeClosedItem() {
    return cellTreeClosedItemInitializer.get();
  }
  private void cellTreeLoadingInitializer() {
    cellTreeLoading = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTreeLoading",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?externalImage_rtl0 : externalImage0),
      0, 0, 16, 16, true, false
    );
  }
  private static class cellTreeLoadingInitializer {
    static {
      _instance0.cellTreeLoadingInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTreeLoading;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTreeLoading() {
    return cellTreeLoadingInitializer.get();
  }
  private void cellTreeOpenItemInitializer() {
    cellTreeOpenItem = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTreeOpenItem",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?externalImage_rtl1 : externalImage1),
      0, 0, 15, 15, false, false
    );
  }
  private static class cellTreeOpenItemInitializer {
    static {
      _instance0.cellTreeOpenItemInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTreeOpenItem;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTreeOpenItem() {
    return cellTreeOpenItemInitializer.get();
  }
  private void cellTreeSelectedBackgroundInitializer() {
    cellTreeSelectedBackground = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "cellTreeSelectedBackground",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?externalImage_rtl2 : externalImage2),
      0, 0, 82, 26, false, false
    );
  }
  private static class cellTreeSelectedBackgroundInitializer {
    static {
      _instance0.cellTreeSelectedBackgroundInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return cellTreeSelectedBackground;
    }
  }
  public com.google.gwt.resources.client.ImageResource cellTreeSelectedBackground() {
    return cellTreeSelectedBackgroundInitializer.get();
  }
  private void cellTreeStyleInitializer() {
    cellTreeStyle = new com.google.gwt.user.cellview.client.CellTree.Style() {
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
        return "cellTreeStyle";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GP-OPMDLG{padding-right:" + ("16px")  + ";font-style:" + ("italic")  + ";}.GP-OPMDMG{padding-top:" + ("4px")  + ";padding-bottom:" + ("4px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";zoom:" + ("1")  + ";}.GP-OPMDOG{zoom:" + ("1")  + ";}.GP-OPMDPG{padding-right:" + ("3px")  + ";padding-left:" + ("3px")  + ";outline:") + (("none")  + ";}.GP-OPMDEH{font-weight:" + ("bold")  + ";color:" + ("#4b4a4a")  + ";margin-top:" + ("20px")  + ";padding:" + ("3px"+ " " +"10px"+ " " +"3px"+ " " +"13px")  + " !important;}.GP-OPMDGH{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#6f7277")  + ";padding-bottom:" + ("1px")  + ";}.GP-OPMDAH{background-color:" + ("#ffc")  + ";outline:" + ("none")  + ";}.GP-OPMDCH{height:" + ((CellTree_Resources_en_InlineClientBundleGenerator.this.cellTreeSelectedBackground()).getHeight() + "px")  + ";overflow:" + ("hidden") ) + (";background:" + ("url(\"" + (CellTree_Resources_en_InlineClientBundleGenerator.this.cellTreeSelectedBackground()).getSafeUri().asString() + "\") -" + (CellTree_Resources_en_InlineClientBundleGenerator.this.cellTreeSelectedBackground()).getLeft() + "px -" + (CellTree_Resources_en_InlineClientBundleGenerator.this.cellTreeSelectedBackground()).getTop() + "px  repeat-x")  + ";background-color:" + ("#628cd5")  + ";color:" + ("white")  + ";height:" + ("auto")  + ";overflow:" + ("visible")  + ";}.GP-OPMDDH{padding-right:" + ("16px")  + ";outline:" + ("none")  + ";}")) : ((".GP-OPMDLG{padding-left:" + ("16px")  + ";font-style:" + ("italic")  + ";}.GP-OPMDMG{padding-top:" + ("4px")  + ";padding-bottom:" + ("4px")  + ";cursor:" + ("hand")  + ";cursor:" + ("pointer")  + ";zoom:" + ("1")  + ";}.GP-OPMDOG{zoom:" + ("1")  + ";}.GP-OPMDPG{padding-left:" + ("3px")  + ";padding-right:" + ("3px")  + ";outline:") + (("none")  + ";}.GP-OPMDEH{font-weight:" + ("bold")  + ";color:" + ("#4b4a4a")  + ";margin-top:" + ("20px")  + ";padding:" + ("3px"+ " " +"13px"+ " " +"3px"+ " " +"10px")  + " !important;}.GP-OPMDGH{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#6f7277")  + ";padding-bottom:" + ("1px")  + ";}.GP-OPMDAH{background-color:" + ("#ffc")  + ";outline:" + ("none")  + ";}.GP-OPMDCH{height:" + ((CellTree_Resources_en_InlineClientBundleGenerator.this.cellTreeSelectedBackground()).getHeight() + "px")  + ";overflow:" + ("hidden") ) + (";background:" + ("url(\"" + (CellTree_Resources_en_InlineClientBundleGenerator.this.cellTreeSelectedBackground()).getSafeUri().asString() + "\") -" + (CellTree_Resources_en_InlineClientBundleGenerator.this.cellTreeSelectedBackground()).getLeft() + "px -" + (CellTree_Resources_en_InlineClientBundleGenerator.this.cellTreeSelectedBackground()).getTop() + "px  repeat-x")  + ";background-color:" + ("#628cd5")  + ";color:" + ("white")  + ";height:" + ("auto")  + ";overflow:" + ("visible")  + ";}.GP-OPMDDH{padding-left:" + ("16px")  + ";outline:" + ("none")  + ";}"));
      }
      public java.lang.String cellTreeEmptyMessage() {
        return "GP-OPMDLG";
      }
      public java.lang.String cellTreeItem() {
        return "GP-OPMDMG";
      }
      public java.lang.String cellTreeItemImage() {
        return "GP-OPMDNG";
      }
      public java.lang.String cellTreeItemImageValue() {
        return "GP-OPMDOG";
      }
      public java.lang.String cellTreeItemValue() {
        return "GP-OPMDPG";
      }
      public java.lang.String cellTreeKeyboardSelectedItem() {
        return "GP-OPMDAH";
      }
      public java.lang.String cellTreeOpenItem() {
        return "GP-OPMDBH";
      }
      public java.lang.String cellTreeSelectedItem() {
        return "GP-OPMDCH";
      }
      public java.lang.String cellTreeShowMoreButton() {
        return "GP-OPMDDH";
      }
      public java.lang.String cellTreeTopItem() {
        return "GP-OPMDEH";
      }
      public java.lang.String cellTreeTopItemImage() {
        return "GP-OPMDFH";
      }
      public java.lang.String cellTreeTopItemImageValue() {
        return "GP-OPMDGH";
      }
      public java.lang.String cellTreeWidget() {
        return "GP-OPMDHH";
      }
    }
    ;
  }
  private static class cellTreeStyleInitializer {
    static {
      _instance0.cellTreeStyleInitializer();
    }
    static com.google.gwt.user.cellview.client.CellTree.Style get() {
      return cellTreeStyle;
    }
  }
  public com.google.gwt.user.cellview.client.CellTree.Style cellTreeStyle() {
    return cellTreeStyleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAPCAYAAAA71pVKAAAAwElEQVR4XmNgGPogr6KzIbeiM7q+vp4NXY4gAGq8klfZ+Se/onNLflV3DLo8XpBX1XkYaPt/KP4MNGhXTkVXKLo6rCC3svNkXmXXf6AmCIYY8gHooiN55R3+6OpRAFDjKYTmrv9ATWAMFqvo/AoUX46uBw5yK0Ca4YrhtudXdr0E0jOzq3vk0fXAAcjZMNsgNnbeB4bD7PyyTnV0tRggr7zzPFTTXaCmqQVlnZroanACoMYVQOdNz69oN0WXG0YAAC38dueW7qlRAAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage_rtl = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAPCAYAAAA71pVKAAAAvUlEQVR4XmNgGL6gvr6eLbeiMzqvorMBXQ4vyK/qjsmv6NySV9n5B2jAFXR5rCCnoisUqGEX0LbPQPwfjKs6D6OrQwF55R3+QBuOABV/AGuohOGu/7mVnSfR1cMBUNFyoIavYIVAjSAMYsM0A/EpdD1wkF3dIw/UPDO/susl3FYkA3Ir8GiGgfyyTnWg/2YDNdyHuQCM8TkbHRSUdWoCDZkKNOQu2AvlnefR1RAE+RXtpkDnTwcasAJdbggCAPUZdudt9wylAAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage0 = "data:image/gif;base64,R0lGODlhEAAQAPIAAP///255itve4pObqG55iqWstre9xcDFzCH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==";
  private static final java.lang.String externalImage_rtl0 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAeElEQVR4XmNgGAVDENy+9+j/5NkrwBjERpcnCEAa8yq7wBjERpcnCCg2AK8XQAIYglAAEl+6ZhsYY1UD04zLkO17j8JtBhmCLo9hAAgfOHoGjEFsZANAbHT9YIBsO7IByIbg9AI6AGkCaQBhEBtdniCAuQBXmMAAACY3w0kkIFmSAAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage1 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAPCAYAAAA71pVKAAAAwklEQVR4XmNgGPogt6JzRV555/ncys6TuRVdp/Iqu06B2HlVnYeBclfyKjob0PXAAVByOlDRfxDOqwThLgiG8P8AxaPR9cBBfkW7KVDRXYhmkEaoIUB+fkXnlvr6ejZ0PSgA6MSpYM3IBlR0fs6v6o5BV4sBCso6NYEa7oM0IQzp3IWuDicA2j4bpAmq+UNORVcouhqcIL+sUz2/suslyNlAA46gyxMEQBtnAvHXvPIOf3Q5giC7ukce6Nfl6OLDAAAA2QV25/ovWEQAAAAASUVORK5CYII=";
  private static final java.lang.String externalImage_rtl1 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAPCAYAAAA71pVKAAAAw0lEQVR4XmNgGPogr6KzIbei80peVefh3MrOk3mVXadyK4AYxC7vPA+UW4GuBw6AktF5lZ1/gIb8B2qE4s7/QHEwBopPR9cDB/X19Wz5FZ1bIJphuAuisbLzbn5Fuym6HhSQX9UdA9T8GaYRZBBYc1XnVHS1WAFQ4y64JogL7heUdWqiq8MKciq6QoGaP0D9CbJ1NroavACo8QjI2fmVXS/zyzrV0eXxgrzyDn+grV+BeCa6HFEA6Nfl2dU98ujiQxwAAGgNducmuWVfAAAAAElFTkSuQmCC";
  private static final java.lang.String externalImage2 = "data:image/png;base64,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";
  private static final java.lang.String externalImage_rtl2 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFIAAAAaCAYAAAAkJwuaAAAHcElEQVR4Xu1SWXdWRRC8PxWC7IrgAhzBY1BAlnwEAihwXEFRUNkJ/JCwh0VZBAVJCMvjOFXVPdN38vGkjzz06a2quuae241feJnGL75KuyZfMsYvvErjod6dd9ij9lkv225o+N4w1JrMOe5Zh1veN7rFG+JixfbmQQ9791dq40adeKN3K3CqL3F6N3n3VeoGeTiYfJGQ/WN6YF77Vz2c6rqP8ziLuAE1fN7q176vIX70F2f1brw538vrblSt6NP38Y19H+2+Gzv3nM3Y+ecMgj3n3dg526E+/4J5cF6Y0ht/cH7OODZjPWdaVcd30gj95Fzu54xXwzW9HkyKh/viuD/zRM36FmnbPcfxvnvEzO8qc8d9wJyzb1Pu2MfNfbfz7FzacXou7Tz7LO3IgZ4zmzOfaeI0sIY7o7wT2ffGL/tzVpte0Q/8kgOPd8DxG4xnxYf65/RdZ8+qjxDlpvkr7+QOGjYPfqK3yO3NLbptp2cT49SztD0b//zkLGMb6jzDfNvpGfbI3J2aJRaz7acMf0oawpkmwrS44z7i/bZj8s50pI+7M+KBA2+ONX314AgH7e3FB/jyynnjR1y9jZis4e/adtLebJ78jr7PDLHU4rtmU7c1N1tOPk1bf1NszrHF48RT7jSbKfNef0I8Ym1HLej6Ph/mHrXhNFe/9YTtqTkjPyfVbz0xyz0zetvRg2lKa5Z3qMf71a97Y0CXGGF9zhp3wl3vN9tb+U73Hvsc3ae//pM+y1HyL6if1L7kJ8zCPCHO8ZpXTsFFbtEV1/V8VmrsuA9+/FbvXt3FfcH53mYM6+MbW23kTcfD+3t799l/I6L75Oe/0+ixJwm5xLE8Ox77xzk/zrPHdXesYrEDZpPtyzzPRr3HHezLnapHfWZ4MV5+DO6oryGv0ik71zsGTr1JDXBMy7GjxnW+16P0BE6Ncsduxl48fZtu49GH6eOfHimO/pWzYmOuN/74MMcjq4Vhjzl4NueeXNTgoAfGNLAz7Q3QcbyFcKjBtxvM8GYY8jADXvUG7ANHe/nRO+C5evdaHuHLvYirW3aDfvwb+FsMV+b2TbJe99EPf6Z+PGzqHEesP4I67gNmGG+e3pD94ZZn9WHcQ8SbzrFd1CIm4NAT19xvtYbxXqdZMEHPolv33b207rv7ad33D3Ig30/rkTHjPPeHUd+rO2IfcI5eIf76w5o7T3hxqcHdA9bCGc90q04N52oHLnDuNdaOtWx33X/1alG07a69sYR/G87rHZ+Bs9Zy9+G3dxPjGwv295q+7tdGLMOw4BTsPR5YW3ZBq+jWG2tZgy8OboBftJkd0+j53UazNx/mlXeDTtHz/Wu0mp2/sXv/qz/SvPj6bnqvmdX+bt03uB4nYOJeGGn0bwY+ueIjPjAsZuQGvahR9kNu9vz3+MGHeXZs9RP6WAdct/rQ7bTm0O9pdY41h+4wVjN7j4w96tuW23CMsjSiZqvV3lStuXORvRc+hvuoXiMHvd9o77a6VaP6H3arajoWfOd07x68nTxWHbyVVh1AjXyrzpCtn4+PuFqXfMDnysLfYWZwfsc0ndfeC9qcO8/r1hf0qx7u+Zy3g5f6ZuE0cz/1jdQsevLoflB373x5MyHe/iKHZc1uhbrOiRsyjzFsNmzf4ko/T9+8HLDAHLMc2GHW+nNe0QCmvcOQBvUaX8T7PWgS12po1q3YdyOt3D+dVuy/mWo9zXrFPuTpTFJWZMy+mxmHqDjNpOMavl9JPnjTVusWdKEjDdxGLX4NeZKW7vJe2bf4IVzemeZ93ur5kga1g270Xd5ne34H8+O7bnkGLt97PYfysolc59myWE9cK5n1xA1G3StL45plYKouMrgwpp1uLLcZNKhDjuuahu1W7NUHV487xsk3qVXuhjdNOMd8gsO7mOFdFedvKF6Kj0aberrv36JbuudaWrrnalLOsRu199ctbFdmwCEDpx7HWE/4znUtMAMGJsmxGzbDnvN8f8nuwM112yMDuwReoVu8BH97Is/mxIVsdwvGPPbv+R7Y/E733HyPbvH4FRKX7L6SVOewzH4c+SqDOw/O273lMFd9zbSxF48c0xKu8ljzg7oX13asPpJr1Vt6R/HmPNOq2PrW6EvfQW9wT/UNwV/x7Jr5Q76160qaFwPlxe08x6LB5by/HPoWc7nMmJv9otfoAsf5IGhGrmuVmXtocuD4Hegtsn3Pb6j786t118NIw31GLx2WPJTzyOAS8yLmS2lkDHU/5s/ERR4ZE0+zOnftPhdznznWdIqG7+JeuxHju07EYee68tT3EvWAGzF/cQ8e5qrdl3FKNi8Z2/GBg6m0kMQpCZjIwp2X8hyEKfVjwmHux0fGnAO87YkHN2CJ8Xl8AGrp64buChfu9e7i5hQfI9+6LQ/GM436PucFPObM7sPuFK96s7/F3ygvuiHd/EfSKGLHlIK9DizwDxOIC4iZYmZNTMBh5zzu/YMYPnwcf3DvFntpSV86hRt9gFc8V4+9G67feOl5w0cv/sUpb3PNcj/cCRpdPfYm/ku8+ZD/U/wLUOGYyjDRrH4AAAAASUVORK5CYII=";
  private static com.google.gwt.resources.client.ImageResource cellTreeClosedItem;
  private static com.google.gwt.resources.client.ImageResource cellTreeLoading;
  private static com.google.gwt.resources.client.ImageResource cellTreeOpenItem;
  private static com.google.gwt.resources.client.ImageResource cellTreeSelectedBackground;
  private static com.google.gwt.user.cellview.client.CellTree.Style cellTreeStyle;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      cellTreeClosedItem(), 
      cellTreeLoading(), 
      cellTreeOpenItem(), 
      cellTreeSelectedBackground(), 
      cellTreeStyle(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("cellTreeClosedItem", cellTreeClosedItem());
        resourceMap.put("cellTreeLoading", cellTreeLoading());
        resourceMap.put("cellTreeOpenItem", cellTreeOpenItem());
        resourceMap.put("cellTreeSelectedBackground", cellTreeSelectedBackground());
        resourceMap.put("cellTreeStyle", cellTreeStyle());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'cellTreeClosedItem': return this.@com.google.gwt.user.cellview.client.CellTree.Resources::cellTreeClosedItem()();
      case 'cellTreeLoading': return this.@com.google.gwt.user.cellview.client.CellTree.Resources::cellTreeLoading()();
      case 'cellTreeOpenItem': return this.@com.google.gwt.user.cellview.client.CellTree.Resources::cellTreeOpenItem()();
      case 'cellTreeSelectedBackground': return this.@com.google.gwt.user.cellview.client.CellTree.Resources::cellTreeSelectedBackground()();
      case 'cellTreeStyle': return this.@com.google.gwt.user.cellview.client.CellTree.Resources::cellTreeStyle()();
    }
    return null;
  }-*/;
}
