public class PengirimanDarat extends LayananPengiriman implements LacakKargo{
    private String jenisTruk;
    private String statusSaatIni;

    public PengirimanDarat(String noResi, double beratBarang, double jarakTempuhdalam, String jenisTruk){
        super(noResi, beratBarang, jarakTempuhdalam);
        this.jenisTruk = jenisTruk;
        this.statusSaatIni = "Menunggu Kurir";
    }

    @Override
    public double hitungOngkosKirim() {
        double tarif = (beratBarang*5000) + (jarakTempuhdalam*2000);
        if(jenisTruk.equalsIgnoreCase("tronton")){
            tarif += 150000;
        }
        return tarif;
    }

    @Override
    public void updateStatus(String status) { 
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return "Status Saat Ini: " + statusSaatIni;
    }

}
