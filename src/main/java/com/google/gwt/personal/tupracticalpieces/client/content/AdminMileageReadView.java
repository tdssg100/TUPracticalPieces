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

import java.math.BigDecimal;

import com.google.gwt.core.client.GWT;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.editor.client.SimpleBeanEditorDriver;
//import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPieces;
//import com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox;
//import com.google.gwt.sample.mobilewebapp.presenter.task.TaskReadView;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy; 
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageReadView;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.Widget;
//import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
/**
 * View used to see the details of a task.
 */
//public class DesktopTaskReadView extends Composite implements TaskReadView {
//public class ConcreteMileageReadView extends Composite implements MileageReadView {
//public class ConcreteMileageReadView extends ContentWidget implements MileageReadView {
public class AdminMileageReadView extends Composite implements MileageReadView {
//   /**
//   * The constants used in this Content Widget.
//   */
//  @TUPracticalPiecesSource
//  public static interface CwConstants extends Constants {
//    String CwAdminMileageReadViewDescription();
//    
//    String CwAdminMileageReadViewName();
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
//  public AdminMileageReadView(CwConstants constants) {
//	/* 201305 remove style and source code tabs. */
//    super(constants.CwAdminMileageReadViewName(), constants.CwAdminMileageReadViewDescription(), true);
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
//		   GWT.runAsync(AdminMileageReadView.class, new RunAsyncCallback() {
//	         public void onFailure(Throwable caught) {
//		       callback.onFailure(caught);
//		     }
//	         public void onSuccess() {
//		       callback.onSuccess(onInitialize());
//		     }
//		   });
//	  }
//	  
//
	

	
//   /**
//   * The constants used in this Content Widget.
//   */
//  //@TUPracticalPiecesSource
//  public static interface CwConstants extends Constants {
//	  String cwUpdateDescription();
//	  String cwUpdateName();
//  }
//  //@TUPracticalPiecesData
//  private final CwConstants constants;
//  public ConcreteMileageReadView(CwConstants constants) {
//	/* 201305 remove style and source code tabs. */
//	super(constants.cwUpdateName(), constants.cwUpdateDescription(), false);
//    this.constants = constants;
//  }	  
//  @Override
//  public Widget onInitialize() {
//	  return dockLayoutPanel;
//  }
//  @Override
//  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
//	   GWT.runAsync(ConcreteMileageReadView.class, new RunAsyncCallback() {
//         public void onFailure(Throwable caught) {
//	       callback.onFailure(caught);
//	     }
//         public void onSuccess() {
//	       callback.onSuccess(onInitialize());
//	     }
//	   });
//  }  

	
	/**
   * The UiBinder interface.
   */
//  interface DesktopTaskReadViewUiBinder extends UiBinder<Widget, DesktopTaskReadView> {
  interface AdminMileageReadViewUiBinder extends UiBinder<Widget, AdminMileageReadView> {
  }

//  interface EditorDriver extends SimpleBeanEditorDriver<TaskProxy, DesktopTaskReadView> {
  interface EditorDriver extends SimpleBeanEditorDriver<MileageProxy, AdminMileageReadView> {
  }

  /**
   * The UiBinder used to generate the view.
   */
//  private static DesktopTaskReadViewUiBinder uiBinder = GWT
//  .create(DesktopTaskReadViewUiBinder.class);
  private static AdminMileageReadViewUiBinder uiBinder = GWT
      .create(AdminMileageReadViewUiBinder.class);

  @UiField
//  @Editor.Ignore
  DockLayoutPanel dockLayoutPanel;

  /**
   * The panel that contains the edit form.
   */
  @UiField
//  @Editor.Ignore
  HTMLPanel editForm;

//  @UiField
//  DateLabel dueDateEditor;
//  @UiField
//  Label nameEditor;
//  @UiField
//  Label notesEditor;
  @UiField
//  @Editor.Path("MileageProxy.supplyDate")
  Label supplyDateEditor;
  /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  */
  @UiField
//  @Path("MileageProxy.quantity")
//  DoubleBox quantityEditor;
  ValueBoxBase<BigDecimal> quantityEditor;
  
  @UiField
//  @Path("MileageProxy.unitPrice")
  ValueBoxBase<Integer> unitPriceEditor;
  
  @UiField
//  @Path("MileageProxy.totalPrice")
  ValueBoxBase<Integer> totalPriceEditor;
  
  @UiField
//  @Path("MileageProxy.bsMileage")
//  DoubleBox bsMileageEditor;
  ValueBoxBase<BigDecimal> bsMileageEditor;
  
  @UiField
//  @Path("MileageProxy.totalMileage")
  ValueBoxBase<BigDecimal> totalMileageEditor;
  
  
  @UiField
  @Editor.Ignore
  Button editButton;

  private final EditorDriver editorDriver = GWT.create(EditorDriver.class);

  /**
   * The {@link TaskReadView.Presenter} for this view.
   */
  private Presenter presenter;

  /**
   * Construct a new {@link DesktopTaskReadView}.
   */
//  public DesktopTaskReadView() {
  public AdminMileageReadView() {
    initWidget(uiBinder.createAndBindUi(this));
    editorDriver.initialize(this);
    // Create a new task or modify the current task when done is pressed.
    editButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (presenter != null) {
          presenter.editMileage();
        }
      }
    });
  }
  /**
   * Construct a new {@link DesktopTaskReadView}.
   */
//  public DesktopTaskReadView() {
//  public AdminMileageReadView() {
  /**
   * Initialize this example.
   */
//  //@TUPracticalPiecesSource
//  @Override
//  public Widget onInitialize() {
//////	    super(constants.cwUpdateName(), constants.cwUpdateDescription(), false);
////	//new ConcreteMileageReadView((CwConstants)TUPracticalPieces.constants);
////	super(((CwConstants)TUPracticalPieces.constants).cwUpdateName(), ((CwConstants)TUPracticalPieces.constants).cwUpdateDescription(), false);
////    constants = (CwConstants)TUPracticalPieces.constants;
////		editorDriver.initialize(this);
//	lPanel.getWidgetIndex(uiBinder.createAndBindUi(this));
//	editorDriver.initialize(this);
//    // Create a new task or modify the current task when done is pressed.
//    editButton.addClickHandler(new ClickHandler() {
//      public void onClick(ClickEvent event) {
//        if (presenter != null) {
////          presenter.editTask();
//            presenter.editMileage();
//        }
//      }
//    });
//    return lPanel;
//  }

//  public SimpleBeanEditorDriver<TaskProxy, ?> getEditorDriver() {
  public SimpleBeanEditorDriver<MileageProxy, ?> getReadEditorDriver() {
    return editorDriver;
  }

  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }
}
