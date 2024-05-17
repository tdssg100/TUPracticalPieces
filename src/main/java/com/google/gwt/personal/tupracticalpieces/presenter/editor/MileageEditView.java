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

import com.google.gwt.editor.client.Editor;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.place.shared.Place;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
//import com.google.gwt.sample.ui.client.PresentsWidgets;
//import com.google.gwt.personal.ui.client.PresentsWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;

/**
 * Implemented by widgets that edit tasks.
 */
//public interface TaskEditView extends Editor<TaskProxy>, IsWidget {
public interface MileageEditView extends Editor<MileageProxy>, IsWidget {

  /**
   * The presenter for this view.
   */
//  public interface Presenter extends PresentsWidgets {
	public interface Presenter  {
    /**
     * Delete the current task or cancel the creation of a task.
     */
//    void deleteTask();
    void deleteMileage();

    /**
     * Create a new task or save the current task based on the values in the
     * inputs.
     */
//    void saveTask();
    void saveMileage();
    
    void goTo(Place place);

    void setName(String goodbyeName);

	Widget asWidget();

	String mayStop();
	
	void stop();
   
  }

  /**
   * Get the driver used to edit tasks in the view.
   */
//  RequestFactoryEditorDriver<TaskProxy, ?> getEditorDriver();
  RequestFactoryEditorDriver<MileageProxy, ?> getEditorDriver();

  /**
   * Specify whether the view is editing an existing task or creating a new
   * task.
   * 
   * @param isEditing true if editing, false if creating
   */
  void setEditing(boolean isEditing);

  /**
   * Lock or unlock the UI so the user cannot enter data. The UI is locked until
   * the task is loaded.
   * 
   * @param locked true to lock, false to unlock
   */
  void setLocked(boolean locked);

//  /**
//   * The the violation associated with the name.
//   * 
//   * @param message the message to show, or null if no violation
//   */
//  void setNameViolation(String message);

  /**
   * Set the {@link Presenter} for this view.
   * 
   * @param presenter the presenter
   */
  void setPresenter(Presenter presenter);


  void setName(String helloName);
 
  
  
  
  
  
//  void show();
//  
//  
//  void hide();


  /**
   * Check if a user has a privilege.
   * 
   * @param tasks the list of tasks
   */
  void checkLoginAdmin();

  

}
