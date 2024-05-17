package com.google.gwt.personal.tupracticalpieces.client.common;
  
//import java.io.Serializable;
import com.google.gwt.user.client.rpc.IsSerializable;
/**
 * 20130508 Grid  
 * The RPC of AdiminSvc for data.
 *
@SuppressWarnings("serial")
 */
public class ResultSvc implements IsSerializable {
  private String[] rec;
  private int num;
  public ResultSvc() {
  }

  public ResultSvc(int num) {
	  setNumber(num);
	  setAllocate(num);
  }
  
  public void setNumber(int num) {
	  this.num = num;
  }
  
  public void setAllocate(int num) {
	  //this.rec = new String[num][6];
	  this.rec = new String[num];
  }
  
//  public void setRec(int indx, String supplyDate, String quantity, String unitPrice,
//		  String totalPrice, String bsMileage, String totalMileage) {
/*	  this.rec[indx][0] = supplyDate;
	  this.rec[indx][1] = quantity;
	  this.rec[indx][2] = unitPrice;
	  this.rec[indx][3] = totalPrice;
	  this.rec[indx][4] = bsMileage;
	  this.rec[indx][5] = totalMileage;
*/	
  public String getRec(int indx) {		
	  return this.rec[indx];
  }
  
  public void setRec(int indx, String rec) {		
	  this.rec[indx] = rec;
  }
  
  public int getNumber() {
	  return this.num;
  }
}
/*  
  public String getSupplyDate(int indx) {
	  return this.rec[indx][0];
  }
  
  public String getQuantity(int indx) {
	  return this.rec[indx][1];
  }
  
  public String getUnitPrice(int indx) {
	  return this.rec[indx][2];
  }
  
  public String getTotalPrice(int indx) {
	  return this.rec[indx][3];
  }
  
  public String getBsMileage(int indx) {
	  return this.rec[indx][4];
  }
  
  public String getTotalMileage(int indx) {
	  return this.rec[indx][5];
  }
  
*/
