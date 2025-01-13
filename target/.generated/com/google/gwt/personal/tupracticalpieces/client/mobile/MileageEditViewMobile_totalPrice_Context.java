package com.google.gwt.personal.tupracticalpieces.client.mobile;

public class MileageEditViewMobile_totalPrice_Context extends com.google.gwt.editor.client.impl.AbstractEditorContext<java.lang.Integer> {
  private final com.google.gwt.personal.tupracticalpieces.shared.MileageProxy parent;
  public MileageEditViewMobile_totalPrice_Context(com.google.gwt.personal.tupracticalpieces.shared.MileageProxy parent, com.google.gwt.editor.client.Editor<java.lang.Integer> editor, String path) {
    super(editor,path);
    this.parent = parent;
  }
  @Override public boolean canSetInModel() {
    return parent != null && true && true;
  }
  @Override public java.lang.Integer checkAssignment(Object value) {
    return (java.lang.Integer) value;
  }
  @Override public Class getEditedType() { return java.lang.Integer.class; }
  @Override public java.lang.Integer getFromModel() {
    return (parent != null && true) ? parent.getTotalPrice() : null;
  }
  @Override public void setInModel(java.lang.Integer data) {
    parent.setTotalPrice(data);
  }
}
