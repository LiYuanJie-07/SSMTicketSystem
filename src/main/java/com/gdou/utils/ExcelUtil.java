package com.gdou.utils;

import com.gdou.domain.Order;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

import static org.apache.poi.hssf.usermodel.HSSFPicture.PICTURE_TYPE_JPEG;
import static org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER;

/**
 * excel工具类
 */
public class ExcelUtil {
    public static void createExcel(OutputStream os, String rootPath, Order order) {
        //excel模板路径
        String modelPath = rootPath + "/ssmTicketSystem/static/excelModel/orderModel.xls";
        //二维码路径
        String qrcodePath = rootPath + "/ssmTicketSystem/static/images/qrcode/" + order.getOrderUsername() + "/" + order.getOrderid() + ".jpg";
        HSSFWorkbook workbook = null;
        //使用模板
        try {
            POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream(modelPath));
            //创建工作薄
            workbook = new HSSFWorkbook(fileSystem);
            //获取第一页
            HSSFSheet sheet = workbook.getSheetAt(0);
            HSSFRow row; //行
            HSSFCell cell; //单元格

            //订单号
            row = sheet.getRow(2);
            cell = row.getCell(1);
            cell.setCellValue(order.getOrderid());
            //订单状态
            row = sheet.getRow(2);
            cell = row.getCell(4);
            cell.setCellValue(order.getStatus());
            HSSFFont font = workbook.createFont();
            font.setFontName("宋体");//设置字体
            font.setFontHeightInPoints((short) 12);//设置字体大小
            font.setBold(true);//粗体显示
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(CENTER); // 居中
            if (order.getStatus().equals("已支付")) {
                font.setColor(HSSFColor.GREEN.index);
                cellStyle.setFont(font);
                cell.setCellStyle(cellStyle);
            } else {
                font.setColor(HSSFColor.RED.index);
                cellStyle.setFont(font);
                cell.setCellStyle(cellStyle);
            }
            // 用户ID
            row = sheet.getRow(3);
            cell = row.getCell(1);
            cell.setCellValue(order.getUserid());
            // 用户名
            row = sheet.getRow(3);
            cell = row.getCell(4);
            cell.setCellValue(order.getOrderUsername());
            // 姓名
            row = sheet.getRow(4);
            cell = row.getCell(1);
            cell.setCellValue(order.getOrderIdcardname());
            // 身份证号
            row = sheet.getRow(4);
            cell = row.getCell(4);
            cell.setCellValue(order.getOrderIdcardnumber());
            // 车票ID
            row = sheet.getRow(5);
            cell = row.getCell(1);
            cell.setCellValue(order.getTicketid());
            // 车次
            row = sheet.getRow(5);
            cell = row.getCell(4);
            cell.setCellValue(order.getOrderTrainname());
            // 始发站
            row = sheet.getRow(6);
            cell = row.getCell(1);
            cell.setCellValue(order.getOrderStartstation());
            // 终点站
            row = sheet.getRow(6);
            cell = row.getCell(4);
            cell.setCellValue(order.getOrderEndstation());
            // 发车时间
            row = sheet.getRow(7);
            cell = row.getCell(1);
            cell.setCellValue(order.getOrderStarttime());
            // 预计到达时间
            row = sheet.getRow(7);
            cell = row.getCell(4);
            cell.setCellValue(order.getOrderArrivetime());
            // 订单金额
            row = sheet.getRow(8);
            cell = row.getCell(1);
            cell.setCellValue(order.getOrderPrice() + "元");
            // 下单时间
            row = sheet.getRow(8);
            cell = row.getCell(4);
            cell.setCellValue(order.getOrdertime());
            // 座位ID
            row = sheet.getRow(9);
            cell = row.getCell(1);
            cell.setCellValue(order.getSeatid());
            // 座位类型
            row = sheet.getRow(9);
            cell = row.getCell(4);
            cell.setCellValue(order.getOrderSeattype());
            // 车厢
            row = sheet.getRow(10);
            cell = row.getCell(1);
            cell.setCellValue(order.getOrderCarriage() + "号");
            // 座位号
            row = sheet.getRow(10);
            cell = row.getCell(4);
            cell.setCellValue(order.getOrderSeatlocation());

            //插入二维码
            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255, (short) 7, 3, (short) 8, 10);
            // 图片字节流
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            BufferedImage bufferImg = ImageIO.read(new File(qrcodePath));
            ImageIO.write(bufferImg, "jpg", byteArrayOut);
            byte[] imgtypes = byteArrayOut.toByteArray();
            /*
             * 在工作簿中添加一张图片，返回图片的索引，base 1
             * @param pictureType 图片类型 PICTURE_TYPE_JPEG|PICTURE_TYPE_PNG
             **/
            int puctureIndex = workbook.addPicture(imgtypes, PICTURE_TYPE_JPEG);
            // 创建图片
            patriarch.createPicture(anchor, puctureIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //写到输出流中
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}