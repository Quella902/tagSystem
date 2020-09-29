package com.ruoyi.tag.vo;

import java.util.List;
import lombok.Data;

/**
 * 树形结构数据封装对象
 * @author admin
 * @date 2020/9/16  15:32
 */
@Data
public class TreeVO<T>{

	private String label;
	private String id;
	private T data;
	private List<TreeVO<T>> children;
	
}
