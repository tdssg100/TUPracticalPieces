package com.google.web.bindery.requestfactory.shared;

public class EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory extends com.google.web.bindery.autobean.shared.impl.AbstractAutoBean<com.google.web.bindery.requestfactory.shared.EntityProxy> {
  private final com.google.web.bindery.requestfactory.shared.EntityProxy shim = new com.google.web.bindery.requestfactory.shared.EntityProxy() {
    public com.google.web.bindery.requestfactory.shared.EntityProxyId stableId()  {
      com.google.web.bindery.requestfactory.shared.EntityProxyId toReturn = (com.google.web.bindery.requestfactory.shared.EntityProxyId) EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory.this.getWrapped().stableId();
      toReturn = com.google.web.bindery.requestfactory.shared.impl.BaseProxyCategory.__intercept(EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory.this, toReturn);
      EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory.this.call("stableId", toReturn );
      return toReturn;
    }
    @Override public boolean equals(Object o) {
      return this == o || getWrapped().equals(o);
    }
    @Override public int hashCode() {
      return getWrapped().hashCode();
    }
    @Override public String toString() {
      return getWrapped().toString();
    }
  };
  { com.google.gwt.core.client.impl.WeakMapping.set(shim, com.google.web.bindery.autobean.shared.AutoBean.class.getName(), this); }
  public EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory(com.google.web.bindery.autobean.shared.AutoBeanFactory factory) {super(factory);}
  public EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory(com.google.web.bindery.autobean.shared.AutoBeanFactory factory, com.google.web.bindery.requestfactory.shared.EntityProxy wrapped) {
    super(wrapped, factory);
  }
  public com.google.web.bindery.requestfactory.shared.EntityProxy as() {return shim;}
  public Class<com.google.web.bindery.requestfactory.shared.EntityProxy> getType() {return com.google.web.bindery.requestfactory.shared.EntityProxy.class;}
  @Override protected com.google.web.bindery.requestfactory.shared.EntityProxy createSimplePeer() {
    return new com.google.web.bindery.requestfactory.shared.EntityProxy() {
      private final com.google.web.bindery.autobean.shared.Splittable data = com.google.web.bindery.requestfactory.shared.EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory.this.data;
      public com.google.web.bindery.requestfactory.shared.EntityProxyId stableId()  {
        return com.google.web.bindery.requestfactory.shared.impl.EntityProxyCategory.stableId(EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory.this);
      }
      public boolean equals(java.lang.Object other)  {
        return com.google.web.bindery.requestfactory.shared.impl.EntityProxyCategory.equals(EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory.this, other);
      }
      public int hashCode()  {
        return com.google.web.bindery.requestfactory.shared.impl.EntityProxyCategory.hashCode(EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory.this);
      }
    };
  }
  @Override protected void traverseProperties(com.google.web.bindery.autobean.shared.AutoBeanVisitor visitor, com.google.web.bindery.autobean.shared.impl.AbstractAutoBean.OneShotContext ctx) {
    com.google.web.bindery.autobean.shared.impl.AbstractAutoBean bean;
    Object value;
    com.google.web.bindery.autobean.gwt.client.impl.ClientPropertyContext propertyContext;
    com.google.web.bindery.requestfactory.shared.EntityProxy as = as();
  }
}
