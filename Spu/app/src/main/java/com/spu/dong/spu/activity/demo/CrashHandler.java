package com.spu.dong.spu.activity.demo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

   public class CrashHandler implements Thread.UncaughtExceptionHandler {
        private static final String LOGTAG = "SimpleUncaughtExceptionHandler";
        public  CrashHandler(Context t){
            this.t = t;
        }
        private Context t;
        @Override
        public void uncaughtException(Thread thread, Throwable throwable) {
            //读取stacktrace信息
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            throwable.printStackTrace(printWriter);
            String errorReport = result.toString();
            Toast.makeText(t, errorReport, Toast.LENGTH_LONG).show();
        }
    }

