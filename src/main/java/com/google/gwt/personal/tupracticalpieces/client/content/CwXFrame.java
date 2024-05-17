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

import java.util.Arrays;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesData;
//import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesSource;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminTask;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminTaskAsync;
import com.google.gwt.personal.tupracticalpieces.client.common.LoginState;
import com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch;
/**
 * Load and store the mileage data.
 */
public class CwXFrame extends CwFrame {
//   /**
//   * The constants used in this Content Widget.
//   */
//  //@TUPracticalPiecesSource
//  public static interface CwConstants extends Constants {
//    String cwXFrameDescription();
//  
//    String cwXFrameName();
//  
//  }
  
  /**
   * RPC.
   */
  //@TUPracticalPiecesData
  private final AdminTaskAsync adminTaskSvc = GWT.create(AdminTask.class);
  
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
   * Mileage Table (Widget).
   */
  //@TUPracticalPiecesData
  private MileageWidget milegeTable = null;

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
//  //@TUPracticalPiecesData
//  private final CwConstants constants;
  
  /**
   * Constructor.
   */
  public CwXFrame(CwConstants constants) {
//    super(constants.cwXFrameName(), constants.cwXFrameDescription(), constants);
    super(constants);
    //this.constants = this.constants;
    //this.constants = constants;
//    this.constants = constants;
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
//    if (("127.0.0.1:8888").equals(Window.Location.getHost())
//    		|| ("localhost:8888").equals(Window.Location.getHost())) {
//        url = "https://accounts.google.com/o/oauth2/auth?" + 
//            	URL.encode("response_type=code&" +
//            	"client_id=9571369657.apps.googleusercontent.com&" +
//            	"redirect_uri=" + "http://localhost:8888/oauth2callback&" +
//            	"scope=https://www.googleapis.com/auth/userinfo.profile " +  
//            		"https://www.googleapis.com/auth/userinfo.email&" +
//            	"state=/profile");
//             // Window.alert(url); //TODO when restart to update, open this url.
//    } else {
//        url = "https://accounts.google.com/o/oauth2/auth?" + 
//                URL.encode("response_type=code&" +
//                "client_id=9571369657-7va8o0mlabijtltni1bmjui8ofqmurm8.apps.googleusercontent.com&" +
//                "redirect_uri=" + Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/oauth2callback&" +
//            	"scope=https://www.googleapis.com/auth/userinfo.profile " +  
//        			"https://www.googleapis.com/auth/userinfo.email&" +
//        	    "state=/profile");
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
//    /* retrieve the last session properties */
//    AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
//	      public void onFailure(Throwable caught) {
//	    	String wedgeStr = "<ol style='list-style-type: disc'>";
//	    	wedgeStr += "<li>" + "RPC failure." + "</li>";
//	    	wedgeStr += "</ol>";
//	    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//	      }
//	      public void onSuccess(ResultFetch result) {
//	          if (result.getResult()) {
//	        	  contentDiv.setHTML(result.getText());
//		    	  String[] tmp = result.getText().split(",");
//			      java.util.Date tmpDate = new java.util.Date(Long.parseLong(tmp[2]));
//			      contentDiv.setHTML(" go into bodyWidget" + ":" + tmp[0] + "," + tmp[1] + "," + tmpDate + "," + tmp[3] + ".");
//			      bodyWidget(tmp[0], tmp[1], tmpDate, tmp[3]);
//	          } else {
//			      contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//	          }
//	      }
//	};
//	adminTaskSvc.saveJobName("ConsentCheck", callback);
    excludeButton.setEnabled(false);
    checkLoginAdmin();
	return contPanel;
  }
  
