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
//package com.google.gwt.sample.mobilewebapp.shared;
package com.google.gwt.personal.tupracticalpieces.shared;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.google.web.bindery.requestfactory.shared.EntityProxyId;

//import java.util.Date;

//import java.sql.Date;

/**
 * A task used in the task list.
 */
public class UserProxyImpl implements UserProxy {
//  private Date dueDate;
//  private Long id;
//  private String name;
//  private String notes;
//
//  public TaskProxyImpl() {
//  }
//
//  public TaskProxyImpl(String name, String notes) {
//    this.name = name;
//    this.notes = notes;
//  }
//
//  public Date getDueDate() {
//    return dueDate;
//  }
//
//  public Long getId() {
//    return id;
//  }
//
//  public String getName() {
//    return name;
//  }
//
//  public String getNotes() {
//    return notes;
//  }
//
//  public void setDueDate(Date dueDate) {
//    this.dueDate = dueDate;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }
//
//  public void setNotes(String notes) {
//    this.notes = notes;
//  }
//
//  public EntityProxyId<?> stableId() {
//    return null;
//  }

	  @Id 
	  @NotNull
	  private Long id;
	  @NotNull
	  private String name;
	  @NotNull
	  private String password;
	  @NotNull
	  private String comment;

	  public UserProxyImpl() {
		  /* empty */
	  }
	  
//	  public MileageProxyImpl(String supplyDate, float quantity, int unitPrice, int totalPrice, float bsMileage, float totalMileage) {
//	  public MileageProxyImpl(float quantity, int unitPrice, int totalPrice, float bsMileage, float totalMileage) {
	  public UserProxyImpl(String name, String password, String comment) { 
	      this.name = name;
	      this.password = password;
	      this.comment = comment;
	  }
	  
	  public Long getId() {
		  return this.id;
	  }
	  
//	  public Date getSupplyDate() {
	  public String getName() {
		  return this.name;
	  }
	  
//	  public float getQuantity() {
	  public String getPassword() {
		  return this.password;
	  }
	  
	  public String getComment() {
		  return this.comment;
	  }
	  
	  public void setName(String name) {
		  this.name = name;
	  }
	  
	  public void setPassword(String password) {
		  this.password = password;
	  }
	  
	  public void setComment(String comment) {
		  this.comment = comment;
	  }

	@Override
	public EntityProxyId<?> stableId() {
		// TODO Auto-generated method stub
		return null;
	}

}
