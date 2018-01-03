package com.reeliant.plongeoir.mapper;

import com.reeliant.plongeoir.dto.MetaDataDTO;
import com.reeliant.plongeoir.entity.MetaData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetaDataMapper{
    MetaDataDTO metaDataToMetaDataDTO(MetaData metaData);
    MetaData metaDataDTOToMetaData(MetaDataDTO metaData);
}
