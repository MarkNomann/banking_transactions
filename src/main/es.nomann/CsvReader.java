package es.nomann;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CsvReader {

    private final String fullPathToFile;

    public CsvReader(String fullPathToFile) {
        this.fullPathToFile = fullPathToFile;
    }

    public Map<String, List<String>> readFile(int limit) {
        HashMap<String, List<String>> map = new HashMap<>();
        try (BufferedReader files = Files.newBufferedReader(Path.of(fullPathToFile))) {
            var keys = files.lines().findFirst().orElse("").split(",");
            var data = files.lines().map(line -> Arrays.asList(line.split(","))).limit(limit).toList();

            List<String> trx = new ArrayList<>();
            for (int i = 0; i < keys.length; i++) {
                for (int j = 0; j < limit; j++) {
                    var tmp = Arrays.stream(data.get(j).toString().split(",")).toList();
                    trx.add(tmp.get(i));
                }

                map.put(keys[i], trx);
                trx = new ArrayList<>();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
