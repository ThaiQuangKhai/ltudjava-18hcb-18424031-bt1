/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

import static XuLy.DangNhap.giaovu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Xoa1SV {
    public static void DeleteStudent(String user, String pass) throws IOException{
        Scanner input=new Scanner(System.in);
        System.out.print("Xóa sinh viên lớp:");
        String csvFile = input.nextLine();
        
        //String csvFile = input.nextLine();
        List<SinhVien> arrSinhVien = new ArrayList<>();
        SinhVien sinhvien;
        System.out.print("MSSV:");
        String masv = input.nextLine();
        
        csvFile += ".csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] bd = line.split(cvsSplitBy);
                if(masv.equals(bd[0]))
                {
                }
                else
                {
                    sinhvien = new SinhVien(bd[0], bd[1], bd[2], bd[3]);
                    arrSinhVien.add(sinhvien);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Them1SV.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Collections.sort(arrSinhVien);
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
}
