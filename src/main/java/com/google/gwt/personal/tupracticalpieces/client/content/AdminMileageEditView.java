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
//package com.google.gwt.sample.mobilewebapp.client.desktop;
package com.google.gwt.personal.tupracticalpieces.client.content;

import java.util.Arrays;
import java.util.List;
import java.math.BigDecimal;

import com.google.gwt.http.client.URL;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Constants;
//import com.google.gwt.core.client.RunAsyncCallback;
//import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.google.gwt.i18n.client.Constants;
//import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
//import com.google.gwt.personal.tupracticalpieces.client.content.auth.CwUpdate.CwConstants;
//import com.google.gwt.sample.mobilewebapp.client.ui.DateButton;
//import com.google.gwt.sample.mobilewebapp.client.ui.EditorDecorator;
//import com.google.gwt.sample.mobilewebapp.presenter.task.TaskEditView;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxyImpl;
import com.google.gwt.personal.tupracticalpieces.client.ui.DateButton;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditView;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminTask;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminTaskAsync;
import com.google.gwt.personal.tupracticalpieces.client.common.LoginState;
import com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch;

/**
 * View used to edit a task.
 */
/*
CwAdminMileageEditViewDescription = Administrator can edit mileage data of database by using this page.
CwAdminMileageEditViewName = Administrator's editor of mileage data. 
CwAdminMileageReadViewDescription = Administrator can read mileage data of database by using this page.
CwAdminMileageReadViewName = Administrator's reader of mileage data. 
subCategoryAdminMileage = Mileage Admin
 * 
 */
//public class DesktopTaskEditView extends Composite implements TaskEditView {
//public class ConcreteMileageEditView extends Composite implements MileageEditView {
//public class ConcreteMileageEditView extends ContentWidget implements MileageEditView {
//public class AdminMileageEditView extends Composite implements MileageEditView {
public class AdminMileageEditView extends ResizeComposite implements MileageEditView {

	  
	  /**
	   * OAuth 2 access url.
	   */
	  //@TUPracticalPiecesData
	  public String url = null;
	 	
	  
	  /**
	   * RPC.
	   * 
	   */
	  //@TUPracticalPiecesData
	  public final AdminTaskAsync adminTaskSvc = GWT.create(AdminTask.class);
	  
	  
	//   /**
//   * The constants used in this Content Widget.
//   */
//  @TUPracticalPiecesSource
//  public static interface CwConstants extends Constants {
//    String CwAdminMileageEditViewDescription();
//       
//    String CwAdminMileageEditViewName();
//  }
//  
//  /**
//   * main panel.
//   */
//  private LayoutPanel lPanel = new LayoutPanel();
//  
//  /**
//   * An instance of the constants.
//   */
//  @TUPracticalPiecesData
//  private final CwConstants constants;
//  
//  /**
//   * Constructor.
//   *
//   * @param constants the constants
//   */
//  public AdminMileageEditView(CwConstants constants) {
//	/* 201305 remove style and source code tabs. */
//    super(constants.CwAdminMileageEditViewName(), constants.CwAdminMileageEditViewDescription(), true);
//    this.constants = constants;
//  }
//  
////	  /**
////	   * Initialize this example.
////	   */
////	  //@TUPracticalPiecesSource
////	  @Override
////	  public Widget onInitialize() {
////		// todo @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
////		return this;
////	  }
//	//  
//	  @Override
//	  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
//		   GWT.runAsync(AdminMileageEditView.class, new RunAsyncCallback() {
//	         public void onFailure(Throwable caught) {
//		       callback.onFailure(caught);
//		     }
//	         public void onSuccess() {
//		       callback.onSuccess(onInitialize());
//		     }
//		   });
//	  }
	  

	
  /**
   * The UiBinder interface.
   */
//  interface DesktopTaskEditViewUiBinder extends UiBinder<Widget, DesktopTaskEditView> {
  interface AdminMileageEditViewUiBinder extends UiBinder<Widget, AdminMileageEditView> {
  }

//  /**
//   * The cell used to render task templates.
//   */
////  static class TaskTemplateCell extends AbstractCell<TaskProxy> {
//	  static class MileageTemplateCell extends AbstractCell<MileageProxy> {
//
//    /**
//     * Use a UiBinder template to generate the {@code Cell} contents and process
//     * events.
//     */
////    @UiTemplate("TaskTemplateCell.ui.xml")
//	@UiTemplate("MileageTemplateCell.ui.xml")
//    interface Renderer extends UiRenderer {
//      void render(SafeHtmlBuilder sb, String name, String notes);
////      void onBrowserEvent(TaskTemplateCell o, NativeEvent n, Element e, Context context);
//      void onBrowserEvent(MileageTemplateCell o, NativeEvent n, Element e, Context context);
//    }
//
//    private Renderer renderer = GWT.create(Renderer.class);
//
////    public TaskTemplateCell() {
//    public MileageTemplateCell() {
//      // Register the kinds of event this cell will manage.
//      super("dragstart");
//    }
//
//    /**
//     * Delegates event handling to the generated {@link UiRenderer}.
//     */
//    @Override
////    public void onBrowserEvent(Context context, Element parent, TaskProxy value, NativeEvent event,
////        ValueUpdater<TaskProxy> valueUpdater) {
//    public void onBrowserEvent(Context context, Element parent, MileageProxy value, NativeEvent event,
//            ValueUpdater<MileageProxy> valueUpdater) {
//      renderer.onBrowserEvent(this, event, parent, context);
//    }
//
//    /**
//     * Delegates the cell rendering to the generated {@link UiRenderer}.
//     */
//    @Override
////    public void render(Context context, TaskProxy value, SafeHtmlBuilder sb) {
//    public void render(Context context, MileageProxy value, SafeHtmlBuilder sb) {
//      if (value == null) {
//        return;
//      }
//
//      String notes = value.getNotes();
//      renderer.render(sb, value.getName(), (notes == null) ? "" : notes);
//    }
//
//    /**
//     * Handles "drag-start" events inside the element named "root".
//    */
//    @UiHandler({"root"})
//    void onDragStart(DragStartEvent event, Element parent, Context context) {
//      // Save the ID of the TaskProxy.
//      DataTransfer dataTransfer = event.getDataTransfer();
//      dataTransfer.setData("text", String.valueOf(context.getIndex()));
//
//      // Set the image.
//      dataTransfer.setDragImage(parent, 25, 15);
//    }
//  }

//  interface Driver extends RequestFactoryEditorDriver<TaskProxy, DesktopTaskEditView> {
//  interface RFEDriver extends RequestFactoryEditorDriver<MileageProxy, ConcreteMileageEditView> {
  interface Driver extends RequestFactoryEditorDriver<MileageProxy, AdminMileageEditView> {
  }

