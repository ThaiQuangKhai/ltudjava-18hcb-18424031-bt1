/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

import static XuLy.DangNhap.giaovu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class ImportTKB {

    /**
     * @param args the command line arguments
     */
    public static void inporttkb(String user, String pass) throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.print("Thời khóa biểu lớp:");
        String lop = input.nextLine();
        System.out.print("file chứa thời kháo biểu:");
        String csvFile = input.nextLine();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<TKB> arrTKB = new ArrayList<>();
        ArrayList<SinhVien> arrSinhVien = new ArrayList<>();
        SinhVien sinhvien;
        TKB tkb;
        try {
            br = new BufferedReader(new FileReader(lop+".csv"));
            while ((line = br.readLine()) != null) {
                String[] sv = line.split(cvsSplitBy);
                sinhvien = new SinhVien(sv[0],sv[1],sv[2],sv[3]);
                arrSinhVien.add(sinhvien);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file bạn nhập vào hoạc định dạng lỗi");
            //Logger.getLogger(ImportTKB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br = new BufferedReader(new FileReader(csvFile+".csv"));
            System.out.println("Mã môn\tTên môn\t\t\tPhòng học");
            while ((line = br.readLine()) != null) {
                String[] l = line.split(cvsSplitBy);
                String File=lop+"-"+l[0]+".csv";
                PrintStream f = new PrintStream(File);
                tkb = new TKB(l[0],l[1],l[2]);
                arrTKB.add(tkb);
                
                for (SinhVien student : arrSinhVien) {           
                    f.print(student.getmssv()+",");
                    f.print(student.gethoten()+",");
                    f.print(student.getgt()+",");
                    f.println(student.getcmnd());
                }
                System.out.println(l[0].toString() + "\t" + l[1] + "\t\t\t" + l[2]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file bạn nhập vào hoạc định dạng lỗi");
            //Logger.getLogger(ImportTKB.class.getName()).log(Level.SEVERE, null, ex);
        }
        giaovu(user, pass);
    }
}