  /*
   * login 
   * @see com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileageSuperView#checkLoginAdmin()
   */
  public void checkLoginAdmin() {
	Window.alert("From Edit. Enter checkLoginAdmin. path=" + Window.Location.getHref());

	LoginState ls = LoginState.getInstance();
//	ls.loginQury(Arrays.asList(executeButton, deleteButton, insertCloudButton), Arrays.asList(contentDiv),Window.Location.getHref());
	ls.loginQury(Arrays.asList(excludeButton), Arrays.asList(contentDiv),Window.Location.getHref());
  }
  
//private void bodyWidget(String regiuser, String state, java.util.Date expire, String session) {
//    //Window.alert("bodyWidget entered.");
//	//long session = 0; @@@@@getSessionIdInJava();
//	/* the other user is making login process */
//	if (!session.equals(regiuser) && state.equals("LoginTRY")) {
//		contentDiv.setHTML(contentDiv.getHTML() + "Please retry after a while.");
//		return;
//    }
//	java.util.Date curTime = new java.util.Date();
//	/* login failuer 2
//	 * 1/2: in service to other user */
//	if (!session.equals(regiuser) && state.equals("LoginOK") && expire.compareTo(curTime) > 0) {
//		contentDiv.setHTML(contentDiv.getHTML() + "You are not authorized.");
//		return;
//    }
//	/* 2/2: not authorative of google accout*/
//	if (session.equals(regiuser) && !state.equals("LoginOK") ) {
//		contentDiv.setHTML(contentDiv.getHTML() + "You are not authorized in google account.");
//		return;
//    }
//	/* TimeOut occurs */
//	if (session.equals(regiuser) && state.equals("LoginOK") &&  curTime.compareTo(expire) > 0) {
//		contentDiv.setHTML("Time out occurs.");
//	    /*  need to reset time out */
//	    AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
//		      public void onFailure(Throwable caught) {
//		    	String wedgeStr = "<ol style='list-style-type: disc'>";
//		    	wedgeStr += "<li>" + "RPC failure." + "</li>";
//		    	wedgeStr += "</ol>";
//		    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//		      }
//		      public void onSuccess(ResultFetch result) {
//		          if (result.getResult()) {
//		        	  contentDiv.setHTML(result.getText());
//		          } else {
//				      contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//		          }
//		      }
//		};
//		adminTaskSvc.saveJobName("ConsentTimeOut", callback);
//		return;
//    }
//    /* can try to login 
//     *  not 
//     *  no need to consult google account.
//     *  session == regiuser && state = "LoginOK" && expire > curTime || 
//     */
//    /* login process */
//    //Window.alert("before login condition check.");
//    if ((curTime.compareTo(expire) > 0) || (!session.equals(regiuser)) || !state.equals("LoginOK")) {
//        //if (Window.confirm("after login condition check.")) {
//        /* log on process */
//        AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
//    	      public void onFailure(Throwable caught) {
//    	    	String wedgeStr = "<ol style='list-style-type: disc'>";
//    	    	wedgeStr += "<li>" + "RPC failure." + "</li>";
//    	    	wedgeStr += "</ol>";
//    	    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//    	      }
//    	      public void onSuccess(ResultFetch result) {
//	              if (result.getResult()) {
//	            	  Window.Location.assign(url);
//	              } else {
//	    		    contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//	              }
//	          }
//    	};
//    	adminTaskSvc.saveJobName("ConsentLogin:" + session + "," + "LoginTRY" + ",0,CwXFrame", callback);
//        //}
//    }
//       
//    //gridPanel.setVisible(false);
//    //contPanel.add(gridPanel);
//  }
  
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
   * check if the user has finished the consent.
   */
  /*
  private void checkConsent() {
	AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
	  public void onFailure(Throwable caught) {
		timer.cancel();
		String wedgeStr = "<ol style='list-style-type: disc'>";
		wedgeStr += "<li>" + "RPC failure. exception:" + caught.toString() + "</li>";
		wedgeStr += "</ol>";
		contentDiv.setHTML(wedgeStr);
      }
	  public void onSuccess(ResultFetch result) {
		timer.cancel();
		if (result.getResult()) {
		  contentDiv.setHTML(result.getText());
		  apiFrame.setUrl("adminmethod?dp=" + URL.encode(url));
		  //Window.open(url,"Goolge Appengine Concent", "");
		  enableButton();
		} else {
  		  contentDiv.setHTML(result.getText());    		    	
		}
	  }
	};
	adminTaskSvc.saveJobName("CheckConsent", callback);	  
  }
  */
/*
 * JS function call. Get the session id. @@@ session id ???
 * 	return $wnd.__gwtStatsSessionId; @@@@@@
 */
}