  /**
   * The UiBinder used to generate the view.
   */
//  private static DesktopTaskEditViewUiBinder uiBinder = GWT
//      .create(DesktopTaskEditViewUiBinder.class);
  private static AdminMileageEditViewUiBinder uiBinder = GWT.create(AdminMileageEditViewUiBinder.class);

  /**
   * The glass panel used to lock the UI.
   */
  private static PopupPanel glassPanel;

  /**
   * Show or hide the glass panel used to lock the UI will the task loads.
   * 
   * @param visible true to show, false to hide
   */
  private static void setGlassPanelVisible(boolean visible) {
    // Initialize the panel.
    if (glassPanel == null) {
      glassPanel = new DecoratedPopupPanel(false, true);
      glassPanel.setWidget(new Label("Loading..."));
    }

    if (visible) {
      // Show the loading panel.
      glassPanel.center();
    } else {
      // Hide the loading panel.
      glassPanel.hide();
    }
  }
//
  @UiField
//  @Editor.Ignore
  DockLayoutPanel dockLayoutPanel;
//  PopupPanel popupPanel;
  /**
   * The panel that contains the edit form.
   */
  @UiField
//  @Editor.Ignore
  HTMLPanel editForm;

  @UiField
  @Path("supplyDate")
//  DateButton dueDateEditor;
  DateButton supplyDateEditor;
//  final EditorDecorator<String> nameEditor;
//  @UiField
//  @Ignore
//  TextBoxBase nameField;
//  @UiField
//  Element nameViolation;
  
