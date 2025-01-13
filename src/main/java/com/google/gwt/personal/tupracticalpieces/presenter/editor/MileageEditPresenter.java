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
//package com.google.gwt.sample.mobilewebapp.presenter.task;
package com.google.gwt.personal.tupracticalpieces.presenter.editor;

//import com.google.gwt.sample.mobilewebapp.client.ClientFactory;
//import com.google.gwt.sample.mobilewebapp.client.event.ActionEvent;
//import com.google.gwt.sample.mobilewebapp.client.event.ActionNames;
//import com.google.gwt.sample.mobilewebapp.client.ui.SoundEffects;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
import com.google.gwt.personal.tupracticalpieces.client.ClientFactory;
//import com.google.gwt.personal.tupracticalpieces.client.content.auth.AdminMileageEditView;
import com.google.gwt.personal.tupracticalpieces.client.event.ActionEvent;
import com.google.gwt.personal.tupracticalpieces.client.event.ActionNames;
import com.google.gwt.personal.tupracticalpieces.client.ui.SoundEffects;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.personal.tupracticalpieces.shared.MileageRequest;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

import java.util.Set;
//import java.util.logging.Logger;

import javax.validation.ConstraintViolation;

/**
 * Drives a {@link TaskEditView} to fetch and edit a given task, or to create a
 * new one.
 */
//public class TaskEditPresenter implements TaskEditView.Presenter {
public class MileageEditPresenter implements MileageEditView.Presenter {


//  private static final Logger log = Logger.getLogger(TaskEditPresenter.class.getName());

	//You are not required to use it, for example it's a good practice to user Gin (Dependency injection for client in gwt).
	private final ClientFactory clientFactory;

  /**
   * Indicates whether the activity is editing an existing task or creating a
   * new task.
   */
  private boolean isEditing;

  /**
   * The current task being edited, provided by RequestFactory.
   */
//  private TaskProxy editTask;
  private MileageProxy editMileage;

  /**
   * The ID of the current task being edited.
   */
//  private final Long taskId;
  private final Long mileageId;

  /**
   * The request used to persist the modified task.
   */
//  private Request<Void> taskPersistRequest;
  private Request<Void> mileagePersistRequest;
  private EventBus eventBus;

  /**
   * For creating a new task.
   */
//  public TaskEditPresenter(ClientFactory clientFactory) {
  public MileageEditPresenter(ClientFactory clientFactory) {
//	      this.taskId = null;
	      this.mileageId = null;
   
	      this.clientFactory = clientFactory;
//    clientFactory.getTaskEditView().setPresenter(this);
//    getView().setPresenter(this);
//    clientFactory.getShell().setWidget(getView().asWidget()); // To display the view is from activities.
//    clientFactory.getMileageEditView().setPresenter(this);
      //asWiget();
}

  /**
   * For editing an existing task.
   */
//  public TaskEditPresenter(ClientFactory clientFactory, TaskProxy readOnlyTask) {
//  public MileageEditPresenter(ClientFactory clientFactory, MileageProxy readOnlyMileage) {
	public MileageEditPresenter(ClientFactory clientFactory, MileageProxy readOnlyMileage) {
    /*
     * TODO surely we can find a way to show the read-only values while waiting
     * for the async fetch
     */
//    this.taskId = readOnlyTask.getId();
	if (readOnlyMileage != null) {
      this.mileageId = readOnlyMileage.getId();
	} else {
	  this.mileageId = null;
	}
    this.clientFactory = clientFactory;
//    clientFactory.getTaskEditView().setPresenter(this);
    clientFactory.getMileageEditView().setPresenter(this);
  }

  @Override
  public Widget asWidget() {
    return getView().asWidget();
  }

//  public void deleteTask() {
  public void deleteMileage() {
    if (isEditing) {
//      doDeleteTask();
      doDeleteMileage();
    } else {
//      doCancelTask();
      doCancelMileage();
    }
  }

  @Override
  public void stop() {
	    eventBus = null;
	    // Ignore all incoming responses to the requests from this activity.
	    //isDead = true;
  }

  @Override
  public String mayStop() {
//    if ((eventBus != null && editTask != null) && getView().getEditorDriver().isDirty()) {
    if ((eventBus != null && editMileage != null) && getView().getEditorDriver().isDirty()) {
      return "Are you sure you want to discard these changes?";
    }
    return null;
  }

//  public void saveTask() {
  public void saveMileage() {
    // Flush the changes into the editable task.
//    TaskRequest context = (TaskRequest) clientFactory.getTaskEditView().getEditorDriver().flush();
    MileageRequest context = (MileageRequest) clientFactory.getMileageEditView().getEditorDriver().flush();
Window.alert("persisting...");
    /*
     * Create a persist request the first time we try to save this task. If a
     * request already exists, reuse it.
     */
//    if (taskPersistRequest == null) {
    if (mileagePersistRequest == null) {
//      taskPersistRequest = context.persist().using(editTask);
      mileagePersistRequest = context.persist().using(editMileage);
    }

    Window.alert("persisting......fire");
    // Fire the request.
//    taskPersistRequest.fire(new Receiver<Void>() {
    mileagePersistRequest.fire(new Receiver<Void>() {
      @Override
      public void onConstraintViolation(Set<ConstraintViolation<?>> violations) {
        handleConstraintViolations(violations);
      }

      @Override
      public void onSuccess(Void response) {
        //        editTask = null;
        editMileage = null;

        // Notify the user that the task was updated.
//        TaskEditPresenter.this.notify("Task Saved");
        MileageEditPresenter.this.notify("Mileage Saved");
        
        // Return to the task list.
//        ActionEvent.fire(eventBus, ActionNames.TASK_SAVED);
        ActionEvent.fire(eventBus, ActionNames.MILEAGE_SAVED);
      }
    });
    Window.alert("persisting......end");
  }

//  public void start(EventBus eventBus) {
  public void start(EventBus eventBus) {
    this.eventBus = eventBus;
    getView().setNameViolation(null);

    // Prefetch the sounds used in this activity.
    SoundEffects.get().prefetchError();

    // Hide the 'add' button in the shell.
    // TODO(rjrjr) Ick!
//    clientFactory.getShell().setAddButtonVisible(false);

//    checkLogin();
    
    
//    if (taskId == null) {
    if (mileageId == null) {
      startCreate();
    } else {
      startEdit();
    }
    
    
    
    
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//    clientFactory.getMileageEditView().show();
    
    
    
    
  }

