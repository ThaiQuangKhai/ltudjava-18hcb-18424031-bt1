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
        System.out.print("User:");
        String user = input.nextLine();
        System.out.print("Password:");
        String password = input.nextLine();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String csvFile = "DangNhap.csv";
        ArrayList<Acccount> arrAccount = new ArrayList<>();
        Acccount account;
	//Scanner scanner = new Scanner(System.in);
        String a,b;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            //Acccount ac;
            while ((line = br.readLine()) != null) {
                String[] ac = line.split(cvsSplitBy);

                if(user.equals(ac[0])&&password.equals(ac[1])&&user.equalsIgnoreCase("giaovu"))
                {
                    giaovu(user, password);
                }
                else if(user.equals(ac[0])&&password.equals(ac[1]))
                {
                    sinhvien(user,password);
                }
            }
            System.out.printf("User name hoạc password không đúng\nYêu cầu nhập lại\n"); 
            XuLy.DangNhap.main(args);
        } catch (FileNotFoundException ex) {
            System.out.printf("Lỗi"); 
            //Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void giaovu(String user, String pass) throws IOException
    {
        System.out.printf("1. Import danh sách lop."); 
        System.out.printf("\n2. Them một sinh viên."); 
        System.out.printf("\n3. Import thời kháo biểu."); 
        System.out.printf("\n4. Xóa một sinh viên."); 
        System.out.printf("\n5. Xem danh sách lớp"); 
        System.out.printf("\n6. Xem lại thời khóa biểu"); 
        System.out.printf("\n7. Import bảng điểm"); 
        System.out.printf("\n8. Xem lại bảng điểm"); 
        System.out.printf("\n9. Sửa điểm sinh viên"); 
        System.out.printf("\n10. Đổi mật khẩu");
        System.out.printf("\n11. Đăng xuất."); 
        System.out.printf("\n0. Thóa."); 
        System.out.printf("\nNhập mục cần dùng:"); 
        Scanner input=new Scanner(System.in);
        String choice = input.nextLine();
        switch (choice) {
            case "1":
                ImportLop.importlop(user, pass);
                break;
            case "2":
                XuLy.Them1SV.addstudent(user, pass);
                break;
            case "3":
                XuLy.ImportTKB.inporttkb(user, pass);
                break;
            case "4":
                XuLy.Xoa1SV.DeleteStudent(user, pass);
                break;
            case "5":
                XuLy.XemDSLop.DSLop(user, pass);
                break;
            case "6":
                XuLy.XemTKB.xemtkb(user, pass);
                break;
            case "7":
                XuLy.ImportDiem.importdiem(user, pass);
                break;
            case "8":
                XuLy.XemBangDiem.xembangdiem(user, pass);
                break;
            case "9":
                XuLy.SuaDiemSV.suadiemsv(user, pass);
                break;
            case "10":
                doimatkhau(user, pass);
                break;
            case "11":
                danguat();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("Chọn không hợp lệ, yêu cầu chọn các mục đã nêu");
                giaovu(user, pass);
                break;
        }
    }
    
    public static void sinhvien(String user, String pass) throws IOException
    {
        System.out.printf("1. Xem điểm."); 
        System.out.printf("\n2. Đổi mật khẩu");
        System.out.printf("\n3. Đăng xuất."); 
        System.out.printf("\n0. Đăng xuất."); 
        System.out.printf("\nNhập mục cần dùng:"); 
        Scanner input=new Scanner(System.in);
        String choice = input.nextLine();
        switch (choice) {
            case "1":
                SinhVienXemDiem.DiemSV(user,pass);
                break;
            case "2":
                doimatkhau(user, pass);
                break;
            case "3":
                danguat();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("Chọn không hợp lệ, yêu cầu chọn các mục đã nêu");
                sinhvien(user,pass);
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
    public static void doimatkhau(String user, String pass) throws IOException
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Mật khẩu hiện tại:");
        String passnow = input.nextLine();
        System.out.println("Mật khẩu mới:");
        String passnew= input.nextLine();
        System.out.println("Nhập lại mật khẩu mới:");
        String passnewagain = input.nextLine();
        if(pass.equalsIgnoreCase(passnow))
        {
            if(passnew.equalsIgnoreCase(passnewagain))
            {
                BufferedReader br = null;
                String line = "";
                String cvsSplitBy = ",";
                String csvFile = "DangNhap.csv";
                ArrayList<Acccount> arrAccount = new ArrayList<>();
                Acccount account;
                //Scanner scanner = new Scanner(System.in);
                int lan=0;
                try {
                    br = new BufferedReader(new FileReader(csvFile));
                    while ((line = br.readLine()) != null) {
                        String[] ac = line.split(cvsSplitBy);
                        if(user.equals(ac[0])&&pass.equals(ac[1]))
                        {
                            account=new Acccount(ac[0],passnew);
                        }
                        else
                        {
                            account=new Acccount(ac[0],ac[1]);
                        }
                        arrAccount.add(account);
                    }
                } catch (FileNotFoundException ex) {
                    System.out.printf("Lỗi file"); 
                    //Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
                PrintStream f = new PrintStream("DangNhap.csv");

                for (Acccount acccount : arrAccount) {           
                    f.print(acccount.getUser()+",");
                    f.println(acccount.getPasswourd());
                }
            }
            else
            {
                System.out.println("Hai lần mật khẩu mới không trùng khớp, hãy nhập lại");
                doimatkhau( user, pass);
            }
        }
        else
        {
            System.out.println("Mật khẩu hiện tại không đúng, hãy nhập lại");
            doimatkhau( user, pass);
        }
        if(user.equalsIgnoreCase("giaovu"))
        {
            giaovu(user, pass);
        }
        else sinhvien(user, pass);
    }
}
