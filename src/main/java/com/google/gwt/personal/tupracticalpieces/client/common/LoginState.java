package com.google.gwt.personal.tupracticalpieces.client.common;
import java.nio.charset.Charset;
import java.security.Security;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.lang.StringBuilder;
import java.lang.String;
import java.lang.Integer;
import java.lang.Byte;
import java.util.List;
import java.util.Arrays;
import java.lang.StringBuilder;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.lang.Thread;
//import org.apache.tools.ant.taskdefs.Javadoc.Html;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.google.gwt.user.client.Timer;	//202406

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminTask;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminTaskAsync;
import com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextArea;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;

public class LoginState  {

	private static LoginState singleton = new LoginState();

	private List<Button> btnList;

	public static List<HTML> logList;
	
	private String callbackUrl;

	private static boolean isFinish = false;	//202406
	
	private static boolean isConfirmation = false;	//202406
	/**
	 * RPC.
	 * 
	 */
	//@TUPracticalPiecesData
	public final AdminTaskAsync adminTaskSvc = GWT.create(AdminTask.class);
	public final AdminTaskAsync loginSvc = GWT.create(AdminTask.class);	//202406

	//	
	//	public void setButtonList(List<Button> btnList) {
	//		this.btnList = btnList;
	//	}
	//	
	//	
	//	public void setCallbackUrl (String url) {
	//		this.callbackUrl = url;
	//	}



	public static LoginState getInstance() {
		return singleton;
	}

