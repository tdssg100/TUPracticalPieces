/*
 * Copyright 2008 Google Inc.
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
package com.google.gwt.personal.tupracticalpieces.client.content;

//import java.util.Date;
import java.util.Arrays;
import java.util.List;


//import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
//import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellList;
//import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
//import com.google.gwt.user.client.ui.DialogBox;
//import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesData;
//import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesSource;
//import com.google.gwt.personal.tupracticalpieces.client.common.AdminTask;
//import com.google.gwt.personal.tupracticalpieces.client.common.AdminTaskAsync;
//import com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch;
//import com.google.gwt.personal.tupracticalpieces.shared.UserProxy;
import com.google.gwt.personal.tupracticalpieces.client.event.MileageEditEvent;
//import com.google.gwt.view.client.ListDataProvider;
//import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileageSuperView;
import com.google.gwt.personal.tupracticalpieces.client.common.LoginState;
//import com.google.gwt.personal.tupracticalpieces.client.content.MileageWidget;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;
//import com.google.gwt.personal.tupracticalpieces.shared.MileageRequestFactory;
//import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace;
//import com.google.web.bindery.requestfactory.shared.Receiver;
//import com.google.web.bindery.requestfactory.shared.ServerFailure;
//import com.google.web.bindery.requestfactory.shared.RequestTransport;
//import com.google.web.bindery.requestfactory.gwt.client.DefaultRequestTransport; 
//import com.google.web.bindery.event.shared.EventBus;
//import com.google.web.bindery.event.shared.SimpleEventBus;
//import com.google.gwt.personal.tupracticalpieces.client.event.ShowMileageEvent;
import com.google.gwt.user.client.ui.DialogBox; //202406
//import com.google.gwt.personal.tupracticalpieces.client.ClientFactoryImpl;

import java.util.Collections;

 /**
 * Load and store the mileage data.
 */
public class CwUpdate extends ContentWidget implements AdminMileageSuperView {
   /**
   * The constants used in this Content Widget.
   */
  //@TUPracticalPiecesSource
  public static interface CwConstants extends Constants {
    String cwUpdateDescription();
  
    String cwUpdateName();
    
    String cwCommonAdminTitle();
    
    String cwCommonAdminName();
    
    String cwCommonAdminPassword();
    
    String cwCommonAdminOk();
    
    String cwCommonAdminCancel();
    
  }
  
//  /**
//   * RPC.
//   * 
//   */
//  //@TUPracticalPiecesData
//  public final AdminTaskAsync adminTaskSvc = GWT.create(AdminTask.class);
//  
  //private final ClientFactoryImpl cf;
//  interface Presenter {
//  	void goTo(Place place);
//  }
  
  Presenter presenter;
  //private final EventBus eventBus = new EventBus();
  //private final PlaceController placeController = new PlaceController(eventBus);
 
  //private final MileageRequestFactory requestFactory = GWT.create(MileageRequestFactory.class);
  /**
   * DB field name.
   */
  //@TUPracticalPiecesData
  private TextBox nameTextBox = new TextBox();
  
  /**
   * DB field password.
   */
  //@TUPracticalPiecesData
  private TextBox passwordTextBox = new TextBox();
  
  /**
   * DB field comment.
   */
  //@TUPracticalPiecesData
  private TextBox commentTextBox = new TextBox();
  
  /**
   * DB update parameters.
   */
  //@TUPracticalPiecesData
  static String tempStr;

  //@TUPracticalPiecesData
  public  final DialogBox dialogBox = new DialogBox();

  /**
   * main panel.
   */
  public VerticalPanel vPanel = new VerticalPanel();
  
  /**
   * page content.
   */
  //@TUPracticalPiecesData
  public HTML contentDiv =  new HTML("<p>Log:</p>");
  
  /**
   * page content.
   */
  //@TUPracticalPiecesData
  public VerticalPanel gridPanel = new VerticalPanel();
  
