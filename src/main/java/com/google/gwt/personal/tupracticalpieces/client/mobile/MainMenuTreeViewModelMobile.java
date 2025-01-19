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
//package com.google.gwt.personal.tupracticalpieces.client;
package com.google.gwt.personal.tupracticalpieces.client.mobile;

import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.TreeViewModel;


import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesConstants;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;

import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.TreeViewModel;
//import com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView;
import com.google.gwt.personal.tupracticalpieces.client.content.CwCanvas2d;
import com.google.gwt.personal.tupracticalpieces.client.content.CwCanvas3d;
import com.google.gwt.personal.tupracticalpieces.client.content.CwColumn;
import com.google.gwt.personal.tupracticalpieces.client.content.CwFrame;
import com.google.gwt.personal.tupracticalpieces.client.content.CwMethod;
import com.google.gwt.personal.tupracticalpieces.client.content.CwMethod2;
import com.google.gwt.personal.tupracticalpieces.client.content.CwNotes;
import com.google.gwt.personal.tupracticalpieces.client.content.CwPreface;
import com.google.gwt.personal.tupracticalpieces.client.content.CwPrimeNumberFrequencyByModulo;
import com.google.gwt.personal.tupracticalpieces.client.content.CwUpdate;
import com.google.gwt.personal.tupracticalpieces.client.content.CwXFrame;
import com.google.gwt.personal.tupracticalpieces.client.content.CwMashup2;
import com.google.gwt.personal.tupracticalpieces.client.desktop.MainMenuTreeViewModelDesktop.Category;
import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditView;
// import com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageReadView;
import com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileageSuperView;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.prefetch.RunAsyncCode;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;


/**
 * The {@link TreeViewModel} used by the main menu.
 */
//public class MainMenuTreeViewModel implements TreeViewModel {
public class MainMenuTreeViewModelMobile implements TreeViewModel {

	  private CwUpdate cwUpdate;

	  /**
	   * The constants used in the menu.
	   */
	  //@Override
	  public static interface MenuConstants extends Constants {
	    String categoryAboutThisPage();
	    String categoryHtml5canvas();
	    String categoryAdministrative();
//	    String subCategoryAdminMileage();
	    
	  }

	  /**
	   * The cell used to render categories.
	   */
	  private static class CategoryCell extends AbstractCell<Category> {
	    @Override
	    public void render(Context context, Category value, SafeHtmlBuilder sb) {
	      if (value != null) {
	        sb.appendEscaped(value.getName());
	      }
	    }
	  }
	  
	  /**
	   * The cell used to render examples.
	   */
	  private static class ContentWidgetCell extends AbstractCell<ContentWidget> {
	    @Override
	    public void render(Context context, ContentWidget value, SafeHtmlBuilder sb) {
	      if (value != null) {
	        sb.appendEscaped(value.getName());
	      }
	    }
	  }

	  /**
	   * A top level category in the tree.
	   */
	  public class Category {

	    private final ListDataProvider<ContentWidget> examples =
	        new ListDataProvider<ContentWidget>();
	    private final String name;
	    private NodeInfo<ContentWidget> nodeInfo;
	    private final List<RunAsyncCode> splitPoints =
	        new ArrayList<RunAsyncCode>();

	    public Category(String name) {
	      this.name = name;
	    }

	    public void addExample(ContentWidget example, RunAsyncCode splitPoint) {
	      examples.getList().add(example);
	      if (splitPoint != null) {
	        splitPoints.add(splitPoint);
	      }
	      contentCategory.put(example, this);
	      contentToken.put(TUPracticalPiecesShellMobile.getContentWidgetToken(example), example);
	    }

	    public String getName() {
	      return name;
	    }

	    /**
	     * Get the node info for the examples under this category.
	     * 
	     * @return the node info
	     */
	    public NodeInfo<ContentWidget> getNodeInfo() {
	      if (nodeInfo == null) {
	        nodeInfo = new DefaultNodeInfo<ContentWidget>(examples,
	            contentWidgetCell, selectionModel, null);
	      }
	      return nodeInfo;
	    }

