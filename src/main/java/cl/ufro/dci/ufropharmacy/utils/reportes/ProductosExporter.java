package cl.ufro.dci.ufropharmacy.utils.reportes;

import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoSUC;
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

public class ProductosExporter {
        private XSSFWorkbook workbook;
        private XSSFSheet sheet;
        private List<ProductoSUC> listaProductos;

        public ProductosExporter(List<ProductoSUC> listaProductos) {
            this.listaProductos = listaProductos;
            workbook = new XSSFWorkbook();
        }


        private void writeHeaderLine() {
            sheet = workbook.createSheet("Productos");
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
            sheet.addMergedRegion(new CellRangeAddress(0,0,0,10));
            style.setFont(font);
            style.setAlignment(HorizontalAlignment.CENTER);
            createCell(row,0,"Productos",style);
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
            createCell(row, 1, "MARCA", style);
            createCell(row, 2, "CATEGORIA", style);
            createCell(row, 3, "PRECIO", style);
            createCell(row,4,"CANTIDAD",style);
            createCell(row,5,"NOMBRE PRODUCTO",style);
            createCell(row,6,"RAZON SOCIAL TIT.",style);
            createCell(row,7,"COND. VENTA",style);
            createCell(row,8,"DESCRIPCION",style);
            createCell(row,9,"DESCUENTO",style);
            createCell(row,10,"FECHA TECNICA",style);

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



            for (ProductoSUC p : listaProductos) {
                Row row = sheet.createRow(rowCount++);
                int columnCount = 0;

                createCell(row, columnCount++, p.getId(), style);
                createCell(row, columnCount++, p.getMarca(), style);
                createCell(row, columnCount++, p.getCategoria(), style);
                createCell(row, columnCount++, p.getPrecio(), style);
                createCell(row, columnCount++, p.getCantidad(), style);
                createCell(row, columnCount++, p.getNombre_producto(), style);
                createCell(row, columnCount++, p.getRazon_social_titular(), style);
                createCell(row, columnCount++, p.getCondicion_de_venta(), style);
                createCell(row, columnCount++, p.getDescirpcion(), style);
                createCell(row, columnCount++, p.getDescuento(), style);
                createCell(row, columnCount++, p.getFechaTecnica(), style);
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