  /**
   * page content.
   */
  //@TUPracticalPiecesData
  public VerticalPanel contPanel = new VerticalPanel();
  
  /**
   * page content.
   */
  //@TUPracticalPiecesData
  public HorizontalPanel buttonPanel = new HorizontalPanel();
  
  /**
   * Issue the api call.
   */
  //@TUPracticalPiecesData
  public Button showButton = new Button("Show");
  
  /**
   * Issue the api call.
   */
  //@TUPracticalPiecesData
  public Button editButton = new Button("Edit");
  /**
   * Issue the api call.
   */
  //@TUPracticalPiecesData
  public Button deleteButton = new Button("Delete");
  
  /**
   * Issue the api call.
   */
  //@TUPracticalPiecesData
  public Button insertCloudButton = new Button("Insert");
//  
//  /**
//   * Mileage Table (Widget).
//   */
//  //@TUPracticalPiecesData
//  public MileageWidget milegeTable = null;
  
  /**
   * Mileage Table (Widget).
   */
  //@TUPracticalPiecesData
//  public CellList<MileageProxy> mileageList = null;
//  /**
//   * Mileage Table (Widget).
//   */
//  //@TUPracticalPiecesData
//  public CellList<TaskProxy> milegeList = null;

  /**
   * API IFRAME.
   */
  //@TUPracticalPiecesData
  //private Frame apiFrame = new Frame();
  
  /**
   * Message Timer.
   */
  //@TUPracticalPiecesData
  //private Timer timer;
  
    /**
   * Resources used by the mobile CellList.
   */
  interface CellListResources extends CellList.Resources {
    @Source({CellList.Style.DEFAULT_CSS})
    CellListStyle cellListStyle();
  }

  /**
   * Styles used by the mobile CellList.
   */
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
//        sb.appendEscaped(String.valueOf(value.getQuantity()).substring(0, 5));
        sb.appendEscaped(String.valueOf(value.getQuantity()));
        sb.appendHtmlConstant("</td><td>");
        sb.appendEscaped(String.valueOf(value.getUnitPrice()));
        sb.appendHtmlConstant("</td><td>");
        sb.appendEscaped(String.valueOf(value.getTotalPrice()));        
        sb.appendHtmlConstant("</td><td>");
//        sb.appendEscaped(String.valueOf(value.getBsMileage()).substring(0, 5));
        sb.appendEscaped(String.valueOf(value.getBsMileage()));
        sb.appendHtmlConstant("</td><td>");
 //       sb.appendEscaped(String.valueOf(value.getTotalMileage()).substring(0, 6));
        sb.appendEscaped(String.valueOf(value.getTotalMileage()));
        sb.appendHtmlConstant("</td></tr></table></div>");
      }
    }
  } //
