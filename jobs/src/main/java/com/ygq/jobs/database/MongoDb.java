package com.ygq.jobs.database;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MongoDb {

    public void connectToDatabase() {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase db = client.getDatabase("sichuan");
        System.out.println("connect db succussfully!");

        //get a collection
        MongoCollection luzhou = db.getCollection("luzhou");
        System.out.println("documents in collection is " + luzhou.countDocuments());

        //create a collection
        //db.createCollection("chengdu");
        MongoCollection chengdu = db.getCollection("chengdu");
        System.out.println("documents in collection is " + chengdu.countDocuments());

        Document document = new Document("name", "huangxiansheng");
        document.append("age", 88);
        document.append("city", "ziyang");
        chengdu.insertOne(document);


        FindIterable<Document> docs = chengdu.find(document);

        MongoCursor<Document> ds = docs.iterator();
        for (Document s : docs) {
            System.out.println(s.containsKey("city"));
            System.out.println(s.toJson());
        }

        chengdu.updateOne(Filters.eq("name", "lixiansheng"), new Document("$set", new Document("age", 150)));
        FindIterable<Document> rlt = chengdu.find(Filters.eq("name", "lixiansheng"));
        rlt.forEach(new Block<Document>() {
            public void apply(Document document) {
                System.out.println(document);
            }
        });
        System.out.println(rlt.first().toJson());

        chengdu.deleteOne(Filters.eq("name", "lixiansheng"));


    }


}
