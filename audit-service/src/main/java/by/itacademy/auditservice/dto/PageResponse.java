package by.itacademy.auditservice.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageResponse<T> {

    private int number;
    private int size;
    private int total_pages;
    private long total_elements;
    private List<T> content;
    private boolean first;
    private int number_of_elements;
    private boolean last;

    public static <T> PageResponse<T> from(Page<T> page) {
        PageResponse<T> response = new PageResponse<>();
        response.setNumber(page.getNumber());
        response.setSize(page.getSize());
        response.setTotal_pages(page.getTotalPages());
        response.setTotal_elements(page.getTotalElements());
        response.setContent(page.getContent());
        response.setFirst(page.isFirst());
        response.setNumber_of_elements(page.getNumberOfElements());
        response.setLast(page.isLast());
        return response;
    }
}