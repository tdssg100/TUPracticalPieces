// .ui.xml template last modified: 1603611250241
package com.google.gwt.personal.tupracticalpieces.client.mobile;

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

public class TUPracticalPiecesShellMobile_TUPracticalPiecesShellMobileUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile>, com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile.TUPracticalPiecesShellMobileUiBinder {
  static TUPracticalPiecesShellMobileTUPracticalPiecesShellMobileUiBinderImplGenMessages messages = (TUPracticalPiecesShellMobileTUPracticalPiecesShellMobileUiBinderImplGenMessages) GWT.create(TUPracticalPiecesShellMobileTUPracticalPiecesShellMobileUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<table align='right' cellpadding='0' cellspacing='0' id='{0}'> <tr> <td class='{1}'> <a href='http://code.google.com/webtoolkit/'> {2} </a> </td> <td class='{3}'> |  </td> <td class='{4}'> <a href='http://www.gwtproject.org/examples.html'> {5} </a> </td> </tr> </table>")
    SafeHtml html1(String arg0, String arg1, SafeHtml arg2, String arg3, String arg4, SafeHtml arg5);
     
    @Template("<table cellpadding='0' cellspacing='0' width='100%'> <tr> <td style='{0}'> <span id='{1}'></span>&gt; </td>  <td> <table cellpadding='0' cellspacing='0'> <tr> <td> <span id='{2}'></span> </td> <td> <h1 class='{3}'> {4} </h1> <h2 class='{5}'> {6} </h2> </td> </tr> </table> </td> <td align='right' class='{7}' id='{8}' valign='top'> <table cellpadding='0' cellspacing='0'> <tr> <td valign='middle'> <span id='{9}'></span> </td> <td valign='middle'> <span id='{10}'></span> </td> </tr> </table> </td> </tr> </table>")
    SafeHtml html2(String arg0, String arg1, String arg2, String arg3, SafeHtml arg4, String arg5, SafeHtml arg6, String arg7, String arg8, String arg9, String arg10);
     
    @Template("{0}")
    SafeHtml html3(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html4(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html5(SafeHtml arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile owner) {


    return new Widgets(owner).get_mMenuContainer();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile owner;


    public Widgets(final com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0(), "" + get_style().link() + "", SafeHtmlUtils.fromSafeConstant(messages.message1()), "" + get_style().link() + "", "" + get_style().link() + "", SafeHtmlUtils.fromSafeConstant(messages.message2()));
    }
    SafeHtml template_html2() {
      return template.html2("" + get_style().burgerMenu() + "", get_domId1(), get_domId2(), "" + get_style().title() + "", SafeHtmlUtils.fromSafeConstant(messages.message3()), "" + get_style().subtitle() + "", SafeHtmlUtils.fromSafeConstant(messages.message4()), "" + get_style().options() + "", get_domId3(), get_domId4(), get_domId5());
    }
    SafeHtml template_html3() {
      return template.html3(SafeHtmlUtils.fromSafeConstant(messages.message5()));
    }
    SafeHtml template_html4() {
      return template.html4(SafeHtmlUtils.fromSafeConstant(messages.message6()));
    }
    SafeHtml template_html5() {
      return template.html5(SafeHtmlUtils.fromSafeConstant(messages.message7()));
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile_TUPracticalPiecesShellMobileUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile_TUPracticalPiecesShellMobileUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile_TUPracticalPiecesShellMobileUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile_TUPracticalPiecesShellMobileUiBinderImpl_GenBundle) GWT.create(com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile_TUPracticalPiecesShellMobileUiBinderImpl_GenBundle.class);
      // Setup section.

      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 2 times. Type: IMPORTED. Build precedence: 1.
     */
    private com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile res;
    private com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile get_res() {
      return res;
    }
    private com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile build_res() {
      // Creation section.
      res = (com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile) GWT.create(com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesResourcesMobile.class);
      // Setup section.

      return res;
    }

    /**
     * Getter for style called 18 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile_TUPracticalPiecesShellMobileUiBinderImpl_GenCss_style style;
    private com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile_TUPracticalPiecesShellMobileUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private com.google.gwt.personal.tupracticalpieces.client.mobile.TUPracticalPiecesShellMobile_TUPracticalPiecesShellMobileUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();

      return style;
    }

    /**
     * Getter for mMenuContainer called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.DockLayoutPanel get_mMenuContainer() {
      return build_mMenuContainer();
    }
    private com.google.gwt.user.client.ui.DockLayoutPanel build_mMenuContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.DockLayoutPanel mMenuContainer = new com.google.gwt.user.client.ui.DockLayoutPanel(com.google.gwt.dom.client.Style.Unit.PT);
      // Setup section.
      mMenuContainer.addNorth(get_f_HTMLPanel1(), 8);
      mMenuContainer.addNorth(get_f_HTMLPanel2(), 24);
      mMenuContainer.addWest(get_mMenuPanel(), 225);
      mMenuContainer.add(get_f_DockLayoutPanel5());

      this.owner.mMenuContainer = mMenuContainer;

      return mMenuContainer;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_style().linkBar() + "");

      {
        // Attach section.
        UiBinderUtil.TempAttachment __attachRecord__ = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());

        get_linkCell();

        // Detach section.
        __attachRecord__.detach();
      }

      return f_HTMLPanel1;
    }

    /**
     * Getter for linkCell called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.dom.client.TableElement get_linkCell() {
      return build_linkCell();
    }
    private com.google.gwt.dom.client.TableElement build_linkCell() {
      // Creation section.
      final com.google.gwt.dom.client.TableElement linkCell = new com.google.gwt.uibinder.client.LazyDomElement(get_domId0()).get().cast();
      // Setup section.

      this.owner.linkCell = linkCell;

      return linkCell;
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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_style().titleBar() + "");

      {
        // Attach section.
        UiBinderUtil.TempAttachment __attachRecord__ = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());

        get_domId1Element().get();
        get_domId2Element().get();
        get_localeSelectionCell();
        get_domId4Element().get();
        get_domId5Element().get();

        // Detach section.
        __attachRecord__.detach();
      }
      f_HTMLPanel2.addAndReplaceElement(get_burgerMenuButton(), get_domId1Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_Image3(), get_domId2Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_Image4(), get_domId4Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_localeBox(), get_domId5Element().get());

      return f_HTMLPanel2;
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
     * Getter for burgerMenuButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_burgerMenuButton() {
      return build_burgerMenuButton();
    }
    private com.google.gwt.user.client.ui.Button build_burgerMenuButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button burgerMenuButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.

      this.owner.burgerMenuButton = burgerMenuButton;

      return burgerMenuButton;
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
     * Getter for f_Image3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Image get_f_Image3() {
      return build_f_Image3();
    }
    private com.google.gwt.user.client.ui.Image build_f_Image3() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image f_Image3 = new com.google.gwt.user.client.ui.Image(get_res().gwtLogo());
      // Setup section.

      return f_Image3;
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
     * Getter for localeSelectionCell called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.dom.client.TableCellElement get_localeSelectionCell() {
      return build_localeSelectionCell();
    }
    private com.google.gwt.dom.client.TableCellElement build_localeSelectionCell() {
      // Creation section.
      final com.google.gwt.dom.client.TableCellElement localeSelectionCell = new com.google.gwt.uibinder.client.LazyDomElement(get_domId3()).get().cast();
      // Setup section.

      this.owner.localeSelectionCell = localeSelectionCell;

      return localeSelectionCell;
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
     * Getter for f_Image4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Image get_f_Image4() {
      return build_f_Image4();
    }
    private com.google.gwt.user.client.ui.Image build_f_Image4() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image f_Image4 = new com.google.gwt.user.client.ui.Image(get_res().locale());
      // Setup section.

      return f_Image4;
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
     * Getter for localeBox called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.ListBox get_localeBox() {
      return build_localeBox();
    }
    private com.google.gwt.user.client.ui.ListBox build_localeBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.ListBox localeBox = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
      // Setup section.
      localeBox.addStyleName("" + get_style().localeBox() + "");

      this.owner.localeBox = localeBox;

      return localeBox;
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
     * Getter for mMenuPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_mMenuPanel() {
      return build_mMenuPanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_mMenuPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel mMenuPanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      mMenuPanel.add(get_mainMenu());
      mMenuPanel.setStyleName("" + get_style().mainMenu() + "");

      this.owner.mMenuPanel = mMenuPanel;

      return mMenuPanel;
    }

    /**
     * Getter for mainMenu called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.cellview.client.CellTree get_mainMenu() {
      return build_mainMenu();
    }
    private com.google.gwt.user.cellview.client.CellTree build_mainMenu() {
      // Creation section.
      final com.google.gwt.user.cellview.client.CellTree mainMenu = owner.mainMenu;
      assert mainMenu != null : "UiField mainMenu with 'provided = true' was null";
      // Setup section.

      return mainMenu;
    }

    /**
     * Getter for f_DockLayoutPanel5 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.DockLayoutPanel get_f_DockLayoutPanel5() {
      return build_f_DockLayoutPanel5();
    }
    private com.google.gwt.user.client.ui.DockLayoutPanel build_f_DockLayoutPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.DockLayoutPanel f_DockLayoutPanel5 = new com.google.gwt.user.client.ui.DockLayoutPanel(com.google.gwt.dom.client.Style.Unit.PT);
      // Setup section.
      f_DockLayoutPanel5.addNorth(get_contentButtons(), 20);
      f_DockLayoutPanel5.add(get_contentContainer());
      f_DockLayoutPanel5.setStyleName("" + get_style().backgroundDocLayoutPanel() + "");

      return f_DockLayoutPanel5;
    }

    /**
     * Getter for contentButtons called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_contentButtons() {
      return build_contentButtons();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_contentButtons() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel contentButtons = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      contentButtons.add(get_tabExample());
      contentButtons.add(get_tabStyle());
      contentButtons.add(get_tabSource());
      contentButtons.add(get_tabSourceList());
      contentButtons.setStyleName("" + get_style().contentButtons() + "");

      return contentButtons;
    }

    /**
     * Getter for tabExample called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_tabExample() {
      return build_tabExample();
    }
    private com.google.gwt.user.client.ui.Anchor build_tabExample() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor tabExample = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      tabExample.setHTML(template_html3().asString());
      tabExample.addStyleName("" + get_style().contentButton() + "");

      this.owner.tabExample = tabExample;

      return tabExample;
    }

    /**
     * Getter for tabStyle called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_tabStyle() {
      return build_tabStyle();
    }
    private com.google.gwt.user.client.ui.Anchor build_tabStyle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor tabStyle = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      tabStyle.setHTML(template_html4().asString());
      tabStyle.addStyleName("" + get_style().contentButton() + "");

      this.owner.tabStyle = tabStyle;

      return tabStyle;
    }

    /**
     * Getter for tabSource called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_tabSource() {
      return build_tabSource();
    }
    private com.google.gwt.user.client.ui.Anchor build_tabSource() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor tabSource = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      tabSource.setHTML(template_html5().asString());
      tabSource.addStyleName("" + get_style().contentButton() + "");
      tabSource.addStyleName("" + get_style().contentButtonSource() + "");

      this.owner.tabSource = tabSource;

      return tabSource;
    }

    /**
     * Getter for tabSourceList called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.ListBox get_tabSourceList() {
      return build_tabSourceList();
    }
    private com.google.gwt.user.client.ui.ListBox build_tabSourceList() {
      // Creation section.
      final com.google.gwt.user.client.ui.ListBox tabSourceList = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
      // Setup section.
      tabSourceList.addStyleName("" + get_style().contentList() + "");

      this.owner.tabSourceList = tabSourceList;

      return tabSourceList;
    }

    /**
     * Getter for contentContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.DeckLayoutPanel get_contentContainer() {
      return build_contentContainer();
    }
    private com.google.gwt.user.client.ui.DeckLayoutPanel build_contentContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.DeckLayoutPanel contentContainer = (com.google.gwt.user.client.ui.DeckLayoutPanel) GWT.create(com.google.gwt.user.client.ui.DeckLayoutPanel.class);
      // Setup section.

      this.owner.contentContainer = contentContainer;

      return contentContainer;
    }
  }
}
