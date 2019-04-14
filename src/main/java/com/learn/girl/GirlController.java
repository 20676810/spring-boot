package com.learn.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private  GirlService girlService;

    //查询所有列表
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return  girlRepository.findAll();
    }

    //通过年龄来查询列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return  girlRepository.findByAge(age);
    }

    //新增
    @PostMapping(value="/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    //查询一条记录
    @GetMapping(value="/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
//        return girlRepository.findOne(id);
        return girlRepository.findById(id).orElse(null);
    }

    //更新
    @PutMapping (value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    //删除
    @DeleteMapping(value="/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
//        girlRepository.delete(id);
        girlRepository.deleteById(id);
    }

    //新增2个
    @RequestMapping(value="/girls/two")
    public  void girlAdd2(){
        girlService.insertTwo();
    }

}
