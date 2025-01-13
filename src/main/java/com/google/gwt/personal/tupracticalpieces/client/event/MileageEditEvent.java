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
//package com.google.gwt.sample.mobilewebapp.client.event;
package com.google.gwt.personal.tupracticalpieces.client.event;

import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;

/**
 * Fired when the user wants to edit a task.
 */
//public class TaskEditEvent extends GwtEvent<TaskEditEvent.Handler> {
public class MileageEditEvent extends GwtEvent<MileageEditEvent.Handler> {
  /**
   * Implemented by objects that handle {@link TaskEditEvent}.
   */
  public interface Handler extends EventHandler {
    //void onTaskEdit(TaskEditEvent event);
    void onMileageEdit(MileageEditEvent event);
  }
  
  /**
   * The event type.
   */
  //public static final Type<TaskEditEvent.Handler> TYPE = new Type<TaskEditEvent.Handler>();
  public static final Type<MileageEditEvent.Handler> TYPE = new Type<MileageEditEvent.Handler>();

  //private final TaskProxy task;

  //public TaskEditEvent(TaskProxy task) {
  //  this.task = task;
  //}
  private final MileageProxy mileage;

  public MileageEditEvent(MileageProxy mileage) {
    this.mileage = mileage;
  }
  
  public MileageProxy getMileage() {
	  return this.mileage;
  }

  @Override
  //public final Type<TaskEditEvent.Handler> getAssociatedType() {
  public final Type<MileageEditEvent.Handler> getAssociatedType() {
    return TYPE;
  }

  //public TaskProxy getReadOnlyTask() {
  //  return task;
  //}
  public MileageProxy getReadOnlyMileage() {
    return mileage;
  }

  @Override
  //protected void dispatch(TaskEditEvent.Handler handler) {
  protected void dispatch(MileageEditEvent.Handler handler) {
    //handler.onTaskEdit(this);
    handler.onMileageEdit(this);
  }
}
