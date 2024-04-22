package org.example;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Line2 {
    @SerializedName("станции")
    private List<String>stations2;

    public void addStation(String station){
        if(stations2 == null){
            stations2 = new ArrayList<>();
        }
        stations2.add(station);
    }
}
