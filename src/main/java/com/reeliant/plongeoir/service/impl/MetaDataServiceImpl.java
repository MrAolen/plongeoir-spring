package com.reeliant.plongeoir.service.impl;

import com.reeliant.plongeoir.mapper.MetaDataMapper;
import com.reeliant.plongeoir.repository.MetaDataRepository;
import com.reeliant.plongeoir.service.MetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetaDataServiceImpl implements MetaDataService{

    @Autowired
    private MetaDataRepository metaDataRepository;

    @Autowired
    private MetaDataMapper metaDataMapper;

    @Override
    public String getMetaDataByKey(String key) {
        return metaDataMapper.metaDataToMetaDataDTO(metaDataRepository.findByKey(key)).getValue();
    }

    @Override
    public List<String> getOpeningHours() {
        List<String> openingHours = new ArrayList<>();
        openingHours.add(getMetaDataByKey("oh_monday"));
        openingHours.add(getMetaDataByKey("oh_tuesday"));
        openingHours.add(getMetaDataByKey("oh_wednesday"));
        openingHours.add(getMetaDataByKey("oh_thursday"));
        openingHours.add(getMetaDataByKey("oh_friday"));
        openingHours.add(getMetaDataByKey("oh_saturday"));
        openingHours.add(getMetaDataByKey("oh_sunday"));

        return openingHours;
    }
}
