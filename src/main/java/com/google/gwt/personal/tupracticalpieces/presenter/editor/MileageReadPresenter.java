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
//package com.google.gwt.sample.mobilewebapp.presenter.task;
package com.google.gwt.personal.tupracticalpieces.presenter.editor;

import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.place.shared.Place;
//import com.google.gwt.sample.mobilewebapp.client.ClientFactory;
//import com.google.gwt.sample.mobilewebapp.client.event.ActionEvent;
//import com.google.gwt.sample.mobilewebapp.client.event.ActionNames;
//import com.google.gwt.sample.mobilewebapp.client.event.TaskEditEvent;
import com.google.gwt.personal.tupracticalpieces.client.ClientFactory;
import com.google.gwt.personal.tupracticalpieces.client.event.ActionEvent;
import com.google.gwt.personal.tupracticalpieces.client.event.ActionNames;
import com.google.gwt.personal.tupracticalpieces.client.event.MileageEditEvent;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;

/**
 * Makes a TaskReadView display a task.
 */
//public class TaskReadPresenter implements TaskReadView.Presenter {
public class MileageReadPresenter implements MileageReadView.Presenter {

  private final ClientFactory clientFactory;

  /**
   * A boolean indicating whether or not this activity is still active. The user
   * might move to another activity while this one is loading, in which case we
   * do not want to do any more work.
   */
  private boolean isDead = false;

  /**
   * The current task being displayed, might not be possible to edit it.
   */
//  private TaskProxy task;
  private MileageProxy mileage;

  /**
   * The ID of the current task being edited.
   */
//  private final Long taskId;
  private final Long mileageId;
  private EventBus eventBus;

  /**
   * Construct a new {@link TaskReadPresenter}.
   * 
   * @param clientFactory the {@link ClientFactory} of shared resources
   * @param place configuration for this activity
   */
//  public TaskReadPresenter(ClientFactory clientFactory, TaskPlace place) {
  public MileageReadPresenter(ClientFactory clientFactory, MileageReadPlace place) {
//    this.taskId = place.getTaskId();
//    this.task = place.getTask();
    this.mileageId = place.getMileageId();
    this.mileage = place.getMileage();
    this.clientFactory = clientFactory;
//    clientFactory.getTaskReadView().setPresenter(this);
    getView().setPresenter(this);
//    clientFactory.getShell().setWidget(getView().asWidget()); 
  }
  
  @Override
//  public void editTask() {
  public void editMileage() {
//    eventBus.fireEvent(new TaskEditEvent(task));
    eventBus.fireEvent(new MileageEditEvent(mileage));
  }

  @Override
  public Widget asWidget() {
    return getView().asWidget();
  }


  @Override
  public String mayStop() {
    return null;
  }

  public void start(EventBus newEventBus) {
    this.eventBus = newEventBus;

    // Hide the 'add' button in the shell.
    // TODO(rjrjr) Ick!
//    clientFactory.getShell().setAddButtonVisible(false);
    //getView().setAddButtonVisible(false);

    // Try to load the task from local storage.
//    if (task == null) {
//      task = clientFactory.getTaskProxyLocalStorage().getTask(taskId);
// TODO localStorage    if (mileage == null) {
//        mileage = clientFactory.getMileageProxyLocalStorage().getMileage(mileageId);
//    }

//    if (task == null) {
    if (mileage == null) {
      // Load the existing task.
//      clientFactory.getRequestFactory().taskRequest().findTask(this.taskId).fire(
        clientFactory.getRequestFactory().mileageRequest().findMileage(this.mileageId).fire(
//          new Receiver<TaskProxy>() {
          new Receiver<MileageProxy>() {
            @Override
//            public void onSuccess(TaskProxy response) {
            public void onSuccess(MileageProxy response) {
              // Early exit if this activity has already been cancelled.
              if (isDead) {
                return;
              }

              // Task not found.
              if (response == null) {
//                Window.alert("The task with id '" + taskId + "' could not be found."
//                    + " Please select a different task from the task list.");
                  Window.alert("The mileage with id '" + mileageId + "' could not be found."
                          + " Please select a different mileage from the mileage list.");
                ActionEvent.fire(eventBus, ActionNames.EDITING_CANCELED);
                return;
              }

              // Show the task.
//              task = response;
              mileage = response;
//              getView().getEditorDriver().edit(response);
//              getView().getEditorDriver().edit(response,
//                clientFactory.getRequestFactory().mileageRequest());
              getView().getReadEditorDriver().edit(response);
            }
          });
    } else {
      // Use the task that was passed with the place.
//      getView().getEditorDriver().edit(task);
//        getView().getEditorDriver().edit(mileage);
//        getView().getEditorDriver().edit(mileage,
//          clientFactory.getRequestFactory().mileageRequest());
        getView().getReadEditorDriver().edit(mileage);
    }
  }

  @Override
  public void stop() {
    eventBus = null;
    // Ignore all incoming responses to the requests from this activity.
    isDead = true;
  }

//  private TaskReadView getView() {
//    return clientFactory.getTaskReadView();
  private MileageReadView getView() {
	    return clientFactory.getMileageReadView();
  }
@Override
public void goTo(Place place) {
	// TODO Auto-generated method stub
	clientFactory.getPlaceController().goTo(place);
	
}
}
