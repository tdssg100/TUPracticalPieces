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

import java.util.Set;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
/**
 * 20160123 MVP for mobile
 * 20160222 eventbus, presenter, place, activities
 * 20160511 editor
 */
//import com.google.gwt.sample.gaerequest.client.GaeAuthRequestTransport;
//import com.google.gwt.sample.gaerequest.client.ReloadOnAuthenticationFailure;
//import com.google.gwt.sample.mobilewebapp.client.activity.AppActivityMapper;
//import com.google.gwt.sample.mobilewebapp.client.activity.AppPlaceHistoryMapper;
//import com.google.gwt.sample.mobilewebapp.client.desktop.DesktopTaskEditView;
//import com.google.gwt.sample.mobilewebapp.client.desktop.DesktopTaskListView;
//import com.google.gwt.sample.mobilewebapp.client.desktop.DesktopTaskReadView;
//import com.google.gwt.sample.mobilewebapp.client.desktop.MobileWebAppShellDesktop;
//import com.google.gwt.sample.mobilewebapp.client.ui.PieChart;
//import com.google.gwt.sample.mobilewebapp.presenter.task.TaskEditView;
//import com.google.gwt.sample.mobilewebapp.presenter.task.TaskReadView;
//import com.google.gwt.sample.mobilewebapp.presenter.taskchart.TaskChartPresenter;
//import com.google.gwt.sample.mobilewebapp.presenter.tasklist.TaskListView;
//import com.google.gwt.sample.mobilewebapp.shared.MobileWebAppRequestFactory;


//import com.google.gwt.personal.gaerequest.client.GaeAuthRequestTransport;
//import com.google.gwt.personal.gaerequest.client.ReloadOnAuthenticationFailure;
import com.google.gwt.personal.tupracticalpieces.client.activity.AppActivityMapper;
import com.google.gwt.personal.tupracticalpieces.client.activity.TUAppPlaceHistoryMapper;
import com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView;
import com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageReadView;
import com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView;
//import com.google.gwt.personal.tupracticalpieces.client.desktop.DesktopTaskEditView;
//import com.google.gwt.personal.tupracticalpieces.client.desktop.DesktopTaskListView;
//import com.google.gwt.personal.tupracticalpieces.client.desktop.DesktopTaskReadView;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesShell;
import com.google.gwt.personal.tupracticalpieces.client.desktop.TUPracticalPiecesShellDesktop;
import com.google.gwt.personal.tupracticalpieces.shared.MileageRequestFactory;
//import com.google.gwt.personal.tupracticalpieces.client.ui.PieChart;
//import com.google.gwt.personal.tupracticalpieces.presenter.task.TaskEditView;
//import com.google.gwt.personal.tupracticalpieces.presenter.task.TaskReadView;
//import com.google.gwt.personal.tupracticalpieces.presenter.taskchart.TaskChartPresenter;
//import com.google.gwt.personal.tupracticalpieces.presenter.tasklist.TaskListView;


import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.RequestTransport;
import com.google.web.bindery.requestfactory.gwt.client.DefaultRequestTransport; 
import com.google.web.bindery.requestfactory.shared.ServerFailure; 

import com.google.gwt.personal.tupracticalpieces.generator.TUPracticalPiecesGenerator;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditView;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageReadView;
import com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileageSuperView;
/**
 * Default implementation of {@link ClientFactory}. Used by desktop version.
 */

//class ClientFactoryImpl implements ClientFactory {
//class ClientFactoryImpl extends TUPracticalPiecesGenerator implements ClientFactory {
class ClientFactoryImpl implements ClientFactory {

  /**
   * The URL argument used to enable or disable local storage.
   */
  private static final String STORAGE_URL_ARG = "storage";

  private final EventBus eventBus = new SimpleEventBus();
  private final PlaceController placeController = new PlaceController(eventBus);
  private final MileageRequestFactory requestFactory;
  private TUPracticalPiecesShell shell;
  private final Storage localStorage;
  //private final TaskProxyLocalStorage taskProxyLocalStorage;
  //private TaskEditView taskEditView;
  //private TaskListView taskListView;
//  TODO localStorage private final MileageProxyLocalStorage mileageProxyLocalStorage;
  private AdminMileageSuperView myAppAdminMileageView;
  private MileageEditView mileageEditView;
  private MileageReadView mileageReadView;
//  private MileageEditView myAppAdminMileageEdit;
//  private MileageReadView myAppAdminMileageRead;
//  private MileageEditView mileageEditView;
//  private MileageReadView mileageReadView;
  private ActivityManager activityManager;

