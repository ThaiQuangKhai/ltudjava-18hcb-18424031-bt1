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
public class XemBangDiem {

    /**
     * @param args the command line arguments
     */
    public static void xembangdiem(String user, String pass) throws IOException {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        System.out.print("Nhập lớp cần xem điểm:");
        String lop = input.nextLine();
        System.out.print("Nhập mã môn học cần xem:");
        String mon = input.nextLine();
        String csvFile="";
        csvFile+= lop+"-"+mon+"-DIEM.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<BangDiem> arrBangDiem = new ArrayList<>();
        BangDiem bangdiem;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] bd = line.split(cvsSplitBy);
                bangdiem = new BangDiem(bd[0], bd[1], Float.parseFloat(bd[2]), Float.parseFloat(bd[3]), Float.parseFloat(bd[4]), Float.parseFloat(bd[5]));
                arrBangDiem.add(bangdiem);
            }
            System.out.print("MSSV\t\tHọ tên\t\t\tĐiểm GK\t\tĐiểm CK\t\tĐiểm khác\tĐiểm tổng\tĐậu\n");
            int d=0,r=0,t=0;
            for (BangDiem bangDiem : arrBangDiem) {           
                System.out.print(bangDiem.getMssv()+"\t");
                System.out.print(bangDiem.getHoten()+"\t\t");
                System.out.print(bangDiem.getDiem_gk()+"\t\t");
                System.out.print(bangDiem.getDiem_ck()+"\t\t");
                System.out.print(bangDiem.getDiem_khac()+"\t\t");
                System.out.print(bangDiem.getDiem_tong()+"\t\t");
                if(bangDiem.getDiem_tong()>=5)
                {
                    System.out.println("Đậu");
                    d++;
                }
                else
                {
                    System.out.println("Rớt");
                    r++;
                }
            }
            t=d+r;
            float ptd=(d/(float)t)*100;
            float ptr=100-ptd;
            System.out.println("Số lượng sinh viện đậu là "+d+" trong tổng số "+t+" sinh viên");
            System.out.println("Số lượng sinh viện rớt là "+r+" trong tổng số "+t+" sinh viên");
            System.out.println("Phần trâm sinh viện đậu là "+ptd+" phần trăm");
            System.out.println("Số lượng sinh viện rớt là "+ptr+" phần trăm");
        
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
        DangNhap.giaovu(user,pass);
    }
}