  /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
   * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
   */
  @UiField
  @Path("quantity")
//  DecimalBox quantityEditor;
  ValueBoxBase<BigDecimal> quantityEditor;
  @UiField
  @Path("unitPrice")
  ValueBoxBase<Integer> unitPriceEditor;
  @UiField
  @Path("totalPrice")
  ValueBoxBase<Integer> totalPriceEditor;
  @UiField
  @Path("bsMileage")
//  DecimalBox bsMileageEditor;
  ValueBoxBase<BigDecimal> bsMileageEditor;
  @UiField
  @Path("totalMileage")
  ValueBoxBase<BigDecimal> totalMileageEditor;
  @UiField
//  @Editor.Ignore
  Button saveButton; // create new
  @UiField
//  @Editor.Ignore
  Button deleteButton;
  @UiField
  @Editor.Ignore
  HTML contentDiv;
//  @UiField(provided = true)
////  final CellList<TaskProxy> templateList;
//  final CellList<MileageProxy> templateList;
//
//  @UiField
//  Widget templateListContainer;

//  private final Driver driver = GWT.create(RFEDriver.class);
  private final Driver driver = GWT.create(Driver.class);

  /**
   * The {@link TaskEditView.Presenter} for this view.
   */
  private Presenter presenter;

  /**
   * Construct a new {@link DesktopTaskEditView}.
   */
//  public DesktopTaskEditView() {
  public AdminMileageEditView() {
	    //super(constants.cwXFrameName(), constants.cwXFrameDescription(), constants);
//	  	super((com.google.gwt.personal.tupracticalpieces.client.content.auth.CwUpdate.CwConstants) constants);
	    initWidget(uiBinder.createAndBindUi(this));
	    driver.initialize(this);


	    // Create a new task or modify the current task when done is pressed.
	    saveButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        if (presenter != null) {
	          presenter.saveMileage();
	        }
	      }
	    });
	    saveButton.setEnabled(false);

	    // Delete the current task or cancel when delete is pressed.
	    deleteButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        if (presenter != null) {
	          presenter.deleteMileage();
	        }
	      }
	    });
	    deleteButton.setEnabled(false);
	        
	  }
  
//  /**
//   * Initialize this example.
//   */
//  //@TUPracticalPiecesSource
//  @Override
//  public Widget onInitialize() {
//	  
//    // Create the template list.
////    templateList = createTaskTemplateList();
////    templateList = createMileageTemplateList();
//
//////    initWidget(uiBinder.createAndBindUi(this));
//////    super(constants.cwUpdateName(), constants.cwUpdateDescription(), false);
////	super(((CwConstants)TUPracticalPieces.constants).cwUpdateName(), ((CwConstants)TUPracticalPieces.constants).cwUpdateDescription(), false);
////    constants = (CwConstants)TUPracticalPieces.constants;
////    nameEditor = EditorDecorator.create(nameField.asEditor(), nameViolation);
////    initWidget(uiBinder.createAndBindUi(this));
//	lPanel.getWidgetIndex(uiBinder.createAndBindUi(this));
//    driver.initialize(this);
//
////    // Hide the template list if it isn't supported.
////    if (!DragDropEventBase.isSupported()) {
////      dockLayoutPanel.setWidgetSize(templateListContainer, 0);
////    }
//
//    // Create a new task or modify the current task when done is pressed.
//    saveButton.addClickHandler(new ClickHandler() {
//      public void onClick(ClickEvent event) {
//        if (presenter != null) {
////          presenter.saveTask();
//            presenter.saveMileage();
//        }
//      }
//    });
//
//    // Delete the current task or cancel when delete is pressed.
//    deleteButton.addClickHandler(new ClickHandler() {
//      public void onClick(ClickEvent event) {
//        if (presenter != null) {
////          presenter.deleteTask();
//            presenter.deleteMileage();
//        }
//      }
//    });
//    return lPanel;
//  }

  
  
