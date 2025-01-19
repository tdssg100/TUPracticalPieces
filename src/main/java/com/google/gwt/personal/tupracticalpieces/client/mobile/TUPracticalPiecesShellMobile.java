/*
 * Copyright 2010 Google Inc.
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
//package com.google.gwt.personal.tupracticalpieces.client;
package com.google.gwt.personal.tupracticalpieces.client.mobile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.prefetch.Prefetcher;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.cellview.client.TreeNode;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.TreeViewModel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesConstants;
import com.google.gwt.personal.tupracticalpieces.client.mobile.MainMenuTreeViewModelMobile;
//import com.google.gwt.personal.tupracticalpieces.client.Category;
import com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditView;
// import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageReadPlace;
// import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageReadView;
import com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace;
import com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileageSuperView;
import com.google.gwt.i18n.client.Constants;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Application shell for TUPracticalPieces personal.
 */
/**
 * 20160123 MVP for mobile
 * 20160222 eventbus, presenter, place, activities
 * 20160511 editor
 */
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPieces;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesShell;
//import com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView;
import com.google.gwt.personal.tupracticalpieces.client.desktop.MainMenuTreeViewModelDesktop;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.content.CwUpdate;
//public class TUPracticalPiecesShell extends ResizeComposite {
public class TUPracticalPiecesShellMobile extends ResizeComposite implements TUPracticalPiecesShell {

  //interface TUPracticalPiecesShellMobileUiBinder extends UiBinder<Widget, TUPracticalPiecesShell> {
  interface TUPracticalPiecesShellMobileUiBinder extends UiBinder<Widget, TUPracticalPiecesShellMobile> {
  }
  private static TUPracticalPiecesShellMobileUiBinder uiBinder = GWT.create(
	      TUPracticalPiecesShellMobileUiBinder.class);

  
  private String theme = TUPracticalPieces.THEME;
  
  /**
   * The static images used throughout the TUPracticalPieces.
   */
//  public static final TUPracticalPiecesResources images = GWT.create(
//      TUPracticalPiecesResources.class);
  public static final TUPracticalPiecesResourcesMobile images = GWT.create(
	      TUPracticalPiecesResourcesMobile.class);
  

  /**
   * The callback used when retrieving source code.
   */
  //private class CustomCallback implements ContentWidget.Callback<String> {
  private class CustomCallback implements ContentWidget.Callback<String> {

    private int id;

    public CustomCallback() {
      id = ++nextCallbackId;
    }

    public void onError() {
      if (id == nextCallbackId) {
        contentSource.setHTML("Cannot find resource", Direction.LTR);
      }
    }

    public void onSuccess(String value) {
      if (id == nextCallbackId) {
        contentSource.setHTML(value, Direction.LTR);
      }
    }
  }

  /**
   * The text color of the selected tab.
   */
  private static final String SELECTED_TAB_COLOR = "#333333";

  /**
   * The unique ID assigned to the next callback.
   */
  private static int nextCallbackId = 0;


  
//  private AdminMileageSuperView adminViewMileage;
//  private MileageEditView adminEditMileage;
//  private MileageReadView adminReadMileage;
  
  private SimpleLayoutPanel contentPanel = new SimpleLayoutPanel();

  /**
   * The panel that holds the content.
   */
//  @UiField
//  SimpleLayoutPanel contentPanel;
//  @UiField
//  DockLayoutPanel contentPanel;
  /**
   * The panel used for layout.
   */
  @UiField
  DeckLayoutPanel contentContainer;

//  @UiField
//  LayoutPanel layoutPanel;

   /**
    * The panel that holds the menu.
    */
   @UiField
  DockLayoutPanel mMenuContainer;

   /**
    * The panel that holds the menu.
    */
   @UiField
   ScrollPanel mMenuPanel;

  /**
   * The panel that holds the content. @@@@@@
   */
  @UiField
  Button burgerMenuButton;
  
  /**
   * The container around the links at the top of the app.
   */
  @UiField
  TableElement linkCell;

  /**
   * A drop box used to change the locale.
   */
  @UiField
  ListBox localeBox;

  /**
   * The container around locale selection.
   */
  @UiField
  TableCellElement localeSelectionCell;

  /**
   * The main menu used to navigate to examples.
   */
  @UiField(provided = true)
  CellTree mainMenu;

  /**
   * The button used to show the example.
   */
  @UiField
  Anchor tabExample;

  /**
   * The button used to show the source CSS style.
   */
  @UiField
  Anchor tabStyle;

  /**
   * The button used to show the source code.
   */
  @UiField
  Anchor tabSource;

