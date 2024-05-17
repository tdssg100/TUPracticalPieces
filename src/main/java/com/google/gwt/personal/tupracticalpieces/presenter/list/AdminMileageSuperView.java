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
//package com.google.gwt.sample.mobilewebapp.presenter/tasklist;
package com.google.gwt.personal.tupracticalpieces.presenter.list;

//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
//import com.google.gwt.sample.ui.client.PresentsWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.place.shared.Place;

//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
//import com.google.gwt.personal.ui.client.PresentsWidgets;
import java.util.List;

/**
 * Implemented by views that display a list of tasks.
 */
public interface AdminMileageSuperView extends IsWidget {

  /**
   * The presenter for this view.
   */
//	  public interface Presenter extends PresentsWidgets {
	public interface Presenter {
    /**
     * Select a task.
     * 
     * @param selected the select task
     */
    void selectMileage(MileageProxy selected);
    
    
    void addMileage(Place place);
    
    void goTo(Place place);
    
    void stop();

  }

//  /**
//   * Clear the list of tasks.
//   */
  void clearList();

  /**
   * Sets the new presenter, and calls {@link Presenter#stop()} on the previous
   * one.
   */
  void setPresenter(Presenter presenter);

  /**
   * Set the list of tasks to display.
   * 
   * @param tasks the list of tasks
   */
  //void setTasks(List<MileageProxy> tasks);
  void setMileages(List<MileageProxy> mileages);



  /**
   * Check if a user has a privilege.
   * 
   * @param tasks the list of tasks
   */
  void checkLoginAdmin();

}