  private final TUAppPlaceHistoryMapper historyMapper = GWT.create(TUAppPlaceHistoryMapper.class);

  /**
   * The stock GWT class that ties the PlaceController to browser history,
   * configured by our custom {@link #historyMapper}.
   */
  private final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);

  //private TaskReadView taskReadView;

  public ClientFactoryImpl() {
//    RequestTransport requestTransport = new GaeAuthRequestTransport(eventBus);
    RequestTransport requestTransport = new DefaultRequestTransport();
//    requestFactory = GWT.create(MobileWebAppRequestFactory.class);
    requestFactory = GWT.create(MileageRequestFactory.class);
    requestFactory.initialize(eventBus, requestTransport);

    // Initialize local storage.
    String storageUrlValue = Window.Location.getParameter(STORAGE_URL_ARG);
    if (storageUrlValue == null || storageUrlValue.startsWith("t")) {
      localStorage = Storage.getLocalStorageIfSupported();
    } else {
      localStorage = null;
    }
    //taskProxyLocalStorage = new TaskProxyLocalStorage(localStorage);
// TODO localStorage   mileageProxyLocalStorage = new MileageProxyLocalStorage(localStorage);
  }
  
//  public App getApp() {
//    return new App(getLocalStorageIfSupported(), eventBus, getPlaceController(),
//        getActivityManager(), historyMapper, historyHandler, new ReloadOnAuthenticationFailure(),
//        getShell());
  public App getApp() {
//	  return new App(getShell());
//	  shell = getShell();
	  
//	  return new App(getLocalStorageIfSupported(), eventBus, getPlaceController(), getActivityManager(),
//			  historyMapper, historyHandler, getShell());
	  return new App(getLocalStorageIfSupported(), eventBus, getPlaceController(), getActivityManager(),
			  historyMapper, historyHandler, getShell());
	  }
  @Override
  public EventBus getEventBus() {
    return eventBus;
  }
  
  public PlaceController getPlaceController() {
    return placeController;
  }

//  public MobileWebAppRequestFactory getRequestFactory() {
  public MileageRequestFactory getRequestFactory() {
    return requestFactory;
  }

  public TUPracticalPiecesShell getShell() {
    if (shell == null) {
      shell = createShell();
    }
    return shell;
  }

//  public TaskEditView getTaskEditView() {
//    if (taskEditView == null) {
//      taskEditView = createTaskEditView();
//    }
//    return taskEditView;
//  }
  public MileageEditView getMileageEditView() {
//    return myAppAdminMileageEdit;
	if (mileageEditView == null) {
		mileageEditView = createMileageEditView();
	}
	return mileageEditView;
  }
  public MileageReadView getMileageReadView() {
//    return myAppAdminMileageRead;
		if (mileageReadView == null) {
			mileageReadView = createMileageReadView();
		}
		return mileageReadView;
  }
//
//  public TaskListView getTaskListView() {
//  }
public AdminMileageSuperView getMyAppAdminMileageView() {
//  if (myAppAdminMileageView == null) {
//  	Timer timerView = new Timer () {
//	      @Override
//	      public void run() {
//	    	  myAppAdminMileageView = createMyAppAdminMileageView();
//	      }
//	};
//	timerView.schedule(100);
//  }
  return myAppAdminMileageView;
}
//
//  public TaskProxyLocalStorage getTaskProxyLocalStorage() {
//    return taskProxyLocalStorage;
//  }
//
//  public TaskReadView getTaskReadView() {
//    if (taskReadView == null) {
//      taskReadView = createTaskReadView();
//    }
//    return taskReadView;
//  }
//
//  TODO localStorage public MileageProxyLocalStorage getMileageProxyLocalStorage() {
//	  
//	return mileageProxyLocalStorage;
//  }
  /**
   * ActivityMapper determines an Activity to run for a particular place,
   * configures the {@link #getActivityManager()}
   */
  protected ActivityMapper createActivityMapper() {
    return new AppActivityMapper(this);
  }

  /**
   * Create the application UI shell.
   * 
   * @return the UI shell
   */
  //protected MobileWebAppShellDesktop createShell() {
  protected TUPracticalPiecesShellDesktop createShell() {
//    PieChart pieChart = PieChart.createIfSupported();
//    TaskChartPresenter presenter = null;
//    if (pieChart != null) {
//      presenter = new TaskChartPresenter(pieChart);
//      presenter.start(getEventBus());
//    }
//    return new MobileWebAppShellDesktop(eventBus, presenter, placeController, getTaskListView(),
//        getTaskEditView(), getTaskReadView());
//
//    // Inject global styles.
//    injectThemeStyleSheet();
//    images.css().ensureInjected();

////    // Initialize the constants.
////    TUPracticalPiecesConstants constants = GWT.create(TUPracticalPiecesConstants.class);
////
////    // Create the application shell.
////    final SingleSelectionModel<ContentWidget> selectionModel = new SingleSelectionModel<ContentWidget>();
////    final MainMenuTreeViewModel treeModel = new MainMenuTreeViewModel(
////        constants, selectionModel);
////    Set<ContentWidget> contentWidgets = treeModel.getAllContentWidgets();
////    //shell = new TUPracticalPiecesShell(eventBus, presenter, placeController, treeModel);
////    //RootLayoutPanel.get().add(shell);
//    return new TUPracticalPiecesShellDesktop(eventBus, placeController, treeModel);
      //return new TUPracticalPiecesShellDesktop(eventBus, placeController);
//	  TUPracticalPiecesShellDesktop tmp = new TUPracticalPiecesShellDesktop(eventBus, placeController);
	  TUPracticalPiecesShellDesktop tmp = new TUPracticalPiecesShellDesktop(getPlaceController(), getMileageReadView(), getMileageEditView());
	  myAppAdminMileageView = tmp.getAdminMileageView();
//	  myAppAdminMileageEdit = tmp.getAdminMileageEditView();
//	  myAppAdminMileageRead = tmp.getAdminMileageReadView();
	  return tmp;
  
  }

  
