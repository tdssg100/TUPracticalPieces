// .ui.xml template last modified: 1721026362639
package com.google.gwt.personal.tupracticalpieces.client.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AdminMileageView_AdminMileageViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView>, com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView.AdminMileageViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView owner) {


    return new Widgets(owner).get_f_ScrollPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView owner;


    public Widgets(final com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView_AdminMileageViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView_AdminMileageViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView_AdminMileageViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView_AdminMileageViewUiBinderImpl_GenBundle) GWT.create(com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView_AdminMileageViewUiBinderImpl_GenBundle.class);
      // Setup section.

      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView_AdminMileageViewUiBinderImpl_GenCss_style get_style() {
      return build_style();
    }
    private com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView_AdminMileageViewUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      final com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageView_AdminMileageViewUiBinderImpl_GenCss_style style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();

      return style;
    }

    /**
     * Getter for f_ScrollPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_f_ScrollPanel1() {
      return build_f_ScrollPanel1();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_f_ScrollPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel1 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      f_ScrollPanel1.add(get_mileageList());

      return f_ScrollPanel1;
    }

    /**
     * Getter for mileageList called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.cellview.client.DataGrid get_mileageList() {
      return build_mileageList();
    }
    private com.google.gwt.user.cellview.client.DataGrid build_mileageList() {
      // Creation section.
      final com.google.gwt.user.cellview.client.DataGrid mileageList = (com.google.gwt.user.cellview.client.DataGrid) GWT.create(com.google.gwt.user.cellview.client.DataGrid.class);
      // Setup section.

      return mileageList;
    }
  }
}
