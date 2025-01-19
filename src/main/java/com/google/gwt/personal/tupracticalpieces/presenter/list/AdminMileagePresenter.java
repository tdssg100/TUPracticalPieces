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
//package com.google.gwt.sample.mobilewebapp.presenter.tasklist;
package com.google.gwt.personal.tupracticalpieces.presenter.list;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.sample.mobilewebapp.client.ClientFactory;
//import com.google.gwt.sample.mobilewebapp.client.event.ShowTaskEvent;
//import com.google.gwt.sample.mobilewebapp.client.event.TaskListUpdateEvent;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
//import java.util.Arrays;
//import java.util.List;
import com.google.gwt.personal.tupracticalpieces.client.ClientFactory;
import com.google.gwt.personal.tupracticalpieces.client.event.ActionEvent;
import com.google.gwt.personal.tupracticalpieces.client.event.ActionNames;
import com.google.gwt.personal.tupracticalpieces.client.event.MileageEditEvent;
import com.google.gwt.personal.tupracticalpieces.client.event.MileageListUpdateEvent;
import com.google.gwt.personal.tupracticalpieces.client.event.ShowMileageEvent;
import com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace;
//import com.google.gwt.personal.tupracticalpieces.client.event.MileageListEvent;
//import com.google.gwt.personal.tupracticalpieces.client.event.ShowTaskEvent;
//import com.google.gwt.personal.tupracticalpieces.client.event.MileageListUpdateEvent;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.requestfactory.gwt.client.DefaultRequestTransport;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.RequestTransport;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace;
import com.google.gwt.personal.tupracticalpieces.client.content.CwUpdate;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditView;

import java.util.Collections;
import java.util.List;

/**
 * Activity that presents a list of tasks.
 */
//public class TaskListPresenter implements TaskListView.Presenter {
public class AdminMileagePresenter implements AdminMileageSuperView.Presenter {

  /**
   * The delay in milliseconds between calls to refresh the task list.
   */
  private static final int REFRESH_DELAY = 1000;

  private static List<MileageProxy> mileages;
  /**
   * A boolean indicating that we should clear the task list when started.
   */
//  private final boolean clearTaskList;
  private final boolean clearMileageList;

  private final ClientFactory clientFactory;

  private EventBus eventBus;
  
  /**
   * The refresh timer used to periodically refresh the task list.
   */
//  private Timer refreshTimer;
  private Timer refreshTimer;

//  public TaskListPresenter(ClientFactory clientFactory, boolean clearTaskList) {
  public AdminMileagePresenter(ClientFactory clientFactory, boolean clearMileageList) {
    this.clientFactory = clientFactory;
//    this.clearTaskList = clearTaskList;
    this.clearMileageList = clearMileageList;
//    clientFactory.getTaskListView().setPresenter(this);
    clientFactory.getMyAppAdminMileageView().setPresenter(this);
  }

  /**
   * Construct a new {@link TaskListPresenter}.
   * 
   * @param clientFactory the {@link ClientFactory} of shared resources
   * @param place configuration for this activity
   */
//  public TaskListPresenter(ClientFactory clientFactory, TaskListPlace place) {
//    this(clientFactory, place.isTaskListStale());
//  }
  public AdminMileagePresenter(ClientFactory clientFactory, AdminMileagePlace place) {
	    this(clientFactory, place.isMileageListStale());
	    
	    //Button btn;
	    
	    // Show
	    //btn = clientFactory.getMyAppAdminMileageView().getShowButton();
	    clientFactory.getMyAppAdminMileageView().getShowButton().addClickHandler(new ClickHandler() {
		  public void onClick(ClickEvent event) {
        refleshList();
      }});

      // Edit
	    //btn = clientFactory.getMyAppAdminMileageView().getEditButton();
	    clientFactory.getMyAppAdminMileageView().getEditButton().addClickHandler(new ClickHandler() {
			@Override
		    public void onClick(ClickEvent event) {


        if (clientFactory.getMyAppAdminMileageView().getSelected()== null) {
          Window.confirm("Select a row.");
          return;
        }

        clientFactory.getMyAppAdminMileageView().getShowButton().setEnabled(true);
        clientFactory.getMyAppAdminMileageView().getEditButton().setEnabled(false);
        clientFactory.getMyAppAdminMileageView().getDeleteButton().setEnabled(false);
        clientFactory.getMyAppAdminMileageView().getInsertButton().setEnabled(false);
        getView().clearList();
				editMileage(clientFactory.getMyAppAdminMileageView().getSelected());
			}
	    });

      // Delete
	    clientFactory.getMyAppAdminMileageView().getDeleteButton().addClickHandler(new ClickHandler() {
        @Override
          public void onClick(ClickEvent event) {
  
  
          if (clientFactory.getMyAppAdminMileageView().getSelected()== null) {
            Window.confirm("Select a row.");
            return;
          }
  
          clientFactory.getMyAppAdminMileageView().getShowButton().setEnabled(true);
          clientFactory.getMyAppAdminMileageView().getEditButton().setEnabled(false);
          clientFactory.getMyAppAdminMileageView().getDeleteButton().setEnabled(false);
          clientFactory.getMyAppAdminMileageView().getInsertButton().setEnabled(false);
          getView().clearList();
          deleteMileageFromList(clientFactory.getMyAppAdminMileageView().getSelected());
        }
        });
  


	    	    
	    // Insert
	    //btn = clientFactory.getMyAppAdminMileageView().getInsertButton();
      clientFactory.getMyAppAdminMileageView().getInsertButton().addClickHandler(new ClickHandler() {
				@Override
			    public void onClick(ClickEvent event) {
                clientFactory.getMyAppAdminMileageView().getShowButton().setEnabled(true);
                clientFactory.getMyAppAdminMileageView().getEditButton().setEnabled(false);
                clientFactory.getMyAppAdminMileageView().getDeleteButton().setEnabled(false);
                clientFactory.getMyAppAdminMileageView().getInsertButton().setEnabled(false);
                getView().clearList();
				        addMileage();
			    }
		});    
			    
	    
	    
	    
	    
	    
  }

//@Override
  public Widget asWidget() {
    return getView().asWidget();
  }

//  @Override
  public String mayStop() {
    return null; // always happy to stop
  }

//  public void selectTask(TaskProxy selected) {
//    // Go into edit mode when a task is selected.
//    eventBus.fireEvent(new ShowTaskEvent(selected));
//  }
//  public void selectTask(TaskProxy selected) {
  public void selectMileage(MileageProxy selected) {
	    // Go into edit mode when a task is selected.
//    eventBus.fireEvent(new ShowMileageEvent(selected));

  
  }
  
