package com.youcode.youbooking.service;

import com.youcode.youbooking.entity.Proprietary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprietaryService implements IService<Proprietary , Long> {
    @Override
    public Proprietary add(Proprietary proprietary) {
        return null;
    }

    @Override
    public boolean delete(Long i) {
        return false;
    }

    @Override
    public Proprietary findOneById(Long i) {
        return null;
    }

    @Override
    public Proprietary update(Proprietary proprietary) {
        return null;
    }

    @Override
    public List<Proprietary> findAll() {
        return null;
    }
}
