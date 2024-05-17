package com.google.gwt.personal.tupracticalpieces.client.content;


import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.Constants;
//import com.google.gwt.maps.client.MapOptions;
//import com.google.gwt.maps.client.MapTypeId;
//import com.google.gwt.maps.client.MapWidget;
//import com.google.gwt.maps.client.base.LatLng;


import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesData;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesSource;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
//import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Frame;
/**
 * HTML5 + CSS
 */
/* NG 201407
@TUPracticalPiecesStyle({"option","select"})
*/
public class CwFrame extends ContentWidget {
  /**
   * A custom animation that moves a small image around a circle in an
   * {@link HorizontalPanel}.
   */
  @TUPracticalPiecesSource
  public static interface CwConstants extends Constants {
    String cwFrameAttached();
	    
	String cwFrameDescription();
	    
	String cwFrameInstruct();
    
    String cwFrameName();
  }
    
  /**
   * The root.
   */
  @TUPracticalPiecesData
  private VerticalPanel displayPane = null;
  
  /**
   * The map panel.
   */
  @TUPracticalPiecesData
  private SimplePanel mapPanel = new SimplePanel();
  
  /**
   * The timer to retry retrieving news.
   */
  @TUPracticalPiecesData
  private Timer timerNewsList = null;
  
  /**
   * The timer to retry retrieving news.
   */
  @TUPracticalPiecesData
  private Timer timerBlackList = null;
  
  /**
   * Update status.
   */
  @TUPracticalPiecesData
  private TextBox textStatus = new TextBox();
  
  /**
   * The selected news and location.
   */
  /*
  @TUPracticalPiecesData
  private TextBox textLat = new TextBox();
  */
  /**
   * The selected news and location.
   */
  /*
  /**
   * The displayed errors.
   */
  /*
  @TUPracticalPiecesData
  private TextBox msgBox = new TextBox();
  */
  /**
   * The retry number of http request.
   */
  @TUPracticalPiecesData
  private int re_try = 0;
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private boolean isAdmin = false;

  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private Button excludeButton = new Button("ExcludeThisName");
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private HorizontalPanel tablePanel = null;
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private VerticalPanel contPanel = null;
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private VerticalPanel waitPanel = null;
  
  /**
   * An instance of the constants.
   */
  @TUPracticalPiecesData
//  private final CwConstants constants;
  protected final CwConstants constants;
  
  /**
   * Constructor.
   *
   * @param constants the constants
   */
  public CwFrame(CwConstants constants) {
	    super(
	        constants.cwFrameName(), constants.cwFrameDescription(), false);
	    this.constants = constants;
	  }
	  
  public CwFrame(String title, String descript, Constants constants) {
	  super(title, descript, false);
	  //this.constants = this.constants;
	  this.constants = (CwConstants) constants;
	  //new CwFrame(this.constants);
  }
  