//    // Add the form as a drop target.
//    editForm.addDomHandler(new DragOverHandler() {
//      public void onDragOver(DragOverEvent event) {
//        // Highlight the name and notes box.
//        nameField.getElement().getStyle().setBackgroundColor("#ffa");
//        notesEditor.getElement().getStyle().setBackgroundColor("#ffa");
//      }
//    }, DragOverEvent.getType());
//    editForm.addDomHandler(new DragLeaveHandler() {
//      public void onDragLeave(DragLeaveEvent event) {
//        EventTarget eventTarget = event.getNativeEvent().getEventTarget();
//        if (!Element.is(eventTarget)) {
//          return;
//        }
//        Element target = Element.as(eventTarget);
//
//        if (target == editForm.getElement()) {
//          // Un-highlight the name and notes box.
//          nameField.getElement().getStyle().clearBackgroundColor();
//          notesEditor.getElement().getStyle().clearBackgroundColor();
//        }
//      }
//    }, DragLeaveEvent.getType());
//    editForm.addDomHandler(new DropHandler() {
//      public void onDrop(DropEvent event) {
//        // Prevent the default text drop.
//        event.preventDefault();
//
//        // Un-highlight the name and notes box.
//        nameField.getElement().getStyle().clearBackgroundColor();
//        notesEditor.getElement().getStyle().clearBackgroundColor();
//
//        // Fill in the form.
//        try {
//          // Get the template the from the data transfer object.
//          DataTransfer dataTransfer = event.getNativeEvent().getDataTransfer();
//          int templateIndex = Integer.parseInt(dataTransfer.getData("text"));
////          TaskProxy template = templateList.getVisibleItem(templateIndex);
//          MileageProxy template = templateList.getVisibleItem(templateIndex);
//          nameField.setValue(template.getName());
//          notesEditor.setValue(template.getNotes());
//        } catch (NumberFormatException e) {
//          // The user probably dragged something other than a template.
//        }
//      }
//    }, DropEvent.getType());
//  }

//  public RequestFactoryEditorDriver<TaskProxy, ?> getEditorDriver() {
  public RequestFactoryEditorDriver<MileageProxy, ?> getEditorDriver() {
    return driver;
  }

  public void setEditing(boolean isEditing) {
    if (isEditing) {
      deleteButton.setText("Delete item");
    } else {
      deleteButton.setText("Cancel");
    }
  }

  public void setLocked(boolean locked) {
    setGlassPanelVisible(locked);
  }

//  public void setNameViolation(String message) {
//    nameViolation.setInnerText(message);
//  }

  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }
  
  
	  
	  
  
//  public void show() {
//	  this.show();
//  }
//
//  public void hide() {
//	  this.hide();
//  }
//  
  
  
  
  
////  private CellList<TaskProxy> createTaskTemplateList() {
//  private CellList<MileageProxy> createMileageTemplateList() {
////    CellList<TaskProxy> list =
////        new CellList<TaskProxy>(new TaskTemplateCell());
//	    CellList<MileageProxy> list =
//	            new CellList<MileageProxy>(new MileageTemplateCell());
//    list.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.DISABLED);
//
////    // Create the templates.
////    List<TaskProxy> templates = new ArrayList<TaskProxy>();
////    templates.add(new TaskProxyImpl("Call mom", null));
////    templates.add(new TaskProxyImpl("Register to vote", "Where is my polling location again?"));
////    templates.add(new TaskProxyImpl("Replace air filter", "Size: 24x13x1"));
////    templates.add(new TaskProxyImpl("Take out the trash", null));
//    List<MileageProxy> templates = new ArrayList<MileageProxy>();
//    templates.add(new MileageProxyImpl("2016-05-11", 40.0, 110, 4400, 400.0, 68000.0));
//    
////    templates.add(new MileageProxyImpl("Register to vote", "Where is my polling location again?"));
////    templates.add(new MileageProxyImpl("Replace air filter", "Size: 24x13x1"));
////    templates.add(new MileageProxyImpl("Take out the trash", null));
//    list.setRowData(templates);
//
//    return list;
//  }
  
  
  
  
  
//@Override
//public Widget onInitialize() {
//  public void onLoad() {

