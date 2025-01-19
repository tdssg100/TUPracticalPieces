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

//import com.google.gwt.sample.mobilewebapp.server.domain.Task;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

import java.math.BigDecimal;
import java.util.List;
import com.google.gwt.personal.tupracticalpieces.database.Mileage;

//import java.util.Date;

//import java.sql.Date;

/**
 * A task used in the task list.
 */
//@ProxyFor(Task.class)
@ProxyFor(Mileage.class)
public interface MileageProxy extends EntityProxy {

//  Date getDueDate();
//
//  Long getId();
//
//  String getName();
//
//  String getNotes();
//
//  void setDueDate(Date dueDate);
//
//  void setName(String name);
//
//  void setNotes(String notes);
//}
    Long getId();
	
	String getSupplyDate();

	BigDecimal getQuantity();

	int getUnitPrice();

	int getTotalPrice();

	BigDecimal getBsMileage();
	
	BigDecimal getTotalMileage();

//	Date getId();

//	String getId();

    void setSupplyDate(String supplyDate);

    void setQuantity(BigDecimal quantity);

    void setUnitPrice(int unitPrice);

    void setTotalPrice(int totalPrice);

    void setBsMileage(BigDecimal bsMileage);

    void setTotalMileage(BigDecimal totalMileage);
    
//    List<Mileage> getList();

}
