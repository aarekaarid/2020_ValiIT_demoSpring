package com.example.demoSpring.controller;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

//TASK6
@RequestMapping("test")
@RestController
public class TestController2 {
    @GetMapping("a/*/a/{a}/{b}/c")
    public void test1(@PathVariable("a") String a,   // {a} = pathVarA
                     @RequestParam("a") String aa,  //requestParA
                     @RequestParam("b") String bb,  //requestParB
                     @PathVariable("b") String b) { //{b} = pathVarB
    }
    // localhost:8080/test/a/smth/a/pathVarA/pathVarB/c?a=requestParA&b=requestParB

//TASK3
// GIVEN URL: /company/5/employee/8/contract/5
    @GetMapping("company/{id1}/employee/{id2}/contract/{id3}")
    public void task3(@PathVariable("id1") int id1,
                      @PathVariable("id2") int id2,
                      @PathVariable("id3") int id3) {

    }
//TASK4
// GIVEN URL:  /?employeeId=8&somthingElse=tere
    @GetMapping("/")
    public  void task4(@RequestParam("employeeId") int id1,             // value = 8
                       @RequestParam("somthingElse") String str1) {     // value = tere

    }

//TASK5:
// GIVEN URL:    /company/6?company=5&a=a&b=b
    @GetMapping("company/{id1}")
    public void task5(@PathVariable("id1") int id1,         // value = 6
                      @RequestParam("company") int comp,    // value = 5
                      @RequestParam("a") String a,          // value = a
                      @RequestParam("b") String b){         // value = b

    }

}
// * - all between two /.../
// ? - NB! comes after path
// PathVariables FIRST, then ? and RequestParam1 & RequestParam2



