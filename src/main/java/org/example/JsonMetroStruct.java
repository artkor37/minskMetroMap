package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class JsonMetroStruct {
    //todo Map линии, станции на линии
    public Map<String, List<Station>> stations = new HashMap<>();

    //todo connections пары переходов
    public List<List<Connection>> connections = new ArrayList<>();

    //todo список линий
    public List<Line> lines = new ArrayList<>();

    public void addConnection() {


        connections.add(new ArrayList<Connection>());
        connections.get(0).add(new Connection("Автозаводская линия", "Купаловская"));
        connections.get(0).add(new Connection("Московская линия", "Октябрьская"));
        // System.out.println(connections);

        connections.add(new ArrayList<Connection>());
        connections.get(1).add(new Connection("Автозаводская линия", "Фрунзенская"));
        connections.get(1).add(new Connection("Зеленолужская линия", "Юбилейная площадь"));
        // System.out.println(connections);

        connections.add(new ArrayList<Connection>());
        connections.get(2).add(new Connection("Зеленолужская линия", "Вокзальная"));
        connections.get(2).add(new Connection("Московская линия", "Площадь Ленина"));
        // System.out.println(connections);
        for (List<Connection> c : connections) {
            System.out.println(c);
        }
    }
}
