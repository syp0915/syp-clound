package com.shfc.cloud.video.ffmpeg;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @Package com.demo.dubbo.ffmpeg.ConvertSingleVideo
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/3/14 14:29
 * version V1.0.0
 */
public class ConvertSingleVideo {
    private static String mencoder_home = "";//mencoder.exe所放的路径 D:\mencoder\mencoder.exe
    private static String ffmpeg_home = "";//ffmpeg.exe所放的路径 D:\ffmpeg\bin\ffmpeg.exe

    private String tempFile_home;//存放rm,rmvb等无法使用ffmpeg直接转换为flv文件先转成的avi文件

    public static void main(String[] args) {
        ConvertSingleVideo convertSingleVideo = new ConvertSingleVideo("D:\\upload\\rmvb\\111.avi");
        convertSingleVideo.convert("D:\\upload\\rmvb\\111.rmvb");

    }

    public ConvertSingleVideo(String tempFilePath){
        this.tempFile_home = tempFilePath;
    }

    /**
     *  功能函数
     * @param inputFile 待处理视频，需带路径
     * @return
     */
    public  boolean convert(String inputFile)
    {
        if (!checkfile(inputFile)) {
            System.out.println(inputFile + " is not file");
            return false;
        }
        if (process(inputFile,tempFile_home)) {
            System.out.println("ok");
            return true;
        }
        return false;
    }
    //检查文件是否存在
    private  boolean checkfile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return false;
        }
        return true;
    }
    /**
     * 转换过程 ：先检查文件类型，在决定调用 processFlv还是processAVI
     * @param inputFile
     * @param outputFile
     * @return
     */
    private  boolean process(String inputFile,String outputFile) {
        int type = checkContentType( inputFile);
        boolean status = false;
        if (type == 0) {
            status = processAVI(inputFile,outputFile);// 直接将文件转为flv文件
        } else if (type == 1) {
            String avifilepath = processAVI(type,inputFile);
            if (avifilepath == null)
                return true;
//            if (avifilepath == null)
//                return false;// avi文件没有得到
            //status = processFLV(avifilepath,outputFile);// 将avi转为flv
        }
        return status;
    }
    /**
     * 检查视频类型
     * @param inputFile
     * @return ffmpeg 能解析返回0，不能解析返回1
     */
    private  int checkContentType(String inputFile) {
        String type = inputFile.substring(inputFile.lastIndexOf(".") + 1,inputFile.length()).toLowerCase();
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
        if (type.equals("avi")) {
            return 0;
        } else if (type.equals("mpg")) {
            return 0;
        } else if (type.equals("wmv")) {
            return 0;
        } else if (type.equals("3gp")) {
            return 0;
        } else if (type.equals("mov")) {
            return 0;
        } else if (type.equals("mp4")) {
            return 0;
        } else if (type.equals("asf")) {
            return 0;
        } else if (type.equals("asx")) {
            return 0;
        } else if (type.equals("flv")) {
            return 0;
        }
        // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
        // 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
        else if (type.equals("wmv9")) {
            return 1;
        } else if (type.equals("rm")) {
            return 1;
        } else if (type.equals("rmvb")) {
            return 1;
        }
        return 9;
    }
    /**
     *  ffmepg: 能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
     * @param inputFile
     * @param outputFile
     * @return
     */
    private  boolean processAVI(String inputFile,String outputFile) {
        if (!checkfile(inputFile)) {
            System.out.println(inputFile + " is not file");
            return false;
        }
        File file = new File(outputFile);
        System.out.println(outputFile);
        if(file.exists()){
            System.out.println("flv文件已经存在！无需转换");
            return true;
        } else {
            System.out.println("正在转换成flv文件……");

            List<String> commend = new java.util.ArrayList<String>();
            //低精度
            commend.add(ffmpeg_home);
            commend.add("-i");
            commend.add(inputFile);
            commend.add("-ab");
            commend.add("128");
            commend.add("-acodec");
            commend.add("libmp3lame");
            commend.add("-ac");
            commend.add("1");
            commend.add("-ar");
            commend.add("22050");
            commend.add("-r");
            commend.add("29.97");
            // 清晰度 -qscale 4 为最好但文件大, -qscale 6就可以了
            commend.add("-qscale");
            commend.add("4");
            commend.add("-y");
            commend.add(outputFile);
            StringBuffer test=new StringBuffer();
            for(int i=0;i<commend.size();i++)
                test.append(commend.get(i)+" ");
            System.out.println(test);
            try {
                ProcessBuilder builder = new ProcessBuilder();
                builder.command(commend);
                builder.start();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        }

    }
    /**
     * Mencoder:
     * 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
     * @param type
     * @param inputFile
     * @return
     */
    private  String processAVI(int type,String inputFile) {
        File file =new File(tempFile_home);
        System.out.println(tempFile_home+file.exists());
        if(file.exists()){
            System.out.println("avi文件已经存在！无需转换");
            return tempFile_home;
        }
        List<String> commend = new java.util.ArrayList<String>();
        commend.add(mencoder_home);
        commend.add(inputFile);
        commend.add("-oac");
        commend.add("mp3lame");
        commend.add("-lameopts");
        commend.add("preset=64");
        commend.add("-ovc");
        commend.add("xvid");
        commend.add("-xvidencopts");
        commend.add("bitrate=600");
        commend.add("-of");
        commend.add("avi");
        commend.add("-o");
        commend.add(tempFile_home);
        StringBuffer test=new StringBuffer();
        for(int i=0;i<commend.size();i++)
            test.append(commend.get(i)+" ");
        System.out.println(test);
        try
        {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            Process p=builder.start();
            /**
             * 清空Mencoder进程 的输出流和错误流
             * 因为有些本机平台仅针对标准输入和输出流提供有限的缓冲区大小，
             * 如果读写子进程的输出流或输入流迅速出现失败，则可能导致子进程阻塞，甚至产生死锁。
             */
            final InputStream is1 = p.getInputStream();
            final InputStream is2 = p.getErrorStream();
            new Thread() {
                public void run() {
                    BufferedReader br = new BufferedReader(new InputStreamReader(is1));
                    try {
                        String lineB = null;
                        while ((lineB = br.readLine()) != null ){
                            if(lineB != null)System.out.println(lineB);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            new Thread() {
                public void run() {
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
                    try {
                        String lineC = null;
                        while ( (lineC = br2.readLine()) != null){
                            if(lineC != null)System.out.println(lineC);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

            //等Mencoder进程转换结束，再调用ffmpeg进程
            p.waitFor();
            System.out.println("who cares");
            return tempFile_home;
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static boolean  downLoadFromUrl(String urlStr,String fileName,String savePath){
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(3*1000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            //得到输入流
            InputStream inputStream = conn.getInputStream();
            //获取自己数组
            byte[] getData = readInputStream(inputStream);

            //文件保存位置
            File saveDir = new File(savePath);
            if(!saveDir.exists()){
                saveDir.mkdir();
            }
            File file = new File(saveDir+File.separator+fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if(fos!=null){
                fos.close();
            }
            if(inputStream!=null){
                inputStream.close();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
