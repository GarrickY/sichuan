package com.ygq.jobs.restassured;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class VantageCms {
    @BeforeTest
    public void initializer(){
        RestAssured.baseURI = "https://cms.csw.lenovo.com/sitemapjson";
        RestAssured.port = 443;
    }

    @Test
    public void getGeneralSection(){
        ValidatableResponse resp = RestAssured.get().then();
        resp.body("general.homepage-action",equalTo(""));
        resp.body("gecvcvneral.homepage",equalTo("https://cms.csw.lenovo.com"))
                    .body("general.cmsVersion",equalTo("1.0.249.0"));
        String[] names=new String[]{"CMS-CD-PROD-VPN-Site1","CMS-CD-PROD-VPN-Site2"};
        resp.body("general.appName",containsString("CMS-CD-PROD-VPN-Site"));
    }

    @Test
    public void getThemeSection(){
        RestAssured.get().then().body("theme.themeName",equalTo("Consumer"));
    }

    @Test
    public void getFeatureContentSection(){
        RestAssured.get().then().body("feature-content.categories.feature-id",hasItems("E40B12CE-C5DD-4571-BBC6-7EA5879A8472"));
        System.out.println(RestAssured.get().getBody().print());

    }

    @Test
    public void getNavigationSection(){

    }

    @AfterTest
    public void cleanEnvironment(){

    }
}