  /**
   * The list of available source code.
   */
  @UiField
  ListBox tabSourceList;

  /**
   * A boolean indicating that we have not yet seen the first content widget.
   */
  private boolean firstContentWidget = true;

  /**
   * The current {@link ContentWidget} being displayed.
   */
  private ContentWidget content;

  /**
   * The handler used to handle user requests to view raw source.
   */
  private HandlerRegistration contentSourceHandler;

  /**
   * The widget that holds CSS or source code for an example.
   */
  private HTML contentSource = new HTML();

  /**
   * The html used to show a loading icon.
   */
  private final String loadingHtml;

//	  /**
//	   * The static images used throughout the TUPracticalPieces.
//	   */
//	  public static final TUPracticalPiecesResources images = GWT.create(
//	      TUPracticalPiecesResources.class);
	
	  /**
	   * Get the token for a given content widget.
	   *
	   * @return the content widget token.
	   */
//      public static String getContentWidgetToken(ContentWidget content) {
	  public static String getContentWidgetToken(ContentWidget content) {
	    return getContentWidgetToken(content.getClass());
	  }

	  /**
	   * Get the token for a given content widget.
	   *
	   * @return the content widget token.
	   */
//	  public static <C extends ContentWidget> String getContentWidgetToken(
	  public static <C extends ContentWidget> String getContentWidgetToken(
	      Class<C> cwClass) {
	    String className = cwClass.getName();
	    className = className.substring(className.lastIndexOf('.') + 1);
	    if (className.substring(className.length() - 6).equals("Mobile")) {
	    	className = className.substring(0,className.length() - 7 -1);
	    }
	    return "!" + className;
	  };
//	// Initialize the constants.
//	TUPracticalPiecesConstants constants = GWT.create(TUPracticalPiecesConstants.class);
	 
