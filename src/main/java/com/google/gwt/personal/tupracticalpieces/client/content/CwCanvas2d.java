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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesData;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesSource;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesStyle;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminTask;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminTaskAsync;
import com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch;
import com.google.gwt.resources.client.ImageResource;
//import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.Widget;

/**
 * Canvas2d - car mileagedata.
 */
@TUPracticalPiecesStyle({".graphColor", ".gra2D"})
public class CwCanvas2d extends ContentWidget {
  /**
   * A custom animation that moves a small image around a circle in an
   * {@link HorizontalPanel}.
   */
  @TUPracticalPiecesSource
  public static interface CwConstants extends Constants {
	String cwCanvas2dBlur();
	
	String cwCanvas2dBlurOff();

	String cwCanvas2dDescription();

    String cwCanvas2dDraw();
    
    String cwCanvas2dGraph1OptionColor();
    
    String cwCanvas2dGraph1OptionRed();
    
    String cwCanvas2dGraph1OptionGreen();
    
    String cwCanvas2dGraph1OptionBlue();

    String cwCanvas2dGraph1OptionYaxis();
    
    String cwCanvas2dGraph1OptionYaxisList();
    
    String cwCanvas2dGraph1OptionYKind();
    
    String cwCanvas2dGraph1OptionYKindList();
    
    String cwCanvas2dGraph1OptionYType();
    
    String cwCanvas2dGraph1OptionYTypeList();
   
    String cwCanvas2dGraph2OptionYaxis();
    
    String cwCanvas2dGraph2OptionYaxisList();
    
    String cwCanvas2dGraph2OptionYKind();
    
    String cwCanvas2dGraph2OptionYKindList();
    
    String cwCanvas2dGraph2OptionYType();
    
    String cwCanvas2dGraph2OptionYTypeList();
    
    String cwCanvas2dGraphOptionXPeriodStart();
    
    String cwCanvas2dGraphOptionXPeriodEnd();
    
    String cwCanvas2dName();
   
    String cwCanvas2dOptions();
  }
  
  /**
   * images that was used in this page.
   *
   * We will override the leaf image used in the tree. Instead of using a blank
   * 16x16 image, we will use a blank 1x1 image so it does not take up any
   * space. Each TreeItem will use its own custom image.
   */
  @TUPracticalPiecesSource
  public interface Images extends Tree.Resources {
    ImageResource arrowLeft();
  
    ImageResource arrowRight();
  
  }
  
  /**
   * RPC.
   */
  @TUPracticalPiecesData
  private final AdminTaskAsync adminTaskSvc = GWT.create(AdminTask.class);

  /**
   * Graph attributes.
   */
  @TUPracticalPiecesData
  private final int graWidth = 600;
  
  /**
   * Height of the canvas.
   */
  @TUPracticalPiecesData
  private 	final int graHeight = 400;
  
  /**
   * Guidance's graWidth of the canvas.
   */
  @TUPracticalPiecesData
  private 	final int graDepth = 60;
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private HTML canvas = null;
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private HTML canvasE = null;
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private HTML canvasW = null;
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private HTML canvasS = null;
  
  /**
   * The Graph 1 ListBox.
   */
  @TUPracticalPiecesData
  private ListBox graph1Option = new ListBox();
  
  /**
   * The Graph 1 Kind ListBox.
   */
  @TUPracticalPiecesData
  private HTML graph1OptionKind = null;
  
  /**
   * The Graph 1 Type ListBox.
   */
  @TUPracticalPiecesData
  private HTML graph1OptionType = null;

  /**
   * The end date of the graphs.
   */
  @TUPracticalPiecesData
  private Label graph1OptionColor = new Label();
  
  /**
   * The Graph 2 ListBox.
   */
  @TUPracticalPiecesData
  private ListBox graph2Option = new ListBox();
  
  /**
   * The Graph 2 Kind ListBox.
   */
  @TUPracticalPiecesData
  private HTML graph2OptionKind = null;
  
  /**
   * The Graph 2 Type ListBox.
   */
  @TUPracticalPiecesData
  private HTML graph2OptionType = null;

  /**
   * The end date of the graphs.
   */
  @TUPracticalPiecesData
  private Label graph2OptionColor =  new Label();
  
  /**
   * The start date of the graphs.
   */
  @TUPracticalPiecesData
  private HTML graphOptionStartDate = null;

