package com.google.gwt.personal.tupracticalpieces.client.content;

public class AdminMileageEditView_DriverImpl extends com.google.web.bindery.requestfactory.gwt.client.impl.AbstractRequestFactoryEditorDriver<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy, com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView> implements com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView.Driver {
  @Override public void accept(com.google.gwt.editor.client.EditorVisitor visitor) {
    com.google.gwt.editor.client.impl.RootEditorContext ctx = new com.google.gwt.editor.client.impl.RootEditorContext(getDelegate(), com.google.gwt.personal.tupracticalpieces.shared.MileageProxy.class, getObject());
    ctx.traverse(visitor, getDelegate());
  }
  @Override protected com.google.web.bindery.requestfactory.gwt.client.impl.RequestFactoryEditorDelegate createDelegate() {
    return new com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_RequestFactoryEditorDelegate();
  }
}