	// Create the application shell.
	final SingleSelectionModel<ContentWidget> selectionModel = new SingleSelectionModel<ContentWidget>();
//	final MainMenuTreeViewModelMobile treeModel = new MainMenuTreeViewModelMobile(
//			TUPracticalPieces.constants, selectionModel);
//	Set<ContentWidget> contentWidgets = treeModel.getAllContentWidgets();
  
  
  /**
   * Construct the {@link TUPracticalPiecesShell}.
   *
   * @param treeModel the treeModel that backs the main menu
   */
//  public TUPracticalPiecesShellDesktop(TreeViewModel treeModel) {
//    AbstractImagePrototype proto = AbstractImagePrototype.create(
//        TUPracticalPieces.images.loading());
//    loadingHtml = proto.getHTML();
//
//    // Create the cell tree.
//    mainMenu = new CellTree(treeModel, null);
//    mainMenu.setAnimationEnabled(true);
//    mainMenu.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.DISABLED);
//    mainMenu.ensureDebugId("mainMenu");
//
//    // Initialize the ui binder.
//    initWidget(uiBinder.createAndBindUi(this));
//    initializeLocaleBox();
//    contentSource.getElement().getStyle().setBackgroundColor("#eee");
//    contentSource.getElement().getStyle().setMargin(10.0, Unit.PX);
//    contentSource.getElement().getStyle().setProperty(
//        "border", "1px solid #c3c3c3");
//    contentSource.getElement().getStyle().setProperty("padding", "10px 2px");
//
//    // In RTL mode, we need to set some attributes.
//    if (LocaleInfo.getCurrentLocale().isRTL()) {
//      localeSelectionCell.setAlign("left");
//      linkCell.setPropertyString("align", "left");
//    }
//
//    // Handle events from the tabs.
//    tabExample.addClickHandler(new ClickHandler() {
//      public void onClick(ClickEvent event) {
//        showExample();
//      }
//    });
//    tabStyle.addClickHandler(new ClickHandler() {
//      public void onClick(ClickEvent event) {
//        showSourceStyles();
//      }
//    });
//    tabSource.addClickHandler(new ClickHandler() {
//      public void onClick(ClickEvent event) {
//        showSourceFile();
//      }
//    });
//    tabSourceList.addChangeHandler(new ChangeHandler() {
//      public void onChange(ChangeEvent event) {
//        showSourceFile();
//      }
//    });
//
//    // Default to no content.
//    contentPanel.ensureDebugId("contentPanel");
//    /* 201302
//    setContent(null);
//    */
//    setContent(null, 0);
//  }

  
//  public TUPracticalPiecesShellDesktop(EventBus bus, TaskChartPresenter pieChart,
//	      final PlaceController placeController, TaskListView taskListView, TaskEditView taskEditView,
//	      TaskReadView taskReadView) {
//	public TUPracticalPiecesShellDesktop(EventBus bus, final PlaceController placeController,MainMenuTreeViewModel treeModel) {
//	public TUPracticalPiecesShellMobile(EventBus bus, final PlaceController placeController) {
//	public TUPracticalPiecesShellMobile(final PlaceController placeController, MileageEditView mileageEditView, MileageReadView mileageReadView) {
//	public TUPracticalPiecesShellMobile(final PlaceController placeController, MileageEditView mileageEditView, MileageReadView mileageReadView, CwUpdate cwUpdate, TUPracticalPiecesConstants constants) {
    public TUPracticalPiecesShellMobile(final PlaceController placeController, MileageEditView mileageEditView, CwUpdate cwUpdate, TUPracticalPiecesConstants constants) {
	    // Inject global styles.
	    injectThemeStyleSheet();
	    images.css().ensureInjected();

	    
		//final MainMenuTreeViewModel treeModel = new MainMenuTreeViewModel(
//		AdminMileageView adminViewMileageList = new AdminMileageView(TUPracticalPieces.constants);

//		final MainMenuTreeViewModelMobile treeModel = new MainMenuTreeViewModelMobile(
//				TUPracticalPieces.constants, selectionModel, adminViewMileageList);
		final MainMenuTreeViewModelMobile treeModel = new MainMenuTreeViewModelMobile(
				constants, selectionModel, cwUpdate);
//		adminViewMileage = adminViewMileageList;
		Set<ContentWidget> contentWidgets = treeModel.getAllContentWidgets();
//		adminEditMileage = treeModel.getAdminMaileageEditView();
	    
//		final MainMenuTreeViewModelMobile treeModel = new MainMenuTreeViewModelMobile(
//				TUPracticalPieces.constants, selectionModel);
//	    
	    
	    
//	    // Initialize the main menu.
//	    Resources resources = GWT.create(Resources.class);
//	    mainMenu = new CellList<MainMenuItem>(new MainMenuItem.Cell(), resources);
//	    mainMenu.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.DISABLED);
//
//	    // We don't expect to have more than 30 menu items.
//	    mainMenu.setVisibleRange(0, 30);
//
//	    // Add items to the main menu.
//	    final List<MainMenuItem> menuItems = new ArrayList<MainMenuItem>();
//	    menuItems.add(new MainMenuItem("Task List", new TaskListPlace(false)) {
//	      @Override
//	      public boolean mapsToPlace(Place p) {
//	        // Map to all TaskListPlace instances.
//	        return p instanceof TaskListPlace;
//	      }
//	    });
//	    menuItems.add(new MainMenuItem("Add Task", TaskPlace.getTaskCreatePlace()));
//	    mainMenu.setRowData(menuItems);
//
//	    // Choose a place when a menu item is selected.
//	    final SingleSelectionModel<MainMenuItem> selectionModel =
//	        new SingleSelectionModel<MainMenuItem>();
//	    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//	      public void onSelectionChange(SelectionChangeEvent event) {
//	        MainMenuItem selected = selectionModel.getSelectedObject();
//	        if (selected != null && !selected.mapsToPlace(placeController.getWhere())) {
//	          placeController.goTo(selected.getPlace());
//	        }
//	      }
//	    });
//	    mainMenu.setSelectionModel(selectionModel);
//
//	    // Update selection based on the current place.
//	    bus.addHandler(PlaceChangeEvent.TYPE, new PlaceChangeEvent.Handler() {
//	      public void onPlaceChange(PlaceChangeEvent event) {
//	        Place place = event.getNewPlace();
//	        for (MainMenuItem menuItem : menuItems) {
//	          if (menuItem.mapsToPlace(place)) {
//	            // We found a match in the main menu.
//	            selectionModel.setSelected(menuItem, true);
//	            return;
//	          }
//	        }
//
//	        // We didn't find a match in the main menu.
//	        selectionModel.setSelected(null, true);
//	      }
//	    });
		

		//AbstractImagePrototype proto = AbstractImagePrototype.create(TUPracticalPieces.images.loading());	    
		AbstractImagePrototype proto = AbstractImagePrototype.create(images.loading());	    
	    loadingHtml = proto.getHTML();


	    // Create the cell tree.
	    mainMenu = new CellTree(treeModel, null);
	    mainMenu.setAnimationEnabled(true);
	    mainMenu.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.DISABLED);
	    mainMenu.ensureDebugId("mainMenu");

	    // Initialize the ui binder.
	    initWidget(uiBinder.createAndBindUi(this));


