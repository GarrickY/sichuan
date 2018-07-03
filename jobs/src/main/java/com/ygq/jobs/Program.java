package com.ygq.jobs;


import com.ygq.jobs.io.DirectoryOperation;
import com.ygq.jobs.io.ReadFiles;
import com.ygq.jobs.io.WriteFiles;
import com.ygq.jobs.json.Json2Object;
import com.ygq.jobs.json.WriterJson;

public class Program {
    public static void main(String[] para) {

        DirectoryOperation d = new DirectoryOperation();
        d.dirOperation();
        System.out.println("End");
    }
}
