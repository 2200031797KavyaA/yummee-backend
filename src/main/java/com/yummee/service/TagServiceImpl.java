package com.yummee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummee.entity.Tag;
import com.yummee.repository.TagRepository;

@Service
public class TagServiceImpl implements TagService{

	@Autowired
    private TagRepository tagRepository;

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTagById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Tag updateTag(Long id, Tag tag) {
        Optional<Tag> existingTag = tagRepository.findById(id);
        if (existingTag.isPresent()) {
            Tag t = existingTag.get();
            t.setName(tag.getName());
            return tagRepository.save(t);
        }
        return null;
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}