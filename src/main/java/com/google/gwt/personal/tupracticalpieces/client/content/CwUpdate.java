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
import com.google.gwt.user.cellview.client.CellList;
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
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesData;
//import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesSource;
//import com.google.gwt.personal.tupracticalpieces.client.common.AdminTask;
//import com.google.gwt.personal.tupracticalpieces.client.common.AdminTaskAsync;
//import com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
/**
 * Load and store the mileage data.
 */
public class CwUpdate extends ContentWidget {
   /**
   * The constants used in this Content Widget.
   */
  //@TUPracticalPiecesSource
  public static interface CwConstants extends Constants {
    String cwUpdateDescription();
  
    String cwUpdateForbidden();
    
    String cwUpdateName();
  
  }
  
//  /**
//   * RPC.
//   * 
//   */
//  //@TUPracticalPiecesData
//  public final AdminTaskAsync adminTaskSvc = GWT.create(AdminTask.class);
//  
  /**
   * OAuth 2 access url.
   */
  //@TUPracticalPiecesData
  public String url = null;
 
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
  public VerticalPanel vPanel = new VerticalPanel();
  
  /**
   * page content.
   */
  //@TUPracticalPiecesData
  public HTML contentDiv = null;
  
  /**
   * page content.
   */
  //@TUPracticalPiecesData
  public VerticalPanel gridPanel = new VerticalPanel();
  
  /**
   * page content.
   */
  //@TUPracticalPiecesData
  public HorizontalPanel contPanel = new HorizontalPanel();
  
  /**
   * page content.
   */
  //@TUPracticalPiecesData
  public HorizontalPanel buttonPanel = new HorizontalPanel();
  
  /**
   * Issue the api call.
   */
  //@TUPracticalPiecesData
  public Button executeButton = new Button("Show");
  
  /**
   * Issue the api call.
   */
  //@TUPracticalPiecesData
  public Button deleteButton = new Button("DeleteJDO");
  
  /**
   * Issue the api call.
   */
  //@TUPracticalPiecesData
  public Button insertCloudButton = new Button("InsertIntoGoogleCloudSQL");
//  
//  /**
//   * Mileage Table (Widget).
//   */
//  //@TUPracticalPiecesData
//  public MileageWidget milegeTable = null;
  
  /**
   * Mileage Table (Widget).
   */
  //@TUPracticalPiecesData
  public CellList<MileageProxy> mileageList = null;
//  /**
//   * Mileage Table (Widget).
//   */
//  //@TUPracticalPiecesData
//  public CellList<TaskProxy> milegeList = null;

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
  
  /**
   * An instance of the constants.
   */
  @TUPracticalPiecesData
  private final CwConstants constants;
  
