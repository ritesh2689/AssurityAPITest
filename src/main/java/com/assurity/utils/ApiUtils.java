package com.assurity.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Contains methods related to api automation.
 *
 * @author Ritesh Vashisth
 */
public class ApiUtils {

    private static Logger log = Logger.getLogger(ApiUtils.class.getName());
    private HttpClient httpClient = null;


    /**
     * @param restURL
     * @return
     * @throws IOException
     */
    public HttpResponse getRequestWithJsonContentType(String restURL) throws IOException {
        httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(restURL);
        request.setHeader("Content-Type", "application/json");
        log.info("Request Object is: " + request);
        return httpClient.execute(request);
    }

    /**
     * This method formats a json object of type JSONObject and return formatted json as a string
     *
     * @param jsonObject
     * @return formattedJSON as String
     */
    public static String getFormattedJSON(JSONObject jsonObject) {
        String formattedJSON = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Object object = objectMapper.readValue(jsonObject.toString(), Object.class);
            ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
            /* Get the formatted json */
            formattedJSON = objectWriter.writeValueAsString(object);
            log.info("Returning Formatted JSON: " + formattedJSON);
        } catch (Exception e) {
            log.warn("Some exception has occured" + e);
            return formattedJSON;
        }
        return formattedJSON;
    }

    /**
     * Get the JSON Object from the HTTP Response, JSON Object starts With { and Ends with }
     *
     * @param httpResponse
     * @return JSONObject
     * @throws JSONException
     */
    public JSONObject getJSONObjectForResponse(HttpResponse httpResponse)
            throws IOException, JSONException {
        JSONObject jo = null;
        HttpEntity respEntity = httpResponse.getEntity();
        String responseString = EntityUtils.toString(respEntity, "UTF-8");
        log.debug(responseString);
        try {
            jo = new JSONObject(responseString);
        } catch (JSONException e) {
            jo = new JSONObject("{}");
        }
        log.info(getFormattedJSON(jo));
        return jo;
    }
}
