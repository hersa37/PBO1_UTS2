package karyawan;

import interfaces.Berbiaya;

abstract class Karyawan implements Berbiaya {
    protected int gajiPokok;
    private String nama;
    private String id;

    public Karyawan(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
