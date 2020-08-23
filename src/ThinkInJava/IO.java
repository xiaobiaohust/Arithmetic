package ThinkInJava;

import java.io.*;
import java.net.FileNameMap;
import java.util.Arrays;
import java.util.regex.Pattern;

public class IO {
    /**
     * File类
     */

    // 对目录下的文件进行过滤
    public static class  DirFilter implements FilenameFilter {
        private Pattern pattern;
        public DirFilter(String regex){
            pattern = Pattern.compile(regex);
        }
        public boolean accept(File dir,String name){
            return pattern.matcher(name).matches();
        }
    }

    public static void f1(){
        File file  = new File("./src");
        System.out.println(Arrays.toString(file.list()));
        System.out.println(Arrays.toString(file.list(new DirFilter(".*\\.java"))));
        file  = new File("./src/main.java");
    }

    /**
     * 输入输出
     *
     */
    public static void f2() throws IOException{
        BufferedReader in  = new BufferedReader(new FileReader("./src/main.java"));
        String s;
        StringBuffer sb = new StringBuffer();
        while((s=in.readLine())!=null){
            sb.append(s+"\n");
        }
        in.close();
        System.out.println(sb.toString());
    }

    public static void f3() throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("./src/main.java"));
        PrintWriter out  = new PrintWriter(new BufferedWriter(new FileWriter("./src/test.java")));
        String s;
        while((s = in.readLine())!=null){
            out.println(s);
        }
        in.close();
        out.close();
    }


    /**
     * 文本读写TextFile
     *
     */

    public static void main(String[]args)throws IOException{
        f1();
        f2();
        f3();
    }
}
