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

//import com.google.gwt.activity.shared.AbstractActivity;
//import com.google.gwt.sample.mobilewebapp.client.ClientFactory;
//import com.google.gwt.sample.mobilewebapp.client.event.TaskEditEvent;
//import com.google.gwt.sample.mobilewebapp.presenter.task.TaskEditPresenter;
//import com.google.gwt.sample.mobilewebapp.presenter.task.TaskPlace;
//import com.google.gwt.sample.mobilewebapp.presenter.task.TaskReadPresenter;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
//import com.google.gwt.sample.ui.client.PresentsWidgets;
//import com.google.gwt.user.client.ui.AcceptsOneWidget;
//import com.google.web.bindery.event.shared.ResettableEventBus;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.personal.tupracticalpieces.client.ClientFactory;
import com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView;
import com.google.gwt.personal.tupracticalpieces.client.event.MileageEditEvent;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPresenter;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditView;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPresenter;
import com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.place.shared.Place;
//import com.google.gwt.personal.tupracticalpieces.presenter.task.TaskEditPresenter;
//import com.google.gwt.personal.tupracticalpieces.presenter.task.TaskReadPresenter;
//import com.google.gwt.personal.tupracticalpieces.shared.TaskProxy;
//import com.google.gwt.personal.ui.client.PresentsWidgets;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.ResettableEventBus;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * An activity that shows details on a particular task, and allows the user to
 * edit it.
 */
//public class TaskActivity extends AbstractActivity {
public class MileageEditActivity extends AbstractActivity implements MileageEditView.Presenter {
	
  private static final Logger log = Logger.getLogger(TUAdminActivity.class.getName());
	
//  private PresentsWidgets presenter;

  //private final TaskPlace place;
  private final MileageEditPlace place;

  private final ClientFactory clientFactory;

  private ResettableEventBus childEventBus;

  /**
   * Construct a new {@link TaskActivity}.
   * 
   * @param clientFactory the {@link ClientFactory} of shared resources
   * @param place configuration for this activity
   */
  //public TaskActivity(ClientFactory clientFactory, TaskPlace place) {
  public MileageEditActivity(ClientFactory clientFactory, MileageEditPlace place) {
    this.place = place;
    this.clientFactory = clientFactory;
  }

  @Override
  public String mayStop() {
//    return presenter.mayStop();
    return "Please hold on. This activity is stopping.";
  }

  /**
   * Navigate to a new Place in the browser
   */
  public void goTo(Place place) {
      clientFactory.getPlaceController().goTo(place);
  }
  
  
  @Override
  public void onCancel() {
//    presenter.stop();
//    clientFactory.getPlaceController().onCancel()
  }

  @Override
  public void onStop() {
    childEventBus.removeHandlers();
//    presenter.stop();
//    clientFactory.getPlaceController().onStop(place);
    
  }

//  public void start(final AcceptsOneWidget container, com.google.gwt.event.shared.EventBus eventBus) {
//	    this.childEventBus = new ResettableEventBus(eventBus);
//	    eventBus.addHandler(TaskEditEvent.TYPE, new TaskEditEvent.Handler() {
//	      @Override
//	      public void onTaskEdit(TaskEditEvent event) {

  public void start(final AcceptsOneWidget container, com.google.gwt.event.shared.EventBus eventBus) {
//	this.childEventBus = new ResettableEventBus(eventBus);
//	eventBus.addHandler(MileageEditEvent.TYPE, new MileageEditEvent.Handler() {
//	  @Override
//	  public void onMileageEdit(MileageEditEvent event) {
//	    // Stop the read presenter
//	    onStop();
////	    presenter = startEdit(event.getReadOnlyTask());
//	    presenter = startEdit(event.getReadOnlyMileage());
//	    
//	    
//	    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
////	    clientFactory.get History.newItem("adminEdit");
//	    container.setWidget(presenter);
//	    
//	  }
//	});
      MileageEditView mileageEditView = clientFactory.getMileageEditView();
//      mileageEditView.setName(name);
      mileageEditView.setName("adminEdit");
      mileageEditView.setPresenter(this);
//      containerWidget.setWidget(mileageEditView.asWidget());
      container.setWidget(mileageEditView.asWidget());
	  
	
//	if (place.getTaskId() == null) {
//	  presenter = startCreate();
//	} else {
//	  presenter = startDisplay(place);
//	}
//	container.setWidget(presenter);

//	if (place.getMileageId() == null) {
//	  presenter = startCreate();
//	} else {
//	  presenter = startDisplay(place);
//	}
//	container.setWidget(presenter);
//
////Tutorial : Activity inherites view's presenter	
////	AdminMileageView adminMileageView = clientFactory.getMyAppAdminMileageView();
////	adminMileageView.setName(name);
////	adminMileageView.setPresenter(this);
////  container.setWidget(adminMileageView.asWidget());
//	
  }

@Override
public void deleteMileage() {
	// TODO Auto-generated method stub
	
}

@Override
public void saveMileage() {
	// TODO Auto-generated method stub
	
}

@Override
public void setName(String goodbyeName) {
	// TODO Auto-generated method stub
	
}

@Override
public Widget asWidget() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void stop() {
	// TODO Auto-generated method stub
	
}
  
//  private PresentsWidgets startCreate() {
//	  PresentsWidgets rtn = new MileageEditPresenter(clientFactory);
//	  rtn.start(childEventBus);
//	  return rtn;
//  }
//
//  // private PresentsWidgets startDisplay(TaskPlace place) {
//  private PresentsWidgets startDisplay(MileagePlace place) {
//	  //PresentsWidgets rtn = new TaskReadPresenter(clientFactory, place);
//	  PresentsWidgets rtn = new MileageReadPresenter(clientFactory, place);
//	  rtn.start(childEventBus);
//	  return rtn;
//  }
//  
//  private PresentsWidgets startEdit(MileageProxy readOnlyTask) {
//	  PresentsWidgets rtn = new MileageEditPresenter(clientFactory, readOnlyTask);
//	  rtn.start(childEventBus);
//	  return rtn;
//  }
}
  
//  public void start(final AcceptsOneWidget container, com.google.gwt.event.shared.EventBus eventBus) {
//    this.childEventBus = new ResettableEventBus(eventBus);
//    eventBus.addHandler(TaskEditEvent.TYPE, new TaskEditEvent.Handler() {
//      @Override
//      public void onTaskEdit(TaskEditEvent event) {
//        // Stop the read presenter
//        onStop();
//        presenter = startEdit(event.getReadOnlyTask());
//        container.setWidget(presenter);
//      }
//    });
//
//    if (place.getTaskId() == null) {
//      presenter = startCreate();
//    } else {
//      presenter = startDisplay(place);
//    }
//    container.setWidget(presenter);
//  }
//
//  private PresentsWidgets startCreate() {
//    PresentsWidgets rtn = new TaskEditPresenter(clientFactory);
//    rtn.start(childEventBus);
//    return rtn;
//  }
//
////  private PresentsWidgets startDisplay(TaskPlace place) {
//  private PresentsWidgets startDisplay(MileagePlace place) {
////    PresentsWidgets rtn = new TaskReadPresenter(clientFactory, place);
//	PresentsWidgets rtn = new MileageReadPresenter(clientFactory, place);
//    rtn.start(childEventBus);
//    return rtn;
//  }
//
//  private PresentsWidgets startEdit(TaskProxy readOnlyTask) {
//    PresentsWidgets rtn = new TaskEditPresenter(clientFactory, readOnlyTask);
//    rtn.start(childEventBus);
//    return rtn;
//  }
