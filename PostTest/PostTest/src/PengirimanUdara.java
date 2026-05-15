public class PengirimanUdara extends LayananPengiriman implements LacakKargo, Asuransi {
    private String nomorPenerbangan;
    private String statusSaatIni;
    private double nilaiBarang;

    public PengirimanUdara(String noResi, double beratBarang, double jarakTempuhdalam, String nomorPenerbangan, double nilaiBarang){
        super(noResi, beratBarang, jarakTempuhdalam);
        this.nomorPenerbangan = nomorPenerbangan;
        this.statusSaatIni = "Menunggu Jadwal Penerbangan";
        this.nilaiBarang = nilaiBarang;
    }

    @Override
    public double hitungOngkosKirim(){
        double tarifUdara = (beratBarang*25000) + (jarakTempuhdalam*5000);
        return tarifUdara;
    }

    @Override
    public double hitungPremi(double nilaiBarang) {
        double premi = nilaiBarang * 0.03;
        return premi;
    }

    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return "Status Saat Ini: " + statusSaatIni;
    }

    public double getnilaiBarang() {
        return nilaiBarang;
    }
}