  /*
  @Override
  public void mayStop() {
    eventBus = null;
//    clientFactory.getTaskEditView().setLocked(false);
    clientFactory.getMileageEditView().setLocked(false);

    
    
    
    
    
    
    
    
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//    clientFactory.getMileageEditView().hide();
    
    
    
    
  }
*/
  
  /**
   * Cancel the current task.
   */
//  private void doCancelTask() {
  private void doCancelMileage() {
    ActionEvent.fire(eventBus, ActionNames.EDITING_CANCELED);
  }

  /**
   * Delete the current task.
   */
//  private void doDeleteTask() {
  private void doDeleteMileage() {
//    if (editTask == null) {
	if (editMileage == null) {
      return;
    }

    // Delete the task in the data store.
//    final TaskProxy toDelete = this.editTask;
    final MileageProxy toDelete = this.editMileage;
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
            onMileageDeleted();
          }
        });
  }

//  private TaskEditView getView() {
  private MileageEditView getView() {
//    return clientFactory.getTaskEditView();
    return clientFactory.getMileageEditView();
  }
  

  /**
   * Handle constraint violations.
   */
  private void handleConstraintViolations(Set<ConstraintViolation<?>> violations) {
    // Display the violations.
    getView().getEditorDriver().setConstraintViolations(violations);

    // Play a sound.
    //SoundEffects.get().playError();
  }

  /**
   * Notify the user of a message.
   * 
   * @param message the message to display
   */
  private void notify(String message) {
    // TODO Add notification pop-up
//    log.fine("Tell the user: " + message);
  }

  /**
   * Called when a task has been successfully deleted.
   */
//  private void onTaskDeleted() {
  private void onMileageDeleted() {
    // Notify the user that the task was deleted.
    notify("Task Deleted");

    // Return to the task list.
//    ActionEvent.fire(eventBus, ActionNames.TASK_SAVED);
    ActionEvent.fire(eventBus, ActionNames.MILEAGE_SAVED);
  }

  private void startCreate() {

    Window.alert("startCreate endtered.");
    isEditing = false;
    getView().setEditing(false);
//    TaskRequest request = clientFactory.getRequestFactory().taskRequest();
//    editTask = request.create(TaskProxy.class);
//    getView().getEditorDriver().edit(editTask, request);
    MileageRequest request = clientFactory.getRequestFactory().mileageRequest();
    editMileage = request.create(MileageProxy.class);
    getView().getEditorDriver().edit(editMileage, request);
  }

  private void startEdit() {

    Window.alert("startCreate startEdit.");
    isEditing = true;
    getView().setEditing(true);
    // Lock the display until the task is loaded.
    getView().setLocked(true);
//    clientFactory.getRequestFactory().taskRequest().findTask(this.taskId).fire(

    clientFactory.getRequestFactory().mileageRequest().findMileage(this.mileageId).fire(
    
//        new Receiver<TaskProxy>() {
        new Receiver<MileageProxy>() {
          @Override
          public void onConstraintViolation(Set<ConstraintViolation<?>> violations) {
            getView().setLocked(false);
            getView().getEditorDriver().setConstraintViolations(violations);
          }

          @Override
          public void onFailure(ServerFailure error) {
            getView().setLocked(false);
//            doCancelTask();
            doCancelMileage();
            super.onFailure(error);
          }

          @Override
//          public void onSuccess(TaskProxy response) {
          public void onSuccess(MileageProxy response) {
            // Early exit if we have already stopped.
            if (eventBus == null) {
              return;
            }

            // Task not found.
            if (response == null) {
//              Window.alert("The task with id '" + taskId + "' could not be found."
//                  + " Please select a different task from the task list.");
              Window.alert("The mileage with id '" + mileageId + "' could not be found."
                      + " Please select a different task from the mileage list.");
//              doCancelTask();
              doCancelMileage();
              return;
            }

            // Show the task.
//            editTask = response;
            editMileage = response;
//            getView().getEditorDriver().edit(response,
//                clientFactory.getRequestFactory().taskRequest());
            getView().getEditorDriver().edit(response,
            clientFactory.getRequestFactory().mileageRequest());
            getView().setLocked(false);
          }
        });
  }
  
//  private void checkLogin() {
//	  getView().checkLoginAdmin();
//  }
//
@Override
public void goTo(Place place) {
	// TODO Auto-generated method stub
	clientFactory.getPlaceController().goTo(place);
	
}

@Override
public void setName(String goodbyeName) {
	// TODO Auto-generated method stub
	
}
//
//@Override
//public void start(DeckLayoutPanel container, EventBus eventBus) {
//	// TODO Auto-generated method stub
//	
//} 
//  
  
}
