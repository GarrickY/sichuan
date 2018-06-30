package com.ygq.jobs.json;

import io.restassured.path.json.JsonPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

public class Reader {

    public void readjson(){
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("data/vantage-cms.json");
        BufferedReader rd=new BufferedReader(new InputStreamReader(in));
        String s;
        try{
            while ((s = rd.readLine()) != null)
            {
                System.out.println(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        JsonPath json = new JsonPath(in);
        System.out.println("good");
    }
}
