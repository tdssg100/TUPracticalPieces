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
//package com.google.gwt.sample.mobilewebapp.client.mobile;
package com.google.gwt.personal.tupracticalpieces.client.content;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.http.client.URL;
//import com.google.gwt.sample.mobilewebapp.presenter.tasklist.TaskListView;
//import com.google.gwt.sample.mobilewebapp.shared.TaskProxy;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.common.LoginState;
import com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch;
import com.google.gwt.personal.tupracticalpieces.client.content.CwUpdate.CwConstants;
import com.google.gwt.personal.tupracticalpieces.database.Mileage;
import com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileageSuperView;


/**
 * View used to display the list of Tasks.
 * View user to display the list of Mileas.
 */
//public class MobileTaskListView extends Composite implements TaskListView {
public class AdminMileageView extends CwUpdate implements AdminMileageSuperView {
//  /**
//   * Resources used by the mobile CellList.
//   */
//  interface CellListResources extends CellList.Resources {
//    @Source({CellList.Style.DEFAULT_CSS, "MileageCellList.gss"})
//    CellListStyle cellListStyle();
//  }

  /**
   * Styles used by the mobile CellList.
   * Styles used by the desktop CellList.
   * 
   */
	
  private boolean selectCheck = false;	
//  private boolean loginOk = false;
  
  interface CellListStyle extends CellList.Style {
  }
  // XXX use default celllist style.
//
//  /**
//   * The UiBinder interface.
//   */
//  //interface MobileAppTaskListViewUiBinder extends UiBinder<Widget, MobileAppTaskListView> {
//  interface AdminMileageViewUiBinder extends UiBinder<Widget, AdminMileageView> {
//  }
//
//  /**
//   * The UiBinder used to generate the view.
//   */
//  //private static MobileAppTaskListViewUiBinder uiBinder = GWT.create(MobileAppTaskListViewUiBinder.class);
//  private static AdminMileageViewUiBinder uiBinder = GWT.create(AdminMileageViewUiBinder.class);
//
//  /**
//   * Displays the list of tasks.
//   */
////  @UiField(provided = true)
////  CellList<TaskProxy> taskList;
//  @UiField
//  SimpleLayoutPanel adminMileageView;
  /**
   * A custom {@link Cell} used to render a {@link Contact}.
   * A custom {@link Cell} used to render a {@link Mileage}.
   */
  private static class MileageCell extends AbstractCell<MileageProxy> {
    @Override
    public void render(Context context, MileageProxy value, SafeHtmlBuilder sb) {
      if (value != null) {
        sb.appendHtmlConstant("<div style=\"height:32px;overflow:auto;\"><table>");
        sb.appendHtmlConstant("<tr><td>");
        sb.appendEscaped(value.getSupplyDate());
        sb.appendHtmlConstant("</td><td>");
        sb.appendEscaped(String.valueOf(value.getQuantity()).substring(0, 5));
        sb.appendHtmlConstant("</td><td>");
        sb.appendEscaped(String.valueOf(value.getUnitPrice()));
        sb.appendHtmlConstant("</td><td>");
        sb.appendEscaped(String.valueOf(value.getTotalPrice()));        
        sb.appendHtmlConstant("</td><td>");
        sb.appendEscaped(String.valueOf(value.getBsMileage()).substring(0, 5));
        sb.appendHtmlConstant("</td><td>");
        sb.appendEscaped(String.valueOf(value.getTotalMileage()).substring(0, 6));
        sb.appendHtmlConstant("</td></tr></table></div>");
      }
    }
  }


//    /*
//     * Define a key provider for a Contact. We use the unique ID as the key,
//     * which allows to maintain selection even if the name changes.
//     */
//    ProvidesKey<Contact> keyProvider = new ProvidesKey<Contact>() {
//      public Object getKey(Contact item) {
//        // Always do a null check.
//        return (item == null) ? null : item.id;
//      }
//    }; 
  /**
   * The presenter for this view.
   */
  private Presenter presenter;

  private ScrollPanel sp;
  

