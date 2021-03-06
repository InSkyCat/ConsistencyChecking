package ttt;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.ConnectException;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;

public class openofficeDemo {

	/**  
     * 将Office文档转换为PDF. 运行该函数需要用到OpenOffice, OpenOffice下载地址为  
     * http://www.openoffice.org/  
     * <pre>  
     * 方法示例:  
     * String sourcePath = "F:\\office\\source.doc";  
     * String destFile = "F:\\pdf\\dest.pdf";  
     * Converter.office2PDF(sourcePath, destFile);  
     * </pre>  
     * @param sourceFile  
     *            源文件, 绝对路径. 可以是Office2003-2007全部格式的文档, Office2010的没测试. 包括.doc,  
     *            .docx, .xls, .xlsx, .ppt, .pptx等. 示例: F:\\office\\source.doc  
     * @param destFile  
     *            目标文件. 绝对路径. 示例: F:\\pdf\\dest.pdf  
     * @return 操作成功与否的提示信息. 如果返回 -1, 表示找不到源文件, 或url.properties配置错误; 如果返回 0,  
     *         则表示操作成功; 返回1, 则表示转换失败  
     */    
    public static int office2PDF(String sourceFile, String destFile) throws FileNotFoundException {    
        try {    
            File inputFile = new File(sourceFile);    
            if (!inputFile.exists()) {    
                return -1;// 找不到源文件, 则返回-1    
            }    
    
            // 如果目标路径不存在, 则新建该路径    
            File outputFile = new File(destFile);    
            if (!outputFile.getParentFile().exists()) {    
                outputFile.getParentFile().mkdirs();    
            }    
            /**
             * 无意间解决了。远程服务启动的时候，host=真实的对外IP，不能写127.0.0.1。 还有远程传输。converter应该用：DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);     
             */
            // connect to an OpenOffice.org instance running on port 8100    
            OpenOfficeConnection connection = new SocketOpenOfficeConnection(    
                    "192.168.206.47", 8100);    
            connection.connect();    
    
            // convert    
//            DocumentConverter converter = new OpenOfficeDocumentConverter(  connection);    
            DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
            
            converter.convert(inputFile, outputFile);    
    
            // close the connection    
            connection.disconnect();    
    
            return 0;    
        } catch (ConnectException e) {    
            e.printStackTrace();    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
        return 1;    
    }   
	 
	
}