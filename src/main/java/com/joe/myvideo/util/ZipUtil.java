package com.joe.myvideo.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.codehaus.plexus.util.IOUtil;

import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;

/**
 * <p>
 * Title: 解压缩文件
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: yourcompany
 * </p>
 * 
 * @author yourcompany
 * @version 1.0
 */
public class ZipUtil {
    

    /**
     * 压缩文件
     * 
     * @param srcfile
     *            File[] 需要压缩的文件列表
     * @param zipfile
     *            File 压缩后的文件
     */
    public static void ZipFiles(String srcfile, String zippath	) {
    	try {
	        File file = new File(srcfile);// 要被压缩的文件夹
	        File zipFile = new File(zippath);
	        InputStream input = null;
	        
	        File parent = new File(zipFile.getParent());
	        if(!parent.exists()){
	        	parent.mkdirs(); 
	        }
	        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
	        if(file.isDirectory()){
	            File[] files = file.listFiles();
	            for(int i = 0; i < files.length; ++i){
	                input = new FileInputStream(files[i]);
	                zipOut.putNextEntry(new ZipEntry(file.getName() + File.separator + files[i].getName()));
	                int temp = 0;
	                while((temp = input.read()) != -1){
	                    zipOut.write(temp);
	                }
	                input.close();
	            }
	        }
	        zipOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    
    public static void main(String[] args) {
    	ZipFiles("C:\\Users\\zhoucijoe\\Desktop\\新建文件夹", "C:\\Users\\zhoucijoe\\Desktop\\6666.zip");
	}
    /**
     * zip解压缩
     * 
     * @param zipfile
     *            File 需要解压缩的文件
     * @param descDir
     *            String 解压后的目标目录
     */
    public static void unZipFiles(java.io.File zipfile, String descDir) {
    	ZipFile zf = null;
    	try {
            zf = new ZipFile(zipfile);
            for (Enumeration<ZipEntry> entries = zf.getEntries(); entries
                    .hasMoreElements();) {
                ZipEntry entry = ((ZipEntry) entries.nextElement());
                String zipEntryName = entry.getName();
                InputStream in = zf.getInputStream(entry);
                File file = new File(descDir,zipEntryName);
                if(!file.exists()){
                	(new File(file.getParent())).mkdirs(); 
                }
                OutputStream out = new FileOutputStream(file);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
                in.close();
                out.close();
                //System.out.println("解压缩完成.");
            }
        } catch (IOException e) {
        	
            throw new RuntimeException("解压失败",e);
        }finally {
        	try {
				zf.close();
			} catch (IOException e) {
				throw new RuntimeException("io流关闭失败");
			}
		}
    }

    

    /** 
    * 根据原始rar路径，解压到指定文件夹下.      
    * @param srcRarPath 原始rar路径 
    * @param dstDirectoryPath 解压到的文件夹      
    */
    public static void unRarFile(String srcRarPath, String dstDirectoryPath) {
        if (!srcRarPath.toLowerCase().endsWith(".rar")) {
            System.out.println("非rar文件！");
            return;
        }
        File dstDiretory = new File(dstDirectoryPath);
        if (!dstDiretory.exists()) {// 目标目录不存在时，创建该文件夹
            dstDiretory.mkdirs();
        }
        Archive a = null;
        try {
            a = new Archive(new File(srcRarPath));
            if (a != null) {
                a.getMainHeader().print(); // 打印文件信息.
                FileHeader fh = a.nextFileHeader();
                while (fh != null) {
                    if (fh.isDirectory()) { // 文件夹 
                        File fol = new File(dstDirectoryPath + File.separator
                                + fh.getFileNameString());
                        fol.mkdirs();
                    } else { // 文件
                        File out = new File(dstDirectoryPath + File.separator
                                + fh.getFileNameString().trim());
                        //System.out.println(out.getAbsolutePath());
                        try {// 之所以这么写try，是因为万一这里面有了异常，不影响继续解压. 
                            if (!out.exists()) {
                                if (!out.getParentFile().exists()) {// 相对路径可能多级，可能需要创建父目录. 
                                    out.getParentFile().mkdirs();
                                }
                                out.createNewFile();
                            }
                            FileOutputStream os = new FileOutputStream(out);
                            a.extractFile(fh, os);
                            os.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    fh = a.nextFileHeader();
                }
                a.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}