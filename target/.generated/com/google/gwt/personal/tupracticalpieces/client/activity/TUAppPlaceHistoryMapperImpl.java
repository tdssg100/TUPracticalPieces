package com.google.gwt.personal.tupracticalpieces.client.activity;

import com.google.gwt.place.impl.AbstractPlaceHistoryMapper;
import com.google.gwt.personal.tupracticalpieces.client.activity.TUAppPlaceHistoryMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.impl.AbstractPlaceHistoryMapper.PrefixAndToken;
import com.google.gwt.core.client.GWT;

public class TUAppPlaceHistoryMapperImpl extends AbstractPlaceHistoryMapper<Void> implements TUAppPlaceHistoryMapper {
  
  protected PrefixAndToken getPrefixAndToken(Place newPlace) {
    if (newPlace instanceof com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace) {
      com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace place = (com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace) newPlace;
      PlaceTokenizer<com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace> t = GWT.create(com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace.Tokenizer.class);
      return new PrefixAndToken("mileedit", t.getToken((com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace) place));
    }
    if (newPlace instanceof com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace) {
      com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace place = (com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace) newPlace;
      PlaceTokenizer<com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace> t = GWT.create(com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace.Tokenizer.class);
      return new PrefixAndToken("ml", t.getToken((com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace) place));
    }
    return null;
  }
  
  protected PlaceTokenizer<?> getTokenizer(String prefix) {
    if ("mileedit".equals(prefix)) {
      return GWT.create(com.google.gwt.personal.tupracticalpieces.presenter.editor.MileageEditPlace.Tokenizer.class);
    }
    if ("ml".equals(prefix)) {
      return GWT.create(com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace.Tokenizer.class);
    }
    return null;
  }

}
