public class EWallet extends Pembayaran implements Keamanan {
    private String nomorHP;

    public EWallet(String namaPembayar, double nominal, String nomorHP){
        super(namaPembayar, nominal);
        this.nomorHP = nomorHP;
    }

    @Override
    public void prosesPembayaran(){
        System.out.println("Total Tagihan : " + nominal + "\n");
    }

    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi PIN berhasil");
        return true;
    }

}
