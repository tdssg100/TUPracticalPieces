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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
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
public class CwNotes extends ContentWidget {
  /**
   * The constants used in this Content Widget.
   */
  @TUPracticalPiecesSource
  public static interface CwConstants extends Constants {
    String cwNotesDescription();

    String cwNotesName();

    String cwNotesP1();

    String cwNotesP2();

    String cwNotesP3();

    String cwNotesP4();

    String cwNotesP5();

    String cwNotesP6();

    String cwNotesP7();

    String cwNotesP8();

    String cwNotesP9();

    String cwNotesPa();

    String cwNotesPb();

    String cwNotesPc();

    String cwNotesPd();

    String cwNotesPe();

    String cwNotesPf();

    String cwNotesPg();

    String cwNotesPh();

    String cwNotesPi();

    String cwNotesPj();

    String cwNotesPk();

    String cwNotesPl();

    String cwNotesPm();
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
  public CwNotes(CwConstants constants) {
    super(constants.cwNotesName(), constants.cwNotesDescription(),
        true);
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
    String wedgeStr = "<ol style='list-style-type: disc'>";
    wedgeStr += "<li><p>" + constants.cwNotesP1() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesP2() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesP3() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesP4() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesP5() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesP6() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesP7() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesP8() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesP9() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPa() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPb() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPc() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPd() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPe() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPf() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPg() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPh() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPi() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPj() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPk() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPl() + "</p></li>";
    wedgeStr += "<li><p>" + constants.cwNotesPm() + "</p></li>";
    wedgeStr += "</ol>";
	vPanel.add(new HTML(wedgeStr));
    return vPanel;
  }

  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
    GWT.runAsync(CwNotes.class, new RunAsyncCallback() {

      public void onFailure(Throwable caught) {
        callback.onFailure(caught);
      }

      public void onSuccess() {
        callback.onSuccess(onInitialize());
      }
    });
  }
}