//  /**
//   * Displays the list of tasks.
//   */
////  @UiField(provided = true)
////  CellList<TaskProxy> taskList;
    CellList<MileageProxy> mileageList; // = new CellList<MileageProxy>(new MileageCell());
  
    private ScrollPanel sp;
    private MileageProxy selected;
    
  //final ListDataProvider<MileageProxy> dataProvider = new ListDataProvider<MileageProxy>();
    
  /**
   * An instance of the constants.
   */
  @TUPracticalPiecesData
  public final CwConstants constants;
  


  /**
   * Constructor.
   */
  public CwUpdate(CwConstants constants) {
	/* 201305 remove style and source code tabs. */
    super(constants.cwUpdateName(), constants.cwUpdateDescription(), false);
    this.constants = constants;
  }
  
  
  /**
   * Initialize this example.
   */
  //@TUPracticalPiecesSource
  @Override
  public Widget onInitialize() {
    // Create the CellList.
    CellListResources cellListRes = GWT.create(CellListResources.class);
    mileageList = new CellList<MileageProxy>(new MileageCell(), cellListRes);
    final SingleSelectionModel<MileageProxy> selectionModel = new SingleSelectionModel<MileageProxy>();
    mileageList.setSelectionModel(selectionModel);
    selected = selectionModel.getSelectedObject();
    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
        @Override
        public void onSelectionChange(SelectionChangeEvent event) {
        	selected = selectionModel.getSelectedObject();
            //if (selected != null) {
            //	 presenter.selectMileage(selected);
            //}

        }
	});
    showButton.setEnabled(false);
    editButton.setEnabled(false);	    
    deleteButton.setEnabled(false);
    insertCloudButton.setEnabled(false);
    

	    
	    buttonPanel.add(showButton);
	    buttonPanel.add(editButton);
	    buttonPanel.add(deleteButton);
	    buttonPanel.add(insertCloudButton);
		//disenableButton(); 
	    contPanel.add(buttonPanel);
	    
	    
	    //contPanel.add( new MileageWidget(15));
	    //vPanel.add(apiFrame);

		//mileageList.setHTML("<table><tr><td>writing maileage list...</td></tr></table>");
		//setMileages();
		
	    // Create a CellList.
	    //mileageList = new CellList<MileageProxy>(new MileageCell());
	    // Create a list data provider.
	    //final ListDataProvider<MileageProxy> dataProvider = new ListDataProvider<MileageProxy>();
	    // Add the cellList to the dataProvider.
	    //dataProvider.addDataDisplay(mileageList);		


	    //mileageList.setHeight("100%");
	    sp = new ScrollPanel(mileageList);
	    sp.setHeight("500px");
	    sp.setWidth("500px");
	    vPanel.add(sp);
	    //mileageList.setHeight("500px");
	    

	    
	    //contentDiv = new HTML("<p>Log:</p>");
	    
	    //gridPanel.add(mileageList);
	    //gridPanel.setVisible(true);  // @@@@@@@@@@@@@@@@@@@@@@@@@@@a
	    vPanel.add(contentDiv);
	    vPanel.add(gridPanel);
//	    HTML contentTemp = new HTML("<table><tr><td>writing test list...</td></tr></table>");
//		vPanel.add(contentTemp);
	    contPanel.add(vPanel);
		//return contPanel;
		//adminMileageView.add(contPanel);
//		adminMileageView.add(super.onInitialize());
//	    //initWidget(uiBinder.createAndBindUi(this));
	    //initWidget(uiBinder.createAndBindUi(this)); //@@@@@@@@@@@@@@@@@@
//  

	/* 202406 add User authentication dialog
	 */
	LoginState ls = LoginState.getInstance();
	ls.checkLoginAdmin(dialogBox, constants.cwCommonAdminTitle(),
	    constants.cwCommonAdminName(), constants.cwCommonAdminPassword(), 
	    constants.cwCommonAdminOk(), constants.cwCommonAdminCancel(),
	    Arrays.asList(showButton), Arrays.asList(contentDiv), Window.Location.getHref());
	  
	return contPanel;


  }
