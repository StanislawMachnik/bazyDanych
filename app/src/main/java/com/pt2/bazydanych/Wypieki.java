package com.pt2.bazydanych;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "wypieki_tabela")
public class Wypieki {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nazwa;
    private String skladniki;
    @ColumnInfo(name = "tempertaura pieczenia")
    private int temperatura;
    @ColumnInfo(name = "czas pieczenia")
    private int czas_pieczenia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getTemperatura() {
        return temperatura;
    }

    public int getCzas_pieczenia() {
        return czas_pieczenia;
    }

    public void setCzas_pieczenia(int czas_pieczenia) {
        this.czas_pieczenia = czas_pieczenia;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(String skladniki) {
        this.skladniki = skladniki;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Wypieki(String nazwa, String skladniki, int temperatura, int czas_pieczenia) {
        id = 0;
        this.nazwa = nazwa;
        this.skladniki = skladniki;
        this.temperatura = temperatura;
        this.czas_pieczenia = czas_pieczenia;
    }

    @Override
    public String toString() {
        return "Wypieki{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", skladniki='" + skladniki + '\'' +
                ", temperatura=" + temperatura +
                ", czas_pieczenia=" + czas_pieczenia +
                '}';
    }
}

