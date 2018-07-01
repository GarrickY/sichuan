package com.ygq.jobs.json;

import io.restassured.path.json.JsonPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Reader {

    private String vantageJson = "data/vantage-cms.json";
    public void readJson(){
        URL vantageJsonUrl = Thread.currentThread().getContextClassLoader().getResource(vantageJson);

        JsonPath p = new JsonPath(vantageJsonUrl);
        HashMap<String,List<HashMap<String,String>>> general = p.get("general");
        HashMap<String,List<HashMap<String,String>>> theme = p.get("theme");
        HashMap<String,List<HashMap<String,ArrayList<HashMap>>>> feature_content = p.get("feature-content");
        ArrayList<HashMap> navigation = p.get("navigation");

        //general segment
        System.out.println("***********");
        System.out.println("general: " + general);
        System.out.println("general-cmsVersion:" + general.get("cmsVersion"));
        System.out.println("general-homepage:" + general.get("homepage"));
        System.out.println("general-appName:" + general.get("appName"));
        System.out.println("general-homepage-action:" + general.get("homepage-action"));

        //theme
        System.out.println("***********");
        System.out.println("theme: " + theme);
        System.out.println("theme-themeName:" + theme.get("themeName"));
        System.out.println("theme-bgColor:" + theme.get("bgColor"));
        System.out.println("theme-logoImage:" + theme.get("logoImage"));
        System.out.println("theme-logoImageSml:" + theme.get("logoImageSml"));
        System.out.println("theme-bgOpaqueness:" + theme.get("bgOpaqueness"));

        //feature_content
        System.out.println("***********");
        System.out.println("feature_content: " + feature_content);
        System.out.println("categories: " + feature_content.get("categories"));
        List<HashMap<String, ArrayList<HashMap>>> categories = feature_content.get("categories");
        for(HashMap<String, ArrayList<HashMap>> category:categories){
            System.out.println("feature-id:" + category.get("feature-id"));
            System.out.println("title:" + category.get("title"));
            System.out.println("template:" + category.get("template"));
            System.out.println("items:" + category.get("items"));
        }

        //navigation
        System.out.println("***********");
        System.out.println("navigation: " + navigation);
        for(HashMap nav:navigation){
            System.out.println("menuId:" + nav.get("menuId"));
            System.out.println("items:" + nav.get("items"));
        }

        System.out.println("good");
    }

    public void printJson(){
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(vantageJson);
        BufferedReader rd=new BufferedReader(new InputStreamReader(in));
        StringBuilder json = new StringBuilder();
        String s;
        try{
            while ((s = rd.readLine()) != null)
            {
                json.append(s);
                System.out.println(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
