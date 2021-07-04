import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadPass {

    public List<Passenger> readPassengersJsonFile() throws IOException
    {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Passenger> passengerList = new ArrayList<>();
        passengerList = objectMapper.readValue(new FileInputStream("D:\\AI\\1-Technical\\09-Java&UML\\TitanicJava\\data\\titanic_csv.json"), new TypeReference<List<Passenger>>(){});
        return passengerList;
    }
}