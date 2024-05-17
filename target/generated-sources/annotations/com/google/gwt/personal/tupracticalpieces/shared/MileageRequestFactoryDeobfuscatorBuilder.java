// Automatically Generated -- DO NOT EDIT
// com.google.gwt.personal.tupracticalpieces.shared.MileageRequestFactory
package com.google.gwt.personal.tupracticalpieces.shared;
import java.util.Arrays;
import com.google.web.bindery.requestfactory.vm.impl.OperationData;
import com.google.web.bindery.requestfactory.vm.impl.OperationKey;
import com.google.gwt.core.shared.GwtIncompatible;
@GwtIncompatible("Server-side only but loaded through naming convention so must be in same package as shared MileageRequestFactory interface")
public final class MileageRequestFactoryDeobfuscatorBuilder extends com.google.web.bindery.requestfactory.vm.impl.Deobfuscator.Builder {
{
withOperation(new OperationKey("H7b7N2bBXgqDqnfphqicNcq0J8E="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/util/List;")
  .withMethodName("findAllMileages")
  .withRequestContext("com.google.gwt.personal.tupracticalpieces.shared.MileageRequest")
  .build());
withOperation(new OperationKey("_4k3Iz4SD5PcbBJTQEI4kaP$Ljg="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/Long;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/Long;)Lcom/google/gwt/personal/tupracticalpieces/database/Mileage;")
  .withMethodName("findMileage")
  .withRequestContext("com.google.gwt.personal.tupracticalpieces.shared.MileageRequest")
  .build());
withOperation(new OperationKey("J1PEuib$rinyWfjkXqGF77yk$PM="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("persist")
  .withRequestContext("com.google.gwt.personal.tupracticalpieces.shared.MileageRequest")
  .build());
withOperation(new OperationKey("6wwt2VVxZ$$17ZCpIaute6KQl3k="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("remove")
  .withRequestContext("com.google.gwt.personal.tupracticalpieces.shared.MileageRequest")
  .build());
withRawTypeToken("dVAbArmAZ8V2oHLvRrt7cnomkoE=", "com.google.gwt.personal.tupracticalpieces.shared.MileageProxy");
withRawTypeToken("w1Qg$YHpDaNcHrR5HZ$23y518nA=", "com.google.web.bindery.requestfactory.shared.EntityProxy");
withRawTypeToken("FXHD5YU0TiUl3uBaepdkYaowx9k=", "com.google.web.bindery.requestfactory.shared.BaseProxy");
withClientToDomainMappings("com.google.gwt.personal.tupracticalpieces.database.Mileage", Arrays.asList("com.google.gwt.personal.tupracticalpieces.shared.MileageProxy"));
}}
