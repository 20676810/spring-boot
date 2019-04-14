package com.learn.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    //@Transactional(rollbackFor = Exception.class)
    @Transactional
    public  void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("F");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(28);
        girlB.setCupSize("DD");
        girlRepository.save(girlB);

    }
}
