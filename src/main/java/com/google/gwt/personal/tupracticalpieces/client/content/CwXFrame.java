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

//import java.util.Date;

import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.Constants;
//import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
//import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import com.google.gwt.user.client.ui.DialogBox; //202406

import java.util.Arrays;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesData;
//import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesSource;
//import com.google.gwt.personal.tupracticalpieces.client.common.AdminTask;
//import com.google.gwt.personal.tupracticalpieces.client.common.AdminTaskAsync;
//import com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch;
import com.google.gwt.personal.tupracticalpieces.client.common.LoginState; //202406
/**
 * Load and store the mileage data.
 */
public class CwXFrame extends CwFrame {
//   /**
//   * The constants used in this Content Widget.
//   */
  //@TUPracticalPiecesSource
  //public static interface CwConstants extends Constants implements CwFrame.CwConstants {
  //public static interface CwConstants extends Constants {
  public static interface CwConstants extends CwFrame.CwConstants {
    String cwXFrameDescription();
  
    String cwXFrameName();
 
    String cwCommonAdminTitle();
    
    String cwCommonAdminName();
    
    String cwCommonAdminPassword();
    
    String cwCommonAdminOk();
    
    String cwCommonAdminCancel();
 
  
  }
  
  /**
   * OAuth 2 access url.
   */
  //@TUPracticalPiecesData
  private String url = null;
 
  /**
   * DB field supplyDate.
   */
  //@TUPracticalPiecesData
  private TextBox supplyDateTextBox = new TextBox();
  
  /**
   * DB field quantity.
   */
  //@TUPracticalPiecesData
  private TextBox quantityTextBox = new TextBox();
  
  /**
   * DB field unitPrice.
   */
  //@TUPracticalPiecesData
  private TextBox unitPriceTextBox = new TextBox();
  
  /**
   * DB field totalPrice.
   */
  //@TUPracticalPiecesData
  private TextBox totalPriceTextBox = new TextBox();
  
  /**
   * DB field bsMileage.
   */
  //@TUPracticalPiecesData
  private TextBox bsMileageTextBox = new TextBox();
  
  /**
   * DB field totalMileage.
   */
  //@TUPracticalPiecesData
  private TextBox totalMileageTextBox = new TextBox();
  
  /**
   * DB update parameters.
   */
  //@TUPracticalPiecesData
  static String tempStr;

  /**
   * main panel.
   */
  private VerticalPanel vPanel = new VerticalPanel();
  
  /**
   * page content.
   */
  //@TUPracticalPiecesData
  private HTML contentDiv = null;
  
  /**
   * page content of super class.
   */
  @TUPracticalPiecesData
  private Widget superWidget = null;
  
  /**
   * page content.
   */
  @TUPracticalPiecesData
  private VerticalPanel gridPanel = new VerticalPanel();
  
  /**
   * page content.
   */
  @TUPracticalPiecesData
  private HorizontalPanel contPanel = new HorizontalPanel();
  
  /**
   * Issue the api call.
   */
  //@TUPracticalPiecesData
  private Button excludeButton = new Button("Show");
  
    /**
   * admin authentication 202406
   */
  //@TUPracticalPiecesData
  public  final DialogBox dialogBox = new DialogBox();

  /**
   * API IFRAME.
   */
  //@TUPracticalPiecesData
  //private Frame apiFrame = new Frame();
  
  /**
   * Message Timer.
   */
  //@TUPracticalPiecesData
  //private Timer timer;
  
//  /**
//   * An instance of the constants.
//   */
  @TUPracticalPiecesData
  private final CwConstants constants;
  
  /**
   * Constructor.
   */
  public CwXFrame(CwConstants constants) {
    //super().super(constants.cwXFrameName(), constants.cwXFrameDescription(), false);
    super(constants);
    this.constants = constants;

  }
  
  /**
   * Initialize this example.
   */
  //@TUPracticalPiecesSource
  @Override
  public Widget onInitialize() {
	
	/* 20140501 add admin to scope
    */
	super.setAdmin(true);
	superWidget = super.onInitialize();
	contPanel.add(superWidget);

//        		//Window.confirm(url); //xxxTODO when restart to update, open this url.
//    }
//    
    vPanel.setSpacing(10);
    //apiFrame.setHeight("15em");
    //apiFrame.setWidth("24em");
    vPanel.add(new HTML("<a href='https://appengine.google.com/'>dashboard</a>"));
    vPanel.add(new HTML("<a href='https://code.google.com/apis/console/'>Google API console</a>"));
    //vPanel.add(apiFrame);
	contentDiv = new HTML("<p></p>");
    vPanel.add(contentDiv);
    contPanel.add(vPanel);

    excludeButton.setEnabled(false);
    //checkLoginAdmin();
	/* 202406 add User authentication dialog */
	LoginState ls = LoginState.getInstance();
	ls.checkLoginAdmin(dialogBox, constants.cwCommonAdminTitle(),
	    constants.cwCommonAdminName(), constants.cwCommonAdminPassword(), 
	    constants.cwCommonAdminOk(), constants.cwCommonAdminCancel(),
	    Arrays.asList(excludeButton), Arrays.asList(contentDiv),Window.Location.getHref());
	contPanel.add(dialogBox);		    
	return contPanel;
  }
  
  /*
   * login 
   * @see com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileageSuperView#checkLoginAdmin()
   
  public void checkLoginAdmin() {
	Window.alert("From Edit. Enter checkLoginAdmin. path=" + Window.Location.getHref());

	LoginState ls = LoginState.getInstance();
//	ls.loginQury(Arrays.asList(executeButton, deleteButton, insertCloudButton), Arrays.asList(contentDiv),Window.Location.getHref());
	ls.loginQury(Arrays.asList(excludeButton), Arrays.asList(contentDiv),Window.Location.getHref());
  }
   */

  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
	   GWT.runAsync(CwXFrame.class, new RunAsyncCallback() {
         public void onFailure(Throwable caught) {
	       callback.onFailure(caught);
	     }
         public void onSuccess() {
	       callback.onSuccess(onInitialize());
	     }
	   });
  }
  

/*
 * JS function call. Get the session id. @@@ session id ???
 * 	return $wnd.__gwtStatsSessionId; @@@@@@
 */
}
