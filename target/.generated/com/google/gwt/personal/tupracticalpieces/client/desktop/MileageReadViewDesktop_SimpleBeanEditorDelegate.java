package com.google.gwt.personal.tupracticalpieces.client.desktop;

public class MileageReadViewDesktop_SimpleBeanEditorDelegate extends com.google.gwt.editor.client.impl.SimpleBeanEditorDelegate {
  private com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop editor;
  @Override protected com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop getEditor() {return editor;}
  protected void setEditor(com.google.gwt.editor.client.Editor editor) {this.editor=(com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop)editor;}
  private com.google.gwt.personal.tupracticalpieces.shared.MileageProxy object;
  @Override public com.google.gwt.personal.tupracticalpieces.shared.MileageProxy getObject() {return object;}
  @Override protected void setObject(Object object) {this.object=(com.google.gwt.personal.tupracticalpieces.shared.MileageProxy)object;}
  com.google.gwt.editor.client.impl.SimpleBeanEditorDelegate quantityDelegate;
  com.google.gwt.editor.client.impl.SimpleBeanEditorDelegate unitPriceDelegate;
  com.google.gwt.editor.client.impl.SimpleBeanEditorDelegate totalPriceDelegate;
  com.google.gwt.editor.client.impl.SimpleBeanEditorDelegate bsMileageDelegate;
  com.google.gwt.editor.client.impl.SimpleBeanEditorDelegate totalMileageDelegate;
  @Override protected void initializeSubDelegates() {
    if (editor.quantityEditor.asEditor() != null) {
      quantityDelegate = new com.google.gwt.editor.ui.client.adapters.ValueBoxEditor_java_math_BigDecimal_SimpleBeanEditorDelegate();
      addSubDelegate(quantityDelegate, appendPath("quantity"), editor.quantityEditor.asEditor());
    }
    if (editor.unitPriceEditor.asEditor() != null) {
      unitPriceDelegate = new com.google.gwt.editor.ui.client.adapters.ValueBoxEditor_java_lang_Integer_SimpleBeanEditorDelegate();
      addSubDelegate(unitPriceDelegate, appendPath("unitPrice"), editor.unitPriceEditor.asEditor());
    }
    if (editor.totalPriceEditor.asEditor() != null) {
      totalPriceDelegate = new com.google.gwt.editor.ui.client.adapters.ValueBoxEditor_java_lang_Integer_SimpleBeanEditorDelegate();
      addSubDelegate(totalPriceDelegate, appendPath("totalPrice"), editor.totalPriceEditor.asEditor());
    }
    if (editor.bsMileageEditor.asEditor() != null) {
      bsMileageDelegate = new com.google.gwt.editor.ui.client.adapters.ValueBoxEditor_java_math_BigDecimal_SimpleBeanEditorDelegate();
      addSubDelegate(bsMileageDelegate, appendPath("bsMileage"), editor.bsMileageEditor.asEditor());
    }
    if (editor.totalMileageEditor.asEditor() != null) {
      totalMileageDelegate = new com.google.gwt.editor.ui.client.adapters.ValueBoxEditor_java_math_BigDecimal_SimpleBeanEditorDelegate();
      addSubDelegate(totalMileageDelegate, appendPath("totalMileage"), editor.totalMileageEditor.asEditor());
    }
  }
  @Override public void accept(com.google.gwt.editor.client.EditorVisitor visitor) {
    {
      com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop_supplyDate_Context ctx = new com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop_supplyDate_Context(getObject(), editor.supplyDateEditor.asEditor(), appendPath("supplyDate"));
      ctx.traverse(visitor, null);
    }
    if (quantityDelegate != null) 
    {
      com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop_quantity_Context ctx = new com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop_quantity_Context(getObject(), editor.quantityEditor.asEditor(), appendPath("quantity"));
      ctx.setEditorDelegate(quantityDelegate);
      ctx.traverse(visitor, quantityDelegate);
    }
    if (unitPriceDelegate != null) 
    {
      com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop_unitPrice_Context ctx = new com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop_unitPrice_Context(getObject(), editor.unitPriceEditor.asEditor(), appendPath("unitPrice"));
      ctx.setEditorDelegate(unitPriceDelegate);
      ctx.traverse(visitor, unitPriceDelegate);
    }
    if (totalPriceDelegate != null) 
    {
      com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop_totalPrice_Context ctx = new com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop_totalPrice_Context(getObject(), editor.totalPriceEditor.asEditor(), appendPath("totalPrice"));
      ctx.setEditorDelegate(totalPriceDelegate);
      ctx.traverse(visitor, totalPriceDelegate);
    }
    if (bsMileageDelegate != null) 
    {
      com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop_bsMileage_Context ctx = new com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop_bsMileage_Context(getObject(), editor.bsMileageEditor.asEditor(), appendPath("bsMileage"));
      ctx.setEditorDelegate(bsMileageDelegate);
      ctx.traverse(visitor, bsMileageDelegate);
    }
    if (totalMileageDelegate != null) 
    {
      com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop_totalMileage_Context ctx = new com.google.gwt.personal.tupracticalpieces.client.desktop.MileageReadViewDesktop_totalMileage_Context(getObject(), editor.totalMileageEditor.asEditor(), appendPath("totalMileage"));
      ctx.setEditorDelegate(totalMileageDelegate);
      ctx.traverse(visitor, totalMileageDelegate);
    }
  }
}
