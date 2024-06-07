package com.google.gwt.personal.tupracticalpieces.database;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2024-06-07T06:06:02.352+0900")
@StaticMetamodel(Mileage.class)
public class Mileage_ {
	public static volatile SingularAttribute<Mileage, Long> id;
	public static volatile SingularAttribute<Mileage, String> supplyDate;
	public static volatile SingularAttribute<Mileage, BigDecimal> quantity;
	public static volatile SingularAttribute<Mileage, Integer> unitPrice;
	public static volatile SingularAttribute<Mileage, Integer> totalPrice;
	public static volatile SingularAttribute<Mileage, BigDecimal> bsMileage;
	public static volatile SingularAttribute<Mileage, BigDecimal> totalMileage;
}
