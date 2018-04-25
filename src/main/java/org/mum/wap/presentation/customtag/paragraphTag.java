/**
 * @author Abdelrahman
 *
 * this class is used for the custom tag of type paragraph
 */
package org.mum.wap.presentation.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class paragraphTag extends SimpleTagSupport {
    String theclass;
    String words;

    public void doTag() throws JspException, IOException // render custom tag
    {
        JspWriter out = getJspContext().getOut();
        if (theclass != null)
            out.write(String.format("<p class='%s'>%s</p>", theclass, words));
        else
            out.write(String.format("<p>%s</p>", words));
    }

    // Need a setter for each attribute of custom tag
    public void settheclass(String foreColor) {
        this.theclass = foreColor;
    }

    public void setwords(String text) {
        this.words = text;
    }
}