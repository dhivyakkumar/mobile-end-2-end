package testcases;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;

public class BaseTest {
    private String pathOfCapabilitieFile = "src/test/resources/capabilities.json";
    public static AppiumDriver driver;

    @BeforeSuite
    public void setup()throws Exception {

        MutableCapabilities caps = new MutableCapabilities();
        URL url;

        String platform = System.getProperty("platform");
        switch (platform) {
            case "local":
                caps = getDesiredCapabilities(platform, pathOfCapabilitieFile);
                url = new URL(caps.asMap().get("url").toString());
                break;

            case "iOS":
                caps = getDesiredCapabilities(platform, pathOfCapabilitieFile);
                url = new URL(caps.asMap().get("url").toString());
                break;

            case "android":
                caps = getDesiredCapabilities(platform, pathOfCapabilitieFile);
                url = new URL(caps.asMap().get("url").toString());
                break;

            default:
                caps = getDesiredCapabilities("local", pathOfCapabilitieFile);
                url = new URL(caps.asMap().get("url").toString());
        }

        driver = new AppiumDriver(url, caps);
    }

    private static JSONArray parseJSON(String jsonLocation) throws Exception {
        JSONParser jsonParser = new JSONParser();
        return (JSONArray) jsonParser.parse(new FileReader(jsonLocation));
    }

    private static JSONObject getCapability(String capabilityName, String jsonLocation) throws Exception {
        JSONArray capabilitiesArray = parseJSON(jsonLocation);
        for (Object jsonObj : capabilitiesArray) {
            JSONObject capability = (JSONObject) jsonObj;
            if (capability.get("name").toString().equalsIgnoreCase(capabilityName)) {
                return (JSONObject) capability.get("caps");
            }
        }
        return null;
    }

    private static HashMap<String, Object> convertCapsToHashMap(String capabilityName, String jsonLocation) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(getCapability(capabilityName, jsonLocation).toString(), HashMap.class);
    }

    public static DesiredCapabilities getDesiredCapabilities(String capabilityName, String capsContentRootLocation) throws Exception {
        String jsonLocation = System.getProperty("user.dir") + "/" + capsContentRootLocation;
        HashMap<String, Object>  caps = convertCapsToHashMap(capabilityName, jsonLocation);
        return new DesiredCapabilities(caps);
    }


    @AfterSuite
    public void teardown(){
        driver.quit();
    }
}
