/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ventanas.Capturista;

/**
 *
 * @author Javier
 */
public class ImpresionPdf {

    java.util.Date date = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
    String fecha = sdf.format(date);

    public void ReporteJuguetes() {

        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Juguetes.pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/header.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informe creado para Adriana Morin © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Juguetes registrados \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(7);
            tabla.setWidths(new int[]{20, 80, 60, 60, 60, 60, 60});
            tabla.setWidthPercentage(100f);
            tabla.addCell("ID");
            tabla.addCell("Nombre Juguete");
            tabla.addCell("Precio");
            tabla.addCell("Tipo de juguete");
            tabla.addCell("Costo de fabricacion");
            tabla.addCell("Proveedor");
            tabla.addCell("Stock");

            try {
                Connection cn2 = Conexion.conectar();;
                PreparedStatement pst = cn2.prepareStatement("select id_juguetes, nombre, Precio, Tipo, Costo, "
                        + "proveedor.nombre_prov, Stock from juguetes, proveedor WHERE juguetes.Proveedor = proveedor.id_proveedor");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error en la imagen " + e);
        }

    }

    public void ReporteJardines() {

        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Jardines " + fecha + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/header.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informe creado para Adriana Morin © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Jardines registrados \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidths(new int[]{20, 80, 100, 100, 100});
            tabla.setWidthPercentage(100f);
            tabla.addCell("ID");
            tabla.addCell("Jardin");
            tabla.addCell("Direccion");
            tabla.addCell("Contacto");
            tabla.addCell("Telefono");

            try {
                Connection cn2 = Conexion.conectar();;
                PreparedStatement pst = cn2.prepareStatement("select * from jardines");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error en la imagen " + e);
        }

    }

    public void ReporteProveedores() {

        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_proveedores.pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/header.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informe creado para Adriana Morin © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Proveedores registrados \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(6);
            PdfPCell celda1 = new PdfPCell(new Paragraph("ID"));
            tabla.setWidths(new int[]{20, 80, 100, 100, 100, 120});
            tabla.setWidthPercentage(100f);

            tabla.addCell(celda1);
            tabla.addCell("Nombre");
            tabla.addCell("Contacto");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");
            tabla.addCell("Comentarios");

            try {
                Connection cn2 = Conexion.conectar();
                PreparedStatement pst = cn2.prepareStatement("select * from proveedor");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error en la imagen " + e);
        }
    }

