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

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
//import com.google.gwt.sample.gaerequest.client.ReloadOnAuthenticationFailure;
//import com.google.gwt.sample.mobilewebapp.client.activity.AppPlaceHistoryMapper;
//import com.google.gwt.sample.mobilewebapp.client.event.ActionEvent;
//import com.google.gwt.sample.mobilewebapp.client.event.ActionNames;
//import com.google.gwt.sample.mobilewebapp.client.event.ShowTaskEvent;
//import com.google.gwt.sample.mobilewebapp.presenter.task.TaskPlace;
//import com.google.gwt.sample.mobilewebapp.presenter.tasklist.TaskListPlace;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;

//import com.google.gwt.personal.gaerequest.client.ReloadOnAuthenticationFailure;
import com.google.gwt.personal.tupracticalpieces.client.activity.TUAppPlaceHistoryMapper;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesShell;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace;
import com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.personal.tupracticalpieces.client.event.ActionEvent;
import com.google.gwt.personal.tupracticalpieces.client.event.ActionNames;
//import com.google.gwt.personal.tupracticalpieces.client.event.ShowTaskEvent;
//import com.google.gwt.personal.tupracticalpieces.presenter.task.TaskPlace;
//import com.google.gwt.personal.tupracticalpieces.presenter.tasklist.TaskListPlace;
//import com.google.gwt.personal.tupracticalpieces.shared.TaskProxy;
import com.google.gwt.personal.tupracticalpieces.client.event.ShowMileageEvent;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.UmbrellaException;

//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 * The heart of the applicaiton, mainly concerned with bootstrapping.
 */
public class App {
	private static final String HISTORY_SAVE_KEY = "SAVEPLACE";

	// private static final Logger log = Logger.getLogger(App.class.getName());

	private final Storage storage;

	/**
	 * Where components of the app converse by posting and monitoring events.
	 */
	private final EventBus eventBus;

	/**
	 * Owns the current {@link Place} in the app. A Place is the embodiment of
	 * any bookmarkable state.
	 */
	private final PlaceController placeController;

	/**
	 * The top of our UI.
	 */
	// private final MobileWebAppShell shell;
	private final TUPracticalPiecesShell shell;

	private final ActivityManager activityManager;

	private final TUAppPlaceHistoryMapper historyMapper;

	private final PlaceHistoryHandler historyHandler;
	//
	// private final ReloadOnAuthenticationFailure
	// reloadOnAuthenticationFailure;

	// public App(Storage storage, EventBus eventBus, PlaceController
	// placeController,
	// ActivityManager activityManager, AppPlaceHistoryMapper historyMapper,
	// PlaceHistoryHandler historyHandler,
	// //ReloadOnAuthenticationFailure reloadOnAuthenticationFailure,
	// MobileWebAppShell shell) {
	// ReloadOnAuthenticationFailure reloadOnAuthenticationFailure,
	// TUPracticalPiecesShell shell) {
	public App(Storage storage, EventBus eventBus, PlaceController placeController, ActivityManager activityManager,
			TUAppPlaceHistoryMapper historyMapper, PlaceHistoryHandler historyHandler, TUPracticalPiecesShell shell) {

//		this.storage = storage;
		this.storage = null;
		this.eventBus = eventBus;
		this.placeController = placeController;
		this.activityManager = activityManager;
		this.historyMapper = historyMapper;
		this.historyHandler = historyHandler;
		// this.reloadOnAuthenticationFailure = reloadOnAuthenticationFailure;
		this.shell = shell;
	}