  /**
   * The end date of the graphs.
   */
  @TUPracticalPiecesData
  private HTML graphOptionEndDate = null;
  
  /**
   * Draw the graph on the click.
   */
  @TUPracticalPiecesData
  private Button drawButton = new Button();

  /**
   * Clear the graph on the click.
   */
  @TUPracticalPiecesData
  private ToggleButton blurButton = null;

  /**
   * Draw the graph with a longer priod on the click.
   */
  @TUPracticalPiecesData
  private Image leftExtendButton = new Image();

  /**
   * Draw the graph with a shorter priod on the click.
   */
  @TUPracticalPiecesData
  private Image leftShrinkButton = new Image();

  /**
   * Draw the graph with a shorter priod on the click.
   */
  @TUPracticalPiecesData
  private Image rightShrinkButton = new Image();

  /**
   * Draw the graph with a longer priod on the click.
   */
  @TUPracticalPiecesData
  private Image rightExtendButton = new Image();

  /**
   * An instance of the constants.
   */
  @TUPracticalPiecesData
  private final CwConstants constants;
  
  /**
   * Constructor.
   *
   * @param constants the constants
   */
  public CwCanvas2d(CwConstants constants) {
    super(
        constants.cwCanvas2dName(), constants.cwCanvas2dDescription(), true);
    this.constants = constants;
  }
  
