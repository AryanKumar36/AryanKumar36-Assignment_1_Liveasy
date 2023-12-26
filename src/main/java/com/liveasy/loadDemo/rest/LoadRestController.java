package com.liveasy.loadDemo.rest;

import com.liveasy.loadDemo.entity.Load;
import com.liveasy.loadDemo.exceptionHandling.LoadNotFoundException;
import com.liveasy.loadDemo.service.LoadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadRestController {
    private LoadService loadService;

    public LoadRestController(LoadService theLoadService)
    {
        loadService = theLoadService;
    }

    @GetMapping
    public List<Load> findAll(){
        return loadService.findAll();
    }
    @GetMapping("/{loadId}")

    public ResponseEntity<Load> findById(@PathVariable Integer loadId)
            throws LoadNotFoundException {
        Load theLoad = loadService.findById(loadId)
                .orElseThrow(() -> new LoadNotFoundException("Load not found with id :: " +loadId));
        return  new ResponseEntity<>(theLoad, HttpStatus.OK);
    }



    @GetMapping(params = "shipperId")
    public ResponseEntity<List<Load>> finderByShipperId(@RequestParam String shipperId)
    {
        List<Load> theLoads =  loadService.findByShipperId(shipperId);

        if (theLoads.isEmpty()) {
            throw new LoadNotFoundException("No loads found for shipperId: " + shipperId);
        }

        return ResponseEntity.ok(theLoads);
    }

    @PostMapping
    public ResponseEntity<String> saveLoad(@RequestBody Load load)
    {
        loadService.save(load);
        String response = "loads details added successfully";
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable Integer loadId, @RequestBody Load updatedload)
            throws LoadNotFoundException{
        Load theLoad = loadService.findById(loadId)
                .orElseThrow(() -> new LoadNotFoundException("Load not found for the update with id :: " + loadId));

        updatedload.setId(loadId);

        theLoad.setLoadingPoint(updatedload.getLoadingPoint());
        theLoad.setUnloadingPoint(updatedload.getUnloadingPoint());
        theLoad.setProductType(updatedload.getProductType());
        theLoad.setTruckType(updatedload.getTruckType());
        theLoad.setNoOfTrucks(updatedload.getNoOfTrucks());
        theLoad.setWeight(updatedload.getWeight());
        theLoad.setComment(updatedload.getComment());
        theLoad.setDate(updatedload.getDate());
        final Load updatedPayload = loadService.save(theLoad);
        return new ResponseEntity<>(updatedload, HttpStatus.OK);


    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteById(@PathVariable Integer loadId) throws LoadNotFoundException {
        Load theLoad = loadService.findById(loadId)
                .orElseThrow(() -> new LoadNotFoundException("Load not found with id :: " +loadId));

        String message = "Deleted the load with id :: "+ loadId;
        loadService.deleteById(loadId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }





}
