package com.example.demoSpring.controller;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController     //this class says that go and scan the file structure
public class TestController {

    List<TaskFriday> workerList = new ArrayList<>();    //this is for task Exercise (REST endpoint 2)

    @GetMapping(value = "/")    //every @RestController have @GetMapping/@PostMapping/@PutMapping, it says if anybody makes request show this: HelloWorld!
    public  String test(){      //address: localhost:8080
        return "Hello World!";
    }

    @GetMapping("hello")        //address: localhost:8080/hello
    public String test2(){
        return "midagi muud";
    }

    @GetMapping("hello/{midagi}")   //goes in: hello/dfgfdg?employeeId=89&testId=3
    public String test3(@PathVariable("midagi") String mingiTekst,
                        @RequestParam("employeeId") Integer employeeId,
                        @RequestParam(value = "testId", required = false) Integer optional){
        return mingiTekst + " :)" + employeeId;   // returns to the localhost page here
    }
    //TaskFriday_GetMapping
//    @GetMapping("worker")
//    public TaskFriday getWorker(){
//        TaskFriday w = new TaskFriday();
//        w.setSalary(2500);
//        w.setWorker("John");
//        return w;
//    }

    //TaskFriday_PostMapping
//    @PostMapping("worker")
//    public List<TaskFriday> postWorker(@RequestBody TaskFriday new_worker){
//        List<TaskFriday> workerList = new ArrayList<>();    //new empty list named 'workerList'
//        workerList.add(new_worker);     //adding
//
//        TaskFriday w = new TaskFriday();    //
//        w.setSalary(2900);
//        w.setWorker("Jane");
//        workerList.add(w);  //adds 'w' variable
//        return workerList;  //return whole list
//    }

    //Exercise (REST endpoint 2)
    //saves in Postman an worker
    @PostMapping("worker")
    public List<TaskFriday> postWorker2(@RequestBody TaskFriday new_worker){
        workerList.add(new_worker);     //adding
        return workerList;  //return whole list
    }
    //recalls the whole list of current state of workers
    @GetMapping("worker")
    public List<TaskFriday> getWorkerList() {
        return workerList;
    }

    //finds specified worker by list index !!!
    @GetMapping("worker/{id}")
    public TaskFriday getWorkerById(@PathVariable("id") int workerId) {
//        workerList.stream().filter(result -> result.getWorker().equals(workerName));        //filtering by name, hard!!!
        return workerList.get(workerId);
    }

    //overwrites an existing worker by id
    @PutMapping("worker/{id}")
    public List<TaskFriday> putWorkerById(@RequestBody TaskFriday new_worker,
                                          @PathVariable("id") int workerId){
        workerList.set(workerId, new_worker);
        return workerList;  //return remaining list
    }

    //deletes an existing worker by id
    @DeleteMapping("worker/{id}")
    public List<TaskFriday> DeleteWorkerById(@PathVariable("id") int workerId) {
        workerList.remove(workerId);
        return workerList;
    }

}
