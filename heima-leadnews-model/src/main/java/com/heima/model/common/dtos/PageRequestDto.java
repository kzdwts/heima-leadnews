package com.heima.model.common.dtos;

import lombok.Data;

/**
 * 分页参数
 *
 * @author Kang Yong
 * @date 2024/4/19
 * @since 1.0.0
 */
@Data
public class PageRequestDto {

    protected Integer size;
    protected Integer page;

    public void checkParam() {
        if (this.page == null || this.page < 0) {
            setPage(1);
        }
        if (this.size == null || this.size < 0 || this.size > 100) {
            setSize(10);
        }
    }
}
