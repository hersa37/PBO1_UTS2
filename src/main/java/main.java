import interfaces.Berbiaya;
import interfaces.JumlahTerjual;
import karyawan.*;
import cat.*;

public class main {

    public static void main(String[] args){
        int gajiPokokSales = 3000000;

        Karyawan[] daftarKaryawan = new Karyawan[5];
        Nota[] daftarNota = new Nota[5];
        // karyawan : echa -> 1234, bernardus -> 3456, Kristha ->3456
        // jotun : 25,nippon : 14,dulux : 7

        //Data Karyawan
        Sales hermas = new Sales("Hermas", "S03");
        hermas.setGajiPokok(gajiPokokSales);
        daftarKaryawan[0] = hermas;

        Sales echa = new Sales("Echa", "S01");
        echa.setGajiPokok(gajiPokokSales);
        daftarKaryawan [1] = echa;

        Sales bernardus =  new Sales ("Bernardus", "S02");
        bernardus.setGajiPokok(gajiPokokSales);
        daftarKaryawan [2] = bernardus;

        Manajer kristha = new Manajer("Kristha", "M01");
        kristha.setGajiPokok(4000000);
        kristha.setTunjangan(2500000);
        daftarKaryawan [3] = kristha;

        Sales hersa = new Sales("Hersa", "S04");
        hersa.setGajiPokok(gajiPokokSales);
        daftarKaryawan[4] = hersa;


        daftarNota[0] = new Nota("N01", echa);
        daftarNota[0].addCat(new Grosir(NamaCat.JOTUN, 15));
        daftarNota[0].addCat(new Ecer(NamaCat.DULUX, 4));

        Cat[] listCat1 = new Cat[Nota.TOTAL_CAT_NOTA];
        listCat1[0] = new Ecer(NamaCat.NIPPON, 2);
        listCat1[1] = new Ecer(NamaCat.DULUX, 4);
        listCat1[2] = new Ecer(NamaCat.JOTUN, 2);
        daftarNota[1] = new Nota("N02", bernardus);
        daftarNota[1].setCat(listCat1, 3);

        daftarNota[2] = new Nota("N03", hermas);
        daftarNota[2].addCat(new Grosir(NamaCat.NIPPON, 20));
        daftarNota[2].addCat(new Grosir(NamaCat.JOTUN, 12));

        daftarNota[3] = new Nota("N04", hersa);
        daftarNota[3].addCat(new Ecer(NamaCat.JOTUN, 4));

        daftarNota[4] = new Nota("N05", echa);
        daftarNota[4].addCat(new Ecer(NamaCat.DULUX, 6));


        //looping dan seleksi untuk daftar karyawan
        String managerString = "Manager : \n";
        String salesString = "Sales : \n";

        System.out.println("Toko Maju Kena Mundur Kena");
        for(int i = 0; i< daftarKaryawan.length; i++) {
            if (daftarKaryawan[i] instanceof Manajer) {
                managerString += daftarKaryawan[i].toString() + "\n";
            }
            if (daftarKaryawan[i] instanceof Sales) {
                salesString += daftarKaryawan[i].toString() + "\n";
            }
        }

        System.out.println(managerString);
        System.out.println(salesString);

        //Penjualan per sales dan per cat
        JumlahTerjual[] terjual = new JumlahTerjual[100];
        int lastIndex = 0;

        for(int i = 0;i <daftarKaryawan.length;i++){
            if(daftarKaryawan[i] instanceof Sales){
                terjual[lastIndex] = (JumlahTerjual) daftarKaryawan[i];
                lastIndex++;
            }
        }

        for(int i = 0;i< daftarNota.length;i++){
            for(int j = 0; j < daftarNota[i].getJumlahEntry();j++){
                terjual[lastIndex] = daftarNota[i].getCat()[j];
                lastIndex++;
            }
        }

        //Cetak array jumlahTerjual
        System.out.println("Daftar Penjualan Bulanan");
        System.out.println("- Daftar Penjualan Sales :");
        for(int i = 0; i <lastIndex ; i++){
            System.out.println(terjual[i].toString()+"\n Jumlah terjual: "
                    +terjual[i].getJumlahTerjual()
            );
        }

        //Sales penjualan terbanyak
        Sales salesMax = new Sales("","");
        for(int i = 0; i < lastIndex;i++){
            if(terjual[i] instanceof Sales){
                if(terjual[i].getJumlahTerjual() > salesMax.getJumlahTerjual()){
                    salesMax = (Sales) terjual[i];
                }
            }
        }
        System.out.println("\nPenjualan Sales Terbanyak :");
        System.out.println(salesMax);

        //Cat penjualan terbanyak
        int jotun = 0;
        int nippon = 0;
        int dulux = 0;
        System.out.println("\nPenjualan Cat Terbanyak :");
        for(int i = 0; i<lastIndex;i++){
            if(terjual[i] instanceof Cat){
                switch (((Cat) terjual[i]).getMerek()){
                    case DULUX -> dulux += terjual[i].getJumlahTerjual();
                    case JOTUN -> jotun += terjual[i].getJumlahTerjual();
                    case NIPPON -> nippon += terjual[i].getJumlahTerjual();
                }
            }
        }
        if(jotun > nippon && jotun > dulux){
            System.out.println("Jotun terjual terbanyak dengan jumlah: " + jotun);
        }
        if(nippon > jotun && nippon > dulux){
            System.out.println("Nippon terjual terbanyak dengan jumlah: " + nippon);
        }
        if(dulux > nippon && dulux > jotun){
            System.out.println("Dulux terjual terbanyak dengan jumlah: " + dulux);
        }

        //Berbiaya
        Berbiaya[] berbiaya = new Berbiaya[100];
        lastIndex = 0;
        for(int i = 0;i <daftarKaryawan.length;i++){
            berbiaya[lastIndex] = daftarKaryawan[i];
            lastIndex++;
        }

        for(int i = 0;i< daftarNota.length;i++){
            for(int j = 0; j < daftarNota[i].getJumlahEntry();j++){
                berbiaya[lastIndex] = daftarNota[i].getCat()[j];
                lastIndex++;
            }
        }

        //Gaji tertinggi
        Karyawan karyawanMax=null;
        for(int i = 0; i < lastIndex;i++){
            if(berbiaya[i] instanceof Karyawan){
                if(karyawanMax != null){
                    if(karyawanMax.getBiaya() > berbiaya[i].getBiaya()){
                        karyawanMax = (Karyawan) berbiaya[i];
                    }
                } else {
                    karyawanMax = (Karyawan) berbiaya[i];
                }
            }
        }
        System.out.println("karyawan max");
        System.out.println(karyawanMax);

        //Keuntungan
        int profit = 0;

        for(int i = 0; i<lastIndex;i++){
            if(berbiaya[i] instanceof Karyawan){
                profit -= berbiaya[i].getBiaya();
            } else if(berbiaya[i] instanceof Cat){
                profit += berbiaya[i].getBiaya();
            }
        }

        System.out.println("profit " + profit);

    }


}
