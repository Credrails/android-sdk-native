package com.credrails.androidsdknative;

import com.credrails.androidsdknative.models.SessionsParameter;

import java.io.IOException;
import java.util.HashMap;

public class SessionsManager {

    public String createSession(SessionsParameter params) throws IOException {

        StringBuilder sb = new StringBuilder();

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("ref_user", params.getUserReference());
        map.put("ref_email", params.getEmail());
        map.put("ref_name", params.getName());
        map.put("session_type", 1);
        map.put("result_mode", 1);
        map.put("callback_url", "https://credrails.com");

        try {

            CredrailsAPIClient.sendPostRequest(URLS.SessionsEndpoint, map);

            String[] response = CredrailsAPIClient.readMultipleLinesRespone();
            for (String line : response) {
                sb.append(line);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        CredrailsAPIClient.disconnect();
        return sb.toString();
    }
}
