package atmprogram;                         //Paket Program dengan nama "atmprogram"
 
import java.util.Scanner;
 
public class AtmProgram {
 
    Scanner s = new Scanner(System.in);
    AtmClass atm = new AtmClass();
    double minSaldo = 50000;                //Batas Minimal Saldo Tabungan
    int pil;
 
    public static void main(String[] args) {
        AtmProgram program = new AtmProgram();
        program.initSaldo(5000000);         //Isi saldo pada tabungan
        program.login();
    }
 
    public void initSaldo(double saldo) {
        atm.setSaldo(saldo);
    }
 
    public void menu() {
        System.out.println("=======================================================");
        System.out.print("|");
        System.out.print("\tSelamat Datang di ATM Bank Sejahtera          |");
        System.out.println();
        System.out.println("=======================================================");
        System.out.print("|");
        System.out.print("\t       > Pilih Transaksi <                    |");
        System.out.println();
        System.out.print("|");
        System.out.print("\t[1] Cek Saldo          [2] Transfer           |");
        System.out.println();
        System.out.print("|");
        System.out.print("\t[3] Penarikan          [4] Pembayaran         |");
        System.out.println();
        System.out.print("|");
        System.out.println("\t           [5] Keluar                         |");
        System.out.println("=======================================================");
        System.out.print("\t         Masukan pilihan Anda : ");
        pil = s.nextInt();
        switch (pil) {
            case 1:                     //Pilihan melihat saldo
                lihatSaldo();
                break;
            case 2:                     //Pilihan melakukan transfer
                transfer();
                break;
            case 3:                     //Pilihan melakukan penarikan
                tarik();
                break;
            case 4:                     //Pilihan melakukan pembayaran
                pembayaran();
                break;
            case 5:                     //Pilihan menu keluar dari menu atm
                System.out.println("=======================================================");
                System.out.println("\tTerimakasih telah menggunakan layanan kami.");
                System.out.println("\t      Silahkan Ambil kartu Anda.");
                break;                                                              //untuk memberhentikan script
            default:
                System.out.println("Pilihan Yang Anda masukan salah. Silahkan Login kembali."); //Jika salah melakukan pilihan angka
                login();
                break;                                                              //untuk memberhentikan script
        }
    }
 
    //-------------------------------- User Login
    public void login() {
        int pin;
        atm.setPin(12345678);
        System.out.println("=======================================================");
        System.out.print("|");
        System.out.print("\tSelamat Datang di ATM Bank Sejahtera          |");
        System.out.println();
        System.out.println("=======================================================");
        System.out.print("\t     Masukan PIN : ");          //Masukkan PIN
        pin = s.nextInt();
        if (atm.getPin() == pin) {                          //Jika PIN salah akan terjadi perulangan
            menu();
        } else {
            System.out.println("Gagal");                    //Akan terjadi kegagalan login bila salah memasukkan PIN
            login();
        }
    }
 
    //----------------------------- Menu Lihat Saldo
    public void lihatSaldo() {
        System.out.println("=======================================================");
        System.out.println("\t         Lihat Saldo ");
        System.out.println("=======================================================");
        System.out.println("Sisa Saldo yang Anda miliki adalah sebesar Rp." + atm.getSaldo()); //Untuk mengambil data sisa saldo
        transaksiLagi();
 
    }
 
    //---------------------------- Menu Transfer
    public void transfer() {
        int norek;
        double nom;
        Scanner scan = new Scanner(System.in);
        System.out.println("=======================================================");
        System.out.print("|");
        System.out.print("\tTransfer                    |");
        System.out.println();
        System.out.println("=======================================================");
        System.out.print("\tMasukan Nomor Rekening : ");                                //Masukkan NOREK
        norek = s.nextInt();
        System.out.println();
        System.out.print("\tMasukan Nominal Transfer : ");                              //Masukkan Nominal Transfer
        nom = scan.nextDouble();
        transferNominal(nom, norek);
    }
 
    public void transferNominal(double nominal, int norek) {
        double saldo = atm.getSaldo();
        if (atm.getSaldo() < 50000) {
            System.out.println("\tMaaf Saldo Anda tidak mencukupi."); //Jika Saldo mencapai batas limit 50000
        } else {
            saldo -= nominal;
            if (saldo < minSaldo) {
                System.out.println("\tMaaf, jumlah transfer terlalu besar");        //maka tidak akan bisa melakukan penarikan
                System.out.println("\t    Sisa saldo tidak mencukupi");
            } else {
                atm.setSaldo(saldo);
                System.out.println("Anda telah berhasil melakukan transfer sebesar : " + nominal);
                System.out.println("Ke nomor rekening : " + norek);
                System.out.println("\t       Sisa Saldo adalah :" + saldo);
            }
            transaksiLagi();
        }
    }
 
    //------------------------------------------ Menu penarikan
    public void tarik() {
        double penarikan;
        Scanner scan = new Scanner(System.in);
 
        System.out.println("=======================================================");
        System.out.print("|");
        System.out.print("\t            Penarikan Tunai                   |"
                + "                |");
        System.out.println();
        System.out.println("=======================================================");
        System.out.print("|");
        System.out.print("\t           > Pilih Nominal <                  |");
        System.out.println();
        System.out.print("|");
        System.out.print("\t[1] Rp. 100.000          [2] Rp. 200.000      |");
        System.out.println();
        System.out.print("|");
        System.out.print("\t[3] Rp. 500.000          [4] Rp. 1000.0000    |");
        System.out.println();
        System.out.print("|");
        System.out.println("\t[5] Rp. 2000.0000        [6] Penarikan        |");
        System.out.println("=======================================================");
        System.out.print("\t         Masukan pilihan Anda : ");
        pil = s.nextInt();
        System.out.println("=======================================================");
        switch (pil) {
            case 1:
                tarikNominal(100000);
                break;
            case 2:
                tarikNominal(200000);
                break;
            case 3:
                tarikNominal(500000);
                break;
            case 4:
                tarikNominal(1000000);
                break;
            case 5:
                tarikNominal(2000000);
                break;
            case 6:
                System.out.println("\t         Masukan Nominal : ");
                System.out.println("=======================================================");
                System.out.print("Jumlah Penarikan : ");
                penarikan = scan.nextDouble();
                tarikNominal(penarikan);
                break;
            default:
                System.out.println("\tPilihan Yang Anda masukan salah");
                tarik();
        }
    }
 
