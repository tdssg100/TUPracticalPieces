package com.google.gwt.personal.tupracticalpieces.client.desktop;

public class MileageEditViewDesktop_DriverImpl extends com.google.web.bindery.requestfactory.gwt.client.impl.AbstractRequestFactoryEditorDriver<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy, com.google.gwt.personal.tupracticalpieces.client.desktop.MileageEditViewDesktop> implements com.google.gwt.personal.tupracticalpieces.client.desktop.MileageEditViewDesktop.Driver {
  @Override public void accept(com.google.gwt.editor.client.EditorVisitor visitor) {
    com.google.gwt.editor.client.impl.RootEditorContext ctx = new com.google.gwt.editor.client.impl.RootEditorContext(getDelegate(), com.google.gwt.personal.tupracticalpieces.shared.MileageProxy.class, getObject());
    ctx.traverse(visitor, getDelegate());
  }
  @Override protected com.google.web.bindery.requestfactory.gwt.client.impl.RequestFactoryEditorDelegate createDelegate() {
    return new com.google.gwt.personal.tupracticalpieces.client.desktop.MileageEditViewDesktop_RequestFactoryEditorDelegate();
  }
}