	/* login sesquence. 202406 */
	public void checkLoginAdmin(DialogBox dialogBox, String pcwCommonAdminTitle, String pcwCommonAdminName,
   	  String pcwCommonAdminPassword, String pcwCommonAdminOk, String pcwCommonAdminCancel,
   	  List<Button> btnList, List<HTML> logList, String callbackUrl) {
   	  	
   	  	/*
   	  	this.btnList = btnList;
		this.logList = logList;
		this.callbackUrl = callbackUrl;
		*/
		
		/* retrieve the last session properties */
		isConfirmation = false;
		AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
			public void onFailure(Throwable caught) {
				isFinish = true;
				String wedgeStr = "<ol style='list-style-type: disc'>";
				wedgeStr += "<li>" + "RPC failure." + "</li>";
				wedgeStr += "</ol>";
				//		    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
				//com.google.gwt.personal.tupracticalpieces.client.common.LoginState.logList.get(0).setHTML(wedgeStr);
				Window.alert("login getJobName error: " + wedgeStr);
			}
			public void onSuccess(ResultFetch result) {
				isFinish = true;
				if (result.getResult()) {
					String[] tmp = result.getText().split(",");
					String loginState = tmp[1];
					java.util.Date loginExpire = new java.util.Date(Long.parseLong(tmp[2]));
			   	  	java.util.Date curTime = new java.util.Date();
			   	  	if (!(loginState.equals("LoginOK")) || (curTime.compareTo(loginExpire) > 0)) {
						isConfirmation = true;
						//Window.alert("Finish with need");
						setAminAuthDialog(dialogBox, pcwCommonAdminTitle, pcwCommonAdminName, 
						 		pcwCommonAdminPassword, pcwCommonAdminOk, pcwCommonAdminCancel,
								btnList, logList, callbackUrl);
						dialogBox.center();
						dialogBox.show();
						
						
					} else {
						loginQury(btnList, logList, callbackUrl);
					}
					//Window.alert("Not confirmation condition");
				} else {
					com.google.gwt.personal.tupracticalpieces.client.common.LoginState.logList.get(0).setHTML(
							 result.getText() + "<br/>"+ com.google.gwt.personal.tupracticalpieces.client.common.LoginState.logList.get(0).getText());
					//				      contentDiv.setHTML(contentDiv.getHTML() + result.getText());
					Window.alert("login getJobName error: " + result.getText());
				}
			}
		};
		loginSvc.getJobName("", callback);
		return;
	}
   	  	

	public void loginQury(List<Button> btnList, List<HTML> logList, String callbackUrl) {

		this.btnList = btnList;
		this.logList = logList;
		this.callbackUrl = callbackUrl;

		/* retrieve the last session properties */
		AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
			public void onFailure(Throwable caught) {
				String wedgeStr = "<ol style='list-style-type: disc'>";
				wedgeStr += "<li>" + "RPC failure." + "</li>";
				wedgeStr += "</ol>";
				//		    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
				com.google.gwt.personal.tupracticalpieces.client.common.LoginState.logList.get(0).setHTML(wedgeStr);
//				Window.alert("ConsentCheck: " + wedgeStr);
			}
			public void onSuccess(ResultFetch result) {
				if (result.getResult()) {
					com.google.gwt.personal.tupracticalpieces.client.common.LoginState.logList.get(0).setHTML(
							  result.getText() + "<br/>" + com.google.gwt.personal.tupracticalpieces.client.common.LoginState.logList.get(0).getText());
					//		        	  contentDiv.setHTML(result.getText());
					String[] tmp = result.getText().split(",");
					java.util.Date tmpDate = new java.util.Date(Long.parseLong(tmp[2]));
					com.google.gwt.personal.tupracticalpieces.client.common.LoginState.logList.get(0).setHTML(
							  " go into bodyWidget" + ":" + tmp[0] + "," + tmp[1] + "," + tmpDate + "," + tmp[3] + "." + "<br/>" + com.google.gwt.personal.tupracticalpieces.client.common.LoginState.logList.get(0).getText());
					//				      contentDiv.setHTML(" go into bodyWidget" + ":" + tmp[0] + "," + tmp[1] + "," + tmpDate + "," + tmp[3] + ".");
					bodyWidget(tmp[0], tmp[1], tmpDate, tmp[3]);
				} else {
					com.google.gwt.personal.tupracticalpieces.client.common.LoginState.logList.get(0).setHTML(
							 result.getText() + "<br/>"+ com.google.gwt.personal.tupracticalpieces.client.common.LoginState.logList.get(0).getText());
					//				      contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//					Window.alert("ConsentCheck: " + result.getText());
				}
			}
		};
		adminTaskSvc.saveJobName("ConsentCheck", callback);
	}


	public void bodyWidget(String regiuser, String state, java.util.Date expire, String session) {
//		Window.alert("bodyWidget entered.AdminMileage path=" + Window.Location.getHref());
		//long session = 0; @@@@@getSessionIdInJava();
		/* the other user is making login process */
		if (!session.equals(regiuser) && state.equals("LoginTRY")) {
			//		contentDiv.setHTML(contentDiv.getHTML() + "Please retry after a while.");
			logList.get(0).setHTML("Please retry after a while." + "<br/>" + logList.get(0).getText());
//			Window.alert("Please retry after a while.");
			return;
		}
		java.util.Date curTime = new java.util.Date();
		/* login failuer 2
		 * 1/2: in service to other user */
		if (!(regiuser == null || regiuser.isEmpty()) && !session.equals(regiuser) && state.equals("LoginOK") && expire.compareTo(curTime) > 0) {
			//		contentDiv.setHTML(contentDiv.getHTML() + "You are not authorized.");
			logList.get(0).setHTML("You opened another session. Session changed." + "<br/>" + logList.get(0).getText());
//			Window.alert("You are not authorized.");
//			return;
		}
		/* 2/2: not authorative of google accout. Once fail, never login*/
//		if (session.equals(regiuser) && !state.equals("LoginOK") ) {
		if (session.equals(regiuser) && state.equals("LoginNG") ) {
			//		contentDiv.setHTML(contentDiv.getHTML() + "You are not authorized in google account.");
			logList.get(0).setHTML("You are not authorized in google account." + "<br/>" + logList.get(0).getText());
//			Window.alert("You are not authorized in google account.");
			return;
		}
		/* TimeOut occurs */
		if (session.equals(regiuser) && state.equals("LoginOK") &&  curTime.compareTo(expire) > 0) {
			//		contentDiv.setHTML("Time out occurs.");
			logList.get(0).setHTML("Time out occurs." + "<br/>" + logList.get(0).getText());
//			Window.alert("Time out occurs.");
			/* need to reset time out */
			AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
				public void onFailure(Throwable caught) {
					String wedgeStr = "<ol style='list-style-type: disc'>";
					wedgeStr += "<li>" + "RPC failure." + "</li>";
					wedgeStr += "</ol>";
					logList.get(0).setHTML(wedgeStr + "<br/>" + logList.get(0).getText());
					//		    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//					Window.alert(wedgeStr);
				}
				public void onSuccess(ResultFetch result) {
					if (result.getResult()) {
						logList.get(0).setHTML(result.getText() + "<br/>" + logList.get(0).getText());
						//		        	  contentDiv.setHTML(result.getText());
//						Window.alert("ConsentTimeOut" + result.getText());
					} else {
						logList.get(0).setHTML(result.getText() + "<br/>" + logList.get(0).getText());
						//				      contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//						Window.alert("ConsentTimeOut" + result.getText());
					}
				}
			};
			adminTaskSvc.saveJobName("ConsentTimeOut", callback);
			return;
		}
		/* can try to login 
		 *  not 
		 *  no need to consult google account.
		 *  session == regiuser && state = "LoginOK" && expire > curTime || 
		 */
		/* login process */
