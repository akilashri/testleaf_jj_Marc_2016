package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileExistsException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Wrapper_Xl {
	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	
	/*XLS Wrapper classes*/
	
	//Method to Open a work book
	public void openWorkbook(String FilePath,String sheetName){
		 		
		try {
			FileInputStream fs = new FileInputStream(new File(FilePath));
			workbook = new XSSFWorkbook(fs);
			sheet = workbook.getSheet(sheetName);
			System.out.println(sheetName);
		}
		catch(FileNotFoundException e){
			System.out.println("File is not found in the path"+FilePath);
		}
		
		 catch (IOException e) {
			//No workbook is present in that name
			 System.out.println("The specified XL does not contain sheet"+sheetName);
			
		}
		
}
	
	//Method to get the Row count
	public int getRowNumber(){
		
		return sheet.getLastRowNum();		
				
	}
	
	//Method to get the Cell Value of the Row and Column
	public String getCellValue(int row,int colNum){
		
		return sheet.getRow(row).getCell(colNum).getStringCellValue();
		
	}
	
	//Create a New Workbook before writing data to it
	public void createSheet(String sheetName){
		
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet(sheetName);
		
		
	}
	
	public void createRow(int rowNo) {
		row = sheet.createRow(rowNo);
	}

	//Method to Write the Data to the cell
	public void writeData(int rowNum,int cellNo,String data){
		
		sheet.getRow(rowNum).createCell(cellNo).setCellValue(data);

	}
	
	//Method to write a file
	public void writeToFile(String fileName){
			try {
				
			FileOutputStream fs= new FileOutputStream(new File(fileName));
			System.out.println("Workbook created");		
			
				workbook.write(fs);
				workbook.close();
				fs.close();
				
			}catch (IOException e) {
			
				System.out.println();
			}
			
		}
			

	
	//Method to Close the work book
	public void closeWorkBook(){
		
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot Close WorkBook");
		}
		
	}
	
}
