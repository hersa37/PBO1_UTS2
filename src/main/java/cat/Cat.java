package cat;

import interfaces.Berbiaya;
import interfaces.Penjualan;

public abstract class Cat implements Penjualan, Berbiaya {

    protected int jumlahPenjualan;
    protected int hargaPokok;
    protected NamaCat merek;

    public Cat(NamaCat merek, int hargaPokok){
        this.merek = merek;
        this.hargaPokok = hargaPokok;
    }
    public int getJumlahPenjualan(){
        return jumlahPenjualan;
    }

    public abstract void setJumlahPenjualan(int penjualan);

    public int getHargaPokok(){
        return hargaPokok;
    }

    public void setHargaPokok(int hargaPokok) {
        this.hargaPokok = hargaPokok;
    }

}
