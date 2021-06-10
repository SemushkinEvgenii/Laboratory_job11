package com.company;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        File file1 = new File("C:\\Users\\79613\\IdeaProjects\\12345\\1.txt");
        File file2 = new File("C:\\Users\\79613\\IdeaProjects\\12345\\2.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
                String s;
                boolean n = false;
                while ((s = reader.readLine()) != null) {
                    Pattern pattern = Pattern.compile("//");
                    Matcher matcher = pattern.matcher(s);
                    StringBuilder strBuilder = new StringBuilder();
                    strBuilder.append(s);
                    if (n){
                        pattern = Pattern.compile("\\*/");
                        matcher = pattern.matcher(s);
                        if (matcher.find()){
                            n = false;
                            strBuilder.delete(0, strBuilder.length());
                        }}
                    if (matcher.find()){
                        strBuilder.delete(matcher.start(), strBuilder.length());
                        if(strBuilder.length() != 0){
                            writer.write(String.valueOf(strBuilder.append("\n")));
                            continue;
                        }
                    } else {
                        pattern = Pattern.compile("/\\*");
                        matcher = pattern.matcher(s);
                        if (matcher.find()){
                            n = true;
                            strBuilder.delete(matcher.start(), strBuilder.length());
                            writer.write(String.valueOf(strBuilder.append("\n")));
                        }}
                    if (!n) {
                        writer.write(String.valueOf(strBuilder.append("\n")));
                    }
                    strBuilder.delete(0, strBuilder.length());
                }}}
        catch (IOException e) {
            e.printStackTrace();
        }}}