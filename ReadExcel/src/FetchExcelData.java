import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
   FileInputStream fileinputstream = new FileInputStream("C:\\Users\\Sai Infotech\\Downloads\\ReadExcelData.xlsx");
		
		Sheet sh =  WorkbookFactory.create(fileinputstream).getSheet("login");
		
		String uname = sh.getRow(1).getCell(1).getStringCellValue();
		
		System.out.println(uname);
		
		for(int i=0; i<sh.getLastRowNum(); i++)
		{
			int lastCellNum = sh.getRow(i).getLastCellNum();

			for(int j=0; j<lastCellNum; j++)
			{
				CellType ctype = sh.getRow(i).getCell(j).getCellType();
				String values = "";
				double intValues = 0;
				if(ctype.toString().equalsIgnoreCase("string"))
					values = sh.getRow(i).getCell(j).getStringCellValue();
				else
					intValues = sh.getRow(i).getCell(j).getNumericCellValue();
				System.out.println(values);
				System.out.println(intValues);
				
				
			}
			
		}
		  
	}

	}