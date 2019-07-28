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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class ImportDiem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        System.out.print("Nhập lớp cần đưa điểm vào:");
        String csvFile = input.nextLine();
        //String csvFile = "18HCB.csv";
        csvFile += ".csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<BangDiem> arrBangDiem = new ArrayList<>();
        BangDiem bangdiem;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] bd = line.split(cvsSplitBy);
                
                //sinhvien = new SinhVien();
                bangdiem = new BangDiem(bd[0], bd[1], Float.parseFloat(bd[2]), Float.parseFloat(bd[3]), Float.parseFloat(bd[4]), Float.parseFloat(bd[5]));
                arrBangDiem.add(bangdiem);

                //System.out.println("Country [code= " + sv[0].toString() + " , name=" + sv[1] + "]");

            }
        //PrintStream f = new PrintStream("DangNhap.csv");
        System.out.print("MSSV\t\tHọ tên\t\t\tĐiểm GK\t\tĐiểm CK\t\tĐiểm khác\tĐiểm tổng\n");
        for (BangDiem bangDiem : arrBangDiem) {           
            System.out.print(bangDiem.getMssv()+"\t");
            System.out.print(bangDiem.getHoten()+"\t\t");
            System.out.print(bangDiem.getDiem_gk()+"\t\t");
            System.out.print(bangDiem.getDiem_ck()+"\t\t");
            System.out.print(bangDiem.getDiem_khac()+"\t\t");
            System.out.println(bangDiem.getDiem_tong());
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
