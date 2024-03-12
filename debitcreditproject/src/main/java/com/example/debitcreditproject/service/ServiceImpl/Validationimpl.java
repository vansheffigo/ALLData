package com.example.debitcreditproject.service.ServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.debitcreditproject.dto.request.GrnRequest;
import com.example.debitcreditproject.dto.request.InvoiceRequest;
import com.example.debitcreditproject.dto.request.MaterialRequest;
import com.example.debitcreditproject.dto.request.PoItemRequest;
import com.example.debitcreditproject.dto.request.PoRequest;
import com.example.debitcreditproject.dto.request.VendorRequest;
import com.example.debitcreditproject.dto.response.GrnResponse;
import com.example.debitcreditproject.dto.response.InvoiceResponse;
import com.example.debitcreditproject.dto.response.MaterialResponse;
import com.example.debitcreditproject.dto.response.PoItemResponse;
import com.example.debitcreditproject.dto.response.PoResponse;
import com.example.debitcreditproject.dto.response.VendorResponse;
import com.example.debitcreditproject.entity.GrnEntity;
import com.example.debitcreditproject.entity.InvoiceEntity;
import com.example.debitcreditproject.entity.MaterialEntity;
import com.example.debitcreditproject.entity.PoEntity;
import com.example.debitcreditproject.entity.VendorEntity;
import com.example.debitcreditproject.repository.GrnRepo;
import com.example.debitcreditproject.repository.InvoiceRepo;
import com.example.debitcreditproject.repository.MaterialRepo;
import com.example.debitcreditproject.repository.PoRepo;
import com.example.debitcreditproject.repository.VendorRepo;
import com.example.debitcreditproject.service.ValidationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Validationimpl implements ValidationService {

	GrnRepo grnRepo;
	InvoiceRepo invoiceRepo;
	MaterialRepo materialRepo;
	PoRepo poRepo;
	VendorRepo vendorRepo;

	public Validationimpl(GrnRepo grnRepo, InvoiceRepo invoiceRepo, MaterialRepo materialRepo, PoRepo poRepo,
			VendorRepo vendorRepo) {
		super();
		this.grnRepo = grnRepo;
		this.invoiceRepo = invoiceRepo;
		this.materialRepo = materialRepo;
		this.poRepo = poRepo;
		this.vendorRepo = vendorRepo;

	}

	public List<?> convertExcelToListOfProduct(InputStream input) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(input);

		return null;
	}

	private String getStringValue(Cell cell) {
		if (cell != null) {
			cell.setCellType(CellType.STRING); // Ensure cell is read as string
			return cell.getStringCellValue();
		}
		return null;
	}

	private Long getNumericValue(Cell cell) {
		if (cell != null) {
			cell.setCellType(CellType.NUMERIC);
			return (long) cell.getNumericCellValue();
		}
		return (long) 0;
	}

	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private void setDateValue(Cell cell, LocalDate localDate) {
		if (cell != null && cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		}
	}

	public ResponseEntity<?> validationFunction(MultipartFile file) {

		try {
			// Validate the file content type
			String contentType = file.getContentType();
			if (!("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(contentType))) {
				System.out.println(contentType);
				return ResponseEntity.badRequest().body("Invalid file format. Please upload an Excel file.");
			}

			// Read Excel file content
			Workbook workbook = WorkbookFactory.create(file.getInputStream());
			Sheet sheet = workbook.getSheetAt(0); // Assuming first sheet
			Iterator<Row> rowIterator = sheet.iterator();

			// Define a list to store extracted data
			List<List<String>> dataList = new ArrayList<>();

			List<String> firstRow = new ArrayList<>();

			VendorEntity vendorEntity = new VendorEntity();
			GrnEntity grnEntity = new GrnEntity();
			InvoiceEntity invoiceEntity = new InvoiceEntity();
			MaterialEntity materialEntity = new MaterialEntity();
			PoEntity poEntity = new PoEntity();
			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				Row rowdata = sheet.getRow(i);

				if (rowdata != null) {
					int index = firstRow.indexOf("grnnumber");
					if (grnRepo.findById(firstRow.get(index)) != null)
						return null;
					else {
//						vendorEntity.setVendorCode(getStringValue(rowdata.getCell(1)));
//						poEntity.setPoNumber(getStringValue(rowdata.getCell(2)));
//						poEntity.setPoItems(getNumericValue(rowdata.getCell(3)));
//						materialEntity.setMaterialCode(getStringValue(rowdata.getCell(4)));
//						invoiceEntity.setInvoiceNumber(getStringValue(rowdata.getCell(5)));
//						invoiceEntity.setInvoiceItems(getNumericValue(rowdata.getCell(6)));
//						setDateValue(rowdata.getCell(7), invoiceEntity.getInvoiceDate());
//						invoiceEntity.setOldRate(getNumericValue(rowdata.getCell(8)));
//						invoiceEntity.setNewRate(getNumericValue(rowdata.getCell(9)));
//						invoiceEntity.setDifference(getNumericValue(rowdata.getCell(10)));
//						invoiceEntity.setTotal(getNumericValue(rowdata.getCell(11)));

					}

				}
			}

			workbook.close();

			return ResponseEntity.ok().body(dataList); // Return extracted data as ResponseEntity
		} catch (IOException | EncryptedDocumentException ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing Excel file.");
		}
	}

	@Override
	public GrnResponse saveGrn(GrnRequest grnRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvoiceResponse saveInvoice(InvoiceRequest inoviceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PoResponse savePo(PoRequest poRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VendorResponse saveVendor(VendorRequest vendorRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaterialResponse saveMaterial(MaterialRequest materialRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PoItemRequest savePoItem(PoItemResponse poItemResponse) {
		// TODO Auto-generated method stub
		return null;
	}

}
