package cl.ufro.dci.ufropharmacy.utils.reportes;

import cl.ufro.dci.ufropharmacy.models.sucursal.BoletaSUC;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BoletaSUCExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<BoletaSUC> listaCompras;

    public BoletaSUCExporter(List<BoletaSUC> listaCompras) {
        this.listaCompras = listaCompras;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Boletas Compras");
        createFirstLine();
        createSecondLine();
    }

    private void createFirstLine() {
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(20);
        style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        createCell(row,0,"Boletas Compras",style);
    }

    private void createSecondLine() {
        Row row = sheet.createRow(1);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.LEFT);

        createCell(row, 0, "ID", style);
        createCell(row, 1, "ID USUARIO", style);
        createCell(row, 2, "NOMBRE USUARIO",style);
        createCell(row, 3, "PRECIO COMPRA", style);
        createCell(row, 4, "FORMA PAGO", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else if (value instanceof String){
            cell.setCellValue((String) value);
        }else if (value instanceof Double){
            cell.setCellValue((Double) value);
        }else if (value instanceof LocalDateTime) {
            LocalDateTime temp = (LocalDateTime) value;
            String fecha = (temp.getDayOfMonth()) + "-";
            fecha += (temp.getMonthValue())+"-";
            fecha += temp.getYear();
            cell.setCellValue(fecha);
        }else if (value instanceof Long){
            cell.setCellValue((Long) value);
        }else if (value instanceof LocalDate){
            LocalDate temp = (LocalDate) value;
            String fecha = (temp.getDayOfMonth()) + "-";
            fecha += (temp.getMonthValue())+"-";
            fecha += temp.getYear();
            cell.setCellValue(fecha);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 2;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.LEFT);



        for (BoletaSUC b: listaCompras) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, b.getId(), style);
            createCell(row, columnCount++, b.getUsuario().getId(), style);
            createCell(row, columnCount++, b.getUsuario().getNombre(),style);
            createCell(row, columnCount++, b.getPrecioTotal(), style);
            createCell(row, columnCount++, b.getTipoPago(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }
}