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
package com.google.gwt.personal.tupracticalpieces.client;

//import com.google.gwt.personal.tupracticalpieces.client.MainMenuTreeViewModel.MenuConstants;
import com.google.gwt.personal.tupracticalpieces.client.desktop.MainMenuTreeViewModelDesktop.MenuConstants;
//import com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageEditView;
//import com.google.gwt.personal.tupracticalpieces.client.content.AdminMileageReadView;
import com.google.gwt.personal.tupracticalpieces.client.content.CwCanvas2d;
import com.google.gwt.personal.tupracticalpieces.client.content.CwCanvas3d;
import com.google.gwt.personal.tupracticalpieces.client.content.CwColumn;
//import com.google.gwt.personal.tupracticalpieces.client.content.CwFrame;
import com.google.gwt.personal.tupracticalpieces.client.content.CwMethod;
import com.google.gwt.personal.tupracticalpieces.client.content.CwMethod2;
import com.google.gwt.personal.tupracticalpieces.client.content.CwNotes;
import com.google.gwt.personal.tupracticalpieces.client.content.CwPreface;
import com.google.gwt.personal.tupracticalpieces.client.content.CwPrimeNumberFrequencyByModulo;
import com.google.gwt.personal.tupracticalpieces.client.content.CwUpdate;
import com.google.gwt.personal.tupracticalpieces.client.content.CwXFrame;
import com.google.gwt.personal.tupracticalpieces.client.content.CwMashup2;

/**
 * Constants used throughout the tupracticalpieces.
 */
	public interface TUPracticalPiecesConstants extends MenuConstants, CwPreface.CwConstants,
    CwNotes.CwConstants, CwMethod.CwConstants, CwMethod2.CwConstants, CwCanvas2d.CwConstants,
    CwCanvas3d.CwConstants, CwColumn.CwConstants, CwUpdate.CwConstants, CwXFrame.CwConstants,
    CwPrimeNumberFrequencyByModulo.CwConstants
//20170822
    , CwMashup2.CwConstants

//    , AdminMileageEditView.CwConstants, AdminMileageReadView.CwConstants
    {

  /**
   * The path to source code for examples, raw files, and style definitions.
   */
  String DST_SOURCE = "gwtTUPracticalPiecesSource/";

  /**
   * The destination folder for parsed source code from TUPracticalPieces examples.
   */
  String DST_SOURCE_EXAMPLE = DST_SOURCE + "java/";

  /**
   * The destination folder for raw files that are included in entirety.
   */
  String DST_SOURCE_RAW = DST_SOURCE + "raw/";

  /**
   * The destination folder for parsed CSS styles used in TUPracticalPieces examples.
   */
  String DST_SOURCE_STYLE = DST_SOURCE + "css/";
}
