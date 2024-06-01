package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.testng.annotations.DataProvider;

public class Gettestdata {

	
	
	//public static void main (String[] args) throws EncryptedDocumentException, IOException {
		//Gettestdata read = new Gettestdata();
		//read.getData("InputSSS_message");
		
	//}
	@DataProvider(name="inputSSSno")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException, InterruptedException
	{
	
		String excelSheetName = m.getName();
		File f = new File("C:\\Users\\jvk5400\\eclipse-workspace\\New Work\\HR_WorkForce\\src\\test\\resources\\testdata\\testData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalCol = rowCells.getLastCellNum();
		System.out.println(totalCol);
		
		DataFormatter format = new DataFormatter();
		
		String testData[][] = new String [totalRows][totalCol];
		for(int i=1; i <=totalRows; i++) {
			for(int j=0; j<totalCol; j++) {
				testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
		
				System.out.println(testData[i-1][j]);
				
		 
			
	}
}
		return testData;
	}

}

		
