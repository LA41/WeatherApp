package example.db;

import java.util.HashMap;
import java.util.Map;

public class CityWeatherDb {

    private static final Map<Long, CityDataEntity> dataBase = new HashMap<>();

    // TODO: metody do pracy nad bazą danych, dodawanie itp...
    public CityDataEntity get(Long id){
        return dataBase.get(id);
    }
    public void add(CityDataEntity entity){
        dataBase.put(entity.getId(), entity);
    }

    public void remove(CityDataEntity entity){
        dataBase.remove(entity.getId());
    }

    public CityDataEntity change(CityDataEntity cityDataEntity) {
        // wyszukac po id ? jak wyciągamy obiekt po kluczu?
        final CityDataEntity toChange = dataBase.get(cityDataEntity.getId());
        // zmodyfikowac jego pola (settery)
        toChange.setName(cityDataEntity.getName());
        toChange.setWeatherDataEntity(cityDataEntity.getWeatherDataEntity());
        // zapisać ponownie do mapy ? jak dodajemy po kluczu bwartość
        return dataBase.put(cityDataEntity.getId(), toChange);
    }
}