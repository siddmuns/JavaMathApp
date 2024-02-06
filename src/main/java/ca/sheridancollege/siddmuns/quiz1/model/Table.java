package ca.sheridancollege.siddmuns.quiz1.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Table {
    private List<Integer> table;

    public Table() {
        this.table = new ArrayList<>();
        generateRandomValues();
    }

    public void multiplyRows(int n) {
        table.replaceAll(element -> element * n);
    }

    public void generateRandomValues() {
        table.clear();
        Random random = new Random();
        int numberOfRows = random.nextInt(1,10);
        for (int i = 0; i < numberOfRows; i++) {
            table.add(random.nextInt(1,10));
        }
    }
}