//       
//    Button insertButton = new Button("insert");
//    dialogVPanel.add(insertButton);
//    insertButton.addClickHandler(new ClickHandler() {
////      @Override
//      public void onClick(ClickEvent event) {
//      	String supplyDate = null;
//      	// ('2002-10-12',34.23,107,3666,241.0,241.0)
//      	try {
//          	for (int i = 0; i < supplyDateTextBox.getText().length(); i++) {
//          		byte c = supplyDateTextBox.getText().getBytes()[i];
//          		if (i == 4 || i == 7) {
//          			if (c != '-') {
//          				throw new Exception();
//          			}
//          		} else {
//          			if  (c < '0' || c > '9') {
//          				throw new Exception();
//          			}
//          		}
//          	}
//          	supplyDate = supplyDateTextBox.getText();
//          	Float.parseFloat(quantityTextBox.getText());
//          	Float.parseFloat(quantityTextBox.getText());
//      		Integer.parseInt(unitPriceTextBox.getText());
//      		Integer.parseInt(totalPriceTextBox.getText());
//      		Float.parseFloat(bsMileageTextBox.getText());
//      		Float.parseFloat(totalMileageTextBox.getText());
//      		tempStr = "'" + supplyDate + "'," + quantityTextBox.getText() + ","
//      				+ unitPriceTextBox.getText()  + ","  + totalPriceTextBox.getText()  + ","
//      				+ bsMileageTextBox.getText()  + ","+ totalMileageTextBox.getText();
//      		/* due to deffer binding, static String String.format cannot be used.(?)
//          	tempStr = String.format("'%s',%.2f,%d,%d,%.1f,%.1f",
//          			supplyDate, quantity, unitPrice, totalPrice, bsMileage, totalMileage);
//          	*/		 
//      	} catch (Exception e) {
//              Window.alert("for example:('2002-10-12',34.23,107,3666,241.0,241.0)");
//              return;
//      	}
//      	// Window.alert("InsertSQL:" + tempStr);
//	    contentDiv.setHTML("<p>delete JDO button clicked</p>");
//  		AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
//  		      public void onFailure(Throwable caught) {
//  		    	String wedgeStr = "<ol style='list-style-type: disc'>";
//  		    	wedgeStr += "<li>" + "RPC failure." + "</li>";
//  		    	wedgeStr += "</ol>";
//  		    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//		    	enableButton();
//  		      }
//  		      public void onSuccess(ResultFetch result) {
//  		    	enableButton();
//  		    	if (result.getResult()) {
//  			        contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//  		  		    //apiFrame.setUrl("adminmethod?dp=" + URL.encode(url));
//	            	//Window.Location.assign(url);
//  		    	} else {
//    			    contentDiv.setHTML(contentDiv.getHTML() + result.getText());    		    	
//  		    	}
//  		      }
//  		    };
//  		adminTaskSvc.saveJobName("InsertSQL:" + tempStr, callback);
//        //dialogBox.hide();
//      }
//    });  
//    Button closeButton = new Button("close");
//    dialogVPanel.add(closeButton);
//    closeButton.addClickHandler(new ClickHandler() {
////      @Override
//      public void onClick(ClickEvent event) {
//        dialogBox.hide();
//    	enableButton();
//      }
//    });
//    /* Show button */
//    executeButton.addClickHandler(new ClickHandler() {
//    	public void onClick(ClickEvent event) {
//    	    gridPanel.setVisible(true);
//		    contentDiv.setHTML("<p>execute button clicked</p>");
//		    //milegeTable = new MileageWidget(15);
//		    milegeTable.refresh();
//		    /*
//		    disenableButton();
//    		AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
//  		      public void onFailure(Throwable caught) {
//  		    	String wedgeStr = "<ol style='list-style-type: disc'>";
//  		    	wedgeStr += "<li>" + "RPC failure." + "</li>";
//  		    	wedgeStr += "</ol>";
//  		    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//		    	enableButton();
//  		      }
//  		      public void onSuccess(ResultFetch result) {
//                if (result.getResult()) {   
//  		    	  contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//  			      //apiFrame.setUrl("adminmethod?dp=" + URL.encode(url));
//  		    	  Window.Location.assign(url);
//                } else {
//    		      contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//                }
//		    	enableButton();
//              }
//  		    };
//  		   adminTaskSvc.saveJobName("LoadFromCloud", callback);
//  		   */
//    }});
//    
//    /* no operation */
//    deleteButton.addClickHandler(new ClickHandler() {
//    	public void onClick(ClickEvent event) {
//		    contentDiv.setHTML("<p>delete JDO button clicked. No more operation.</p>");
///*		    disenableButton();
//    		AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
//    		      public void onFailure(Throwable caught) {
//    		    	String wedgeStr = "<ol style='list-style-type: disc'>";
//    		    	wedgeStr += "<li>" + "RPC failure." + "</li>";
//    		    	wedgeStr += "</ol>";
//    		    	contentDiv.setHTML(contentDiv.getHTML() + wedgeStr);
//    		    	enableButton();
//    		      }
//    		      public void onSuccess(ResultFetch result) {
//    		    	if (result.getResult()) {
//    			        contentDiv.setHTML(contentDiv.getHTML() + result.getText());
//    		  		    //apiFrame.setUrl("adminmethod?dp=" + URL.encode(url));
//    		  		    //Window.Location.assign(url);
//    		    	} else {
//      			      contentDiv.setHTML(contentDiv.getHTML() + result.getText());    		    	
//    		    	}
//    		    	enableButton();
//    		      }
//    		    };
//    		adminTaskSvc.saveJobName("DeleteJdo", callback);
//*/    }});
//    
//    insertCloudButton.addClickHandler(new ClickHandler() {
//    	public void onClick(ClickEvent event) {
//	    	disenableButton();
//    		dialogBox.show();
//    }});
//    /* 201305 Widget Grid
//	20141212 move to Show executeButton
//     */
//    MileageWidget milegeTable = new MileageWidget(15);
//    gridPanel.add(milegeTable);
//    gridPanel.setVisible(false);
//    contPanel.add(gridPanel);
//    /*
//    contentDiv.setHTML("please wait....");
//    checkConsent();
//    timer = new Timer() {
//		  @Override
//		  public void run() {
//			    contentDiv.setHTML("CANNOT CONNECT SERVER.");
//		 }
//	  };
//	timer.schedule(20000);
//	*/
//    //return contPanel;
//  }
  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
	   GWT.runAsync(CwUpdate.class, new RunAsyncCallback() {
         public void onFailure(Throwable caught) {
	       callback.onFailure(caught);
	     }
         public void onSuccess() {
	       callback.onSuccess(onInitialize());
	     }
	   });
  }
  
  public void setPresenter(Presenter presenter) {
  //Window.alert("setPresenter enter.");
  	this.presenter = presenter;
  }
  
  public void setMileages(List<MileageProxy> mileages) {
    mileageList.setRowData(mileages);
    contentDiv.setHTML(contentDiv.getHTML() + "<p>mileage count:" + mileages.size() + "</p>");
    //contentDiv.setHTML("<p>mileage count:" + mileages.size() + "</p>);
  }
    
