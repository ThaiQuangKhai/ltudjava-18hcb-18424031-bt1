/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

import static XuLy.DangNhap.giaovu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Them1SV {
 
    public static void addstudent(String user, String pass) throws IOException{
        Scanner input=new Scanner(System.in);
        System.out.print("Thêm sinh viên vào lớp:");
        String csvFile = input.nextLine();
        List<SinhVien> arrSinhVien = new ArrayList<SinhVien>();
        //Set<SinhVien> treesetSinhVien = new TreeSet<>();
        SinhVien sinhvien;
        System.out.print("MSSV:");
        String masv = input.nextLine();
        System.out.print("Họ tên:");
        String hoten = input.nextLine();
        System.out.print("Giới tính:");
        String gt = input.nextLine();
        System.out.print("Chứng minh nhân dân:");
        String cmnd = input.nextLine();
        
        csvFile += ".csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] bd = line.split(cvsSplitBy);
                sinhvien = new SinhVien(bd[0], bd[1], bd[2], bd[3]);
                arrSinhVien.add(sinhvien);
                //treesetSinhVien.add(sinhvien);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file bạn nhập vào hoạc định dạng lỗi");
            //Logger.getLogger(Them1SV.class.getName()).log(Level.SEVERE, null, ex);
        }
        sinhvien = new SinhVien(masv, hoten, gt, cmnd);
        arrSinhVien.add(sinhvien);
        //treesetSinhVien.add(sinhvien);
        //Collections.sort(arrSinhVien,new SortByMSSV());
        PrintStream f = new PrintStream(csvFile);
        System.out.print("MSSV\t\tHọ tên\t\tGiới tính\tCMND\n");
        for (SinhVien student : arrSinhVien) {           
            System.out.print(student.getmssv()+"\t");
            System.out.print(student.gethoten()+"\t\t");
            System.out.print(student.getgt()+"\t");
            System.out.println(student.getcmnd());
            f.print(student.getmssv()+",");
            f.print(student.gethoten()+",");
            f.print(student.getgt()+",");
            f.println(student.getcmnd());
        }
        giaovu(user, pass);
    }
//    class SortByMSSV implements Comparator<SinhVien> {
//        @Override
//        public int compare(SinhVien a, SinhVien b) {
//            return a.getmssv().compareTo(b.getmssv());
//        }
//    }
}