	    /**
	     * Get the list of split points to prefetch for this category.
	     * 
	     * @return the list of classes in this category
	     */
	    public Iterable<RunAsyncCode> getSplitPoints() {
	      return splitPoints;
	    }
	  }


	  /**
	   * The top level categories.
	   */
	  private final ListDataProvider<Category> categories = new ListDataProvider<Category>();

	  /**
	   * A mapping of {@link ContentWidget}s to their associated categories.
	   */
	  private final Map<ContentWidget, Category> contentCategory = new HashMap<ContentWidget, Category>();

	  /**
	   * The cell used to render examples.
	   */
	  private final ContentWidgetCell contentWidgetCell = new ContentWidgetCell();

	  /**
	   * A mapping of history tokens to their associated {@link ContentWidget}.
	   */
	  private final Map<String, ContentWidget> contentToken = new HashMap<String, ContentWidget>();

	  /**
	   * The selection model used to select examples.
	   */
	  private final SelectionModel<ContentWidget> selectionModel;

	  //public MainMenuTreeViewModelMobile(TUPracticalPiecesConstants constants,
	  //      SelectionModel<ContentWidget> selectionModel, AdminMileageView adminViewMileage) {
	  public MainMenuTreeViewModelMobile(TUPracticalPiecesConstants constants,
			  SelectionModel<ContentWidget> selectionModel, CwUpdate cwUpdate) {
		    this.selectionModel = selectionModel;
		    //initializeTree(constants, adminViewMileage);
		    initializeTree(constants);
		    this.cwUpdate = cwUpdate;
	  }
//	  public MainMenuTreeViewModelMobile(TUPracticalPiecesConstants constants,
//	      SelectionModel<ContentWidget> selectionModel) {
//	    this.selectionModel = selectionModel;
//	    initializeTree(constants);
//	  }

	  /**
	   * Get the {@link Category} associated with a widget.
	   * 
	   * @param widget the {@link ContentWidget}
	   * @return the associated {@link Category}
	   */
	  public Category getCategoryForContentWidget(ContentWidget widget) {
	    return contentCategory.get(widget);
	  }

	  /**
	   * Get the content widget associated with the specified history token.
	   * 
	   * @param token the history token
	   * @return the associated {@link ContentWidget}
	   */
	  public ContentWidget getContentWidgetForToken(String token) {
	    return contentToken.get(token);
	  }

	  public <T> NodeInfo<?> getNodeInfo(T value) {
	    if (value == null) {
	      // Return the top level categories.
	      return new DefaultNodeInfo<Category>(categories, new CategoryCell());
	    } else if (value instanceof Category) {
	      // Return the examples within the category.
	      Category category = (Category) value;
	      return category.getNodeInfo();
	    }
	    return null;
	  }

	  public boolean isLeaf(Object value) {
	    return value != null && !(value instanceof Category);
	  }

	  /**
	   * Get the set of all {@link ContentWidget}s used in the model.
	   * 
	   * @return the {@link ContentWidget}s
	   */
	  Set<ContentWidget> getAllContentWidgets() {
	    Set<ContentWidget> widgets = new HashSet<ContentWidget>();
	    for (Category category : categories.getList()) {
	      for (ContentWidget example : category.examples.getList()) {
	        widgets.add(example);
	      }
	    }
	    return widgets;
	  }

