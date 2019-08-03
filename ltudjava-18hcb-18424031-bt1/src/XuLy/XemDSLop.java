/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

import static XuLy.DangNhap.giaovu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class XemDSLop {
    public static void DSLop(String user, String pass) throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.print("Nhập lớp cần xem:");
        String csvFile = input.nextLine();
        csvFile += ".csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<SinhVien> arrSinhVien = new ArrayList<>();
        SinhVien sinhvien;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] sv = line.split(cvsSplitBy);
                sinhvien = new SinhVien(sv[0],sv[1],sv[2],sv[3]);
                arrSinhVien.add(sinhvien);
            }
        System.out.print("MSSV\t\tHọ tên\t\tGiới tính\tCMND\n");
        for (SinhVien student : arrSinhVien) {           
            System.out.print(student.getmssv()+"\t");
            System.out.print(student.gethoten()+"\t\t");
            System.out.print(student.getgt()+"\t");
            System.out.println(student.getcmnd());
        }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file bạn nhập vào hoạc định dạng lỗi");
            //e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Không tìm thấy file bạn nhập vào hoạc định dạng lỗi");
            //e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        giaovu(user, pass);
    }
}