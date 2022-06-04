package cat;

public class Ecer extends Cat{
    public int marginEcer;

    public Ecer(NamaCat merek, int hargaPokok, int margin){
        super(merek, hargaPokok);
        marginEcer = margin;
        this.jumlahPenjualan = jumlahPenjualan;
    }

    public int getBiaya() {
        return hargaPokok + marginEcer;
    }
    public void setPenjualan(int penjualan){
        this.jumlahPenjualan = penjualan;
    }
    public int getMarginEcer() {
        return marginEcer;
    }

    public void setMarginEcer(int marginEcer) {
        this.marginEcer = marginEcer;
    }

    @Override
    public void setJumlahPenjualan(int penjualan) {
        jumlahPenjualan = jumlahPenjualan;
    }
}
