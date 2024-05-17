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
//package com.google.gwt.sample.mobilewebapp.client;
package com.google.gwt.personal.tupracticalpieces.client;

//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxyImpl;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxyImpl;
import com.google.gwt.storage.client.Storage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

/**
 * Manages the storage and retrieval of local tasks.
 */
//public class TaskProxyLocalStorage {
public class MileageProxyLocalStorage {

//	private static final String TASKLIST_SAVE_KEY = "TASKLIST";
  private static final String MILEAGELIST_SAVE_KEY = "MILEAGELIST";
//  private static final String TASKSEP = "&&";
  private static final String MILEAGESEP = "&&";
  private static final String FIELDSEP = "@@";
  private static final String FIELDEMPTY = "***";

  /**
   * Convert a task proxy list into a string.
   */
//  private static String getStringFromTaskProxy(List<TaskProxy> list) {
  private static String getStringFromMileageProxy(List<MileageProxy> list) {
    StringBuilder sb = new StringBuilder();
//    for (TaskProxy proxy : list) {
    for (MileageProxy proxy : list) {
//      sb.append(proxy.getDueDate() != null ? proxy.getDueDate().getTime() : FIELDEMPTY);
//        sb.append(FIELDSEP);
//        sb.append(proxy.getId() != null ? proxy.getId() : "");
//        sb.append(FIELDSEP);
//        String name = proxy.getName();
//        sb.append(name != null && name.length() > 0 ? proxy.getName() : FIELDEMPTY);
//        sb.append(FIELDSEP);
//        String notes = proxy.getNotes();
//        sb.append(notes != null && notes.length() > 0 ? proxy.getNotes() : FIELDEMPTY);
//        sb.append(TASKSEP);
//<!-- Mileage . SupplyDate	Quantity	UnitPrice	TotalPrice	BsMileage	TotalMileage -->    	
//      sb.append(String
//				.format("'%s'" + FIELDSEP + "%.2f" + FIELDSEP + "%d" + 
//						FIELDSEP + "%d" + FIELDSEP + "%.1f" + FIELDSEP + "%.1f" + MILEAGESEP,
//						proxy.getSupplyDate(), proxy.getQuantity(),
//						proxy.getUnitPrice(), proxy.getTotalPrice(),
//						proxy.getBsMileage(), proxy.getTotalMileage()));
//      sb.append(proxy.getSupplyDate() + FIELDSEP + Float.toString(Float.parseFloat(proxy.getQuantity())) 
        sb.append(proxy.getSupplyDate() + FIELDSEP + proxy.getQuantity().toString() 
    	+ FIELDSEP + Integer.toString(proxy.getUnitPrice()) 
    	+ FIELDSEP + Integer.toString(proxy.getTotalPrice()) 
    	+ FIELDSEP + proxy.getBsMileage().toString()
    	+ FIELDSEP + proxy.getTotalMileage().toString() + MILEAGESEP);
    }
    return sb.toString();
  }

