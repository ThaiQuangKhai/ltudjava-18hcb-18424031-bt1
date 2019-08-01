/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

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
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Them1SVVaoLop {
 
    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.print("Thêm sinh viên vào lớp:");
        String csvFile = input.nextLine();
        
        //String csvFile = input.nextLine();
        List<SinhVien> arrSinhVien = new ArrayList<>();
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
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Them1SVVaoLop.class.getName()).log(Level.SEVERE, null, ex);
        }
        sinhvien = new SinhVien(masv, hoten, gt, cmnd);
        arrSinhVien.add(sinhvien);
        //Collections.sort(arrSinhVien);
        PrintStream f = new PrintStream(csvFile);
        System.out.print("MSSV\t\tHọ tên\t\tGiới tính\tCMND\n");
        for (SinhVien student : arrSinhVien) {           
            System.out.print(student.getmssv()+"\t");
            System.out.print(student.gethoten()+"\t\t");
            System.out.print(student.getgt()+"\t");
            System.out.println(student.getcmnd());
            f.print(student.getmssv()+"\t");
            f.print(student.gethoten()+"\t\t");
            f.print(student.getgt()+"\t");
            f.println(student.getcmnd());
        }
    }
}