  /**
   * Initialize this example.
   */
  @TUPracticalPiecesSource
  @Override
  public Widget onInitialize() {
    // Add the components to a panel and return it
    HorizontalPanel mainLayout = new HorizontalPanel();
    mainLayout.setSpacing(10);
    // Create the options bar
    mainLayout.add(createOptionsBar());
    /*
	loadXmlInJava();
	*/
    // Create the custom canvas
    canvas = new HTML("<canvas id='gra' width=" + String.valueOf(graWidth) + " height=" + String.valueOf(graHeight) + "></canvas>");
    canvasE = new HTML("<canvas id='ver0' width=" + String.valueOf(graDepth) + " height=" + String.valueOf(graHeight) + "></canvas>");
    canvasW = new HTML("<canvas id='ver1' width=" + String.valueOf(graDepth) + " height=" + String.valueOf(graHeight) + "></canvas>");
    canvasS = new HTML("<canvas id='horz' width=" + String.valueOf(graWidth) + " height=" + String.valueOf(graDepth) + "></canvas>");
    // Get the images.
    Images images = (Images) GWT.create(Images.class);
  
    leftExtendButton.setResource(images.arrowLeft());
    leftExtendButton.setSize(graDepth / 2 + "px", graDepth + "px");
    leftExtendButton.addClickHandler(new ClickHandler() {
    	public void onClick(ClickEvent event) {
    		if (!drawButton.isEnabled()) {
    			return;
    		}
    		decDateStartInJava();}});
    leftShrinkButton.setResource(images.arrowRight());
    leftShrinkButton.setSize(graDepth / 2 + "px", graDepth + "px");
    leftShrinkButton.addClickHandler(new ClickHandler() {
    	public void onClick(ClickEvent event) {
    		if (!drawButton.isEnabled()) {
    			return;
    		}
    		incDateStartInJava();}});
    rightShrinkButton.setResource(images.arrowLeft());
    rightShrinkButton.setSize(graDepth / 2 + "px", graDepth + "px");
    rightShrinkButton.addClickHandler(new ClickHandler() {
    	public void onClick(ClickEvent event) {
    		if (!drawButton.isEnabled()) {
    			return;
    		}
    		decDateEndInJava();}});
    rightExtendButton.setResource(images.arrowRight());
    rightExtendButton.setSize(graDepth / 2 + "px", graDepth + "px");
    rightExtendButton.addClickHandler(new ClickHandler() {
    	public void onClick(ClickEvent event) {
    		if (!drawButton.isEnabled()) {
    			return;
    		}
    		incDateEndInJava();}});
  
    // Create a HorizontalPanel
    final HorizontalPanel graMainPanel = new HorizontalPanel();
    graMainPanel.setSpacing(0);
  
    // Add contents
    graMainPanel.add(canvasE);
    graMainPanel.add(canvas);
    graMainPanel.add(canvasW);
        
    // Create a panel to move components around
    HorizontalPanel bottom = new HorizontalPanel();
    bottom.setSpacing(0);
    bottom.add(leftExtendButton);
    bottom.add(leftShrinkButton);
    bottom.add(canvasS);
    bottom.add(rightShrinkButton);
    bottom.add(rightExtendButton);
    
    // Create a new panel
    VerticalPanel graPanel = new VerticalPanel();
    graPanel.setSpacing(0);

    // Add contents
    graPanel.add(graMainPanel);
    graPanel.add(bottom);
        
    mainLayout.add(graPanel);

  	loadMileageData();

    // Return the layout
    return mainLayout;
  }
  
  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
    GWT.runAsync(CwCanvas2d.class, new RunAsyncCallback() {
  
      public void onFailure(Throwable caught) {
        callback.onFailure(caught);
      }
  
      public void onSuccess() {
        callback.onSuccess(onInitialize());
      }
    });
  }
  
  /**
   * Create an options panel that allows users to select a widget and reposition
   * it.
   *
   * @return the new options panel
   */
  @TUPracticalPiecesSource
  private Widget createOptionsBar() {
    // Create a panel to move components around
    VerticalPanel optionsBar = new VerticalPanel();
    optionsBar.setSpacing(5);
    optionsBar.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
  
    // Add a title
    optionsBar.add(new HTML("<b>" + constants.cwCanvas2dOptions() + "</b>"));
  
    // Add option listboxes.
    optionsBar.add(new HTML(constants.cwCanvas2dGraph1OptionYaxis()));
  //    graph1Option = new HTML("<select class='gra2DListBoxLeft' id='graph1Option'/>");
    /*
    DOM.setElementAttribute(graph1Option.getElement(), "id", "graph1Option"); 
    DOM.setElementAttribute(graph1Option.getElement(), "class", "gra2DListBoxLeft"); 
    */
    graph1Option.getElement().setId("graph1Option"); 
    graph1Option.getElement().setClassName("gra2DListBoxLeft"); 
    graph1Option.addChangeHandler(new ChangeHandler() {
    	public void onChange(ChangeEvent event) {
    		setGraphColor(graph1OptionColor, graph1Option.getSelectedIndex());}});

    optionsBar.add(graph1Option);
    graph1OptionColor.setText(" graph color : ");
    optionsBar.add(graph1OptionColor);
    
    optionsBar.add(new HTML(constants.cwCanvas2dGraph1OptionYType()));
    graph1OptionType = new HTML("<select class='gra2DListBoxLeft' id='graph1OptionType'/>");
    optionsBar.add(graph1OptionType);
    
    optionsBar.add(new HTML(constants.cwCanvas2dGraph1OptionYKind()));
    graph1OptionKind = new HTML("<select class='gra2DListBoxLeft' id='graph1OptionKind'/>");
    optionsBar.add(graph1OptionKind);
    
    optionsBar.add(new HTML(constants.cwCanvas2dGraph2OptionYaxis()));
 //    graph2Option = new HTML("<select class='gra2DListBoxRight' id='graph2Option'/>");
    /*
    DOM.setElementAttribute(graph2Option.getElement(), "id", "graph2Option"); 
    DOM.setElementAttribute(graph2Option.getElement(), "class", "gra2DListBoxRight");
     */
    graph2Option.getElement().setId("graph2Option");
    graph2Option.getElement().setClassName("gra2DListBoxRight");
    graph2Option.addChangeHandler(new ChangeHandler() {
    	public void onChange(ChangeEvent event) {
    		setGraphColor(graph2OptionColor, graph2Option.getSelectedIndex());}});
    optionsBar.add(graph2Option);
    graph2OptionColor.setText(" graph color : ");
    optionsBar.add(graph2OptionColor);
   
    optionsBar.add(new HTML(constants.cwCanvas2dGraph2OptionYType()));
    graph2OptionType = new HTML("<select class='gra2DListBoxRight' id='graph2OptionType'/>");
    optionsBar.add(graph2OptionType);
    
    optionsBar.add(new HTML(constants.cwCanvas2dGraph2OptionYKind()));
    graph2OptionKind = new HTML("<select class='gra2DListBoxRight' id='graph2OptionKind'/>");
    optionsBar.add(graph2OptionKind);
    
    optionsBar.add(new HTML(constants.cwCanvas2dGraphOptionXPeriodStart()));
    graphOptionStartDate = new HTML("<select class='gra2DListBoxBottom' id='graphOptionStartDate'/>");
    optionsBar.add(graphOptionStartDate);
    
    optionsBar.add(new HTML(constants.cwCanvas2dGraphOptionXPeriodEnd()));
    graphOptionEndDate = new HTML("<select class='gra2DListBoxBottom' id='graphOptionEndDate'/>");
    optionsBar.add(graphOptionEndDate);
    
    // Add start button
    drawButton.addStyleName("sc-FixedWidthButton");
    drawButton.setText(constants.cwCanvas2dDraw());
    drawButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
    	  drawGraphInJava();
      }
    });
    optionsBar.add(drawButton);
    // Add cancel button
