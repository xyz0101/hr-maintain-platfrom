package com.yuchai.maintain.evalmaintain.service.impl;

import com.yuchai.maintain.evalmaintain.entity.EvalDistQuota;
import com.yuchai.maintain.evalmaintain.mapper.EvalDistQuotaMapper;
import com.yuchai.maintain.evalmaintain.service.EvalDistQuotaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EvalDistQuotaServiceImpl implements EvalDistQuotaService {
    @Resource
    EvalDistQuotaMapper mapper;

    @Override
    public List<EvalDistQuota> getEvalDistQuotaByYear(String year) {
        return mapper.getEvalDistQuotaByYear(year);
    }

    @Override
    public void deleteEvalDistQuotaByYear(String year) {

    }

    @Override
    @Transactional
    public void addEvalDistQuotaWithYear(List<EvalDistQuota> distQuotaList,String year) {
        mapper.deleteEvalDistQuotaByYear(year);
        mapper.addEvalDistQuotaWithYear(distQuotaList);
    }

    @Override
    public void updateEvalDistQuotaWithYear(List<EvalDistQuota> distQuotaList) {
        mapper.updateEvalDistQuotaWithYear(distQuotaList);
    }
}