  /**
   * Set admin mode.
   *
   * @param whether admin or not
   */
  public void setAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }
  
  /**
   * Initialize this example.
   */
  @TUPracticalPiecesSource
  @Override
  public Widget onInitialize() {
	contPanel = new VerticalPanel();
    contPanel.setVisible(false);
    VerticalPanel instPanel = new VerticalPanel();
    if (isAdmin) {
    	instPanel.add(new HTML("<h2><a href='#!CwFrame'>CwFrame</a></h2>"));
    }
    instPanel.add(new HTML("<em>" + constants.cwFrameInstruct() + "</em>"));
    instPanel.add(new HTML("<code><em><select id='listLocs'></select></em></code>"));
    instPanel.add(new HTML("<font size='1'><br></font>"));
    instPanel.add(new HTML("<em>" + constants.cwFrameAttached() + "</em>"));
    instPanel.add(new HTML("<font size='4'><a id='linkNewsSource'></a></font>"));
    contPanel.add(instPanel);

    /*20151230
     * contPanel.add(new HTML("<div id='mapcanvas' style=''/>"));
     */
    mapPanel.getElement().setId("mapcanvas");
    mapPanel.setStyleName("NewsCountMap");
    
//    var mapOptions = {
//            center: new google.maps.LatLng(-34.397, 150.644),
//            mapTypeId:google.maps.MapTypeId.ROADMAP,
//            zoom: 8
//          };
/*

LatLng center = LatLng.newInstance(49.496675, -102.65625);
MapOptions opts = MapOptions.newInstance();
opts.setZoom(8);
opts.setCenter(center);
opts.setMapTypeId(MapTypeId.ROADMAP);

MapWidget mapWidget = new MapWidget(opts);
mapPanel.add(mapWidget);
mapWidget.setSize("750px", "500px");
*/



/*
SimplePanel mapPanel = new SimplePanel() ;

mapPanel.setSize("100%","100%");
Maps theMap = Maps.create( mapPanel.getElement(), options ) ;


GoogleMap theMap = GoogleMap.create( mapPanel.getElement(), options ) ;
    
*/
    
    contPanel.add(mapPanel);
    String tmp = "<div>The news list of the pull-down menu is selected from of 'Google News'.";
    tmp += "The way to pick up is as follows.<ol>";
    tmp += "<li>Retieve 50 items from the category of world news.</li>";		
    tmp += "<li>As the map requires the location name, first one or two words of news title is a candidate of it in convinience.</li>";		
    tmp += "<li>The news extraction is proper 8 items at most in processing order. If the words obtained a location from 'geoname.org', it is considered as a proper one.</li>";	
    tmp += "</ol>";
    tmp	+= "The figures of the table of the right side are sums of the items obtained by excuting the above method at schedule time once a day.</div>";
    contPanel.add(new HTML(tmp));
	contPanel.add(new HTML("<span id='msgBox'></span>"));
	/*contPanel.add(new HTML("<iframe id='mapPane' style='height:100%; width:100%;'></iframe>"));
	*/
	displayPane = new VerticalPanel();

	waitPanel = new VerticalPanel();
	waitPanel.setVisible(true);
	waitPanel.add(new HTML("<h3 id='waitMsg'>Please wait a minute....</h3>"));
	displayPane.add(waitPanel);
	/*
	mapCanvas = new HTML("<canvas id='mapcanvas' height='300' width='400'/>");
	*/
    tablePanel = new HorizontalPanel();
    tablePanel.setVisible(false);
    tablePanel.add(contPanel);
    VerticalPanel newscountpanel = new VerticalPanel();
    newscountpanel.add(new HTML("<span>News appearances by country in the last 30 days.<span>"));
//    newscountpanel.add(new NewsCountWidget());
    //20170715
//    newscountpanel.add(new NewsCountWidgetAngular());
//    newscountpanel.add(new NewsCountWidgetAngularJS());
 // Create a frame for the bottom of the split panel
    Frame newsCountWidget = new Frame("/NewsCountWidget.html");
    newsCountWidget.setSize("100%",  "400px");
    newscountpanel.add(newsCountWidget);
	excludeButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	    	/** 8181 set this location name to ineffective */
	    	setBlackList();
	      }
	    });
    newscountpanel.add(excludeButton);
    //newscountpanel.add(new HTML("<span id=textLocName width='12em' ><span>"));
    textStatus.getElement().setId("textStatus");;
    textStatus.setWidth("12em");
    newscountpanel.add(textStatus);
  	timerNewsList = new Timer () {
	      @Override
	      public void run() {
	    	if (isNewsListEmptyInJava()) {
	    		re_try++;
	    		if (re_try > 3) {
	    		  waitPanel.removeFromParent();
	    		  contPanel.setVisible(true);
	    		  tablePanel.setVisible(true);
	    		  return;
	    		}
	    	  	setNewsList();
	    	  	return;
	    	 }
	    	 waitPanel.removeFromParent();
	    	 contPanel.setVisible(true);
	    	 tablePanel.setVisible(true);
	    	 //20170729
	    	 setupMapinJava();
	      }
	};
	timerBlackList = new Timer () {
	      @Override
	      public void run() {
	    	if (isUpdateStatusNG()) {
	    		re_try++;
	    		if (re_try > 3) {
	    		  return;
	    		}
	    	  	setBlackList();
	    	  	return;
	    	 }
	      }
	};
    if (isAdmin) {
    	//setLocNameVisibleInJava(true);
    	excludeButton.setVisible(true);
    	textStatus.setVisible(true);
    } else {
    	//setLocNameVisibleInJava(false);
    	excludeButton.setVisible(false);    	
    	textStatus.setVisible(false);
    	newscountpanel.add(new HTML("<h2><a href='#!CwXFrame'>Adjustment by admin</a></h2>"));
    }
    
    tablePanel.add(newscountpanel);
	displayPane.add(tablePanel);
	setNewsList();
    return displayPane;
  }
  
  private void setNewsList() {
	  	String url;
//	  	if (("127.0.0.1:8888").equals(Window.Location.getHost())
//	    		|| ("localhost:8888").equals(Window.Location.getHost())) {
//			url= "http://localhost:8888/proxy8181?method=location";
//	  	} else {
//	  		url= "http://tupracticalpieces.appspot.com/proxy8181?method=location";
//	  	}
//	  	url = Window.Location.getHref() + "/proxy8181?method=location";
	  	url = "/proxy8181?method=location";
	  	/* Send request to server and catch any errors. */
	    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
	    try { 
	  	  builder.setHeader("Content-Type","text/plain");
	      builder.setHeader("Access-Control-Allow-Origin","*");
		  @SuppressWarnings("unused")
		  Request request = builder.sendRequest(null, 
			new RequestCallback() {
		        public void onError(Request request, Throwable exception) {
		          displayErrorInJava("Couldn't retrieve JSON." + exception.toString());
//	        	  timerNewsList.schedule(500);
	        	  timerNewsList.schedule(10000);
		        }

		        public void onResponseReceived(Request request, Response response) {
		          if (200 == response.getStatusCode()) {
		        	  //Window.alert(response.getText());
		        	  setListBoxInJava(response.getText());

		          } else {
		            displayErrorInJava("Couldn't retrieve JSON. (" + response.getStatusCode() + ":" + response.getStatusText()
		                + ")");
		          }
	    /*
		    	  timerNewsList.schedule(500);

		*/
	        	  timerNewsList.schedule(20000);
		        }
		      });
		} catch (Exception e) {
      	      Window.alert("RequestBuilder expeption:" + e.toString());
		      displayErrorInJava("Couldn't retrieve JSON. e:" + e.toString());
	    /*
		    	  timerNewsList.schedule(500);

		*/
	        	  timerNewsList.schedule(20000);
		}
    
  }
  
  private void setBlackList() {
	    setUpdateStatus("");
	  	String url;
//	  	if (("127.0.0.1:8888").equals(Window.Location.getHost())
//	    		|| ("localhost:8888").equals(Window.Location.getHost())) {
//			url= "http://localhost:8888/proxy8181?method=blacklist&name=";
//	  	} else {
//	  		url= "http://tupracticalpieces.appspot.com/proxy8181?method=blacklist&name=";
//	  	}
//	  	url = Window.Location.getHref() + "/proxy8181?method=blacklist&name=";
	  	url = "/proxy8181?method=blacklist&name=";
	  	url += URL.encode(getLocNameInJava());
	    /* Send request to server and catch any errors. */
	    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
	    try { 
	  	  builder.setHeader("Content-Type","text/plain");
	      builder.setHeader("Access-Control-Allow-Origin","*");
		  @SuppressWarnings("unused")
		  Request request = builder.sendRequest(null, 
			new RequestCallback() {
		        public void onError(Request request, Throwable exception) {
		          displayErrorInJava("Couldn't set BlackList." + exception.toString());
	        	  timerBlackList.schedule(100);
		        }

		        public void onResponseReceived(Request request, Response response) {
		          if (200 == response.getStatusCode()) {
		        	  setUpdateStatus(response.getText());
		        	  //Window.alert(response.getText());

		          } else {
		            displayErrorInJava("Couldn't set BlackList. (" + response.getStatusCode() + ":" + response.getStatusText()
		                + ")");
		          }
	    /*
		    	  timerBlackList.schedule(100);

		*/
	        	  timerBlackList.schedule(5000);
		        }
		      });
		} catch (Exception e) {
      	      Window.alert("RequestBuilder expeption:" + e.toString());
		      displayErrorInJava("Couldn't set BlackList. e:" + e.toString());
	    /*
		    	  timerBlackList.schedule(100);

		*/
	        	  timerBlackList.schedule(5000);
		}
    
  }
  public void setUpdateStatus(String txtStatus) {
	  textStatus.setText(txtStatus);
  }
  
  public boolean isUpdateStatusNG() {
	  if (textStatus.getText().equals("OK")) {
		  return true;
	  }
	  return false;
  }
  
  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
    GWT.runAsync(CwFrame.class, new RunAsyncCallback() {
  
      public void onFailure(Throwable caught) {
        callback.onFailure(caught);
      }
  
      public void onSuccess() {
        callback.onSuccess(onInitialize());
      }
    });
  }
  /*
  private void displayError(String s) {
	  msgBox.setText(s);
  }
  */
  /**
   * JS function call. Make ComboBox(ListBox;select) and display a map of the selected list.
   *  20130416 slider(range)
   */
  @TUPracticalPiecesSource
  public static native void setListBoxInJava(String s) /*-{
	$wnd.setListBox(s);
  }-*/;
  /**
   * JS function call. Display the error.
   *  20130416 slider(range)
   * @return 
   */
  @TUPracticalPiecesSource
  public static native void displayErrorInJava(String s) /*-{
	$wnd.displayError();
  }-*/;
  /**
   * JS function call. Where to succeed downloading news list.
   *  20130416 slider(range)
   * @return 
   */
  @TUPracticalPiecesSource
  public static native boolean isNewsListEmptyInJava() /*-{
    return $wnd.isNewsListEmpty();
  }-*/;
  /**
   * JS function call. Where to succeed downloading news list.
   *  20130416 slider(range)
   * @return 
   */
  @TUPracticalPiecesSource
  public static native String getLocNameInJava() /*-{
    return $wnd.getLocName();
  }-*/;
  /**
   * JS function call. Setup the map.
   *  20170729 avoid not showing the first map.
   * @return 
   */
  @TUPracticalPiecesSource
  public static native void setupMapinJava() /*-{
    $wnd.setupMap();
  }-*/;
  
}
