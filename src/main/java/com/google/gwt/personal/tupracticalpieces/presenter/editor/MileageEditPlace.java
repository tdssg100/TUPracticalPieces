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
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
import com.google.gwt.user.client.Window;

/**
 * The place in the app that shows and edits details of a task.
 */
public class MileageEditPlace extends Place {

//  private static final String NO_ID = "create";
    static final String NO_ID = "mileedit";
    
	private String mileageEditName;

    public MileageEditPlace(Long mileageId, String  token) {
		this.mileageId = mileageId;
    //this.mileage = mileage;
    this.mileageEditName = token;
    }

/*     public String getHelloName() {
        return mileageEditName;
    }
 */

  /**
   * The tokenizer for this place.
   */
//  public static class Tokenizer implements PlaceTokenizer<TaskPlace> {
  //@Prefix("adminEdit")
  @Prefix("mileedit")
  public static class Tokenizer implements PlaceTokenizer<MileageEditPlace> {


//    public TaskPlace getPlace(String token) {
    public MileageEditPlace getPlace(String token) {
      //return new MileageEditPlace(this.mileageId, this.mileage);
      try {
        // Parse the task ID from the URL.
//        Long taskId = Long.parseLong(token);
// Window.alert("tokennizer toString start");
        Long mileageId = Long.parseLong(token);
//        return new TaskPlace(taskId, null);
// Window.alert("tokennizer toString end");
        return new MileageEditPlace(mileageId, token);
      } catch (NumberFormatException e) {
        // If the ID cannot be parsed, assume we are creating a task.
//        return TaskPlace.getTaskCreatePlace();
        return MileageEditPlace.getMileageCreatePlace();
      }
    }
 
//    public String getToken(TaskPlace place) {
    public String getToken(MileageEditPlace place) {
//      Long taskId = place.getTaskId();
//      return (taskId == null) ? NO_ID : taskId.toString();
      Long mileageId = place.getMileageId();
      return ((mileageId == null) ? NO_ID : NO_ID + mileageId.toString());
    }
  }

  /**
   * The singleton instance of this place used for creation.
   */
//  private static TaskPlace singleton;
  private static MileageEditPlace singleton;

  /**
   * Create an instance of {@link TaskPlace} associated with the specified task
   * ID.
   * 
   * @param taskId the ID of the task to edit
   * @param task the task to edit, or null if not available
   * @return the place
   */
//  public static TaskPlace createTaskEditPlace(Long taskId, TaskProxy task) {
  public static MileageEditPlace createMileageEditPlace(Long mileageId) {
//    return new TaskPlace(taskId, task);
// Window.alert("createMileageEditPlace entered.");
      return new MileageEditPlace(mileageId, NO_ID + mileageId.toString());
  }

  /**
   * Get the singleton instance of the {@link TaskPlace} used to create a new
   * task.
   * 
   * @return the place
   */
//  public static TaskPlace getTaskCreatePlace() {
  public static MileageEditPlace getMileageCreatePlace() {
    // Window.alert("getMileageCreatePlace entered.");
    if (singleton == null) {
//      singleton = new TaskPlace(null, null);
        singleton = new MileageEditPlace(null, NO_ID);
        Window.alert("MileageEditPlace constructor entered.");
      }
    return singleton;
  }

//  private final TaskProxy task;
//  private final Long taskId;
//  private final MileageProxy mileage;
  private final Long mileageId;

  /**
   * Construct a new {@link TaskPlace} for the specified task id.
   * 
   * @param taskId the ID of the task to edit
   * @param task the task to edit, or null if not available
   */
//  private TaskPlace(Long taskId, TaskProxy task) {
  // @@@@@@@@@@@@@@@@@@@ need MileageProxy ?
  public MileageEditPlace(Long mileageId) {
//    this.taskId = taskId;
//    this.task = task;
  	this.mileageId = mileageId;
	  this.mileageEditName = NO_ID + mileageId.toString();
  }

  /**
   * Get the task to edit.
   * 
   * @return the task to edit, or null if not available
   */
//  public TaskProxy getTask() {
/*   public MileageProxy getMileage() {
//    return task;
    return mileage;
  }
 */
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
