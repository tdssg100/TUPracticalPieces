// .ui.xml template last modified: 1722478530320
package com.google.gwt.personal.tupracticalpieces.client.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AdminMileageEditView_AdminMileageEditViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView>, com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView.AdminMileageEditViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("Save")
    SafeHtml html1();
     
    @Template("Delete Item")
    SafeHtml html2();
     
    @Template("<table align='center' cellspacing='10'> <tr> <td align='center' class='{0}' colspan='2'>Mileage Details</td> </tr>   <tr> <td class='{1}'>Supply date:</td> <td> <span id='{2}'></span> </td> </tr>  <tr> <td class='{3}'>Quantity:</td> <td class='{4}'> <span id='{5}'></span> </td> </tr>  <tr> <td class='{6}'>UnitPrice:</td> <td class='{7}'> <span id='{8}'></span> </td> </tr>  <tr> <td class='{9}'>TotalPrice:</td> <td class='{10}'> <span id='{11}'></span> </td> </tr>  <tr> <td class='{12}'>BsMileage:</td> <td class='{13}'> <span id='{14}'></span> </td> </tr>  <tr> <td class='{15}'>TotalMileage:</td> <td class='{16}'> <span id='{17}'></span> </td> </tr>                                  <tr class='{18}'> <td></td> <td align='center'> <span id='{19}'></span> <span id='{20}'></span> </td> </tr>  <tr> <td> <span id='{21}'></span> </td> </tr> </table>")
    SafeHtml html3(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20, String arg21);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView owner) {


    return new Widgets(owner).get_dockLayoutPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView owner;


    public Widgets(final com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3("" + get_style().title() + "", "" + get_style().label() + "", get_domId0(), "" + get_style().label() + "", "" + get_style().textBoxWrapper() + "", get_domId1(), "" + get_style().label() + "", "" + get_style().textBoxWrapper() + "", get_domId2(), "" + get_style().label() + "", "" + get_style().textBoxWrapper() + "", get_domId3(), "" + get_style().label() + "", "" + get_style().textBoxWrapper() + "", get_domId4(), "" + get_style().label() + "", "" + get_style().textBoxWrapper() + "", get_domId5(), "" + get_style().buttonPanel() + "", get_domId6(), get_domId7(), get_domId8());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenBundle) GWT.create(com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenBundle.class);
      // Setup section.

      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 26 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenCss_style style;
    private com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView_AdminMileageEditViewUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();

      return style;
    }

    /**
     * Getter for dockLayoutPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.DockLayoutPanel get_dockLayoutPanel() {
      return build_dockLayoutPanel();
    }
    private com.google.gwt.user.client.ui.DockLayoutPanel build_dockLayoutPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.DockLayoutPanel dockLayoutPanel = new com.google.gwt.user.client.ui.DockLayoutPanel(com.google.gwt.dom.client.Style.Unit.PX);
      // Setup section.
      dockLayoutPanel.add(get_editForm());

      this.owner.dockLayoutPanel = dockLayoutPanel;

      return dockLayoutPanel;
    }

    /**
     * Getter for editForm called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_editForm() {
      return build_editForm();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_editForm() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel editForm = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      editForm.addStyleName("" + get_style().editForm() + "");

      {
        // Attach section.
        UiBinderUtil.TempAttachment __attachRecord__ = UiBinderUtil.attachToDom(editForm.getElement());

        get_domId0Element().get();
        get_domId1Element().get();
        get_domId2Element().get();
        get_domId3Element().get();
        get_domId4Element().get();
        get_domId5Element().get();
        get_domId6Element().get();
        get_domId7Element().get();
        get_domId8Element().get();

        // Detach section.
        __attachRecord__.detach();
      }
      editForm.addAndReplaceElement(get_supplyDateEditor(), get_domId0Element().get());
      editForm.addAndReplaceElement(get_quantityEditor(), get_domId1Element().get());
      editForm.addAndReplaceElement(get_unitPriceEditor(), get_domId2Element().get());
      editForm.addAndReplaceElement(get_totalPriceEditor(), get_domId3Element().get());
      editForm.addAndReplaceElement(get_bsMileageEditor(), get_domId4Element().get());
      editForm.addAndReplaceElement(get_totalMileageEditor(), get_domId5Element().get());
      editForm.addAndReplaceElement(get_saveButton(), get_domId6Element().get());
      editForm.addAndReplaceElement(get_deleteButton(), get_domId7Element().get());
      editForm.addAndReplaceElement(get_contentDiv(), get_domId8Element().get());

      this.owner.editForm = editForm;

      return editForm;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId0;
    }

    /**
     * Getter for supplyDateEditor called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.personal.tupracticalpieces.client.ui.DateButton get_supplyDateEditor() {
      return build_supplyDateEditor();
    }
    private com.google.gwt.personal.tupracticalpieces.client.ui.DateButton build_supplyDateEditor() {
      // Creation section.
      final com.google.gwt.personal.tupracticalpieces.client.ui.DateButton supplyDateEditor = (com.google.gwt.personal.tupracticalpieces.client.ui.DateButton) GWT.create(com.google.gwt.personal.tupracticalpieces.client.ui.DateButton.class);
      // Setup section.
      supplyDateEditor.addStyleName("" + get_style().field() + "");
      supplyDateEditor.addStyleName("" + get_style().button() + "");
      supplyDateEditor.addStyleName("" + get_style().dateButton() + "");

      this.owner.supplyDateEditor = supplyDateEditor;

      return supplyDateEditor;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.

      return domId0Element;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId1;
    private java.lang.String get_domId1() {
      return domId1;
    }
    private java.lang.String build_domId1() {
      // Creation section.
      domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId1;
    }

    /**
     * Getter for quantityEditor called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox get_quantityEditor() {
      return build_quantityEditor();
    }
    private com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox build_quantityEditor() {
      // Creation section.
      final com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox quantityEditor = (com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox) GWT.create(com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox.class);
      // Setup section.
      quantityEditor.addStyleName("" + get_style().field() + "");

      this.owner.quantityEditor = quantityEditor;

      return quantityEditor;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId1Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId1Element() {
      return domId1Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId1Element() {
      // Creation section.
      domId1Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId1());
      // Setup section.

      return domId1Element;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId2;
    private java.lang.String get_domId2() {
      return domId2;
    }
    private java.lang.String build_domId2() {
      // Creation section.
      domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId2;
    }

    /**
     * Getter for unitPriceEditor called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.IntegerBox get_unitPriceEditor() {
      return build_unitPriceEditor();
    }
    private com.google.gwt.user.client.ui.IntegerBox build_unitPriceEditor() {
      // Creation section.
      final com.google.gwt.user.client.ui.IntegerBox unitPriceEditor = (com.google.gwt.user.client.ui.IntegerBox) GWT.create(com.google.gwt.user.client.ui.IntegerBox.class);
      // Setup section.
      unitPriceEditor.addStyleName("" + get_style().field() + "");

      this.owner.unitPriceEditor = unitPriceEditor;

      return unitPriceEditor;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId2Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId2Element() {
      return domId2Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId2Element() {
      // Creation section.
      domId2Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId2());
      // Setup section.

      return domId2Element;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId3;
    private java.lang.String get_domId3() {
      return domId3;
    }
    private java.lang.String build_domId3() {
      // Creation section.
      domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId3;
    }

    /**
     * Getter for totalPriceEditor called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.IntegerBox get_totalPriceEditor() {
      return build_totalPriceEditor();
    }
    private com.google.gwt.user.client.ui.IntegerBox build_totalPriceEditor() {
      // Creation section.
      final com.google.gwt.user.client.ui.IntegerBox totalPriceEditor = (com.google.gwt.user.client.ui.IntegerBox) GWT.create(com.google.gwt.user.client.ui.IntegerBox.class);
      // Setup section.
      totalPriceEditor.addStyleName("" + get_style().field() + "");

      this.owner.totalPriceEditor = totalPriceEditor;

      return totalPriceEditor;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId3Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId3Element() {
      return domId3Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId3Element() {
      // Creation section.
      domId3Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId3());
      // Setup section.

      return domId3Element;
    }

    /**
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId4;
    private java.lang.String get_domId4() {
      return domId4;
    }
    private java.lang.String build_domId4() {
      // Creation section.
      domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId4;
    }

    /**
     * Getter for bsMileageEditor called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox get_bsMileageEditor() {
      return build_bsMileageEditor();
    }
    private com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox build_bsMileageEditor() {
      // Creation section.
      final com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox bsMileageEditor = (com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox) GWT.create(com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox.class);
      // Setup section.
      bsMileageEditor.addStyleName("" + get_style().field() + "");

      this.owner.bsMileageEditor = bsMileageEditor;

      return bsMileageEditor;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId4Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId4Element() {
      return domId4Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId4Element() {
      // Creation section.
      domId4Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId4());
      // Setup section.

      return domId4Element;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId5;
    private java.lang.String get_domId5() {
      return domId5;
    }
    private java.lang.String build_domId5() {
      // Creation section.
      domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId5;
    }

    /**
     * Getter for totalMileageEditor called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox get_totalMileageEditor() {
      return build_totalMileageEditor();
    }
    private com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox build_totalMileageEditor() {
      // Creation section.
      final com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox totalMileageEditor = (com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox) GWT.create(com.google.gwt.personal.tupracticalpieces.client.ui.DecimalBox.class);
      // Setup section.
      totalMileageEditor.addStyleName("" + get_style().field() + "");

      this.owner.totalMileageEditor = totalMileageEditor;

      return totalMileageEditor;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId5Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId5Element() {
      return domId5Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId5Element() {
      // Creation section.
      domId5Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId5());
      // Setup section.

      return domId5Element;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId6;
    private java.lang.String get_domId6() {
      return domId6;
    }
    private java.lang.String build_domId6() {
      // Creation section.
      domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId6;
    }

    /**
     * Getter for saveButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_saveButton() {
      return build_saveButton();
    }
    private com.google.gwt.user.client.ui.Button build_saveButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button saveButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      saveButton.setHTML(template_html1().asString());
      saveButton.addStyleName("" + get_style().button() + "");
      saveButton.addStyleName("" + get_style().saveButton() + "");

      this.owner.saveButton = saveButton;

      return saveButton;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId6Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId6Element() {
      return domId6Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId6Element() {
      // Creation section.
      domId6Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId6());
      // Setup section.

      return domId6Element;
    }

    /**
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId7;
    private java.lang.String get_domId7() {
      return domId7;
    }
    private java.lang.String build_domId7() {
      // Creation section.
      domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId7;
    }

    /**
     * Getter for deleteButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_deleteButton() {
      return build_deleteButton();
    }
    private com.google.gwt.user.client.ui.Button build_deleteButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button deleteButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      deleteButton.setHTML(template_html2().asString());
      deleteButton.addStyleName("" + get_style().button() + "");
      deleteButton.addStyleName("" + get_style().deleteButton() + "");

      this.owner.deleteButton = deleteButton;

      return deleteButton;
    }

    /**
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId7Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId7Element() {
      return domId7Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId7Element() {
      // Creation section.
      domId7Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId7());
      // Setup section.

      return domId7Element;
    }

    /**
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId8;
    private java.lang.String get_domId8() {
      return domId8;
    }
    private java.lang.String build_domId8() {
      // Creation section.
      domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId8;
    }

    /**
     * Getter for contentDiv called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_contentDiv() {
      return build_contentDiv();
    }
    private com.google.gwt.user.client.ui.HTML build_contentDiv() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML contentDiv = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.

      this.owner.contentDiv = contentDiv;

      return contentDiv;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId8Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId8Element() {
      return domId8Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId8Element() {
      // Creation section.
      domId8Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId8());
      // Setup section.

      return domId8Element;
    }
  }
}
