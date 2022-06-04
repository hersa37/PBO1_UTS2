package karyawan;

public class Manajer extends Karyawan{

    private int tunjangan = 2500000;

    public Manajer(String nama, String id){
        super(nama, id);
    }

    public int getBiaya(){
        return tunjangan+gajiPokok;
    }
}