  /**
   * Constructor.
   */
  public CwUpdate(CwConstants constants) {
	/* 201305 remove style and source code tabs. */
    super(constants.cwUpdateName(), constants.cwUpdateDescription(), false);
    this.constants = constants;
  }
  
//  public CwUpdate() {
//	  CwConstants constants = this.constants;
//	  super(constants.cwUpdateName(), constants.cwUpdateDescription(), false);
//  }
//  
//  public CwUpdate(String title, String descript, com.google.gwt.personal.tupracticalpieces.client.content.auth.CwXFrame.CwConstants constants2) {
//	  super(title, descript, false);
//	  //this.constants = this.constants;
//	  this.constants = (CwConstants) constants2;
//	  //new CwFrame(this.constants);
//  }

  
  /**
   * Initialize this example.
   */
  //@TUPracticalPiecesSource
  @Override
  public Widget onInitialize() {
	
    /* removed from Google API Console
    if (("tupracticalpieces.appspot.com").equals(Window.Location.getHost())
    		|| ("www.tupracticalpieces.appspot.com").equals(Window.Location.getHost())) {
      url = "https://accounts.google.com/o/oauth2/auth?" + 
        URL.encode("response_type=code&" +
        "client_id=142776700795.apps.googleusercontent.com&" +
        "redirect_uri=" + Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/oauth2callback&" +
        "scope=https://www.googleapis.com/auth/userinfo.profile " +
	        "https://www.googleapis.com/auth/sqlservice&" + 
	    "state=/profile");
    } else {
      url = "https://accounts.google.com/o/oauth2/auth?" + 
    	URL.encode("response_type=code&" +
    	"client_id=142776700795-mh5vdbe743a9imq4jh224661dhmh397g.apps.googleusercontent.com&" +
    	"redirect_uri=" + "http://localhost:8888/oauth2callback&" +
    	"scope=https://www.googleapis.com/auth/userinfo.profile " +
    	    "https://www.googleapis.com/auth/sqlservice&" + 
    	"state=/profile");
    }
  	  * 
  	  * create OAuth2 ID 20131215/16
  	  */
	/*
    if (("tupracticalpieces.appspot.com").equals(Window.Location.getHost())
    		|| ("www.tupracticalpieces.appspot.com").equals(Window.Location.getHost())) {
      url = "https://accounts.google.com/o/oauth2/auth?" + 
        URL.encode("response_type=code&" +
        "client_id=9571369657-pst4k53gna3tssfp6dfjp1g82elfrjnb.apps.googleusercontent.com&" +
        "redirect_uri=" + Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/oauth2callback&" +
        "scope=https://www.googleapis.com/auth/userinfo.profile " +
	        "https://www.googleapis.com/auth/sqlservice&" + 
	    "state=/profile");
    } else {
      url = "https://accounts.google.com/o/oauth2/auth?" + 
    	URL.encode("response_type=code&" +
    	"client_id=9571369657.apps.googleusercontent.com&" +
    	"redirect_uri=" + "http://localhost:8888/oauth2callback&" +
    	"scope=https://www.googleapis.com/auth/userinfo.profile " +
    	    "https://www.googleapis.com/auth/sqlservice&" + 
    	"state=/profile");
      Window.alert(url); //XXTODO when restart to update, open this url.
   
    }
    */
	/* 20140501 add admin to scope
    */
//    if (("127.0.0.1:8888").equals(Window.Location.getHost())
//    		|| ("localhost:8888").equals(Window.Location.getHost())) {
//        url = "https://accounts.google.com/o/oauth2/auth?" + 
//            	URL.encode("response_type=code&" +
//            	"client_id=9571369657.apps.googleusercontent.com&" +
//            	"redirect_uri=" + "http://localhost:8888/oauth2callback&" +
//            	"scope=https://www.googleapis.com/auth/userinfo.profile " +  
//            		"https://www.googleapis.com/auth/userinfo.email&" +
//            	"state=/profile");
//              Window.alert(url); //xxxTODO when restart to update, open this url.
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
//    vPanel.setSpacing(10);
//    //apiFrame.setHeight("15em");
//    //apiFrame.setWidth("24em");
//    vPanel.add(new HTML("<a href='https://appengine.google.com/'>dashboard</a>"));
//    //vPanel.add(new HTML("<a href='https://code.google.com/apis/console/'>Google API console</a>"));
//    vPanel.add(new HTML("<a href='https://console.developers.google.com/'>Google API console</a>"));
//    HorizontalPanel buttonPanel = new HorizontalPanel();
//    buttonPanel.add(executeButton);
//    buttonPanel.add(deleteButton);
//    buttonPanel.add(insertCloudButton);
//	disenableButton();
//    vPanel.add(buttonPanel);
//    //vPanel.add(apiFrame);
//	contentDiv = new HTML("<p></p>");
//    vPanel.add(contentDiv);
//    contPanel.add(vPanel);
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
	  
	  
	  
//	  
//	  contPanel.addAttachHandler(new AttachEvent.Handler() {
//
//		  @Override
//		  public void onAttachOrDetach(AttachEvent event) {
//		    // do something
//		  }
//		});  
	  
	  
	  
	  
	return contPanel;
  }
//  
//public void bodyWidget(String regiuser, String state, java.util.Date expire, String session) {
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
//	    /* need to reset time out */
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
////    	adminTaskSvc.saveJobName("ConsentLogin:" + session + "," + "LoginTRY" + ",0,CwUpdate", callback);
//    	adminTaskSvc.saveJobName("ConsentLogin:" + session + "," + "LoginTRY" + ",0,AdminMileageView", callback);
//        //}
//    }
//    /* otherwise continue */
//    /*      (session == regiuser) && state == 'LoginOK' && expire > curTime
//     * not( (session != regiuser) || state != 'LoginOK' || expire <= curTime)
//     */
//    // Create the dialog box
//  	enableButton();
//    final DialogBox dialogBox = new DialogBox();
//    dialogBox.setText("Insert record into Google-Cloud-SQL as follows:");
//    dialogBox.setAnimationEnabled(true);
//    VerticalPanel dialogVPanel = new VerticalPanel();
//    dialogBox.add(dialogVPanel);
//    dialogVPanel.setWidth("100%");
//    dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
//    dialogVPanel.add(supplyDateTextBox);
//    dialogVPanel.add(quantityTextBox);
//    dialogVPanel.add(unitPriceTextBox);
//    dialogVPanel.add(totalPriceTextBox);
//    dialogVPanel.add(bsMileageTextBox);
//    dialogVPanel.add(totalMileageTextBox);
//       
//    Button insertButton = new Button("insert");
//    dialogVPanel.add(insertButton);
//    insertButton.addClickHandler(new ClickHandler() {
////      @Override
//      public void onClick(ClickEvent event) {
//      	String supplyDate = null;
//      	// ('2002-10-12',34.23,107,3666,241.0,241.0)
//      	try {
//          	for (int i = 0; i < supplyDateTextBox.getText().length(); i++) {
//          		byte c = supplyDateTextBox.getText().getBytes()[i];
//          		if (i == 4 || i == 7) {
//          			if (c != '-') {
//          				throw new Exception();
//          			}
//          		} else {
//          			if  (c < '0' || c > '9') {
//          				throw new Exception();
//          			}
//          		}
//          	}
//          	supplyDate = supplyDateTextBox.getText();
//          	Float.parseFloat(quantityTextBox.getText());
//          	Float.parseFloat(quantityTextBox.getText());
//      		Integer.parseInt(unitPriceTextBox.getText());
//      		Integer.parseInt(totalPriceTextBox.getText());
//      		Float.parseFloat(bsMileageTextBox.getText());
//      		Float.parseFloat(totalMileageTextBox.getText());
//      		tempStr = "'" + supplyDate + "'," + quantityTextBox.getText() + ","
//      				+ unitPriceTextBox.getText()  + ","  + totalPriceTextBox.getText()  + ","
//      				+ bsMileageTextBox.getText()  + ","+ totalMileageTextBox.getText();
//      		/* due to deffer binding, static String String.format cannot be used.(?)
//          	tempStr = String.format("'%s',%.2f,%d,%d,%.1f,%.1f",
//          			supplyDate, quantity, unitPrice, totalPrice, bsMileage, totalMileage);
//          	*/		 
//      	} catch (Exception e) {
//              Window.alert("for example:('2002-10-12',34.23,107,3666,241.0,241.0)");
//              return;
//      	}
//      	// Window.alert("InsertSQL:" + tempStr);
//	    contentDiv.setHTML("<p>delete JDO button clicked</p>");
//  		AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
//  		      public void onFailure(Throwable caught) {
//  		    	String wedgeStr = "<ol style='list-style-type: disc'>";
//  		    	wedgeStr += "<li>" + "RPC failure." + "</li>";
//  		    	wedgeStr += "</ol>";
//  		    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//		    	enableButton();
//  		      }
//  		      public void onSuccess(ResultFetch result) {
//  		    	enableButton();
//  		    	if (result.getResult()) {
//  			        contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//  		  		    //apiFrame.setUrl("adminmethod?dp=" + URL.encode(url));
//	            	//Window.Location.assign(url);
//  		    	} else {
//    			    contentDiv.setHTML(contentDiv.getHTML() + result.getText());    		    	
//  		    	}
//  		      }
//  		    };
//  		adminTaskSvc.saveJobName("InsertSQL:" + tempStr, callback);
//        //dialogBox.hide();
//      }
//    });  
//    Button closeButton = new Button("close");
//    dialogVPanel.add(closeButton);
//    closeButton.addClickHandler(new ClickHandler() {
////      @Override
//      public void onClick(ClickEvent event) {
//        dialogBox.hide();
//    	enableButton();
//      }
//    });
//    /* Show button */
//    executeButton.addClickHandler(new ClickHandler() {
//    	public void onClick(ClickEvent event) {
//    	    gridPanel.setVisible(true);
//		    contentDiv.setHTML("<p>execute button clicked</p>");
//		    //milegeTable = new MileageWidget(15);
//		    milegeTable.refresh();
//		    /*
//		    disenableButton();
//    		AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
//  		      public void onFailure(Throwable caught) {
//  		    	String wedgeStr = "<ol style='list-style-type: disc'>";
//  		    	wedgeStr += "<li>" + "RPC failure." + "</li>";
//  		    	wedgeStr += "</ol>";
//  		    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//		    	enableButton();
//  		      }
//  		      public void onSuccess(ResultFetch result) {
//                if (result.getResult()) {   
//  		    	  contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//  			      //apiFrame.setUrl("adminmethod?dp=" + URL.encode(url));
//  		    	  Window.Location.assign(url);
//                } else {
//    		      contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//                }
//		    	enableButton();
//              }
//  		    };
//  		   adminTaskSvc.saveJobName("LoadFromCloud", callback);
//  		   */
//    }});
//    
//    /* no operation */
//    deleteButton.addClickHandler(new ClickHandler() {
//    	public void onClick(ClickEvent event) {
//		    contentDiv.setHTML("<p>delete JDO button clicked. No more operation.</p>");
///*		    disenableButton();
//    		AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
//    		      public void onFailure(Throwable caught) {
//    		    	String wedgeStr = "<ol style='list-style-type: disc'>";
//    		    	wedgeStr += "<li>" + "RPC failure." + "</li>";
//    		    	wedgeStr += "</ol>";
//    		    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//    		    	enableButton();
//    		      }
//    		      public void onSuccess(ResultFetch result) {
//    		    	if (result.getResult()) {
//    			        contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//    		  		    //apiFrame.setUrl("adminmethod?dp=" + URL.encode(url));
//    		  		    //Window.Location.assign(url);
//    		    	} else {
//      			      contentDiv.setHTML(contentDiv.getHTML() + result.getText());    		    	
//    		    	}
//    		    	enableButton();
//    		      }
//    		    };
//    		adminTaskSvc.saveJobName("DeleteJdo", callback);
//*/    }});
//    
//    insertCloudButton.addClickHandler(new ClickHandler() {
//    	public void onClick(ClickEvent event) {
//	    	disenableButton();
//    		dialogBox.show();
//    }});
//    /* 201305 Widget Grid
//	20141212 move to Show executeButton
//     */
//    MileageWidget milegeTable = new MileageWidget(15);
//    gridPanel.add(milegeTable);
//    gridPanel.setVisible(false);
//    contPanel.add(gridPanel);
//    /*
//    contentDiv.setHTML("please wait....");
//    checkConsent();
//    timer = new Timer() {
//		  @Override
//		  public void run() {
//			    contentDiv.setHTML("CANNOT CONNECT SERVER.");
//		 }
//	  };
//	timer.schedule(20000);
//	*/
//    //return contPanel;
//  }
  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
	   GWT.runAsync(CwUpdate.class, new RunAsyncCallback() {
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
   * enable the button
   *
   */
//  public void enableButton() {
//	  executeButton.setEnabled(true);
//	  deleteButton.setEnabled(true);
//	  insertCloudButton.setEnabled(true);
//  }
//  
//  /*
//   * disenable the button
//   *
//   */
//  public void disenableButton() {
//		deleteButton.setEnabled(false);
//		executeButton.setEnabled(false);
//		insertCloudButton.setEnabled(false);	  
//  }
/*
 * JS function call. Get the session id. @@@ session id ???
 * 	return $wnd.__gwtStatsSessionId; @@@@@@
 */
}
