package com.google.gwt.personal.tupracticalpieces.client.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminSvc;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminSvcAsync;
import com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Grid;

/**
 * A Composite widget of MileageWidget using grid whose data are linking to doa by 15 lines.
 */
public class MileageWidget extends Composite {
  
  private final AdminSvcAsync adminSvcSvc = GWT.create(AdminSvc.class);

  private static final String NO_CONNECTION_MESSAGE = "<em>Error occured in RPC</em>";
  private final String INVALID_COLUMN_NUM_MESSAGE = "<em>Expecting a positive number of columns</em>";
  
  private final DockPanel outer = new DockPanel();
  
  private final Grid grid = new Grid();
  
  private final NavBar navbar = new NavBar();
  
  private int startRow = 0;
  
  private int maxRows;
  
  private AsyncCallback<ResultSvc> callback = new AsyncCallback<ResultSvc>() {
	      public void onFailure(Throwable caught) {
	    		setStatusText(NO_CONNECTION_MESSAGE);
	      }
	      public void onSuccess(ResultSvc result) {
	    	try {
	    		setStatusText("");
	    	    if (result.getNumber() == 0) {
	    	    	setStatusText(INVALID_COLUMN_NUM_MESSAGE);
	    	    }
	    	    navbar.gotoFirst.setEnabled(true);
	    	    navbar.gotoPrev.setEnabled(true);
	    	    if (result.getNumber() == maxRows - 1) {
	    	    	navbar.gotoNext.setEnabled(true);
	    	    }
	    	    for (int i = 1; i <= result.getNumber(); i++) {
	    	    	String tmp[] = result.getRec(i - 1).split(",");
/*	    	    	grid.setText(i, 0, result.getSupplyDate(i - 1));
	    	    	grid.setText(i, 1, result.getQuantity(i - 1));
	    	    	grid.setText(i, 2, result.getUnitPrice(i - 1));
	    	    	grid.setText(i, 3, result.getTotalPrice(i - 1));
	    	    	grid.setText(i, 4, result.getBsMileage(i - 1));
	    	        grid.setText(i, 5, result.getTotalMileage(i - 1));
*/	    	    
	    	    	for (int j = 0; j < 6; j++)
	    	    		grid.setText(i, j, tmp[j]);
	    	    }
	    	    for (int j = result.getNumber() + 1; j < maxRows; j++) {
	    	    	for (int k = 0; k < 6; k++) {
	    	    		grid.setText(j, k, "");
	    	    	}
	    	    }
	    	} catch(Exception e) {
	    		setStatusText(e.toString());
	    	}
	      }
	    };

  public MileageWidget(int visibleRows) {
	    maxRows = visibleRows + 1;
	    String[] columns = new String[] {"SupplyDate", "Quantity", "UnitPrice", "TotalPrice", "BsMileage", "TotalMileage"};
	    String[] styles = new String[] {"Date", "Float", "Int", "Int", "Float", "Float"};
	    initWidget(outer);
	    grid.setStyleName("table");
	    grid.resize(maxRows, columns.length);
	    outer.add(navbar, DockPanel.NORTH);
	    outer.add(grid, DockPanel.CENTER);
	    for (int i = 0, n = columns.length; i < n; i++) {
	        grid.setText(0, i, columns[i]);
	        grid.getCellFormatter().setStyleName(0, i, "mileageWedgetHeader");
	    }
	    setStyleName("MileageWidget");
	    for (int i = 1; i < maxRows; i++) {
	    	for (int j = 0; j < columns.length; j++) {
	    		grid.getCellFormatter().setStyleName(i, j, "mileageWedget" + styles[j]);
	    	}
	    }
  }
    
  private class NavBar extends Composite implements ClickHandler {
	    public final HorizontalPanel bar = new HorizontalPanel();
	    public final Button gotoFirst = new Button("&lt;&lt;", this);
	    public final Button gotoNext = new Button("&gt;", this);
	    public final Button gotoPrev = new Button("&lt;", this);
	    public final HTML status = new HTML();

	    public NavBar() {
	      initWidget(bar);
	      bar.setStyleName("navbar");
	      status.setStyleName("status");

	      HorizontalPanel buttons = new HorizontalPanel();
	      buttons.add(gotoFirst);
	      buttons.add(gotoPrev);
	      buttons.add(gotoNext);
	      bar.add(buttons);
	      //bar.setCellHorizontalAlignment(buttons, DockPanel.ALIGN_RIGHT);
	      bar.add(status);
	      //bar.setVerticalAlignment(DockPanel.ALIGN_MIDDLE);
	      //bar.setCellHorizontalAlignment(status, HasAlignment.ALIGN_RIGHT);
	      //bar.setCellVerticalAlignment(status, HasAlignment.ALIGN_MIDDLE);
	      //bar.setCellWidth(status, "100%");

	      // Initialize prev & first button to disabled.
	      //
	      gotoPrev.setEnabled(false);
	      gotoFirst.setEnabled(false);
	    }

	    public void onClick(ClickEvent event) {
	      Object source = event.getSource();
	      if (source == gotoNext) {
	        startRow += getDataRowCount();
	        refresh();
	      } else if (source == gotoPrev) {
	        startRow -= getDataRowCount();
	        if (startRow < 0) {
	          startRow = 0;
	        }
	        refresh();
	      } else if (source == gotoFirst) {
	        startRow = 0;
	        refresh();
	      }
	  }
  }
  
  public void refresh() {
    // Disable buttons temporarily to stop the user from running off the end.
    //
    navbar.gotoFirst.setEnabled(false);
    navbar.gotoPrev.setEnabled(false);
    navbar.gotoNext.setEnabled(false);

    setStatusText("Please wait...");
//    provider.updateRowData(startRow, grid.getRowCount() - 1, acceptor);
	adminSvcSvc.dispatchMileageData(startRow, grid.getRowCount() - 1, callback);
  }
  /*
  public void setRowCount(int rows) {
    grid.resizeRows(rows);
  }
  */
  public void setStatusText(String text) {
    navbar.status.setText(text);
  }
  
  private int getDataRowCount() {
    return grid.getRowCount() - 1;
  }
}