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
//import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * Canvas3d - Koach 3d extended.
 */
@TUPracticalPiecesStyle({"input", ".sliderValue"})
public class CwCanvas3d extends ContentWidget {
  @TUPracticalPiecesSource
  public static interface CwConstants extends Constants {
	String cwCanvas3dStop();

	String cwCanvas3dDescription();

    String cwCanvas3dStart();
    
    String cwCanvas3dName();
    /** 20130416 slider(range) */
    String cwCanvas3dOptionInterval();
    /** 20130416 slider(range) */
    String cwCanvas3dOptionRotation();
    
    String cwCanvas3dOptions();
  }
  
  /**
   * Graph attributes.
   */
  @TUPracticalPiecesData
  private final int graWidth = 400;
  
  /**
   * Height of the canvas.
   */
  @TUPracticalPiecesData
  private final int graHeight = 320;
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private HTML canvas = null;
    
  /**
   * The recursive level slider.
  */
  @TUPracticalPiecesData
  private TextBox sliderRecursiveLevel = new TextBox();
  /**
   * The Rotation slider.
  */
  @TUPracticalPiecesData
  private TextBox sliderRotation = new TextBox();
  /**
  * The recursive level slider.
  */
  @TUPracticalPiecesData
  private TextBox sliderInterval = new TextBox();
  /**
   * stop the graph on the click.
   */
  @TUPracticalPiecesData
  private Button stopButton = new Button();
  /**
   * start the graph on the click.
   */
  @TUPracticalPiecesData
  private Button startButton = new Button();
  /**
  * Level in drawing.
  */
  @TUPracticalPiecesData
  private int previousLevel = 0;
  
  /**
  * Redraw timer.
  */
  @TUPracticalPiecesData
  private Timer timer = new Timer () {
	  @Override
	  public void run() {
		 drawSceneInJava();
	 }
  };
  /**
   * whether the first invoking or not.
   */
  @TUPracticalPiecesData
  private boolean isFirst = true;
      
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
  public CwCanvas3d(CwConstants constants) {
    super(
        constants.cwCanvas3dName(), constants.cwCanvas3dDescription(), true);
    this.constants = constants;
  }
  
