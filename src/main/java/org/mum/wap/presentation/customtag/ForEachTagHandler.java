package org.mum.wap.presentation.customtag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @Author Elham
 * @Date 04/24/2018
 * This is Custom Tag Class that provide for each in HTML and it recieve an array and loop trought array and write
 * it to jsp
 *
 */
public class ForEachTagHandler extends SimpleTagSupport {

    String[] items;

    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();
        for(String item : items)
            out.println(item);
    }


    public void setItems(String[] items){
        this.items = items;
    }

}
