package com.google.gwt.personal.tupracticalpieces.client;

import com.google.gwt.personal.tupracticalpieces.database.Mileage;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

import java.util.Date;
import java.util.List;
//import java.sql.Date;
import com.google.gwt.personal.tupracticalpieces.shared.MileageProxy;

/**
 * Remote request for {@link Mileagea}.
 */
@Service(Mileage.class)
public interface MileageRequest extends RequestContext {

  /**
   * Create a {@link Request} for all Mileages.
   * 
   * @return a {@link Request}
   */
  Request<List<MileageProxy>> findAllMileages();

  /**
   * Create a {@link Request} to find a Mileage by id.
   * 
   * @param id the Mileage id
   * @return a {@link Request}
   */
  Request<MileageProxy> findMileage(Long id);
//  Request<MileageProxy> findMileage(Date dueDate);

  /**
   * Persist a Mileage instance in the datastore.
   * 
   * @return an {@link InstanceRequest}
   */
  InstanceRequest<MileageProxy, Void> persist();

  /**
   * Remove a Mileage instance from the datastore.
   * 
   * @return an {@link InstanceRequest}
   */
  InstanceRequest<MileageProxy, Void> remove();
}