  /**
   * Construct a new {@link MobileTaskListView}.
   */
  public AdminMileageView(CwConstants constants) {
	    super(constants);
//	    initWidget(uiBinder.createAndBindUi(this));
	    
//	    super.onLoad();
//
//	    // Initialize the widget.
//	    this.view.initWidget(uiBinder.createAndBindUi(this));

	    // Create the CellList.
//	    CellListResources cellListRes = GWT.create(CellListResources.class);
//	    taskList = new CellList<TaskProxy>(new TaskProxyCell(), cellListRes);
//	    taskList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.DISABLED);
		mileageList = new CellList<MileageProxy>(new MileageCell());
	    final NoSelectionModel<MileageProxy> selectionModel = new NoSelectionModel<MileageProxy>();
	    mileageList.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

		        @Override
		        public void onSelectionChange(SelectionChangeEvent event) {
		        	MileageProxy selected = selectionModel.getLastSelectedObject();
		            if (selected != null) {
		            	 presenter.selectMileage(selected);

		            }

		        }
		 });
//	    /*
//	     * Inform the presenter when the user selects a task from the task list.
//	     */
//	    final NoSelectionModel<TaskProxy> selectionModel = new NoSelectionModel<TaskProxy>();
//	    taskList.setSelectionModel(selectionModel);
//	    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//	      @Override
//	      public void onSelectionChange(SelectionChangeEvent event) {
//	        // Edit the task.
//	        if (presenter != null) {
//	          presenter.selectTask(selectionModel.getLastSelectedObject());
//	        }
//	      }
//	    });
	    /*
	     * Inform the presenter when the user selects a task from the task list.
	     */
  }
  
  @Override
  public Widget onInitialize() {
        vPanel.setSpacing(10);
	    //apiFrame.setHeight("15em");
	    //apiFrame.setWidth("24em");
	    vPanel.add(new HTML("<a href='https://appengine.google.com/'>dashboard</a>"));
	    //vPanel.add(new HTML("<a href='https://code.google.com/apis/console/'>Google API console</a>"));
	    vPanel.add(new HTML("<a href='https://console.developers.google.com/'>Google API console</a>"));
//	    HorizontalPanel buttonPanel = new HorizontalPanel();

	  	/* Show button */
	    executeButton.addClickHandler(new ClickHandler() {
	    	public void onClick(ClickEvent event) {
	    	    gridPanel.setVisible(true);
			    contentDiv.setHTML("<p>execute button clicked</p>");
			    //milegeTable = new MileageWidget(15);
//			    milegeTable.refresh();
			    /*
			    disenableButton();
	    		AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
	  		      public void onFailure(Throwable caught) {
	  		    	String wedgeStr = "<ol style='list-style-type: disc'>";
	  		    	wedgeStr += "<li>" + "RPC failure." + "</li>";
	  		    	wedgeStr += "</ol>";
	  		    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
			    	enableButton();
	  		      }
	  		      public void onSuccess(ResultFetch result) {
	                if (result.getResult()) {   
	  		    	  contentDiv.setHTML(contentDiv.getHTML() + result.getText());
	  			      //apiFrame.setUrl("adminmethod?dp=" + URL.encode(url));
	  		    	  Window.Location.assign(url);
	                } else {
	    		      contentDiv.setHTML(contentDiv.getHTML() + result.getText());
	                }
			    	enableButton();
	              }
	  		    };
	  		   adminTaskSvc.saveJobName("LoadFromCloud", callback);
	  		   */
	    }});

		  insertCloudButton.addClickHandler(new ClickHandler() {
				@Override
			    public void onClick(ClickEvent event) {
//				 Window.alert("InsertIntoGoogleCloudSQL clicked.");
			      if (presenter != null) {
			        presenter.addMileage(null);
			      }
					
				}
			    });    
			    


	    
	    buttonPanel.add(executeButton);
	    buttonPanel.add(deleteButton);
	    buttonPanel.add(insertCloudButton);
		disenableButton();
	    vPanel.add(buttonPanel);
	    //vPanel.add(apiFrame);

		//mileageList.setHTML("<table><tr><td>writing maileage list...</td></tr></table>");
		//setMileages();
//	    mileageList.setHeight("100%");
	    sp = new ScrollPanel(mileageList);
	    sp.setHeight("500px");
	    sp.setWidth("500px");
		vPanel.add(sp);
//	    mileageList.setHeight("500px");
//	    vPanel.add(mileageList);;
	    
		contentDiv = new HTML("<p>Log:</p>");
	    vPanel.add(contentDiv);
//	    HTML contentTemp = new HTML("<table><tr><td>writing test list...</td></tr></table>");
//		vPanel.add(contentTemp);
	    contPanel.add(vPanel);
		//return contPanel;
		//adminMileageView.add(contPanel);
//		adminMileageView.add(super.onInitialize());
//	    //initWidget(uiBinder.createAndBindUi(this));
//	    setWidget(uiBinder.createAndBindUi(this));
//  
//    // Create the CellList.
//    CellListResources cellListRes = GWT.create(CellListResources.class);
//    taskList = new CellList<TaskProxy>(new TaskProxyCell(), cellListRes);
//    taskList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.DISABLED);
//
    /*
     * Inform the presenter when the user selects a task from the task list. We
     * use a NoSelectionModel because we don't want the task to remain selected,
     * we just want to be notified of the selection event.
     */
/* edit, add dialog box, or list with editor
 * -> embeded to MainMenuTreeViewModel as ContentWidget. 		
 */
//    final NoSelectionModel<TaskProxy> selectionModel = new NoSelectionModel<TaskProxy>();
//    taskList.setSelectionModel(selectionModel);
//    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//      public void onSelectionChange(SelectionChangeEvent event) {
//        // Edit the task.
//        if (presenter != null) {
//          presenter.selectTask(selectionModel.getLastSelectedObject());
//        }
//      }
//    });
//    return adminMileageView;
    return contPanel;
  }
  /*
   * login 
   * @see com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileageSuperView#checkLoginAdmin()
   */
  public void checkLoginAdmin() {
	Window.alert("From Edit. Enter checkLoginAdmin. path=" + Window.Location.getHref());

	LoginState ls = LoginState.getInstance();
	ls.loginQury(Arrays.asList(executeButton, deleteButton, insertCloudButton), Arrays.asList(contentDiv),Window.Location.getHref());
  }
