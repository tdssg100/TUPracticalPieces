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
public class MileageProxyImpl implements MileageProxy {
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
	  private String supplyDate;
	  @NotNull
	  private BigDecimal quantity;
	  @NotNull
	  private int unitPrice;
	  @NotNull
	  private int totalPrice;
	  @NotNull
	  private BigDecimal bsMileage;
	  @NotNull
	  private BigDecimal totalMileage;

	  public MileageProxyImpl() {
		  /* empty */
	  }
	  
//	  public MileageProxyImpl(String supplyDate, float quantity, int unitPrice, int totalPrice, float bsMileage, float totalMileage) {
//	  public MileageProxyImpl(float quantity, int unitPrice, int totalPrice, float bsMileage, float totalMileage) {
	  public MileageProxyImpl(String supplyDate, BigDecimal quantity, int unitPrice, 
			  int totalPrice, BigDecimal bsMileage, BigDecimal totalMileage) {
	      this.supplyDate = supplyDate;
	      this.quantity = quantity;
	      this.unitPrice = unitPrice;
	      this.totalPrice = totalPrice;
	      this.bsMileage = bsMileage;
	      this.totalMileage = totalMileage;
	  }
	  
	  
//	  public Date getSupplyDate() {
	  public String getSupplyDate() {
		  return this.supplyDate;
	  }
	  
//	  public float getQuantity() {
	  public BigDecimal getQuantity() {
		  return this.quantity;
	  }
	  
	  public int getUnitPrice() {
		  return this.unitPrice;
	  }
	  
	  public int getTotalPrice() {
		  return this.totalPrice;
	  }
	  
//	  public float getBsMileage() {
	  public BigDecimal getBsMileage() {
		  return this.bsMileage;
	  }
	  
//	  public float getTotalMileage() {
	  public BigDecimal getTotalMileage() {
		  return this.totalMileage;
	  }

	  public void setSupplyDate(String supplyDate) {
		  this.supplyDate = supplyDate;
	  }
	  
//	  public void setQuantity(float quantity) {
	  public void setQuantity(BigDecimal quantity) {
		  this.quantity = quantity;
	  }
	  
	  public void setUnitPrice(int unitPrice) {
		  this.unitPrice = unitPrice;
	  }
	  
	  public void setTotalPrice(int totalPrice) {
		  this.totalPrice = totalPrice;
	  }
	  
//	  public void setBsMileage(float bsMileage) {
	  public void setBsMileage(BigDecimal bsMileage) {
		  this.bsMileage = bsMileage;
	  }
	  
//	  public void setTotalMileage(float totalMileage) {
	  public void setTotalMileage(BigDecimal totalMileage) {
		  this.totalMileage = totalMileage;
	  }
	  
//	  public Date getId() {
//	    return this.supplyDate;
//	  }
	  public Long getId() {
		    return this.id;
	  }
//	  public String getId() {
//		  return this.supplyDate;
//	  }



	@Override
	public EntityProxyId<?> stableId() {
		// TODO Auto-generated method stub
		return null;
	}

}
