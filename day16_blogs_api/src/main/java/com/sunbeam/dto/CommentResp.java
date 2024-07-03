package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResp extends BaseDTO {

	private String commentText;
	private int rating;
}
