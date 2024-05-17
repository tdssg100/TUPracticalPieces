package com.google.gwt.personal.tupracticalpieces.shared;

public class MileageRequestImpl extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequestContext implements com.google.gwt.personal.tupracticalpieces.shared.MileageRequest {
  public MileageRequestImpl(com.google.web.bindery.requestfactory.shared.impl.AbstractRequestFactory requestFactory) {super(requestFactory, com.google.web.bindery.requestfactory.shared.impl.AbstractRequestContext.Dialect.STANDARD);}
  @com.google.web.bindery.autobean.shared.AutoBeanFactory.Category({com.google.web.bindery.requestfactory.shared.impl.EntityProxyCategory.class, com.google.web.bindery.requestfactory.shared.impl.ValueProxyCategory.class, com.google.web.bindery.requestfactory.shared.impl.BaseProxyCategory.class})
  @com.google.web.bindery.autobean.shared.AutoBeanFactory.NoWrap(com.google.web.bindery.requestfactory.shared.EntityProxyId.class)
  interface Factory extends com.google.web.bindery.autobean.shared.AutoBeanFactory {
    com.google.web.bindery.autobean.shared.AutoBean<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy> com_google_gwt_personal_tupracticalpieces_shared_MileageProxy();
  }
  public static Factory FACTORY;
  @Override public Factory getAutoBeanFactory() {
    if (FACTORY == null) {
      FACTORY = com.google.gwt.core.client.GWT.create(Factory.class);
    }
    return FACTORY;
  }
  public  com.google.web.bindery.requestfactory.shared.Request<java.util.List<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy>> findAllMileages() {
    class X extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequest<com.google.web.bindery.requestfactory.shared.BaseProxy, java.util.List<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy>> implements com.google.web.bindery.requestfactory.shared.Request<java.util.List<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy>> {
      public X() { super(MileageRequestImpl.this);}
      @Override public X with(String... paths) {super.with(paths); return this;}
      @Override protected com.google.web.bindery.requestfactory.shared.impl.RequestData makeRequestData() {
        return new com.google.web.bindery.requestfactory.shared.impl.RequestData("H7b7N2bBXgqDqnfphqicNcq0J8E=", new Object[] {}, propertyRefs, java.util.List.class, com.google.gwt.personal.tupracticalpieces.shared.MileageProxy.class);
      }
    }
    X x = new X();
    addInvocation(x);
    return x;
  }
  public  com.google.web.bindery.requestfactory.shared.Request<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy> findMileage(final java.lang.Long id) {
    class X extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequest<com.google.web.bindery.requestfactory.shared.BaseProxy, com.google.gwt.personal.tupracticalpieces.shared.MileageProxy> implements com.google.web.bindery.requestfactory.shared.Request<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy> {
      public X() { super(MileageRequestImpl.this);}
      @Override public X with(String... paths) {super.with(paths); return this;}
      @Override protected com.google.web.bindery.requestfactory.shared.impl.RequestData makeRequestData() {
        return new com.google.web.bindery.requestfactory.shared.impl.RequestData("_4k3Iz4SD5PcbBJTQEI4kaP$Ljg=", new Object[] {id}, propertyRefs, com.google.gwt.personal.tupracticalpieces.shared.MileageProxy.class, null);
      }
    }
    X x = new X();
    addInvocation(x);
    return x;
  }
  public  com.google.web.bindery.requestfactory.shared.InstanceRequest<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy, java.lang.Void> persist() {
    class X extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequest<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy, java.lang.Void> implements com.google.web.bindery.requestfactory.shared.InstanceRequest<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy, java.lang.Void> {
      public X() { super(MileageRequestImpl.this);}
      @Override public X with(String... paths) {super.with(paths); return this;}
      @Override protected com.google.web.bindery.requestfactory.shared.impl.RequestData makeRequestData() {
        return new com.google.web.bindery.requestfactory.shared.impl.RequestData("J1PEuib$rinyWfjkXqGF77yk$PM=", new Object[] {null}, propertyRefs, java.lang.Void.class, null);
      }
    }
    X x = new X();
    return x;
  }
  public  com.google.web.bindery.requestfactory.shared.InstanceRequest<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy, java.lang.Void> remove() {
    class X extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequest<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy, java.lang.Void> implements com.google.web.bindery.requestfactory.shared.InstanceRequest<com.google.gwt.personal.tupracticalpieces.shared.MileageProxy, java.lang.Void> {
      public X() { super(MileageRequestImpl.this);}
      @Override public X with(String... paths) {super.with(paths); return this;}
      @Override protected com.google.web.bindery.requestfactory.shared.impl.RequestData makeRequestData() {
        return new com.google.web.bindery.requestfactory.shared.impl.RequestData("6wwt2VVxZ$$17ZCpIaute6KQl3k=", new Object[] {null}, propertyRefs, java.lang.Void.class, null);
      }
    }
    X x = new X();
    return x;
  }
}
