package com.google.gwt.personal.tupracticalpieces.shared;

public class MileageRequestFactoryImpl_FactoryImpl extends com.google.web.bindery.autobean.gwt.client.impl.AbstractAutoBeanFactory implements com.google.gwt.personal.tupracticalpieces.shared.MileageRequestFactoryImpl.Factory {
  @Override protected void initializeCreatorMap(com.google.web.bindery.autobean.gwt.client.impl.JsniCreatorMap map) {
    map.add(com.google.gwt.personal.tupracticalpieces.shared.MileageProxy.class, getConstructors_com_google_gwt_personal_tupracticalpieces_shared_MileageProxy());
    map.add(com.google.web.bindery.requestfactory.shared.EntityProxy.class, getConstructors_com_google_web_bindery_requestfactory_shared_EntityProxy());
  }
  private native com.google.gwt.core.client.JsArray<com.google.gwt.core.client.JavaScriptObject> getConstructors_com_google_gwt_personal_tupracticalpieces_shared_MileageProxy() /*-{
    return [
      @com.google.gwt.personal.tupracticalpieces.shared.MileageProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;),
      @com.google.gwt.personal.tupracticalpieces.shared.MileageProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;Lcom/google/gwt/personal/tupracticalpieces/shared/MileageProxy;)
    ];
  }-*/;
  private native com.google.gwt.core.client.JsArray<com.google.gwt.core.client.JavaScriptObject> getConstructors_com_google_web_bindery_requestfactory_shared_EntityProxy() /*-{
    return [
      @com.google.web.bindery.requestfactory.shared.EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;),
      @com.google.web.bindery.requestfactory.shared.EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;Lcom/google/web/bindery/requestfactory/shared/EntityProxy;)
    ];
  }-*/;
  private native com.google.gwt.core.client.JsArray<com.google.gwt.core.client.JavaScriptObject> getConstructors_com_google_web_bindery_requestfactory_shared_EntityProxyId() /*-{
    return [
      @com.google.web.bindery.requestfactory.shared.EntityProxyIdAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;),
      @com.google.web.bindery.requestfactory.shared.EntityProxyIdAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;Lcom/google/web/bindery/requestfactory/shared/EntityProxyId;)
    ];
  }-*/;
  @Override protected void initializeEnumMap() {
  }
  public com.google.web.bindery.autobean.shared.AutoBean com_google_gwt_personal_tupracticalpieces_shared_MileageProxy() {
    return new com.google.gwt.personal.tupracticalpieces.shared.MileageProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory(MileageRequestFactoryImpl_FactoryImpl.this);
  }
  public com.google.web.bindery.autobean.shared.AutoBean com_google_web_bindery_requestfactory_shared_EntityProxy() {
    return new com.google.web.bindery.requestfactory.shared.EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory(MileageRequestFactoryImpl_FactoryImpl.this);
  }
}