//  private void fireMileageEdit() {
//  //Window.alert("fireMileageEdit enter");
//  //    eventBus.fireEventFromSource(new MileageEditEvent(selected), this);
//  //	placeController.goTo("!adminEdit?id=" + selected.getId());
//  //	placeController.goTo(new MileageEditPlace(selected.getId(), "app"));
//  //	eventBus.fireEvent(new ShowMileageEvent(selected));
//  //    eventBus.fireEventFromSource(new ShowMileageEvent(selected), this);
//  //	placeController.goTo(new MileageEditPlace(selected.getId(), selected));
//  //	placeController.goTo(new MileageEditPlace(selected.getId(), "app"));
//  //	presenter.goTo(new MileageEditPlace(selected.getId(), selected));
//  //Window.alert("fireMileageEdit exit");
//  }
  
  private void fireMileageDelete() {
  
      //eventBus.fireEventFromSource(new MileageEditEvent(selected), this);
  }

  
  /*
   * enable the button
   *
   */
//  public void enableButton() {
//	  executeButton.setEnabled(true);
//	  deleteButton.setEnabled(true);
//	  insertCloudButton.setEnabled(true);
//  }
//  
//  /*
//   * disenable the button
//   *
//   */
//  public void disenableButton() {
//		deleteButton.setEnabled(false);
//		executeButton.setEnabled(false);
//		insertCloudButton.setEnabled(false);	  
//  }
/*
 * JS function call. Get the session id. @@@ session id ???
 * 	return $wnd.__gwtStatsSessionId; @@@@@@
 */

  public Button getShowButton() {
	return showButton;
  }

  public Button getEditButton() {
    return editButton;
  }
  
  public Button getDeleteButton() {
    return deleteButton;
  }

  public Button getInsertButton() {
    return insertCloudButton;
  }
  
  public MileageProxy getSelected() {
	return selected;
  }
  
}

