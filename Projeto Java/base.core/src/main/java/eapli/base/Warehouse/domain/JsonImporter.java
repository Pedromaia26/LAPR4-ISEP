package eapli.base.Warehouse.domain;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

        String whName = (String) warehousePlant.get("Warehouse");
        System.out.println(whName);

        long whLength = (Long) warehousePlant.get("Length");
        System.out.println(whLength);

        long whWidth = (Long) warehousePlant.get("Width");
        System.out.println(whWidth);

        long whSquare = (Long) warehousePlant.get("Square");
        System.out.println(whSquare);

        String whUnit = (String) warehousePlant.get("Unit");
        System.out.println(whUnit);

        JSONArray aisles = (JSONArray) warehousePlant.get("Aisles");
        Set<Aisle> aisleSet = new HashSet<>();
        for (Object aisle : aisles) {
            System.out.println(aisle);

            JSONObject oAisle=(JSONObject) aisle;
            //id aisle
            long idAisle= (long) oAisle.get("Id");
            System.out.println(idAisle);

            JSONObject begin = (JSONObject) oAisle.get("begin");

            //begin object
            long lsquareBegin =  (long)begin.get("lsquare");
            long wsquareBegin =  (long)begin.get("wsquare");

            System.out.println(lsquareBegin);
            System.out.println(wsquareBegin);

            JSONObject end = (JSONObject) oAisle.get("end");
            //end object
            long lsquareEnd =  (long)end.get("lsquare");
            long wsquareEnd =  (long)end.get("wsquare");

            System.out.println(lsquareEnd);
            System.out.println(wsquareEnd);

            JSONObject depth = (JSONObject) oAisle.get("depth");

            //depth object
            long lsquareDepth =  (long)depth.get("lsquare");
            long wsquareDepth =  (long)depth.get("wsquare");
            System.out.println(lsquareDepth);
            System.out.println(wsquareDepth);

            //aisle accessibility
            String aisleAccess= (String) oAisle.get("accessibility");
            System.out.println(aisleAccess);

            JSONArray rows = (JSONArray) oAisle.get("rows");
            Set<Row> rowSet = new HashSet<>();
            for (Object row : rows) {
                System.out.println(row);

                JSONObject oRow=(JSONObject) row;
                //id Row
                long idRow= (long) oRow.get("Id");
                System.out.println(idRow);
                JSONObject beginRow = (JSONObject) oRow.get("begin");

                //beginRow object
                long lsquareBeginRow =  (long)beginRow.get("lsquare");
                long wsquareBeginRow =  (long)beginRow.get("wsquare");
                System.out.println(lsquareBeginRow);
                System.out.println(wsquareBeginRow);

                JSONObject endRow = (JSONObject) oRow.get("end");
                //endRow object
                long lsquareEndRow =  (long)endRow.get("lsquare");
                long wsquareEndRow =  (long)endRow.get("wsquare");
                System.out.println(lsquareEndRow);
                System.out.println(wsquareEndRow);

                //Shelves
                long numberShelves= (long) oRow.get("shelves");
                System.out.println(numberShelves);
                Set<Shelf> shelfSet = new HashSet<>();
                for (int i=0; i<numberShelves;i++){
                    final ShelfBuilder newShelf= new ShelfBuilder(i+1);
                    Shelf shelf= newShelf.build();
                    //repository.save(shelf)

                    shelfSet.add(shelf);
                }

                final RowBuilder newRow = new RowBuilder(idRow,lsquareBeginRow,wsquareBeginRow,lsquareEndRow,wsquareEndRow,shelfSet);
                Row fila = newRow.build();
                //repository.save
                rowSet.add(fila);

            }

            final AisleBuilder newAisle = new AisleBuilder(idAisle,lsquareBegin,wsquareBegin,lsquareEnd,wsquareEnd,lsquareDepth,wsquareDepth,aisleAccess,rowSet);
            Aisle corredor = newAisle.build();
            //repository.save
            aisleSet.add(corredor);

        }

        JSONArray agvDocks = (JSONArray) warehousePlant.get("AGVDocks");
        Set<AGVDock> agvDockSet = new HashSet<>();
        for (Object agvD : agvDocks) {
            JSONObject oAGVD=(JSONObject) agvD;
            //id aisle
            String idAGVD= (String) oAGVD.get("Id");
            System.out.println(idAGVD);
            JSONObject begin = (JSONObject) oAGVD.get("begin");
            //begin object
            long lsquareBegin =  (long)begin.get("lsquare");
            long wsquareBegin =  (long)begin.get("wsquare");
            System.out.println(lsquareBegin);
            System.out.println(wsquareBegin);
            JSONObject end = (JSONObject) oAGVD.get("end");
            //end object
            long lsquareEnd =  (long)end.get("lsquare");
            long wsquareEnd =  (long)end.get("wsquare");
            System.out.println(lsquareEnd);
            System.out.println(wsquareEnd);
            JSONObject depth = (JSONObject) oAGVD.get("depth");
            //depth object
            long lsquareDepth =  (long)depth.get("lsquare");
            long wsquareDepth =  (long)depth.get("wsquare");
            System.out.println(lsquareDepth);
            System.out.println(wsquareDepth);
            //aisle accessibility
            String agvAccess= (String) oAGVD.get("accessibility");
            System.out.println(agvAccess);
            final AGVDockBuilder newAGVDocker = new AGVDockBuilder(idAGVD,lsquareBegin,wsquareBegin,lsquareEnd,wsquareEnd,lsquareDepth,wsquareDepth,agvAccess);
            AGVDock agvDocker = newAGVDocker.build();
            //repository.save
            agvDockSet.add(agvDocker);

        }

        final WarehouseBuilder newWarehouse = new WarehouseBuilder(whName,whLength,whWidth,whSquare,whUnit,aisleSet,agvDockSet);
        Warehouse warehouse = newWarehouse.build();
        //repository.save

    }

}
