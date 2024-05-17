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

//import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.personal.tupracticalpieces.client.ContentWidget;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesData;
import com.google.gwt.personal.tupracticalpieces.client.TUPracticalPiecesAnnotations.TUPracticalPiecesSource;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * HTML5 + CSS
 */
public class CwColumn extends ContentWidget {
  /**
   * A custom animation that moves a small image around a circle in an
   * {@link HorizontalPanel}.
   */
  @TUPracticalPiecesSource
  public static interface CwConstants extends Constants {
    String cwColumnButtonOff();
	    
	String cwColumnButtonOn();
	    
	String cwColumnDescription();
    
    String cwColumnName();
  }
  
  /**
   * contents string.
   */
  @TUPracticalPiecesData
  private final String articleStr[] = {
		  "<section><h3>Are you computer-literate?</h3><br/><p>I passed the Software Design & Development Engineer Examination in 2006. It is one of the exams that are conducted by Japanese independent corporation - IPA or Information-Technology Promotion Agency, Japan. It was renamed to Applied Information Technology Engineer Examination in 2009, and success in the exam requires knowledge of network, database and system configuration, and skills to design and produce software under senior engineer's administration. I constantly update my knowledge by learning new technology, for exampleI make 3 web pages in according to HTML5 standards. I have been trying the next step exam, I plan to challenge a higher level exam - Database Specialist Examination on June 26.</p><br/><br><time>2011/05/18</time><br/><small>Writing Grade:95</small></section>",
		  "<section><h3>Modern society consists of fuge number of consucutive inventions. There might be vealed and unutilized ones. I think the computers are the best in modern times and also in all time because everyone uses them and they are necessities. I want to mention the &quot;ENIAC&quot; since I majored the computer science and have worked in IT. It was made by John von Neumann in order to calculate a line of fire in the World War II. And it is original and its architecture is inherited in today's computer such as the smart phone. Nowadays computers are networking and communicating each other like human. I fear they should have intentions without ethics. Meanwhile I wonder that in several years, other invention will be popular like superconductivity.</p><br/><br><time>20110504</time><br/><small>Writing Grade:--</small></section>",
		  "<section><h3>Asking for legal advice</h3><br/><p>Dear lawyer;<br/>I would like to ask a favour to let me hear your advice. I had my arm broken when I used a training machine in the gym. I believe the accident caused  the instrument's defect and the gym should pay for the medical cost and a compensation for the income loss. But  the gym have insisted on that I improperly treated the instrument, and it have not admitted its fault. So I wonder whether I will take legal action. I don't know how long the case will take, how much it will cost, and by what rate I will win if I sue the gym. Can I reach a settlement with your help? Please let me know these and what I should know beforehand if any.<br/>Best Regards,<br/>Uesugi, T.</p><br/><br><time>2011/05/20</time><br/><small>Writing Grade:87</small></section>",
		  "<section><h3>Learning Through Listening</h3><br/><p>In this Unit, I learned grouping listening. It is categorized three types that depends on situations. First, like stories or lectures, I don't have to know the details but I could know only a main topic. In this case, I think I have to follow the outline. Next, on the contrary I have to listen carefully in every word like instructions or directions. At last, between the two there is a framework listening. In this case, the topic is specified in advance, I carefully listen to key words. I concentrate only a few points. I think I can naturally choose one form these things, and use the combination. So it is important for me to predict what will be spoken in a certain situation, and to raise the accuracy of the prediction I convince I should learn more in various situations.</p><br/><br><time>20110/05/25</time><br/><small>Writing Grade:85</small></section>",
          "<section><h3>Describe your country's culture</h3><br/><p>Dear friend:<br/>You don't have to worry about an ordinary  life in Japan. Japanese civilization has progressed as well as Western countries. There is no particular religion in Japan, and no conflict between religions, as a lot of people conduct the marriage in Church and the funeral in Buddhism. Shinto is recognized as the state religion of Japan, but its influence became weakened since the defeat in the World War II. You only take care of entering the individual home. Almost houses are build in Japanese style like the room spreading tatamis or straw matting, so you need to take off your shoes at the entrance. I'm looking forward to seeing you.<br/>Best Regards,<br/>Uesugi, T.</p><br/><br><time>2011/06/06</time><br/><small>Writing Grade:87</small></section>",
          "<section><h3>Write about a book you've read</h3><br/><p>I have just been reading 'PERMUTATION CITY' authored by Greg Egan in 1994 with finishing half of the entire book. It is a science fiction, and describe the world where human beings experience living in the yberspace. There the computer completely simulates the human consciousness and biochemistry and the environment, and the copies of living persons behave autonomously. 'Neuromancer' by William Ford Gibson in 1984, which is famous for cyberpunk, describe that a real person jacks in the computer and he acts, so there is a big difference between the two in where an identity of the character in the cyberspace is. I like SFs because they tell ideas or raise questions. As I have not totally read 'PERMUTATION CITY' yet, I'm looking forward to how it ends.</p><br/><br><time>2011/06/11</time><br/><small>Writing Grade:96</small></section>",
          "<section><h3>Health Concern</h3><br/><p>A friend of mine, who is an office worker, came out that he suffered from a diabetic. He looks healthy, and he takes care of himself. The stress might have driven him to fall victim to the disease. Exercises improve the symptoms of it, so he seems to try to exercise. My medical check-up alerts that I also have a high risk to get a diabetic. I must quit smoking, and I must pay attention to the weight control. I have tried to ban smoking several times, but I didn't continue. Now that smoking is a morbid dependence, so it might be wrong to hesitate to go to the doctor.</p><br/><br><time>2011/06/18</time><br/><small>Writing Grade:85</small></section>",
          "<section><h3>Professional</h3><br/><p>I write an impression of the work place I had worked before as I have been out of work. The company sent its employees to other companies that needed the engineers. So I feel that the relationship between the employees was weak and I had little sense of belonging though the company had a meeting once a month. But I think this work style is very modern system. The employees concentrate the job without bothering the human relationship for especially experts like the engineers. Although it seems envious for me to obey the culture matured for long time, I give priority to follow a sense of mission.</p><br/><br><time>2011/06/30</time><br/><small>Writing Grade:85</small></section>",
          "<section><h3>What English Cources Do You Want?</h3><br/><p>I consider it is efficient to split into some courses because requied skills depend on his or her positions. A common training method begins with a subcription of an online English school to increase the time to learn English. Using the net is easy to address in the available time because of the sense of the game. And the upper course, which needs high communication skills, adopts face to face trainings with foreigners in a practical manner. In this cource the members were screened in advance. The other hand, I think there could be an email course exclusively. Though emails are less strict than letters, emails are used more often.</p><br/><br><time>2011/07/10</time><br/><small>Writing Grade:91</small></section>",
          "<section><h3>A Likely Week</h3><br/><p>I have 3 matters, one is a main job for a long term; another is over for (D)(>>)a short span; the other is new. I poured respectively 50%, 20% and 20% to all the work time of this week. The remains was spent by my chores. The main job needs a fixed amount of time and is a little behind the milestone. The finished job was on schedule. I estimate the new one will conclude in 4 months. However, it might delay because it is possible to come out an additional request with a high priority which relates the finished job.</p><br/><br><time>2044/07/21</time><br/><small>Writing Grade:96</small></section>",
          "<section><h3>Custom</h3><br/><p>In the city, I hear that many marriages are conducted by Christain style in the commercial base. I think that many women dream wearing the white wedding dress with a bouquet. On the other hand, Japanese conventional style is Shinzenshiki, which is conducted by Shintou manner. Shintou is considerd as a state religion. The bride and groom are wearing kimonos, and the bride is putting on Bunkintakashimada or a gorgeous wig with a white silk belt. The wedding is conducted with due solemnity. You might avoid wearing the cloth in garish colors because a heroin in the wedding is the bride.</p><br/><br><time>2011/07/25</time><br/><small>Writing Grade:90</small></section>",
          "<section><h3>To Be</h3><br/><p>I have improved very much in particular in writing since resumption of English Town in April. I realize I'm progressing in speaking as well. When I speak English, I get nervous a little, and I can't think of any words, or speak rudely. I'd like to try to increase the opportunities to use English, and get familiar with English. And I'd like to become a fluent speaker as I can select the right way in English in various situations. To master the decent English, which it is most difficultfor me, I think I need to learn how to express the fine nuance.</p><br/><br><time>2011/08/02</time><br/><small>Writing Grade:89</small></section>"
          };
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private HTML contDiv = null;
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private HTML contDivList = null;
  