/**
* Create a {@link MileageEditView}.
* 
* @return a new {@link MileageEditView}
*/
protected MileageEditView createMileageEditView() {
 return new AdminMileageEditView();
}

/**
* Create a {@link MileageListView}.
* 
* @return a new {@link MileageListView}
*/
protected MileageReadView createMileageReadView() {
 return new AdminMileageReadView();
}
  
  
  
  
  
//  /**
//   * Create a {@link TaskEditView}.
//   * 
//   * @return a new {@link TaskEditView}
//   */
//  protected TaskEditView createTaskEditView() {
//    return new DesktopTaskEditView();
//  }
//
//  /**
//   * Create a {@link TaskListView}.
//   * 
//   * @return a new {@link TaskListView}
//   */
//  protected TaskListView createTaskListView() {
//    return new DesktopTaskListView();
//  }
//protected AdminMileageSuperView createMyAppAdminMileageView() {
//  // createMyAppAdminView from MainTree	
////return new DesktopTaskListView();
//  //return AdminMileageView;
////	try {
////	    Thread.sleep(1000);                 //1000 milliseconds is one second.
////	} catch(InterruptedException ex) {
////	    Thread.currentThread().interrupt();
////	}
//	
//	if (myAppAdminMileageView == null) {
//	    return getMyAppAdminMileageView();
//	}
//	return myAppAdminMileageView;
//}

//
//  protected TaskReadView createTaskReadView() {
//    return new DesktopTaskReadView();
//  }
//
//  /**
//   * Owns a panel in the window, in this case the entire {@link #shell}.
//   * Monitors the {@link #eventBus} for
//   * {@link com.google.gwt.place.shared.PlaceChangeEvent PlaceChangeEvent}s posted by the
//   * {@link #placeController}, and chooses what
//   * {@link com.google.gwt.activity.shared.Activity Activity} gets to take
//   * over the panel at the current place. Configured by the
//   * {@link #createActivityMapper()}.
//   */
  protected ActivityManager getActivityManager() {
    if (activityManager == null) {
      activityManager = new ActivityManager(createActivityMapper(), eventBus);
    }
    return activityManager;
  }

  private Storage getLocalStorageIfSupported() {
    return localStorage;
  }

}


