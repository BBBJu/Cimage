package com.example.cimage.Service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.stereotype.Service;

// UserService.java
@Service
public class AddimageService {
    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellValue = cell.getDateCellValue().toString();
                    } else {
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    cellValue = cell.getCellFormula();
                    break;
                default:
                    break;
            }
        }
        return cellValue;
    }
}
