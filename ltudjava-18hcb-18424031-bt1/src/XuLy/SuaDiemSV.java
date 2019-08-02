/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

import static XuLy.DangNhap.doimatkhau;
import static XuLy.DangNhap.giaovu;
import static XuLy.DangNhap.sinhvien;
import java.io.BufferedReader;
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
public class SuaDiemSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner input=new Scanner(System.in);
        System.out.println("Sủa điểm sinh viên lớp:");
        String csvFile = input.nextLine();
        csvFile+="-DIEM.csv";
        System.out.println("Mã số sinh viên:");
        String mssv= input.nextLine();
        System.out.println("Điểm giửa kỳ:");
        String gk = input.nextLine();
        System.out.println("Điểm cuối kỳ:");
        String ck = input.nextLine();
        System.out.println("Điểm khác:");
        String dk = input.nextLine();
        System.out.println("Điểm tổng:");
        String dt = input.nextLine();

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<BangDiem> arrBangDiem = new ArrayList<>();
        BangDiem bangDiem;
        //Scanner scanner = new Scanner(System.in);
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] bd = line.split(cvsSplitBy);
                if(mssv.equals(bd[0]))
                {
                    bangDiem=new BangDiem(bd[0], bd[1], Float.parseFloat(gk), Float.parseFloat(ck), Float.parseFloat(dk), Float.parseFloat(dt));
                }
                else
                {
                    bangDiem = new BangDiem(bd[0], bd[1], Float.parseFloat(bd[2]), Float.parseFloat(bd[3]), Float.parseFloat(bd[4]), Float.parseFloat(bd[5]));
                }
                arrBangDiem.add(bangDiem);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintStream f = new PrintStream(csvFile);

        for (BangDiem bangDiem1 : arrBangDiem) {           
            System.out.print(bangDiem1.getMssv()+"\t");
            System.out.print(bangDiem1.getHoten()+"\t\t");
            System.out.print(bangDiem1.getDiem_gk()+"\t\t");
            System.out.print(bangDiem1.getDiem_ck()+"\t\t");
            System.out.print(bangDiem1.getDiem_khac()+"\t\t");
            System.out.println(bangDiem1.getDiem_tong());
            
            f.print(bangDiem1.getMssv()+",");
            f.print(bangDiem1.getHoten()+",");
            f.print(bangDiem1.getDiem_gk()+",");
            f.print(bangDiem1.getDiem_ck()+",");
            f.print(bangDiem1.getDiem_khac()+",");
            f.println(bangDiem1.getDiem_tong());
        }
    }
    
}
