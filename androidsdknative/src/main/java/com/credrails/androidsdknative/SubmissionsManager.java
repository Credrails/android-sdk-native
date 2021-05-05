package com.credrails.androidsdknative;

import com.credrails.androidsdknative.models.BaseAPIResponse;
import com.credrails.androidsdknative.models.Institution;
import com.google.gson.Gson;

import java.util.HashMap;

public class SubmissionsManager {

    public Institution[] getInstitutions() {
        return getInstitutions("");

    }


    public Institution[] getInstitutions(String countryCode) {
        String requestUrl = URLS.InstitutionsEndpoint;
        if(countryCode != "") {
            requestUrl += "?countryCode=" + countryCode;
        }
        StringBuilder sb = new StringBuilder();


        try {

            CredrailsAPIClient.sendGetRequest(requestUrl);

            String[] response = CredrailsAPIClient.readMultipleLinesRespone();
            for (String line : response) {
                sb.append(line);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        CredrailsAPIClient.disconnect();
        Gson gson = new Gson();
        BaseAPIResponse res = gson.fromJson(sb.toString(), BaseAPIResponse.class);
        return res.data;
    }
}