	    initializeLocaleBox();
	    contentSource.getElement().getStyle().setBackgroundColor("#eee");
	    contentSource.getElement().getStyle().setMargin(10.0, Unit.PX);
	    contentSource.getElement().getStyle().setProperty(
	        "border", "1px solid #c3c3c3");
	    contentSource.getElement().getStyle().setProperty("padding", "10px 2px");

	    // In RTL mode, we need to set some attributes.
	    if (LocaleInfo.getCurrentLocale().isRTL()) {
	      localeSelectionCell.setAlign("left");
	      linkCell.setPropertyString("align", "left");
	    }

	    // Handle events from the tabs.
	    tabExample.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        showExample();
	      }
	    });
	    tabStyle.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        showSourceStyles();
	      }
	    });
	    tabSource.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        showSourceFile();
	      }
	    });
	    tabSourceList.addChangeHandler(new ChangeHandler() {
	      public void onChange(ChangeEvent event) {
	        showSourceFile();
	      }
	    });

	    // Default to no content.
	    contentPanel.ensureDebugId("contentPanel");
	    /* 201302
	    setContent(null);
	    */
	    
//		adminViewMileage = treeModel.getAdminMaileageView();
//		adminEditMileage = treeModel.getAdminMaileageEditView();
//		adminReadMileage = treeModel.getAdminMaileageReadView();
//		Set<ContentWidget> contentWidgets = treeModel.getAllContentWidgets();
	    
	    
	    content = treeModel.getFirstContentWidget();
        int catInx = treeModel.indexOf(treeModel.getCategoryForContentWidget(content));
	    setContent(content, catInx);
	    
	    
		//shell = new TUPracticalPiecesShell(treeModel);
		//RootLayoutPanel.get().add(shell);
	    // Prefetch examples when opening the Category tree nodes.
	    final List<MainMenuTreeViewModelMobile.Category> prefetched = new ArrayList<MainMenuTreeViewModelMobile.Category>();
	    //final CellTree mainMenu = shell.getMainMenu();
	    mainMenu.addOpenHandler(new OpenHandler<TreeNode>() {
	      public void onOpen(OpenEvent<TreeNode> event) {
	        Object value = event.getTarget().getValue();
	        if (!(value instanceof MainMenuTreeViewModelMobile.Category)) {
	          return;
	        }

	        MainMenuTreeViewModelMobile.Category category = (MainMenuTreeViewModelMobile.Category) value;
	        if (!prefetched.contains(category)) {
	          prefetched.add(category);
	          Prefetcher.prefetch(category.getSplitPoints());
	        }
	      }
	    });

	    // Always prefetch.
	    Prefetcher.start();

	    // Change the history token when a main menu item is selected.
	    selectionModel.addSelectionChangeHandler(
	        new SelectionChangeEvent.Handler() {
	          public void onSelectionChange(SelectionChangeEvent event) {
	            ContentWidget selected = selectionModel.getSelectedObject();
	            if (selected != null) {
	              History.newItem(getContentWidgetToken(selected), true);
	            }
//	            mMenuContainer.getWidget(0).setHeight("0"); 
	            // Hide burger menu
	            mMenuContainer.getWidget(1).setStyleName("hideMenu");
//	        	mMenuContainer.setWidgetHidden(mMenuPanel.getParent(), false);
	        	mMenuContainer.setWidgetHidden(mMenuPanel, true);
	        	mMenuContainer.forceLayout();

	            
	            
	          }
	        });
