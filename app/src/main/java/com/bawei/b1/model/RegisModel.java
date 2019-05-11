package com.bawei.b1.model;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RegisModel implements ModelSI{
    private static final String path="http://172.17.8.100/small/user/v1/register";
    private static final String paths="http://172.17.8.100/small/user/v1/login";
    @Override
    public void FromData(String userName, String pwd, Callback callback) {
           new MyTask(userName,pwd,callback).execute(path,paths);
    }
    class MyTask extends AsyncTask<String,Void,String>{
        private String userName;
        private String pwd;
        private Callback callback;

        public MyTask(String userName, String pwd, Callback callback) {
            this.userName = userName;
            this.pwd = pwd;
            this.callback = callback;
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url=new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                OutputStream outputStream = connection.getOutputStream();
                String paraem="phone="+userName+"&pwd="+pwd;
                outputStream.write(paraem.getBytes());
                outputStream.flush();
                outputStream.close();

                while (connection.getResponseCode()==200){
                    InputStream inputStream = connection.getInputStream();
                    String s = SystemFromData(inputStream);
                    return s;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            callback.getData(s);
        }
    }

    public String SystemFromData(InputStream inputStream) throws IOException {
          int len=-1;
          byte[] bytes=new byte[1024];
          StringBuffer stringBuffer=new StringBuffer();
          while ((len=inputStream.read(bytes))!=-1){
               String s=new String(bytes,0,len);
               stringBuffer.append(s);
          }
          return stringBuffer.toString();
    }


}