public void checkLoginAdmin() {
//	Window.alert("From Edit. Enter checkLoginAdmin. path=" + Window.Location.getHref());
	  LoginState ls = LoginState.getInstance();
	  ls.loginQury(Arrays.asList(saveButton, deleteButton), Arrays.asList(contentDiv),Window.Location.getHref());

	



//	/* 20140501 add admin to scope
//  */
//  
//  disenableButton();  
//  /* retrieve the last session properties */
//  AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
//	      public void onFailure(Throwable caught) {
//	    	String wedgeStr = "<ol style='list-style-type: disc'>";
//	    	wedgeStr += "<li>" + "RPC failure." + "</li>";
//	    	wedgeStr += "</ol>";
//	    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//	      }
//	      public void onSuccess(ResultFetch result) {
//	          if (result.getResult()) {
//	        	  contentDiv.setHTML(result.getText());
//		    	  String[] tmp = result.getText().split(",");
//			      java.util.Date tmpDate = new java.util.Date(Long.parseLong(tmp[2]));
//			      contentDiv.setHTML(" go into bodyWidget" + ":" + tmp[0] + "," + tmp[1] + "," + tmpDate + "," + tmp[3] + ".");
//			      bodyWidget(tmp[0], tmp[1], tmpDate, tmp[3]);
//	          } else {
//			      contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//	          }
//	      }
//	};
//	adminTaskSvc.saveJobName("ConsentCheck", callback);
	  
	
}
  
  
  
  
  
  
  
  
//public void bodyWidget(String regiuser, String state, java.util.Date expire, String session) {
//	//Window.alert("bodyWidget entered.");
//	//long session = 0; @@@@@getSessionIdInJava();
//	/* the other user is making login process */
//	if (!session.equals(regiuser) && state.equals("LoginTRY")) {
//		contentDiv.setHTML(contentDiv.getHTML() + "Please retry after a while.");
//		return;
//	}
//	java.util.Date curTime = new java.util.Date();
//	/* login failuer 2
//	 * 1/2: in service to other user */
//	if (!session.equals(regiuser) && state.equals("LoginOK") && expire.compareTo(curTime) > 0) {
//		contentDiv.setHTML(contentDiv.getHTML() + "You are not authorized.");
//		return;
//	}
//	/* 2/2: not authorative of google accout*/
//	if (session.equals(regiuser) && !state.equals("LoginOK") ) {
//		contentDiv.setHTML(contentDiv.getHTML() + "You are not authorized in google account.");
//		return;
//	}
//	/* TimeOut occurs */
//	if (session.equals(regiuser) && state.equals("LoginOK") &&  curTime.compareTo(expire) > 0) {
//		contentDiv.setHTML("Time out occurs.");
//		/* need to reset time out */
//		AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
//			public void onFailure(Throwable caught) {
//				String wedgeStr = "<ol style='list-style-type: disc'>";
//				wedgeStr += "<li>" + "RPC failure." + "</li>";
//				wedgeStr += "</ol>";
//				contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//			}
//			public void onSuccess(ResultFetch result) {
//				if (result.getResult()) {
//					contentDiv.setHTML(result.getText());
//				} else {
//					contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//				}
//			}
//		};
//		adminTaskSvc.saveJobName("ConsentTimeOut", callback);
//		return;
//	}
//	/* can try to login 
//	 *  not 
//	 *  no need to consult google account.
//	 *  session == regiuser && state = "LoginOK" && expire > curTime || 
//	 */
//	/* login process */
//	Window.alert("From Edit. before login condition check. path=" + Window.Location.getHref());
//	if ((curTime.compareTo(expire) > 0) || (!session.equals(regiuser)) || !state.equals("LoginOK")) {
//		//if (Window.confirm("after login condition check.")) {
//		/* log on process */
//		AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
//			public void onSuccess(ResultFetch result) {
//				if (result.getResult()) {
//					Window.Location.assign(url);
//				} else {
//					contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//				}
//			}
//			public void onFailure(Throwable caught) {
//				String wedgeStr = "<ol style='list-style-type: disc'>";
//				wedgeStr += "<li>" + "RPC failure." + "</li>";
//				wedgeStr += "</ol>";
//				contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//			}
//		};
//		//	adminTaskSvc.saveJobName("ConsentLogin:" + session + "," + "LoginTRY" + ",0,CwUpdate", callback);
//		adminTaskSvc.saveJobName("ConsentLogin:" + session + "," + "LoginTRY" + ",0," + Window.Location.getHref(), callback);
//		//}
//	} else {
//		enableButton();
//	}
///* otherwise continue */
///*      (session == regiuser) && state == 'LoginOK' && expire > curTime
// * not( (session != regiuser) || state != 'LoginOK' || expire <= curTime)
// */
//
//	
//
//}
//  
//  
private void enableButton() {
	saveButton.setEnabled(true);
	deleteButton.setEnabled(true);
}


private void disenableButton() {
	saveButton.setEnabled(false);
	deleteButton.setEnabled(false);
}

@Override
public void setName(String helloName) {
	// TODO Auto-generated method stub
	
}
  
}