//		Window.alert("From before login condition check.");
//		if ((curTime.compareTo(expire) > 0) || (!session.equals(regiuser)) || !state.equals("LoginOK")) {
		if ((curTime.compareTo(expire) > 0) ||  !state.equals("LoginOK")) {
			//if (Window.confirm("after login condition check.")) {
			/* log on process */
			AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
				public void onFailure(Throwable caught) {
					String wedgeStr = "<ol style='list-style-type: disc'>";
					wedgeStr += "<li>" + "RPC failure." + "</li>";
					wedgeStr += "</ol>";
					logList.get(0).setHTML(wedgeStr + "<br/>" + logList.get(0).getText());
					//    	    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//					Window.alert(wedgeStr);
//											"client_id=9571369657.apps.googleusercontent.com&" +
				}
				public void onSuccess(ResultFetch result) {
					if (result.getResult()) {
						// login as admin
						String url; 
						//localhost jetty ssl
						if (("127.0.0.1:8443").equals(Window.Location.getHost())
								|| ("localhost:8443").equals(Window.Location.getHost())) {
							/*
							url = "https://accounts.google.com/o/oauth2/auth?" + 
									URL.encode("response_type=code&" +
											"client_id=9571369657.apps.googleusercontent.com&" +
											"redirect_uri=" + Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/oauth2callback&" +
											"scope=https://www.googleapis.com/auth/userinfo.profile " +  
											"https://www.googleapis.com/auth/userinfo.email&" +
											"state=/profile");
							*/				
							url = "https://accounts.google.com/o/oauth2/auth?" + 
									URL.encode("response_type=code&" +
											"client_id=882057016296-tl5oic5jm1anrd625dlt1t10ud1rhpn0.apps.googleusercontent.com&" + 
											"redirect_uri=https://localhost:8443/oauth2callback&" +
											"scope=https://www.googleapis.com/auth/userinfo.profile " +  
											"https://www.googleapis.com/auth/userinfo.email&" +
											"state=/profile");
							//"client_id=665228524445-n826p8nec0b91tk5mlg6iuu7ss9g3kl6.apps.googleusercontent.com&" +
											
											
//							Window.alert(url); //TODO when restart to update, open this url.
					    // localhost devserver
//						} else  if (("tupracticalpieces.appspot.com:8888").equals(Window.Location.getHost())) {
						} else if (("tupracticalpieces.appspot.com").equals(Window.Location.getHost())) {
							url = "https://accounts.google.com/o/oauth2/auth?" + 
									URL.encode("response_type=code&" +
											"client_id=9571369657-0omq28sbvq94as3bl127ia3de85lf2l9.apps.googleusercontent.com&" +
											"redirect_uri=" + Window.Location.getProtocol() + "/" + Window.Location.getHost() + "//oauth2callback&" +
											"scope=https://www.googleapis.com/auth/userinfo.profile " +  
											"https://www.googleapis.com/auth/userinfo.email&" +
											"state=/profile");


							//Window.alert(url); //TODO when restart to update, open this url.


						} else {
							url = "https://accounts.google.com/o/oauth2/auth?" + 
									URL.encode("response_type=code&" +
											"client_id=882057016296-tl5oic5jm1anrd625dlt1t10ud1rhpn0.apps.googleusercontent.com&" + 
											"redirect_uri=" + Window.Location.getProtocol() + "/" + Window.Location.getHost() + "/oauth2callback&" +
											"scope=https://www.googleapis.com/auth/userinfo.profile " +  
											"https://www.googleapis.com/auth/userinfo.email&" +
											"state=/profile");
							//"client_id=9571369657-3mqoa0q64gfer18q52gmhmul9gg5anus.apps.googleusercontent.com&" +
							//Window.confirm(url); //xxxTODO when restart to update, open this url.
						}





						Window.Location.assign(url);
						return;
						// force to call change handler
						//getApp().getHistoristoryMapper().handleCurrentHistory();
//						History.fireCurrentHistoryState();
					} else {
						logList.get(0).setHTML(result.getText() + "<br/>" + logList.get(0).getText());
						//	    		    contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//						Window.alert("ConsentLogin : " + result.getText());
					}
				}
			};
			//    	adminTaskSvc.saveJobName("ConsentLogin:" + session + "," + "LoginTRY" + ",0,CwUpdate", callback);
			adminTaskSvc.saveJobName("ConsentLogin:" + session + "," + "LoginTRY" + ",0," + callbackUrl, callback);
			logList.get(0).setHTML("Oauth2 check. Qury server." + "<br/>" + logList.get(0).getText());
			//}
			return;
		} else {
			/* otherwise continue */
			/*      (session == regiuser) && state == 'LoginOK' && expire > curTime
			 * not( (session != regiuser) || state != 'LoginOK' || expire <= curTime)
			 */
			// Create the dialog box
			//    loginOk = true;
			//		  buttonPanel.setVisible(true);
			//		  enableButton();
//			Window.alert("Login OK. Button enabled.");
			logList.get(0).setHTML("Login OK. Button enabled." + "<br/>" + logList.get(0).getText());
			for (Button btn : btnList) {
				btn.setEnabled(true);
			}
		}


	}



  /**
   * Create the dialog box for this example.
   *
   * @return the new dialog box
   */
  public void setAminAuthDialog(DialogBox dialogBox, String pcwCommonAdminTitle, String pcwCommonAdminName,
   String pcwCommonAdminPassword, String pcwCommonAdminOk, String pcwCommonAdminCancel,
   List<Button> btnList, List<HTML> logList, String callbackUrl) {
    // Create a dialog box and set the caption text
    dialogBox.setText(pcwCommonAdminTitle);

    // Create a table to layout the content
    VerticalPanel dialogContents = new VerticalPanel();
    dialogContents.setSpacing(4);
    dialogBox.setWidget(dialogContents);

    // Add TextBox (name)
    VerticalPanel namePanel = new VerticalPanel();
    namePanel.add(new HTML(pcwCommonAdminName));
    
    TextBox tbn = new TextBox();

    // Let's make an 80x50 text area to go along with the other two.

    namePanel.add(tbn);
    
    dialogContents.add(namePanel);



    // Add PasswordTextBox 
    VerticalPanel passwordPanel = new VerticalPanel();
    passwordPanel.add(new HTML(pcwCommonAdminPassword));
    
    PasswordTextBox ptb = new PasswordTextBox();
    
    passwordPanel.add(ptb);
    
    dialogContents.add(passwordPanel);
    
    // Add a Ok cancel button at the bottom of the dialog
    HorizontalPanel buttonPanel = new HorizontalPanel();
    Button okButton = new Button(
        pcwCommonAdminOk, new ClickHandler() {
          public void onClick(ClickEvent event) {
		String token = ptb.getText();
		byte[] tokenByte = token.getBytes(StandardCharsets.UTF_8);
                String hashedStr = "";
		byte[] hashedBytes = null;
		
		//Window.alert(token);	
		try {
		 

//		Security.addProvider(new BouncyCastleProvider());
		
		
		    MessageDigest md = MessageDigest.getInstance("SHA-256");
/*
		    for (byte b : ptb.getText().getBytes("UTF-8")) {
			try {
	     	            	md.update(b);
			} catch (Exception e) {  //NoSuchAlgorithmException
			        Window.alert("UPDATE fail. " + e.toString());
			}
     	            }
*/                     
		    //MessageDigest tc1 = md.clone();
		    //byte[] hashedBytes = tc1.digest(ptb.getValue().getBytes());
		    //hashedBytes = md.digest(token.getBytes("UTF-8"));
		    hashedBytes = md.digest(tokenByte);
/*
		    try {
		    	hashedBytes = md.digest();
		    } catch (Exception e) {
		    	Window.alert("DIGEST" + e.toString());
		    }
*/
		    //hashedStr = new String(hashedBytes);
		    //hashedStr = Arrays.toString(hashedBytes);
		    StringBuilder sb = new StringBuilder();
		    for (byte b : hashedBytes) {
			sb.append(Byte.toString(b));
		    }
		    hashedStr = "{" + sb.toString() + "}";
		   
//Window.alert("Encrypt :" + hashedStr);	//
		} catch (Exception e) {  //NoSuchAlgorithmException
			Window.alert("Encrypt fail. " + e.toString());
		}

/*		    
MessageDigest md;
try {
  md = MessageDigest.getInstance("SHA-256");
} catch (NoSuchAlgorithmException e) {
  throw new RuntimeException(e);
}
md.update(message.getBytes(Charset.forName("UTF-8")));
StringBuilder sb = new StringBuilder();
for (byte b : md.digest()) {
  sb.append(String.format("%02x", b & 0xff)); // String#format に修正
}
System.out.println(sb);		    
*/		    
		    
		    
		    
          
    		//Window.alert("password=" + hashedStr);
    		checkMatch(tbn.getValue(), hashedStr, btnList, logList, callbackUrl);
                dialogBox.hide();
          }
        });
    buttonPanel.add(okButton);

    Button cancelButton = new Button(
        pcwCommonAdminCancel, new ClickHandler() {
          public void onClick(ClickEvent event) {
            dialogBox.hide();
          }
        });
    buttonPanel.add(cancelButton);


    dialogContents.add(buttonPanel);

    // Return the dialog box
    return;
  }

