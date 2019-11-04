package com.assurity.impl;

import com.assurity.base.TestBase;
import com.assurity.utils.ApiUtils;
import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * Contains methods to be called directly by test class related to a particular api.
 * Here we are writing methods to be utilized for Category details api.
 * e.g this class is for (v1/Categories/6327/Details.json?catalogue=false)
 *
 * @author Ritesh Vashisth
 */
public class CategoryDetailsImpl extends TestBase {

    private static Logger log = Logger.getLogger(CategoryDetailsImpl.class.getName());

    /**
     * Method return JSONObject response for Category Detail API
     *
     * @return JSONObject
     */
    public JSONObject getCategoryDetailResponse() {
        JSONObject responseJsonCatResponse = new JSONObject();
        ApiUtils apiUtils = new ApiUtils();

        try {
            String reqURL = testData.get("assurity.api.baseURL") + "/" + testData.get("category.details.api");
            HttpResponse httpResponse = apiUtils.getRequestWithJsonContentType(reqURL);
            responseJsonCatResponse = apiUtils.getJSONObjectForResponse(httpResponse);
        } catch (Exception ex) {
            log.debug(
                    "Some unknown exception has occured causing issue while fetching API results - " + ex.getMessage());
        }
        return responseJsonCatResponse;
    }
}
