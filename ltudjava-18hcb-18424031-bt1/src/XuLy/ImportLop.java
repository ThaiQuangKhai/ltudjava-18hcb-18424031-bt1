/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

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
public class ImportLop {
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
        //PrintStream f = new PrintStream("DangNhap.csv");
        System.out.print("MSSV\t\tHọ tên\t\tGiới tính\tCMND\n");
        for (SinhVien student : arrSinhVien) {           
            System.out.print(student.getmssv()+"\t");
            System.out.print(student.gethoten()+"\t\t");
            System.out.print(student.getgt()+"\t");
            System.out.println(student.getcmnd());
        }
        DangNhap.giaovu();
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