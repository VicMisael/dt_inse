package com.dt.inse.application.service.utils;

import com.dt.inse.commons.QueryOrder;
import org.springframework.data.domain.Sort;

public final class QueryOrderToSpringOrderMapper {
    private QueryOrderToSpringOrderMapper() {
    }

    public static Sort.Direction Map(QueryOrder queryOrder) {
        return switch (queryOrder) {
            case Asc -> Sort.Direction.ASC;
            case Desc -> Sort.Direction.DESC;
        };
    }
}
