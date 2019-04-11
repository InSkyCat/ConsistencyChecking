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
     * ��Office�ĵ�ת��ΪPDF. ���иú�����Ҫ�õ�OpenOffice, OpenOffice���ص�ַΪ  
     * http://www.openoffice.org/  
     * <pre>  
     * ����ʾ��:  
     * String sourcePath = "F:\\office\\source.doc";  
     * String destFile = "F:\\pdf\\dest.pdf";  
     * Converter.office2PDF(sourcePath, destFile);  
     * </pre>  
     * @param sourceFile  
     *            Դ�ļ�, ����·��. ������Office2003-2007ȫ����ʽ���ĵ�, Office2010��û����. ����.doc,  
     *            .docx, .xls, .xlsx, .ppt, .pptx��. ʾ��: F:\\office\\source.doc  
     * @param destFile  
     *            Ŀ���ļ�. ����·��. ʾ��: F:\\pdf\\dest.pdf  
     * @return �����ɹ�������ʾ��Ϣ. ������� -1, ��ʾ�Ҳ���Դ�ļ�, ��url.properties���ô���; ������� 0,  
     *         ���ʾ�����ɹ�; ����1, ���ʾת��ʧ��  
     */    
    public static int office2PDF(String sourceFile, String destFile) throws FileNotFoundException {    
        try {    
            File inputFile = new File(sourceFile);    
            if (!inputFile.exists()) {    
                return -1;// �Ҳ���Դ�ļ�, �򷵻�-1    
            }    
    
            // ���Ŀ��·��������, ���½���·��    
            File outputFile = new File(destFile);    
            if (!outputFile.getParentFile().exists()) {    
                outputFile.getParentFile().mkdirs();    
            }    
            /**
             * ��������ˡ�Զ�̷���������ʱ��host=��ʵ�Ķ���IP������д127.0.0.1�� ����Զ�̴��䡣converterӦ���ã�DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);     
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