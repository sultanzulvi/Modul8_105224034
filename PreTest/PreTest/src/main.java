public class main {
    public static void main(String[] args) throws Exception {
        Programmer programmer = new Programmer ("Sultan", 300.000);
        System.out.println("Nama : " + programmer.nama);
        System.out.println("Gaji : " + programmer.hitungGaji());
    }
}
