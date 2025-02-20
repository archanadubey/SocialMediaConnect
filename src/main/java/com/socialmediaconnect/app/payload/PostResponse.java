package com.socialmediaconnect.app.payload;


import com.socialmediaconnect.app.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponse {

 // original list of PostDto content along with the other fields.
    private List<PostDto> content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private boolean isLastPage;


}