	  /**
	   * Initialize the top level categories in the tree.
	   */
	  private void initializeTree(TUPracticalPiecesConstants constants) {
//	  private void initializeTree(TUPracticalPiecesConstants constants, AdminMileageView adminViewMileage) {
	    List<Category> catList = categories.getList();

	    // about this page.
	    {
	      Category category = new Category(constants.categoryAboutThisPage());
	      catList.add(category);
	      // CwCheckBox is the default example, so don't prefetch it.
	      category.addExample(new CwPreface(constants), null);
	      category.addExample(new CwMethod(constants), null);
	      category.addExample(new CwMethod2(constants), null);
	      category.addExample(new CwNotes(constants), null);
	    }

	    // HTML5 canvas.
	    {
	      Category category = new Category(constants.categoryHtml5canvas());
	      catList.add(category);
	      
	      category.addExample(new CwCanvas2d(constants),
	              RunAsyncCode.runAsyncCode(CwCanvas2d.class));
	      category.addExample(new CwCanvas3d(constants),
	              RunAsyncCode.runAsyncCode(CwCanvas3d.class));
	      category.addExample(new CwColumn(constants),
	              RunAsyncCode.runAsyncCode(CwColumn.class));
	      category.addExample(new CwPrimeNumberFrequencyByModulo(constants),
	              RunAsyncCode.runAsyncCode(CwColumn.class));
/* 2024 remove due to reduce charge of ddos
	      category.addExample(new CwFrame(constants),
	              RunAsyncCode.runAsyncCode(CwFrame.class));
*/
	      }


	    // admin.
	    {
	      Category category = new Category(constants.categoryAdministrative());
	      catList.add(category);
	      
	      
	      
//	      category.addExample(new CwUpdate(constants),
//	              RunAsyncCode.runAsyncCode(CwUpdate.class));
	      category.addExample(cwUpdate,
	              RunAsyncCode.runAsyncCode(CwUpdate.class));
//
//		   adminViewMileage = new AdminMileageView(constants);
////		addExample("AdminMileageView", adminViewMileage,
////	        RunAsyncCode.runAsyncCode(AdminMileageView.class), category3);
//		  category.addExample(adminViewMileage,
//	        RunAsyncCode.runAsyncCode(AdminMileageView.class));
	   

//	      //sub category 
//	      {
//	          Category subcategory = new Category(constants.subCategoryAdminMileage());
//	          catList.add(subcategory);
//	          
//		   adminViewMileage = new AdminMileageView(constants);
////		addExample("AdminMileageView", adminViewMileage,
////	        RunAsyncCode.runAsyncCode(AdminMileageView.class), category3);
//		   subcategory.addExample(adminViewMileage,
//	        RunAsyncCode.runAsyncCode(AdminMileageView.class));
//		  
//	      adminEditMileage = new AdminMileageEditView(constants);
//	      subcategory.addExample(adminEditMileage,
//			        RunAsyncCode.runAsyncCode(AdminMileageEditView.class));
//	      adminReadMileage = new AdminMileageReadView(constants);
//	      subcategory.addExample(adminReadMileage,
//			        RunAsyncCode.runAsyncCode(AdminMileageReadView.class));
//		    	  
//		    	  
//		    	  
//		      }
		   
//		   category.addExample(new AdminMileageView(constants),
//			   		RunAsyncCode.runAsyncCode(AdminMileageView.class));
         
//	   adminViewMileage = new AdminMileageView(constants);
////	addExample("AdminMileageView", adminViewMileage,
////        RunAsyncCode.runAsyncCode(AdminMileageView.class), category3);
//	    category.addExample(adminViewMileage,
//        RunAsyncCode.runAsyncCode(AdminMileageView.class));
	  
		  
		  
		  
	      category.addExample(new CwXFrame(constants),
	              RunAsyncCode.runAsyncCode(CwXFrame.class));
// 20170822
	      category.addExample(new CwMashup2(constants),
	              RunAsyncCode.runAsyncCode(CwMashup2.class));
	    }
	  }
	  
		
	public ContentWidget getFirstContentWidget() {
			return contentToken.get("!CwPreface");
	}
	

    public int indexOf(Category cat) {
    	return categories.getList().indexOf(cat);
    }
		
	
}
	//  //private void initializeTree(TUPracticalPiecesConstants constants) {
	//  public void initilize(TUPracticalPiecesConstants constants) {
