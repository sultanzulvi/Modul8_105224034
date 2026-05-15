import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Pembayaran> daftarPembayaran = new ArrayList<>();

        daftarPembayaran.add(new KartuKredit("Sultan", 120000, "08123456"));
        daftarPembayaran.add(new EWallet("Sultan", 200000, "081236754"));

        for (Pembayaran pembayaran : daftarPembayaran) {
            pembayaran.tampilkanDetail();

            if (pembayaran instanceof Keamanan){
                Keamanan keamanan = (Keamanan) pembayaran;

                if(keamanan.autentikasi()){
                    pembayaran.prosesPembayaran();
                } else {
                    System.out.println("Autentikasi gagal. Pembayaran tidak diproses.");
                }
            }
        }
    }
}