  @Override
  public void editMileage(MileageProxy selected) {
	  //clientFactory.getPlaceController().goTo(new MileageEditPlace(selected.getId(), "adminEdit:" + selected.getId()));
// Window.alert("On show edit mileage :" + selected.getId());
      eventBus.fireEvent(new ShowMileageEvent(selected));
      eventBus.fireEvent(new MileageEditEvent(selected));
	  
  }
 
  @Override
  //public void addMileage(Place place) {
  public void addMileage() {
	  //clientFactory.getPlaceController().goTo(new MileageEditPlace(null, "adminCeate"));
    //eventBus.fireEvent(new ShowMileageEvent(null));
    ActionEvent.fire(eventBus, ActionNames.ADD_MILEAGE);
//		    MileageEditView mileageEditView = clientFactory.getMileageEditView();
//		    mileageEditView.asWidget();
//		    container.setWidget(contentPanel);
//		    container.setAnimationDuration(500);
  }
  
  @Override
  public void deleteMileageFromList(MileageProxy selected) {
    final MileageProxy toDelete = selected;
//    clientFactory.getRequestFactory().taskRequest().remove().using(toDelete).fire(
    clientFactory.getRequestFactory().mileageRequest().remove().using(toDelete).fire(
        new Receiver<Void>() {
          @Override
          public void onFailure(ServerFailure error) {
//            Window.alert("An error occurred on the server while deleting this task: \"."
            Window.alert("An error occurred on the server while deleting this mileage: \"."
                + error.getMessage() + "\".");
          }

          @Override
          public void onSuccess(Void response) {
//            onTaskDeleted();
            onMileageDeletedFromList();
          }
        });
  }
  
  private void onMileageDeletedFromList() {
    // Notify the user that the task was deleted.
    //notify("Mileage Deleted");
    //notify("Task Deleted");

    // Return to the task list.
//    ActionEvent.fire(eventBus, ActionNames.TASK_SAVED);
    ActionEvent.fire(eventBus, ActionNames.MILEAGE_SAVED);
  }
  @Override
  public void start(EventBus eventBus) {
    this.eventBus = eventBus;

    
//    setPresenter(this);

    
    // Add a handler to the 'add' button in the shell.
//    clientFactory.getShell().setAddButtonVisible(true);
// TODO add Button    clientFactory.getShell().setAddButtonVisible(true);

    // Clear the task list and display it.
//    if (clearTaskList) {
//    if (clearMileageList) {
//      getView().clearList();
//    }

    // Create a timer to periodically refresh the task list.
//    refreshTimer = new Timer() {
//      @Override
//      public void run() {
//       refreshMileageList();
//      }
//    };


    
    
    // Load the saved task list from storage
//    List<TaskProxy> list = clientFactory.getTaskProxyLocalStorage().getTasks();
// TODO localstorage    List<TaskProxy> list = clientFactory.getTaskProxyLocalStorage().getTasks();
//    setTasks(list);
//    setMileages(mileages);
    // Load the saved task list from storage
//    List<MileageProxy> list = clientFactory.getMileageProxyLocalStorage().getMileages();
//	setMileages(list);
    //setMileages(mileages);


    //checkLogin();
    
    
    // Request the task list now.
    
    
    
//    refreshMileageList();
    // Create a timer to periodically refresh the task list.
//    refreshTimer = new Timer() {
//     @Override
//      public void run() {
//        refreshMileageList();
//      }
//    };
//    refreshTimer.schedule(REFRESH_DELAY);
  }

 
  @Override
  public void stop() {
    eventBus = null;

    // Kill the refresh timer.
//    if (refreshTimer != null) {
//      refreshTimer.cancel();
//    }
    
//     Kill the refresh timer.
	  if (refreshTimer != null) {
	    refreshTimer.cancel();
	  }
  }

//  private TaskListView getView() {
//    return clientFactory.getTaskListView();
//  }
//  private AdminMileageSuperView getView() {
  private CwUpdate getView() {
	    return clientFactory.getMyAppAdminMileageView();
  }

