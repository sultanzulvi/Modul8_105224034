public interface Asuransi {
    public double hitungPremi(double nilaiBarang);

    default void cetakPolis(){
        System.out.println("Polis Asuransi Aktif : Menanggung kehilangan dan kerusakan fisik sebesar 100% dari nilai barang");
    }
}
