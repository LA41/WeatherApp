package example.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        final CityDataEntity result = db.get(id);
        Assertions.assertEquals(result.getName(), newName);
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
        final CityDataEntity res = db.get(id);
        //then
        Assertions.assertEquals(res.getName(), cityName);

    }
}