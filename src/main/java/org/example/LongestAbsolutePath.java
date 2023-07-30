// #17  Problem
package org.example;

import java.io.File;

public class LongestAbsolutePath {
    /* We are interested in finding the longest (number of characters) absolute path to a file within our file system.
    For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext",
    and its length is 32 (not including the double quotes).

    Given a string representing the file system in the above format, return the length of the longest absolute path
     to a file in the abstracted file system. If there is no file in the system, return 0. */

    public static void main(String[] args) {
        String directory = "C:\\Users\\Rafal\\Desktop";
        int result = findPath(new File(directory));
        System.out.println(result);
    }

    static int pathLength = 0;
    static int countDir = 0;
    public static int findPath(File directory){
        if (directory.isDirectory()){
            File[] files = directory.listFiles();
            if (files != null){
                for (File file : files){
                    if (file.isDirectory()){
                        findPath(file);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".exe")) {
                            int count = 0;
                            for (char c : file.getAbsolutePath().toCharArray()){
                                if (c == '\\'){
                                    count++;
                                }
                            }
                            if (count > countDir){
                                countDir = count;
                                pathLength = file.getAbsolutePath().length();
                            }
                        }
                    }
                }
            }
        }
        return pathLength;
    }
}
