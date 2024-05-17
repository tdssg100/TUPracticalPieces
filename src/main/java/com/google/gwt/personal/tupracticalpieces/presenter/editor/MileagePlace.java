package com.google.gwt.personal.tupracticalpieces.presenter.editor;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class MileagePlace extends Place {

	@Prefix("admin")
	public static class Tokenizer implements PlaceTokenizer<MileagePlace> {
//	    public TaskPlace getPlace(String token) {
	    //public abstract MileagePlace getPlace(String token);
	    public MileagePlace getPlace(String token) {
	    	return null;
	    }
//		@Override
//		public abstract String getToken(MileagePlace place);
		@Override
		public String getToken(MileagePlace place) {
			return null;
		}
	  }

}

