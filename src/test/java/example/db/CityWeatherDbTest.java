package example.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CityWeatherDbTest {
    private static final CityWeatherDb db = new CityWeatherDb();

    @Test
    void shouldChangeEntity() {

        //given
        final long id = 1L;
        String cityName = "Wroclaw";
        CityDataEntity cde = new CityDataEntity();
        cde.setId(id);
        cde.setName(cityName);
        db.add(cde);

        final CityDataEntity changedCde = new CityDataEntity();
        changedCde.setId(id);
        final String newName = cityName + "xxxx";
        changedCde.setName(newName);

        //when
        db.change(changedCde);

        //then
        final Optional<CityDataEntity> resOpt = db.get(id);
        final String name = resOpt.orElseThrow().getName();
        Assertions.assertEquals(name, newName);
    }

    @Test
    void shouldGetId(){
        //given - rzeczy, ktore test ma otrzymac
        final long id = 1L;
        String cityName = "Wroclaw";
        CityDataEntity cde = new CityDataEntity();
        cde.setId(id);
        cde.setName(cityName);
        db.add(cde);
        //when
        final Optional<CityDataEntity> resOpt = db.get(id);
        final String name = resOpt.orElseThrow().getName();

        //then
        Assertions.assertEquals(name, cityName);
    }

    @Test
    void should_delete_entry_from_db(){
        //given
        final long id = 1L;
        String cityName = "Wroclaw";
        CityDataEntity cde = new CityDataEntity();
        cde.setId(id);
        cde.setName(cityName);
        db.add(cde);

        //when
        db.remove(id);

        //then
        final var resultOpt = db.get(id);
        final boolean isPresent = resultOpt.isPresent();
        Assertions.assertFalse(isPresent);
    }



}