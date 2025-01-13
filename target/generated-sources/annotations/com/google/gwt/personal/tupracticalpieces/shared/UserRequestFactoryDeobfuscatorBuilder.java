// Automatically Generated -- DO NOT EDIT
// com.google.gwt.personal.tupracticalpieces.shared.UserRequestFactory
package com.google.gwt.personal.tupracticalpieces.shared;
import java.util.Arrays;
import com.google.web.bindery.requestfactory.vm.impl.OperationData;
import com.google.web.bindery.requestfactory.vm.impl.OperationKey;
import com.google.gwt.core.shared.GwtIncompatible;
@GwtIncompatible("Server-side only but loaded through naming convention so must be in same package as shared UserRequestFactory interface")
public final class UserRequestFactoryDeobfuscatorBuilder extends com.google.web.bindery.requestfactory.vm.impl.Deobfuscator.Builder {
{
withOperation(new OperationKey("JlLtvaWCKAu3gbcAtkNPd84AzhY="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/util/List;")
  .withMethodName("findAllUsers")
  .withRequestContext("com.google.gwt.personal.tupracticalpieces.shared.UserRequest")
  .build());
withOperation(new OperationKey("$u5uT21dd6zh8tneJYOviagW$Hc="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/Long;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/Long;)Lcom/google/gwt/personal/tupracticalpieces/database/User;")
  .withMethodName("findUser")
  .withRequestContext("com.google.gwt.personal.tupracticalpieces.shared.UserRequest")
  .build());
withOperation(new OperationKey("Af5ZZA4W_haEcmSSJ3w21cx73g0="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("persist")
  .withRequestContext("com.google.gwt.personal.tupracticalpieces.shared.UserRequest")
  .build());
withOperation(new OperationKey("_jWHZvt8HO_dmf2FPea62WR2sb8="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("remove")
  .withRequestContext("com.google.gwt.personal.tupracticalpieces.shared.UserRequest")
  .build());
withRawTypeToken("z7eYGoOya1dmmCqsoOWemSMF3Tw=", "com.google.gwt.personal.tupracticalpieces.shared.UserProxy");
withRawTypeToken("w1Qg$YHpDaNcHrR5HZ$23y518nA=", "com.google.web.bindery.requestfactory.shared.EntityProxy");
withRawTypeToken("FXHD5YU0TiUl3uBaepdkYaowx9k=", "com.google.web.bindery.requestfactory.shared.BaseProxy");
withClientToDomainMappings("com.google.gwt.personal.tupracticalpieces.database.User", Arrays.asList("com.google.gwt.personal.tupracticalpieces.shared.UserProxy"));
}}
