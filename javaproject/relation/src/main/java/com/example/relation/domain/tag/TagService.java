package com.example.relation.domain.tag;

import com.example.relation.domain.tag.dto.TagResponseDto;
import com.example.relation.domain.tag.dto.Tag;
import com.example.relation.domain.tag.dto.TagRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    @Transactional
    public TagResponseDto createTag(TagRequestDto requestDto) {
        Tag tag = tagRepository.save(requestDto.toEntity());

        return TagResponseDto.from(tag);
    }

    public List<TagResponseDto> readTags() {
        return tagRepository.findAll().stream()
                .map(TagResponseDto::from).toList();
    }
}
