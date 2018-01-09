package com.reeliant.plongeoir.service.impl;

import com.reeliant.plongeoir.entity.MetaData;
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
        MetaData metaData = metaDataRepository.findByKey(key);
        if (metaData == null) {
            return "";
        }
        return metaDataMapper.metaDataToMetaDataDTO(metaDataRepository.findByKey(key)).getValue();
    }

    @Override
    public void updateMetaData(String data, String key) {
        MetaData metaData = metaDataRepository.findByKey(key);
        metaData.setValue(data);
        metaDataRepository.save(metaData);
    }

}
