package com.credrails.androidsdknative;

import com.credrails.androidsdknative.models.SessionsParameter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;

public class SessionsManager {

    public void createSession(SessionsParameter params) throws IOException {

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("ref_user", params.getUserReference());
        map.put("ref_email", params.getEmail());
        map.put("ref_name", params.getName());

        HttpURLConnection connection
                = CredrailsAPIClient.sendPostRequest(URLS.SessionsEndpoint, map);
    }
}
