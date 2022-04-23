package eapli.base.Warehouse.domain;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonImporter
{

    public Warehouse importer(String fileName)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName+".json"))
        {
            //Read JSON file

            JSONArray warehousePlant = (JSONArray)jsonParser.parse(reader);
            System.out.println("c");
            System.out.println(warehousePlant);

            //Iterate over employee array

            warehousePlant.forEach( wh -> parsewarehousePlant( (JSONObject) wh ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void parsewarehousePlant(JSONObject warehousePlant)
    {


        //Get employee first name
        String firstName = (String) warehousePlant.get("Warehouse");
        System.out.println(firstName);

        //Get employee last name
        long lastName = (Long) warehousePlant.get("Length");
        System.out.println(lastName);


    }

}
