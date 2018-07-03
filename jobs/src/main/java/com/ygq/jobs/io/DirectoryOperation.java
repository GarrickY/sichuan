package com.ygq.jobs.io;

import java.io.File;

public class DirectoryOperation {
    private String currentDir = Class.class.getClass().getResource("/").getPath();

    public void dirOperation(){
        File path = new File(currentDir +"folder1");
        System.out.println("folder1 exist:" + path.exists());
        path.mkdir();
        System.out.println("folder1 exist:" + path.exists());
        path.delete();
        System.out.println("folder1 exist:" + path.exists());

        File path2 = new File(currentDir +"folder2/folder21");
        System.out.println("folder2 exist:" + path2.exists());
        path2.mkdir();
        System.out.println("folder2 exist:" + path2.exists());
        path2.mkdirs();
        System.out.println("folder2 exist:" + path2.exists());
        path2.delete();
        System.out.println("folder2 exist:" + path2.exists());

        File path3 = new File(currentDir+"folder3/folder4");
        path3.mkdirs();
        System.out.println("folder3 exist:" + path3.exists());
        path3.getParentFile().delete();
        System.out.println("folder3 exist:" + path3.exists());
    }
}
