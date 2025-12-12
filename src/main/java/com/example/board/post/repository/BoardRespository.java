package com.example.board.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.board.post.entity.Board;

import java.util.List;

public interface BoardRespository extends JpaRepository<Board, Long>, SearchBoardRepository {

  @Query("select b,m from Board b join b.writer m")
  List<Object[]> getBoardWithWriter();
}
