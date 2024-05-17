package com.google.gwt.personal.tupracticalpieces.client.content;

public class AdminMileageReadView_quantity_Context extends com.google.gwt.editor.client.impl.AbstractEditorContext<java.math.BigDecimal> {
  private final com.google.gwt.personal.tupracticalpieces.shared.MileageProxy parent;
  public AdminMileageReadView_quantity_Context(com.google.gwt.personal.tupracticalpieces.shared.MileageProxy parent, com.google.gwt.editor.client.Editor<java.math.BigDecimal> editor, String path) {
    super(editor,path);
    this.parent = parent;
  }
  @Override public boolean canSetInModel() {
    return parent != null && true && true;
  }
  @Override public java.math.BigDecimal checkAssignment(Object value) {
    return (java.math.BigDecimal) value;
  }
  @Override public Class getEditedType() { return java.math.BigDecimal.class; }
  @Override public java.math.BigDecimal getFromModel() {
    return (parent != null && true) ? parent.getQuantity() : null;
  }
  @Override public void setInModel(java.math.BigDecimal data) {
    parent.setQuantity(data);
  }
}
