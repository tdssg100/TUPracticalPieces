package com.google.gwt.personal.tupracticalpieces.client.content;

public class AdminMileageReadView_EditorDriverImpl extends com.google.gwt.editor.client.impl.AbstractSimpleBeanEditorDriver<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy, com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageReadView> implements com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageReadView.EditorDriver {
  @Override public void accept(com.google.gwt.editor.client.EditorVisitor visitor) {
    com.google.gwt.editor.client.impl.RootEditorContext ctx = new com.google.gwt.editor.client.impl.RootEditorContext(getDelegate(), com.google.gwt.personal.tupracticalpieces.shared.MileageProxy.class, getObject());
    ctx.traverse(visitor, getDelegate());
  }
  @Override protected com.google.gwt.editor.client.impl.SimpleBeanEditorDelegate createDelegate() {
    return new com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageReadView_SimpleBeanEditorDelegate();
  }
}
