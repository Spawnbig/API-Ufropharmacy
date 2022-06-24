package cl.ufro.dci.ufropharmacy.utils.reportes;

import cl.ufro.dci.ufropharmacy.models.casamatriz.DespachoSucursalCM;
import cl.ufro.dci.ufropharmacy.models.casamatriz.ESTADO_DESPACHO;
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
import java.util.Date;
import java.util.List;

public class DespachoExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<DespachoSucursalCM> listaDespacho;

    public DespachoExporter(List<DespachoSucursalCM> listaDespacho) {
        this.listaDespacho = listaDespacho;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Despachos");
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
        createCell(row,0,"Despachos",style);
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
        createCell(row, 1, "FECHA HORA DESPACHO", style);
        createCell(row, 2, "FECHA HORA LLEGADA", style);
        createCell(row, 3, "FECHA ESTIMADA ENT.", style);
        createCell(row,4,"ESTADO",style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            if ((Boolean) value){
                cell.setCellValue((String) "SI" );
            }else{
                cell.setCellValue((String) "NO" );
            }
        }else if (value instanceof String){
            cell.setCellValue((String) value);
        }else if (value instanceof Double){
            cell.setCellValue((Double) value);
        }else if (value instanceof ESTADO_DESPACHO){
            String str = ((ESTADO_DESPACHO) value).toString();
            cell.setCellValue(str);
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
        }else if (value instanceof Date){
            Date temp = (Date) value;
            String fecha = temp.getDate() + "-"+temp.getMonth() + "-" + temp.getYear();
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



        for (DespachoSucursalCM d : listaDespacho) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, d.getId(), style);
            createCell(row, columnCount++, d.getFechaHoraDespacho(), style);
            createCell(row, columnCount++, d.getFechaHoraLlegada(), style);
            createCell(row, columnCount++, d.getFechaEstimadaEntrega(), style);
            createCell(row, columnCount++, d.getEstadoDespacho(), style);
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
