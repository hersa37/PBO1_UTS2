package cat;

public class Grosir extends Cat{

    private int marginGrosir;
    private int minJumlah;

    public Grosir(NamaCat merek, int hargaPokok, int margin){
        super(merek, hargaPokok);
        marginGrosir = margin;
    }


    @Override
    public void setJumlahPenjualan(int penjualan) {
        if(penjualan >= minJumlah){
            this.jumlahPenjualan = penjualan;
        }
    }

    @Override
    public int getBiaya() {
        return 0;
    }
}
