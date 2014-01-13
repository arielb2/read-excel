package com.fuentesjava.pruebas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

public class ProcesarDatosHoja extends ManipularLibros {

    /**
     * 
     * @param strArchivoIn
     * @param intIndice
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws FormatoUsuariosException 
     */
    public List cargarDatos(String strArchivoIn, int intIndice) throws FileNotFoundException,
            IOException, FormatoUsuariosException {


        Iterator<Row> row = tomarRegistros(strArchivoIn, intIndice);

        Usuarios usuarios = null;

        List lista = new ArrayList();

        while (row.hasNext()) {

            Row r = row.next();

            Iterator<Cell> celda = r.cellIterator();

            usuarios = new Usuarios();

            while (celda.hasNext()) {

                Cell cel = celda.next();

                if (cel.getColumnIndex() == 0) {
                    if (cel.getCellType() == 1) {
                        usuarios.setNombre(cel.toString());
                    } else {
                        establecerException(cel);
                    }
                }
                if (cel.getColumnIndex() == 1) {
                    if (cel.getCellType() == 1) {
                        usuarios.setApellido(cel.toString());
                    } else {
                        establecerException(cel);
                    }
                }
                if (cel.getColumnIndex() == 2) {
                    if (cel.getCellType() == 0) {
                        usuarios.setEdad((int) cel.getNumericCellValue());
                    } else {
                        establecerException(cel);
                    }
                }
                if (cel.getColumnIndex() == 3) {
                    if (cel.getCellType() == 0) {

                        double d = HSSFDateUtil.getExcelDate(cel.getDateCellValue());

                        if (DateUtil.isCellDateFormatted(cel)) {
                            Date fecha = HSSFDateUtil.getJavaDate(d);
                            usuarios.setFecha(fecha);
                        } else {
                            establecerException(cel);
                        }
                    } else {
                        establecerException(cel);
                    }
                }
            }
            lista.add(usuarios);
        }
        return lista;
    }

    /**
     * 
     * @param strArchivoIn
     * @param intIndice
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public Iterator<Row> tomarRegistros(String strArchivoIn, int intIndice) throws FileNotFoundException,
            IOException {
        cargarArchivo(strArchivoIn);

        HSSFSheet hoja = obtenerHoja(intIndice);

        Iterator<Row> row = hoja.rowIterator();
        return row;

    }

    public void establecerException(Cell cel) throws FormatoUsuariosException {
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("La columna [").append(cel.getColumnIndex());
        builder.append("] tiene un valor incorrecto [");
        builder.append(cel.toString()).append("]");
        throw new FormatoUsuariosException(builder.toString());
    }
}
