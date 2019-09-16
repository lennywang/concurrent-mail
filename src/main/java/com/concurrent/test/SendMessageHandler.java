package com.concurrent.test;

import com.concurrent.CallableTemplate;

import java.util.HashMap;
import java.util.Map;

public class SendMessageHandler extends CallableTemplate<Map<String,String>> {
    private String eimail;
    private String content;

    public SendMessageHandler(String email,String content){
        this.eimail=email;
        this.content=content;
    }

    public Map<String, String> process() {
        SendMessageService sendMessageService = new SendMessageService();
        sendMessageService.sendMessage(eimail,content);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(eimail,content);
        return map;
    }
}