//			 List<Category> catList = getCategories().getList();
//			
//			 // about this page.
//			 //{
//			   //Category category = new Category(constants.categoryAboutThisPage());
//			   Category category1 = new Category(constants.categoryAboutThisPage());
//			   catList.add(category1);
//			   // CwCheckBox is the default example, so don't prefetch it.
//			//   category.addExample(new CwPreface(constants), null);
//			//   category.addExample(new CwMethod(constants), null);
//			//   category.addExample(new CwMethod2(constants), null);
//			//   category.addExample(new CwNotes(constants), null);
//			//   CwPreface cwpreface =  new CwPreface(constants);
//			   addExample("CwPreface", new CwPreface(constants), null, category1);
//			//   CwMethod cwmethod =  new CwMethod(constants);
//			   addExample("CwMethod", new CwMethod(constants),
//			           RunAsyncCode.runAsyncCode(CwMethod.class), category1);
//			   addExample("CwMethod2", new CwMethod2(constants),
//			   			RunAsyncCode.runAsyncCode(CwMethod2.class), category1);
//			   addExample("CwNotes", new CwNotes(constants),
//		       			RunAsyncCode.runAsyncCode(CwNotes.class), category1);
//			 //}
//			
//			 // HTML5 canvas.
//			 //{
//			   Category category2 = new Category(constants.categoryHtml5canvas());
//			   catList.add(category2);
//			   
//			//   category.addExample(new CwCanvas2d(constants),
//			//           RunAsyncCode.runAsyncCode(CwCanvas2d.class));
//			//   category.addExample(new CwCanvas3d(constants),
//			//           RunAsyncCode.runAsyncCode(CwCanvas3d.class));
//			//   category.addExample(new CwColumn(constants),
//			//           RunAsyncCode.runAsyncCode(CwColumn.class));
//			//   category.addExample(new CwPrimeNumberFrequencyByModulo(constants),
//			//           RunAsyncCode.runAsyncCode(CwColumn.class));
//			//   category.addExample(new CwFrame(constants),
//			//           RunAsyncCode.runAsyncCode(CwFrame.class));
//			   addExample("CwCanvas2d", new CwCanvas2d(constants),
//			           RunAsyncCode.runAsyncCode(CwCanvas2d.class), category2);
//			   addExample("CwCanvas3d", new CwCanvas3d(constants),
//			           RunAsyncCode.runAsyncCode(CwCanvas3d.class), category2);
//			   addExample("CwColumn", new CwColumn(constants),
//			           RunAsyncCode.runAsyncCode(CwColumn.class), category2);
//			   addExample("CwPrimeNumberFrequencyByModulo", new CwPrimeNumberFrequencyByModulo(constants),
//			           RunAsyncCode.runAsyncCode(CwPrimeNumberFrequencyByModulo.class), category2);
//			   addExample("CwFrame", new CwFrame(constants),
//			           RunAsyncCode.runAsyncCode(CwFrame.class), category2);
//			   //}
//			
//			
//			 // admin.
//			 //{
//			   Category category3 = new Category(constants.categoryAdministrative());
//			   catList.add(category3);
//			   
//			//   category.addExample(new CwUpdate(constants),
//			//           RunAsyncCode.runAsyncCode(CwUpdate.class));
//			//   
//			//   category.addExample(new CwXFrame(constants),
//			//           RunAsyncCode.runAsyncCode(CwXFrame.class));
////			   addExample("CwUpdate", new CwUpdate(constants),
////			           RunAsyncCode.runAsyncCode(CwUpdate.class), category3);
////			   
////			   addExample("CwXFrame", new CwXFrame(constants),
////			           RunAsyncCode.runAsyncCode(CwXFrame.class), category3);
//			   /* temporary to implement eventbus, place, so on. */
//			   adminViewMileage = new AdminMileageView(constants);
//		       addExample("AdminMileageView", adminViewMileage,
//	               RunAsyncCode.runAsyncCode(AdminMileageView.class), category3);
	//   
//	           addExample("CwXFrame", new CwXFrame(constants),
//	               RunAsyncCode.runAsyncCode(CwXFrame.class), category3);
//			 //}
//			}
	//
	//  }

