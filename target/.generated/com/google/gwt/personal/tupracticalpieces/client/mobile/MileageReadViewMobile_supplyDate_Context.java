package com.google.gwt.personal.tupracticalpieces.client.mobile;

public class MileageReadViewMobile_supplyDate_Context extends com.google.gwt.editor.client.impl.AbstractEditorContext<java.lang.String> {
  private final com.google.gwt.personal.tupracticalpieces.shared.MileageProxy parent;
  public MileageReadViewMobile_supplyDate_Context(com.google.gwt.personal.tupracticalpieces.shared.MileageProxy parent, com.google.gwt.editor.client.Editor<java.lang.String> editor, String path) {
    super(editor,path);
    this.parent = parent;
  }
  @Override public boolean canSetInModel() {
    return parent != null && true && true;
  }
  @Override public java.lang.String checkAssignment(Object value) {
    return (java.lang.String) value;
  }
  @Override public Class getEditedType() { return java.lang.String.class; }
  @Override public java.lang.String getFromModel() {
    return (parent != null && true) ? parent.getSupplyDate() : null;
  }
  @Override public void setInModel(java.lang.String data) {
    parent.setSupplyDate(data);
  }
}
