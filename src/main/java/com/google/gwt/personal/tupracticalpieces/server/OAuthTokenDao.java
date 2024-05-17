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
import com.google.api.client.auth.oauth2.draft10.AccessTokenResponse;
*/
/**
 * Allows easy storage and access of authorization tokens.
 */
public interface OAuthTokenDao {

  /**
   * Stores the given AccessTokenResponse using the {@code username}, the OAuth
   * {@code clientID} and the tokens scopes as keys.
   *
   * @param tokens The AccessTokenResponse to store
   * @param userName The userName associated wit the token

  public void saveKeys(AccessTokenResponse tokens, String userName);
   */
  public void saveJob(String name);

  /**
   * Returns the AccessTokenResponse stored for the given username, clientId and
   * scopes. Returns {@code null} if there is no AccessTokenResponse for this
   * user and scopes.
   *
   * @param userName The username of which to get the stored AccessTokenResponse
   * @return The AccessTokenResponse of the given username
  public AccessTokenResponse getKeys(String userName);
   */
  public String getJob();
  public String getMessage();
  public String getPropMesg();
  public String getLocus();
  public void setSingletonState2OK(String msg);
  public void setSingletonState2NG(String msg);
}
