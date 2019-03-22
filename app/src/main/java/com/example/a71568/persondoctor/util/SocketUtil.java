package com.example.a71568.persondoctor.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketUtil {//主从 艺术升 70w
    private static Socket masterSocket=new Socket();
    private static Socket slaveSocket=new Socket();
    public void connectMasterServer() {
      /*  if (masterSocket.isConnected()) {
            try {
                masterSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //Socket socket2=new Socket(FinalValue.ipAddress,FinalValue.serverPort);
                    try {
                        masterSocket.connect(new InetSocketAddress(FinalValue.ipAddressMaster, FinalValue.serverPortMaster));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //socket.getOutputStream().write("".getBytes("UTF-8"));
                }
            });
        }


    /**
     * api 文档需要定义
     * @param apiName
     * @param json
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public String sendMessageMaster(final String apiName,final JSONObject json) throws IOException, JSONException {
        if (!masterSocket.isConnected())connectMasterServer();//return null;
        OutputStream out= masterSocket.getOutputStream();
        json.put("apiname",apiName);
        out.write(json.toString().getBytes("UTF-8"));
        out.flush();

        InputStream is=masterSocket.getInputStream();
        InputStreamReader reader=new InputStreamReader(is,"UTF-8");
        BufferedReader bufferedReader=new BufferedReader(reader);
        StringBuffer sbuffer=new StringBuffer();
        String str;
        while ((str=bufferedReader.readLine())!=null){
            sbuffer.append(str);
        }

        return sbuffer.toString();
    }
}
