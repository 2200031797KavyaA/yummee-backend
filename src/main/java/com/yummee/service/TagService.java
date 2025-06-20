package com.yummee.service;

import java.util.List;

import com.yummee.entity.Tag;

public interface TagService {
	
	Tag createTag(Tag tag);
    List<Tag> getAllTags();
    Tag getTagById(Long id);
    Tag updateTag(Long id, Tag tag);
    void deleteTag(Long id);
}