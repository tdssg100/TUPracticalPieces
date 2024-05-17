package com.google.gwt.editor.ui.client.adapters;

public class ValueBoxEditor_java_math_BigDecimal_RequestFactoryEditorDelegate extends com.google.web.bindery.requestfactory.gwt.client.impl.RequestFactoryEditorDelegate {
  private com.google.gwt.editor.ui.client.adapters.ValueBoxEditor editor;
  @Override protected com.google.gwt.editor.ui.client.adapters.ValueBoxEditor getEditor() {return editor;}
  protected void setEditor(com.google.gwt.editor.client.Editor editor) {this.editor=(com.google.gwt.editor.ui.client.adapters.ValueBoxEditor)editor;}
  private java.math.BigDecimal object;
  @Override public java.math.BigDecimal getObject() {return object;}
  @Override protected void setObject(Object object) {this.object=(java.math.BigDecimal)object;}
  @Override protected void initializeSubDelegates() {
  }
  @Override public void accept(com.google.gwt.editor.client.EditorVisitor visitor) {
  }
}
