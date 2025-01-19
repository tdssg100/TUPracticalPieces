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

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
//import com.google.gwt.place.shared.Prefix;

/**
 * The place in the app that shows a list of tasks.
 */
//public class TaskListPlace extends Place {
public class AdminMileagePlace extends Place {

    private String adminMileageName;

    public AdminMileagePlace(String token) {
        this.MileageListStale = false;
		this.adminMileageName = token;
    }

    public String getAminMileageName() {
        return adminMileageName;
    }
  /**
   * The tokenizer for this place. TaskList doesn't have any state, so we don't
   * have anything to encode.
   */
//@Prefix("tl")
      //@Prefix("adminList")
        //public static class Tokenizer implements PlaceTokenizer<TaskListPlace> {
//@Prefix("!AdminMileageView")
  @Prefix("ml")
  public static class Tokenizer implements PlaceTokenizer<AdminMileagePlace> {

//    public TaskListPlace getPlace(String token) {
//      return new TaskListPlace(true);
//    }
//
//    public String getToken(TaskListPlace place) {
//      return "";
//    }
    public AdminMileagePlace getPlace(String token) {
        return new AdminMileagePlace(true);
      }

    public String getToken(AdminMileagePlace place) {
        return "";
      }
  
  }

  //private final boolean taskListStale;
  private final boolean MileageListStale;
  /**
   * Construct a new {@link TaskListPlace}.
   * 
   * @param taskListStale true if the task list is stale and should be cleared
   */
//  public TaskListPlace(boolean taskListStale) {
//    this.taskListStale = taskListStale;
//  }
  public AdminMileagePlace(boolean MileageListStale) {
	    this.MileageListStale = MileageListStale;
	  }

  /**
   * Check if the task list is stale and should be cleared.
   * 
   * @return true if stale, false if not
   */
//  public boolean isTaskListStale() {
//    return taskListStale;
//  }
  public boolean isMileageListStale() {
	    return MileageListStale;
	  }

  public String getAdminMileageName() {
      return this.adminMileageName;
    }
}

//package com.google.gwt.sample.mobilewebapp.presenter.tasklist;
//
//import com.google.gwt.place.shared.Place;
//import com.google.gwt.place.shared.PlaceTokenizer;
//import com.google.gwt.place.shared.Prefix;
//
///**
// * The place in the app that shows a list of tasks.
// */
//public class TaskListPlace extends Place {
//
//  /**
//   * The tokenizer for this place. TaskList doesn't have any state, so we don't
//   * have anything to encode.
//   */
//  @Prefix("tl")
//  public static class Tokenizer implements PlaceTokenizer<TaskListPlace> {
//
//    public TaskListPlace getPlace(String token) {
//      return new TaskListPlace(true);
//    }
//
//    public String getToken(TaskListPlace place) {
//      return "";
//    }
//  }
//
//  private final boolean taskListStale;
//
//  /**
//   * Construct a new {@link TaskListPlace}.
//   * 
//   * @param taskListStale true if the task list is stale and should be cleared
//   */
//  public TaskListPlace(boolean taskListStale) {
//    this.taskListStale = taskListStale;
//  }
//
//  /**
//   * Check if the task list is stale and should be cleared.
//   * 
//   * @return true if stale, false if not
//   */
//  public boolean isTaskListStale() {
//    return taskListStale;
//  }
