import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import tech.tablesaw.api.Table;


import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Chart {

        public static void main(String args[]) throws IOException
        {

            Table titanicData;
            String dataPath="D:\\AI\\1-Technical\\09-Java&UML\\TitanicJava\\data\\titanic.csv";
            titanicData = Table.read().csv(dataPath);
            System.out.println(titanicData.summary());
            List<Passenger> passengersDataset = new ReadPass().readPassengersJsonFile();

            Graphs.graphPassengerAges(passengersDataset);
            Graphs.graphPassengerClass(passengersDataset);
            Graphs.graphPassengerSurvived(passengersDataset);
            Graphs.graphPassengerNotSurvivedSex(passengersDataset);
        }

    }

