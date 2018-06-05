package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {

        Random random = new Random();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Good day, my name is Eliza. Tell me what is on your mind.");
        System.out.println("Press q at anytime to exist session.");
        while (true) {
            String comment = input.readLine();
            comment = comment.toLowerCase();

            if(comment.equalsIgnoreCase("q")){
                break;
            }
            String replcmnt = new String();
            String[] replacement = comment.split("\\s+");
                HashMap<String, String> rplcmntMap = new HashMap<String, String>();
                rplcmntMap.put("I", "you");
                rplcmntMap.put("my", "your");
                rplcmntMap.put("me", "you");
                rplcmntMap.put("am", "are");
            for (HashMap.Entry<String, String> entry : rplcmntMap.entrySet()) {
                replcmnt = rplcmntMap.get(replacement);
            }
            for (int i = 0; i < replacement.length; i++) {
                replcmnt += replacement[i] + " ";
            }
            //if (rplcmntMap.containsKey(replacement)) {
                //String replced = rplcmntMap.get(replacement);
           // }
           // String replcmnt = new String();
           // for (int i = 0; i < replacement.length; i++) {
              //  replcmnt += replced[i] + " ";
           // }

            String respnse = new String();
            if (random.nextBoolean()) {
            respnse = replyHdg();
            } else {
                respnse = replyQualfr() + " " + replcmnt + ". Please tell me more.";
            }
            System.out.println(respnse);
        }
        input.close();

    }//close method main
    //ArrayList<String> comment = new ArrayList<String>();


    private static String replyQualfr() {
        Random random = new Random();
        ArrayList<String> qualifiers = new ArrayList<String>();
        qualifiers.add("Why do you say that");
        qualifiers.add("You seem to think that");
        qualifiers.add("So, you are concerned that");
        String replyQulfr = qualifiers.get(random.nextInt(qualifiers.size()));
        return replyQulfr;
    }

    private static String replyHdg() {
        Random random = new Random();
        ArrayList<String> hedges = new ArrayList<String>();
        hedges.add("Please tell me more");
        hedges.add("Many of my patients tell me the same thing");
        hedges.add("It is getting late, maybe we had better quit");
        String replyHdg = hedges.get(random.nextInt(hedges.size()));
        return replyHdg;
    }


}

