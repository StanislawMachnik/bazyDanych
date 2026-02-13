package com.pt2.bazydanych;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WypiekiDao {
    @Insert
    public void wstawWypiekDoBazy(Wypieki wypieki);

    @Insert
    public void wstawKilkaWypiekDoBazy(Wypieki ...wypieki);

    @Delete
    public void usunZBazy(Wypieki wypieki);

    @Update
    public void zaktualizuj(Wypieki wypieki);

    @Query("Select * from wypieki_tabela")
    List<Wypieki> zwrocWszystkieWypiekiZBazy();

    @Query("Select nazwa from wypieki_tabela where `czas pieczenia` < :czas")
    List<String> zwrocNazwyWypiekow(int czas);
}