  /**
   * The instance of an canvas.
   */
  @TUPracticalPiecesData
  private HTML contDivColumn = null;
  
  /**
   * list or 3-column switching for the articles on the click.
   */
  @TUPracticalPiecesData
  private ToggleButton listButton = null;

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
  public CwColumn(CwConstants constants) {
    super(
        constants.cwColumnName(), constants.cwColumnDescription(), false);
    this.constants = constants;
  }
  
  /**
   * Initialize this example.
   */
  @TUPracticalPiecesSource
  @Override
  public Widget onInitialize() {
    // Load mileage data.
	contDiv = new HTML("<div></div>");
	contDivList = new HTML("<div id='colContainer'>"
			  + getColAll()
			  + "</div>");
	contDivColumn = new HTML("<div id='colContainer'><div id='colWrapper'><div id='colLeft'>"
			  + getCol1()
			  + "</div><div id='colCenter'>"
			  + getCol2()
			  + "</div></div><div id='colRight'>"
			  + getCol3()
			  + "</div></div>");

	contDiv = contDivList;
	listButton = new ToggleButton("Up", constants.cwColumnButtonOn());
	listButton.setText(constants.cwColumnButtonOff());
	listButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
    	  if (listButton.isDown()) {
    		  contDiv.setHTML(contDivColumn.getHTML());
    	  } else {
    		  contDiv.setHTML(contDivList.getHTML());
    	  }
      }
    });
    // Add the components to a panel and return it
    VerticalPanel mainScope = new VerticalPanel();
    mainScope.setSpacing(10);
    mainScope.add(listButton);
    mainScope.add(contDiv);      
    // Return the layout
    return mainScope;
  }
  
  @Override
  protected void asyncOnInitialize(final AsyncCallback<Widget> callback) {
    GWT.runAsync(CwColumn.class, new RunAsyncCallback() {
  
      public void onFailure(Throwable caught) {
        callback.onFailure(caught);
      }
  
      public void onSuccess() {
        callback.onSuccess(onInitialize());
      }
    });
  }
  
  private String getCol1() {
	  String ss = "";
	  for (int i = 0; i < Math.round(articleStr.length/ 3); i++) {
		  ss += articleStr[i];
	  }
	  return ss;
  }
  private String getCol2() {
	  String ss = "";
	  for (int i = Math.round(articleStr.length/ 3) + 1; i < Math.round(articleStr.length * 2 / 3); i++) {
		  ss += articleStr[i];
	  }
	  return ss;
  }
  private String getCol3() {
	  String ss = "";
	  for (int i = Math.round(articleStr.length * 2 / 3) + 1; i < articleStr.length; i++) {
		  ss += articleStr[i];
	  }
	  return ss;
  }
  private String getColAll() {
	  String ss = "";
	  for (int i = 0; i < articleStr.length; i++) {
		  ss += articleStr[i];
	  }
	  return ss;
  }
}
