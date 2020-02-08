//package com.boylegu.springboot_vue.mapper;
//
//import java.util.List;
//
//import com.google.common.base.Function;
//import com.google.common.collect.Lists;
//
//public abstract class BaseSelmaMapper<D, V>
//{
//
//    public abstract D asDto(V source);
//
//    public abstract V asVO(D source);
//
//    /**
//     * Transform a list from VO to DTO
//     * @param vos
//     * @return
//     */
//    public List<D> asDtos(List<V> vos)
//    {
//        return Lists.transform(vos, new Function<V, D>()
//        {
//            @Override
//            public D apply(final V vo)
//            {
//                return asDto(vo);
//            }
//        });
//    }
//
//    /**
//     * Transform a list from DTO to VO
//     * @param dtos
//     * @return
//     */
//    public List<V> asVOs(List<D> dtos)
//    {
//        return Lists.transform(dtos, new Function<D, V>()
//        {
//            @Override
//            public V apply(final D dto)
//            {
//                return asVO(dto);
//            }
//        });
//    }
//}