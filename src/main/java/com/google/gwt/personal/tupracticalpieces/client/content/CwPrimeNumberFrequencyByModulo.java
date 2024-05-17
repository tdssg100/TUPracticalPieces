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

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesData;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesSource;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesStyle;
//import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
/**
 * Prime Number Frequency By Modulo - car mileagedata.
 */
@TUPracticalPiecesStyle({"input"})
public class CwPrimeNumberFrequencyByModulo extends ContentWidget {
  /**
   * A custom animation that moves a small image around a circle in an
   * {@link HorizontalPanel}.
   */
  @TUPracticalPiecesSource
  public static interface CwConstants extends Constants {
	String cwPrimeNumberFrequencyByModuloDescription();

    String cwPrimeNumberFrequencyByModuloGuidMax();
    
    String cwPrimeNumberFrequencyByModuloGuidModulo();
    
    String cwPrimeNumberFrequencyByModuloName();
   
    String cwPrimeNumberFrequencyByModuloStatNum();
    
    String cwPrimeNumberFrequencyByModuloStatModulo();
    
    String cwPrimeNumberFrequencyByModuloStatRemainder();
    
    String cwPrimeNumberFrequencyByModuloSubmit();
  }
  
  /**
   * Graph attributes.
   */
  @TUPracticalPiecesData
  private final int graWidth = 1024;
  
  /**
   * Height of the canvas.
   */
  @TUPracticalPiecesData
  private 	final int graHeight = 1024;
  
  /**
   * Guidance's graWidth of the canvas.
   */
  @TUPracticalPiecesData
  private 	final int graDepth = 60;
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  //private HTML canvas = null;
  private Canvas canvas = null;
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private HTML canvasN = null;
  
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
   * Draw the graph on the click.
   */
  @TUPracticalPiecesData
  private Button drawButton = new Button();
  
  /**
   * Draw the graph on the click.
   */
  @TUPracticalPiecesData
  private RadioButton radioIsGradient = new RadioButton("radioIsGroup","Gradient");
  private RadioButton radioIsIncident = new RadioButton("radioIsGroup","Incident");
 
  /**
   * Clear the graph on the click.
   */
  @TUPracticalPiecesData
  private TextBox parameterTextBox = new TextBox();
  /**
   * The modulo max.
  */
  @TUPracticalPiecesData
  private TextBox maxModuloTextBox = new TextBox();
  /**
   * The modulo max.
  */
  @TUPracticalPiecesData
  private TextBox maxModuloValueTextBox = new TextBox();
  /**
   * The work modulo max.
  */
  @TUPracticalPiecesData
  private String prevMod = "8";
  
  /**
  * Redraw timer.
  */
  @TUPracticalPiecesData
  private Timer timer;
  
  
  /**
  * Redraw timer.
  */
  @TUPracticalPiecesData
  final Timer threadTimer = new Timer() {
    	@Override
    	public void run() {
    		  calculatePrimeNumbersInJava();
    	}
  };

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
  public CwPrimeNumberFrequencyByModulo(CwConstants constants) {
    super(
        constants.cwPrimeNumberFrequencyByModuloName(), constants.cwPrimeNumberFrequencyByModuloDescription(), true);
    this.constants = constants;
  }
  
