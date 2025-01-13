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
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
//import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileagePlace;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;

/**
 * The place in the app that shows and edits details of a task.
 */
public class MileageReadPlace extends Place {
    private String mileageReadName;

//  private final TaskProxy task;
//  private final Long taskId;
  private final MileageProxy mileage;
  private final Long mileageId;

    public MileageReadPlace(String token) {
        this.mileageReadName = token;
    	this.mileageId = Long.parseLong(token);
    	this.mileage = null;
    	
    }
    
    public String getHelloName() {
        return mileageReadName;
    }

  /**
   * The tokenizer for this place.
   */
//  public static class Tokenizer implements PlaceTokenizer<TaskPlace> {
  @Prefix("adminEdit")
  public static class Tokenizer implements PlaceTokenizer<MileageReadPlace> {

//    private static final String NO_ID = "create";
    private static final String NO_ID = "adminCreate";

//    public TaskPlace getPlace(String token) {
    public MileageReadPlace getPlace(String token) {
      try {
        // Parse the task ID from the URL.
//        Long taskId = Long.parseLong(token);
        Long mileageId = Long.parseLong(token);
//        return new TaskPlace(taskId, null);
        return new MileageReadPlace(mileageId, null);
      } catch (NumberFormatException e) {
        // If the ID cannot be parsed, assume we are creating a task.
//        return TaskPlace.getTaskCreatePlace();
        return MileageReadPlace.getMileageCreatePlace();
      }
    }

//    public String getToken(TaskPlace place) {
    public String getToken(MileageReadPlace place) {
//      Long taskId = place.getTaskId();
//      return (taskId == null) ? NO_ID : taskId.toString();
      Long mileageId = place.getMileageId();
      return ((mileageId == null) ? NO_ID : mileageId.toString());
    }
  }

  /**
   * The singleton instance of this place used for creation.
   */
//  private static TaskPlace singleton;
  private static MileageReadPlace singleton;

  /**
   * Create an instance of {@link TaskPlace} associated with the specified task
   * ID.
   * 
   * @param taskId the ID of the task to edit
   * @param task the task to edit, or null if not available
   * @return the place
   */
//  public static TaskPlace createTaskEditPlace(Long taskId, TaskProxy task) {
  public static MileageReadPlace createMileageEditPlace(Long mileageId, MileageProxy mileage) {
//    return new TaskPlace(taskId, task);
	    return new MileageReadPlace(mileageId, mileage);
  }

  /**
   * Get the singleton instance of the {@link TaskPlace} used to create a new
   * task.
   * 
   * @return the place
   */
//  public static TaskPlace getTaskCreatePlace() {
  public static MileageReadPlace getMileageCreatePlace() {
    if (singleton == null) {
//      singleton = new TaskPlace(null, null);
        singleton = new MileageReadPlace(null, null);
    }
    return singleton;
  }

  /**
   * Construct a new {@link TaskPlace} for the specified task id.
   * 
   * @param taskId the ID of the task to edit
   * @param task the task to edit, or null if not available
   */
//  private TaskPlace(Long taskId, TaskProxy task) {
  // @@@@@@@@@@@@@@@@@@@ need MileageProxy ?
  public MileageReadPlace(Long mileageId, MileageProxy mileage) {
//    this.taskId = taskId;
//    this.task = task;
	this.mileageId = mileageId;
	this.mileage = mileage;
  }

  /**
   * Get the task to edit.
   * 
   * @return the task to edit, or null if not available
   */
//  public TaskProxy getTask() {
  public MileageProxy getMileage() {
//    return task;
    return mileage;
  }

  /**
   * Get the ID of the task to edit.
   * 
   * @return the ID of the task, or null if creating a new task
   */
//  public Long getTaskId() {
  public Long getMileageId() {
//    return taskId;
    return mileageId;
  }
}
