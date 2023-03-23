package com.example.webServicesapp6fileupload;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FileUploadController {
	
	// Image File Upload
	@RequestMapping(path = "upload1", method = RequestMethod.POST)
	public String upload1(@RequestParam MultipartFile myFile) throws Exception{
		byte[] bytes = myFile.getBytes();
		FileOutputStream fout = new FileOutputStream("test1.png");
		fout.write(bytes);
		return "File Upload success. Check in your project by refreshing";   // IN arc or postman we have select multipart/form-data under body section
	}
	
	// Diff File upload
	@RequestMapping(path="upload2", method=RequestMethod.POST)
	public String upload2(@RequestParam MultipartFile file) throws Exception{
		FileOutputStream fout = new FileOutputStream("test2.txt");
		fout.write(file.getBytes());
		return "file uploaded successfully";		
	}
	
	// UPloading at specific location(resource folder)
	@RequestMapping(path = "upload3", method=RequestMethod.POST)
	public String upload3(@RequestParam MultipartFile myFile) throws Exception {
		FileOutputStream fout = 
				new FileOutputStream("src\\main\\resources\\uploads\\Test.java");  // upload file in resource --> uploads folder 
		fout.write(myFile.getBytes());
		return "file upload success";
	}
	
	// original file name
	@RequestMapping(path = "upload4", method=RequestMethod.POST)
	public String upload4(@RequestParam MultipartFile myFile) throws Exception {
		String originalFileName = myFile.getOriginalFilename();
		FileOutputStream fout = 
				new FileOutputStream("src\\main\\resources\\uploads\\" + originalFileName);
		fout.write(myFile.getBytes());
		return originalFileName + " uploaded successfully";
	}
	
	@RequestMapping(path = "upload5", method=RequestMethod.POST)
	public String upload5(@RequestParam MultipartFile myFile) throws Exception {
		String originalFileName = myFile.getOriginalFilename();
		String fileName = "hello";
		String fileType = originalFileName.substring(originalFileName.indexOf("."));
		FileOutputStream fout = 
				new FileOutputStream("src\\main\\resources\\uploads\\" + fileName + fileType);
		fout.write(myFile.getBytes());
		return fileName + fileType + " uploaded successfully";
	}
	
	// Dynamic file name   
	int counter = 0;	
	synchronized int getCounter() {
		counter ++;
		return counter;
	}	
	@RequestMapping(path = "upload6", method=RequestMethod.POST)
	public String upload6(@RequestParam MultipartFile myFile) throws Exception {
		String originalFileName = myFile.getOriginalFilename();
		String fileName = "hello" + getCounter();
		String fileType = originalFileName.substring(originalFileName.indexOf("."));
		FileOutputStream fout = 
				new FileOutputStream("src\\main\\resources\\uploads\\" + fileName + fileType);
		fout.write(myFile.getBytes());
		return originalFileName + " uploaded as " + fileName + fileType + " successfully";
	}

	// File upload with JSON object
	// We have to import object mapper in order to map json object into specified object like employee object
	@RequestMapping(path="upload7", method=RequestMethod.POST)
	public String upload7(@RequestParam MultipartFile myFile, 
						  @RequestParam String jsonObject) throws Exception{
		String originalFileName = myFile.getOriginalFilename();
		String fileType = originalFileName.substring(originalFileName.indexOf("."));
		FileOutputStream fout = 
				new FileOutputStream("src\\main\\resources\\uploads\\new_file" + fileType);
		fout.write(myFile.getBytes());
		Employee emp = new ObjectMapper().readValue(jsonObject, Employee.class); // JSON object mapped into Employee Object
		System.out.println(emp.getId());
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
		return "success";
	}
	
	
	// Multiple Files and Multiple JSON objects
	@RequestMapping(path="upload8", method=RequestMethod.POST)
	public String upload8(@RequestParam MultipartFile file1, 
						  @RequestParam MultipartFile file2,
						  @RequestParam String jsonEmpObject,
						  @RequestParam String jsonAddressObject) throws Exception{
		String file1Name = file1.getOriginalFilename();
		String file2Name = file2.getOriginalFilename();
		String file1Type = file1Name.substring(file1Name.indexOf("."));
		String file2Type = file2Name.substring(file2Name.indexOf("."));		
		FileOutputStream fout1 = 
				new FileOutputStream("src\\main\\resources\\uploads\\new_file1" + file1Type);
		FileOutputStream fout2 = 
				new FileOutputStream("src\\main\\resources\\uploads\\new_file2" + file2Type);		
		fout1.write(file1.getBytes());
		fout2.write(file2.getBytes());
		Employee emp = new ObjectMapper().readValue(jsonEmpObject, Employee.class);
		System.out.println(emp.getId());
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
		Address address = new ObjectMapper().readValue(jsonAddressObject, Address.class);
		System.out.println(address.getHouseNo());
		System.out.println(address.getStreetName());
		return "success";
	}
	
	// Excel File upload and processing with poi
	@RequestMapping(path = "upload9", method=RequestMethod.POST)
	public String upload9(@RequestParam MultipartFile myFile) throws Exception {
		String originalFileName = myFile.getOriginalFilename();
		String fileName = "data";
		String fileType = originalFileName.substring(originalFileName.indexOf("."));
		FileOutputStream fout = 
				new FileOutputStream("src\\main\\resources\\uploads\\" + fileName + fileType);
		fout.write(myFile.getBytes());
		
		/* Reading from excel sheet by using POI library */
		
		XSSFWorkbook workbook = 
				new XSSFWorkbook("src\\main\\resources\\uploads\\" + fileName + fileType);
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    XSSFRow row;
	    for(int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {	   
	    	row = worksheet.getRow(i);
	    	System.out.print(row.getCell(0).getNumericCellValue() + "\t");
	    	System.out.print(row.getCell(1).getStringCellValue() + "\t");
	    	System.out.print(row.getCell(2).getNumericCellValue() + "\t");
	    	System.out.println(row.getCell(3).getStringCellValue());
	    }
	    
	    
		return originalFileName + " uploaded as " + fileName + fileType + " successfully";
	}
	
	
	
}