	/**
	 * Given a parent view to show itself in, start this App.
	 * 
	 * @param parentView
	 *            where to show the app's widget
	 */
	public void run(HasWidgets.ForIsWidget parentView) {

		activityManager.setDisplay(shell);
		//
		parentView.add(shell);

		// ActionEvent.register(eventBus, ActionNames.ADD_TASK, new
		// ActionEvent.Handler() {
		// @Override
		// public void onAction(ActionEvent event) {
		// placeController.goTo(TaskPlace.getTaskCreatePlace());
		// }
		// });
		ActionEvent.register(eventBus, ActionNames.ADD_MILEAGE, new ActionEvent.Handler() {
			@Override
			public void onAction(ActionEvent event) {
				History.newItem("adminEdit:adminCreate");
				placeController.goTo(MileageEditPlace.getMileageCreatePlace());
			}
		});

		// eventBus.addHandler(ShowTaskEvent.TYPE, new ShowTaskEvent.Handler() {
		// @Override
		// public void onShowTask(ShowTaskEvent event) {
		// TaskProxy task = event.getTask();
		// placeController.goTo(TaskPlace.createTaskEditPlace(task.getId(),
		// task));
		// }
		// });
		eventBus.addHandler(ShowMileageEvent.TYPE, new ShowMileageEvent.Handler() {
			@Override
			public void onShowMileage(ShowMileageEvent event) {
				MileageProxy mileage = event.getMileage();
				History.newItem("adminEdit:" + mileage.getId()); // TODO
//		
//Window.alert("createMileageEditPlace to go.");																			// @@@@@@@
				placeController.goTo(MileageEditPlace.createMileageEditPlace(mileage.getId(), mileage));
			}
		});
		//
		// ActionEvent.register(eventBus, ActionNames.GO_HOME, new
		// ActionEvent.Handler() {
		// @Override
		// public void onAction(ActionEvent event) {
		// placeController.goTo(new TaskListPlace(false));
		// }
		// });
		//
		// ActionEvent.register(eventBus, ActionNames.TASK_SAVED, new
		// ActionEvent.Handler() {
		// @Override
		// public void onAction(ActionEvent event) {
		// placeController.goTo(new TaskListPlace(true));
		// }
		// });
		//
		// ActionEvent.register(eventBus, ActionNames.EDITING_CANCELED, new
		// ActionEvent.Handler() {
		// @Override
		// public void onAction(ActionEvent event) {
		// placeController.goTo(new TaskListPlace(false));
		// }
		// });
		//
		ActionEvent.register(eventBus, ActionNames.GO_HOME, new ActionEvent.Handler() {
			@Override
			public void onAction(ActionEvent event) {
				History.newItem("!Preface");
				History.fireCurrentHistoryState();
				//
				// placeController.goTo(new AdminMileagePlace(false));
			}
		});

		ActionEvent.register(eventBus, ActionNames.MILEAGE_SAVED, new ActionEvent.Handler() {
			@Override
			public void onAction(ActionEvent event) {
				// History.newItem("!AdminMileageView");
				placeController.goTo(new AdminMileagePlace(true));
			}
		});

		ActionEvent.register(eventBus, ActionNames.EDITING_CANCELED, new ActionEvent.Handler() {
			@Override
			public void onAction(ActionEvent event) {
				// History.newItem("!AdminMileageView");
				placeController.goTo(new AdminMileagePlace(false));
			}
		});

		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void onUncaughtException(Throwable e) {
				String msg = "";
				while (e instanceof UmbrellaException) {
					msg += "[" + e.getClass() + "]";
					msg += e.getMessage() + "+";
					e = ((UmbrellaException) e).getCauses().iterator().next();
				}

				msg += "[" + e.getClass() + "]";
				msg += e.getMessage() + "+";
				if (msg == null) {
					msg = "[" + e.getClass() + "]";
					msg += e.toString();
				}
//				String message = e.getMessage();
//				if (message == null) {
//					message = e.toString();
//				}
				// log.log(Level.SEVERE, "Uncaught exception", e);
//				Window.alert("An unexpected error occurred: " + message);
				Window.alert("An unexpected error occurred: " + msg);
			}
		});
		//
		// // Check for authentication failures or mismatches
	    // reloadOnAuthenticationFailure.register(eventBus);
		//
		// initBrowserHistory(historyMapper, historyHandler, new
		// TaskListPlace(true));new AdminMileagePlace(true)
		// initBrowserHistory(historyMapper, historyHandler);
		initBrowserHistory(historyMapper, historyHandler, new AdminMileagePlace(true));
	}

	/**
	 * Initialize browser history / bookmarking. If LocalStorage is available,
	 * use it to make the user's default location in the app the last one seen.
	 */
	// private void initBrowserHistory(final AppPlaceHistoryMapper
	// historyMapper,
	// PlaceHistoryHandler historyHandler, TaskListPlace defaultPlace) {
	// private void initBrowserHistory(final AppPlaceHistoryMapper
	// historyMapper, PlaceHistoryHandler historyHandler,
	// AdminMileagePlace defaultPlace) {
	// private void initBrowserHistory(final AppPlaceHistoryMapper
	// historyMapper, PlaceHistoryHandler historyHandler) {
	private void initBrowserHistory(final TUAppPlaceHistoryMapper historyMapper, PlaceHistoryHandler historyHandler,
			AdminMileagePlace defaultPlace) {
		Place savedPlace = null;
		if (storage != null) {
			try {
				// wrap in try-catch in case stored value is invalid
				savedPlace = historyMapper.getPlace(storage.getItem(HISTORY_SAVE_KEY));
			} catch (Throwable t) {
				// ignore error and use the default-default
			}
		}
		if (savedPlace == null) {
			savedPlace = defaultPlace;
		}
		historyHandler.register(placeController, eventBus, savedPlace);
		/*
		 * Go to the place represented in the URL. This is what makes bookmarks
		 * work.
		 */
		// historyHandler.handleCurrentHistory();

		String prevToken = History.getToken();

		// Place listPlace = new AdminMileagePlace(true);
		// Place editPlace;

		

/*
 * 
//		if (("!AdminM".equals(prevToken.substring(0, 7))) || ("adminE".equals(prevToken.substring(0, 6)))) {
		if ("adminE".equals(prevToken.substring(0, 6))) {
					 historyHandler.register(placeController, eventBus, savedPlace);
			 * Go to the place represented in the URL. This is what makes
			 * bookmarks work.
			historyHandler.handleCurrentHistory();

			// } else if ("adminEdit".equals(prevToken.substring(1,9))) {
			// String [] tokenSplit = prevToken.split(":");
			// if (tokenSplit.length == 2) {
			// if ("create".equals(tokenSplit[1])) {
			// editPlace = new MileagePlace(null, null);
			// } else { // Id
			// editPlace = new MileagePlace(Long.valueOf(tokenSplit[1]), null);
			// }
			// } else {
			// editPlace = new MileagePlace(null, null);
			// }
			// historyHandler.register(placeController, eventBus, listPlace);
			// historyHandler.register(placeController, eventBus, editPlace);
			// historyHandler.handleCurrentHistory();
		} else { // ContentWidget
			History.fireCurrentHistoryState();
		}


		*/

		historyHandler.handleCurrentHistory();


		/*
		 * Monitor the eventbus for place changes and note them in LocalStorage
		 * for the next launch.
		 */
		if (storage != null) {
			eventBus.addHandler(PlaceChangeEvent.TYPE, new PlaceChangeEvent.Handler() {
				public void onPlaceChange(PlaceChangeEvent event) {
					// TODO extend to hold timestamp to check expireation
					// 
					// if session is fix, need to reset the timeout.
					// to make bookmark's timeout effective, cookie needs
					storage.setItem(HISTORY_SAVE_KEY, historyMapper.getToken(event.getNewPlace()));
					Place place = event.getNewPlace();
					storage.setItem(HISTORY_SAVE_KEY, (place instanceof AdminMileagePlace) ? "!AdminMileageView" : "adminEdit" + historyMapper.getToken(place));
				}
			});
		}

	}

	public TUAppPlaceHistoryMapper getHistoristoryMapper() {
		// TODO Auto-generated method stub
		return this.historyMapper;
	}
}
//public App(Storage storage, EventBus eventBus, PlaceController placeController,
//	      ActivityManager activityManager, AppPlaceHistoryMapper historyMapper,
//	      PlaceHistoryHandler historyHandler,
//	      ReloadOnAuthenticationFailure reloadOnAuthenticationFailure, MobileWebAppShell shell) {
//
//	    this.storage = storage;
//	    this.eventBus = eventBus;
//	    this.placeController = placeController;
//	    this.activityManager = activityManager;
//	    this.historyMapper = historyMapper;
//	    this.historyHandler = historyHandler;
//	    this.reloadOnAuthenticationFailure = reloadOnAuthenticationFailure;
//	    this.shell = shell;
//	  }
//
//	  /**
//	   * Given a parent view to show itself in, start this App.
//	   * 
//	   * @param parentView where to show the app's widget
//	   */
//	  public void run(HasWidgets.ForIsWidget parentView) {
//	    activityManager.setDisplay(shell);
//
//	    parentView.add(shell);
//
//	    ActionEvent.register(eventBus, ActionNames.ADD_TASK, new ActionEvent.Handler() {
//	      @Override
//	      public void onAction(ActionEvent event) {
//	        placeController.goTo(TaskPlace.getTaskCreatePlace());
//	      }
//	    });
//
//	    eventBus.addHandler(ShowTaskEvent.TYPE, new ShowTaskEvent.Handler() {
//	      @Override
//	      public void onShowTask(ShowTaskEvent event) {
//	        TaskProxy task = event.getTask();
//	        placeController.goTo(TaskPlace.createTaskEditPlace(task.getId(), task));
//	      }
//	    });
//
//	    ActionEvent.register(eventBus, ActionNames.GO_HOME, new ActionEvent.Handler() {
//	      @Override
//	      public void onAction(ActionEvent event) {
//	        placeController.goTo(new TaskListPlace(false));
//	      }
//	    });
//
//	    ActionEvent.register(eventBus, ActionNames.TASK_SAVED, new ActionEvent.Handler() {
//	      @Override
//	      public void onAction(ActionEvent event) {
//	        placeController.goTo(new TaskListPlace(true));
//	      }
//	    });
//
//	    ActionEvent.register(eventBus, ActionNames.EDITING_CANCELED, new ActionEvent.Handler() {
//	      @Override
//	      public void onAction(ActionEvent event) {
//	        placeController.goTo(new TaskListPlace(false));
//	      }
//	    });
//
//	    GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
//	      @Override
//	      public void onUncaughtException(Throwable e) {
//	        while (e instanceof UmbrellaException) {
//	          e = ((UmbrellaException) e).getCauses().iterator().next();
//	        }
//
//	        String message = e.getMessage();
//	        if (message == null) {
//	          message = e.toString();
//	        }
//	        log.log(Level.SEVERE, "Uncaught exception", e);
//	        Window.alert("An unexpected error occurred: " + message);
//	      }
//	    });
//
//	    // Check for authentication failures or mismatches
//	    reloadOnAuthenticationFailure.register(eventBus);
//
//	    initBrowserHistory(historyMapper, historyHandler, new TaskListPlace(true));
//	  }
//
//	  /**
//	   * Initialize browser history / bookmarking. If LocalStorage is available, use
//	   * it to make the user's default location in the app the last one seen.
//	   */
//	  private void initBrowserHistory(final AppPlaceHistoryMapper historyMapper,
//	      PlaceHistoryHandler historyHandler, TaskListPlace defaultPlace) {
//
//	    Place savedPlace = null;
//	    if (storage != null) {
//	      try {
//	        // wrap in try-catch in case stored value is invalid
//	        savedPlace = historyMapper.getPlace(storage.getItem(HISTORY_SAVE_KEY));
//	      } catch (Throwable t) {
//	        // ignore error and use the default-default
//	      }
//	    }
//	    if (savedPlace == null) {
//	      savedPlace = defaultPlace;
//	    }
//	    historyHandler.register(placeController, eventBus, savedPlace);
//
//	    /*
//	     * Go to the place represented in the URL. This is what makes bookmarks
//	     * work.
//	     */
//	    historyHandler.handleCurrentHistory();
//
//	    /*
//	     * Monitor the eventbus for place changes and note them in LocalStorage for
//	     * the next launch.
//	     */
//	    if (storage != null) {
//	      eventBus.addHandler(PlaceChangeEvent.TYPE, new PlaceChangeEvent.Handler() {
//	        public void onPlaceChange(PlaceChangeEvent event) {
//	          storage.setItem(HISTORY_SAVE_KEY, historyMapper.getToken(event.getNewPlace()));
//	        }
//	      });
//	    }
//	  }
//	}
