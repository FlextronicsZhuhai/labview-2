package com.joe.myvideo.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 对多个文件压缩和解压缩  
 * 
 * 
 */
public class ZipUtil {
	//private int k = 1;
	
	/**
	 * 压缩文件
	 * @param zipFileName
	 * @param inputFile
	 * @throws Exception
	 */
	public static void compress( File inputFile ,String outputZipFileName) throws Exception {
        //System.out.println("压缩中...");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outputZipFileName));
        BufferedOutputStream bo = new BufferedOutputStream(out);
        zip(out, inputFile, inputFile.getName(), bo);
        bo.close();
        out.close(); // 输出流关闭
        //System.out.println("压缩完成");
    }  
	
	private static void zip(ZipOutputStream out, File f, String base,BufferedOutputStream bo) throws Exception { // 方法重载
		String separator = File.separator;
        if (f.isDirectory()){
            File[] fl = f.listFiles(); 
            if (fl.length == 0){
            	out.putNextEntry(new ZipEntry(base + separator)); // 创建zip压缩进入点base
                System.out.println(base + separator);
            }            for (int i = 0; i < fl.length; i++) {
                zip(out, fl[i], base + separator + fl[i].getName(), bo); // 递归遍历子文件夹
            }
            //System.out.println("第" + k + "次递归");
            //k++;
        } else {            
        	out.putNextEntry(new ZipEntry(base)); // 创建zip压缩进入点base
            System.out.println(base);
            FileInputStream in = new FileInputStream(f);
            BufferedInputStream bi = new BufferedInputStream(in);
            int b;
            while ((b = bi.read()) != -1) {
                bo.write(b); // 将字节流写入当前zip目录
            }
            bi.close();
            in.close(); // 输入流关闭
        }
    }
	
	/**
	 * 解压缩
	 * @param inputZipFileName
	 * @param outputDir
	 * @throws Exception
	 */
	public static void unCompress(String inputZipFileName, String outputDir) throws Exception {
        //long startTime=System.currentTimeMillis();  
        try {  
            ZipInputStream Zin=new ZipInputStream(new FileInputStream(  
            		inputZipFileName));//输入源zip路径  
            BufferedInputStream Bin=new BufferedInputStream(Zin);  
            File Fout=null;  
            ZipEntry entry;  
            try {  
                while((entry = Zin.getNextEntry())!=null && !entry.isDirectory()){  
                    Fout=new File(outputDir,entry.getName());  
                    if(!Fout.exists()){  
                        (new File(Fout.getParent())).mkdirs();  
                    }  
                    FileOutputStream out=new FileOutputStream(Fout);  
                    BufferedOutputStream Bout=new BufferedOutputStream(out);  
                    int b;  
                    while((b=Bin.read())!=-1){  
                        Bout.write(b);  
                    }  
                    Bout.close();  
                    out.close();  
                    //System.out.println(Fout+"解压成功");      
                }  
                Bin.close();  
                Zin.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        }  
        //long endTime=System.currentTimeMillis();  
        //System.out.println("耗费时间： "+(endTime-startTime)+" ms");  
    }
	
//	/**
//     * 测试
//     * @param args
//     */
//    public static void main(String[] args) {
//    	ZipUtil book = new ZipUtil();        try {
//            //book.compress(new File("F:pcdlc"),"F:pcdlc.zip");
//    		//book.unCompress("F:pcdlc.zip", "D:1");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
