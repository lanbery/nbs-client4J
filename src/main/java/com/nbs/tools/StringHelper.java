package com.nbs.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Package : com.nbs.tools
 * @Description : <p></p>
 * @Author : lambor.c
 * @Date : 2018/6/19-18:17
 * Copyright (c) 2018, NBS , lambor.c<lanbery@gmail.com>.
 * All rights reserved.
 */
public class StringHelper {
    public static final Pattern CRLF = Pattern.compile("(\n\t|\n|\t)");
    private StringHelper(){}
    private static class StringHolder{
         static final StringHelper instance = new StringHelper();
    }

    public static StringHelper getInstance(){
        return StringHolder.instance;
    }

    /**
     *
     * @param in
     * @return
     */
    public String replaceAllCRLF2Br(String in){
        if(in==null)return null;
        Matcher matcher = CRLF.matcher(in);
        if(matcher.find()){
            return matcher.replaceAll("<br>");
        }
        return in;
    }
}
