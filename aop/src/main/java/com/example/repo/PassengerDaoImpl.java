package com.example.repo;

import com.example.aspect.Log;
import com.example.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("passengerDao")
public class PassengerDaoImpl implements PassengerDao{
    private static Map<Integer, Passenger> pMap = new HashMap<>();

    @Override
    @Log
    public Passenger getPassenger(int id) {
        if( id<1 ) throw new RuntimeException("incorrect id");

        if(pMap.get(id)==null){
            Passenger p = new Passenger(id);
            return p;
        }

        return pMap.get(id);
    }
}
