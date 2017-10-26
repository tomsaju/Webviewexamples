package playground.webview.webviewexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] mobileArray = {"simple","tables","form","responsive","original","more javascript"};
    String html;
    String dummydatatoPost = "[{\"qname\":\"q1\",\"ans\":\"yes\",\"qtype\":\"radio\"},{\"qname\":\"q2\",\"ans\":\"no\",\"qtype\":\"radio\"},{\"qname\":\"q3\",\"ans\":\"damages\",\"qtype\":\"text\"},{\"qname\":\"q4\",\"ans\":\"Yes\",\"qtype\":\"textarea\"},{\"qname\":\"q5\",\"ans\":[\"damaged\",\"Shingles\"],\"qtype\":\"checkbox\"},{\"qname\":\"q6\",\"ans\":[\"Deterior\"],\"qtype\":\"checkbox\"}]";

    //////////////////////////////////
    String simple = "<HTML>\n" +
            "<HEAD>\n" +
            "<TITLE>Your Title Here</TITLE>\n" +
            "</HEAD>\n" +
            "<BODY BGCOLOR=\"FFFFFF\">\n" +
            "<CENTER><IMG SRC=\"clouds.jpg\" ALIGN=\"BOTTOM\"> </CENTER>\n" +
            "<HR>\n" +
            "<a href=\"http://somegreatsite.com\">Link Name</a>\n" +
            "is a link to another nifty site\n" +
            "<H1>This is a Header</H1>\n" +
            "<H2>This is a Medium Header</H2>\n" +
            "Send me mail at <a href=\"mailto:support@yourcompany.com\">\n" +
            "support@yourcompany.com</a>.\n" +
            "<P> This is a new paragraph!\n" +
            "<P> <B>This is a new paragraph!</B>\n" +
            "<BR> <B><I>This is a new sentence without a paragraph break, in bold italics.</I></B>\n" +
            "<HR>\n" +
            "</BODY>\n" +
            "</HTML>";



    String form ="<!DOCTYPE html>\n" +
            "<title>My Example</title>\n" +
            "\n" +
            "<style>\n" +
            "  .myForm {\n" +
            "  font-family: \"Lucida Sans Unicode\", \"Lucida Grande\", sans-serif;\n" +
            "  font-size: 0.8em;\n" +
            "  width: 30em;\n" +
            "  padding: 1em;\n" +
            "  border: 1px solid #ccc;\n" +
            "}\n" +
            "\n" +
            ".myForm * {\n" +
            "  box-sizing: border-box;\n" +
            "}\n" +
            "\n" +
            ".myForm fieldset {\n" +
            "  border: none;\n" +
            "  padding: 0;\n" +
            "}\n" +
            "\n" +
            ".myForm legend,\n" +
            ".myForm label {\n" +
            "  padding: 0;\n" +
            "  font-weight: bold;\n" +
            "}\n" +
            "\n" +
            ".myForm label.choice {\n" +
            "  font-size: 0.9em;\n" +
            "  font-weight: normal;\n" +
            "}\n" +
            "\n" +
            ".myForm label {\n" +
            "  text-align: left;\n" +
            "  display: block;\n" +
            "}\n" +
            "\n" +
            ".myForm input[type=\"text\"],\n" +
            ".myForm input[type=\"tel\"],\n" +
            ".myForm input[type=\"email\"],\n" +
            ".myForm input[type=\"datetime-local\"],\n" +
            ".myForm select,\n" +
            ".myForm textarea {\n" +
            "  float: right;\n" +
            "  width: 60%;\n" +
            "  border: 1px solid #ccc;\n" +
            "  font-family: \"Lucida Sans Unicode\", \"Lucida Grande\", sans-serif;\n" +
            "  font-size: 0.9em;\n" +
            "  padding: 0.3em;\n" +
            "}\n" +
            "\n" +
            ".myForm textarea {\n" +
            "  height: 100px;\n" +
            "}\n" +
            "\n" +
            ".myForm input[type=\"radio\"],\n" +
            ".myForm input[type=\"checkbox\"] {\n" +
            "  margin-left: 40%;\n" +
            "}\n" +
            "\n" +
            ".myForm button {\n" +
            "  padding: 1em;\n" +
            "  border-radius: 0.5em;\n" +
            "  background: #eee;\n" +
            "  border: none;\n" +
            "  font-weight: bold;\n" +
            "  margin-left: 40%;\n" +
            "  margin-top: 1.8em;\n" +
            "}\n" +
            "\n" +
            ".myForm button:hover {\n" +
            "  background: #ccc;\n" +
            "  cursor: pointer;\n" +
            "}\n" +
            "</style>\n" +
            "\n" +
            "\n" +
            "<form class=\"myForm\" method=\"get\" action=\"/html/codes/html_form_handler.cfm\">\n" +
            "  <p>\n" +
            "    <label>Name\n" +
            "      <input type=\"text\" name=\"customer_name\" required>\n" +
            "    </label> \n" +
            "  </p>\n" +
            "\n" +
            "  <p>\n" +
            "    <label>Phone \n" +
            "      <input type=\"tel\" name=\"phone_number\">\n" +
            "    </label>\n" +
            "  </p>\n" +
            "\n" +
            "  <p>\n" +
            "    <label>Email \n" +
            "      <input type=\"email\" name=\"email_address\">\n" +
            "    </label>\n" +
            "  </p>\n" +
            "\n" +
            "  <fieldset>\n" +
            "    <legend>Which taxi do you require?</legend>\n" +
            "    <p><label> <input type=\"radio\" name=\"taxi\" required value=\"car\"> Car </label></p>\n" +
            "    <p><label> <input type=\"radio\" name=\"taxi\" required value=\"van\"> Van </label></p>\n" +
            "    <p><label> <input type=\"radio\" name=\"taxi\" required value=\"tuktuk\"> Tuk Tuk </label></p>\n" +
            "  </fieldset>\n" +
            "\n" +
            "  <fieldset>\n" +
            "    <legend>Extras</legend>\n" +
            "    <p><label> <input type=\"checkbox\" name=\"extras\" value=\"baby\"> Baby Seat </label></p>\n" +
            "    <p><label> <input type=\"checkbox\" name=\"extras\" value=\"wheelchair\"> Wheelchair Access </label></p>\n" +
            "    <p><label> <input type=\"checkbox\" name=\"extras\" value=\"tip\"> Stock Tip </label></p>\n" +
            "  </fieldset>\n" +
            "\n" +
            "  <p>\n" +
            "    <label>Pickup Date/Time\n" +
            "      <input type=\"datetime-local\" name=\"pickup_time\" required>\n" +
            "    </label>\n" +
            "  </p>\n" +
            "\n" +
            "  <p>\n" +
            "    <label>Pickup Place\n" +
            "      <select id=\"pickup_place\" name=\"pickup_place\">\n" +
            "        <option value=\"\" selected=\"selected\">Select One</option>\n" +
            "        <option value=\"office\" >Taxi Office</option>\n" +
            "        <option value=\"town_hall\" >Town Hall</option>\n" +
            "        <option value=\"telepathy\" >We'll Guess!</option>\n" +
            "      </select>\n" +
            "    </label> \n" +
            "  </p>\n" +
            "\n" +
            "  <p>\n" +
            "    <label>Dropoff Place\n" +
            "      <input type=\"text\" name=\"dropoff_place\" required list=\"destinations\">\n" +
            "    </label>\n" +
            "\n" +
            "    <datalist id=\"destinations\">\n" +
            "      <option value=\"Airport\">\n" +
            "      <option value=\"Beach\">\n" +
            "      <option value=\"Fred Flinstone's House\">\n" +
            "    </datalist>\n" +
            "  </p>\n" +
            "\n" +
            "  <p>\n" +
            "    <label>Special Instructions\n" +
            "      <textarea name=\"comments\" maxlength=\"500\"></textarea>\n" +
            "    </label>\n" +
            "  </p>\n" +
            "\n" +
            "  <p><button>Submit Booking</button></p>\n" +
            "\n" +
            "</form>\n" +
            "\n" +
            "<hr>\n" +
            "<p>More info: <a href=\"/html/tags/html_form_tag.cfm\"><code>form</code></a>, <a href=\"/html/tutorial/html_forms.cfm\">HTML Form Tutorial</a>, <a href=\"/html/codes/html_form_code.cfm\">HTML Form Code</a>, <a href=\"/html/codes/html_form_to_email.cfm\">Form to Email</a>.</p>";



    String table = "<!DOCTYPE html>\n" +
            "<title>My Example</title>\n" +
            "\n" +
            "<style>\n" +
            "  table {\n" +
            "    border-collapse: collapse;\n" +
            "    width: 100%;\n" +
            "    text-align: left;\n" +
            "  }\n" +
            "  table, td, th {\n" +
            "    border: 1px solid lightgray;\n" +
            "    padding: 10px;\n" +
            "  }\n" +
            "</style>\n" +
            "<table>\n" +
            "  <tr>\n" +
            "    <th>Table Header</th>\n" +
            "    <th>Table Header</th>\n" +
            "    <th>Table Header</th>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>Table cell</td>\n" +
            "    <td>Table cell</td>\n" +
            "    <td>Table cell</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>Table cell</td>\n" +
            "    <td>Table cell</td>\n" +
            "    <td>Table cell</td>\n" +
            "  </tr>\n" +
            "</table>\n" +
            "\n" +
            "<hr>\n" +
            "<p>More info: <a href=\"/html/html_table_tutorial.cfm\">Table Tutorial</a>, <a href=\"/html/html_table_generator.cfm\">Table Generator</a>.</p>";

    String responsive = "<html>\n" +
            "<head>\n" +
            "<style>\n" +
            "body{\n" +
            "background-color: #FA5858;\n" +
            "color:#fff;\n" +
            "}\n" +
            "input{\n" +
            "background-color: #F7D358;\n" +
            "width: 300px;\n" +
            "padding:10px;\n" +
            "color: #000;\n" +
            "}\n" +
            "div#content{\n" +
            "padding:20px;\n" +
            "background-color: #F7D358;\n" +
            "color: #000;\n" +
            "}\n" +
            "</style>\n" +
            "<script type=\"text/javascript\">\n" +
            "    function showAndroidToast(toastmsg) {\n" +
            "        Android.showToast(toastmsg);\n" +
            "    }\n" +
            " function showAndroidDialog(dialogmsg) {\n" +
            "        Android.showDialog(dialogmsg);\n" +
            "    }\n" +
            " function moveToScreenTwo() {\n" +
            "        Android.moveToNextScreen();\n" +
            "    }\n" +
            "</script>\n" +
            "</head>\n" +
            "<body>\n" +
            "<center>\n" +
            "<h3>Binding JavaScript code to Android code</h3>\n" +
            "<div id=\"content\">\n" +
            "When developing a web application that's designed specifically for the WebView in your Android application, you can create interfaces between your JavaScript code and client-side Android code. For example, your JavaScript code can call a method in your Android code to display a Dialog, instead of using JavaScript's alert() function.\n" +
            "</div>\n" +
            "<div>\n" +
            "Here are few examples:\n" +
            "</div>\n" +
            "<div>\n" +
            "<input type=\"button\" value=\"Make Toast\" onClick=\"showAndroidToast('Toast made by Javascript :)')\" /><br/>\n" +
            "<input type=\"button\" value=\"Trigger Dialog\" onClick=\"showAndroidDialog('This dialog is triggered by Javascript :)')\" /><br/>\n" +
            "<input type=\"button\" value=\"Exit\" onClick=\"moveToScreenTwo()\" />\n" +
            "</div>\n" +
            "</center>\n" +
            "</body>\n" +
            "</html>";




    String original = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "  <head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n" +
            "    <title>Form templates</title>\n" +
            "    <style type=\"text/css\">\n" +
            "      *{\n" +
            "    box-sizing: border-box; \n" +
            "}\n" +
            "body{\n" +
            "    padding: 0;\n" +
            "    margin: 0;\n" +
            "    font-family: 'Open Sans', sans-serif;\n" +
            "    font-size: 13px;\n" +
            "    overflow-x: hidden\n" +
            "}\n" +
            ".form-container{\n" +
            "    max-width:1100px;\n" +
            "    \n" +
            "}\n" +
            ".row{\n" +
            "    margin: 0 -15px;\n" +
            "    border-bottom: 1px solid #ddd;\n" +
            "}\n" +
            ".row:after,.row:before,.clearfix:after,.clearfix:before,.qst-heading:before,.qst-heading:after{\n" +
            "    content: '';\n" +
            "    display: table;\n" +
            "    clear: both;\n" +
            "}\n" +
            ".col-6{\n" +
            "    width: 50%;\n" +
            "    float: left;\n" +
            "    padding-left: 15px;\n" +
            "    padding-right: 15px;\n" +
            "    box-sizing: border-box;\n" +
            "}\n" +
            ".col-full{\n" +
            "    width: 100%;\n" +
            "    float: left;\n" +
            "    padding-left: 15px;\n" +
            "    padding-right: 15px;\n" +
            "    box-sizing: border-box;\n" +
            "}\n" +
            ".form-container-fluid{\n" +
            "    width: 100%;\n" +
            "   \n" +
            "}\n" +
            ".padding-tp-0{\n" +
            "    padding-top: 0;\n" +
            "}\n" +
            ".padding-btm-0{\n" +
            "    padding-bottom: 0;\n" +
            "}\n" +
            ".form-container-fluid:after,.form-container-fluid:before{\n" +
            "    content: '';\n" +
            "    display: table;\n" +
            "    clear: both;\n" +
            "\n" +
            "}\n" +
            "h2.form-title,.qust-cat-title{\n" +
            "    font-size: 14px;\n" +
            "    margin:0;\n" +
            "    color: #000;\n" +
            "    font-weight: 600;\n" +
            "}\n" +
            ".text-center{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".form-heading,.qust-cat-title{\n" +
            "    padding: 10px;\n" +
            "}\n" +
            ".overflow-hidden{\n" +
            "    overflow: hidden;\n" +
            "}\n" +
            ".no-border{\n" +
            "    border: 0\n" +
            "}\n" +
            ".qst-heading{\n" +
            "    background: #ddd;\n" +
            "    padding: 10px 40px;\n" +
            "}\n" +
            ".qstn-row{\n" +
            "   padding: 10px 35px 10px 20px ;\n" +
            "    background: #fff;\n" +
            "}\n" +
            "p.qst-text{\n" +
            "    color: #3a3a3a;\n" +
            "    font-weight: 500;\n" +
            "    margin-top: 0;\n" +
            "    margin-bottom: 10px\n" +
            "}\n" +
            "p.qst-text span{\n" +
            "    color: #000;\n" +
            "    font-weight: 600;\n" +
            "    font-size: 16px;\n" +
            "    \n" +
            "}\n" +
            "\n" +
            "/** custom radio button**/\n" +
            ".radio-inline{\n" +
            "    padding-right: 25px;\n" +
            "}\n" +
            "[type=\"radio\"]:checked,\n" +
            "[type=\"radio\"]:not(:checked),[type=\"checkbox\"]:checked,[type=\"checkbox\"]:not(:checked){\n" +
            "    position: absolute;\n" +
            "    left: -9999px;\n" +
            "}\n" +
            "[type=\"radio\"]:checked + label,\n" +
            "[type=\"radio\"]:not(:checked) + label,\n" +
            "[type=\"checkbox\"]:checked + label,\n" +
            "[type=\"checkbox\"]:not(:checked) + label\n" +
            "{\n" +
            "    position: relative;\n" +
            "    padding-left: 28px;\n" +
            "    cursor: pointer;\n" +
            "    line-height: 20px;\n" +
            "    display: inline-block;\n" +
            "    color: #666;\n" +
            "    font-size: 12px;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            "[type=\"radio\"]:checked + label:before,\n" +
            "[type=\"radio\"]:not(:checked) + label:before,\n" +
            "[type=\"checkbox\"]:checked + label:before,\n" +
            "[type=\"checkbox\"]:not(:checked) + label:before{\n" +
            "    content: '';\n" +
            "    position: absolute;\n" +
            "    left: 0;\n" +
            "    top: 0;\n" +
            "    width: 16px;\n" +
            "    height: 16px;\n" +
            "    border: 1px solid #ddd;\n" +
            "    border-radius: 100%;\n" +
            "    background: #fff;\n" +
            "}\n" +
            "[type=\"checkbox\"]:checked + label:before,\n" +
            "[type=\"checkbox\"]:not(:checked) + label:before{\n" +
            "    border-radius: 0;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "[type=\"radio\"]:checked + label:after,\n" +
            "[type=\"radio\"]:not(:checked) + label:after{\n" +
            "    content: '';\n" +
            "    width: 10px;\n" +
            "    height: 10px;\n" +
            "    background: #34b2ed;\n" +
            "    position: absolute;\n" +
            "    top: 4px;\n" +
            "    left: 4px;\n" +
            "    border-radius: 100%;\n" +
            "    -webkit-transition: all 0.2s ease;\n" +
            "    transition: all 0.2s ease;\n" +
            "}\n" +
            "[type=\"checkbox\"]:checked + label:after{\n" +
            "    content: '';\n" +
            "    width: 4px;\n" +
            "    height: 10px;\n" +
            "/*    background: #34b2ed;*/\n" +
            "    position: absolute;\n" +
            "    top: 1px;\n" +
            "    left: 6px;\n" +
            "    border:1px solid transparent;\n" +
            "    border-bottom: 2px solid #34b2ed;\n" +
            "    border-right: 2px solid #34b2ed;\n" +
            "    -webkit-transition: all 0.2s ease;\n" +
            "    transition: all 0.2s ease;\n" +
            "    transform: rotate(30deg)\n" +
            "}\n" +
            "[type=\"radio\"]:not(:checked) + label:after {\n" +
            "    opacity: 0;\n" +
            "    -webkit-transform: scale(0);\n" +
            "    transform: scale(0);\n" +
            "}\n" +
            "[type=\"radio\"]:checked + label:after {\n" +
            "    opacity: 1;\n" +
            "    -webkit-transform: scale(1);\n" +
            "    transform: scale(1);\n" +
            "}\n" +
            "/***END custom radio button**/\n" +
            ".q-info{\n" +
            "    font-size: 9px;\n" +
            "    font-style: italic;\n" +
            "    color:#737373;;\n" +
            "    margin: 3px 0;\n" +
            "}\n" +
            "p.sub_qstn{\n" +
            "    font-size: 11px;\n" +
            "    margin-bottom: 5px;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".qst-options{margin-top: 10px;}\n" +
            ".extra-info{\n" +
            "    display: block;\n" +
            "    height: 35px;\n" +
            "    border: 1px solid #ddd;\n" +
            "    padding-left: 5px;\n" +
            "    border-radius: 3px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".qst-row{\n" +
            "    padding: 15px 0;\n" +
            "}\n" +
            ".btn-btm{\n" +
            "    border: 0;\n" +
            "    padding-top: 15px;\n" +
            "    padding-bottom: 15px;\n" +
            "}\n" +
            ".btn-btm button{\n" +
            "    padding: 10px 30px;\n" +
            "    border: 0;\n" +
            "    background: #34B2ED;\n" +
            "    color: #fff;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            "    </style>\n" +
            "   \n" +
            "    \n" +
            "    <!-- Open sans google fonts\n" +
            "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,600\" rel=\"stylesheet\">-->\n" +
            "\n" +
            "   \n" +
            "  </head>\n" +
            "  <body>\n" +
            "    \n" +
            "    <div class=\"form-container-fluid top clearfix\">\n" +
            "        <div class=\"row\">\n" +
            "            <div class=\"form-heading overflow-hidden\">\n" +
            "               <div class=\"col-6\">\n" +
            "                    <h2 class=\"form-title text-center\">Item</h2>\n" +
            "                </div>\n" +
            "                <div class=\"col-6\">\n" +
            "                    <h2 class=\"form-title text-center\">Details</h2>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"row\">\n" +
            "            <div class=\"col-full qst-heading\">\n" +
            "               <h2 class=\"form-title\">Roof</h2> \n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <!-- Question row 1 -->\n" +
            "        <div class=\"row qst-row\">\n" +
            "            <div class=\"col-6\">\n" +
            "                <div class=\"col-full qstn-row\">\n" +
            "                <p class=\"qst-text\"><span>A</span>. Is the roof leaking?</p>\n" +
            "                <div class=\"qst-options\">\n" +
            "                       <span class=\"radio-inline\">\n" +
            "                           <input type=\"radio\" id=\"test1\" name=\"radio-group\" checked>\n" +
            "                           <label for=\"test1\">Yes</label>\n" +
            "                       </span>\n" +
            "                        <span class=\"radio-inline\">\n" +
            "                        <input type=\"radio\" id=\"test2\" name=\"radio-group\">\n" +
            "                        <label for=\"test2\">No</label>\n" +
            "                       </span>\n" +
            "                </div>\n" +
            "                <p class=\"q-info\">If the roof allows any water to enter is considered to be leaking</p>\n" +
            "                <p class=\"qst-text sub_qstn\">Source of the leak?</p>\n" +
            "                <div class=\"qst-options\">\n" +
            "                       <span class=\"radio-inline\">\n" +
            "                           <input type=\"checkbox\" id=\"test3\" name=\"radio-group2\" checked>\n" +
            "                           <label for=\"test3\">Damaged</label>\n" +
            "                       </span>\n" +
            "                        <span class=\"radio-inline\">\n" +
            "                            <input type=\"checkbox\" id=\"test4\" name=\"radio-group2\">\n" +
            "                            <label for=\"test4\">Deteriorated</label>\n" +
            "                       </span>\n" +
            "                       <span class=\"radio-inline\">\n" +
            "                            <input type=\"checkbox\" id=\"test5\" name=\"radio-group2\">\n" +
            "                            <label for=\"test5\">Missing</label>\n" +
            "                       </span>\n" +
            "                       <span class=\"radio-inline\">\n" +
            "                            <input type=\"checkbox\" id=\"test6\" name=\"radio-group2\">\n" +
            "                            <label for=\"test6\">Shingles/Both?</label>\n" +
            "                       </span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-6\">\n" +
            "                <div class=\"col-full qstn-row\">\n" +
            "                    <p class=\"qst-text sub_qstn padding-btm-0\">Where is the damage located?</p>\n" +
            "                    <div class=\"qst-options\">\n" +
            "                           <span class=\"radio-inline\">\n" +
            "                               <input type=\"checkbox\" id=\"Q1C1\" name=\"radio-group3\" checked>\n" +
            "                               <label for=\"Q1C1\">Front</label>\n" +
            "                           </span>\n" +
            "                            <span class=\"radio-inline\">\n" +
            "                                <input type=\"checkbox\" id=\"Q1C2\" name=\"radio-group3\">\n" +
            "                                <label for=\"Q1C2\">Rear</label>\n" +
            "                           </span>\n" +
            "                           <span class=\"radio-inline\">\n" +
            "                                <input type=\"checkbox\" id=\"Q1C3\" name=\"radio-group3\">\n" +
            "                                <label for=\"Q1C3\">Center</label>\n" +
            "                           </span>\n" +
            "                    </div>\n" +
            "               </div>\n" +
            "               <div class=\"col-full qstn-row\" style=\"padding-top: 0\">\n" +
            "                    <p class=\"qst-text sub_qstn\">Where is the damage located?</p>\n" +
            "                    <div class=\"qst-options\">\n" +
            "                           <span class=\"radio-inline\">\n" +
            "                               <input type=\"checkbox\" id=\"Q2C1\" name=\"radio-group4\" checked>\n" +
            "                               <label for=\"Q2C1\">House</label>\n" +
            "                           </span>\n" +
            "                            <span class=\"radio-inline\">\n" +
            "                                <input type=\"checkbox\" id=\"Q2C2\" name=\"radio-group4\">\n" +
            "                                <label for=\"Q2C2\">Detached Garage</label>\n" +
            "                           </span>\n" +
            "                           <span class=\"radio-inline\">\n" +
            "                                <input type=\"checkbox\" id=\"Q2C3\" name=\"radio-group4\">\n" +
            "                                <label for=\"Q2C3\">Detached Garage</label>\n" +
            "                           </span>\n" +
            "                    </div>\n" +
            "                    <div>\n" +
            "                       <input type=\"text\" id=\"exp\" placeholder=\"Expla..\" class=\"extra-info\">\n" +
            "                   </div>\n" +
            "               </div>\n" +
            "               \n" +
            "            </div>\n" +
            "         </div>\n" +
            "        <!-- Question row 1::END -->\n" +
            "        <!-- Question row 2 -->\n" +
            "        <div class=\"row qst-row\">\n" +
            "            <div class=\"col-6\">\n" +
            "                <div class=\"col-full qstn-row\">\n" +
            "                <p class=\"qst-text\"><span>B</span>.Is the damaged, deteriorated, leaking roof tarped?</p>\n" +
            "                <div class=\"qst-options\">\n" +
            "                       <span class=\"radio-inline\">\n" +
            "                           <input type=\"radio\" id=\"q3c1\" name=\"radio-group5\" checked>\n" +
            "                           <label for=\"q3c1\">Yes</label>\n" +
            "                       </span>\n" +
            "                        <span class=\"radio-inline\">\n" +
            "                        <input type=\"radio\" id=\"q3c2\" name=\"radio-group5\">\n" +
            "                        <label for=\"q3c2\">No</label>\n" +
            "                       </span>\n" +
            "                </div>\n" +
            "             </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-6\">\n" +
            "                <div class=\"col-full qstn-row\">\n" +
            "                    <p class=\"qst-text sub_qstn padding-btm-0\">Give the approximate size in square footage of the damaged /deteriorated\n" +
            "area?</p>        </div>\n" +
            "               <div class=\"col-full qstn-row\" style=\"padding-top: 0\">\n" +
            "                  \n" +
            "                    <div>\n" +
            "                       <input type=\"text\" placeholder=\"Explain other..\" class=\"extra-info\">\n" +
            "                   </div>\n" +
            "                    \n" +
            "               </div>\n" +
            "               \n" +
            "            </div>\n" +
            "         </div>\n" +
            "        <!-- Question row 2::END -->\n" +
            "        <!-- Question row 3 -->\n" +
            "        <div class=\"row qst-row\">\n" +
            "            <div class=\"col-6\">\n" +
            "                <div class=\"col-full qstn-row\">\n" +
            "                <p class=\"qst-text\"><span>C</span>. Is there ceiling damage due to the roof leak?</p>\n" +
            "                <div class=\"qst-options\">\n" +
            "                       <span class=\"radio-inline\">\n" +
            "                           <input type=\"radio\" id=\"q4c1\" name=\"radio-group6\" checked>\n" +
            "                           <label for=\"q4c1\">Yes</label>\n" +
            "                       </span>\n" +
            "                        <span class=\"radio-inline\">\n" +
            "                        <input type=\"radio\" id=\"q4c2\" name=\"radio-group6\">\n" +
            "                        <label for=\"q4c2\">No</label>\n" +
            "                       </span>\n" +
            "                </div>\n" +
            "             </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-6\">\n" +
            "                <div class=\"col-full qstn-row\">\n" +
            "                    <p class=\"qst-text sub_qstn padding-btm-0\">Give the approximate size in square footage of the damaged area?</p>        </div>\n" +
            "               <div class=\"col-full qstn-row\" style=\"padding-top: 0\">\n" +
            "                  \n" +
            "                    <div>\n" +
            "                       <input type=\"text\" placeholder=\"Explain other..\" class=\"extra-info\">\n" +
            "                   </div>\n" +
            "                    \n" +
            "               </div>\n" +
            "               \n" +
            "            </div>\n" +
            "         </div>\n" +
            "        <!-- Question row 3::END -->\n" +
            "        <!-- Next previous button-->\n" +
            "        \n" +
            "<script type=\"text/javascript\">\n" +
            "    function showAndroidToast() {\n" +
            "var a = document.getElementById('exp').innerHTML = \n" +
            "        Android.showToast(a);\n" +
            "    }\n" +
            " function showAndroidDialog(dialogmsg) {\n" +
            "        Android.showDialog(dialogmsg);\n" +
            "    }\n" +
            " function moveToScreenTwo() {\n" +
            "        Android.moveToNextScreen();\n" +
            "    }\n" +
            "</script>\n" +
            "        <div class=\"row btn-btm\">\n" +
            "            <div class=\"col-6 text-center\">\n" +
            "                <button>Previous</button>\n" +
            "            </div>\n" +
            "            <div class=\"col-6 text-center\">\n" +
            "                <button type=\"button\" value=\"\" id=\"btnOK\" onClick=\"showAndroidToast()\">Next</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "  </body>\n" +
            "</html>";


    //Serious javascript

    String moreScript = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "  <head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n" +
            "    <title>Form templates</title>\n" +
            "    <style type=\"text/css\">\n" +
            "      *{\n" +
            "    box-sizing: border-box; \n" +
            "}\n" +
            "body{\n" +
            "    padding: 0;\n" +
            "    margin: 0;\n" +
            "    font-family: 'Open Sans', sans-serif;\n" +
            "    font-size: 13px;\n" +
            "    overflow-x: hidden\n" +
            "}\n" +
            ".form-container{\n" +
            "    max-width:1100px;\n" +
            "    \n" +
            "}\n" +
            ".row{\n" +
            "    margin: 0 -15px;\n" +
            "    border-bottom: 1px solid #ddd;\n" +
            "}\n" +
            ".row:after,.row:before,.clearfix:after,.clearfix:before,.qst-heading:before,.qst-heading:after{\n" +
            "    content: '';\n" +
            "    display: table;\n" +
            "    clear: both;\n" +
            "}\n" +
            ".col-6{\n" +
            "    width: 50%;\n" +
            "    float: left;\n" +
            "    padding-left: 15px;\n" +
            "    padding-right: 15px;\n" +
            "    box-sizing: border-box;\n" +
            "}\n" +
            ".col-full{\n" +
            "    width: 100%;\n" +
            "    float: left;\n" +
            "    padding-left: 15px;\n" +
            "    padding-right: 15px;\n" +
            "    box-sizing: border-box;\n" +
            "}\n" +
            ".form-container-fluid{\n" +
            "    width: 100%;\n" +
            "   \n" +
            "}\n" +
            ".padding-tp-0{\n" +
            "    padding-top: 0;\n" +
            "}\n" +
            ".padding-btm-0{\n" +
            "    padding-bottom: 0;\n" +
            "}\n" +
            ".form-container-fluid:after,.form-container-fluid:before{\n" +
            "    content: '';\n" +
            "    display: table;\n" +
            "    clear: both;\n" +
            "\n" +
            "}\n" +
            "h2.form-title,.qust-cat-title{\n" +
            "    font-size: 14px;\n" +
            "    margin:0;\n" +
            "    color: #000;\n" +
            "    font-weight: 600;\n" +
            "}\n" +
            ".text-center{\n" +
            "    text-align: center;\n" +
            "}\n" +
            ".form-heading,.qust-cat-title{\n" +
            "    padding: 10px;\n" +
            "}\n" +
            ".overflow-hidden{\n" +
            "    overflow: hidden;\n" +
            "}\n" +
            ".no-border{\n" +
            "    border: 0\n" +
            "}\n" +
            ".qst-heading{\n" +
            "    background: #ddd;\n" +
            "    padding: 10px 40px;\n" +
            "}\n" +
            ".qstn-row{\n" +
            "   padding: 10px 35px 10px 20px ;\n" +
            "    background: #fff;\n" +
            "}\n" +
            "p.qst-text{\n" +
            "    color: #3a3a3a;\n" +
            "    font-weight: 500;\n" +
            "    margin-top: 0;\n" +
            "    margin-bottom: 10px\n" +
            "}\n" +
            "p.qst-text span{\n" +
            "    color: #000;\n" +
            "    font-weight: 600;\n" +
            "    font-size: 16px;\n" +
            "    \n" +
            "}\n" +
            "\n" +
            "/** custom radio button**/\n" +
            ".radio-inline{\n" +
            "    padding-right: 25px;\n" +
            "}\n" +
            "[type=\"radio\"]:checked,\n" +
            "[type=\"radio\"]:not(:checked),[type=\"checkbox\"]:checked,[type=\"checkbox\"]:not(:checked){\n" +
            "    position: absolute;\n" +
            "    left: -9999px;\n" +
            "}\n" +
            "[type=\"radio\"]:checked + label,\n" +
            "[type=\"radio\"]:not(:checked) + label,\n" +
            "[type=\"checkbox\"]:checked + label,\n" +
            "[type=\"checkbox\"]:not(:checked) + label\n" +
            "{\n" +
            "    position: relative;\n" +
            "    padding-left: 28px;\n" +
            "    cursor: pointer;\n" +
            "    line-height: 20px;\n" +
            "    display: inline-block;\n" +
            "    color: #666;\n" +
            "    font-size: 12px;\n" +
            "    margin-bottom: 10px;\n" +
            "}\n" +
            "[type=\"radio\"]:checked + label:before,\n" +
            "[type=\"radio\"]:not(:checked) + label:before,\n" +
            "[type=\"checkbox\"]:checked + label:before,\n" +
            "[type=\"checkbox\"]:not(:checked) + label:before{\n" +
            "    content: '';\n" +
            "    position: absolute;\n" +
            "    left: 0;\n" +
            "    top: 0;\n" +
            "    width: 16px;\n" +
            "    height: 16px;\n" +
            "    border: 1px solid #ddd;\n" +
            "    border-radius: 100%;\n" +
            "    background: #fff;\n" +
            "}\n" +
            "[type=\"checkbox\"]:checked + label:before,\n" +
            "[type=\"checkbox\"]:not(:checked) + label:before{\n" +
            "    border-radius: 0;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "[type=\"radio\"]:checked + label:after,\n" +
            "[type=\"radio\"]:not(:checked) + label:after{\n" +
            "    content: '';\n" +
            "    width: 10px;\n" +
            "    height: 10px;\n" +
            "    background: #34b2ed;\n" +
            "    position: absolute;\n" +
            "    top: 4px;\n" +
            "    left: 4px;\n" +
            "    border-radius: 100%;\n" +
            "    -webkit-transition: all 0.2s ease;\n" +
            "    transition: all 0.2s ease;\n" +
            "}\n" +
            "[type=\"checkbox\"]:checked + label:after{\n" +
            "    content: '';\n" +
            "    width: 4px;\n" +
            "    height: 10px;\n" +
            "/*    background: #34b2ed;*/\n" +
            "    position: absolute;\n" +
            "    top: 1px;\n" +
            "    left: 6px;\n" +
            "    border:1px solid transparent;\n" +
            "    border-bottom: 2px solid #34b2ed;\n" +
            "    border-right: 2px solid #34b2ed;\n" +
            "    -webkit-transition: all 0.2s ease;\n" +
            "    transition: all 0.2s ease;\n" +
            "    transform: rotate(30deg)\n" +
            "}\n" +
            "[type=\"radio\"]:not(:checked) + label:after {\n" +
            "    opacity: 0;\n" +
            "    -webkit-transform: scale(0);\n" +
            "    transform: scale(0);\n" +
            "}\n" +
            "[type=\"radio\"]:checked + label:after {\n" +
            "    opacity: 1;\n" +
            "    -webkit-transform: scale(1);\n" +
            "    transform: scale(1);\n" +
            "}\n" +
            "/***END custom radio button**/\n" +
            ".q-info{\n" +
            "    font-size: 9px;\n" +
            "    font-style: italic;\n" +
            "    color:#737373;;\n" +
            "    margin: 3px 0;\n" +
            "}\n" +
            "p.sub_qstn{\n" +
            "    font-size: 11px;\n" +
            "    margin-bottom: 5px;\n" +
            "    margin-top: 10px;\n" +
            "}\n" +
            ".qst-options{margin-top: 10px;}\n" +
            ".extra-info{\n" +
            "    display: block;\n" +
            "    height: 35px;\n" +
            "    border: 1px solid #ddd;\n" +
            "    padding-left: 5px;\n" +
            "    border-radius: 3px;\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".qst-row{\n" +
            "    padding: 15px 0;\n" +
            "}\n" +
            ".btn-btm{\n" +
            "    border: 0;\n" +
            "    padding-top: 15px;\n" +
            "    padding-bottom: 15px;\n" +
            "}\n" +
            ".btn-btm button{\n" +
            "    padding: 10px 30px;\n" +
            "    border: 0;\n" +
            "    background: #34B2ED;\n" +
            "    color: #fff;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            "    </style>\n" +
            "    \n" +

            "\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <form id=\"forms\">\n" +
            "    <div class=\"form-container-fluid top clearfix\">\n" +
            "        <div class=\"row\">\n" +
            "            <div class=\"form-heading overflow-hidden\">\n" +
            "               <div class=\"col-6\">\n" +
            "                    <h2 class=\"form-title text-center\">Item</h2>\n" +
            "                </div>\n" +
            "                <div class=\"col-6\">\n" +
            "                    <h2 class=\"form-title text-center\">Details</h2>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"row\">\n" +
            "            <div class=\"col-full qst-heading\">\n" +
            "               <h2 class=\"form-title\">Roof</h2> \n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <!-- Question row 1 -->\n" +
            "        <div class=\"row qst-row\">\n" +
            "            <div class=\"col-6\">\n" +
            "                <div class=\"col-full qstn-row\">\n" +
            "                <p class=\"qst-text\"><span>A</span>. Is the roof leaking?</p>\n" +
            "                <div class=\"qst-options\">\n" +
            "                       <span class=\"radio-inline\">\n" +
            "                           <input type=\"radio\" id=\"q1\" name=\"q1\" value=\"yes\" data-type=\"radio\">\n" +
            "                           <label for=\"q1\">Yes</label>\n" +
            "                       </span>\n" +
            "                        <span class=\"radio-inline\">\n" +
            "                        <input type=\"radio\" id=\"q2\" name=\"q1\" value=\"no\" data-type=\"radio\">\n" +
            "                        <label for=\"q2\">No</label>\n" +
            "                       </span>\n" +
            "                </div>\n" +
            "                <p class=\"q-info\">If the roof allows any water to enter is considered to be leaking</p>\n" +
            "                \n" +
            "            </div>\n" +
            "            </div>\n" +
            "            \n" +
            "         </div>\n" +
            "        <!-- Question row 1::END -->\n" +
            "        <!-- Question row 2 -->\n" +
            "        <div class=\"row qst-row\">\n" +
            "            <div class=\"col-6\">\n" +
            "                <div class=\"col-full qstn-row\">\n" +
            "                <p class=\"qst-text\"><span>B</span>.Is the damaged, deteriorated, leaking roof tarped?</p>\n" +
            "                <div class=\"qst-options\">\n" +
            "                       <span class=\"radio-inline\">\n" +
            "                           <input type=\"radio\" id=\"q3c1\" name=\"q2\" value = 'yes' data-type=\"radio\">\n" +
            "                           <label for=\"q3c1\">Yes</label>\n" +
            "                       </span>\n" +
            "                        <span class=\"radio-inline\">\n" +
            "                        <input type=\"radio\" id=\"q3c2\" name=\"q2\" value = 'no' data-type=\"radio\">\n" +
            "                        <label for=\"q3c2\">No</label>\n" +
            "                       </span>\n" +
            "                </div>\n" +
            "             </div>\n" +
            "            </div>\n" +
            "           \n" +
            "         </div>\n" +
            "        <!-- Question row 2::END -->\n" +
            "        <!-- Question row 3 -->\n" +
            "        <div class=\"row qst-row\">\n" +
            "            <div class=\"col-6\">\n" +
            "                <div class=\"col-full qstn-row\">\n" +
            "                <p class=\"qst-text\"><span>C</span>. Is there ceiling damage due to the roof leak?</p>\n" +
            "                <div class=\"qst-options\">\n" +
            "                       <span class=\"radio-inline\">\n" +
            "                           <input type=\"text\" id=\"q3\" name=\"q3\" value=\"\" data-type=\"text\">\n" +
            "                           \n" +
            "                       </span>\n" +
            "                       \n" +
            "                </div>\n" +
            "             </div>\n" +
            "            </div>\n" +
            "            \n" +
            "         </div>\n" +
            "        <!-- Question row 3::END -->\n" +
            "\n" +
            "        <!-- Question row 4 -->\n" +
            "        <div class=\"row qst-row\">\n" +
            "            <div class=\"col-6\">\n" +
            "                <div class=\"col-full qstn-row\">\n" +
            "                <p class=\"qst-text\"><span>D</span>. Is there ceiling damage due to the roof leak?</p>\n" +
            "                <div class=\"qst-options\">\n" +
            "                  <span class=\"radio-inline\">\n" +
            "                    <textarea name='q4' data-type='textarea'></textarea>\n" +
            "                  </span>\n" +
            "                </div>\n" +
            "             </div>\n" +
            "            </div>\n" +
            "            \n" +
            "         </div>\n" +
            "        <!-- Question row 4::END -->\n" +
            "\n" +
            "        <!-- Question row 5 -->\n" +
            "        <div class=\"row qst-row\">\n" +
            "            <div class=\"col-6\">\n" +
            "                <div class=\"col-full qstn-row\">\n" +
            "                <p class=\"qst-text\"><span>E</span>. Is there ceiling damage due to the roof leak?</p>\n" +
            "                <div class=\"qst-options\">\n" +
            "                    <span class=\"radio-inline\">\n" +
            "                         <input type=\"checkbox\" id=\"test3\" name=\"q5\" value=\"damaged\" data-type='checkbox'>\n" +
            "                         <label for=\"test3\">Damaged</label>\n" +
            "                     </span>\n" +
            "                      <span class=\"radio-inline\">\n" +
            "                          <input type=\"checkbox\" id=\"test4\" name=\"q5\" value=\"Deteriorated\" data-type='checkbox'>\n" +
            "                          <label for=\"test4\">Deteriorated</label>\n" +
            "                     </span>\n" +
            "                     <span class=\"radio-inline\">\n" +
            "                          <input type=\"checkbox\" id=\"test5\" name=\"q5\" value=\"Missing\" data-type='checkbox'>\n" +
            "                          <label for=\"test5\">Missing</label>\n" +
            "                     </span>\n" +
            "                     <span class=\"radio-inline\">\n" +
            "                          <input type=\"checkbox\" id=\"test6\" name=\"q5\" value=\"Shingles\" data-type='checkbox'>\n" +
            "                          <label for=\"test6\">Shingles/Both?</label>\n" +
            "                     </span>\n" +
            "                </div>\n" +
            "             </div>\n" +
            "            </div>\n" +
            "            \n" +
            "         </div>\n" +
            "        <!-- Question row 5::END -->\n" +
            "\n" +
            "        <!-- Question row 6 -->\n" +
            "        <div class=\"row qst-row\">\n" +
            "            <div class=\"col-6\">\n" +
            "                <div class=\"col-full qstn-row\">\n" +
            "                <p class=\"qst-text\"><span>F</span>. Sample Question?</p>\n" +
            "                <div class=\"qst-options\">\n" +
            "                    <span class=\"radio-inline\">\n" +
            "                         <input type=\"checkbox\" id=\"est3\" name=\"q6\" value=\"dama\" data-type='checkbox'>\n" +
            "                         <label for=\"est3\">Dama</label>\n" +
            "                     </span>\n" +
            "                      <span class=\"radio-inline\">\n" +
            "                          <input type=\"checkbox\" id=\"est4\" name=\"q6\" value=\"Deterior\" data-type='checkbox'>\n" +
            "                          <label for=\"est4\">Deter</label>\n" +
            "                     </span>\n" +
            "                     <span class=\"radio-inline\">\n" +
            "                          <input type=\"checkbox\" id=\"est5\" name=\"q6\" value=\"Miss\" data-type='checkbox'>\n" +
            "                          <label for=\"est5\">Miss</label>\n" +
            "                     </span>\n" +
            "                     <span class=\"radio-inline\">\n" +
            "                          <input type=\"checkbox\" id=\"est6\" name=\"q6\" value=\"Shingle\" data-type='checkbox'>\n" +
            "                          <label for=\"est6\">Shingles?</label>\n" +
            "                     </span>\n" +
            "                </div>\n" +
            "             </div>\n" +
            "            </div>\n" +
            "            \n" +
            "         </div>\n" +
            "        <!-- Question row 5::END -->\n" +
            "\n" +
            "  <script type=\"text/javascript\">\n" +
            "    /**  \n" +
            "     * Questions Count  - Each question should be inside the class 'qst-text'.\n" +
            "     * input name should be of the format q1,q2,q3 etc..\n" +
            "     * every input component type should be addressed with the attribute 'data-type'. eg : data-type = 'text', data-type = 'radio', data-type = 'checkbox', data-type = 'textarea'\n" +
            "     */\n" +
            "\n" +
            "    /**\n" +
            "     * get all the attended answers\n" +
            "     * @return {JSON} answersSelected\n" +
            "     */\n" +
            "    function getAnswers() {\n" +
            "\n" +
            "      var questionsCount = document.querySelectorAll('.qst-text').length; //Get total number of questions\n" +
            "      var answersSelected = [];\n" +
            "      if (questionsCount > 0) {\n" +
            "        for (index = 1; index <= questionsCount; index++) {\n" +
            "          var obj = {};\n" +
            "          var userInput = '';\n" +
            "          var elmtFlag = true;\n" +
            "          var elmtType = document.getElementsByName(\"q\"+index)[0].getAttribute('data-type'); //Get input type\n" +
            "          if (typeof(elmtType) !== \"undefined\" && elmtType !== null) {\n" +
            "            if (elmtType == 'radio') {\n" +
            "              if(document.querySelector('input[name=\"q'+index+'\"]:checked')) {\n" +
            "                userInput = document.querySelector('input[name=\"q'+index+'\"]:checked').value; \n" +
            "              }        \n" +
            "            } else if(elmtType == 'text') {\n" +
            "              userInput = document.querySelector('input[name=\"q'+index+'\"]').value;\n" +
            "            } else if(elmtType == 'textarea') {\n" +
            "              userInput = document.querySelector('textarea[name=\"q'+index+'\"]').value;\n" +
            "            } else if(elmtType == 'checkbox') {\n" +
            "              var options = [];\n" +
            "              var els = document.getElementsByName(\"q\"+index);\n" +
            "              for (var i=0;i<els.length;i++) {\n" +
            "                if (els[i].checked) {\n" +
            "                  options.push(els[i].value);\n" +
            "                }\n" +
            "              }\n" +
            "              userInput = options;\n" +
            "            } else {\n" +
            "              elmtFlag = false; \n" +
            "            } \n" +
            "            if (elmtFlag) {\n" +
            "              obj.qname =  \"q\"+index;\n" +
            "              obj.ans = userInput;\n" +
            "              obj.qtype = elmtType;\n" +
            "              answersSelected.push(obj);\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      } \n" +
            "      answersSelected = JSON.stringify(answersSelected);\n" +
            "       Android.saveData(answersSelected);"+
            "      return answersSelected;\n" +
            "    }\n" +
            "\n" +
            "    /**\n" +
            "     * set all the attended answers\n" +
            "     * @param {JSON string} answersSelected\n" +
            "     */\n" +
            "    function setAnswers(answers) {\n" +
            " console.log('this is'+answers);"+
            "      try {\n" +
            "        var ansArr = JSON.parse(answers);\n" +
            "        for(var i = 0; i < ansArr.length; i++) {\n" +
            "          var questions = ansArr[i];\n" +
            "          var elmtType = questions.qtype;\n" +
            "          if (questions.ans != '') {\n" +
            "            var qname = questions.qname;\n" +
            "            var selectedAns = questions.ans;\n" +
            "            if ( elmtType == 'radio') {\n" +
            "              document.querySelector('input[name=\"'+qname+'\"][value=' + selectedAns + ']').checked = true;\n" +
            "            } else if(elmtType == 'text') {\n" +
            "              document.querySelector('input[name=\"'+qname+'\"]').value = selectedAns;\n" +
            "            } else if(elmtType == 'textarea') {\n" +
            "              document.querySelector('textarea[name=\"'+qname+'\"]').value = selectedAns;\n" +
            "            } else if(elmtType == 'checkbox') {\n" +
            "              for (var j=0;j<selectedAns.length;j++) {\n" +
            "                document.querySelector('input[name=\"'+qname+'\"][value=' + selectedAns[j] + ']').checked = true;\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +

            "        }\n" +
            "      } catch (e) {\n" +
            " Android.showToast(e); "+
            "          alert('Invalid JSON input!');\n" +
            "          return false;\n" +
            "      }\n" +
            "    }\n" +
            "\n" +
            "</script>\n" +


            "        <!-- Next previous button-->\n" +
            "        \n" +
            "        <div class=\"row btn-btm\">\n" +
            "            <div class=\"col-6 text-center\">\n" +
            "                <button type=\"button\" onClick=\"Android.setAnswers()\">Previous</button>\n" +
            "            </div>\n" +
            "            <div class=\"col-6 text-center\">\n" +
            "                <button type=\"button\" onClick=\"getAnswers()\">Next</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    </form>\n" +
            "  </body>\n" +
            "</html>";








    ////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mainlist = (ListView) findViewById(R.id.main_list);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,R.id.textview, mobileArray);

        mainlist.setAdapter(adapter);

        mainlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                    html = simple;
                        break;
                    case 1:
                        html = form;
                        break;
                    case 2:
                        html = table;
                        break;
                    case 3:
                        html = responsive;
                        break;

                    case 4:
                        html = original;
                        break;

                    case 5:
                        html = moreScript;
                        break;
                    default:
                        html = simple;
                }

                Intent i = new Intent(MainActivity.this,WebActivity.class);
                i.putExtra("html",html);
                startActivity(i);
            }
        });
    }
}