    public void ReporteVentas() {

        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");

            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Ventas.pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/header.png");
            header.scaleToFit(550, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informe creado para Adriana Morin © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Ventas Registradas \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(6);
            tabla.setWidths(new int[]{15, 80, 80, 65, 80, 65});
            tabla.setWidthPercentage(100f);
            tabla.addCell("ID");
            tabla.addCell("Juguete comprado");
            tabla.addCell("Jardin");
            tabla.addCell("Fecha");
            tabla.addCell("Factura nro");
            tabla.addCell("Cuotas");

            try {
                Connection cn2 = Conexion.conectar();
                PreparedStatement pst = cn2.prepareStatement("select id_ventas, juguetes.nombre, jardines.Jardin, fecha, FacturaNro, cuotas from ventas, juguetes, jardines "
                        + "WHERE ventas.juguete_id = juguetes.id_juguetes && ventas.jardin_id = jardines.id_jardines");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));

                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error en la imagen " + e);
        }
    }

    public void ReporteVenJar(int compjard) {

        Capturista ob = new Capturista();
        // int compjard = ob.cmb();

        Document documento = new Document();

        try {

            String ruta = System.getProperty("user.home");

            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Compras " + compjard + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/header.png");
            header.scaleToFit(550, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informe creado para Adriana Morin © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Ventas Registradas para el Jardin  \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Nro Venta");
            tabla.addCell("Juguete comprado");
            tabla.addCell("Jardin");
            tabla.addCell("Fecha");
            tabla.addCell("Factura nro");

            try {
                Connection cn2 = Conexion.conectar();
                PreparedStatement pst = cn2.prepareStatement("select id_ventas, juguetes.nombre, jardines.Jardin, fecha, FacturaNro from ventas, juguetes, jardines "
                        + "WHERE ventas.juguete_id = juguetes.id_juguetes && ventas.jardin_id = jardines.id_jardines "
                        + "&& '" + compjard + "' = jardines.id_jardines");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error en la imagen " + e);
        }
    }

    public void ReporteProJug(int juguprov) {

        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_JugProv.pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/header.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informe creado para Adriana Morin © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Juguetes segun proveedor \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(7);
            tabla.setWidths(new int[]{20, 80, 60, 60, 60, 60, 60});
            tabla.setWidthPercentage(100f);
            tabla.addCell("ID");
            tabla.addCell("Nombre Juguete");
            tabla.addCell("Precio");
            tabla.addCell("Tipo de juguete");
            tabla.addCell("Costo de fabricacion");
            tabla.addCell("Proveedor");
            tabla.addCell("Stock");

            try {
                Connection cn2 = Conexion.conectar();;
                PreparedStatement pst = cn2.prepareStatement("select id_juguetes, nombre, Precio, Tipo, Costo, "
                        + "proveedor.nombre_prov, Stock from juguetes, proveedor WHERE"
                        + " juguetes.Proveedor = proveedor.id_proveedor && '" + juguprov + "' = proveedor.id_proveedor");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error en la imagen " + e);
        }
    }
    
    public void ListaPrecio (int tipo){
        
        String sql = "", tipo_string = "" ;
        
        if (tipo == 1) {
            sql = "select nombre, Precio from juguetes WHERE  'Goma Espuma' = Tipo";
            tipo_string = "Goma Espuma " + fecha;
        } else if (tipo == 2) {
            sql = "select nombre, Precio from juguetes WHERE  'Madera' = Tipo";
            tipo_string = "Madera " + fecha;
        } else if (tipo == 3) {
            sql = "select nombre, Precio from juguetes WHERE  'Plastico' = Tipo";
            tipo_string = "Plastico " + fecha;
        } else if (tipo == 4) {
            sql = "select nombre, Precio from juguetes";
            tipo_string = "Todos " + fecha;
        }
                
        
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Listas de precios/Lista de precio " + tipo_string + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/header.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Lista de precio creada para Adriana Morin © \n\n");
            parrafo.add("Laprida 3937 Santa Fe Tel 0342 - 4527811 Cel: 342-5470876 \n");
            parrafo.add("www.adrianaeduca.com.ar - E-mail: info@adrianaeduca.com.ar \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Lista de precio \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(2);
            tabla.setWidths(new int[]{150, 80});
            tabla.setWidthPercentage(100f);

            Paragraph columna1 = new Paragraph("Nombre Juguete");
            columna1.getFont().setStyle(Font.BOLD);
            columna1.getFont().setSize(10);
            tabla.addCell(columna1);

            Paragraph columna2 = new Paragraph("Precio");
            columna2.getFont().setStyle(Font.BOLD);
            columna2.getFont().setSize(10);
            tabla.addCell(columna2);

            try {
                Connection cn2 = Conexion.conectar();;
                PreparedStatement pst = cn2.prepareStatement(sql);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));

                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error en la imagen " + e);
        }

    }
    
     public void ReporteVisita(){
        
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");

            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Visitas.pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/header.png");
            header.scaleToFit(550, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informe creado para Adriana Morin © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Visitas Registradas \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidths(new int[]{15, 80, 80, 65, 145});
            tabla.setWidthPercentage(100f);
            tabla.addCell("ID");
            tabla.addCell("Jardin");
            tabla.addCell("Fecha");
            tabla.addCell("Contacto");
            tabla.addCell("Comentarios");
            

            try {
                Connection cn2 = Conexion.conectar();
                PreparedStatement pst = cn2.prepareStatement("select id_visita, jardines.Jardin, fecha, "
                        + "contactovis, comentario from visitas, jardines "
                        + "WHERE visitas.jardin_id = jardines.id_jardines");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error en la imagen " + e);
        }
    }

   
}
