package org.mum.wap.presentation.customtag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @Author Elham
 * @Date 04/23/2018
 * This is Custom Tag Class that provide INPUT element in HTML and it recieve and create all input attributes
 *
 */
public class InputCustomTag extends SimpleTagSupport {


    String type;
    String name;
    String autocomplete;
    String required;
    String value;
    String htmlClass;

    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();
        if(type!=null&&name!=null&&autocomplete!=null&&value!=null&&htmlClass!=null) {
            out.write(String.format("<input type='%s' name='%s' autocomplete='%s' %s value='%s' class='%s'/>", type, name , autocomplete , (required.equals("true")?"required":"") , value , htmlClass));
        }else if(type!=null&&name!=null&&autocomplete!=null){
            out.write(String.format("<input type='%s' name='%s' autocomplete='%s' %s class='%s'/>", type, name , autocomplete , (required.equals("true")?"required":"") , htmlClass));
        }else if(type!=null && value !=null){
            out.write(String.format("<input type='%s' value='%s' class='%s'/>", type, value ,htmlClass));
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
    public void setHtmlClass(String htmlClass){ this.htmlClass = htmlClass; }
}
