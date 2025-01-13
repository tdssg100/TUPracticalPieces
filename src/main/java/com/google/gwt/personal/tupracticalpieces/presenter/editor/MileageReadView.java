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
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
//import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.place.shared.Place;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
//import com.google.gwt.sample.ui.client.PresentsWidgets;
import com.google.gwt.personal.tupracticalpieces.presenter.list.PresentsWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;

/**
 * A readonly view of a task.
 */
//public interface TaskReadView extends Editor<TaskProxy>, IsWidget {
public interface MileageReadView extends Editor<MileageProxy>, IsWidget {

  /**
   * The presenter for this view.
   */
  public interface Presenter extends PresentsWidgets {
//	  public interface Presenter  {
    /**
     * Switch to an edit view of this task.
     */
//    void editTask();
    void editMileage();
    
    void goTo(Place place);

    void stop();
  }

  /**
   * Get the driver used to edit tasks in the view.
   */
//  SimpleBeanEditorDriver<TaskProxy, ?> getEditorDriver();
  SimpleBeanEditorDriver<MileageProxy, ?> getReadEditorDriver();
  
  /**
   * Set the {@link Presenter} for this view.
   * @param presenter the presenter
   */
  void setPresenter(Presenter presenter);
}