  /**
   * Initialize this example.
   */
  @TUPracticalPiecesSource
  @Override
  public Widget onInitialize() {
    VerticalPanel mainLayout = new VerticalPanel();
    HorizontalPanel argument1 = new HorizontalPanel();
    mainLayout.setSpacing(10);
    //Dialog box
    // Create the dialog box
    final DialogBox suspendDialog = new DialogBox();
    suspendDialog.setText("Would you like to suspend?");
    suspendDialog.setAnimationEnabled(true);
    final HorizontalPanel dialogPanel = new HorizontalPanel();
    dialogPanel.setSpacing(0);
    Button suspendButton = new Button("Yes");
    suspendButton.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
        	try {
            	threadTimer.cancel();
            	timer.cancel();
        	} catch(Exception e) {
        		/* empty */
        		;
        	}
        	completeExec();
        	suspendDialog.hide();
        }
      });
    dialogPanel.add(suspendButton);
    Button cancelButton = new Button("No");
    cancelButton.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
        	suspendDialog.hide();
        }
      });
    dialogPanel.add(cancelButton);
    suspendDialog.add(dialogPanel);

    // Add start button
    argument1.add(new HTML(constants.cwPrimeNumberFrequencyByModuloGuidMax()));
	//DOM.setElementAttribute(parameterTextBox.getElement(), "id", "parameterTextBoxID"); 
	parameterTextBox.getElement().setId("parameterTextBoxID");
	parameterTextBox.setMaxLength(6);
	parameterTextBox.setVisibleLength(6);
	parameterTextBox.setValue("64");
	/* no need to validation afraid of js injection because of gwt between */
	parameterTextBox.addKeyPressHandler(new KeyPressHandler() {
	        @Override
	        public void onKeyPress(KeyPressEvent event) {
	            if(!Character.isDigit(event.getCharCode()))
	                ((TextBox) event.getSource()).cancelKey();
	        	}
		}
    );
	argument1.add(parameterTextBox);
    mainLayout.add(argument1);
    
    HorizontalPanel argument2 = new HorizontalPanel();
    /*
    DOM.setElementAttribute(maxModuloTextBox.getElement(), "id", "rangeMaxModulo"); 
    DOM.setElementAttribute(maxModuloTextBox.getElement(), "type", "range");
    DOM.setElementAttribute(maxModuloTextBox.getElement(), "min", "2");
    DOM.setElementAttribute(maxModuloTextBox.getElement(), "max", "1024");
    DOM.setElementAttribute(maxModuloTextBox.getElement(), "step", "1");
    DOM.setElementAttribute(maxModuloTextBox.getElement(), "value", "8");
	*/
    maxModuloTextBox.getElement().setId("rangeMaxModulo"); 
    maxModuloTextBox.getElement().setAttribute("type","range"); 
    maxModuloTextBox.getElement().setAttribute("min","2"); 
    maxModuloTextBox.getElement().setAttribute("max","1024"); 
    maxModuloTextBox.getElement().setAttribute("step","1"); 
    maxModuloTextBox.getElement().setAttribute("value","8"); 

    maxModuloTextBox.addMouseOutHandler(new MouseOutHandler() {
    	public void onMouseOut(MouseOutEvent event) {
    		maxModuloValueTextBox.setValue(maxModuloTextBox.getValue(), true);
    		prevMod = maxModuloTextBox.getValue();
        }
    });
    argument2.add(maxModuloTextBox);
    //DOM.setElementAttribute(maxModuloValueTextBox.getElement(), "id", "rangeMaxModuloValue"); 
    maxModuloValueTextBox.getElement().setId("rangeMaxModuloValue"); 
    maxModuloValueTextBox.addBlurHandler(new BlurHandler() {
    	public void onBlur(BlurEvent event) {
    		int tmpMod;
    		String tmpModStr;
    		try {
    			tmpModStr = maxModuloValueTextBox.getValue();
    			tmpMod = Integer.parseInt(tmpModStr);
    		} catch (Exception e) {
    			Window.alert("Please input integer between 2 and 1024.");
    			maxModuloValueTextBox.setValue(prevMod, true);
    			return;
    		}
    		if (tmpMod < 2 || tmpMod > 1024) {
    			Window.alert("Please input integer between 2 and 1024.");
    			maxModuloValueTextBox.setValue(prevMod, true);
    			return;
    		}
    		prevMod = tmpModStr;
    		maxModuloTextBox.setValue(tmpModStr, true);
        }
    });
    maxModuloValueTextBox.setMaxLength(6);
	maxModuloValueTextBox.setVisibleLength(6);
	maxModuloValueTextBox.setValue("8");
    argument2.add(maxModuloValueTextBox);
    radioIsGradient.setValue(true);
    argument2.add(radioIsGradient);
    argument2.add(radioIsIncident);
    drawButton.addStyleName("sc-FixedWidthButton");
    drawButton.setText(constants.cwPrimeNumberFrequencyByModuloSubmit());
    drawButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
    	  if (execValidationInJava()) {
    		  prepareExec();
    		  if (radioIsGradient.getValue()) {
    			  threadTimer.schedule(30);
    			  timer = new Timer() {
    				  @Override
    				  public void run() {
    					 if (isDrawingInJava()) {
    						 drawHistgramGradientInJava();
    					 } else {
    						completeExec();
    						cancel();
    					 }
    				 }
    			  };
    			  timer.scheduleRepeating(70);
    		  } else {
        		  calculatePrimeNumbersInJava();
        		  drawHistgramIncidentInJava();
    			  completeExec();
    		  }
    	  }
      }
    });
    argument2.add(drawButton);
    mainLayout.add(argument2);
    mainLayout.add(new HTML("<br/><em>"
    + constants.cwPrimeNumberFrequencyByModuloStatNum() + ":" + "<span id='statNum'>n/a</span>" + " "
    + constants.cwPrimeNumberFrequencyByModuloStatModulo() + ":" +  "<span id='statModulo'></span>" + " " 
    + constants.cwPrimeNumberFrequencyByModuloStatRemainder() +  ":" + "<span id='statRemainder'></span></em>"));
    // Create the custom canvas
    canvasN = new HTML("<canvas id='primeNumHeader' width=" + String.valueOf(graDepth + graWidth) + " height=" + String.valueOf(graDepth * 2) + " ></canvas>");
    canvas = Canvas.createIfSupported();
    if (canvas == null) {
      Window.alert("This browser doesn't support HTML5 Canvas.");
    }
    canvas.setHeight(graWidth + "px");
    canvas.setHeight(graHeight + "px");
    canvas.setCoordinateSpaceWidth(graWidth);
    canvas.setCoordinateSpaceHeight(graHeight);
	//DOM.setElementAttribute(canvas.getElement(), "id", "histgram"); 
	canvas.getElement().setId("histgram"); 
	canvas.addClickHandler(new ClickHandler() {
//		@Override
		public void onClick(ClickEvent event) {
	    	if (radioIsGradient.getValue() && drawButton.isEnabled() == false) {
	    		suspendDialog.show();
	    		return;
	    	}
			showExplanationInJava(event.getX(), event.getY());
		}
	});
    canvasW = new HTML("<canvas id='primeNumScale' width=" + String.valueOf(graDepth) + " height=" + String.valueOf(graHeight) + "></canvas>");
    canvasS = new HTML("<span id='primeNumFooter'></span>");
    final VerticalPanel graHeadPanel = new VerticalPanel();
    graHeadPanel.setSpacing(0);
    graHeadPanel.add(canvasN);
    // Create a HorizontalPanel
    final HorizontalPanel graMainPanel = new HorizontalPanel();
    graMainPanel.setSpacing(0);
    // Add contents
    graMainPanel.add(canvasW);
    graMainPanel.add(canvas);
    // Create a panel to move components around
    HorizontalPanel bottom = new HorizontalPanel();
    bottom.setSpacing(0);
    bottom.add(canvasS);
    // Add contents
    mainLayout.add(graHeadPanel);
    mainLayout.add(graMainPanel);
    mainLayout.add(bottom);
    // Return the layout
    final Timer delayTimer = new Timer() {
    	@Override
    	public void run() {
    		setGraphHeaderInJava();
    	}
    };
    delayTimer.schedule(300);
    return mainLayout;
  }
  
  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
    GWT.runAsync(CwPrimeNumberFrequencyByModulo.class, new RunAsyncCallback() {
  
      public void onFailure(Throwable caught) {
        callback.onFailure(caught);
      }
  
      public void onSuccess() {
        callback.onSuccess(onInitialize());
      }
    });
  }
    
  /**
   * 
   */
  public void prepareExec() {
	  drawButton.setEnabled(false);
	  radioIsGradient.setEnabled(false);
	  radioIsIncident.setEnabled(false);
	  parameterTextBox.setEnabled(false);
	  maxModuloTextBox.setEnabled(false);
	  maxModuloValueTextBox.setEnabled(false);
  }
  
  /**
   * 
   */
  public void completeExec() {
	  drawButton.setEnabled(true);
	  radioIsGradient.setEnabled(true);
	  radioIsIncident.setEnabled(true);
	  parameterTextBox.setEnabled(true);
	  maxModuloTextBox.setEnabled(true);
	  maxModuloValueTextBox.setEnabled(true);
  }
  
  /**
   * JS function call. setGraphHeader .
   */
  @TUPracticalPiecesSource
  public static native void setGraphHeaderInJava() /*-{
    $wnd.setGraphHeader();
  }-*/;
    
  /**
   * JS function call. showExplanation .
   */
  @TUPracticalPiecesSource
  public static native void showExplanationInJava(int cLeft, int cTop) /*-{
    $wnd.showExplanation(cLeft, cTop);
  }-*/;
    
  /**
   * JS function call. changeMaxModuloValue .
   */
  @TUPracticalPiecesSource
  public static native void changeMaxModuloValueInJava() /*-{
    $wnd.changeMaxModuloValue();
  }-*/;
    
  /**
   * JS function call. changeMaxModulo .
   */
  @TUPracticalPiecesSource
  public static native void changeMaxModuloInJava() /*-{
    $wnd.changeMaxModulo();
  }-*/;
  
  /**
   * JS function call. drawHistgramGradient .
   */
  @TUPracticalPiecesSource
  public static native void drawHistgramGradientInJava() /*-{
    $wnd.drawHistgramGradient();
  }-*/;
    
  /**
   * JS function call. drawHistgramIncident .
   */
  @TUPracticalPiecesSource
  public static native void drawHistgramIncidentInJava() /*-{
    $wnd.drawHistgramIncident();
  }-*/;
    
  /**
   * JS function call. execValidation .
   */
  @TUPracticalPiecesSource
  public static native boolean execValidationInJava() /*-{
    return $wnd.execValidation();
  }-*/;
    
  /**
   * JS function call. isDrawing .
   */
  @TUPracticalPiecesSource
  public static native boolean isDrawingInJava() /*-{
    return $wnd.isDrawing();
  }-*/;
  
  /**
   * JS function call. calculatePrimeNumbers .
   */
  @TUPracticalPiecesSource
  public static native void calculatePrimeNumbersInJava() /*-{
    $wnd.calculatePrimeNumbers();
  }-*/;
  
 }