//class ClientFactoryImpl implements ClientFactory {
///**
// * The URL argument used to enable or disable local storage.
// */
//private static final String STORAGE_URL_ARG = "storage";
//
//private final EventBus eventBus = new SimpleEventBus();
//private final PlaceController placeController = new PlaceController(eventBus);
//private final MobileWebAppRequestFactory requestFactory;
//private MobileWebAppShell shell;
//private final Storage localStorage;
//private final TaskProxyLocalStorage taskProxyLocalStorage;
//private TaskEditView taskEditView;
//private TaskListView taskListView;
//private ActivityManager activityManager;
//
//private final AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
//
///**
// * The stock GWT class that ties the PlaceController to browser history,
// * configured by our custom {@link #historyMapper}.
// */
//private final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
//
//private TaskReadView taskReadView;
//
//public ClientFactoryImpl() {
//  RequestTransport requestTransport = new GaeAuthRequestTransport(eventBus);
//  requestFactory = GWT.create(MobileWebAppRequestFactory.class);
//  requestFactory.initialize(eventBus, requestTransport);
//
//  // Initialize local storage.
//  String storageUrlValue = Window.Location.getParameter(STORAGE_URL_ARG);
//  if (storageUrlValue == null || storageUrlValue.startsWith("t")) {
//    localStorage = Storage.getLocalStorageIfSupported();
//  } else {
//    localStorage = null;
//  }
//  taskProxyLocalStorage = new TaskProxyLocalStorage(localStorage);
//}
//
//public App getApp() {
//  return new App(getLocalStorageIfSupported(), eventBus, getPlaceController(),
//      getActivityManager(), historyMapper, historyHandler, new ReloadOnAuthenticationFailure(),
//      getShell());
//}
//
//@Override
//public EventBus getEventBus() {
//  return eventBus;
//}
//
//public PlaceController getPlaceController() {
//  return placeController;
//}
//
//public MobileWebAppRequestFactory getRequestFactory() {
//  return requestFactory;
//}
//
//public MobileWebAppShell getShell() {
//  if (shell == null) {
//    shell = createShell();
//  }
//  return shell;
//}
//
//public TaskEditView getTaskEditView() {
//  if (taskEditView == null) {
//    taskEditView = createTaskEditView();
//  }
//  return taskEditView;
//}
//
//public TaskListView getTaskListView() {
//  if (taskListView == null) {
//    taskListView = createTaskListView();
//  }
//  return taskListView;
//}
//
//public TaskProxyLocalStorage getTaskProxyLocalStorage() {
//  return taskProxyLocalStorage;
//}
//
//public TaskReadView getTaskReadView() {
//  if (taskReadView == null) {
//    taskReadView = createTaskReadView();
//  }
//  return taskReadView;
//}
//
///**
// * ActivityMapper determines an Activity to run for a particular place,
// * configures the {@link #getActivityManager()}
// */
//protected ActivityMapper createActivityMapper() {
//  return new AppActivityMapper(this);
//}
//
///**
// * Create the application UI shell.
// * 
// * @return the UI shell
// */
////protected MobileWebAppShellDesktop createShell() {
//protected TUPracticalPiecesShellDesktop createShell() {
////  PieChart pieChart = PieChart.createIfSupported();
////  TaskChartPresenter presenter = null;
////  if (pieChart != null) {
////    presenter = new TaskChartPresenter(pieChart);
////    presenter.start(getEventBus());
////  }
////  return new MobileWebAppShellDesktop(eventBus, presenter, placeController, getTaskListView(),
////      getTaskEditView(), getTaskReadView());
////
////  // Inject global styles.
////  injectThemeStyleSheet();
////  images.css().ensureInjected();
//
//  // Initialize the constants.
//  TUPracticalPiecesConstants constants = GWT.create(TUPracticalPiecesConstants.class);
//
//  // Create the application shell.
//  final SingleSelectionModel<ContentWidget> selectionModel = new SingleSelectionModel<ContentWidget>();
//  final MainMenuTreeViewModel treeModel = new MainMenuTreeViewModel(
//      constants, selectionModel);
//  Set<ContentWidget> contentWidgets = treeModel.getAllContentWidgets();
//  //shell = new TUPracticalPiecesShell(eventBus, presenter, placeController, treeModel);
//  //RootLayoutPanel.get().add(shell);
//  return new TUPracticalPiecesShellDesktop(eventBus, placeController, treeModel);
//
//
//
//}
//
///**
// * Create a {@link TaskEditView}.
// * 
// * @return a new {@link TaskEditView}
// */
//protected TaskEditView createTaskEditView() {
//  return new DesktopTaskEditView();
//}
//
///**
// * Create a {@link TaskListView}.
// * 
// * @return a new {@link TaskListView}
// */
//protected TaskListView createTaskListView() {
//  return new DesktopTaskListView();
//}
//
//protected TaskReadView createTaskReadView() {
//  return new DesktopTaskReadView();
//}
//
///**
// * Owns a panel in the window, in this case the entire {@link #shell}.
// * Monitors the {@link #eventBus} for
// * {@link com.google.gwt.place.shared.PlaceChangeEvent PlaceChangeEvent}s posted by the
// * {@link #placeController}, and chooses what
// * {@link com.google.gwt.activity.shared.Activity Activity} gets to take
// * over the panel at the current place. Configured by the
// * {@link #createActivityMapper()}.
// */
//protected ActivityManager getActivityManager() {
//  if (activityManager == null) {
//    activityManager = new ActivityManager(createActivityMapper(), eventBus);
//  }
//  return activityManager;
//}
//
//private Storage getLocalStorageIfSupported() {
//  return localStorage;
//}
