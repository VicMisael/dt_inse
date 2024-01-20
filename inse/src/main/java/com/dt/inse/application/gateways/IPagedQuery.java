package com.dt.inse.application.gateways;

import com.dt.inse.application.DTO.InseQueryIn;
import com.dt.inse.application.DTO.InseQueryOut;
import com.dt.inse.domain.model.Inse;
import com.dt.inse.domain.pagination.Pagination;

public interface IPagedQuery {
    InseQueryOut QueryInse(InseQueryIn in);
}
