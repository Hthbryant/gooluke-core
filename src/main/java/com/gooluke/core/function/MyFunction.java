package com.gooluke.core.function;

import com.gooluke.core.web.dto.Resp;
import io.github.hthbryant.gooluke.framework.biz.common.dto.BaseRequestDTO;

/**
 * @author 咕噜科
 * ClassName: MyFunction
 * date: 2023-10-30 23:24
 * Description:
 * version 1.0
 */
public interface MyFunction<E extends BaseRequestDTO> {

    Resp apply(E request);

}
