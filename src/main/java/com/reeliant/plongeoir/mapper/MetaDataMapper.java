package com.reeliant.plongeoir.mapper;

import com.reeliant.plongeoir.dto.MetaDataDTO;
import com.reeliant.plongeoir.entity.MetaData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MetaDataMapper{

    MetaDataMapper INSTANCE = Mappers.getMapper(MetaDataMapper.class);

    MetaDataDTO metaDataToMetaDataDTO(MetaData metaData);
    MetaData metaDataDTOToMetaData(MetaDataDTO metaData);
}
