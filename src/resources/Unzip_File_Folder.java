package resources;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.crypto.Data;
public class Unzip_File_Folder {
    List fileList;
    private static final int BUFFER_SIZE = 4096;

    
    public static ArrayList<String> unzip(String zipFileDestination,String unzipDestination)
    {
    	return unZipIt(zipFileDestination,unzipDestination);
    }
    
    private static ArrayList<String> unZipIt(String zipFile, String outputFolder){
     byte[] buffer = new byte[1024];
 	 ArrayList<String> fileNames = new ArrayList<String>();
 	 fileNames.clear();
     try{
    	//create output directory is not exists
    	File folder = new File(outputFolder);
    	if(!folder.exists()){
    		folder.mkdir();
    	}
    	//get the zip file content
    	ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
    	//get the zipped file list entry
    	ZipEntry ze = zis.getNextEntry();
    	

    	
    	while(ze!=null){
    		
    		String filePath = outputFolder + File.separator + ze.getName();

    		
    		if(!ze.isDirectory())
    		{
        		DataModel.map.clear();
    			DataModel.map.putIfAbsent(ze.getName().split("/")[1], filePath);//something Wrong with the file path
    			fileNames.add(ze.getName().split("/")[1]);
    			
        		System.out.println("Exctract File Path : "+filePath);
        		System.out.println("Extract File Name : "+ze.getName().split("/")[1]);
        		
    			extractFile(zis, filePath);
    			
    		}
    		else
    		{
    			File dir = new File(filePath);
    			dir.mkdir();
    		}
    		
    		zis.closeEntry();
    		ze = zis.getNextEntry();
    	}
        
    	zis.close();
    	return fileNames;
    }catch(IOException ex){
       ex.printStackTrace();
       return fileNames;
    }
   }
    
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}