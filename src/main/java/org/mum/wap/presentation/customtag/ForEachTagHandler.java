package org.mum.wap.presentation.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author Elham
 * @Date 04/24/2018
 * This is Custom Tag Class that provide for each in HTML and it recieve an array and loop trought array and write
 * it to jsp
 *
 */
public class ForEachTagHandler extends SimpleTagSupport {

    ArrayList<Object> items;
    String var;

    public void doTag() throws IOException, JspException {
        for(Object item : items) {
            getJspContext().setAttribute(var, item);
            getJspBody().invoke(null);
        }
    }

    public void setItems(ArrayList<Object> items){
        this.items = items;
    }
    public void setVar(String var){this.var = var;}

}
