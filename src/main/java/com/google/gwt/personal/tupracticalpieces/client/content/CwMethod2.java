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
public class CwMethod2 extends ContentWidget {
  /**
   * The constants used in this Content Widget.
   */
  @TUPracticalPiecesSource
  public static interface CwConstants extends Constants {
	String cwMethod2Description();
	
	String cwMethod2Link();
    
	/* 201302 add */
	String cwMethod2LinkSource();

	String cwMethod2Name();

    String cwMethod2P1Title();

    String cwMethod2P1content();

    String cwMethod2P2Title();

    String cwMethod2P2content();

    String cwMethod2P3Title();

    String cwMethod2P3content();

    String cwMethod2P4Title();

    String cwMethod2P4content();

    String cwMethod2P5Title();

    String cwMethod2P5content();
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
  public CwMethod2(CwConstants constants) {
    super(constants.cwMethod2Name(), constants.cwMethod2Description(), true);
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
    widgetStr += "<li><h3>1 " + constants.cwMethod2P1Title() + "</h3>"
              + constants.cwMethod2P1content() + "</li>";
    widgetStr += "<li><h3>2 " + constants.cwMethod2P2Title() + "</h3>"
    	      + constants.cwMethod2P2content() + "</li>";
    widgetStr += "<li><h3>3 " + constants.cwMethod2P3Title() + "</h3>"
    	      + constants.cwMethod2P3content() + "</li>";
    widgetStr += "<li><h3>4 " + constants.cwMethod2P4Title() + "</h3>"
    	      + constants.cwMethod2P4content() + "</li>";
    widgetStr += "<li><h3>5 " + constants.cwMethod2P5Title() + "</h3>"
  	          + constants.cwMethod2P5content() + "</li>";
    widgetStr += "</ol>";
	vPanel.add(new HTML(widgetStr));
	/* 201302 
    vPanel.add(new HTML("<a href='TUPracticalPieces201207.tar.gz'>" + constants.cwMethod2Link() + "</a>"));
	*/
	vPanel.add(new HTML("<s><a href='TUPracticalPieces201207.tar.gz'>" + constants.cwMethod2Link() + "</a></s>"));
	vPanel.add(new HTML("<a href='https://code.google.com/p/making-tupracticalpieces/'>" + constants.cwMethod2LinkSource() + "</a>"));

    return vPanel;
  }
  
  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
    GWT.runAsync(CwMethod2.class, new RunAsyncCallback() {

      public void onFailure(Throwable caught) {
        callback.onFailure(caught);
      }

      public void onSuccess() {
        callback.onSuccess(onInitialize());
      }
    });
  }
  
}
