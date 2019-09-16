package com.concurrent.test;

import com.concurrent.CallableTemplate;
import com.concurrent.impl.CallableTaskFrameWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class SendMessageTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTaskFrameWork callableTaskFrameWork = new CallableTaskFrameWork();
        List<CallableTemplate<Map<String, String>>> tasks = new ArrayList<CallableTemplate<Map<String, String>>>();
        SendMessageHandler sendMessageHandler;
        for (int i = 0; i < 2000; i++) {
            sendMessageHandler = new SendMessageHandler("email" + i, "content" + i);
            tasks.add(sendMessageHandler);
        }

        List<Map<String, String>> results = callableTaskFrameWork.submitsAll(tasks);

        for (Map<String, String> map : results) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "\t" + entry.getValue());
            }
        }

    }
}