//    blurButton.addStyleName("sc-FixedWidthButton");
//    blurButton.addClickHandler(new ClickHandler() {
//      public void onClick(ClickEvent event) {
//    	  clearGraphInJava(false);
//      }
//    });
    blurButton = new ToggleButton("Up", constants.cwCanvas2dBlurOff());
    blurButton.setText(constants.cwCanvas2dBlur());
    blurButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
    	  if (blurButton.isDown()) {
    		  setBlurInJava(true);
    	  } else {
    		  setBlurInJava(true);
    	  }
      }
    });
    optionsBar.add(blurButton);
    
    // Return the options bar
    return optionsBar;
  }
  
  /**
   * Create an options panel that allows users to select a widget and reposition
   * it.
   *
   * @return the new options panel
   */
  @TUPracticalPiecesSource
  private void setOptions() {
	    setgraph1OptionInJava(constants.cwCanvas2dGraph1OptionYaxisList());
	    setGraphColor(graph1OptionColor, graph1Option.getSelectedIndex());
	    setgraph1OptionTypeInJava(constants.cwCanvas2dGraph1OptionYTypeList());
	    setgraph1OptionKindInJava(constants.cwCanvas2dGraph1OptionYKindList());
	    setgraph2OptionInJava(constants.cwCanvas2dGraph2OptionYaxisList());
	    setGraphColor(graph2OptionColor, graph2Option.getSelectedIndex());
	    setgraph2OptionTypeInJava(constants.cwCanvas2dGraph2OptionYTypeList());
	    setgraph2OptionKindInJava(constants.cwCanvas2dGraph2OptionYKindList());
	    setgraphOptionStartDateInJava();
	    setgraphOptionEndDateInJava();
  }  
   
  /**
   * Create an options panel that allows users to select a widget and reposition
   * it.
   *
   * @return the new options panel
   */
  @TUPracticalPiecesSource
  private void setGraphColor(Label lb, int idx) {
	  String styleName = "";
	  String colorName = "";
	  switch (idx) {
	  case 0:
		  styleName = "graphColorFirst";
		  colorName = constants.cwCanvas2dGraph1OptionRed();
		  break;
	  case 1:
		  styleName = "graphColorSecond";
		  colorName = constants.cwCanvas2dGraph1OptionGreen();
		  break;
	  case 2:
		  styleName = "graphColorThird";
		  colorName = constants.cwCanvas2dGraph1OptionBlue();
		  break;
	  default:
		  break;
	  }
	  lb.setText(constants.cwCanvas2dGraph1OptionColor() + " : " + colorName);
	  lb.setStyleName(styleName);
  }  
  
  
  /**
   * Load Mileage Data from JDO to store in Json.
   * it.
   *
   * @return the new options panel
   */
  @TUPracticalPiecesSource
  private void loadMileageData() {
    AsyncCallback<ResultFetch> callback = new AsyncCallback<ResultFetch>() {
		      public void onFailure(Throwable caught) {
		    	String wedgeStr = "<ol style='list-style-type: disc'>";
		    	wedgeStr += "<li>RPC failure.</li>";
		    	wedgeStr += "<li>Throwable: " + caught.toString() + ".</li>";
		    	wedgeStr += "</ol>";
		    	Window.alert(wedgeStr);
		      }
		      public void onSuccess(ResultFetch result) {
		    	if (result.getResult()) {
		    	    setJsonDataInJava(result.getText());
		            clearGraphInJava(false);
		            setOptions();
		    	} else {
			    	String wedgeStr = "<ol style='list-style-type: disc'>";
			    	wedgeStr += "<li>" + "Fail to get JSON from JDO." + "</li>";
			    	wedgeStr += "<li>" + result.getText() + "</li>";
			    	wedgeStr += "</ol>";
			    	Window.alert(wedgeStr);
		    	}
		      }
		    };
	adminTaskSvc.fetchMileageData("", callback);
  }  
  
  /**
   * JS function call. Load data xml file.
   */
  @TUPracticalPiecesSource
  public static native void setJsonDataInJava(String jsondata) /*-{
  	$wnd.setMileageData(jsondata);
  }-*/;
 
  
  /**
   * JS function call. Increase the period to retreat the start date of the graph.
   */
  @TUPracticalPiecesSource
  public static native void decDateStartInJava() /*-{
    $wnd.decDateStart();
  }-*/;
  
  /**
   * JS function call. Decrease the period to progress the start date of the graph.
   */
  @TUPracticalPiecesSource
  public static native void incDateStartInJava() /*-{
    $wnd.incDateStart();
  }-*/;
  
  /**
   * JS function call. Decrease the period to retreat the end date of the graph.
   */
  @TUPracticalPiecesSource
  public static native void decDateEndInJava() /*-{
    $wnd.decDateEnd();
  }-*/;
  
  /**
   * JS function call. Increase the period to progress the end date of the graph.
   */
  @TUPracticalPiecesSource
  public static native void incDateEndInJava() /*-{
    $wnd.incDateEnd();
  }-*/;
  
  /**
   * JS function call. set graph1Option options.
   *
   * @param ss Option items.
   */
  @TUPracticalPiecesSource
  public static native void setgraph1OptionInJava(String ss) /*-{
    $wnd.setgraph1Option(ss);
  }-*/;
  
  /**
   * JS function call. set graph1OptionType options.
   *
   * @param ss Option items.
   */
  @TUPracticalPiecesSource
  public static native void setgraph1OptionTypeInJava(String ss) /*-{
    $wnd.setgraph1OptionType(ss);
  }-*/;
  
  /**
   * JS function call.  set graph1OptionKind options.
   *
   * @param ss Option items.
   */
  @TUPracticalPiecesSource
  public static native void setgraph1OptionKindInJava(String ss) /*-{
    $wnd.setgraph1OptionKind(ss);
  }-*/;
  
  /**
   * JS function call.  set graph2Option options.
   *
   * @param ss Option items.
   */
  @TUPracticalPiecesSource
  public static native void setgraph2OptionInJava(String ss) /*-{
    $wnd.setgraph2Option(ss);
  }-*/;
  
  /**
   * JS function call.  set graph2OptionType options.
   *
   * @param ss Option items.
   */
  @TUPracticalPiecesSource
  public static native void setgraph2OptionTypeInJava(String ss) /*-{
    $wnd.setgraph2OptionType(ss);
  }-*/;
  
  /**
   * JS function call.  set graph2OptionKind options.
   *
   * @param ss Option items.
   */
  @TUPracticalPiecesSource
  public static native void setgraph2OptionKindInJava(String ss) /*-{
    $wnd.setgraph2OptionKind(ss);
  }-*/;
  
  /**
   * JS function call. modeling .
   */
  @TUPracticalPiecesSource
  public static native void setgraphOptionStartDateInJava() /*-{
    $wnd.setgraphOptionStartDate();
  }-*/;
  
  /**
   * JS function call. modeling .
   */
  @TUPracticalPiecesSource
  public static native void setgraphOptionEndDateInJava() /*-{
    $wnd.setgraphOptionEndDate();
  }-*/;
  
  /**
   * JS function call. modeling .
   */
  @TUPracticalPiecesSource
  public static native void drawGraphInJava() /*-{
    $wnd.drawGraph();
  }-*/;
  
  /**
   * JS function call. modeling .
   *
   * @param isBlur whether to render the previous canvas to blur or not.
   */
  @TUPracticalPiecesSource
  public static native void clearGraphInJava(boolean isBlur) /*-{
    $wnd.clearGraph(isBlur);
  }-*/;
  
  /**
   * JS function call. modeling .
   *
   * @param isBlur whether to render the previous canvas to blur or not.
   */
  @TUPracticalPiecesSource
  public static native void setBlurInJava(boolean isBlur) /*-{
    $wnd.setBlur(isBlur);
  }-*/;
  
}