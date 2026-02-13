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
    private int czas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCzas() {
        return czas;
    }

    public void setCzas(int czas) {
        this.czas = czas;
    }

    public int getTemperatura() {
        return temperatura;
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

    public Wypieki(String nazwa, String skladniki, int temperatura, int czas) {
        id = 0;
        this.nazwa = nazwa;
        this.skladniki = skladniki;
        this.temperatura = temperatura;
        this.czas = czas;
    }
}

