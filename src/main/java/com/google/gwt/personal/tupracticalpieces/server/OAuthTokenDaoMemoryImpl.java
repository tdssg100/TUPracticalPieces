/*
 * Copyright (c) 2011 Google Inc.
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
/* modify signiture from about token to about process to be,
   because required to check the user about administrative process before hand.
 */

package com.google.gwt.personal.tupracticalpieces.server;

/*
import java.net.URL;

import java.util.logging.Logger;//TODO when deploy, change loglevel in log.properties

import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
*/
import com.google.gwt.personal.tupracticalpieces.server.OAuthTokenDaoMemoryImpl;

//import java.util.HashMap;
//import java.util.Map;

/**
 * Quick and Dirty memory implementation of {@link OAuthTokenDao} based on
 * HashMaps.
 */
public class OAuthTokenDaoMemoryImpl implements OAuthTokenDao {
  /* singleton */
  @SuppressWarnings("unused")
private static final int i = 0;
  /** Object where all the Tokens will be stored */
  /*
  */
  //private static final Logger log = Logger.getLogger(OAuthTokenDaoMemoryImpl.class.getName());

	//private static OAuthTokenDao oauthTokenDao = new OAuthTokenDaoMemoryImpl();
/*
  private static Map<String, String> tokenPersistance = new HashMap<String, String>();
*/
  private static String nameOfJob;

  /* 20141208 login */
  private static String user = "";
  private static String state = "LoginRESET";
  private static java.util.Date expire = new java.util.Date(0L);
  private static String message = "";
  private static String locus = "";
  /*

  public void saveKeys(String tokens, String value) {
    tokenPersistance.put(tokens, value);
  }

  public String getKeys(String tokens) {
    return tokenPersistance.get(tokens);
  }
 */
  public void saveJob(String name) {
	if (name.length() >= 12 && "ConsentCheck".equals(name.substring(0,12))) {
		nameOfJob = "ConsentCheck";
		appendMessage("Consent Check");
		return;
	}
	if (name.length() >= 12 && "ConsentLogin".equals(name.substring(0,12))) {
		String[] tmp = name.substring(13,name.length()).split(",");
		nameOfJob = "ConsentLogin";
		user = tmp[0];
		state = tmp[1];
		locus = tmp[3];
		expire.setTime(new java.util.Date().getTime() + 30*60*1000);
		return;
	}
	if (name.length() >= 14 && "ConsentTimeOut".equals(name.substring(0,14))) {
		nameOfJob = "ConsentTimeOut";
		user = ""; // init
		state = "LoginRESET";
		expire = new java.util.Date();
		return;
	}
	if (name.length() >= 9 && "InsertSQL".equals(name.substring(0,9))) {
		nameOfJob = "InsertSQL";
		expire.setTime(new java.util.Date().getTime() + 30*60*1000);
		return;
	}
	nameOfJob = name;
  }
  public String getJob() {
    return nameOfJob;
  }
		
  public String getPropMesg() {
	    return user + "," + state + "," + Long.toString(expire.getTime()) + "," + message;
  }
  
  public String getMessage() {
	    return message;
  }
  
  public String getLocus() {
	    return locus;
  }

  public void setSingletonState2OK(String mesg) {
	  state = "LoginOK";
	  expire = new java.util.Date(new java.util.Date().getTime() + 30 * 60 * 1000);
	  //log.info("set expire: " + expire.toString());
	  message = mesg;
  }
  public void setSingletonState2NG(String mesg) {
	  state = "LoginNG";
	  message = mesg;
  }
  public void appendMessage(String mesg) {
	  message += mesg;
  }
}
