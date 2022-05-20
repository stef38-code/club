package org.stephane.club.services.adherent;

import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Map;

@Service
public class BrandsService extends CustomGenericService<BrandsDto, Brands, String, String> {

    private final BrandsMapper mapper = Mappers.getMapper(BrandsMapper.class);

    @PersistenceContext
    private final EntityManager entityManager;

    public BrandsService(JpaRepository<Brands, String> repository, EntityManager entityManager) {
        super(repository, "브랜드");
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public SearchResponseDto search(Map<String, String> params) {

        BrandSearchDto dto = new BrandSearchDto(params);
        Pageable pageable = PageRequest.of(dto.getPageNo(), dto.getPageSize());

        StoredProcedureQuery sp =
                entityManager.createNamedStoredProcedureQuery(Brands.NamedQuery_GetBrandList);
        sp.setParameter("_pageNo", pageable.getPageNumber());
        sp.setParameter("_pageSize", pageable.getPageSize());
        sp.setParameter("_partnerId", dto.getPartnerId());
        sp.setParameter("_brandId", dto.getBrandId());
        sp.setParameter("_useyn", dto.getUseyn());
        sp.execute();

        @SuppressWarnings("unchecked")
        List<Object> results = toDto(sp.getResultList());
        int totalCount = (int) sp.getOutputParameterValue("RESULT");

        return new SearchResponseDto(results, pageable, totalCount);
    }

    @Override
    protected BrandsDto toDto(Brands brands) {
        return mapper.to(brands);
    }

    @Override
    protected Brands toEntity(BrandsDto e) {
        return mapper.to(e);
    }

    @Override
    protected String toKeyEntity(String e) {
        return e;
    }

    @Override
    protected void updateFromDto(BrandsDto dto, Brands brands) {
        mapper.updateFromDto(dto, brands);
    }

    @Override
    protected Brands newEntity() {
        return new Brands();
    }

    @Override
    protected Brands newEntity(String e) {
        return new Brands(e);
    }
}
