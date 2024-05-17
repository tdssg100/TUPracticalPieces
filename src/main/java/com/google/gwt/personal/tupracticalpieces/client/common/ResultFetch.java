package com.google.gwt.personal.tupracticalpieces.client.common;
  
import java.io.Serializable;
  
@SuppressWarnings("serial")
public class ResultFetch implements Serializable {  
  /**
   * Singleton
  private static final long serialVersionUID = 3731536445914262925L;
   */

  private boolean result;
  private String text;
  
  public void setResult(boolean ret) {
	  this.result = ret;
  }
  
  public boolean getResult() {
	  return this.result;
  }
  
  public void setText(String txt) {
	  this.text = txt;
  }
  
  public String getText() {
	  return this.text;
  }
}