  /**
   * Refresh the task list.
   */
////  private void refreshTaskList() {
//  public void refreshMileageList() {
////    clientFactory.getRequestFactory().taskRequest().findAllTasks().fire(
//      clientFactory.getRequestFactory().mileageRequest().findAllMileages().fire(
////        new Receiver<List<TaskProxy>>() {
//          new Receiver<List<MileageProxy>>() {
////  TODO servier validation error
////          @Override
////          public void onConstraintViolation() {
////        	  
////          }
//          @Override
//          public void onFailure(ServerFailure error) {
//            // ignore
//          }
//
//          @Override
////          public void onSuccess(List<TaskProxy> response) {
//          public void onSuccess(List<MileageProxy> response) {
//
//            // Early exit if this activity has already been canceled.
//            //if (eventBus == null) {
//            //  return;
//            //}
//
//            // Display the tasks in the view.
//            if (response == null) {
////              response = Collections.<TaskProxy> emptyList();
//              response = Collections.<MileageProxy> emptyList();
//            }
////            setTasks(response);
//            setMileages(response);
//
//            // save the response to storage
////            clientFactory.getTaskProxyLocalStorage().setTasks(response);
//// TODO localStorage           clientFactory.getMileageProxyLocalStorage().setMileages(response);
//
//            // Restart the timer.
//            //refreshTimer.schedule(REFRESH_DELAY);
//          }
//        });
//  }

  /**
   * Set the list of tasks.
   */
//  private void setTasks(List<TaskProxy> tasks) {
//    getView().setTasks(tasks);
//    eventBus.fireEventFromSource(new TaskListUpdateEvent(tasks), this);
//  }
  private void setMileages(List<MileageProxy> mileages) {
	    this.mileages = mileages;

	    getView().setMileages(mileages);
//	    eventBus.fireEventFromSource(new MileageListUpdateEvent(mileages), this);
//	    eventBus.fireEventFromSource(new MileageListUpdateEvent(mileages), this);
  }
  /**
   * Call login routine when a view needing it were invoked.

  private void checkLogin() {
	  getView().checkLoginAdmin();
  }
  202406 */
//@Override
 public void goTo(Place place) {
	// TODO Auto-generated method stub
	clientFactory.getPlaceController().goTo(place);
 }
  
  @Override
  public void refleshList() {
    //Window.alert("Show button clicked");
    clientFactory.getMyAppAdminMileageView().getShowButton().setEnabled(false);
    //presenter.refreshMileageList();
              RequestTransport requestTransport = new DefaultRequestTransport();
              clientFactory.getRequestFactory().initialize(eventBus, requestTransport);
              clientFactory.getRequestFactory().mileageRequest().findAllMileages().fire(
    new Receiver<List<MileageProxy>>() {
      @Override
      public void onFailure(ServerFailure error) {
        Window.alert("rf mileage fail" + error.toString());
        // ignore
      }

      @Override
      public void onSuccess(List<MileageProxy> response) {
        // Early exit if this activity has already been canceled.
        //if (eventBus == null) {
        //  return;
        //}

        // Display the tasks in the view.
        if (response == null) {
          response = Collections.<MileageProxy> emptyList();
        }
        //Window.alert("mileage:" + response.size());
//            Window.alert("Show button clicked before setMileages");            
        setMileages(response);
//            Window.alert("Show button clicked after setMileages");
        // save the response to storage
        //clientFactory.getTaskProxyLocalStorage().setTasks(response);

        // Restart the timer.
        //refreshTimer.schedule(REFRESH_DELAY);
      }
    });	
 
      clientFactory.getMyAppAdminMileageView().getEditButton().setEnabled(true);
      clientFactory.getMyAppAdminMileageView().getDeleteButton().setEnabled(true);
      clientFactory.getMyAppAdminMileageView().getInsertButton().setEnabled(true);
  //gridPanel.setVisible(true);


  }

}





