package org.mum.wap.presentation.customtag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class InputCustomTag extends SimpleTagSupport {


    String type;
    String name;
    String autocomplete;
    String required;
    String value;

    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();
        if(type!=null&&name!=null&&autocomplete!=null&&value!=null) {
            out.write(String.format("<input type='%s' name='%s' autocomplete='%s' %s value='%s'/>", type, name , autocomplete , (required.equals("true")?"required":"") , value));
        }else if(type!=null&&name!=null&&autocomplete!=null){
            out.write(String.format("<input type='%s' name='%s' autocomplete='%s' %s/>", type, name , autocomplete , (required.equals("true")?"required":"")));
        }else if(type!=null && value !=null){
            out.write(String.format("<input type='%s' value='%s'/>", type, value));
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
    public void setValue(String value){ this.value=value; }
}
