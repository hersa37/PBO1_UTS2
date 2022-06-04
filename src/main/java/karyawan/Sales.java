package karyawan;

import interfaces.Penjualan;

public class Sales extends Karyawan implements Penjualan {
    public static final int KOMISI_PER_PENJUALAN=10000;
    private int penjualan;

    public Sales(String nama, String id){
        super(nama, id);
    }

    public int getJumlahPenjualan(){
        return penjualan;
    }

    public int getBiaya(){
        return (penjualan*KOMISI_PER_PENJUALAN)+gajiPokok;
    }

    public void addPenjualan(int penjualan){
        this.penjualan += penjualan;
    }
}
