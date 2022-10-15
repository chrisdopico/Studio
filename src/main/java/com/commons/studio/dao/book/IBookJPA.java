package com.commons.studio.dao.book;

import com.commons.studio.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookJPA extends JpaRepository<Book,Integer> {
}
