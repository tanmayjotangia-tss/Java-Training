package com.tss.hibernate.dto.page;

import com.tss.hibernate.dto.response.StudentResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentPageResponseDTO {

    private List<StudentResponseDTO> content;
    private int numberOfElements;
    private long totalElements;
    private int totalPages;
    private boolean first;
    private boolean last;

}
