package com.assurity.featureTest;

import com.assurity.base.TestBase;
import com.assurity.impl.CategoryDetailsImpl;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Contains test methods with '@' annotation to test api response.
 *
 * @author Ritesh Vashisth
 */
public class TestFeatureAPIResponse extends TestBase {

    private CategoryDetailsImpl categoryDetails;
    private static Logger log = Logger.getLogger(TestFeatureAPIResponse.class.getName());

    /**
     * Before class method to include class level initializations.
     */
    @BeforeClass(description = "Method to run before class execution starts")
    public void beforeClass() {
        categoryDetails = new CategoryDetailsImpl();
    }

    @Test(description = "Validate acceptance criteria for Category Description API")
    public void testApiAcceptanceCriteria() throws JSONException {
        SoftAssert softAssert = new SoftAssert();
        String actualDescriptionText = "";
        JSONObject responseJSON = categoryDetails.getCategoryDetailResponse();
        log.debug("JSON Response--> " + responseJSON);
        String actualName = responseJSON.get("Name").toString();
        log.debug("Actual Name--> " + actualName);

        softAssert.assertEquals(actualName, "Carbon credits", "Actual Name mismatch");
        softAssert.assertTrue(responseJSON.getBoolean("CanRelist"), "CanRelist Value is not TRUE");
        log.debug("Actual value of CanRelist--> " + responseJSON.getBoolean("CanRelist"));

        JSONArray promotionJSONArray = responseJSON.getJSONArray("Promotions");
        for (int i = 0; i < promotionJSONArray.length(); i++) {
            if (promotionJSONArray.getJSONObject(i).get("Name").equals("Gallery")) {
                actualDescriptionText = promotionJSONArray.getJSONObject(i).get("Description").toString();
                break;
            }
        }
        log.debug("Actual Description Text--> " + actualDescriptionText);

        softAssert.assertTrue(actualDescriptionText.contains("2x larger image"), "Description Text mismatch");

        softAssert.assertAll();
    }
}
