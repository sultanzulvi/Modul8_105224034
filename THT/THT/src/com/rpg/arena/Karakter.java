package com.rpg.arena;

public abstract class Karakter implements AksiBertarung { // kelas abstrak untuk karakter dalam arena, seperti pejuang, penyihir, dan pemanah

    protected String nama;
    protected int hp;
    protected int baseDamage;
    protected boolean isDefending;

    public Karakter(String nama, int hp, int baseDamage) { // konstruktor untuk inisialisasi karakter
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false;
    }

    public void terimaDamage(int damage){ // metode untuk menerima damage, dengan mempertimbangkan apakah karakter sedang bertahan atau tidak
        int damageDiterima = damage;

        if(this.isDefending){ // jika karakter sedang bertahan, damage yang diterima dikurangi setengah
            damageDiterima = damage / 2;
            this.isDefending = false;
            System.out.println(this.nama + " bertahan dan mengurangi damage menjadi " + damageDiterima);
        }

        this.hp -= damageDiterima; // kurangi HP karakter dengan damage yang diterima
        System.out.println(this.nama + " menerima " + damageDiterima + " damage. HP sekarang: " + this.hp);
    }

    public abstract void tampilkanStatus(); // metode abstrak untuk menampilkan status karakter, akan diimplementasikan di kelas turunan

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }

    public int getBaseDamage() { return baseDamage; }
    public void setBaseDamage(int baseDamage) { this.baseDamage = baseDamage; }

    public boolean isDefending() { return isDefending; }
    public void setDefending(boolean defending) { isDefending = defending; }

    // implementasi metode dari interface AksiBertarung akan dilakukan di kelas turunan, karena setiap karakter mungkin memiliki cara yang berbeda dalam menyerang dan bertahan
}