    public void tarikNominal(double nominal) {
        double saldo = atm.getSaldo();
        if (atm.getSaldo() < 50000) {
            System.out.println("\tMaaf Saldo Anda tidak mencukupi.");
        } else {
            saldo -= nominal;
            if (saldo < minSaldo) {
                System.out.println("\tMaaf, jumlah penarikan terlalu besar");
                System.out.println("\t    Sisa saldo tidak mencukupi");
            } else {
                atm.setSaldo(saldo);
                System.out.println("Anda telah berhasil melakukan penarikan sebesar : " + nominal);
                System.out.println("\t       Sisa Saldo adalah :" + saldo);
            }
            transaksiLagi();
        }
    }
 
    public void pembayaran() {
        String warn;
        double saldo = atm.getSaldo();
        Scanner scan = new Scanner(System.in);
        System.out.println("=======================================================");
        System.out.print("|");
        System.out.print("\t           Pembayaran                         |");
        System.out.println();
        System.out.println("=======================================================");
        System.out.print("|");
        System.out.print("\t       > Pilih Transaksi <                    |");
        System.out.println();
        System.out.print("|");
        System.out.print(" [1] Tagihan Listrik          [2] Tagihan Telefon    |");
        System.out.println();
        System.out.println("=======================================================");
        System.out.print("\t         Masukan pilihan Anda : ");
        pil = s.nextInt();
        switch (pil) {
            case 1:
                System.out.println("=======================================================");
                System.out.print("|");
                System.out.print("\t            Tagihan Listrik                   |"
                        + "                |");
                System.out.println();
                System.out.println("=======================================================");
                System.out.println("No. Pembayaran : 278889192828");
                System.out.println("Tanggal pembayaran : 20-22 November 2014");
                System.out.println("Jumlah Biaya : Rp.200.000");
                System.out.print("\t      Lakukan Pembayaran ? [y/n] ");
                warn = scan.nextLine();
                if (warn.equalsIgnoreCase("y")) {
                    if (atm.getSaldo() < 50000) {
                        System.out.println("\tMaaf Saldo Anda tidak mencukupi.");
                    } else {
                        saldo -= 200000;
                        if (saldo < minSaldo) {
                            System.out.println("\tMaaf, jumlah pembayaran terlalu besar");
                            System.out.println("\t    Sisa saldo tidak mencukupi");
                        } else {
                            atm.setSaldo(saldo);
                            System.out.println("Anda telah berhasil melakukan pembayaran sebesar : Rp. 200.000");
                            System.out.println("\t       Sisa Saldo adalah :" + saldo);
                        }
                        transaksiLagi();
                    }
                } else if (warn.equalsIgnoreCase("n")) {
                    System.out.println("=======================================================");
                    System.out.println("\tAnda Telah melakukan Pembayaran");
                    System.out.println("\t      Silahkan Ambil kartu Anda.");
                }
                break;
            case 2:
                System.out.println("=======================================================");
                System.out.print("|");
                System.out.print("\t            Tagihan Telefon                   |"
                        + "                |");
                System.out.println();
                System.out.println("=======================================================");
                System.out.println("No. Pembayaran : TL-9877767788");
                System.out.println("Tanggal pembayaran : 19-20 November 2014");
                System.out.println("Jumlah Biaya : Rp.347.000");
                System.out.print("\t      Lakukan Pembayaran ? [y/n] ");
                warn = scan.nextLine();
                if (warn.equalsIgnoreCase("y")) {
                    if (atm.getSaldo() < 50000) {
                        System.out.println("\tMaaf Saldo Anda tidak mencukupi.");
                    } else {
                        saldo -= 347000;
                        if (saldo < minSaldo) {
                            System.out.println("\tMaaf, jumlah pembayaran terlalu besar");
                            System.out.println("\t    Sisa saldo tidak mencukupi");
                        } else {
                            atm.setSaldo(saldo);
                            System.out.println("Anda telah berhasil melakukan pembayaran sebesar : Rp. 347.000");
                            System.out.println("\t       Sisa Saldo adalah :" + saldo);
                        }
                        transaksiLagi();
                    }
                } else if (warn.equalsIgnoreCase("n")) {
                    System.out.println("=======================================================");
                    System.out.println("\tAnda Telah melakukan Pembayaran");
                    System.out.println("\t      Silahkan Ambil kartu Anda.");
                }
            default:
                pembayaran();
                break;
        }
    }
 
    //----------------------------------------------- Transaksi lagi ?
    public void transaksiLagi() {
        String warn;
        Scanner scan = new Scanner(System.in);
        System.out.println("=======================================================");
        System.out.print("Apakah Anda ingin melakukan transaksi lagi ? [y/n] ");
        warn = scan.nextLine();
        System.out.println();
        if (warn.equalsIgnoreCase("y")) {
            login();
        } else if (warn.equalsIgnoreCase("n")) {
            System.out.println("=======================================================");
            System.out.println("\tTerimakasih telah menggunakan layanan kami.");
            System.out.println("\t      Silahkan Ambil kartu Anda.");
        }
    }
}