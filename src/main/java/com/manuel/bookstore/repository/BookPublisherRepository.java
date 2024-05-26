package com.manuel.bookstore.repository;

import com.manuel.bookstore.entity.PublisherData;
import org.modelmapper.internal.asm.tree.IincInsnNode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookPublisherRepository extends JpaRepository<PublisherData, Long> {

    Optional<PublisherData> findPublisherDataByName(String publisherName);

}
