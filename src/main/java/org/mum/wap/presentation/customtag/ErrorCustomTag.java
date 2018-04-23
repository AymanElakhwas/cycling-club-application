package org.mum.wap.presentation.customtag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @Author Elham
 * @Date 04/23/2018
 * This is Custom Tag Class that provide Error Span
 *
 */
public class ErrorCustomTag extends SimpleTagSupport {

    String text;
    String htmlClass;

    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();
        if(htmlClass!=null&&text!=null){
            out.println(String.format("<div class='%s'>%s</div>",htmlClass,text));
        }
    }

    public void setText(String text){
        this.text = text;
    }

    public void setHtmlClass(String htmlClass){
        this.htmlClass = htmlClass;
    }

}
