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

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;

import java.util.List;

/**
 * Event fired when the task list is updated.
 */
//public class TaskListUpdateEvent extends GwtEvent<TaskListUpdateEvent.Handler> {
public class MileageListUpdateEvent extends GwtEvent<MileageListUpdateEvent.Handler> {
  /**
   * Handler for {@link TaskListUpdateEvent}.
   */
  public interface Handler extends EventHandler {
  
    /**
     * Called when the task list is updated.
     */
    //void onTaskListUpdated(TaskListUpdateEvent event);
    void onTaskListUpdated(MileageListUpdateEvent event);
  }

//  public static final Type<TaskListUpdateEvent.Handler> TYPE = new Type<TaskListUpdateEvent.Handler>();
  public static final Type<MileageListUpdateEvent.Handler> TYPE = new Type<MileageListUpdateEvent.Handler>();

//  private final List<TaskProxy> tasks;
  private final List<MileageProxy> tasks;

//  public TaskListUpdateEvent(List<TaskProxy> tasks) {
  public MileageListUpdateEvent(List<MileageProxy> tasks) {
    this.tasks = tasks;
  }

  @Override
//  public Type<TaskListUpdateEvent.Handler> getAssociatedType() {
  public Type<MileageListUpdateEvent.Handler> getAssociatedType() {
    return TYPE;
  }

//  public List<TaskProxy> getTasks() {
  public List<MileageProxy> getTasks() {
    return tasks;
  }

  @Override
//  protected void dispatch(TaskListUpdateEvent.Handler handler) {
  protected void dispatch(MileageListUpdateEvent.Handler handler) {
    handler.onTaskListUpdated(this);
  }
}