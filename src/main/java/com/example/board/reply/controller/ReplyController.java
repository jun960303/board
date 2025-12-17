package com.example.board.reply.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.reply.dto.ReplyDTO;
import com.example.board.reply.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/replies")
@Log4j2
@RestController
@RequiredArgsConstructor
public class ReplyController {

  private final ReplyService replyServicevice;

  @DeleteMapping("/{rno}")
  public String deleteReply(@PathVariable Long rno) {
    log.info("삭제 요청 {}", rno);
    replyServicevice.delete(rno);
    return "success";
  }

  @PostMapping("/new")
  public Long postReply(@RequestBody ReplyDTO dto) {

    Long rno = replyServicevice.create(dto);
    return rno;
  }

  @PutMapping("/{rno}")
  public Long putReply(@RequestBody ReplyDTO dto) {

    Long rno = replyServicevice.update(dto);
    return rno;
  }

  @GetMapping("/board/{bno}")
  public List<ReplyDTO> getList(@PathVariable Long bno) {
    log.info("{} 댓글 요청", bno);
    return replyServicevice.getList(bno);
  }

  // rno를 요해서 특정 reply 가져오기
  @GetMapping("/{rno}")
  public ReplyDTO getRow(@PathVariable Long rno) {

    log.info("{} 댓글 요청", rno);
    return replyServicevice.getRow(rno);
  }

}
