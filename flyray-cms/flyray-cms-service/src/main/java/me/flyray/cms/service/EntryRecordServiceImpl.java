package me.flyray.cms.service;

import org.springframework.stereotype.Service;

import me.flyray.cms.api.EntryRecordService;
import me.flyray.cms.model.EntryRecord;
import me.flyray.common.service.AbstractBaseService;

@Service("entryRecordService")
public class EntryRecordServiceImpl extends AbstractBaseService<EntryRecord> implements EntryRecordService{

}
