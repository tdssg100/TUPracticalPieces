/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
//package com.google.gwt.personal.tupracticalpieces.client;
package com.google.gwt.personal.tupracticalpieces.client.desktop;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;

/**
 * The images and styles used throughout the TUPracticalPieces.
 */
public interface TUPracticalPiecesResourcesDesktop extends ClientBundle {
  ImageResource catI18N();
  
  ImageResource catWidgets();
  
  /**
   * The styles used in LTR mode.
   */
  /* 201305 remove style and source code */
  /* 201407 add CwFrame.css TODO GSS */
  @NotStrict
//20161207
//  @Source({"../TUPracticalPieces.css", "../content/widgets/CwCanvas3d.css", "../content/widgets/CwCanvas2d.css"})
  @Source({"../TUPracticalPieces.css", "../content/CwCanvas3d.css", "../content/CwCanvas2d.css"})
  CssResource css();
  /* 201305 remove style and source code tab */
  /*
  interface MainCss extends CssResource {
	@NotStrict
	@Source("TUPracticalPieces.css")
    String widget();
  }
  
  interface CbCssCanvas3d extends CssResource {
	@NotStrict
    @Source("content/widgets/CwCanvas3d.css")
    String widget();
  }
  
  @Import({MainCss.class, CbCssCanvas3d.class})
  CssResource css();
  */
  ImageResource gwtLogo();

  ImageResource gwtLogoThumb();

  ImageResource loading();
  
  /**
   * Indicates the locale selection box.
   */
  ImageResource locale();
  
  
}