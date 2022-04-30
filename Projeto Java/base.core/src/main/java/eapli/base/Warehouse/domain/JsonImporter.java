package eapli.base.Warehouse.domain;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import eapli.base.Warehouse.repositories.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.repositories.TransactionalContext;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonImporter
{
    private final TransactionalContext txCtx = PersistenceContext.repositories()
            .newTransactionalContext();

    private static final AGVDockRepository agvDockRepository = PersistenceContext.repositories().agvDock();
    private static final AisleRepository aisleRepository = PersistenceContext.repositories().aisle();
    private static final RowRepository rowRepository = PersistenceContext.repositories().row();
    private static final ShelfRepository shelfRepository = PersistenceContext.repositories().shelf();
    private static final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();


    public Warehouse importer(String fileName)
    {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName+".json"))
        {

            //Read JSON file

            JSONArray warehousePlant = (JSONArray)jsonParser.parse(reader);

            //Iterate over employee array

            Warehouse warehouse=null;

          //  warehousePlant.forEach( wh -> parsewarehousePlant( (JSONObject) wh ) );

            for (Object object :  warehousePlant){
                JSONObject jSonO= (JSONObject) object;
                warehouse= parsewarehousePlant(jSonO);
            }

            return warehouse;

        } catch (IOException | ParseException e) {
            throw new IllegalArgumentException("Invalid file name!");
        }
    }

    private static Warehouse parsewarehousePlant(JSONObject warehousePlant)
    {
        String whName = (String) warehousePlant.get("Warehouse");

        long whLength = (Long) warehousePlant.get("Length");

        long whWidth = (Long) warehousePlant.get("Width");

        long whSquare = (Long) warehousePlant.get("Square");
        String whUnit = (String) warehousePlant.get("Unit");

        final WarehouseBuilder newWarehouse = new WarehouseBuilder(whName,whLength,whWidth,whSquare,whUnit/*,aisleSet,agvDockSet*/);
        Warehouse warehouse = newWarehouse.build();

        warehouseRepository.save(warehouse);

        JSONArray aisles = (JSONArray) warehousePlant.get("Aisles");
        Set<Aisle> aisleSet = new HashSet<>();

        for (Object aisle : aisles) {


            JSONObject oAisle=(JSONObject) aisle;
            //id aisle
            long idAisle= (long) oAisle.get("Id");

            JSONObject begin = (JSONObject) oAisle.get("begin");

            //begin object
            long lsquareBegin =  (long)begin.get("lsquare");
            long wsquareBegin =  (long)begin.get("wsquare");

            JSONObject end = (JSONObject) oAisle.get("end");
            //end object
            long lsquareEnd =  (long)end.get("lsquare");
            long wsquareEnd =  (long)end.get("wsquare");

            JSONObject depth = (JSONObject) oAisle.get("depth");


            //depth object
            long lsquareDepth =  (long)depth.get("lsquare");
            long wsquareDepth =  (long)depth.get("wsquare");

            //aisle accessibility
            String aisleAccess= (String) oAisle.get("accessibility");

            JSONArray rows = (JSONArray) oAisle.get("rows");

               final AisleBuilder newAisle = new AisleBuilder(idAisle,lsquareBegin,wsquareBegin,lsquareEnd,wsquareEnd,lsquareDepth,wsquareDepth,aisleAccess/*,rowSet*/,warehouse);
               Aisle corredor = newAisle.build();
                 aisleRepository.save(corredor);


            Set<Section> sectionSet = new HashSet<>();
            for (Object row : rows) {

                JSONObject oRow=(JSONObject) row;
                //id Row
                long idRow= (long) oRow.get("Id");
                JSONObject beginRow = (JSONObject) oRow.get("begin");

                //beginRow object
                long lsquareBeginRow =  (long)beginRow.get("lsquare");
                long wsquareBeginRow =  (long)beginRow.get("wsquare");

                JSONObject endRow = (JSONObject) oRow.get("end");
                //endRow object
                long lsquareEndRow =  (long)endRow.get("lsquare");
                long wsquareEndRow =  (long)endRow.get("wsquare");
                //Shelves
                long numberShelves= (long) oRow.get("shelves");
                    final RowBuilder newRow = new RowBuilder(idRow,lsquareBeginRow,wsquareBeginRow,lsquareEndRow,wsquareEndRow,corredor);
                    Section fila = newRow.build();
                    rowRepository.save(fila);

                Set<Shelf> shelfSet = new HashSet<>();
                for (int i=0; i<numberShelves;i++){
                    final ShelfBuilder newShelf= new ShelfBuilder(i+1, fila, corredor);
                    Shelf shelf= newShelf.build();
                    shelfRepository.save(shelf);
                    shelfSet.add(shelf);
                }




                //    rowSet.add(fila);

            }


            //    aisleSet.add(corredor);

        }

        JSONArray agvDocks = (JSONArray) warehousePlant.get("AGVDocks");
        Set<AGVDock> agvDockSet = new HashSet<>();
        for (Object agvD : agvDocks) {
            JSONObject oAGVD=(JSONObject) agvD;
            //id aisle
            String idAGVD= (String) oAGVD.get("Id");
            JSONObject begin = (JSONObject) oAGVD.get("begin");
            //begin object
            long lsquareBegin =  (long)begin.get("lsquare");
            long wsquareBegin =  (long)begin.get("wsquare");
            JSONObject end = (JSONObject) oAGVD.get("end");
            //end object
            long lsquareEnd =  (long)end.get("lsquare");
            long wsquareEnd =  (long)end.get("wsquare");
            JSONObject depth = (JSONObject) oAGVD.get("depth");
            //depth object
            long lsquareDepth =  (long)depth.get("lsquare");
            long wsquareDepth =  (long)depth.get("wsquare");
            //aisle accessibility
            String agvAccess= (String) oAGVD.get("accessibility");

            final AGVDockBuilder newAGVDocker = new AGVDockBuilder(idAGVD,lsquareBegin,wsquareBegin,lsquareEnd,wsquareEnd,lsquareDepth,wsquareDepth,agvAccess,warehouse);
            AGVDock agvDocker = newAGVDocker.build();
            agvDockRepository.save(agvDocker);
            agvDockSet.add(agvDocker);

        }



        return warehouse;
    }

}
