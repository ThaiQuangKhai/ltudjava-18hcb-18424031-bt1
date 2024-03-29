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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class XemTKB {
    public static void xemtkb(String user, String pass) throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.print("Thời khóa biểu lớp cần xem:");
        String csvFile = input.nextLine();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<TKB> arrTKB = new ArrayList<>();
        TKB tkb;
        try {
            br = new BufferedReader(new FileReader(csvFile+"-TKB.csv"));
            System.out.println("Mã môn\tTên môn\t\t\t\tPhòng học");
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] l = line.split(cvsSplitBy);
                tkb = new TKB(l[0],l[1],l[2]);
                arrTKB.add(tkb);
                System.out.println(l[0] + "\t" + l[1] + "\t\t\t" + l[2]);

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Không tìm thấy file bạn nhập vào hoạc định dạng lỗi");
            //Logger.getLogger(ImportTKB.class.getName()).log(Level.SEVERE, null, ex);
        }
        giaovu(user, pass);
    }
}
