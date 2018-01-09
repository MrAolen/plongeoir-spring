package com.reeliant.plongeoir.service;

import java.util.List;

public interface MetaDataService{
    String getMetaDataByKey(String key);

    void updateMetaData(String data, String key);
}
