package com.buptsse.spm.service;

import com.buptsse.spm.domain.Code;

public interface ICodeService {
    Code getCodeByTypeAndCode(String codeType, String codeCode);
}
