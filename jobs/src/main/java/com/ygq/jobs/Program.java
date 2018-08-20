package com.ygq.jobs;


import com.ygq.jobs.algorithm.TranslationInEnglish;

public class Program {
    public static void main(String[] para) {

        try {
            TranslationInEnglish translationInEnglish = new TranslationInEnglish();
            translationInEnglish.translate(0);
            translationInEnglish.translate(20);
            translationInEnglish.translate(101);
            translationInEnglish.translate(10304);
            translationInEnglish.translate(1237123456789012345L);
            translationInEnglish.translate(1000000001);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("End");
    }
}