//
  public void clearList() {
//    taskList.setVisibleRangeAndClearData(taskList.getVisibleRange(), true);
	  mileageList.setVisibleRangeAndClearData(mileageList.getVisibleRange(), true);
  }

  public void setPresenter(Presenter presenter) {
    if (this.presenter != null) {
      this.presenter.stop();
    }
    this.presenter = presenter;
  }
//  public void setSelectionModel(SelectionModel<TaskProxy> selectionModel) {
//    taskList.setSelectionModel(selectionModel);
//  }
//
//  @Override
//  public void setTasks(List<TaskProxy> tasks) {
//    taskList.setRowData(tasks);
//  }
  public void setSelectionModel(SelectionModel<MileageProxy> selectionModel) {
    mileageList.setSelectionModel(selectionModel);
  }

  @Override
  public void setMileages(List<MileageProxy> mileages) {
//      contentDiv.setHTML(contentDiv.getHTML() + "<br/><br/>!!@!!entered AdminMileageView. Count=" +  mileages.size() + ".<br/>");
//	  Window.alert("<br/><br/>!!@!!entered AdminMileageView. Count=" +  mileages.size() + ".<br/>");
	  mileageList.setRowData(mileages);
  }

  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
	  GWT.runAsync(AdminMileageView.class, new RunAsyncCallback() {
		  public void onFailure(Throwable caught) {
			  callback.onFailure(caught);
		  }
		  public void onSuccess() {
			  callback.onSuccess(onInitialize());
		  }
	  });
  }


  public void enableButton() {
	  executeButton.setEnabled(true);
	  deleteButton.setEnabled(true);
	  insertCloudButton.setEnabled(true);
  }

  /*
   * disenable the button
   *
   */
  public void disenableButton() {
	  deleteButton.setEnabled(false);
	  executeButton.setEnabled(false);
	  insertCloudButton.setEnabled(false);	  
  }


  
}
