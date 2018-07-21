package com.ygq.jobs.net;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpOperation {
    public void getRequest() throws IOException {
        HttpGet get = new HttpGet("https://www.baidu.com");
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(get);
        Header[] headers = response.getAllHeaders();
        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity, "utf-8"));
        StatusLine line = response.getStatusLine();
        System.out.println(line.getStatusCode());
    }
}
