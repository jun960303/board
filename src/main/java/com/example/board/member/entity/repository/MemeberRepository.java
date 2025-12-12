package com.example.board.member.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.member.entity.Member;

public interface MemeberRepository extends JpaRepository<Member, String> {

}
