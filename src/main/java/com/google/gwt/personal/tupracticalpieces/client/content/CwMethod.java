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
package com.google.gwt.personal.tupracticalpieces.client.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesData;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesSource;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * Example file.
 */
public class CwMethod extends ContentWidget {
  /**
   * The constants used in this Content Widget.
   */
  @TUPracticalPiecesSource
  public static interface CwConstants extends Constants {
	String cwMethodDescription();
	
	String cwMethodLink();
    
	String cwMethodName();

    String cwMethodP1Title();

    String cwMethodP1content();

    String cwMethodP2Title();

    String cwMethodP2content();

    String cwMethodP3Title();

    String cwMethodP3content();

    String cwMethodP4Title();

    String cwMethodP4content();
  }
   
  /**
   * An instance of the constants.
   */
  @TUPracticalPiecesData
  private final CwConstants constants;

  /**
   * Constructor.
   *
   * @param constants the constants
   */
  public CwMethod(CwConstants constants) {
    super(constants.cwMethodName(), constants.cwMethodDescription(), true);
    this.constants = constants;
  }

  /**
   * Initialize this example.
   */
  @TUPracticalPiecesSource
  @Override
  public Widget onInitialize() {
    // Create a panel to align the Widgets
    VerticalPanel vPanel = new VerticalPanel();
    String widgetStr = "<ol style='list-style-type: none'>";
    widgetStr += "<li><h3>1 " + constants.cwMethodP1Title() + "</h3>"
              + constants.cwMethodP1content() + "</li>";
    widgetStr += "<li><h3>2 " + constants.cwMethodP2Title() + "</h3>"
    	      + constants.cwMethodP2content() + "</li>";
    widgetStr += "<li><h3>3 " + constants.cwMethodP3Title() + "</h3>"
    	      + constants.cwMethodP3content() + "</li>";
    widgetStr += "<li><h3>4 " + constants.cwMethodP4Title() + "</h3>"
    	      + constants.cwMethodP4content() + "</li>";
    widgetStr += "</ol>";
	vPanel.add(new HTML(widgetStr));
	/* 2012.07.19 obsolete
	vPanel.add(new HTML("<a href='TUPracticalPieces.tar.gz'>" + constants.cwMethodLink() + "</a>"));
	*/
	vPanel.add(new HTML("<s><a href='TUPracticalPieces.tar.gz'>" + constants.cwMethodLink() + "</a></s>"));
    return vPanel;
  }
  
  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
    GWT.runAsync(CwMethod.class, new RunAsyncCallback() {

      public void onFailure(Throwable caught) {
        callback.onFailure(caught);
      }

      public void onSuccess() {
        callback.onSuccess(onInitialize());
      }
    });
  }
  
}
