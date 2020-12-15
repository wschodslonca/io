package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.Entities.ServiceTechEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchUserException;
import com.wypochodzik.Wypozyczalnia.Repositories.ServiceTechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTechServiceImpl implements ServiceTechService {

    private final ServiceTechRepository serviceTechRepository;

    @Autowired
    public ServiceTechServiceImpl(ServiceTechRepository serviceTechRepository) {
        this.serviceTechRepository = serviceTechRepository;
    }

    @Override
    public ServiceTechEntity getServiceTech(Long serviceTechId) throws NoSuchUserException {
        Optional<ServiceTechEntity> serviceTechEntityOptional = this.serviceTechRepository.findById(serviceTechId);
        if (serviceTechEntityOptional.isEmpty()){
            throw new NoSuchUserException();
        }
        return serviceTechEntityOptional.get();
    }

    @Override
    public List<ServiceTechEntity> getAllServiceTech() {
        return this.serviceTechRepository.findAll();
    }

    @Override
    public void deleteServiceTech(Long serviceTechId) {
        Optional<ServiceTechEntity> serviceTechEntityOptional = this.serviceTechRepository.findById(serviceTechId);
        if (serviceTechEntityOptional.isEmpty()){
            throw new NoSuchUserException();
        }
        else{
            ServiceTechEntity serviceTechEntity = serviceTechEntityOptional.get();
            this.serviceTechRepository.delete(serviceTechEntity);
        }
    }
}