//
//	    // Setup a history handler to reselect the associate menu item.
//	    final ValueChangeHandler<String> historyHandler = new ValueChangeHandler<
//	        String>() {
//	      public void onValueChange(ValueChangeEvent<String> event) {
//	        // Get the content widget associated with the history token.
//	        ContentWidget contentWidget = treeModel.getContentWidgetForToken(
//	            event.getValue());
//	        if (contentWidget == null) {
//	          return;
//	        }
//
//	        // Expand the tree node associated with the content.
//	        Category category = treeModel.getCategoryForContentWidget(
//	            contentWidget);
//	        TreeNode node = mainMenu.getRootTreeNode();
//	        int childCount = node.getChildCount();
//	        int catNo = 0;
//	        for (int i = 0; i < childCount; i++) {
//	          if (node.getChildValue(i) == category) {
//	            node.setChildOpen(i, true, true);
//	            catNo = i;
//	            break;
//	          }
//	        }
//
//	        // Select the node in the tree.
//	        selectionModel.setSelected(contentWidget, true);
//	        
//	        // Display the content widget.
//	        /* 2013 add category no.
//	        displayContentWidget(contentWidget);
//	        */
//	        //int catNo = category.hashCode();
//	        //int catNo = node.getIndex();
//	        displayContentWidget(contentWidget, catNo);
//	   
//	      }
//	    };
//	    History.addValueChangeHandler(historyHandler);
//
//	    // Show the initial example.
//	    if (History.getToken().length() > 0) {
//	      History.fireCurrentHistoryState();
//	    } else {
//	      // Use the first token available.
//	      TreeNode root = mainMenu.getRootTreeNode();
//	      TreeNode category = root.setChildOpen(0, true);
//	      ContentWidget content = (ContentWidget) category.getChildValue(0);
//	      selectionModel.setSelected(content, true);
//	    }
//
//	    // Generate a site map.
//	    createSiteMap(contentWidgets);
//
//	    
//	    contentPanel.add(mileageEditView);	    
//	    contentPanel.add(mileageReadView);	    
//	    
//	    
	    
	    // Setup a history handler to reselect the associate menu item.
	    final ValueChangeHandler<String> historyHandler = new ValueChangeHandler<
	        String>() {
	      public void onValueChange(ValueChangeEvent<String> event) {
	        // Get the content widget associated with the history token.
		    	// transit to app
//			    if (("!AdminM".equals(event.getValue().substring(0,7))) ||
//				    	("adminL".equals(event.getValue().substring(0,6)))) {
////		    	if ("!AdminM".equals(event.getValue().substring(0,7))) {
//		    		placeController.goTo(new AdminMileagePlace(true));
//		    		// nothing 
//		    		return;
//		    	}
		    	// transit to app

/*
		    	if ("adminEdit".equals(event.getValue().substring(0,9))) {
		    		String token = event.getValue();
		    		if (token.equals("adminEdit:adminCreate")) {
		    			placeController.goTo(MileageReadPlace.getMileageCreatePlace());
		    		} else {
		    			try {
		    				// Parse the task ID from the URL.
		    				Long mileageId = Long.parseLong(token);
		    				placeController.goTo( new MileageReadPlace(mileageId, null));
		    			} catch (NumberFormatException e) {
		    				// do nothing
		    				return;
		    			}

		    		}
			    	// do nothing
			    	return;
		    	}
 */          

 
		    	
	        ContentWidget contentWidget = treeModel.getContentWidgetForToken(
	            event.getValue());
	        if (contentWidget == null) {
	          return;
	        }
		   
//OpenHandler
//	        // Expand the tree node associated with the content.
//	        Category category = treeModel.getCategoryForContentWidget(
//	            contentWidget);
//	        TreeNode node = mainMenu.getRootTreeNode();
//	        int childCount = node.getChildCount();
//	        int catNo = 0;
//	        for (int i = 0; i < childCount; i++) {
//	          if (node.getChildValue(i) == category) {
//	            node.setChildOpen(i, true, true);
//	            catNo = i;
//	            break;
//	          }
//	        }
//

	        
	        
	        // Select the node in the tree.
	        selectionModel.setSelected(contentWidget, true);
	        
	        // Display the content widget.
	        /* 2013 add category no.
	        displayContentWidget(contentWidget);
	        */
	        //int catNo = category.hashCode();
	        int catInx = treeModel.indexOf(treeModel.getCategoryForContentWidget(contentWidget));
	        displayContentWidget(contentWidget, catInx);
		   
	      }
	    };
	    History.addValueChangeHandler(historyHandler);

	    // Show the initial example.
//	    if (History.getToken().length() > 0) {
//	      History.fireCurrentHistoryState();
//	    } else {
////	      // Use the first token available.
////	      TreeNode root = mainMenu.getRootTreeNode();
////	      TreeNode category = root.setChildOpen(0, true);
////	      ContentWidget content = (ContentWidget) category.getChildValue(0);
////	      selectionModel.setSelected(content, true);
//
//		    
//		      // Use the first token available.
//		    content = treeModel.getFirstContentWidget();
//	        selectionModel.setSelected(content, true);
//	        int catInx = treeModel.indexOf(treeModel.getCategoryForContentWidget(content));
//		    setContent(content, catInx);
//	    
//	    
//	    }

	    
	    
	    
	    
//	    
//	    
//	    content = treeModel.getFirstContentWidget();
//        selectionModel.setSelected(content, true);
//        int catInx = treeModel.indexOf(treeModel.getCategoryForContentWidget(content));
//	    setContent(content, catInx);
//
	    
	    
	    // Generate a site map.
	    createSiteMap(contentWidgets);

	    
	    contentContainer.add(contentPanel);
