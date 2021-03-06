package aloha.shiningstarbase.util;

import android.annotation.SuppressLint;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 日志记录类
 * "warning"以上级别的日志会被写入文本文件记录
 * Created by chenmingzhen on 16-5-31.
 */
@SuppressLint("SimpleDateFormat")
public class Logger {
    private static boolean DEBUG_MODE;

    private static String FILE_PATH = "";

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    private static File logFile;

    private static PrintWriter pw = null;

    /**
     * ==>通过左侧菜单栏"build Variants"切换编译模式
     */
    static {
        //DEBUG_MODE = BuildConfig.DEBUG;
    }

    public static void d(String tag, String msg) {
        if (!DEBUG_MODE) {
            return;
        }

        tag = tag != null ? tag : "log 的时候 tag 为空";
        msg = msg != null ? msg : "log 的时候 msg 为空";
        android.util.Log.d(tag, msg);
//		log2File(tag, msg,null);
    }

    public static void i(String tag, String msg) {
        if (!DEBUG_MODE) {
            return;
        }

        tag = tag != null ? tag : "log 的时候 tag 为空";
        msg = msg != null ? msg : "log 的时候 msg 为空";
        android.util.Log.i(tag, msg);
//		log2File(tag, msg,null);
    }

    public static void v(String tag, String msg) {
        if (!DEBUG_MODE) {
            return;
        }

        tag = tag != null ? tag : "log 的时候 tag 为空";
        msg = msg != null ? msg : "log 的时候 msg 为空";
        android.util.Log.v(tag, msg);
//		log2File(tag, msg,null);
    }

    public static void e(String tag, String msg) {
        if (!DEBUG_MODE) {
            return;
        }

        tag = tag != null ? tag : "log 的时候 tag 为空";
        msg = msg != null ? msg : "log 的时候 msg 为空";
        android.util.Log.e(tag, msg);
        log2File(tag, msg,null);
    }

    public static void e(String tag, String msg, Exception e) {
        if (!DEBUG_MODE) {
            return;
        }

        tag = tag != null ? tag : "log 的时候 tag 为空";
        msg = msg != null ? msg : "log 的时候 msg 为空";
        e.printStackTrace();
        android.util.Log.e(tag, msg, e);
        log2File(tag, msg,e);
    }


    public static void w(String tag, String msg) {
        if (!DEBUG_MODE) {
            return;
        }

        tag = tag != null ? tag : "log 的时候 tag 为空";
        msg = msg != null ? msg : "log 的时候 msg 为空";
        android.util.Log.w(tag, msg);
        log2File(tag, msg,null);
    }


    public static void log2File(final String tag, final String msg,final Exception e) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    if(pw == null){
                        if (logFile == null) {
                            File dir = new File(FILE_PATH);
                            if (!dir.exists()) {
                                dir.mkdirs();
                            }
                            logFile = new File(String.format("%s/%s", FILE_PATH,"log.txt"));
                        }
                        pw = new PrintWriter(new FileWriter(logFile,true));
                    }
                    String _text  = String.format("%s : ~ %s $ %s \n",sdf.format(new Date()),tag,msg);
                    pw.println(_text);
                    if(e!=null) e.printStackTrace(pw);
                    pw.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                    if(pw != null){
                        pw.close();
                    }
                    pw = null;
                }
            }
        });
    }


    public static void cleanLog(){
        if(logFile!=null&&logFile.exists()){
            logFile.delete();
        }
    }

    /**
     * 设置日志的保存路径
     * 在Application中初始化
     */
    public static void setLogFilePath(String filePath) {
        FILE_PATH = filePath;
    }

}
