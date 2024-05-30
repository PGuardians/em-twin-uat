package com.filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Data {
	public static void column(String filename) throws IOException {

		File f = new File(filename);

		FileInputStream fis = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fis);

		Sheet sheetAt = w.getSheetAt(0);

		int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();

		for (int i = 0; i < physicalNumberOfRows; i++) {

			Row row = sheetAt.getRow(2);
			Cell cell = row.getCell(i);
			System.out.println(cell);

		}

	}

	public static void particularData(String filename) throws IOException {
		File f = new File(filename);

		FileInputStream fis = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fis);

		Sheet sheetAt = w.getSheetAt(0);

		int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();

		Row row = sheetAt.getRow(2);
		Cell cell = row.getCell(2);
		System.out.println(cell);

	}
}
