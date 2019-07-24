/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class ImportLop {
//    public class SinhVien{
//        private String mssv;
//        private String hoten;
//        private String gt;
//        private String cmnd;
//    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("File cấn input:");
        String csvFile = input.nextLine();
        //String csvFile = "18HCB.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<SinhVien> arrSinhVien = new ArrayList<>();
        SinhVien sinhvien;
	Scanner scanner = new Scanner(System.in);
        try {

            br = new BufferedReader(new FileReader(csvFile));
            //ArrayList<String> arrListString = new ArrayList<>();
            //ArrayList<SinhVien> SinhVienList=new ArrayList<>();
            //SinhVien s;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] sv = line.split(cvsSplitBy);
                //sinhvien = new SinhVien();
                sinhvien = new SinhVien(sv[0],sv[1],sv[2],sv[3]);
                arrSinhVien.add(sinhvien);

                //System.out.println("Country [code= " + sv[0].toString() + " , name=" + sv[1] + "]");

            }
        //PrintStream f = new PrintStream("Students.txt");
        System.out.print("MSSV\t\tHọ tên\t\tGiới tính\tCMND\n");
        for (SinhVien student : arrSinhVien) {
//            System.out.format("%5d | ", student.getmssv());
//            System.out.format("%20s | ", student.gethoten());
//            System.out.format("%5d | ", student.getgt());
//            System.out.format("%20s | ", student.getcmnd());
            
            System.out.print(student.getmssv()+"\t");
            System.out.print(student.gethoten()+"\t\t");
            System.out.print(student.getgt()+"\t");
            System.out.println(student.getcmnd());
            
            //f.print(student.getmssv()+",");
            //f.print(student.gethoten()+",");
            //f.print(student.getgt()+",");
            //f.println(student.getcmnd());
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}