  /**
   * Parse a task proxy list from a string.
   */
//  private static List<TaskProxy> getTaskProxyFromString(String taskProxyList) {
	private static List<MileageProxy> getMileageProxyFromString(String mileageProxyList) {
		// ArrayList<TaskProxy> list = new ArrayList<TaskProxy>(0);
		// if (taskProxyList == null) {
		ArrayList<MileageProxy> list = new ArrayList<MileageProxy>(0);
		if (mileageProxyList == null) {
			return list;
		}
		// taskproxy1&&taskproxy2&&taskproxy3&&...
		// String taskProxyStrings[] = taskProxyList.split(TASKSEP);
		// for (String taskProxyString : taskProxyStrings) {
		// if (taskProxyString == null) {
		String mileageProxyStrings[] = mileageProxyList.split(MILEAGESEP);
		for (String mileageProxyString : mileageProxyStrings) {
			if (mileageProxyString == null) {
				continue;
			}
			// date@@id@@name@@notes
			// String taskProxyStringData[] = taskProxyString.split(FIELDSEP);
			// if (taskProxyStringData.length >= 4) {
			// // collect the fields
			// String dateString = taskProxyStringData[0];
			// String idString = taskProxyStringData[1];
			// String nameString = taskProxyStringData[2];
			// if (FIELDEMPTY.equals(nameString)) {
			// nameString = null;
			// }
			// String notesString = taskProxyStringData[3];
			// if (FIELDEMPTY.equals(notesString)) {
			// notesString = null;
			// }
			// // parse the numerical fields
			// Date dueDate = null;
			// try {
			// dueDate = new Date(Long.parseLong(dateString));
			// } catch (NumberFormatException nfe) {
			// }
			// Long idLong = 0L;
			// try {
			// idLong = Long.parseLong(idString);
			// } catch (NumberFormatException nfe) {
			// }
			// // create and populate the TaskProxy
			// TaskProxyImpl taskProxy = new TaskProxyImpl();
			// taskProxy.setDueDate(dueDate);
			// taskProxy.setId(idLong);
			// taskProxy.setName(nameString);
			// taskProxy.setNotes(notesString);
			// list.add(taskProxy);
			// }

			String mileageProxyStringData[] = mileageProxyString.split(FIELDSEP);
			if (mileageProxyStringData.length >= 6) {
				// collect the fields
				String supplyDate = mileageProxyStringData[0];

				String quantityString = mileageProxyStringData[1];
				BigDecimal quantity = null;
				try {
					quantity = new BigDecimal(quantityString);
				} catch (NumberFormatException nfe) {
				}

				String unitPriceString = mileageProxyStringData[2];
				int unitPrice = 0;
				try {
					unitPrice = Integer.parseInt(unitPriceString);
				} catch (NumberFormatException nfe) {
				}

				String totalPriceString = mileageProxyStringData[3];
				int totalPrice = 0;
				try {
					totalPrice = Integer.parseInt(totalPriceString);
				} catch (NumberFormatException nfe) {
				}

				String bsMileageString = mileageProxyStringData[4];
				BigDecimal bsMileage = null;
				try {
					bsMileage = new BigDecimal(bsMileageString);
				} catch (NumberFormatException nfe) {
				}

				String totalMileagetring = mileageProxyStringData[5];
				BigDecimal totalMileage = null;
				try {
					totalMileage = new BigDecimal(totalMileagetring);
				} catch (NumberFormatException nfe) { // TODO @@@@@@@@@@@@@@
				}
				// create and populate the mileageProxy
				MileageProxyImpl mileageProxy = new MileageProxyImpl();
				mileageProxy.setSupplyDate(supplyDate);
				mileageProxy.setQuantity(quantity);
				mileageProxy.setUnitPrice(unitPrice);
				mileageProxy.setTotalPrice(totalPrice);
				mileageProxy.setBsMileage(bsMileage);
				mileageProxy.setTotalMileage(totalMileage);
				list.add(mileageProxy);
			}
		}
		return list;
	}

  private final Storage storage;
//  private List<TaskProxy> tasks;
//  private Map<Long, TaskProxy> taskMap;
  private List<MileageProxy> mileages;
  private Map<Long, MileageProxy> mileageMap;

//  public TaskProxyLocalStorage(Storage storage) {
  public MileageProxyLocalStorage(Storage storage) {
    this.storage = storage;
  }

  /**
   * Get a task by its ID.
   * 
   * @param id the task id
   * @return the task, or null if it isn't in local storage
   */
//  public TaskProxy getTask(Long id) {
//    // Create the map of tasks.
//    if (taskMap == null) {
//      taskMap = new HashMap<Long, TaskProxy>();
//      for (TaskProxy task : getTasks()) {
//        taskMap.put(task.getId(), task);
//      }
//    }
//
//    return taskMap.get(id);
//  }
  public MileageProxy getMileage(Long id) {
	    // Create the map of tasks.
	    if (mileageMap == null) {
	      mileageMap = new HashMap<Long, MileageProxy>();
	      for (MileageProxy mileage : getMileages()) {
	        mileageMap.put(mileage.getId(), mileage);
	      }
	    }

	    return mileageMap.get(id);
	  }

  /**
   * Get a list of all tasks in local storage.
   */
//  public List<TaskProxy> getTasks() {
//    if (tasks == null) {
//      // Load the saved task list from storage
//      if (storage != null) { // if storage is supported
//        String taskString = storage.getItem(TASKLIST_SAVE_KEY);
//        tasks = getTaskProxyFromString(taskString);
//      } else {
//        tasks = new ArrayList<TaskProxy>();
//      }
//    }
//
//    return tasks;
//  }
  public List<MileageProxy> getMileages() {
	    if (mileages == null) {
	      // Load the saved task list from storage
	      if (storage != null) { // if storage is supported
	        String mileageString = storage.getItem(MILEAGELIST_SAVE_KEY);
	        mileages = getMileageProxyFromString(mileageString);
	      } else {
	        mileages = new ArrayList<MileageProxy>();
	      }
	    }
	    return mileages;
  }

  /**
   * Save a list of tasks to local storage.
   */
//  public void setTasks(List<TaskProxy> tasks) {
//    this.tasks = tasks;
//
//    // Save the response to storage
//    if (storage != null) { // if storage is supported
//      String responseString = getStringFromTaskProxy(tasks);
//      storage.setItem(TASKLIST_SAVE_KEY, responseString);
//    }
//  }
  public void setMileages(List<MileageProxy> mileages) {
	    this.mileages = mileages;

	    // Save the response to storage
	    if (storage != null) { // if storage is supported
	      String responseString = getStringFromMileageProxy(mileages);
	      storage.setItem(MILEAGELIST_SAVE_KEY, responseString);
	    }
	  }
}