//	    contentContainer.add(adminViewMileage);
//	    contentContainer.add(mileageReadView); 
	    contentContainer.add(mileageEditView);
        contentContainer.setWidget(contentPanel);
	    contentContainer.setAnimationDuration(100);
	    
	    
	    
	    
	    
	    

	  }
	
	
	  /**
	   * Create a hidden site map for crawlability.
	   * 
	   * @param contentWidgets the {@link ContentWidget}s used in TUPracticalPieces
	   */
	  private void createSiteMap(Set<ContentWidget> contentWidgets) {
	    SafeHtmlBuilder sb = new SafeHtmlBuilder();
	    for (ContentWidget cw : contentWidgets) {
	      String token = getContentWidgetToken(cw);
	      sb.append(SafeHtmlUtils.fromTrustedString("<a href=\"#" + token + "\">"
	          + token + "</a>"));
	    }

	    // Add the site map to the page.
	    HTML siteMap = new HTML(sb.toSafeHtml());
	    siteMap.setVisible(false);
	    RootPanel.get().add(siteMap, 0, 0);
	  }
	  
	  /**
	   * Set the content to the {@link ContentWidget}.
	   *
	   * @param content the {@link ContentWidget} to display
	   */
	  /* 201302
	  private void displayContentWidget(ContentWidget content) {
	  */
	  private void displayContentWidget(ContentWidget content, int catInx) {
	    if (content == null) {
	      return;
	    }

	    /* 201302
	    shell.setContent(content);
	    */
	    //shell.setContent(content, catNo);
	    this.setContent(content, catInx);
	    Window.setTitle("TUPracticalPieces of Features: " + content.getName());
	  }	
  
  
  
  /* Set the widget to display in content area.
   * 
   * @param content the {@link Widget} to display
   */
  public void setWidget(IsWidget content) {
    //contentContainer.setWidget(content);
	  contentPanel.setWidget(content);

    // Do not animate the first time we show a widget.
    if (firstContentWidget) {
      firstContentWidget = false;
      //contentContainer.animate(0);
      //contentPanel.animate(0);
    }
  }

  
  /**
   * Returns the currently displayed content. (Used by tests.)
   */
  public ContentWidget getContent() {
    return content;
  }

  /**
   * Get the main menu used to select examples.
   *
   * @return the main menu
   */
  public CellTree getMainMenu() {
    return mainMenu;
  }

  /**
   * Set the content to display.
   *
   * @param content the content
   */
  public void setContent(final ContentWidget content, int catInx) {
    // Clear the old handler.
    if (contentSourceHandler != null) {
      contentSourceHandler.removeHandler();
      contentSourceHandler = null;
    }

    this.content = content;
    if (content == null) {
      tabExample.setVisible(false);
      tabStyle.setVisible(false);
      tabSource.setVisible(false);
      tabSourceList.setVisible(false);
      contentPanel.setWidget(null);
      return;
    }
 
    // Setup the options bar.
    tabExample.setVisible(true);
    tabStyle.setVisible(content.hasStyle());
    tabSource.setVisible(true);
  
    /*
     * Show the list of raw source files if there are any. We need to add at
     * least one option to the list for crawlability. If we do not, HtmlUnit
     * innerHtml will close the select tag in the open tag (ie, use a forward
     * slash instead of a separate close tag) which most browsers parse
     * incorrectly.
     */
    tabSourceList.clear();
    tabSourceList.addItem("Example");
    List<String> rawFilenames = content.getRawSourceFilenames();
    if (rawFilenames.size() > 0) {
      String text = tabSource.getText();
      if (!text.endsWith(":")) {
        tabSource.setText(text + ":");
      }
      tabSourceList.setVisible(true);
      for (String filename : rawFilenames) {
        tabSourceList.addItem(filename);
      }
      tabSourceList.setSelectedIndex(0);
    } else {
      String text = tabSource.getText();
      if (text.endsWith(":")) {
        tabSource.setText(text.substring(0, text.length() - 1));
      }
      tabSourceList.setVisible(false);
    }
    // change background by the category 201302 TU
    int r = catInx % 3;
    // String catStyle = (r == 0) ? "backgroundCategory0" : (r == 1) ? "backgroundCategory1" : "backgroundCategory2";
    String catStyle = (r == 0) ? "#ffe" : (r == 1) ? "#eff" : "#fef";
    tabExample.getElement().getStyle().setBackgroundColor(catStyle);    
    tabStyle.getElement().getStyle().setBackgroundColor(catStyle);    
    tabSource.getElement().getStyle().setBackgroundColor(catStyle);
    tabSourceList.getElement().getStyle().setBackgroundColor(catStyle);
    contentPanel.getElement().getStyle().setBackgroundColor(catStyle);
    /* 201305 remove style and source tab */
    if (r != 1) { 
      // tabStyle.getParent().setVisible(false); 
      tabSource.setVisible(false);
      tabExample.getParent().setVisible(false); 
    } else {
        tabSource.setVisible(true);
        // In order to hide tab. 
        tabExample.getParent().setVisible(true);     	
    }
    // Handle user requests for raw source.
    contentSourceHandler = content.addValueChangeHandler(
        new ValueChangeHandler<String>() {
          public void onValueChange(ValueChangeEvent<String> event) {
            // Select the file in the list box.
            String filename = event.getValue();
            int index = content.getRawSourceFilenames().indexOf(filename);
            tabSourceList.setSelectedIndex(index + 1);

            // Show the file.
            showSourceFile();
          }
        });

    // Show the widget.
    showExample();
  }

  /**
   * Initialize the {@link ListBox} used for locale selection.
   */
  private void initializeLocaleBox() {
    final String cookieName = LocaleInfo.getLocaleCookieName();
    final String queryParam = LocaleInfo.getLocaleQueryParam();
    if (cookieName == null && queryParam == null) {
      // if there is no way for us to affect the locale, don't show the selector
      localeSelectionCell.getStyle().setDisplay(Display.NONE);
      return;
    }
    String currentLocale = LocaleInfo.getCurrentLocale().getLocaleName();
    if (currentLocale.equals("default")) {
      currentLocale = "en";
    }
    String[] localeNames = LocaleInfo.getAvailableLocaleNames();
    for (String localeName : localeNames) {
      if (!localeName.equals("default")) {
        String nativeName = LocaleInfo.getLocaleNativeDisplayName(localeName);
        localeBox.addItem(nativeName, localeName);
        if (localeName.equals(currentLocale)) {
          localeBox.setSelectedIndex(localeBox.getItemCount() - 1);
        }
      }
    }
    localeBox.addChangeHandler(new ChangeHandler() {
      @SuppressWarnings("deprecation")
      public void onChange(ChangeEvent event) {
        String localeName = localeBox.getValue(localeBox.getSelectedIndex());
        if (cookieName != null) {
          // expire in one year
          Date expires = new Date();
          expires.setYear(expires.getYear() + 1);
          Cookies.setCookie(cookieName, localeName, expires);
        }
        if (queryParam != null) {
          UrlBuilder builder = Location.createUrlBuilder().setParameter(
              queryParam, localeName);
          Window.Location.replace(builder.buildString());
        } else {
          // If we are using only cookies, just reload
          Window.Location.reload();
        }
      }
    });
    /* init burgerMenu for mobile
     */
    burgerMenuButton.setText(new String("\u2630"));     //&#9776"));&#x2630; 
    burgerMenuButton.setStyleName("burgerMenuButton");
    burgerMenuButton.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
        	
//        	mMenuContainer.getWidget(0).setHeight("55");
//        	mMenuContainer.getWidget(1).setStyleName("displayMenu");
//        	mMenuContainer.setWidgetHidden(mMenuPanel.getParent(), true);
        	mMenuContainer.setWidgetHidden(mMenuPanel, false);
        	mMenuContainer.forceLayout();
        }
      });

  }

  /**
   * Show a example.
   */
  private void showExample() {
    if (content == null) {
      return;
    }

    // Set the highlighted tab.
    tabExample.getElement().getStyle().setColor(SELECTED_TAB_COLOR);
    tabStyle.getElement().getStyle().clearColor();
    tabSource.getElement().getStyle().clearColor();

    contentPanel.setWidget(content);
    contentContainer.setWidget(contentPanel);
    
  }

  /**
   * Show a source file based on the selection in the source list.
   */
  private void showSourceFile() {
    if (content == null) {
      return;
    }

    // Set the highlighted tab.
    tabExample.getElement().getStyle().clearColor();
    tabStyle.getElement().getStyle().clearColor();
    tabSource.getElement().getStyle().setColor(SELECTED_TAB_COLOR);

    contentSource.setHTML(loadingHtml, Direction.LTR);
    contentPanel.setWidget(new ScrollPanel(contentSource));
    if (!tabSourceList.isVisible() || tabSourceList.getSelectedIndex() == 0) {
      // If the source list isn't visible or the first item is selected, load
      // the source for the example.
      content.getSource(new CustomCallback());
    } else {
      // Load a raw file.
      String filename = tabSourceList.getItemText(
          tabSourceList.getSelectedIndex());
      content.getRawSource(filename, new CustomCallback());
    }
  }

  /**
   * Show the source CSS style.
   */
  private void showSourceStyles() {
    if (content == null) {
      return;
    }

    // Set the highlighted tab.
    tabExample.getElement().getStyle().clearColor();
    tabStyle.getElement().getStyle().setColor(SELECTED_TAB_COLOR);
    tabSource.getElement().getStyle().clearColor();

    contentSource.setHTML(loadingHtml, Direction.LTR);
    contentPanel.setWidget(new ScrollPanel(contentSource));
    content.getStyle(new CustomCallback());
    //content.getStyle(theme, new CustomCallback());
  }
  /**
   * Convenience method for getting the document's head element.
   *
   * @return the document's head element
   */
  private native HeadElement getHeadElement() /*-{
    return $doc.getElementsByTagName("head")[0];
  }-*/;

  /**
   * Inject the GWT theme style sheet based on the RTL direction of the current
   * locale.
   */
  private void injectThemeStyleSheet() {
    // Choose the name style sheet based on the locale.
    //String styleSheet = "gwt/" + THEME + "/" + THEME;
    String styleSheet = "gwt/" + theme + "/" + theme;
    //    styleSheet += LocaleInfo.getCurrentLocale().isRTL() ? "_rtl.gss" : ".gss";
    styleSheet += LocaleInfo.getCurrentLocale().isRTL() ? "_rtl.css" : ".css";

    // Load the GWT theme style sheet
    String modulePath = GWT.getModuleBaseURL();
    LinkElement linkElem = Document.get().createLinkElement();
    linkElem.setRel("stylesheet");
    linkElem.setType("text/css");
    linkElem.setHref(modulePath + styleSheet);
    getHeadElement().appendChild(linkElem);
  }
