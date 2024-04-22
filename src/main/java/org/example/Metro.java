package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Metro {
    private Station stations;
    private List<List<Connections>> connections;
    private List<Line> lines;

    public void addLine(Line line){
        if(lines == null){
            lines = new ArrayList<>();
        }
        lines.add(line);
    }

    public Metro(List<Line> lines) {
        this.lines = lines;
    }
}
