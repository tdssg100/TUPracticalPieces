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
//package com.google.gwt.sample.mobilewebapp.client.activity;
package com.google.gwt.personal.tupracticalpieces.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
//import com.google.gwt.sample.mobilewebapp.client.ClientFactory;
//import com.google.gwt.sample.mobilewebapp.presenter.task.TaskPlace;
//import com.google.gwt.sample.mobilewebapp.presenter.tasklist.TaskListPlace;
//import com.google.gwt.sample.mobilewebapp.presenter.tasklist.TaskListPresenter;
import com.google.gwt.personal.tupracticalpieces.client.ClientFactory;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileagePlace;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageReadPlace;
import com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace;
import com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePresenter;
import com.google.gwt.personal.tupracticalpieces.client.activity.TUAdminActivity;
//import com.google.gwt.personal.tupracticalpieces.presenter.tasklist.TaskListPlace;
//import com.google.gwt.personal.tupracticalpieces.presenter.tasklist.TaskListPresenter;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
//import java.util.logging.Level;
//import java.util.logging.Logger;

//import org.eclipse.jetty.util.log.Log;
/**
 * A mapping of places to activities used by this application.
 */
public class AppActivityMapper implements ActivityMapper {
  
//  private static final Logger log = Logger.getLogger(AppActivityMapper.class.getName());

  private final ClientFactory clientFactory;

  public AppActivityMapper(ClientFactory clientFactory) {
    super();
    this.clientFactory = clientFactory;
  }

  @Override
  public Activity getActivity(final Place place) {
	//clientFactory.getShell().setWidget();
	//if (place instanceof TaskListPlace) {
    if (place instanceof AdminMileagePlace) {
//	  String token = clientFactory.getApp().getHistoristoryMapper().getToken(place);;
//	  log.info("MVP activity token:" + token);
//	  if (token.equals("!AdminMileageView:") ) {

//	  return new AbstractActivity() {
//            @Override
//            public void start(AcceptsOneWidget panel, EventBus eventBus) {
//              AdminMileagePresenter presenter = new AdminMileagePresenter(clientFactory, (AdminMileagePlace) place);
//              presenter.start(eventBus);

//      clientFactory.getMyAppAdminMileageView().setPresenter(presenter);
    	
//      panel.setWidget(presenter);
//    }
 
              
    	return new TUAdminActivity(clientFactory, (AdminMileagePlace) place);
                               
    } else if (place instanceof MileageEditPlace) {     
    	return new MileageEditActivity(clientFactory, (MileageEditPlace) place);
    } else if (place instanceof MileageReadPlace) {     
    	return new MileageReadActivity(clientFactory, (MileageReadPlace) place);
    }         

            /*
             * Note no call to presenter.stop(). The TaskListViews do that
             * themselves as a side effect of setPresenter.
             */

//
//    if (place instanceof TaskPlace) {
//      // Editable view of a task.
//      return new TaskActivity(clientFactory, (TaskPlace) place);
//    }

  
/*
  if (place instanceof MileagePlace) {
//    if (token.equals("adminEdit:create")) {
	  // Editable view of a task.
	  return new TUAdminActivity(clientFactory, (AdminMileagePlace) place);
	}
*/
    return null;
  }
}
///**
// * A mapping of places to activities used by this application.
// */
//public class AppActivityMapper implements ActivityMapper {
//
//  private final ClientFactory clientFactory;
//
//  public AppActivityMapper(ClientFactory clientFactory) {
//    this.clientFactory = clientFactory;
//  }
//
//  public Activity getActivity(final Place place) {
//    if (place instanceof TaskListPlace) {
//      // The list of tasks.
//      return new AbstractActivity() {
//        @Override
//        public void start(AcceptsOneWidget panel, EventBus eventBus) {
//          TaskListPresenter presenter = new TaskListPresenter(clientFactory, (TaskListPlace) place);
//          presenter.start(eventBus);
//          panel.setWidget(presenter);
//        }
//
//        /*
//         * Note no call to presenter.stop(). The TaskListViews do that
//         * themselves as a side effect of setPresenter.
//         */
//      };
//    }
//
//    if (place instanceof TaskPlace) {
//      // Editable view of a task.
//      return new TaskActivity(clientFactory, (TaskPlace) place);
//    }
//
//    return null;
//  }
//}

