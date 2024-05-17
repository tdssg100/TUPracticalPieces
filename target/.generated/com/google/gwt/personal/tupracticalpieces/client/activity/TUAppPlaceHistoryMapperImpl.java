package com.google.gwt.personal.tupracticalpieces.client.activity;

import com.google.gwt.place.impl.AbstractPlaceHistoryMapper;
import com.google.gwt.personal.tupracticalpieces.client.activity.TUAppPlaceHistoryMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.impl.AbstractPlaceHistoryMapper.PrefixAndToken;
import com.google.gwt.core.client.GWT;

public class TUAppPlaceHistoryMapperImpl extends AbstractPlaceHistoryMapper<Void> implements TUAppPlaceHistoryMapper {
  
  protected PrefixAndToken getPrefixAndToken(Place newPlace) {
    if (newPlace instanceof com.google.gwt.personal.tupracticalpieces.presenter.editor.MileagePlace) {
      com.google.gwt.personal.tupracticalpieces.presenter.editor.MileagePlace place = (com.google.gwt.personal.tupracticalpieces.presenter.editor.MileagePlace) newPlace;
      PlaceTokenizer<com.google.gwt.personal.tupracticalpieces.presenter.editor.MileagePlace> t = GWT.create(com.google.gwt.personal.tupracticalpieces.presenter.editor.MileagePlace.Tokenizer.class);
      return new PrefixAndToken("admin", t.getToken((com.google.gwt.personal.tupracticalpieces.presenter.editor.MileagePlace) place));
    }
    if (newPlace instanceof com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace) {
      com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace place = (com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace) newPlace;
      PlaceTokenizer<com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace> t = GWT.create(com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace.Tokenizer.class);
      return new PrefixAndToken("!AdminMileageView", t.getToken((com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace) place));
    }
    return null;
  }
  
  protected PlaceTokenizer<?> getTokenizer(String prefix) {
    if ("admin".equals(prefix)) {
      return GWT.create(com.google.gwt.personal.tupracticalpieces.presenter.editor.MileagePlace.Tokenizer.class);
    }
    if ("!AdminMileageView".equals(prefix)) {
      return GWT.create(com.google.gwt.personal.tupracticalpieces.presenter.list.AdminMileagePlace.Tokenizer.class);
    }
    return null;
  }

}
