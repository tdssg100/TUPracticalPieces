package com.google.gwt.personal.tupracticalpieces.client.common;
import java.util.List;

//import org.apache.tools.ant.taskdefs.Javadoc.Html;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.URL;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminTask;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminTaskAsync;
import com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch;


public class LoginState  {
	private static LoginState singleton = new LoginState();

	private List<Button> btnList;

	public static List<HTML> logList;
	
	private String callbackUrl;
	/**
	 * RPC.
	 * 
	 */
	//@TUPracticalPiecesData
	public final AdminTaskAsync adminTaskSvc = GWT.create(AdminTask.class);

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
							url = "https://accounts.google.com/o/oauth2/auth?" + 
									URL.encode("response_type=code&" +
											"client_id=9571369657.apps.googleusercontent.com&" +
											"redirect_uri=" + Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/oauth2callback&" +
											"scope=https://www.googleapis.com/auth/userinfo.profile " +  
											"https://www.googleapis.com/auth/userinfo.email&" +
											"state=/profile");
//							Window.alert(url); //TODO when restart to update, open this url.
					    // localhost devserver
//						} else  if (("tupracticalpieces.appspot.com:8888").equals(Window.Location.getHost())) {
						} else if (("tupracticalpieces.appspot.com").equals(Window.Location.getHost())) {
							url = "https://accounts.google.com/o/oauth2/auth?" + 
									URL.encode("response_type=code&" +
											"client_id=9571369657-0omq28sbvq94as3bl127ia3de85lf2l9.apps.googleusercontent.com&" +
											"redirect_uri=" + Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/oauth2callback&" +
											"scope=https://www.googleapis.com/auth/userinfo.profile " +  
											"https://www.googleapis.com/auth/userinfo.email&" +
											"state=/profile");


							Window.alert(url); //TODO when restart to update, open this url.


						} else {
							url = "https://accounts.google.com/o/oauth2/auth?" + 
									URL.encode("response_type=code&" +
											"client_id=9571369657-3mqoa0q64gfer18q52gmhmul9gg5anus.apps.googleusercontent.com&" +
											"redirect_uri=" + Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/oauth2callback&" +
											"scope=https://www.googleapis.com/auth/userinfo.profile " +  
											"https://www.googleapis.com/auth/userinfo.email&" +
											"state=/profile");
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







}
