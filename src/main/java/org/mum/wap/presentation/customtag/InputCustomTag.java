package org.mum.wap.presentation.customtag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class InputCustomTag extends SimpleTagSupport {


    String type;
    String name;
    String autocomplete;
    String required;

    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();
        if(name!=null&&type!=null&&autocomplete!=null) {
            out.write(String.format("<input type='%s' name='%s' autocomplete='%s' %s/>", type, name , autocomplete , (required.equals("true")?"required":"")));
        }else{
            out.write(String.format("<input type='%s' %s/>" , type ,(required.equals("true")?"required":"")));
        }
    }

    public void setName(String name){
        this.name= name;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setAutocomplete(String autocomplete){
        this.autocomplete = autocomplete;
    }
    public void setRequired(String required){
        this.required = required;
    }
}
