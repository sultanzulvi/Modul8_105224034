abstract class LayananPengiriman {
    protected String noResi;
    protected double beratBarang;
    protected double jarakTempuhdalam;

    public LayananPengiriman(String noResi, double beratBarang, double jarakTempuhdalam){
        this.noResi = noResi;
        this.beratBarang = beratBarang;
        this.jarakTempuhdalam = jarakTempuhdalam;
    }

    public void cetakResi (){
        System.out.println("No Resi: " + noResi);
        System.out.println("Berat Barang: " + beratBarang + " kg");
        System.out.println("Jarak Tempuh: " + jarakTempuhdalam + " km");
    }

    public abstract double hitungOngkosKirim();
}
