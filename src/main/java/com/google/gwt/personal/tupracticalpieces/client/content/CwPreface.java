/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.personal.tupracticalpieces.client.content;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesData;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesSource;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Example file.
 */
public class CwPreface extends ContentWidget {
  /**
   * The constants used in this Content Widget.
   */
  @TUPracticalPiecesSource
  public static interface CwConstants extends Constants {
	  
    String cwPrefaceDescription();
    
    String cwPrefaceName();
    
    String cwPrefacePara1();
    
    String cwPrefacePara1cont();
    
    String cwPrefacePara2();
    
    String cwPrefacePara2cont();
    
    String cwPrefacePara3();
    
    String cwPrefacePara3cont();
    
    String cwPrefacePara4();
    
    String cwPrefacePara4cont();
    
    String cwPrefacePara5();
    
    String cwPrefacePara5cont();
    
    String cwPrefacePara6();
    
    String cwPrefacePara6cont();
    
    String cwPrefacePara7();
    
    String cwPrefacePara7cont();
    
    String cwPrefacePara8();
    
    String cwPrefacePara8cont();
    
    String cwPrefacePara9();
    
    String cwPrefacePara9cont();
    
    String cwPrefaceParaa();
    
    String cwPrefaceParaacont();
    
    String cwPrefaceParab();
    
    String cwPrefaceParabcont();
    
    String cwPrefaceParac();
    
    String cwPrefaceParaccont();
    
    String cwPrefaceParad();
    
    String cwPrefaceParadcont();
    
    String cwPrefaceParae();
    
    String cwPrefaceParaecont();
    
    String cwPrefaceParaf();
    
    String cwPrefaceParafcont();
    
    String cwPrefaceParag();
    
    String cwPrefaceParagcont();
    
    String cwPrefaceParah();
    
    String cwPrefaceParahcont();
    
    String cwPrefaceParai();
    
    String cwPrefaceParaicont();
    
    String cwPrefaceParaj();
    
    String cwPrefaceParajcont();
    
    String cwPrefaceParak();
    
    String cwPrefaceParakcont();    
    
    String cwPrefaceParal();
    
    String cwPrefaceParalcont();    
  }

  /**
   * An instance of the constants.
   */
  @TUPracticalPiecesData
  private final CwConstants constants;

  /**
   * Constructor.
   *
   * @param constants the constants
   */
  public CwPreface(CwConstants constants) {
    super(constants.cwPrefaceName(), constants.cwPrefaceDescription(), true);
    this.constants = constants;
  }

  /**
   * Initialize this example.
   */
  @TUPracticalPiecesSource
  @Override
  public Widget onInitialize() {
	    // Create a panel to align the Widgets
	    VerticalPanel vPanel = new VerticalPanel();
	    String wedgeStr = "<h3>" + constants.cwPrefacePara1() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefacePara1cont() + "</li>";
	    wedgeStr += "</ol>";
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefacePara2() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefacePara2cont() + "</li>";
	    wedgeStr += "</ol>";
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefacePara3() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefacePara3cont() + "</li>";
	    wedgeStr += "</ol>";
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefacePara4() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefacePara4cont() + "</li>";
	    wedgeStr += "</ol>";
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefacePara5() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefacePara5cont() + "</li>";
	    wedgeStr += "</ol>";
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefacePara6() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefacePara6cont() + "</li>";
	    wedgeStr += "</ol>";
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefacePara7() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefacePara7cont() + "</li>";
	    wedgeStr += "</ol>";
		
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefacePara8() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefacePara8cont() + "</li>";
	    wedgeStr += "</ol>";
		
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefacePara9() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefacePara9cont() + "</li>";
	    wedgeStr += "</ol>";
		
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefaceParaa() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefaceParaacont() + "</li>";
	    wedgeStr += "</ol>";
		
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefaceParab() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefaceParabcont() + "</li>";
	    wedgeStr += "</ol>";
		
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefaceParac() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefaceParaccont() + "</li>";
	    wedgeStr += "</ol>";
		
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefaceParad() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefaceParadcont() + "</li>";
	    wedgeStr += "</ol>";
		
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefaceParae() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefaceParaecont() + "</li>";
	    wedgeStr += "</ol>";
		
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefaceParaf() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefaceParafcont() + "</li>";
	    wedgeStr += "</ol>";
		
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefaceParag() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefaceParagcont() + "</li>";
	    wedgeStr += "</ol>";
  
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefaceParah() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefaceParahcont() + "</li>";
	    wedgeStr += "</ol>";
	    
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefaceParai() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefaceParaicont() + "</li>";
	    wedgeStr += "</ol>";
	    
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefaceParaj() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefaceParajcont() + "</li>";
	    wedgeStr += "</ol>";
	    
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefaceParak() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefaceParakcont() + "</li>";
	    wedgeStr += "</ol>";
	    
	    wedgeStr += "<br/>";
	    wedgeStr += "<h3>" + constants.cwPrefaceParal() + "</h3>";
	    wedgeStr += "<ol style='list-style-type: disc'>";
	    wedgeStr += "<li>" + constants.cwPrefaceParalcont() + "</li>";
	    wedgeStr += "</ol>";
	    
	    
	    
	    
	    vPanel.add(new HTML(wedgeStr));
	    return vPanel;
  }

  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
    /*
     * CheckBox is the first demo loaded, so go ahead and load it synchronously.
     */
    callback.onSuccess(onInitialize());
  }
}
