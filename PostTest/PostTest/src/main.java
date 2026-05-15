import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws Exception {
        
        ArrayList<LayananPengiriman> daftarPengiriman = new ArrayList<>();

        PengirimanDarat darat = new PengirimanDarat("DRT-001", 50, 100, "Tronton");
        daftarPengiriman.add(darat);
        PengirimanUdara udara = new PengirimanUdara("UDR-999", 10, 800, "GA-123", 5000000);
        daftarPengiriman.add(udara);

        darat.updateStatus("Sedang di Tol Cipali");
        udara.updateStatus("Transit di Bandara Soekarno-Hatta");

        for (LayananPengiriman pengiriman : daftarPengiriman){
            pengiriman.cetakResi();

            double ongkosKirim = pengiriman.hitungOngkosKirim();
            double totalBiaya = ongkosKirim;

            if(pengiriman instanceof LacakKargo){
                LacakKargo lacak = (LacakKargo) pengiriman;
                System.out.println("Status Lokasi : " + lacak.cekLokasiTerakhir());
            }

            if(pengiriman instanceof Asuransi){
                Asuransi asuransi = (Asuransi) pengiriman;
                asuransi.cetakPolis();
                if(pengiriman instanceof PengirimanUdara){
                    double nilai = ((PengirimanUdara) pengiriman).getnilaiBarang();
                    double premi = asuransi.hitungPremi(nilai);
                    
                    System.out.println("Biaya Asuransi : Rp " + premi);
                    totalBiaya += premi;
                }
            }

            System.out.println("Ongkos Kirim : Rp " + pengiriman.hitungOngkosKirim());
            System.out.println("Total Biaya : Rp " + totalBiaya);
        }
    }
}
