package lesson_3;

import java.util.List;
import java.util.stream.Collectors;

public class ConnectorMapper implements Mapper<Connector, String> {
    @Override
    public String map(Connector data) {
        return data.toString();
    }

    @Override
    public List<String> map(List<Connector> listOfData) {
        return listOfData
                .stream()
                .map(Connector::toString)
                .collect(Collectors.toList());
    }
}
