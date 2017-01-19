package atmprogram;

public class AtmClass {     //Nama Class
    int pin;                //Tipe Data Integer (PIN)
    double saldo;           //Tipe Data Double (Saldo)

//--------------------------- setter


    public void setPin(int password) {
        this.pin = 1234;                    //Perintah Setting Passwor atau PIN
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;                 //Perintah ditujukan pada saldo
    }



//------------------------------------ getter


    public int getPin() {                   //Get Pin atau mengambil data pada variabel PIN
        return pin;                         //Jika salah maka harus memasukkan kembali PIN yang benar
    }

    public double getSaldo() {
        return saldo;
    }
}