private void checkMatch(String name, String digest, List<Button> btnList, List<HTML> logList, String callbackUrl) {
//https://localhost:8443/messagedigest?name=tad&digest=48-42-107158-79-63-49-101793-84-85-85511988-84-76-45-1267395-114-9589-5-776113-42-6
		String url;
		String postData;
//	  	if (("127.0.0.1:8888").equals(Window.Location.getHost())
//	    		|| ("localhost:8888").equals(Window.Location.getHost())) {
//			url= "http://localhost:8888/proxy8181?method=location";
//	  	} else {
//	  		url= "http://tupracticalpieces.appspot.com/proxy8181?method=location";
//	  	}
//	  	url = Window.Location.getHref() + "/proxy8181?method=location";
		url = "/messagedigest";
		postData = "name=" + name + "&digest=" + digest;
		/* Send request to server and catch any errors. */
		//Window.alert("isMatch entered url:" + url);
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
		try { 
			//builder.setHeader("Content-Type","text/plain");
		      	builder.setHeader("Content-Type", "application/x-www-form-urlencoded");
		      	builder.setHeader("Access-Control-Allow-Origin","*");
			@SuppressWarnings("unused")
			Request request = builder.sendRequest(postData, 
				new RequestCallback() {
			        	public void onError(Request request, Throwable exception) {
						Window.alert("checkDigest on error");
			        	}
			        	public void onResponseReceived(Request request, Response response) {
			          	if (200 == response.getStatusCode()) {
			        	  //Window.alert(response.getText());
			        	  	//Window.alert("checkDigest: status 200");
			        		boolean checkDigest = checkDigestInJava(response.getText());
                            //Window.alert("checkDigest:" + checkDigest);
			        	  	if (checkDigest) {
			        	  		loginQury(btnList, logList, callbackUrl);
			        	  	}
	
			          	} else {
			            		 // @@@@@@@@@@+ response.getStatusCode() + ":" + response.getStatusText()
						Window.alert("checkDigest on error StatusCode");
					}
				}});
		} catch (Exception e) {
 	     	      Window.alert("RequestBuilder expeption:" + e.toString());
		}
		return;
	}

//  @TUPracticalPiecesSource
  public static native boolean checkDigestInJava(String JsonStr) /*-{
    return $wnd.checkDigest(JsonStr);
  }-*/;
  
}

