/*
 * Copyright 2011 Google Inc.
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
/**
 * 20160123 MVP for mobile
 * 20160222 eventbus, presenter, place, activities
 * 20160511 editor
 */
//package com.google.gwt.sample.mobilewebapp.shared;
package com.google.gwt.personal.tupracticalpieces.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

/**
 * Request factory for this app.
 */

//public interface MobileWebAppRequestFactory extends RequestFactory {
public interface UserRequestFactory extends RequestFactory {

  /**
   * Create a new {@link TaskRequest}.
   */
	
	UserRequest serRequest();
}
