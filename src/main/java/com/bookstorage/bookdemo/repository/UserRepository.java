package com.bookstorage.bookdemo.repository;

import com.bookstorage.bookdemo.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

  @Modifying
  @Transactional
  @Query("delete from UserEntity u where u.id in(?1)")
  void deleteAllByIds(List<Long> userIds);
}
