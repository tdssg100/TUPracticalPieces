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

import com.google.gwt.i18n.client.Constants;
//import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Frame;
//import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import com.google.gwt.user.client.ui.DialogBox;	//202406

import java.util.Arrays;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesData;
import com.google.gwt.personal.tupracticalpieces.client.common.LoginState; //202406
/**
 * Load and store the mileage data.
 */
public class CwMashup2 extends ContentWidget {
   /**
   * The constants used in this Content Widget.
   */
  //@TUPracticalPiecesSource
  public static interface CwConstants extends Constants {
    String cwMashup2Description();
    
    String cwMashup2Name();
    
    String cwCommonAdminTitle();
    
    String cwCommonAdminName();
    
    String cwCommonAdminPassword();
    
    String cwCommonAdminOk();
    
    String cwCommonAdminCancel();
  }
   
  /**
   * iFrame to display server snmp.
   */
  //@TUPracticalPiecesData
  public Frame serverSnmpWidget = new Frame("https://127.0.0.1:3000");
  
  /**
   * iFrame to display server snmp.
   */
  //@TUPracticalPiecesData
  public Frame serverCameraWidget = new Frame("https://127.0.0.1:9443");
  
  /**
   * Issue the api call.
   */
  //@TUPracticalPiecesData
  public Button showButton = new Button("Show");
 
  /**
   * page content.
   */
  //@TUPracticalPiecesData
  public HTML contentDiv = null;

  /**
   * admin authentication 202406
   */
  //@TUPracticalPiecesData
  public  final DialogBox dialogBox = new DialogBox();

  /**
   * An instance of the constants.
   */
  @TUPracticalPiecesData
  private final CwConstants constants;
  
  /**
   * Constructor.
   */
  public CwMashup2(CwConstants constants) {
	 super(constants.cwMashup2Name(), constants.cwMashup2Description(), true);
	 this.constants = constants;
  }  
  
  /**
  * Initialize this example.
  */
 //@TUPracticalPiecesSource
 @Override
 public Widget onInitialize() {
	VerticalPanel contPanel = new VerticalPanel();
	
	
	showButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	    	   serverSnmpWidget.setVisible(true);
	    	   serverCameraWidget.setVisible(true);
	    	   showButton.setEnabled(false);
	      }
		});
   contPanel.add(showButton);
   serverSnmpWidget.setHeight("600px");
   serverSnmpWidget.setWidth("400px");
   serverSnmpWidget.setVisible(false);
   serverCameraWidget.setHeight("600px");
   serverCameraWidget.setWidth("600px");
   serverCameraWidget.setVisible(false);
	HorizontalPanel mainPanel = new HorizontalPanel();
	mainPanel.add(serverCameraWidget);
	mainPanel.add(serverSnmpWidget);
   contPanel.add(mainPanel);

   contentDiv = new HTML("<p></p>");
   contPanel.add(contentDiv);
   contPanel.add(new HTML("<H1>Hello!</H1>"));
   showButton.setEnabled(false);
	/* 202406 add User authentication dialog */
	LoginState ls = LoginState.getInstance();
	ls.checkLoginAdmin(dialogBox, constants.cwCommonAdminTitle(),
	    constants.cwCommonAdminName(), constants.cwCommonAdminPassword(), 
	    constants.cwCommonAdminOk(), constants.cwCommonAdminCancel(),
	    Arrays.asList(showButton), Arrays.asList(contentDiv),Window.Location.getHref());
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
	ls.loginQury(dialogBox,Arrays.asList(showButton), Arrays.asList(contentDiv),Window.Location.getHref());
  }
   */
  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
	   GWT.runAsync(CwMashup2.class, new RunAsyncCallback() {
         public void onFailure(Throwable caught) {
	       callback.onFailure(caught);
	     }
         public void onSuccess() {
	       callback.onSuccess(onInitialize());
	     }
	   });
  }
}


