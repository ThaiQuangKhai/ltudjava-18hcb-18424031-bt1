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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DangNhap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        System.out.println("User:");
        String user = input.nextLine();
        System.out.println("Password:");
        String password = input.nextLine();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String csvFile = "DangNhap.csv";
        ArrayList<Acccount> arrAccount = new ArrayList<>();
        Acccount account;
	Scanner scanner = new Scanner(System.in);
        int lan=0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            //Acccount ac;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] ac = line.split(cvsSplitBy);
                
                //sinhvien = new SinhVien();
                //account = new Acccount(sv[0],sv[1]);
                if(user.equals(ac[0])&&user.equals("giaovu")&&password.equals(ac[1]))
                {
                    giaovu();
                    lan++;
                }else if(user.equals(ac[0])&&password.equals(ac[1]))
                {
                    sinhvien(user,password);
                    lan++;
                }
                //System.out.println("Country [code= " + ac[0] + " , name=" + ac[1] + "]");

            }
            if(lan!=0)
            {
                System.out.println("User hoạc password sai!!!");
            }
            System.out.println(lan);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        //giaovu();
    }
    public static void giaovu()
    {
        //System.out.printf("\n| %-90s %7s", "Menu: ", "|"); 
        System.out.printf("1. Import danh sách lop."); 
        System.out.printf("\n2. Them một sinh viên."); 
        System.out.printf("\n3. Import thoi khoa biểu."); 
        System.out.printf("\n4. Thêm sinh viên vào môn học."); 
        System.out.printf("\n5. Xóa sinh viên trong môn học."); 
        System.out.printf("\n6. Xem danh sách lớp"); 
        System.out.printf("\n7. Xem lại thời khóa biểu"); 
        System.out.printf("\n8. Import bảng điểm"); 
        System.out.printf("\n9. Xem lại bảng điểm"); 
        System.out.printf("\n10. Sửa điểm sinh viên"); 
        System.out.printf("\n11. Đổi mật khẩu");
        System.out.printf("\n0. Đăng xuất."); 
        System.out.printf("\nNhập mục cần dùng:"); 
        Scanner input=new Scanner(System.in);
        String choice = input.nextLine();
        switch (choice) {
            case "1":
                //ImportLop.Import();
                break;
//            case "2":
//                studentId = studentManager.inputId();
//                studentManager.edit(studentId);
//                break;
//            case "3":
//                studentId = studentManager.inputId();
//                studentManager.delete(studentId);
//                break;
//            case "4":
//                studentManager.sortStudentByGPA();
//                break;
//            case "5":
//                studentManager.sortStudentByName();
//                break;
//            case "6":
//                studentManager.show();
//                break;
              case "0":
                  danguat();
                  break;
            default:
                System.out.println("Chọn không hợp lệ, yêu cầu chọn các mục đã nêu");
                giaovu();
                break;
        }
    }
    
    public static void sinhvien(String masv, String pass)
    {
        System.out.printf("1. Xem điểm."); 
        System.out.printf("\n2. Đổi mật khẩu");
        System.out.printf("\n0. Đăng xuất."); 
        System.out.printf("\nNhập mục cần dùng:"); 
        Scanner input=new Scanner(System.in);
        String choice = input.nextLine();
        switch (choice) {
            case "1":
                SinhVienXemDiem.DiemSV(masv,pass);
                break;
            case "0":
                danguat();
                break;
            default:
                System.out.println("Chọn không hợp lệ, yêu cầu chọn các mục đã nêu");
                sinhvien(masv,pass);
                break;
        }
    }
    public static void danguat()
    {
        String[] args = null;
        try {
            XuLy.DangNhap.main(args);
        } catch (IOException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
