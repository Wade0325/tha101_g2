package tw.idv.petpet.web.member.service;

import java.util.List;

import tw.idv.petpet.core.service.CoreService;
import tw.idv.petpet.web.member.entity.Member;

public interface MemberService extends CoreService {

	Member register(Member member);

	Member login(Member member);

	Member edit(Member member);

	List<Member> findAll();

	boolean remove(Integer id);

	boolean save(Member member);
}