  /**
   * Initialize this example.
   */
  @TUPracticalPiecesSource
  @Override
  public Widget onInitialize() {
	  //XXX javascript
	startButton.setText(constants.cwCanvas3dStart());
	startButton.setEnabled(true);
	startButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	    	/** 20130710 */
	    	startButton.setEnabled(false);
	    	stopButton.setEnabled(true);
	        startDraw();
	      }
	    });
	stopButton.setText(constants.cwCanvas3dStop());
	stopButton.setEnabled(false);
	stopButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	    	/** 20130710 */
         	startButton.setEnabled(true);
        	stopButton.setEnabled(false);
	        stopRotating();
	      }
	    });
	VerticalPanel consolePanel = new VerticalPanel();
    consolePanel.add(startButton);
    consolePanel.add(stopButton);
    consolePanel.add(new HTML(constants.cwCanvas3dOptions()));
    /**
    consolePanel.add(new HTML("<input type='range' id='rangeRecursiveLevel' onchange='changeRecursiveLevel()' min='0' max='9' step='1' value='0'><span class='sliderValue' id='rangeRecursiveLevelValue'></span>"));
    consolePanel.add(new HTML("<span class='sliderValue' id='polygonNum'></span><span class='sliderValue'> polygons</span>"));
    consolePanel.add(new HTML(constants.cwCanvas3dOptionRotation()));
    consolePanel.add(new HTML("<input type='range' id='rangeRotation' onchange='changeRotation()' min='0' max='90' step='1' value='45'><span class='sliderValue' id='rangeRotationValue'></span>"));
    consolePanel.add(new HTML(constants.cwCanvas3dOptionInterval()));
    consolePanel.add(new HTML("<input type='range' id='rangeInterval' onchange='changeInterval()' min='300' max='2000' step='100' value='1000'><span class='sliderValue' id='rangeIntervalValue'></span>"));
     */
    /*
    DOM.setElementAttribute(sliderRecursiveLevel.getElement(), "id", "rangeRecursiveLevel"); 
    DOM.setElementAttribute(sliderRecursiveLevel.getElement(), "type", "range");
    DOM.setElementAttribute(sliderRecursiveLevel.getElement(), "min", "0");
    DOM.setElementAttribute(sliderRecursiveLevel.getElement(), "max", "9");
    DOM.setElementAttribute(sliderRecursiveLevel.getElement(), "step", "1");
    DOM.setElementAttribute(sliderRecursiveLevel.getElement(), "value", "0");
	*/
    sliderRecursiveLevel.getElement().setId("rangeRecursiveLevel");
    sliderRecursiveLevel.getElement().setAttribute("type","range");
    sliderRecursiveLevel.getElement().setAttribute("min","0");
    sliderRecursiveLevel.getElement().setAttribute("max","9");
    sliderRecursiveLevel.getElement().setAttribute("step","1");
    sliderRecursiveLevel.getElement().setAttribute("value","0");
    sliderRecursiveLevel.addChangeHandler(new ChangeHandler() {
    	public void onChange(ChangeEvent event) {
    		changeRecursiveLevelinJavaPrev();}});
    /*
    DOM.setElementAttribute(sliderRotation.getElement(), "id", "rangeRotation");
    DOM.setElementAttribute(sliderRotation.getElement(), "type", "range");
    DOM.setElementAttribute(sliderRotation.getElement(), "min", "0");
    DOM.setElementAttribute(sliderRotation.getElement(), "max", "90");
    DOM.setElementAttribute(sliderRotation.getElement(), "step", "1");
    DOM.setElementAttribute(sliderRotation.getElement(), "value", "30");
    */
    sliderRotation.getElement().setId("rangeRotation");
    sliderRotation.getElement().setAttribute("type","range");
    sliderRotation.getElement().setAttribute("min","0");
    sliderRotation.getElement().setAttribute("max","90");
    sliderRotation.getElement().setAttribute("step","1");
    sliderRotation.getElement().setAttribute("value","30");
    sliderRotation.addChangeHandler(new ChangeHandler() {
    	public void onChange(ChangeEvent event) {
    		changeRotationinJavaPrev();}});
    /*
    DOM.setElementAttribute(sliderInterval.getElement(), "id", "rangeInterval");
    DOM.setElementAttribute(sliderInterval.getElement(), "type", "range");
    DOM.setElementAttribute(sliderInterval.getElement(), "min", "300");
    DOM.setElementAttribute(sliderInterval.getElement(), "max", "2000");
    DOM.setElementAttribute(sliderInterval.getElement(), "step", "100");
    DOM.setElementAttribute(sliderInterval.getElement(), "value", "1000");
    */
    sliderInterval.getElement().setId("rangeInterval");
    sliderInterval.getElement().setAttribute("type","range");
    sliderInterval.getElement().setAttribute("min","300");
    sliderInterval.getElement().setAttribute("max","2000");
    sliderInterval.getElement().setAttribute("step","100");
    sliderInterval.getElement().setAttribute("value","1000");
    sliderInterval.addChangeHandler(new ChangeHandler() {
    	public void onChange(ChangeEvent event) {
    		changeIntervalinJavaPrev();}});
    consolePanel.add(sliderRecursiveLevel);
    consolePanel.add(new HTML("<span class='sliderValue' id='rangeRecursiveLevelValue'></span>"));
    consolePanel.add(new HTML("<span class='sliderValue' id='polygonNum'></span><span class='sliderValue'> polygons</span>"));
    consolePanel.add(new HTML(constants.cwCanvas3dOptionRotation()));
    consolePanel.add(sliderRotation);
    consolePanel.add(new HTML("<span class='sliderValue' id='rangeRotationValue'></span>"));
    consolePanel.add(new HTML(constants.cwCanvas3dOptionInterval()));
    consolePanel.add(sliderInterval);
    consolePanel.add(new HTML("<span class='sliderValue' id='rangeIntervalValue'></span>"));
      
    canvas = new HTML("<canvas id='gra' width=" + String.valueOf(graWidth) + " height=" + String.valueOf(graHeight) + "></canvas>");
    HorizontalPanel mainLayout = new HorizontalPanel();
    mainLayout.setSpacing(10);
    mainLayout.add(consolePanel);
    mainLayout.add(canvas);      
    return mainLayout;
  }
  
  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
    GWT.runAsync(CwCanvas3d.class, new RunAsyncCallback() {
    
      public void onFailure(Throwable caught) {
        callback.onFailure(caught);
      }
  
      public void onSuccess() {
        callback.onSuccess(onInitialize());
        /** 20130416 slider(range) */
        initSelectorInJava();
      }
    });
  }
  
  /**
   * start the graphs.
   */
  @TUPracticalPiecesSource
  private void startDraw() {
    if (isFirst) {
    	if (!initGlInJava()) {
    		startButton.setEnabled(false);
    		stopButton.setEnabled(false);
    		return;
    	}
		isFirst = false;
    }
	if (getRecursiveLevelInJava() != previousLevel) {
		previousLevel = getRecursiveLevelInJava(); 
	    modelingInJava(getRecursiveLevelInJava());
	}
    timer.scheduleRepeating(getIntervalInJava());
  }
  
  /**
   * Stop rotation.
   */
  @TUPracticalPiecesSource
  private void stopRotating() {
	startButton.setEnabled(true);
	stopButton.setEnabled(false);
    timer.cancel();
  }
  
  /**
   * Redraw
   */
  @TUPracticalPiecesSource
  private void changeRecursiveLevelinJavaPrev() {
	changeRecursiveLevelinJava();
	if (startButton.isEnabled() == true) {
		return;
	}
	if (stopButton.isEnabled() == false) {
		return;
	}
	timer.cancel();
	startDraw();
  }
  /**
   * Redraw
   */
  @TUPracticalPiecesSource
  private void changeRotationinJavaPrev() {
	changeRotationinJava();
	if (startButton.isEnabled() == true) {
		return;
	}
	if (stopButton.isEnabled() == false) {
		return;
	}
	timer.cancel();
	startDraw();
  }
  /**
   * Redraw
   */
  @TUPracticalPiecesSource
  private void changeIntervalinJavaPrev() {
	changeIntervalinJava();
	if (startButton.isEnabled() == true) {
		return;
	}
	if (stopButton.isEnabled() == false) {
		return;
	}
	timer.cancel();
	startDraw();
  }
  
  /**
   * JS function call. Initialize WebGL canvas and create the form and color of the model .
   *
   * @return whether to success or not.
   */
  @TUPracticalPiecesSource
  public static native boolean initGlInJava() /*-{
  	return $wnd.initGl();
  }-*/;
  
  /**
   * JS function call. modeling .
   *
   * @param level recursive level
   */
  @TUPracticalPiecesSource
  public static native void modelingInJava(int level) /*-{
  	$wnd.modeling(level);
  }-*/;
  
  /**
   * JS function call. Create view. {JavaScript Native Interface (JSNI)}
   * 
   */
  @TUPracticalPiecesSource
  public static native void drawSceneInJava() /*-{
	$wnd.drawScene();
  }-*/;
  
  /**
   * JS function call. Increase rotation angle.
   *  20130416 slider(range)
   */
  @TUPracticalPiecesSource
  public static native int getIntervalInJava() /*-{
	return $wnd.getInterval();
  }-*/;
  
  /**
   * JS function call. Increase rotation angle.
   *  20130416 slider(range)
   */
  @TUPracticalPiecesSource
  public static native int getRecursiveLevelInJava() /*-{
	return $wnd.getRecursiveLevel();
  }-*/;
  
  /**
   * JS function call. Increase rotation angle.
   *  20130416 slider(range)
   */
  @TUPracticalPiecesSource
  public static native void initSelectorInJava() /*-{
	$wnd.changeRecursiveLevel();
	$wnd.changeRotation();
	$wnd.changeInterval();
  }-*/;
  
  /**
   * JS function call. onchange handler in java.
   *  20130710 slider(range)
   */
  @TUPracticalPiecesSource
  public static native void changeRecursiveLevelinJava() /*-{
	$wnd.changeRecursiveLevel();
  }-*/;
  /**
   * JS function call. onchange handler in java.
   *  20130710 slider(range)
   */
  @TUPracticalPiecesSource
  public static native void changeRotationinJava() /*-{
	$wnd.changeRotation();
  }-*/;
  /**
   * JS function call. onchange handler in java.
   *  20130710 slider(range)
   */
  @TUPracticalPiecesSource
  public static native void changeIntervalinJava() /*-{
	$wnd.changeInterval();
  }-*/;
}
