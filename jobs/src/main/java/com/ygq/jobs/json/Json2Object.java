package com.ygq.jobs.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import io.restassured.path.json.JsonPath;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Json2Object {
    private String cmsJson = "data/vantage-cms.json";

    public CmsContent parseToCmsContent() {
        URL url = Thread.currentThread().getContextClassLoader().getResource(cmsJson);
        JsonPath j = new JsonPath(url);
        CmsContent cms = j.getObject(".", CmsContent.class);


        System.out.println("CMS-General:" + cms.general.appName);
        System.out.println("CMS-General:" + cms.general.cmsVersion);
        System.out.println("CMS-General:" + cms.general.homepage);
        System.out.println("CMS-General:" + cms.general.homepage_action);

        System.out.println("CMS-Theme:" + cms.theme.bgColor);
        System.out.println("CMS-Theme:" + cms.theme.bgOpaqueness);
        System.out.println("CMS-Theme:" + cms.theme.logoImage);
        System.out.println("CMS-Theme:" + cms.theme.themeName);

        System.out.println("CMS-navigation:" + cms.navigation.get(1).menuId);
        System.out.println("CMS-navigation:" + cms.navigation.get(1).items.get(1).friendlyName);

        return cms;
    }

    public CmsContent parseToCmsContentPlus() {
        String json = GetJsonString();
        json = json.replace("feature-content", "feature_content");
        json = json.replace("homepage-action", "homepage_action");
        json = json.replace("feature-id", "feature_id");
        json = json.replace("action-label", "action_label");
        json = json.replace("action-command", "action_command");

        JsonPath j = new JsonPath(json);
        CmsContent cms = j.getObject(".", CmsContent.class);


        System.out.println("CMS-General:" + cms.general.appName);
        System.out.println("CMS-General:" + cms.general.cmsVersion);
        System.out.println("CMS-General:" + cms.general.homepage);
        System.out.println("CMS-General:" + cms.general.homepage_action);

        System.out.println("CMS-Theme:" + cms.theme.bgColor);
        System.out.println("CMS-Theme:" + cms.theme.bgOpaqueness);
        System.out.println("CMS-Theme:" + cms.theme.logoImage);
        System.out.println("CMS-Theme:" + cms.theme.themeName);

        System.out.println("CMS-navigation:" + cms.navigation.get(1).menuId);
        System.out.println("CMS-navigation:" + cms.navigation.get(1).items.get(1).friendlyName);

        return cms;
    }

    public void object2String() {
        CmsContent cms = parseToCmsContentPlus();
        cms.general.cmsVersion = "1.2.3.4";
        System.out.println(cms.toString());
        String json = JSON.toJSONString(cms, true);

    }

    String GetJsonString() {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(cmsJson);
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));
        StringBuilder json = new StringBuilder();
        String s;
        try {
            while ((s = rd.readLine()) != null) {
                json.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