//  public AdminMileageSuperView getAdminMileageView() {
//	  return adminViewMileage;
//  }
//  public MileageEditView getAdminMileageEditView() {
//	  return adminEditMileage;
//  }
//  public MileageReadView getAdminMileageReadView() {
//	  return adminReadMileage;
//  }
//  
  
//  private void onShiftToLandscape() {
//
//	    // Landscape.
//	    layoutPanel.setWidgetTopBottom(titleBar, 0, Unit.PX, 0, Unit.PX);
//	    layoutPanel.setWidgetLeftWidth(titleBar, 0, Unit.PX, LANDSCAPE_MENU_WIDTH_EX, Unit.EX);
//	    titleElem.getStyle().setDisplay(Display.NONE);
//
//	    layoutPanel.setWidgetTopBottom(contentContainer, 0, Unit.PX, 0, Unit.PX);
//	    layoutPanel.setWidgetLeftRight(contentContainer, LANDSCAPE_MENU_WIDTH_EX, Unit.EX, 0, Unit.PX);
//
//	    layoutPanel.setWidgetTopHeight(addButtonContainer, 5, Unit.PX, 4, Unit.EX);
//	    layoutPanel
//	        .setWidgetLeftWidth(addButtonContainer, 0, Unit.PX, LANDSCAPE_MENU_WIDTH_EX, Unit.EX);
//
//	    layoutPanel.setWidgetBottomHeight(backButtonContainer, 5, Unit.PX, 4, Unit.EX);
//	    layoutPanel.setWidgetLeftWidth(backButtonContainer, 0, Unit.PX, LANDSCAPE_MENU_WIDTH_EX,
//	        Unit.EX);
//	  }
//
//	  private void onShiftToPortrait() {
//	    // Portrait.
//	    layoutPanel.setWidgetTopHeight(titleBar, 0, Unit.PX, PORTRAIT_MENU_HEIGHT_PT, Unit.PT);
//	    layoutPanel.setWidgetLeftRight(titleBar, 0, Unit.PX, 0, Unit.PX);
//	    titleElem.getStyle().clearDisplay();
//
//	    layoutPanel.setWidgetTopBottom(contentContainer, PORTRAIT_MENU_HEIGHT_PT, Unit.PT, 0, Unit.PX);
//	    layoutPanel.setWidgetLeftRight(contentContainer, 0, Unit.EX, 0, Unit.PX);
//
//	    layoutPanel
//	        .setWidgetTopHeight(addButtonContainer, 0, Unit.PX, PORTRAIT_MENU_HEIGHT_PT, Unit.PT);
//	    layoutPanel.setWidgetRightWidth(addButtonContainer, 8, Unit.PX, 3, Unit.EX);
//
//	    layoutPanel.setWidgetTopHeight(backButtonContainer, 0, Unit.PX, PORTRAIT_MENU_HEIGHT_PT,
//	        Unit.PT);
//	    layoutPanel.setWidgetLeftWidth(backButtonContainer, 8, Unit.PX, 6, Unit.EX);
//	  }
//
//  
  
  
  
  
 }
