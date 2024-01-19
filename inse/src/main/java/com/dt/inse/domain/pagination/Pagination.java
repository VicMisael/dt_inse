package com.dt.inse.domain.pagination;

import java.util.List;

public record Pagination<T>(
        int page,
        int total,
        int perPage,
        List<T> items
) {
}
