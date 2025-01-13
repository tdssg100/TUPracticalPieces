package com.google.gwt.personal.tupracticalpieces.presenter.list;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.event.shared.EventBus;


public interface PresentsWidgets extends IsWidget {

  String mayStop();
  
  void start(EventBus eventBus);

  void stop();
}
